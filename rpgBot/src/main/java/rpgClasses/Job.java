package rpgClasses;

public class Job
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
}
