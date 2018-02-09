package rpgBot.rpgBot;


import net.dv8tion.jda.core.entities.Member;


public class RPGCharacter
{
	private long id;

	private String name;

	private Member creator;

	private RPGgroup group;

	private int[] stats = new int[10];

	private String race;

	private String job;


	public static int[] randomStats()
	{
		int[] stat = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		return stat;
	}

	public int[] getStats()
	{
		return stats;
	}

	public void setStats(int[] stats)
	{
		this.stats = stats;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public Member getCreator()
	{
		return creator;
	}

	public void setCreator(Member creator)
	{
		this.creator = creator;
	}

	public RPGgroup getGroup()
	{
		return group;
	}

	public void setGroup(RPGgroup group)
	{
		this.group = group;
	}

	public String getRace()
	{
		return race;
	}

	public void setRace(String race)
	{
		this.race = race;
	}

	public String getJob()
	{
		return job;
	}

	public void setJob(String job)
	{
		this.job = job;
	}

}
