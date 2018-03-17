package rpgClasses;


public abstract class Monster extends Entity
{
	/**
	 * TODO: Not finished yet
	 * Monster are generated with this class
	 */
	private int attackRange; // Attack range of the monster


	public int getAttackRange()
	{
		return attackRange;
	}

	public void setAttackRange(int attackRange)
	{
		this.attackRange = attackRange;
	}
}
