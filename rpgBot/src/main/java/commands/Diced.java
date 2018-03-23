package commands;

import java.util.Random;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

interface Diced
{
	public abstract void singleRoll(GuildMessageReceivedEvent e, String name, Random rn);

	public abstract void multiRoll(GuildMessageReceivedEvent e, String name, Random rn, String cStr);
}
