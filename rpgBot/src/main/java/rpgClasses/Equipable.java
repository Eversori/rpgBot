package rpgClasses;

public interface Equipable<T extends Item>
{
	public abstract boolean equipItem(T t, int part);
	public abstract boolean equipItem(T t);
}
