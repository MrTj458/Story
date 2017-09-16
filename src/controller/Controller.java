package controller;

import view.View;
import view.Frame;
import model.Player;

public class Controller
{	
	private View view;
	private Frame frame;
	private Player player;
	
	public Controller()
	{
		view = new View();
		frame = new Frame(this);
	}
	
	/**
	 * Starting method for the program.
	 */
	public void start()
	{
		player = new Player(this, "Bob", 100, 0);
		
		player.getInventory().addItem("Axe");
		player.getInventory().addItem("Sword");
		player.getInventory().addItem("Shovel");
		
		player.equip("Axe");
	}
	
	/**
	 * @param input to get handled by the story.
	 */
	public void handleInput(String input)
	{
		if(!input.equals(""))
		{
			addText(input);
		}
	}
	
	/**
	 * @return the current view object in use.
	 */
	public View getView()
	{
		return view;
	}
	
	/**
	 * @return the player.
	 */
	public Player getPlayer()
	{
		return player;
	}
	
	/**
	 * @param text that gets added to the main text area on the panel.
	 */
	public void addText(String text)
	{
		frame.getPanel().addText(text);
	}
}
