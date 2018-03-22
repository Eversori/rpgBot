package rpgClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import net.dv8tion.jda.core.entities.Member;
import rpgBot.rpgBot.WriteInChat;

public abstract class RPGCharacter extends Entity implements DataBaseInterface
{
	// General Attributes
	private String						charID;				// ID of the
	                                                        // Character as
	                                                        // Primary-Key in DB

	private Member						creator;			// The Discord
	                                                        // Member who
	                                                        // created this
	                                                        // Character

	private Tale						ownStory;			// The RPG where
	                                                        // this Character is
	                                                        // registered

	// Character Attributes
	private Race						ownRace;			// Race of the
	                                                        // Character

	private Job							mainJob;			// current Main-Job
	                                                        // of the Character

	private int							age;				// Age of this
	                                                        // Character

	private HashMap<String, Integer>	stats		= null;	// Stats of this
	// Character

	private HashMap<String, Stat>		ownBoni		= null;	// Boni/Mali the
	// Character gets

	private HashMap<String, Integer>	mastery		= null;	// Weaponmastery of
	                                                        // the
	// Character

	private ArrayList<Weapon>			ownWeapon	= null;

	private HashMap<String, Ability>	ownSkill	= null;

	// Bot Attributes
	private boolean						hasLook;

	private boolean						hasSex;

	private boolean						hasRecord;

	private boolean						isWeaponPulled;

	private WriteInChat					writer		= null;

	protected abstract void initialize();

	protected abstract void safeCharacter() throws Exception;

	public void calcStats() throws Exception
	{
		writer = new WriteInChat(getOwnStory().getTxtChannel());
		int[] racestats = new int[9];
		int[] classstats = new int[9];
		int[] randomstats = new int[9];

		String agePoint = profeAge();
		getOwnRace().extractStats(racestats, agePoint);
		getMainJob().extractStats(classstats);
		getRandomStats(randomstats);

		stats.put("Str", racestats[0] + classstats[0] + randomstats[0]); // Strength
		stats.put("Vit", racestats[1] + classstats[1] + randomstats[1]); // Vitality
		stats.put("Int", racestats[2] + classstats[2] + randomstats[2]); // Intelligence
		stats.put("Psy", racestats[3] + classstats[3] + randomstats[3]); // Psyche
		stats.put("Dex", racestats[4] + classstats[4] + randomstats[4]); // Dexterity
		stats.put("LP", racestats[5] + classstats[5] + randomstats[5]); // Leading
		                                                                // Points
		stats.put("MP", racestats[6] + classstats[6] + randomstats[6]); // Movement
		                                                                // Points
		stats.put("TA", racestats[7] + classstats[7] + randomstats[7]); // Teamability
		stats.put("AP", racestats[8] + classstats[8] + randomstats[8]); // Actionpoints

	}

	private void getRandomStats(int[] randomstats)
	{
		Random rn = new Random();
		String out = "";
		randomstats[0] = rn.nextInt(10) + 11; // Str
		randomstats[1] = rn.nextInt(20) + 16; // Vit
		randomstats[2] = rn.nextInt(10) + 6; // Int
		randomstats[3] = rn.nextInt(20) + 11; // Psy
		randomstats[4] = rn.nextInt(10) + 11; // Dex
		randomstats[5] = rn.nextInt(4) + 1; // FP
		randomstats[6] = rn.nextInt(6) + 6; // BP
		randomstats[7] = rn.nextInt(4) + 1; // TF
		randomstats[8] = 1; // AP

		out = String.format("%s got as his stats: %n", this.getName());
		out = out + String.format("Strength: %d%n", randomstats[0]);
		out = out + String.format("Vitality: %d%n", randomstats[1]);
		out = out + String.format("Intelligence: %d%n", randomstats[2]);
		out = out + String.format("Psyche: %d%n", randomstats[3]);
		out = out + String.format("Dexterity: %d%n", randomstats[4]);
		out = out + String.format("Leaderpoints: %d%n", randomstats[5]);
		out = out + String.format("Movement: %d%n", randomstats[6]);
		out = out + String.format("Teamability: %d%n", randomstats[7]);
		out = out + String.format("Actionpoints: %d%n", randomstats[8]);

		writer.writeInfo(out);
	}

	private String profeAge()
	{
		if (getAge() < getOwnRace().getMaxAgeYoung())
		{
			return "young";
		}
		else
			if (getAge() > getOwnRace().getMinAgeOld())
			{
				return "old";
			}
			else
			{
				return "normal";
			}

	}

	public void addAbilities()
	{
		String query = "";

	}

	public Member getCreator()
	{
		return creator;
	}

	public void setCreator(Member creator)
	{
		this.creator = creator;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public HashMap<String, Integer> getStats()
	{
		return stats;
	}

	protected void setStats(HashMap<String, Integer> stats)
	{
		this.stats = stats;
	}

	public boolean isHasLook()
	{
		return hasLook;
	}

	public void setHasLook(boolean hasLook)
	{
		this.hasLook = hasLook;
	}

	public boolean isHasSex()
	{
		return hasSex;
	}

	public void setHasSex(boolean hasSex)
	{
		this.hasSex = hasSex;
	}

	public boolean isHasRecord()
	{
		return hasRecord;
	}

	public void setHasRecord(boolean hasRecord)
	{
		this.hasRecord = hasRecord;
	}

	public boolean isWeaponPulled()
	{
		return isWeaponPulled;
	}

	public void setWeaponPulled(boolean isWeaponPulled)
	{
		this.isWeaponPulled = isWeaponPulled;
	}

	public ArrayList<Weapon> getOwnWeapon()
	{
		return ownWeapon;
	}

	protected void setOwnWeapon(ArrayList<Weapon> ownWeapon)
	{
		this.ownWeapon = ownWeapon;
	}

	public HashMap<String, Integer> getMastery()
	{
		return mastery;
	}

	protected void setMastery(HashMap<String, Integer> mastery)
	{
		this.mastery = mastery;
	}

	public HashMap<String, Stat> getOwnBoni()
	{
		return ownBoni;
	}

	protected void setOwnBoni(HashMap<String, Stat> ownBoni)
	{
		this.ownBoni = ownBoni;
	}

	public HashMap<String, Ability> getOwnSkill()
	{
		return ownSkill;
	}

	protected void setOwnSkill(HashMap<String, Ability> ownSkill)
	{
		this.ownSkill = ownSkill;
	}

	public String getCharID()
	{
		return charID;
	}

	public void setCharID(String charID)
	{
		this.charID = charID;
	}

	public Tale getOwnStory()
	{
		return ownStory;
	}

	public void setOwnStory(Tale ownStory)
	{
		this.ownStory = ownStory;
	}

	public Race getOwnRace()
	{
		return ownRace;
	}

	public void setOwnRace(Race ownRace)
	{
		this.ownRace = ownRace;
	}

	public Job getMainJob()
	{
		return mainJob;
	}

	public void setMainJob(Job mainJob)
	{
		this.mainJob = mainJob;
	}

}
