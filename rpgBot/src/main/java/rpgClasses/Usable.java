package rpgClasses;

public interface Usable<T extends Item>
{
	public abstract boolean useItem(T t);
}
