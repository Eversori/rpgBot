package rpgClasses;


public class Weapon extends Item implements Equipable<Weapon>
{
	/**
	 * equipable Weapon for Characters
	 */
	public static int LEFT = 1; // is the weapon on the left hand
	public static int RIGHT = 2; // is the weapon on the right hand
	public static int BOTH = 3; // is the weapon for both hands
	
	private Weapontype	type; // Weapontype this weapon has

	private int		damage; // damage of the weapon

	private int		malus; // malus if the weaponmastery is too high
	
	private boolean isEquipped = false; // is the weapon equipped
	
	private int side; // on which hand this weapon is equipped


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

}
