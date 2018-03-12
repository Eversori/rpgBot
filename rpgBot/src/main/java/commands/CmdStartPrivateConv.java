package commands;


import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;


public class CmdStartPrivateConv implements Command
{

	@Override
	public boolean called(String[] args, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void action(String[] args, GuildMessageReceivedEvent e)
	{
		e.getMessage().getAuthor().openPrivateChannel().queue((arg0) -> arg0.sendMessage("Hallo").queue());
	}

	@Override
	public void executed(boolean success, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String help()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
