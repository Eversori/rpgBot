package commands;


import java.util.function.Consumer;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;


public class CmdStartPrivateConv implements Command
{

	@Override
	public boolean called(String[] args, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void action(String[] args, GuildMessageReceivedEvent e)
	{
		User u = e.getMessage().getAuthor();

		u.openPrivateChannel().queue(new Consumer<PrivateChannel>()
		{

			@Override
			public void accept(PrivateChannel arg0)
			{
				arg0.sendMessage("Halölo").queue();
			}

		});
	}

	@Override
	public void executed(boolean success, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String help()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
