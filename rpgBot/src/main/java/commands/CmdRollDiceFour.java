package commands;


import java.util.Random;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import util.STATIC;


public class CmdRollDiceFour implements Command
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

		if (args.length == 1)
		{
			multiRoll(e, name, rn, args[0]);
		}
		else
		{
			singleRoll(e, name, rn);
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

	private void multiRoll(GuildMessageReceivedEvent e, String name, Random rn, String cStr)
	{
		int count = 0;
		int x = 0;
		try
		{
			count = Integer.parseInt(cStr);
		}
		catch (NumberFormatException ex)
		{
			e.getChannel()
					.sendMessage(
							STATIC.ERRORMSG.setDescription("You can't roll a dice " + cStr + ", idiot! :rage:").build())
					.queue();
		}

		for (int i = 0; i <= count; i++)
		{
			x = x + (rn.nextInt(4) + 1);
		}

		e.getChannel()
				.sendMessage(STATIC.OUTPUT
						.setDescription(
								":game_die: " + name + " rolls a 4 sided dice " + count + " times and gets " + x)
						.build())
				.queue();

		e.getMessage().delete().queue();
	}

	private void singleRoll(GuildMessageReceivedEvent e, String name, Random rn)
	{
		int x = 0;
		x = rn.nextInt(4) + 1;

		e.getChannel()
				.sendMessage(STATIC.OUTPUT
						.setDescription(":game_die: " + name + " rolls a 4 sided dice and gets a " + x).build())
				.queue();

		e.getMessage().delete().queue();
	}

}
