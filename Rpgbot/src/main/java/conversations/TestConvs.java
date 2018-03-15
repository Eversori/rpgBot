package conversations;


import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;


public class TestConvs implements Conversation
{

	@Override
	public void action(String[] args, PrivateMessageReceivedEvent e)
	{
		e.getMessage().getPrivateChannel().sendMessage("Thank you " + args).queue();
	}

}
