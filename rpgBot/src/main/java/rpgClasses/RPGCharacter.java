package rpgClasses;

import java.util.ArrayList;
import java.util.HashMap;
import net.dv8tion.jda.core.entities.Member;
import rpgBot.rpgBot.DataConnect;

public abstract class RPGCharacter extends Entity
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

	private HashMap<String, Stat>		stats		= null;	// Stats of this
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

	protected abstract void initialize();

	public void calcStats() throws Exception
	{
		String query = "";
		query = "SELECT rs.* FROM rstat rs, race r ";
		query = query + "WHERE r.raceID = rs.race ";
		query = query + "AND r.raceName = '" + getOwnRace().getRaceName() + "'";

		Object o = DataConnect.safeData(query);
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

	public HashMap<String, Stat> getStats()
	{
		return stats;
	}

	protected void setStats(HashMap<String, Stat> stats)
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
