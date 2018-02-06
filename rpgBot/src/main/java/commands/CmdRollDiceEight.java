package commands;


import java.util.Random;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;


public class CmdRollDiceEight implements Command
{

	public boolean called(String[] args, MessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void action(String[] args, MessageReceivedEvent e)
	{
		Random rn = new Random();
		int x = 0;
		x = rn.nextInt(8) + 1;

		String name = e.getMember().getEffectiveName();

		e.getTextChannel()
				.sendMessage(STATIC.OUTPUT
						.setDescription(":game_die: " + name + " rolls a 8 sided dice and gets a " + x).build())
				.queue();
		e.getMessage().delete().queue();
	}

	public void executed(boolean success, MessageReceivedEvent e)
	{
		System.out.println("Command W8 executed");

	}

	public String help()
	{
		// TODO Auto-generated method stub
		return null;
	}
}