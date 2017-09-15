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
	
	private Inventory inventory;
	
	public Player(Controller controller, String name, int score)
	{
		this.controller = controller;
		this.name = name;
		this.score = score;
		
		inventory = new Inventory(controller);
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
