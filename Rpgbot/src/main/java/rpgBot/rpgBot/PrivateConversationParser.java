package rpgBot.rpgBot;


import java.util.ArrayList;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import util.STATIC;


public class PrivateConversationParser
{
	public conversationContainer parser(String raw, PrivateMessageReceivedEvent event)
	{
		String beheaded = raw.replaceFirst(STATIC.PREFIXCON, "");

		String beheadedSplit[] = beheaded.split("+");

		String invoke = beheadedSplit[0];

		ArrayList<String> split = new ArrayList<String>();

		for (String s : beheadedSplit)
		{
			split.add(s);
		}

		String args[] = new String[split.size() - 1];

		split.subList(1, split.size()).toArray(args);

		return new conversationContainer(raw, beheaded, beheadedSplit, invoke, args, event);
	}


	public static class conversationContainer
	{

		public final String raw;

		public final String beheaded;

		public final String[] splitBeheaded;

		public final String invoke;

		public final String[] args;

		public final PrivateMessageReceivedEvent event;


		public conversationContainer(String rw, String beheaded, String[] splitBeheaded, String invoke, String[] args,
				PrivateMessageReceivedEvent event)
		{
			this.raw = rw;
			this.beheaded = beheaded;
			this.splitBeheaded = splitBeheaded;
			this.invoke = invoke;
			this.args = args;
			this.event = event;
		}

	}
}
