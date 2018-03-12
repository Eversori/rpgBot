package conversations;


import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;


public interface Conversation
{
	void action(String[] args, PrivateMessageReceivedEvent e);

}
