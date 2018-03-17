package rpgClasses;

public class Weapontype
{
	private String typename;
	private int range;
	private Stat needet;
	private int howEquipped;
	
	public String getTypename()
	{
		return typename;
	}
	public void setTypename(String typename)
	{
		this.typename = typename;
	}
	public int getRange()
	{
		return range;
	}
	public void setRange(int range)
	{
		this.range = range;
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
