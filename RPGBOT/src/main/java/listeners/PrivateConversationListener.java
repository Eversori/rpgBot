package listeners;


import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import rpgBot.rpgBot.PrivateConversationHandler;
import util.STATIC;


public class PrivateConversationListener extends ListenerAdapter
{
	public void onPrivateMessagReceived(PrivateMessageReceivedEvent e)
	{
		String raw = "";

		if (e.getMessage().getContentDisplay().startsWith(STATIC.PREFIXCON)
				&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId())
		{
			raw = e.getMessage().getContentDisplay();
			System.out.println(e.getMessage());
			PrivateConversationHandler.handlePrivateConversation(PrivateConversationHandler.parser.parser(raw, e));
		}
	}
}
