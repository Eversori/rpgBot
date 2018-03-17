package rpgClasses;


import java.util.HashMap;


public class Battle
{
	/**
	 * is generated through a tale, when a battle happens
	 */
	
	private HashMap<String, Entity> participant; // Which Monsters and Characters are participating in this battle

	private Tale tale; // In which tale is this battle happening

	private String[] order; // the order, in which the turns are happening


	public Battle(Tale t)
	{
		this.tale = t;
		this.participant = new HashMap<>();
	}

	public String[] getOrder()
	{
		return order;
	}

	public void setOrder(String[] order)
	{
		this.order = order;
	}

	public HashMap<String, Entity> getParticipant()
	{
		return participant;
	}

	public Tale getTale()
	{
		return tale;
	}
}
