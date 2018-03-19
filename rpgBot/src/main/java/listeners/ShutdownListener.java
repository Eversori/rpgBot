package listeners;


import net.dv8tion.jda.core.events.ShutdownEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import rpgBot.rpgBot.DataConnect;


public class ShutdownListener extends ListenerAdapter
{
	public void onShutdown(ShutdownEvent e)
	{
		DataConnect.closeDB();
	}
}
