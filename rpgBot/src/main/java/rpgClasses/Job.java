package rpgClasses;


public class Job
{
	/**
	 * Characters can learn jobs
	 */
	private String	label;

	private Weapontype	usableWeapon;


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
}
