package RPGClasses;


public class Race
{
	private String raceId;

	private String raceName; // The Name of Race

	private boolean isPlayable; // Is this Race usable for Player Characters or only usable for NPC


	public String getRaceId()
	{
		return raceId;
	}

	public void setRaceId(String raceId)
	{
		this.raceId = raceId;
	}

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
}
