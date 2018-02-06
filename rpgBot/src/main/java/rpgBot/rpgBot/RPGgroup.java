package rpgBot.rpgBot;


import java.util.ArrayList;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.VoiceChannel;


public class RPGgroup
{
	private long id;

	private String groupname;

	private Member creator;

	private Member storyteller;

	private ArrayList<Member> players = new ArrayList<Member>();

	private Role role;

	private TextChannel txtchannel;

	private VoiceChannel vcchannel;

	private Guild guild;


	public RPGgroup(Guild guild)
	{
		this.guild = guild;
	}

	public String getGroupname()
	{
		return groupname;
	}

	public void setGroupname(String groupname)
	{
		this.groupname = groupname;
	}

	public Member getCreator()
	{
		return creator;
	}

	public void setCreator(String userId)
	{
		this.creator = guild.getMemberById(userId);
	}

	public Member getStoryteller()
	{
		return storyteller;
	}

	public void setStoryteller(String userId)
	{
		this.storyteller = guild.getMemberById(userId);
	}

	public ArrayList<Member> getPlayers()
	{
		return players;
	}

	public void setPlayers(ArrayList<Member> players)
	{
		this.players = players;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public TextChannel getTxtchannel()
	{
		return txtchannel;
	}

	public void setTxtchannel(TextChannel txtchannel)
	{
		this.txtchannel = txtchannel;
	}

	public VoiceChannel getVcchannel()
	{
		return vcchannel;
	}

	public void setVcchannel(VoiceChannel vcchannel)
	{
		this.vcchannel = vcchannel;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

}
