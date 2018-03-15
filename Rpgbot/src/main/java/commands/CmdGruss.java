package commands;


import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.ForConversation;
import util.STATIC;


public class CmdGruss implements Command
{

	public boolean called(String[] args, MessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void action(String[] args, MessageReceivedEvent e)
	{
		User partner = e.getMessage().getAuthor();

		if ((partner == ForConversation.partner.get(e.getMessage().getTextChannel())))
		{
			e.getMessage().getTextChannel().sendMessage(STATIC.OUTPUT.setDescription("Hallo du da").build()).queue();
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
