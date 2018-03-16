package rpgClasses;

public class Armor extends Item implements Equipable<Armor>
{
	public static int HEAD = 1;
	public static int BODY = 2;
	public static int LEGS = 3;
	public static int ARMS = 4;
	public static int FULLBODY = 5;
	
	private int physicalDefense;
	private int magicalDefense;
	private int bodypart;
	private boolean isEquiped = false;
	
	
	
	public int getPhysicalDefense()
	{
		return physicalDefense;
	}
	public void setPhysicalDefense(int physicalDefense)
	{
		this.physicalDefense = physicalDefense;
	}
	public int getMagicalDefense()
	{
		return magicalDefense;
	}
	public void setMagicalDefense(int magicalDefense)
	{
		this.magicalDefense = magicalDefense;
	}
	public int getBodypart()
	{
		return bodypart;
	}
	private void setBodypart(int bodypart)
	{
		this.bodypart = bodypart;
	}
	public boolean isEquiped()
	{
		return isEquiped;
	}
	private void setEquiped(boolean isEquiped)
	{
		this.isEquiped = isEquiped;
	}
	@Override
	public boolean equipItem(Armor t, int part)
	{
		t.bodypart = part;
		t.isEquiped = true;
		return false;
	}
	@Override
	public boolean equipItem(Armor t)
	{
		t.bodypart = FULLBODY;
		t.isEquiped = true;
		return false;
	}

}
