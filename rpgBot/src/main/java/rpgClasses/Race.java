package rpgClasses;

import java.sql.ResultSet;
import rpgBot.rpgBot.DataConnect;

public class Race implements DataBaseInterface
{
	/**
	 * All possible Races for characters
	 */

	private String	raceName;	// The Name of Race

	private int		minAge;

	private int		maxAgeYoung;

	private int		minAgeOld;

	private int		maxAge;

	private boolean	isPlayable;	// Is this Race usable for Player Characters or
	                            // only usable for NPC

	public String getRaceName()
	{
		return raceName;
	}

	public void setRaceName(String raceName)
	{
		this.raceName = raceName;
	}

	public boolean isPlayable()
	{
		return isPlayable;
	}

	public void setPlayable(boolean isPlayable)
	{
		this.isPlayable = isPlayable;
	}

	public int getMinAge()
	{
		return minAge;
	}

	public void setMinAge(int minAge)
	{
		this.minAge = minAge;
	}

	public int getMaxAge()
	{
		return maxAge;
	}

	public void setMaxAge(int maxAge)
	{
		this.maxAge = maxAge;
	}

	public int getMaxAgeYoung()
	{
		return maxAgeYoung;
	}

	public void setMaxAgeYoung(int maxAgeYoung)
	{
		this.maxAgeYoung = maxAgeYoung;
	}

	public int getMinAgeOld()
	{
		return minAgeOld;
	}

	public void setMinAgeOld(int minAgeOld)
	{
		this.minAgeOld = minAgeOld;
	}

	@Override
	public String extractID() throws Exception
	{
		// TODO Auto-generated method stub
		String query = "";
		query = "SELECT r.raceID FROM race r ";
		query = query + "WHERE r.raceName = " + getRaceName();

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
		String query = "";
		ResultSet rset = null;

		query = "SELECT rs.* FROM rstat rs, race r ";
		query = query + "WHERE r.raceID = rs.race ";
		query = query + "AND r.raceName = '" + getRaceName() + "' ";
		query = query + "AND rs.age = '" + help + "'";

		rset = DataConnect.extractData(query);
		for (int i = 2; i < 10; i++)
		{
			stats[i] = rset.getInt(i);
		}
	}
}
