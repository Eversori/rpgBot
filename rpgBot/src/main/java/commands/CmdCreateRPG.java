package commands;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;
import net.dv8tion.jda.core.requests.restaction.ChannelAction;
import net.dv8tion.jda.core.requests.restaction.RoleAction;
import rpgBot.rpgBot.ListCollector;
import rpgBot.rpgBot.MemberTest;
import rpgBot.rpgBot.WriteInChat;
import rpgClasses.Tale;
import util.STATIC;

public class CmdCreateRPG implements Command
{

	private String				rpgName;

	private GuildController		gc;

	private Role				role;

	private List<Permission>	allowVC	= new ArrayList<Permission>();

	private List<Permission>	denyVC	= new ArrayList<Permission>();

	private List<Permission>	allowTC	= new ArrayList<Permission>();

	private List<Permission>	denyTC	= new ArrayList<Permission>();

	private WriteInChat			writer	= null;

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
			Guild guild = e.getGuild();
			gc = guild.getController();
			initialize();

			if (args.length == 1)
			{
				rpgName = args[0];
				createRPG(guild, e);
			}
			else
				if (args.length == 0)
				{
					System.out.println("Wrong format");
					writer.writeError("A roleplay without a name? That's boring! :confused:");
				}
				else
				{
					System.out.println("Wrong format");
					writer.writeError("Hey, hey! Slow down! The name of the RPG is enough! :unamused:");
				}
		}
		else
		{
			System.out.println("Permission denied");
			writer.writeError("Stop! You don't have the permissons to do this, I'm sorry :sweat:");
		}
	}

	public void executed(boolean success, GuildMessageReceivedEvent e)
	{
		System.out.println("Command startrpg executed");
	}

	public String help()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void initialize()
	{
		allowVC.add(Permission.VIEW_CHANNEL);
		allowVC.add(Permission.VOICE_CONNECT);
		allowVC.add(Permission.VOICE_SPEAK);

		denyVC.add(Permission.MANAGE_CHANNEL);
		denyVC.add(Permission.VOICE_MOVE_OTHERS);

		allowTC.add(Permission.VIEW_CHANNEL);
		allowTC.add(Permission.MESSAGE_READ);
		allowTC.add(Permission.MESSAGE_WRITE);
		allowTC.add(Permission.MESSAGE_ADD_REACTION);
		allowTC.add(Permission.MESSAGE_ATTACH_FILES);
		allowTC.add(Permission.MESSAGE_EMBED_LINKS);

		denyTC.add(Permission.MANAGE_CHANNEL);
		denyTC.add(Permission.MESSAGE_MANAGE);
	}

	private void createRPG(Guild g, GuildMessageReceivedEvent e)
	{
		if (!ListCollector.roleMap.containsKey(rpgName + "Role"))
		{
			if (rpgName.length() > 2)
			{
				try
				{
					String id = createRPGRole();
					if (!id.equals(""))
					{
						role = g.getRoleById(id);
						System.out.println("Role:" + role.getName());
						ListCollector.roleMap.put(role.getName(), role);

						String txtid = createTextChannel(g);
						String vcid = createVoiceChannel(g);
						if (!txtid.equals("") && !vcid.equals(""))
						{
							TextChannel txt = g.getTextChannelById(txtid);
							VoiceChannel vc = g.getVoiceChannelById(vcid);
							e.getMember().getRoles().add(role);
							addToRPG(e, txt, vc);
							writer.writeSuccess("The Roleplay " + rpgName + " was started by "
							        + e.getMessage().getAuthor().getAsMention());
						}
						else
						{
							System.out.println("TextChannelId or VoiceChannelId are empty");
							writer.writeError("Sorry, something didn't work please wait, I'm pinging "
							        + g.getOwner().getAsMention() + " :rage:");
						}

					}
					else
					{
						System.out.println("RoleId is empty");
						writer.writeError("Sorry, something didn't work please wait, I'm pinging "
						        + g.getOwner().getAsMention() + " :rage:");
					}

				}
				catch (Exception e1)
				{
					System.out.println(e1.getMessage());
				}
			}
			else
			{
				System.out.println("Name is to short");
				writer.writeError("Hey, isn't this name a bit short? :thinking: You should add some characters");

			}
		}
		else
		{
			System.out.println("Role already is exsisting");
			writer.writeError("This RPG is already existing :frowning:");
		}
	}

	private void addToRPG(GuildMessageReceivedEvent e, TextChannel txt, VoiceChannel vc)
	{
		/**
		 * TODO: Safe the new Tale in DB
		 */
		try
		{
			Tale tale = new Tale(e.getGuild());
			tale.setRole(role);
			tale.setStoryTeller(e.getMember());
			tale.setTaleName(rpgName);
			tale.setTxtChannel(txt);
			tale.setVcChannel(vc);
			ListCollector.taleList.put(txt, tale);
			tale.safeThisTale();
		}
		catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private String createRPGRole() throws Exception
	{
		String id = "";

		try
		{
			RoleAction act = gc.createRole();

			act.setName(rpgName + "Role");

			act.setColor(Color.GRAY);

			id = act.complete().getId();

			System.out.println("Role is created");
		}
		catch (Exception e)
		{
			System.out.println("An error has occured with creating role");
			throw e;
		}

		return id;
	}

	private String createTextChannel(Guild g) throws Exception
	{
		String id = "";
		try
		{
			ChannelAction act = gc.createTextChannel(rpgName);

			act.setParent(g.getCategoryById(STATIC.TCATID));

			act.addPermissionOverride(role, allowTC, denyTC);

			id = act.complete().getId();

			System.out.println("TxtChannel created");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("An error has occured with creating Channel");
		}
		return id;
	}

	private String createVoiceChannel(Guild g)
	{
		String id = "";
		try
		{
			ChannelAction act = gc.createVoiceChannel(rpgName + "VC");

			act.setParent(g.getCategoryById(STATIC.VCATID));

			act.addPermissionOverride(role, allowVC, denyVC);

			id = act.complete().getId();

			System.out.println("VChannel created");

		}
		catch (Exception e)
		{
			System.out.println("An error has occured with creating Channel");
		}
		return id;
	}
}
