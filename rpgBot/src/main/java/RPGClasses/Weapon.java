package RPGClasses;


public class Weapon
{
	private String	weaponId;

	private String	weaponName;

	private String	weapontype;

	private int		damage;

	private int		durability;

	private int		range;

	private int		malus;


	public String getWeaponId()
	{
		return weaponId;
	}

	public void setWeaponId(String weaponId)
	{
		this.weaponId = weaponId;
	}

	public String getWeaponName()
	{
		return weaponName;
	}

	public void setWeaponName(String weaponName)
	{
		this.weaponName = weaponName;
	}

	public String getWeapontype()
	{
		return weapontype;
	}

	public void setWeapontype(String weapontype)
	{
		this.weapontype = weapontype;
	}

	public int getDamage()
	{
		return damage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}

	public int getDurability()
	{
		return durability;
	}

	public void setDurability(int durability)
	{
		this.durability = durability;
	}

	public int getRange()
	{
		return range;
	}

	public void setRange(int range)
	{
		this.range = range;
	}

	public int getMalus()
	{
		return malus;
	}

	public void setMalus(int malus)
	{
		this.malus = malus;
	}

}
