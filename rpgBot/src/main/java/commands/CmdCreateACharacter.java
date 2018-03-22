package commands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import rpgBot.rpgBot.ListCollector;
import rpgBot.rpgBot.MemberTest;
import rpgClasses.Job;
import rpgClasses.PlayerCharacter;
import rpgClasses.Race;

public class CmdCreateACharacter implements Command
{
	// Command -createCharacter
	// name, race, age, start-class
	PlayerCharacter pchara;

	@Override
	public boolean called(String[] args, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void action(String[] args, GuildMessageReceivedEvent e)
	{
		if (args.length == 4)
		{
			if (MemberTest.memberHasCharacter(e.getMessage().getMember(), e.getMessage().getTextChannel()))
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
					}
				}
				else
				{
					System.out.println("Name already in Use");
				}
			}
			else
			{
				System.out.println("Player already has Character");
			}
		}
		else
		{
			System.out.println("Wrong Command Layout");
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
					pchara.setName(args[0]);
					pchara.setMainJob(job);
					pchara.setOwnRace(race);
					pchara.setAge(age);
					pchara.calcStats();
					pchara.addAbilities();
					pchara.createStartInventory();
					ListCollector.characterList.put(pchara.getName(), pchara);
					pchara.safeCharacter();
				}
				catch (Exception e1)
				{
					System.out.println("DB has a problem");
				}
			}
			else
			{
				System.out.println("The Character cannot have this Age");
			}
		}
		else
		{
			System.out.println("The race is not playable and/or the class is not a start-class");
		}
	}

}
