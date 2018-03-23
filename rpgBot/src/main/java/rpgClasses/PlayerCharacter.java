package rpgClasses;

import java.util.ArrayList;
import java.util.HashMap;
import rpgBot.rpgBot.DataConnect;

public class PlayerCharacter extends RPGCharacter
{
	/**
	 * the Players own Characters
	 */

	// Character Attributes
	private Job[]					coset;				// current coset of the
	                                                    // Character

	private int						exp;				// exp the character has
	                                                    // earned

	private ArrayList<Item>			inventory	= null;	// the Inventory with
	                                                    // Items

	private HashMap<String, Entity>	follower	= null;	// All the things, which
	                                                    // are passively
	                                                    // following this
	                                                    // character

	private int						reputation;			// reputation with the
	                                                    // people in a
	                                                    // Land/Town/...

	private int						spezReputation;		// reputation with the
	                                                    // church/Mafia/pirates/...

	// Bot Attributes

	public PlayerCharacter()
	{
		initialize();
	}

	public void createStartInventory() throws Exception
	{
		ArrayList<Item> items = extractItems();
		ArrayList<Weapon> weapons = extractWeapons();
		ArrayList<Armor> cloths = extractArmor();
		inventory.addAll(items);
		inventory.addAll(weapons);
		inventory.addAll(cloths);
	}

	private ArrayList<Item> extractItems()
	{
		ArrayList<Item> items = new ArrayList<>();
		String query = "SELECT i.label, i.durability FROM weapon i, class c ";
		query = query + "WHERE ";

		return items;
	}

	private ArrayList<Weapon> extractWeapons()
	{
		ArrayList<Weapon> weapons = new ArrayList<>();
		String query = "SELECT i.label, i.durability FROM item i, class c ";
		query = query + "WHERE ";

		return weapons;
	}

	private ArrayList<Armor> extractArmor()
	{
		ArrayList<Armor> cloths = new ArrayList<>();
		String query = "SELECT i.label, i.durability FROM armor i, class c ";
		query = query + "WHERE ";

		return cloths;
	}

	public void safeCharacter() throws Exception
	{
		String classid = this.getMainJob().extractID();
		String raceid = this.getOwnRace().extractID();
		String storyid = this.getOwnStory().extractID();

		String query = "";
		query = "INSERT INTO character ";
		query = query + "(charName, creator, class, race, age, str, vit, int, psy, dex, LP, MP, ";
		query = query + "TA, AP, playerCharacter, story) ";
		query = query + "(" + this.getName() + "," + this.getCreator().getUser().getId() + ",";
		query = query + classid + "," + raceid + "," + this.getAge() + ",";
		query = query + this.getStats().get("str") + "," + this.getStats().get("vit") + ",";
		query = query + this.getStats().get("int") + "," + this.getStats().get("psy") + ",";
		query = query + this.getStats().get("dex") + "," + this.getStats().get("LP") + ",";
		query = query + this.getStats().get("MP") + "," + this.getStats().get("TA") + ",";
		query = query + this.getStats().get("AP") + ", true, " + storyid + ")";

		long result = DataConnect.safeData(query);
		this.setCharID(String.valueOf(result));

		getInventory().forEach((n1) ->
			{
				try
				{
					safeInventory(n1);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			});
		getOwnSkill().forEach((n1, n2) ->
			{
				try
				{
					safeAbilitySet(n2);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			});

	}

	private void safeInventory(Item i) throws Exception
	{
		String id = i.extractID();
		String query = "";
		query = "INSERT INTO inventory values (";
		query = query + this.getCharID() + "," + id + ")";
		DataConnect.safeData(query);
	}

	private void safeAbilitySet(Ability a) throws Exception
	{
		String id = a.extractID();
		String query = "";
		query = "INSERT INTO abilitySet values (";
		query = query + this.getCharID() + "," + id + ")";
		DataConnect.safeData(query);
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
		this.setStats(new HashMap<String, Integer>());
		this.setOwnWeapon(new ArrayList<Weapon>());
		this.setOwnBoni(new HashMap<String, Stat>());
		this.setMastery(new HashMap<String, Integer>());
		this.setHasLook(false);
		this.setHasRecord(false);
		this.setHasSex(false);
		this.setWeaponPulled(false);
		this.coset = new Job[4];
	}

	@Override
	public String extractID() throws Exception
	{
		String query = "";
		query = "SELECT charaID FROM Character WHERE charaName = " + this.getName();

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
