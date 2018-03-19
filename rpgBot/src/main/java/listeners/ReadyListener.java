package listeners;


import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import rpgBot.rpgBot.DataConnect;
import rpgBot.rpgBot.ListCollector;


public class ReadyListener extends ListenerAdapter
{
	public void onReady(ReadyEvent e)
	{
		System.out.println("Bot is Ready");
		for (Guild g : e.getJDA().getGuilds())
		{
			ListCollector.createAMapOfServer(g);
			DataConnect.openDB();
		}
	}
}
