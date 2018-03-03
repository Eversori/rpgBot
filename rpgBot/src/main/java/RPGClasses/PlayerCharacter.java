package RPGClasses;


import java.util.ArrayList;
import java.util.HashMap;


public class PlayerCharacter extends RPGCharacter
{
	// General Attributes

	// Character Attributes
	private Job[] coset; // current coset of the Character

	private int ExP;

	private ArrayList<String> inventory = null;

	private HashMap<String, String> follower = null;


	// Bot Attributes

	public PlayerCharacter()
	{
		initialize();
	}

	public int getExP()
	{
		return ExP;
	}

	public void setExP(int exP)
	{
		ExP = exP;
	}

	public ArrayList<String> getInventory()
	{
		return inventory;
	}

	private void setInventory(ArrayList<String> inventory)
	{
		this.inventory = inventory;
	}

	public HashMap<String, String> getFollower()
	{
		return follower;
	}

	private void setFollower(HashMap<String, String> follower)
	{
		this.follower = follower;
	}

	public Job[] getCoset()
	{
		return coset;
	}

	public void setCoset(Job[] coset)
	{
		this.coset = coset;
	}

	@Override
	protected void initialize()
	{
		this.setFollower(new HashMap<String, String>());
		this.setInventory(new ArrayList<String>());
		this.setStats(new HashMap<String, Integer>());
		this.setHasLook(false);
		this.setHasRecord(false);
		this.setHasSex(false);
		this.setWeaponPulled(false);
		this.setCoset(new Job[4]);

		this.getStats().put("str", 0);
		this.getStats().put("vit", 0);
		this.getStats().put("int", 0);
		this.getStats().put("psy", 0);
		this.getStats().put("dex", 0);
		this.getStats().put("FP", 0);
		this.getStats().put("BP", 0);
		this.getStats().put("TF", 0);
		this.getStats().put("AP", 1);
	}

}
