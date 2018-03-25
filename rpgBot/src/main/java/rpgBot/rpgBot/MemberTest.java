package rpgBot.rpgBot;

import java.util.Iterator;
import java.util.function.BiConsumer;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import rpgClasses.RPGCharacter;

public class MemberTest
{
	protected static boolean hasChara;

	public static boolean isThisALeader(Member m)
	{
		boolean hasLead = false;

		if (ListCollector.memberMap.containsKey(m.getEffectiveName()))
		{
			if (m.getRoles().contains(ListCollector.roleMap.get("~Leader"))
			        || m.getRoles().contains(ListCollector.roleMap.get("~General"))
			        || m.getRoles().contains(ListCollector.roleMap.get("~Taktitian")))
			{
				hasLead = true;
			}
			else
			{
				hasLead = false;
				System.out.println("User has not the permission to execute this Command");
			}
		}
		else
		{
			hasLead = false;
			System.out.println("User is not in the Map");
		}

		return hasLead;
	}

	public static boolean memberHasCharacter(Member m, TextChannel txt)
	{
		hasChara = false;
		// Does the member already have a Character in this Channel

		ListCollector.characterList.forEach(new BiConsumer<String, RPGCharacter>()
		{

			@Override
			public void accept(String arg0, RPGCharacter arg1)
			{
				if (arg1.getCreator() == m && arg1.getOwnStory().getTxtChannel() == txt)
				{
					hasChara = true;
				}
				else
				{
					hasChara = false;
				}

			}

		});
		return hasChara;
	}

	public static boolean isThisHome(Member m, TextChannel c)
	{
		boolean isHome = false;

		for (Iterator<Role> iRM = m.getRoles().iterator(); iRM.hasNext();) // List
		                                                                   // of
		                                                                   // Roles
		                                                                   // which
		                                                                   // the
		                                                                   // member
		                                                                   // has
		{
			Role r = iRM.next();
			if (r.getName().contains(c.getName())) // Has the Member the Role of
			                                       // the Channel
			{
				isHome = true;
				break;
			}
			else
			{
				isHome = false;
			}
		}

		return isHome;
	}

}
