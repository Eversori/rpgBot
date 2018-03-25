package commands;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;
import rpgBot.rpgBot.ListCollector;
import rpgBot.rpgBot.MemberTest;
import rpgBot.rpgBot.WriteInChat;
import rpgClasses.Tale;

public class CmdAddGrpMembers implements Command
{
	private WriteInChat	writer	= null;

	private Tale		tale	= null;

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

				if (role != null)
				{
					ListCollector.taleList.forEach((n1, n2) ->
						{
							if (n2.getRole().getId().equals(role.getId()))
							{
								tale = n2;
							}
						});
					int i = 1;
					for (; i < args.length; i++)
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
					tale.setOrder(new String[tale.getNumberOfPlayers() - 1]);
					try
					{
						tale.safeNewParticipants();
					}
					catch (Exception e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("DB Exception");
						writer.writeError("Wait! I'll call " + e.getGuild().getOwner().getAsMention() + ":rage:");
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
			System.out.println("Member not in Guild");
			writer.writeError("I can´t find this guy :sweat:");
		}
	}

}
