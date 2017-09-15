/**
 * @author Trevor Hodsdon
 */

package model;

import controller.Controller;

public class Player
{
	private Controller controller;
	private String name;
	private int score;
	private Item equipped;
	
	private Inventory inventory;
	
	public Player(Controller controller, String name, int score)
	{
		this.controller = controller;
		this.name = name;
		this.score = score;
		
		inventory = new Inventory(controller);
	}
	
	/**
	 * @param item you want the player to equip.
	 */
	public void equip(String item)
	{
		if(inventory.hasItem(item))
		{
			equipped = inventory.getItem(item);
			controller.getView().println(name + " equipped " + item + ".");
		}
		else
		{
			controller.getView().println("Can not equip " + item + ".");
		}
	}
	
	/**
	 * @return the item the player has equipped.
	 */
	public Item getEquippedItem()
	{
		if(equipped == null)
		{
			return null;
		}
		else
		{
			return equipped;
		}
	}
	
	/**
	 * @return The inventory of the player
	 */
	public Inventory getInventory()
	{
		return inventory;
	}

	public String getName()
	{
		return name;
	}

	public int getScore()
	{
		return score;
	}

	public void addScore(int score)
	{
		this.score += score;
	}
}
