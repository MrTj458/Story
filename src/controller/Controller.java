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
		view.println("Welcome to Story.");
		view.println("What is your name?");
		String name = view.nextString();
		
		player = new Player(this, name, 0);
		
		view.println("Welcome to the game " + player.getName() + "!");
		view.println("Hope you have fun!");
		
		story = new Story(player, view);
		story.start();
	}
	
	public View getView()
	{
		return view;
	}
}
