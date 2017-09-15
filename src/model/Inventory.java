/**
 * @author Trevor Hodsdon
 */

package model;

import controller.Controller;
import java.util.ArrayList;

public class Inventory
{
	private Controller controller;
	private ArrayList<Item> itemList;
	
	public Inventory(Controller controller)
	{
		this.controller = controller;
		itemList = new ArrayList<Item>();
	}
	
	/**
	 * Add an item to the players inventory.
	 * @param name
	 */
	public void addItem(String name)
	{
		itemList.add(new Item(name));
	}
	
	/**
	 * Add an item to the players inventory.
	 * @param name
	 * @param damage
	 */
	public void addItem(String name, int damage)
	{
		itemList.add(new Item(name, damage));
	}
	
	/**
	 * Remove the inputted item from the players inventory.
	 * @param name
	 */
	public void removeItem(String name)
	{
		for(int i = 0; i < itemList.size(); i++)
		{
			if(itemList.get(i).getName().equals(name))
			{
				itemList.remove(i);
			}
		}
	}
	
	/**
	 * Check if the player has an item.
	 * @param item
	 * @return True if the player has that item.
	 */
	public boolean hasItem(String item)
	{
		boolean hasItem = false;
		
		for(Item i : itemList)
		{
			if(item == i.getName())
			{
				hasItem = true;
			}
		}
		
		return hasItem;
	}
	
	/**
	 * @return the number of items in the players inventory.
	 */
	public int numberOfItems()
	{
		return itemList.size();
	}
	
	/**
	 * Prints all items in the players inventory neatly.
	 * 'item1, item2, item3'
	 */
	public void printItems()
	{
		for(int i = 0; i < itemList.size(); i++)
		{
			controller.getView().print(itemList.get(i).getName());
			
			if(i < itemList.size() - 1)
			{
				controller.getView().print(", ");
			}
		}
		controller.getView().println("");
	}
	
	public Item getItem(String item)
	{
		Item returnedItem = null;
		for(int i = 0; i < itemList.size(); i++)
		{
			if(itemList.get(i).getName().equals(item))
			{
				returnedItem = itemList.get(i);
			}
		}
		return returnedItem;
	}
}
