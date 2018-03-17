package rpgClasses;

public class Armor extends Item implements Equipable<Armor>
{
	/**
	 * Armors the characters can equip
	 */
	
	public static int HEAD = 1; // if the Armor is for the head
	public static int BODY = 2;	// -'- for the Body
	public static int LEGS = 3;	// -'- for lower Body
	public static int ARMS = 4;	// -'- for Arms and Hands
	public static int FULLBODY = 5; // -'- for the entire Body
	
	private int physicalDefense; // extra physical Defense
	private int magicalDefense; // extra magical Defense
	private int bodypart; // where does this Armor has to be equipped
	private boolean isEquipped = false; //is the Armor equipped
	
	
	
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
		return isEquipped;
	}
	private void setEquiped(boolean isEquiped)
	{
		this.isEquipped = isEquiped;
	}

}
