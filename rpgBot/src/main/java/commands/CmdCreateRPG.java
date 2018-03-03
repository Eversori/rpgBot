package commands;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import RPGClasses.RPGgroup;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;
import net.dv8tion.jda.core.requests.restaction.ChannelAction;
import net.dv8tion.jda.core.requests.restaction.RoleAction;
import rpgBot.rpgBot.ListCollector;
import rpgBot.rpgBot.MemberTest;
import util.STATIC;


//TODO Ausgaben im Discord fertigen

public class CmdCreateRPG implements Command
{

	private String rpgName;

	private RPGgroup rpg;

	private GuildController gc;

	private Role role;

	private List<Permission> allowVC = new ArrayList<Permission>();

	private List<Permission> denyVC = new ArrayList<Permission>();

	private List<Permission> allowTC = new ArrayList<Permission>();

	private List<Permission> denyTC = new ArrayList<Permission>();


	public boolean called(String[] args, MessageReceivedEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void action(String[] args, MessageReceivedEvent e)
	{
		if (MemberTest.isThisALeader(e.getMessage().getMember()))
		{
			Guild guild = e.getGuild();
			rpg = new RPGgroup(guild);
			gc = guild.getController();
			initialize();
			if (args.length == 1)
			{
				rpgName = args[0];
				createRPG(guild, e);
			}
			else if (args.length == 0)
			{
				System.out.println("Wrong format");
				e.getTextChannel()
						.sendMessage(STATIC.ERRORMSG
								.setDescription("A roleplay without a name? That's boring! :confused:").build())
						.queue();
			}
			else
			{
				System.out.println("Wrong format");
				e.getTextChannel().sendMessage(STATIC.ERRORMSG
						.setDescription("Hey, hey! Slow down! The name of the RPG is enough! :unamused:").build())
						.queue();
			}
		}
		else
		{
			e.getTextChannel().sendMessage(STATIC.ERRORMSG
					.setDescription("Stop! You don't have the permissons to do this, I'm sorry :sweat:").build())
					.queue();
		}
	}

	public void executed(boolean success, MessageReceivedEvent e)
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

	private void createRPG(Guild g, MessageReceivedEvent e)
	{
		if (!ListCollector.roleMap.containsKey(rpgName + "Role"))
		{
			if (rpgName.length() > 2)
			{
				try
				{
					String id = createRPGRole();
					if (id != "")
					{
						role = g.getRoleById(id);
						System.out.println("Role:" + role.getName());

						addToRPG(e);

						ListCollector.roleMap.put(role.getName(), role);

						createTextChannel(g);
						createVoiceChannel(g);
						ListCollector.rpggroupList.put(rpg.getTxtchannel(), rpg);
						EmbedBuilder out = new EmbedBuilder().setColor(Color.CYAN);
						e.getTextChannel().sendMessage(out.setDescription("The Roleplay " + rpgName + " was started by "
								+ e.getMessage().getAuthor().getAsMention()).build()).queue();

					}
					else
					{
						System.out.println("RoleId is empty");
						e.getTextChannel()
								.sendMessage(STATIC.ERRORMSG
										.setDescription("Sorry, something didn't work please wait, I'm pinging "
												+ g.getOwner().getAsMention() + " :rage:")
										.build())
								.queue();
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
				e.getTextChannel()
						.sendMessage(STATIC.ERRORMSG
								.setDescription(
										"Hey, isn't this name a bit short? :thinking: You should add some characters")
								.build())
						.queue();
			}
		}
		else
		{
			System.out.println("Role already is exsisting");
			e.getTextChannel()
					.sendMessage(STATIC.ERRORMSG.setDescription("This RPG is already existing :frowning:").build())
					.queue();
		}
	}

	private void addToRPG(MessageReceivedEvent e)
	{
		rpg.setGroupname(rpgName);
		rpg.setCreator(e.getAuthor().getId());
		rpg.setStoryteller(e.getAuthor().getId());
		rpg.setRole(role);
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

	private void createTextChannel(Guild g) throws Exception
	{

		try
		{
			ChannelAction act = gc.createTextChannel(rpgName);

			act.setParent(g.getCategoryById(STATIC.TCATID));

			act.addPermissionOverride(role, allowTC, denyTC);

			String id = act.complete().getId();

			System.out.println("TxtChannel created");

			rpg.setTxtchannel(g.getTextChannelById(id));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("An error has occured with creating Channel");
		}

	}

	private void createVoiceChannel(Guild g)
	{
		try
		{
			ChannelAction act = gc.createVoiceChannel(rpgName + "VC");

			act.setParent(g.getCategoryById(STATIC.VCATID));

			act.addPermissionOverride(role, allowVC, denyVC);

			String id = act.complete().getId();

			System.out.println("VChannel created");

			rpg.setVcchannel(g.getVoiceChannelById(id));
		}
		catch (Exception e)
		{
			System.out.println("An error has occured with creating Channel");
		}
	}
}
