package rpgClasses;

import rpgBot.rpgBot.DataConnect;

public class Item implements DataBaseInterface
{
	/**
	 * All the different Items of a rpg are of this class
	 */

	private String	label;		// itemname
	private int		durability;	// Durability/Usability of this item

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

	@Override
	public String extractID() throws Exception
	{
		String query = "";
		query = "SELECT itemID FROM Item WHERE ItemName = " + this.getLabel();
		String id = DataConnect.extractData(query).getString(0);
		return id;
	}

	@Override
	public void extractStats(int[] stats) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void extractStats(int[] stats, String help) throws Exception
	{
		// TODO Auto-generated method stub

	}
}
