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
	
	/**
	 * Sets up the frame and its properties.
	 */
	private void setupFrame()
	{
		this.setTitle("Story");
		this.setContentPane(panel);
		this.setResizable(false);
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * @return the panel that is in the frame.
	 */
	public Panel getPanel()
	{
		return panel;
	}
}
