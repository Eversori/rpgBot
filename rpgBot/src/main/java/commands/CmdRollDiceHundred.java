package commands;


import java.util.Random;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;


public class CmdRollDiceHundred implements Command
{

	public boolean called(String[] args, MessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void action(String[] args, MessageReceivedEvent e)
	{
		Random rn = new Random();

		String name = e.getMember().getEffectiveName();

		singleRoll(e, name, rn);

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

	private void singleRoll(MessageReceivedEvent e, String name, Random rn)
	{
		int x = 0;
		x = rn.nextInt(100) + 1;

		e.getTextChannel()
				.sendMessage(STATIC.OUTPUT
						.setDescription(":game_die: " + name + " rolls a 100 sided dice and gets a " + x).build())
				.queue();

		e.getMessage().delete().queue();

	}
}
