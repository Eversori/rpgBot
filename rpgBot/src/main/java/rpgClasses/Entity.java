package rpgClasses;


public abstract class Entity
{
	/**
	 * Entity is a generic class for Characters and Monsters
	 */
	
	String		name; // Name of this Entity

	private int	stamina; // Lifepoints this Entity has

	private int mana; // Manapoints of the Entity


	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getStamina()
	{
		return stamina;
	}

	public void setStamina(int stamina)
	{
		this.stamina = stamina;
	}

	public int getMana()
	{
		return mana;
	}

	public void setMana(int mana)
	{
		this.mana = mana;
	}
}
