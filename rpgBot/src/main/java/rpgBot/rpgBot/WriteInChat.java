package rpgBot.rpgBot;

import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class WriteInChat
{
	private GuildMessageReceivedEvent	event			= null;
	private TextChannel					channel			= null;
	private Color						errorColor		= Color.RED;
	private Color						successColor	= Color.GREEN;
	private Color						infoColor		= Color.ORANGE;

	public WriteInChat(GuildMessageReceivedEvent event)
	{
		this.setEvent(event);
		this.setChannel(getEvent().getMessage().getTextChannel());
	}

	public WriteInChat(TextChannel channel)
	{
		this.setChannel(channel);
	}

	public void writeSuccess(String out)
	{
		EmbedBuilder output = new EmbedBuilder().setColor(successColor);
		output.setDescription(out);
		channel.sendMessage(output.build()).queue();
	}

	public void writeError(String out)
	{
		EmbedBuilder output = new EmbedBuilder().setColor(errorColor);
		output.setDescription(out);
		channel.sendMessage(output.build()).queue();
	}

	public void writeInfo(String out)
	{
		EmbedBuilder output = new EmbedBuilder().setColor(infoColor);
		output.setDescription(out);
		channel.sendMessage(output.build()).queue();
	}

	private GuildMessageReceivedEvent getEvent()
	{
		return event;
	}

	private void setEvent(GuildMessageReceivedEvent event)
	{
		this.event = event;
	}

	private TextChannel getChannel()
	{
		return channel;
	}

	public void setChannel(TextChannel channel)
	{
		this.channel = channel;
	}

	public Color getErrorColor()
	{
		return errorColor;
	}

	public void setErrorColor(Color errorColor)
	{
		this.errorColor = errorColor;
	}

	public Color getSuccessColor()
	{
		return successColor;
	}

	public void setSuccessColor(Color successColor)
	{
		this.successColor = successColor;
	}

	public Color getInfoColor()
	{
		return infoColor;
	}

	public void setInfoColor(Color infoColor)
	{
		this.infoColor = infoColor;
	}
}
