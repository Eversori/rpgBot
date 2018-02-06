package commands;


import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rpgBot.rpgBot.DataConnect;
import rpgBot.rpgBot.ListCollector;
import rpgBot.rpgBot.RPGCharacter;
import util.STATIC;


//Muss noch mal neu aufgezogen/implementiert werden

public class CmdCreateACharakter implements Command
{
	EmbedBuilder outage = new EmbedBuilder().setColor(Color.ORANGE);


	public boolean called(String[] args, MessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void action(String[] args, MessageReceivedEvent e)
	{
		RPGCharacter c = new RPGCharacter();

		if (e.getTextChannel().getParent().equals(e.getGuild().getCategoryById(STATIC.TCATID)))
		{
			if (args.length < 3 || args.length > 3)
			{
				try
				{
					buildCharacter(c, args, e);
				}
				catch (Exception e1)
				{
					e.getTextChannel()
							.sendMessage(
									STATIC.ERRORMSG.setDescription("Name, Race and Class, can´t be a number").build())
							.queue();
					System.out.println(e.getMessage());
				}

				ListCollector.characterList.add(c);

				e.getTextChannel()
						.sendMessage(
								outage.setDescription("I have finished Creating your Character " + c.getName()).build())
						.queue();
				e.getTextChannel().sendMessage(
						outage.setDescription("To see your Characters stats use the Command showStats [Charactername]")
								.build())
						.queue();
			}
			else
			{
				e.getTextChannel().sendMessage(
						STATIC.ERRORMSG.setDescription("Please take format createC [Name][Race][Class]").build())
						.queue();
				System.out.println("Command false");
			}
		}
		else
		{
			System.out.println("Wrong Channel");
		}

	}

	public void executed(boolean success, MessageReceivedEvent e)
	{
		System.out.println("Command createC executed");

	}

	public String help()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void buildCharacter(RPGCharacter c, String[] args, MessageReceivedEvent e)
	{
		c.setName(args[0]);
		c.setRace(args[1]);
		c.setJob(args[2]);
		c.setCreator(e.getAuthor());
		c.setGroup(DataConnect.giveGroup(e.getTextChannel().getName()));
		c.setStats(RPGCharacter.randomStats());
	}

}
