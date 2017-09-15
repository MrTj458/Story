package model;

import view.View;

public class Story
{
	private Player player;
	private View view;
	
	public Story(Player player, View view)
	{
		this.player = player;
		this.view = view;
	}
	
	public void start()
	{
		view.println("The story starts here.");
	}
}
