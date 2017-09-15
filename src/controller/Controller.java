package controller;

import model.Text;

public class Controller
{	
	Text text;
	
	public Controller()
	{
		text = new Text();
	}
	
	public void start()
	{
		text.println("Test");
	}
}
