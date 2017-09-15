package controller;

import view.Text;

public class Controller
{	
	Text text;
	
	public Controller()
	{
		text = new Text();
	}
	
	public void start()
	{
		text.println("Write your name.");
		String name = text.nextString();
		text.println("Your name is " + name);
	}
}
