package rpgClasses;

import java.util.ArrayList;
import java.util.HashMap;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.VoiceChannel;
import rpgBot.rpgBot.DataConnect;

public class Tale implements DataBaseInterface
{
	/**
	 * rpg which is played
	 */

	private String							taleName;			// Name of the
	                                                            // Tale

	private HashMap<String, RPGCharacter>	chara	= null;		// The
	                                                            // characters
	                                                            // which are
	                                                            // used in the
	                                                            // Tale

	private String[]						order;				// order the
	                                                            // characters
	                                                            // are taking
	                                                            // action
	private int								counter;			// gets counted
	                                                            // if a Player
	                                                            // use the
	                                                            // Command -next
	                                                            // until the
	                                                            // numberOfPlayers
	                                                            // is reached
	private int								numberOfPlayers;	// the
	                                                            // playerCount
	                                                            // in this RPG

	private boolean							isInConversation;	// is the Tale
	                                                            // in a
	                                                            // conversation
	                                                            // with someone

	private Battle							battle;

	// From Discord API
	private Member							storyTeller;		// Disc-Member
	                                                            // which is the
	                                                            // Leader of the
	                                                            // RPG

	private ArrayList<Member>				player	= null;		// All players
	                                                            // in the RPG

	private Role							role;				// Role of the
	                                                            // RPG

	private TextChannel						txtChannel;			// Textchannel
	                                                            // of the RPG

	private VoiceChannel					vcChannel;			// Voicechannel
	                                                            // of the RPG

	private Guild							guild;				// RPG was
	                                                            // generated in
	                                                            // this guild

	public Tale(Guild guild)
	{
		this.guild = guild;
		this.chara = new HashMap<>();
		this.isInConversation = false;
		this.player = new ArrayList<>();
		this.counter = 0;
	}

	public void safeThisTale() throws Exception
	{
		String query = "";
		query = "INSERT INTO tale (talename, Conversation, storyteller, role, text, voice, guild) ";
		query = query + "VALUES (" + this.getTaleName() + ", false," + this.getStoryTeller().getUser().getId();
		query = query + "," + this.getRole().getId() + "," + this.getTxtChannel().getId();
		query = query + "," + this.getVcChannel().getId() + "," + this.getGuild().getId() + ")";

		DataConnect.safeData(query);
	}

	public void safeNewParticipants() throws Exception
	{
		String id = this.extractID();
		this.getPlayer().forEach((n1) ->
			{
				String query = "";
				query = "INSERT INTO participants VALUES (" + id + "," + n1.getUser().getId() + ")";
				try
				{
					DataConnect.safeData(query);
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	}

	public String getTaleName()
	{
		return taleName;
	}

	public void setTaleName(String taleName)
	{
		this.taleName = taleName;
	}

	public boolean isInConversation()
	{
		return isInConversation;
	}

	public void setInConversation(boolean isInConversation)
	{
		this.isInConversation = isInConversation;
	}

	public Member getStoryTeller()
	{
		return storyTeller;
	}

	public void setStoryTeller(Member storyTeller)
	{
		this.storyTeller = storyTeller;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public TextChannel getTxtChannel()
	{
		return txtChannel;
	}

	public void setTxtChannel(TextChannel txtChannel)
	{
		this.txtChannel = txtChannel;
	}

	public VoiceChannel getVcChannel()
	{
		return vcChannel;
	}

	public void setVcChannel(VoiceChannel vcChannel)
	{
		this.vcChannel = vcChannel;
	}

	public Guild getGuild()
	{
		return guild;
	}

	public void setGuild(Guild guild)
	{
		this.guild = guild;
	}

	public HashMap<String, RPGCharacter> getChara()
	{
		return chara;
	}

	public String[] getOrder()
	{
		return order;
	}

	public void setOrder(String[] order)
	{
		this.order = order;
	}

	public ArrayList<Member> getPlayer()
	{
		return player;
	}

	public Battle getBattle()
	{
		return battle;
	}

	public void setBattle(Battle battle)
	{
		this.battle = battle;
	}

	public int getCounter()
	{
		return counter;
	}

	public void setCounter(int counter)
	{
		this.counter = counter;
	}

	public int getNumberOfPlayers()
	{
		this.setNumberOfPlayers(this.getPlayer().size());
		return numberOfPlayers;
	}

	private void setNumberOfPlayers(int numberOfPlayers)
	{
		this.numberOfPlayers = numberOfPlayers;
	}

	@Override
	public String extractID() throws Exception
	{
		String query = "";
		query = query + "SELECT storyId FROM story WHERE storyName = " + this.getTaleName();

		String id = DataConnect.extractData(query).getString(0);
		return id;
	}

	@Override
	public void extractStats(int[] stats) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void extractStats(int[] stats, String help) throws Exception
	{
		// TODO Auto-generated method stub

	}

}
