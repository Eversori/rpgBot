package RPGClasses;


import java.util.ArrayList;
import java.util.HashMap;


public class NonPlayerCharacter extends RPGCharacter
{
	private String actionstyle;


	protected void initialize()
	{
		this.setStats(new HashMap<String, Stat>());
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

}
