package commands;


import java.util.Iterator;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rpgBot.rpgBot.ListCollector;
import rpgBot.rpgBot.MemberTest;
import rpgBot.rpgBot.RPGCharacter;
import rpgBot.rpgBot.RPGgroup;


public class CmdCreateANewCharacter implements Command
{

	public boolean called(String[] args, MessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void action(String[] args, MessageReceivedEvent e)
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

	public void executed(boolean success, MessageReceivedEvent e)
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
			RPGCharacter c = new RPGCharacter();
			c.setName(args[0]);
			c.setCreator(m);
			c.setGroup(myGroup(txt));
			c.setJob(args[2]);
			c.setRace(args[1]);
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
		boolean isAvailable = false;
		for (Iterator<RPGCharacter> iChar = ListCollector.characterList.iterator(); iChar.hasNext();)
		{
			RPGCharacter rpgc = iChar.next();
			if (rpgc.getName().equals(name))
			{
				isAvailable = false;
				break;
			}
			else
			{
				isAvailable = true;
			}
		}

		if (!isAvailable)
		{
			System.out.println("Name not avaiabale");
		}
		return isAvailable;
	}

	private RPGgroup myGroup(TextChannel txt)
	{
		RPGgroup group = null;

		for (Iterator<RPGgroup> iGrp = ListCollector.rpggroupList.iterator(); iGrp.hasNext();)
		{
			group = iGrp.next();
			if (group.getTxtchannel() == txt)
			{
				break;
			}
		}

		return group;
	}

}
