package rpgBot.rpgBot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.dv8tion.jda.core.entities.Category;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.VoiceChannel;
import rpgClasses.RPGCharacter;
import rpgClasses.Tale;


public class ListCollector
{
	public static HashMap<String, Category> categoryMap = new HashMap<String, Category>();

	public static HashMap<String, Member> memberMap = new HashMap<String, Member>();

	public static HashMap<String, Role> roleMap = new HashMap<String, Role>();

	public static HashMap<String, TextChannel> txtChannelMap = new HashMap<String, TextChannel>();

	public static HashMap<String, VoiceChannel> vcChannelMap = new HashMap<String, VoiceChannel>();

	public static ArrayList<RPGCharacter> characterList = new ArrayList<RPGCharacter>();

	public static HashMap<TextChannel, Tale> taleList = new HashMap<TextChannel, Tale>();


	public static void createAMapOfServer(Guild g)
	{
		System.out.println("Actualize the Servermap");
		categoryMap.clear();
		memberMap.clear();
		roleMap.clear();
		txtChannelMap.clear();
		vcChannelMap.clear();

		try
		{
			for (Iterator<Category> icat = g.getCategories().iterator(); icat.hasNext();)
			{
				Category c = icat.next();
				if (!categoryMap.containsKey(c.getName()))
				{
					categoryMap.put(c.getName(), c);
				}
				else
				{
					DataConnect.writeDoc("Category " + c.getName() + " already is in Map");
				}
			}
			DataConnect.writeDoc("Category map successfully");
			for (Iterator<Member> im = g.getMembers().iterator(); im.hasNext();)
			{
				Member m = im.next();
				if (!memberMap.containsKey(m.getEffectiveName()))
				{
					memberMap.put(m.getEffectiveName(), m);
				}
				else
				{
					DataConnect.writeDoc("Member " + m.getEffectiveName() + " already is in Map");
				}
			}
			DataConnect.writeDoc("Member map successfully");
			for (Iterator<Role> ir = g.getRoles().iterator(); ir.hasNext();)
			{
				Role r = ir.next();
				if (!roleMap.containsKey(r.getName()))
				{
					roleMap.put(r.getName(), r);
				}
				else
				{
					DataConnect.writeDoc("Role " + r.getName() + " already is in Map");
				}
			}
			DataConnect.writeDoc("Role map successfully");
			for (Iterator<TextChannel> itc = g.getTextChannels().iterator(); itc.hasNext();)
			{
				TextChannel tc = itc.next();
				if (!txtChannelMap.containsKey(tc.getName()))
				{
					txtChannelMap.put(tc.getName(), tc);
				}
				else
				{
					DataConnect.writeDoc("TextChannel " + tc.getName() + " already is in Map");
				}
			}
			DataConnect.writeDoc("TextChannel map successfully");
			for (Iterator<VoiceChannel> ivc = g.getVoiceChannels().iterator(); ivc.hasNext();)
			{
				VoiceChannel vc = ivc.next();
				if (!vcChannelMap.containsKey(vc.getName()))
				{
					vcChannelMap.put(vc.getName(), vc);
				}
				else
				{
					DataConnect.writeDoc("VoiceChannel " + vc.getName() + " already is in Map");
				}
			}
			DataConnect.writeDoc("VoiceChannel map successfully");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			DataConnect.writeDoc(e.getMessage());
		}

	}

}
