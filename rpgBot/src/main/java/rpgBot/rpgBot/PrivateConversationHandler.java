package rpgBot.rpgBot;


import java.util.HashMap;
import conversations.Conversation;


public class PrivateConversationHandler
{
	public static HashMap<String, Conversation> convs = new HashMap<String, Conversation>();

	public static final PrivateConversationParser parser = new PrivateConversationParser();


	public static void handlePrivateConversation(PrivateConversationParser.conversationContainer con)
	{
		if (convs.containsKey(con.invoke))
		{
			System.out.println(con.invoke);
			convs.get(con.invoke).action(con.args, con.event);
		}
		else
		{
			System.out.println("Not in the table");
		}
	}
}
