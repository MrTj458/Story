/**
 * @author Trevor Hodsdon
 */

package model;

import controller.Controller;

public class Player
{
	private Controller controller;
	private String name;
	private int health;
	private int score;
	private Item equipped;
	
	private Inventory inventory;
	
	public Player(Controller controller, String name, int health, int score)
	{
		this.controller = controller;
		this.name = name;
		this.health = health;
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
			controller.getView().println("Currently equipped: " + equipped.getName());
			return null;
		}
		else
		{
			controller.getView().println("Currently equipped: " + equipped.getName());
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

	/**
	 * @return the name of the player.
	 */
	public String getName()
	{
		controller.getView().println("Player Name: " + name);
		return name;
	}

	/**
	 * @return the current player score.
	 */
	public int getScore()
	{
		controller.getView().println("Current score: " + score);
		return score;
	}

	/**
	 * @param score to add to the players score.
	 */
	public void addScore(int score)
	{
		this.score += score;
		controller.getView().println("Gained " + score + "score.");
	}
	
	/**
	 * @return the current health of the player.
	 */
	public int getHealth()
	{
		controller.getView().println("Current health: " + health);
		return health;
	}
	
	/**
	 * @param amount to take away from the player.
	 */
	public void damagePlayer(int amount)
	{
		health -= amount;
		controller.getView().println("Damaged " + amount + "health.");
	}
	
	/**
	 * @param amount to heal the player.
	 */
	public void healPlayer(int amount)
	{
		health += amount;
		controller.getView().println("Gained " + health + "health.");
	}
}
