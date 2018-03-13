package commands;


import java.util.Random;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import util.STATIC;


public class CmdRollDiceHundred implements Command
{

	public boolean called(String[] args, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void action(String[] args, GuildMessageReceivedEvent e)
	{
		Random rn = new Random();

		String name = e.getMember().getEffectiveName();

		singleRoll(e, name, rn);

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

	private void singleRoll(GuildMessageReceivedEvent e, String name, Random rn)
	{
		int x = 0;
		x = rn.nextInt(100) + 1;

		e.getChannel()
				.sendMessage(STATIC.OUTPUT
						.setDescription(":game_die: " + name + " rolls a 100 sided dice and gets a " + x).build())
				.queue();

		e.getMessage().delete().queue();

	}
}
