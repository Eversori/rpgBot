package rpgClasses;

public class Weapon extends Item implements Equipable<Weapon>
{
	/**
	 * equipable Weapon for Characters
	 */

	public static int	SHORT		= 1;		// is this a very short ranged
	                                            // weapon
	public static int	MELEE		= 2;		// is this a melee weapon
	public static int	RANGEDMELEE	= 3;		// is this a long melee weapon
	public static int	MIDRANGED	= 4;		// is this a mid ranged weapon
	public static int	RANGED		= 5;		// is this a ranged weapon
	public static int	HIGHRANGED	= 6;		// is this a highly ranged
	                                            // weapon

	private Weapontype	type;					// Weapontype this weapon has

	private int			damage;					// damage of the weapon

	private int			malus;					// malus if the weaponmastery is
	                                            // too high

	private boolean		isEquipped	= false;	// is the weapon equipped

	private int			side;					// on which hand this weapon is
	                                            // equipped
	private int			range;					// attackrange with this weapon

	public Weapontype getType()
	{
		return type;
	}

	public void setType(Weapontype type)
	{
		this.type = type;
	}

	public int getDamage()
	{
		return damage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}

	public int getMalus()
	{
		return malus;
	}

	public void setMalus(int malus)
	{
		this.malus = malus;
	}

	public boolean isEquipped()
	{
		return isEquipped;
	}

	private void setEquipped(boolean isEquipped)
	{
		this.isEquipped = isEquipped;
	}

	public int getSide()
	{
		return side;
	}

	public void setSide(int side)
	{
		this.side = side;
	}

	public int getRange()
	{
		return range;
	}

	public void setRange(int range)
	{
		this.range = range;
	}

}
