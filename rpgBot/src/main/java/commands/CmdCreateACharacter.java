package commands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import rpgBot.rpgBot.ListCollector;
import rpgBot.rpgBot.MemberTest;
import rpgBot.rpgBot.WriteInChat;
import rpgClasses.Job;
import rpgClasses.PlayerCharacter;
import rpgClasses.Race;
import rpgClasses.Tale;

public class CmdCreateACharacter implements Command
{
	/**
	 * TODO: DB connections not working
	 */
	// Command -createCharacter
	// name, race, age, start-class
	PlayerCharacter	pchara;
	WriteInChat		writer	= null;

	@Override
	public boolean called(String[] args, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void action(String[] args, GuildMessageReceivedEvent e)
	{
		writer = new WriteInChat(e);
		if (args.length == 4)
		{
			if (!MemberTest.memberHasCharacter(e.getMessage().getMember(), e.getMessage().getTextChannel()))
			{
				if (!ListCollector.characterList.containsKey(args[0]))
				{
					if (ListCollector.raceList.containsKey(args[1]) && ListCollector.classList.containsKey(args[3]))
					{

						createACharacter(e, args);

					}
					else
					{
						System.out.println("This is not a race or this is not a class");
						writer.writeError(
						        "You should maybe look up the classes and races, which are available :thinking:");
					}
				}
				else
				{
					System.out.println("Name already in Use");
					writer.writeError("I´m sorry. Your chosen name is already in use right now :sweat:");
				}
			}
			else
			{
				System.out.println("Player already has Character");
				writer.writeError("You can only have one character in this RPG. :angry:");
			}
		}
		else
		{
			System.out.println("Wrong Command Layout");
			writer.writeError(
			        "You should use the command-layout: -createCharacter [name] [race] [age] [beginner-class]. :weary:");
		}
	}

	@Override
	public void executed(boolean success, GuildMessageReceivedEvent event)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String help()
	{
		// TODO Auto-generated method stub
		return null;
	}

	private void createACharacter(GuildMessageReceivedEvent e, String[] args)
	{
		int age = 0;
		Race race = ListCollector.raceList.get(args[1]);
		Job job = ListCollector.classList.get(args[3]);
		Tale tale = ListCollector.taleList.get(e.getChannel());
		try
		{
			age = Integer.valueOf(args[2]).intValue();
		}
		catch (NumberFormatException e1)
		{
			System.out.println("This not a number");
		}
		if (race.isPlayable() && job.getTier() == 0)
		{
			if (race.getMaxAge() >= age || race.getMinAge() <= age)
			{
				try
				{
					pchara = new PlayerCharacter();
					pchara.setCreator(e.getMessage().getMember());
					pchara.setOwnStory(tale);
					pchara.setName(args[0]);
					pchara.setMainJob(job);
					pchara.setOwnRace(race);
					pchara.setAge(age);
					pchara.calcStats();
					pchara.addAbilities();
					pchara.createStartInventory();
					ListCollector.characterList.put(pchara.getName(), pchara);
					pchara.getOwnStory().getChara().put(pchara.getName(), pchara);
					pchara.safeCharacter();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
					System.out.println("DB has a problem");
					writer.writeError("Wait! I`ll call " + e.getGuild().getOwner().getAsMention() + "! :rage:");
				}
			}
			else
			{
				System.out.println("The Character cannot have this Age");
				writer.writeError("You should give your character a proper age. :wink:");
			}
		}
		else
		{
			System.out.println("The race is not playable and/or the class is not a start-class");
		}
	}

}
