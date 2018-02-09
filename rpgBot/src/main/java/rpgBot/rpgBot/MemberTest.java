package rpgBot.rpgBot;


import java.util.Iterator;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;


public class MemberTest
{
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
		boolean hasChara = false;
		for (Iterator<RPGCharacter> iChar = ListCollector.characterList.iterator(); iChar.hasNext();)
		{
			RPGCharacter chara = iChar.next();
			if (chara.getCreator() == m && chara.getGroup().getTxtchannel() == txt)
			{
				hasChara = true;
				break;
			}
		}

		return hasChara;
	}

	public static boolean isThisHome(Member m, TextChannel c)
	{
		boolean isHome = false;

		for (Iterator<Role> iRM = m.getRoles().iterator(); iRM.hasNext();)
		{
			Role r = iRM.next();
			if (r.getName().contains(c.getName()))
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
