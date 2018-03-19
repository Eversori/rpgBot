package rpgClasses;

public class Race
{
	/**
	 * All possible Races for characters
	 */

	private String	raceName;	// The Name of Race

	private int		minAge;

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
}
