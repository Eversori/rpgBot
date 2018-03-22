package rpgClasses;

public interface DataBaseInterface
{
	public abstract String extractID() throws Exception;

	public abstract void extractStats(int[] stats) throws Exception;

	public abstract void extractStats(int[] stats, String help) throws Exception;

}
