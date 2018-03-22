package rpgClasses;

public class Weapontype
{
	public static int	LEFT	= 1;	// is the weapon on the left
	// hand
	public static int	RIGHT	= 2;	// is the weapon on the right
	// hand
	public static int	BOTH	= 3;	// is the weapon for both hands

	private String		typename;

	private Stat		needet;
	private int			howEquipped;

	public String getTypename()
	{
		return typename;
	}

	public void setTypename(String typename)
	{
		this.typename = typename;
	}

	public Stat getNeedet()
	{
		return needet;
	}

	public void setNeedet(Stat needet)
	{
		this.needet = needet;
	}

	public int getHowEquipped()
	{
		return howEquipped;
	}

	public void setHowEquipped(int howEquipped)
	{
		this.howEquipped = howEquipped;
	}
}
