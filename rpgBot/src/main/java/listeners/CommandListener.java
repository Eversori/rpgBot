package listeners;


import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import rpgBot.rpgBot.CommandHandler;
import rpgBot.rpgBot.ListCollector;
import util.STATIC;


public class CommandListener extends ListenerAdapter
{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event)
	{
		String raw = "";
		TextChannel channel = event.getMessage().getTextChannel();

		// does the Message has the right beginning char
		// the sender is not the bot itself
		// the sender does not have the role guest
		// the message was send in Botting/ rpgBot_Listens_here/Cat for rpg Textchannel

		if (event.getMessage().getContent().startsWith(STATIC.PREFIX)
				&& event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()
				&& !event.getMessage().getMember().getRoles().contains(ListCollector.roleMap.get("~Guest"))
				&& (channel.getId().equals(STATIC.BOTCHANNELID) || channel.getId().equals(STATIC.GENBOTID)
						|| channel.getParent().getId().equals(STATIC.TCATID)))
		{
			raw = event.getMessage().getContent();
			CommandHandler.handleCommand(CommandHandler.parse.parser(raw, event));
		}
	}
}
