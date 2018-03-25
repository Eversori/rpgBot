package commands;

import java.util.ArrayList;
import java.util.Collections;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import rpgBot.rpgBot.ListCollector;
import rpgBot.rpgBot.MemberTest;
import rpgBot.rpgBot.WriteInChat;
import rpgClasses.RPGCharacter;
import rpgClasses.Tale;
import util.ForConversation;

public class CmdStartTheRPG implements Command
{
	// Command: -go
	// Finds the order of the player turns
	// Player are getting partners each after this order

	private WriteInChat writer = null;

	@Override
	public boolean called(String[] args, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void action(String[] args, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		writer = new WriteInChat(e);

		if (MemberTest.isThisALeader(e.getMessage().getMember()))
		{
			Tale tale = ListCollector.taleList.get(e.getChannel());
			ArrayList<RPGCharacter> cL = new ArrayList<>();
			cL.addAll(tale.getChara().values());
			Collections.sort(cL, (n1, n2) -> n1.getStats().get("MP").compareTo(n2.getStats().get("MP")));
			cL.forEach((n1) ->
				{
					int i = 0;
					tale.getOrder()[i] = n1.getName();
					i++;
				});
			ForConversation.partner.put(e.getChannel(), tale.getChara().get(tale.getOrder()[0]).getCreator().getUser());
			tale.setInConversation(true);
			writer.writeSuccess("Your RPG " + tale.getTaleName() + "was started successfully! :smirk:");
			writer.writeInfo(ForConversation.partner.get(e.getChannel()).getAsMention()
			        + ", you are the Fastest. You may start your turn now! :slight_smile:");
		}
		else
		{
			System.out.println("Member can´t use this command");
			writer.writeError("I'm sorry, but I see, you don't have the permissions to use this Command :sweat:");
		}
	}

	@Override
	public void executed(boolean success, GuildMessageReceivedEvent event)
	{
		// TODO Auto-generated method stub
		System.out.println("Command -go executed");
	}

	@Override
	public String help()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
