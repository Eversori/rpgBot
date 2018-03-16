package rpgClasses;

public class Item
{
	private String label; // itemname
	private int durability; //Durability/Usability of this item
	public String getLabel()
	{
		return label;
	}
	public void setLabel(String label)
	{
		this.label = label;
	}
	public int getDurability()
	{
		return durability;
	}
	public void setDurability(int durability)
	{
		this.durability = durability;
	}
}
