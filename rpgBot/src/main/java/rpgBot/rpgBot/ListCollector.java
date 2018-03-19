package rpgBot.rpgBot;

import java.util.HashMap;
import java.util.Iterator;
import net.dv8tion.jda.core.entities.Category;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.VoiceChannel;
import rpgClasses.Job;
import rpgClasses.RPGCharacter;
import rpgClasses.Race;
import rpgClasses.Tale;

public class ListCollector
{
	public static HashMap<String, Category>		categoryMap		= new HashMap<String, Category>();		// Key
	                                                                                                    // Categoryname

	public static HashMap<String, Member>		memberMap		= new HashMap<String, Member>();		// Key
	                                                                                                    // Memberid

	public static HashMap<String, Role>			roleMap			= new HashMap<String, Role>();			// Key
	                                                                                                    // Rolename

	public static HashMap<String, TextChannel>	txtChannelMap	= new HashMap<String, TextChannel>();	// Key
	                                                                                                    // Channelname

	public static HashMap<String, VoiceChannel>	vcChannelMap	= new HashMap<String, VoiceChannel>();	// Key
	                                                                                                    // Channelname

	public static HashMap<String, RPGCharacter>	characterList	= new HashMap<String, RPGCharacter>();	// Key
	                                                                                                    // Charactername

	public static HashMap<TextChannel, Tale>	taleList		= new HashMap<TextChannel, Tale>();		// Key
	                                                                                                    // TextChannel
	public static HashMap<String, Race>			raceList		= new HashMap<>();						// key
	                                                                                                    // Racelabel

	public static HashMap<String, Job>			classList		= new HashMap<>();						// key
	                                                                                                    // Joblabel

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
					System.out.println("Category " + c.getName() + " already is in Map");
				}
			}
			System.out.println("Category map successfully");
			for (Iterator<Member> im = g.getMembers().iterator(); im.hasNext();)
			{
				Member m = im.next();
				if (!memberMap.containsKey(m.getEffectiveName()))
				{
					memberMap.put(m.getEffectiveName(), m);
				}
				else
				{
					System.out.println();
				}
			}
			System.out.println("Member map successfully");
			for (Iterator<Role> ir = g.getRoles().iterator(); ir.hasNext();)
			{
				Role r = ir.next();
				if (!roleMap.containsKey(r.getName()))
				{
					roleMap.put(r.getName(), r);
				}
				else
				{
					System.out.println("Role " + r.getName() + " already is in Map");
				}
			}
			System.out.println("Role map successfully");
			for (Iterator<TextChannel> itc = g.getTextChannels().iterator(); itc.hasNext();)
			{
				TextChannel tc = itc.next();
				if (!txtChannelMap.containsKey(tc.getName()))
				{
					txtChannelMap.put(tc.getName(), tc);
				}
				else
				{
					System.out.println("TextChannel " + tc.getName() + " already is in Map");
				}
			}
			System.out.println("TextChannel map successfully");
			for (Iterator<VoiceChannel> ivc = g.getVoiceChannels().iterator(); ivc.hasNext();)
			{
				VoiceChannel vc = ivc.next();
				if (!vcChannelMap.containsKey(vc.getName()))
				{
					vcChannelMap.put(vc.getName(), vc);
				}
				else
				{
					System.out.println("VoiceChannel " + vc.getName() + " already is in Map");
				}
			}
			System.out.println("VoiceChannel map successfully");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
