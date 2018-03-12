package listeners;


import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import rpgBot.rpgBot.PrivateConversationHandler;


public class PrivateConversationListener extends ListenerAdapter
{
	public void onPrivateMessagReceived(PrivateMessageReceivedEvent e)
	{
		String raw = "";
		raw = e.getMessage().getContent();
		PrivateConversationHandler.handlePrivateConversation(PrivateConversationHandler.parser.parser(raw, e));
	}
}
