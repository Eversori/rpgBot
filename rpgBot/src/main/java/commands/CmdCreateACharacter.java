package commands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class CmdCreateACharacter implements Command
{
	// Command -createCharacter
	// name, race, age, start-class
	
	@Override
	public boolean called(String[] args, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void action(String[] args, GuildMessageReceivedEvent e)
	{
		
	}

	@Override
	public void executed(boolean success, GuildMessageReceivedEvent event)
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
