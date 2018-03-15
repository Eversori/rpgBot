package listeners;


import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReconnectedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import rpgBot.rpgBot.DataConnect;
import rpgBot.rpgBot.ListCollector;


public class ReconnectedListener extends ListenerAdapter
{
	public void onReconnect(ReconnectedEvent e)
	{
		System.out.println("Bot is Ready");
		for (Guild g : e.getJDA().getGuilds())
		{
			DataConnect.getOut();
			ListCollector.createAMapOfServer(g);
			DataConnect.openDB();
		}
	}
}
