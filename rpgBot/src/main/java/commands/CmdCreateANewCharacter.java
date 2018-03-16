package commands;


import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import rpgBot.rpgBot.ListCollector;
import rpgBot.rpgBot.MemberTest;
import rpgClasses.PlayerCharacter;


public class CmdCreateANewCharacter implements Command
{

	public boolean called(String[] args, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void action(String[] args, GuildMessageReceivedEvent e)
	{
		// Befehl-args: Name, Rasse, Start-Job
		Member creator = e.getMessage().getMember();
		TextChannel grChannel = e.getMessage().getTextChannel();

		if (args.length < 3)
		{
			System.out.println("Wrong format: To View");
		}
		else if (args.length == 3)
		{
			// Does the Member already have a character in that group
			if (!MemberTest.memberHasCharacter(creator, grChannel))
			{
				createACharacter(args, creator, grChannel);
			}
			else
			{
				System.out.println("Member already has Character");
			}
		}
		else
		{
			System.out.println("Wrong format: To Much");
		}
	}

	public void executed(boolean success, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub

	}

	public String help()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void createACharacter(String args[], Member m, TextChannel txt)
	{
		boolean isPossible = false;

		isPossible = isRaceHere(args[1]);
		isPossible = isJobHere(args[2]);
		isPossible = isCharacterNameTakeable(args[0]);

		if (isPossible)
		{
			PlayerCharacter c = new PlayerCharacter();

			ListCollector.characterList.add(c);
		}
		else
		{
			System.out.println("Some Input is false");
		}

	}

	private boolean isRaceHere(String racename) // is the race possible
	{
		return false;
	}

	private boolean isJobHere(String jobname) // is the job possible
	{
		return false;
	}

	private boolean isCharacterNameTakeable(String name) // is the charactername available
	{
		// TODO: Überarbeiten dieser Methode
		return true;
	}

}
