package rpgClasses;


public class Weapon extends Item implements Equipable<Weapon>
{
	public static int LEFT = 1;
	public static int RIGHT = 2;
	public static int BOTH = 3;
	
	private String	weapontype;

	private int		damage;

	private int		range;

	private int		malus;
	
	private boolean isEquiped = false;
	
	private int side;


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

	public boolean isEquiped()
	{
		return isEquiped;
	}

	private void setEquiped(boolean isEquiped)
	{
		this.isEquiped = isEquiped;
	}

	public int getSide()
	{
		return side;
	}

	public void setSide(int side)
	{
		this.side = side;
	}

	@Override
	public boolean equipItem(Weapon t, int part)
	{
		t.side = part;
		t.isEquiped = true;
		return false;
	}

	@Override
	public boolean equipItem(Weapon t)
	{
		t.side = BOTH;
		t.isEquiped = true;
		return false;
	}

}
