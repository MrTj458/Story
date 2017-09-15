package controller;

import view.View;
import model.Player;
import model.Story;

public class Controller
{	
	private View view;
	private Player player;
	private Story story;
	
	public Controller()
	{
		view = new View();
	}
	
	public void start()
	{
		player = new Player(this, "Bob", 0);
		player.getInventory().addItem("Sword", 50);
		player.equip("Sword");
		view.println(Integer.toString(player.getEquippedItem().getDurability()));
	}
	
	public View getView()
	{
		return view;
	}
}
