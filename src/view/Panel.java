/**
 * @author Trevor Hodsdon
 */

package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.Controller;

public class Panel extends JPanel
{
	private Controller controller;
	
	private SpringLayout layout;
	
	//Buttons
	private JButton submitButton;
	private JButton inventoryButton;
	
	//Text Fields
	private JTextField textField;
	
	//Labels
	private JLabel healthLabel;
	private JLabel scoreLabel;
	private JLabel equippedLabel;
	
	//Text Areas
	private JTextArea textArea;
	private JTextArea inventoryArea;
	
	//Scroll Pane
	private JScrollPane scrollPane;
	
	public Panel(Controller controller)
	{
		this.controller = controller;
		
		layout = new SpringLayout();
		
		//Buttons
		submitButton = new JButton("Submit");
		inventoryButton = new JButton("Refresh Inventory");
		
		//Text Fields
		textField = new JTextField();
		
		//Labels
		healthLabel = new JLabel("Health: ");
		scoreLabel = new JLabel("Score: ");
		equippedLabel = new JLabel("Equipped: ");
		
		//Text Areas
		textArea = new JTextArea();
		inventoryArea = new JTextArea();
		
		//Scroll Pane
		scrollPane = new JScrollPane(textArea);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
		
		//Buttons
		this.add(submitButton);
		this.add(inventoryButton);
		
		//Text Fields
		this.add(textField);
		
		//Labels
		this.add(healthLabel);
		this.add(scoreLabel);
		this.add(equippedLabel);
		
		//Text Areas
		textArea.setBackground(Color.darkGray);
		textArea.setEnabled(false);
		
		this.add(inventoryArea);
		inventoryArea.setEnabled(false);
		inventoryArea.setBackground(Color.darkGray);
		
		//Scroll Pane
		this.add(scrollPane);
	}
	
	/**
	 * Sets up where everything is located.
	 */
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.SOUTH, submitButton, -10, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, equippedLabel, 0, SpringLayout.NORTH, healthLabel);
		layout.putConstraint(SpringLayout.WEST, equippedLabel, 33, SpringLayout.EAST, scoreLabel);
		layout.putConstraint(SpringLayout.NORTH, textField, 1, SpringLayout.NORTH, submitButton);
		layout.putConstraint(SpringLayout.NORTH, inventoryButton, -4, SpringLayout.NORTH, healthLabel);
		layout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, inventoryArea);
		layout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, textField);
		layout.putConstraint(SpringLayout.SOUTH, scrollPane, -6, SpringLayout.NORTH, submitButton);
		layout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, submitButton);
		layout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, inventoryButton, 0, SpringLayout.EAST, submitButton);
		layout.putConstraint(SpringLayout.EAST, textField, -6, SpringLayout.WEST, submitButton);
		layout.putConstraint(SpringLayout.NORTH, healthLabel, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, inventoryArea, 6, SpringLayout.SOUTH, healthLabel);
		layout.putConstraint(SpringLayout.WEST, inventoryArea, 0, SpringLayout.WEST, textField);
		layout.putConstraint(SpringLayout.SOUTH, inventoryArea, -6, SpringLayout.NORTH, textArea);
		layout.putConstraint(SpringLayout.EAST, inventoryArea, 0, SpringLayout.EAST, submitButton);
		layout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, textField);
		layout.putConstraint(SpringLayout.NORTH, scoreLabel, 0, SpringLayout.NORTH, healthLabel);
		layout.putConstraint(SpringLayout.WEST, scoreLabel, 23, SpringLayout.EAST, healthLabel);
		layout.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST, textField);
		layout.putConstraint(SpringLayout.SOUTH, textArea, -6, SpringLayout.NORTH, submitButton);
		layout.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, submitButton);
		layout.putConstraint(SpringLayout.NORTH, textArea, 126, SpringLayout.SOUTH, healthLabel);
	}
	
	/**
	 * Sets up the listeners for different objects.
	 */
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				submitted(textField.getText());
			}
		});
		
		textField.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent pressed)
			{
				if(pressed.getKeyCode() == KeyEvent.VK_ENTER)
				{
					submitted(textField.getText());
				}
			}

			public void keyReleased(KeyEvent released)
			{}

			public void keyTyped(KeyEvent typed)
			{}

		});
		
		inventoryButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				refreshStats();
			}
		});
	}
	
	/**
	 * Refreshes the stats.
	 */
	private void refreshStats()
	{
		healthLabel.setText("Health: " + Integer.toString(controller.getPlayer().getHealth()));
		scoreLabel.setText("Score: " + Integer.toString(controller.getPlayer().getScore()));
		inventoryArea.setText("Current inventory: " + controller.getPlayer().getInventory().getAllItems());
		equippedLabel.setText("Equipped: " + controller.getPlayer().getEquippedItem().getName());
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	/**
	 * @param text to add to the text area.
	 */
	public void addText(String text)
	{
		textArea.append(text + "\n");
	}
	
	/**
	 * @param input to get submitted from the text field.
	 */
	private void submitted(String input)
	{
		controller.handleInput(input);
		
		//Always keep this at the bottom.
		refreshStats();
	}
}
