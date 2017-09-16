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
		controller.getView().println("Added " + name + " to inventory.");
	}
	
	/**
	 * Add an item to the players inventory.
	 * @param name
	 * @param damage
	 */
	public void addItem(String name, int damage)
	{
		itemList.add(new Item(name, damage));
		controller.getView().println("Added " + name + "to inventory with " + damage + " damage.");
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
		
		controller.getView().println("Removed " + name + " from inventory.");
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
		
		if(hasItem)
		{
			controller.getView().println("The player has a " + item + ".");
		}
		else
		{
			controller.getView().println("The player does not have a " + item + ".");
		}
		
		return hasItem;
	}
	
	/**
	 * @return the number of items in the players inventory.
	 */
	public int numberOfItems()
	{
		controller.getView().println("The player has " + itemList.size() + " items.");
		return itemList.size();
	}
	
	/**
	 * @return names of all the items in the players inventory.
	 */
	public String getAllItems()
	{
		String result = "";
		
		for(int i = 0; i < itemList.size(); i++)
		{
			result += itemList.get(i).getName();
			
			if(i < itemList.size() - 1)
			{
				result += ", ";
			}
		}
		
		result += ".";
		
		controller.getView().println("Current inventory: " + result);
		
		return result;
	}
	
	/**
	 * @param item
	 * @return the item you requested.
	 */
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
		
		if(returnedItem != null)
		{
			controller.getView().println("The returned item is a " + returnedItem.getName() + ".");
		}
		else
		{
			controller.getView().println("The player does not have a " + item + ".");
		}
		
		return returnedItem;
	}
}
