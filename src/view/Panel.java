package view;

import javax.swing.*;

import controller.Controller;

public class Panel extends JPanel
{
	private Controller controller;
	private SpringLayout layout;
	
	public Panel(Controller controller)
	{
		this.controller = controller;
		layout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
