package commands;

import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;
import rpgBot.rpgBot.ListCollector;
import rpgBot.rpgBot.MemberTest;
import rpgBot.rpgBot.WriteInChat;

public class CmdAddGrpMembers implements Command
{

	private EmbedBuilder	send	= new EmbedBuilder().setColor(Color.ORANGE);
	private WriteInChat		writer	= null;

	public boolean called(String[] args, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void action(String[] args, GuildMessageReceivedEvent e)
	{
		writer = new WriteInChat(e);
		if (MemberTest.isThisALeader(e.getMessage().getMember()))
		{
			if (args.length >= 2)
			{
				String name = args[0];

				Role role = ListCollector.roleMap.get(name);
				Member m = null;

				for (int i = 1; i < args.length; i++)
				{
					String membername = args[i];
					System.out.println(membername);

					if (ListCollector.memberMap.containsKey(membername))
					{
						m = ListCollector.memberMap.get(membername);
					}
					else
					{
						m = null;
					}

					addRoleToM(m, role, e);

				}

			}
			else
			{
				System.out.println("CommandException");
				writer.writeError("Hey, can you use the Syntax -startwith [role][name][name],.., please? :smiley:");
			}
		}
		else
		{
			writer.writeError("Stop! You don't have the permissons to do this, I'm sorry :sweat:");
		}

	}

	public void executed(boolean success, GuildMessageReceivedEvent e)
	{
		System.out.println("Command startwith executed");

	}

	public String help()
	{
		// TODO Auto-generated method stub
		return null;
	}

	private void addRoleToM(Member m, Role r, GuildMessageReceivedEvent e)
	{
		if (m != null)
		{
			if (r != null)
			{
				if (!m.getRoles().contains(r))
				{
					GuildController gc = e.getGuild().getController();
					try
					{
						gc.addSingleRoleToMember(m, r).queue();
						System.out.println(m.getEffectiveName() + " is joining " + r.getName());

						writer.writeSuccess(m.getEffectiveName() + " has now joined " + r.getName() + "! :grin:");
					}
					catch (Exception e1)
					{
						System.out.println(e1.getMessage());
						writer.writeError("Give me more rights! :sunglasses:");
					}
				}
				else
				{
					writer.writeError(m.getEffectiveName() + " already has this role! :weary:");
				}
			}
			else
			{
				System.out.println("Role not in List");
				writer.writeError("I´m sorry I cannot find this role");
			}
		}
		else
		{
			System.out.println("Member not in Guild");
			writer.writeError("I can´t find this guy :sweat:");
		}
	}

}
