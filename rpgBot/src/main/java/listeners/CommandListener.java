package listeners;


import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import rpgBot.rpgBot.CommandHandler;
import util.STATIC;


public class CommandListener extends ListenerAdapter
{
	public void onMessageReceived(MessageReceivedEvent event)
	{
		String raw = "";

		if (event.getMessage().getContent().startsWith(STATIC.PREFIX)
				&& event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()
				&& (event.getMessage().getTextChannel().getId().equals(STATIC.BOTCHANNELID)
						|| event.getMessage().getTextChannel().getId().equals(STATIC.GENBOTID)))
		{
			raw = event.getMessage().getContent();
			CommandHandler.handleCommand(CommandHandler.parse.parser(raw, event));
		}
	}
}
