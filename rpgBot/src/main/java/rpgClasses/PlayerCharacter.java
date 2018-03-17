package rpgClasses;


import java.util.ArrayList;
import java.util.HashMap;


public class PlayerCharacter extends RPGCharacter
{
	/**
	 * the Players own Characters
	 */
	
	// Character Attributes
	private Job[] coset; // current coset of the Character

	private int exp; // exp the character has earned

	private ArrayList<Item> inventory = null; // the Inventory with Items

	private HashMap<String, Entity> follower = null; // All the things, which are passively following this character

	private int reputation; // reputation with the people in a Land/Town/...

	private int spezReputation; // reputation with the church/Mafia/pirates/...


	// Bot Attributes

	public PlayerCharacter()
	{
		initialize();
	}

	public int getExP()
	{
		return exp;
	}

	public void setExP(int exp)
	{
		this.exp = exp;
	}

	public ArrayList<Item> getInventory()
	{
		return inventory;
	}

	private void setInventory(ArrayList<Item> inventory)
	{
		this.inventory = inventory;
	}

	public HashMap<String, Entity> getFollower()
	{
		return follower;
	}

	public Job[] getCoset()
	{
		return coset;
	}

	public int getReputation()
	{
		return reputation;
	}

	public void setReputation(int reputation)
	{
		this.reputation = reputation;
	}

	public int getSpezReputation()
	{
		return spezReputation;
	}

	public void setSpezReputation(int spezReputation)
	{
		this.spezReputation = spezReputation;
	}

	@Override
	protected void initialize()
	{
		this.follower = new HashMap<String, Entity>();
		this.setInventory(new ArrayList<Item>());
		this.setStats(new HashMap<String, Stat>());
		this.setOwnWeapon(new ArrayList<Weapon>());
		this.setOwnBoni(new HashMap<String, Stat>());
		this.setMastery(new HashMap<String, Integer>());
		this.setHasLook(false);
		this.setHasRecord(false);
		this.setHasSex(false);
		this.setWeaponPulled(false);
		this.coset = new Job[4];
	}

}
