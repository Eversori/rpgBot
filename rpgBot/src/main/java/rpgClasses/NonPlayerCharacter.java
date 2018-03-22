package rpgClasses;

import java.util.ArrayList;
import java.util.HashMap;

public class NonPlayerCharacter extends RPGCharacter
{
	/**
	 * Nonplayercharacters aka NPCs are of this class
	 */
	private String actionstyle; // how does this NPC act

	protected void initialize()
	{
		this.setStats(new HashMap<String, Integer>());
		this.setOwnWeapon(new ArrayList<Weapon>());
		this.setOwnBoni(new HashMap<String, Stat>());
		this.setMastery(new HashMap<String, Integer>());
		this.setHasLook(false);
		this.setHasRecord(false);
		this.setHasSex(false);
		this.setWeaponPulled(false);
	}

	public String getActionstyle()
	{
		return actionstyle;
	}

	public void setActionstyle(String actionstyle)
	{
		this.actionstyle = actionstyle;
	}

	@Override
	protected void safeCharacter() throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String extractID() throws Exception
	{
		// TODO Auto-generated method stub
		return null;
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
