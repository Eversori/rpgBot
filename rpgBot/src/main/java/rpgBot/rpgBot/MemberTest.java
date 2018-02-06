package rpgBot.rpgBot;


import net.dv8tion.jda.core.entities.Member;


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

}
