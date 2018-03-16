package rpgClasses;


import java.util.ArrayList;
import java.util.HashMap;


public class PlayerCharacter extends RPGCharacter
{
	// Character Attributes
	private Job[] coset; // current coset of the Character

	private int exp;

	private ArrayList<String> inventory = null;

	private HashMap<String, Entity> follower = null;

	private int reputation;

	private int spezReputation;


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

	public ArrayList<String> getInventory()
	{
		return inventory;
	}

	private void setInventory(ArrayList<String> inventory)
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
		this.setInventory(new ArrayList<String>());
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
