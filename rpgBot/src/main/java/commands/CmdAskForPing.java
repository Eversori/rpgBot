package commands;


import java.awt.Color;
import java.util.List;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;


public class CmdAskForPing implements Command
{
	EmbedBuilder emp = new EmbedBuilder().setColor(Color.YELLOW);


	public boolean called(String[] args, MessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void action(String[] args, MessageReceivedEvent e)
	{
		List<Emote> eList = e.getGuild().getEmotesByName(":MordCool:", false);
		for (Emote emote : eList)
		{
			e.getTextChannel().addReactionById(e.getMessageId(), emote);
		}

		e.getTextChannel().sendMessage(emp.setDescription("Pong").build()).queue();

		e.getTextChannel()
				.sendMessage(emp.setDescription("Just Kidding: My Ping is " + e.getJDA().getPing() + "!").build())
				.queue();
	}

	public void executed(boolean success, MessageReceivedEvent e)
	{

		System.out.println("Command Ping executed");

	}

	public String help()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
