package rpgClasses;

import rpgBot.rpgBot.DataConnect;

public abstract class Ability implements DataBaseInterface
{
	private String name;

	@Override
	public String extractID() throws Exception
	{
		String query = "";
		query = query + "SELECT abilityID FROM ability WHERE abilityName = " + this.getName();
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

	/**
	 * TODO: Not implemented yet Abilities are of this class
	 */

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
