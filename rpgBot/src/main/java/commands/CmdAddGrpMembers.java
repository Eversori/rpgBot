package commands;


import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;
import rpgBot.rpgBot.DataConnect;
import rpgBot.rpgBot.ListCollector;
import rpgBot.rpgBot.MemberTest;
import util.STATIC;


public class CmdAddGrpMembers implements Command
{

	EmbedBuilder send = new EmbedBuilder().setColor(Color.ORANGE);


	public boolean called(String[] args, GuildMessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void action(String[] args, GuildMessageReceivedEvent e)
	{
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
				DataConnect.writeDoc("CommandException");
				e.getChannel()
						.sendMessage(STATIC.ERRORMSG.setDescription(
								"Hey, can you use the Syntax -startwith [role][name][name],.., please? :smiley:")
								.build())
						.queue();
			}
		}
		else
		{
			e.getChannel().sendMessage(STATIC.ERRORMSG
					.setDescription("Stop! You don't have the permissons to do this, I'm sorry :sweat:").build())
					.queue();
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
						e.getChannel()
								.sendMessage(send
										.setDescription(
												m.getEffectiveName() + " has now joined " + r.getName() + "! :grin:")
										.build())
								.queue();
					}
					catch (Exception e1)
					{
						System.out.println(e1.getMessage());
						e.getChannel()
								.sendMessage(
										STATIC.ERRORMSG.setDescription("Give me more rights! :sunglasses:").build())
								.queue();
					}
				}
				else
				{
					e.getChannel()
							.sendMessage(STATIC.ERRORMSG
									.setDescription(m.getEffectiveName() + " already has this role! :weary:").build())
							.queue();
				}
			}
			else
			{
				System.out.println("Role not in List");
				e.getChannel().sendMessage(STATIC.ERRORMSG.setDescription("I´m sorry I cannot find this role").build())
						.queue();
			}
		}
		else
		{
			System.out.println("Member not in Guild");
			e.getChannel().sendMessage(STATIC.ERRORMSG.setDescription("I can´t find this guy :sweat:").build()).queue();
		}
	}

}
