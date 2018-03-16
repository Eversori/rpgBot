package rpgClasses;


import java.util.HashMap;


public class Battle
{
	private HashMap<String, Entity> participant;

	private Tale tale;

	private String[] order;


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
