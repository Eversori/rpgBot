package RPGClasses;


import java.time.LocalDate;
import java.util.HashMap;
import net.dv8tion.jda.core.entities.Member;


public abstract class RPGCharacter
{
	// General Attributes
	private String CharID; // ID of the Character as Primary-Key in DB

	private Member creator; // The Discord Member who created this Character

	private Tale ownStory; // The RPG where this Character is registered

	// Character Attributes
	private String name; // Name of the Character

	private Race ownRace; // Race of the Character

	private Job mainJob; // current Main-Job of the Character

	private int age; // Age of this Character

	private LocalDate birthdate; // Birthdate of the Character

	private double heigth; // Height of the Character

	private double weight; // Weight of the Character

	private char sex; // Gender of the Character

	private String eyecolor;

	private String hair;

	private String appereance;

	private String nature;

	private String charaHistory;

	private HashMap<String, Integer> stats = null; // Stats of this Character

	private HashMap<String, Bonus> ownBoni = null; // Boni/Mali the
	// Character gets

	private HashMap<Weapon, Integer> mastery = null; // Weaponmastery of the
	// Character

	private int stamina;

	private int mana;

	private HashMap<String, Ability> ownSkill = null;

	// Bot Attributes
	private boolean hasLook;

	private boolean hasSex;

	private boolean hasRecord;

	private boolean isWeaponPulled;


	protected abstract void initialize();

	public Member getCreator()
	{
		return creator;
	}

	public void setCreator(Member creator)
	{
		this.creator = creator;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public LocalDate getBirthdate()
	{
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate)
	{
		this.birthdate = birthdate;
	}

	public double getHeigth()
	{
		return heigth;
	}

	public void setHeigth(double heigth)
	{
		this.heigth = heigth;
	}

	public double getWeight()
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	public char getSex()
	{
		return sex;
	}

	public void setSex(char sex)
	{
		this.sex = sex;
	}

	public String getEyecolor()
	{
		return eyecolor;
	}

	public void setEyecolor(String eyecolor)
	{
		this.eyecolor = eyecolor;
	}

	public String getHair()
	{
		return hair;
	}

	public void setHair(String hair)
	{
		this.hair = hair;
	}

	public String getAppereance()
	{
		return appereance;
	}

	public void setAppereance(String appereance)
	{
		this.appereance = appereance;
	}

	public String getNature()
	{
		return nature;
	}

	public void setNature(String nature)
	{
		this.nature = nature;
	}

	public String getCharaHistory()
	{
		return charaHistory;
	}

	public void setCharaHistory(String charaHistory)
	{
		this.charaHistory = charaHistory;
	}

	public HashMap<String, Integer> getStats()
	{
		return stats;
	}

	public void setStats(HashMap<String, Integer> stats)
	{
		this.stats = stats;
	}

	public int getStamina()
	{
		return stamina;
	}

	public void setStamina(int stamina)
	{
		this.stamina = stamina;
	}

	public int getMana()
	{
		return mana;
	}

	public void setMana(int mana)
	{
		this.mana = mana;
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

}
