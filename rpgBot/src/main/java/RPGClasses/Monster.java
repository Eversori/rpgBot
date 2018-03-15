package RPGClasses;


public abstract class Monster extends Entity
{
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
