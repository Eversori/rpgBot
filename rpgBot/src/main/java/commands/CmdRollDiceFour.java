package commands;

import java.util.Random;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import rpgBot.rpgBot.WriteInChat;

public class CmdRollDiceFour implements Command
{
	private WriteInChat writer = null;

	public boolean called(String[] args, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void action(String[] args, GuildMessageReceivedEvent e)
	{
		writer = new WriteInChat(e);
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
			writer.writeError("This is not a number");
		}

		for (int i = 0; i <= count; i++)
		{
			x = x + (rn.nextInt(4) + 1);
		}

		writer.writeInfo(":game_die: " + name + " rolls a 4 sided dice " + count + " times and gets " + x);
		e.getMessage().delete().queue();
	}

	private void singleRoll(GuildMessageReceivedEvent e, String name, Random rn)
	{
		int x = 0;
		x = rn.nextInt(4) + 1;

		writer.writeInfo(":game_die: " + name + " rolls a 4 sided dice and gets a " + x);
		e.getMessage().delete().queue();
	}

}
