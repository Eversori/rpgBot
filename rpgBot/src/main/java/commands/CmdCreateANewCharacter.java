package commands;


import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rpgBot.rpgBot.MemberTest;


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
		if (args.length < 3)
		{
			System.out.println("Wrong format: To View");
		}
		else if (args.length == 3)
		{
			// Does the Member already have a character in that group
			if (!MemberTest.memberHasCharacter(e.getMessage().getMember(), e.getMessage().getTextChannel()))
			{

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

}
