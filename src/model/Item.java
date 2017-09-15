/**
 * @author Trevor Hodsdon
 */

package model;

public class Item
{
	private String name;
	private int damage;
	private int durability;
	
	public Item(String name)
	{
		this.name = name;
		this.durability = 100;
	}
	
	public Item(String name, int damage)
	{
		this.name = name;
		this.damage = damage;
		this.durability = 100;
	}

	/**
	 * @return the name of the item.
	 */
	public String getName()
	{
		return name;
	}
}
