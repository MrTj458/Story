package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;

public class Frame extends JFrame 
{
	private Controller controller;
	private Panel panel;
	
	public Frame(Controller controller)
	{
		this.controller = controller;
		panel = new Panel(controller);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setTitle("Story");
		this.setContentPane(panel);
		this.setResizable(false);
		this.setSize(800, 600);
		this.setVisible(true);
	}
}
