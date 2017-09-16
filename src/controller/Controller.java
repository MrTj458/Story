package controller;

import view.View;
import view.Frame;
import model.Player;
import model.Story;

public class Controller
{	
	private View view;
	private Frame frame;
	private Player player;
	private Story story;
	
	public Controller()
	{
		view = new View();
		frame = new Frame(this);
	}
	
	public void start()
	{
		
	}
	
	public View getView()
	{
		return view;
	}
}
