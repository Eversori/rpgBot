package commands;


import net.dv8tion.jda.core.events.message.MessageReceivedEvent;


public class CmdTestConvers implements Command
{

	public boolean called(String[] args, MessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void action(String[] args, MessageReceivedEvent e)
	{
		util.ForConversation.partner.put(e.getMessage().getTextChannel(), e.getMessage().getAuthor());
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
