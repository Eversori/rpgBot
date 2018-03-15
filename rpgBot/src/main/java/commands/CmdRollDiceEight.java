package commands;


import java.util.Random;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import util.STATIC;


public class CmdRollDiceEight implements Command
{

	public boolean called(String[] args, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void action(String[] args, GuildMessageReceivedEvent e)
	{
		Random rn = new Random();
		int x = 0;
		x = rn.nextInt(8) + 1;

		String name = e.getMember().getEffectiveName();

		e.getChannel()
				.sendMessage(STATIC.OUTPUT
						.setDescription(":game_die: " + name + " rolls a 8 sided dice and gets a " + x).build())
				.queue();
		e.getMessage().delete().queue();
	}

	public void executed(boolean success, GuildMessageReceivedEvent e)
	{
		System.out.println("Command W8 executed");

	}

	public String help()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
