package rpgClasses;

import java.sql.ResultSet;
import rpgBot.rpgBot.DataConnect;

public class Job implements DataBaseInterface
{
	/**
	 * Characters can learn jobs
	 */
	private String		label;

	private Weapontype	usableWeapon;

	private int			tier;

	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public Weapontype getUsableWeapon()
	{
		return usableWeapon;
	}

	public void setUsableWeapon(Weapontype usableWeapon)
	{
		this.usableWeapon = usableWeapon;
	}

	public int getTier()
	{
		return tier;
	}

	public void setTier(int tier)
	{
		this.tier = tier;
	}

	@Override
	public String extractID() throws Exception
	{
		// TODO Auto-generated method stub
		String query = "";

		query = "SELECT classID FROM class WHERE className = " + getLabel();
		String id = DataConnect.extractData(query).getString(0);
		return id;
	}

	@Override
	public void extractStats(int[] stats) throws Exception
	{
		// TODO Auto-generated method stub
		ResultSet rset = null;
		String query = "";

		query = "SELECT cs.* FROM cstat cs, class c ";
		query = query + "WHERE c.classID = cs.class ";
		query = query + "AND c.className " + getLabel();

		rset = DataConnect.extractData(query);
		for (int i = 2; i < 10; i++)
		{
			stats[i] = rset.getInt(i);
		}
	}

	@Override
	public void extractStats(int[] stats, String help) throws Exception
	{
	}
}
