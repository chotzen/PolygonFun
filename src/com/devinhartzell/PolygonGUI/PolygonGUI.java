package com.devinhartzell.PolygonGUI;

import java.awt.Composite;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;

public class PolygonGUI extends JFrame {
	
	private static final long serialVersionUID = 9001L;
	
	private JTextField sidesTextField;
	private JTextField intAngleTextField;
	private JTextField extAngleTextField;
	private JTextField intAngleSumTextField;
	private JTextField diagonalsTextField;
	
	private JTextArea errorMessage;
	
	public PolygonGUI() 
	{
		this.setTitle("Polygon Info GUI 1.0");
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(320, 200);
		
		
		JLabel sidesLabel = new JLabel("Sides");
		sidesLabel.setBounds(35, 6, 33, 16);
		getContentPane().add(sidesLabel);
		
		JLabel intAngleLabel = new JLabel("Int. Angle");
		intAngleLabel.setBounds(6, 34, 62, 16);
		getContentPane().add(intAngleLabel);
		
		JLabel extAngleLabel = new JLabel("Ext Angle");
		extAngleLabel.setBounds(6, 62, 62, 16);
		getContentPane().add(extAngleLabel);
		
		JLabel intAngleSumLabel = new JLabel("Int. Angle");
		intAngleSumLabel.setBounds(6, 90, 62, 16);
		getContentPane().add(intAngleSumLabel);
		
		JLabel intAngleSumLabel_2 = new JLabel("    Sum   ");
		intAngleSumLabel_2.setBounds(6, 110, 62, 16);
		getContentPane().add(intAngleSumLabel_2);
		
		JLabel diagonalsLabel = new JLabel("Diagonals");
		diagonalsLabel.setBounds(6, 131, 85, 16);
		getContentPane().add(diagonalsLabel);
		
		errorMessage = new JTextArea("");
		errorMessage.setEditable(false);
		errorMessage.setLineWrap(true);
		errorMessage.setBackground(UIManager.getColor("Label.background"));
		errorMessage.setForeground(Color.RED);
		errorMessage.setBounds(167, 101, 147, 71);
		getContentPane().add(errorMessage);
		
		sidesTextField = new JTextField();
		sidesTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				resetAllTextFields(sidesTextField);
			}
		});
		sidesTextField.setBounds(80, 0, 62, 28);
		getContentPane().add(sidesTextField);
		sidesTextField.setColumns(10);
		
		intAngleTextField = new JTextField();
		intAngleTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				resetAllTextFields(intAngleTextField);
			}
		});
		intAngleTextField.setColumns(10);
		intAngleTextField.setBounds(80, 28, 62, 28);
		getContentPane().add(intAngleTextField);
		
		extAngleTextField = new JTextField();
		extAngleTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				resetAllTextFields(extAngleTextField);
			}
		});
		extAngleTextField.setColumns(10);
		extAngleTextField.setBounds(80, 56, 62, 28);
		getContentPane().add(extAngleTextField);
		
		
		intAngleSumTextField = new JTextField();
		intAngleSumTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!(e.getKeyChar()==27||e.getKeyChar()==65535))
					resetAllTextFields(intAngleSumTextField);
			}
		});
		intAngleSumTextField.setColumns(10);
		intAngleSumTextField.setBounds(80, 84, 62, 28);
		getContentPane().add(intAngleSumTextField);
		
		diagonalsTextField = new JTextField();
		diagonalsTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				resetAllTextFields(diagonalsTextField);
			}
		});
		diagonalsTextField.setColumns(10);
		diagonalsTextField.setBounds(80, 125, 62, 28);
		getContentPane().add(diagonalsTextField);
		
		JButton goButton = new JButton("Go");
		goButton.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkIfNumber(sidesTextField.getText()))
				{
					if (checkIfInt(Double.parseDouble(sidesTextField.getText())))
					{
						try
						{
							if ((Integer.parseInt(sidesTextField.getText()) >= 3))
								setTextFields(Integer.parseInt(sidesTextField.getText()));
							else
								errorMessage.setText("Numbers can not be negative");
						} 
						catch (Exception ex)
						{
							errorMessage.setText(ex.toString());
						}
					}
					else
					{
						errorMessage.setText("Not an integer");
					}
					
				} 
				else if (checkIfNumber(intAngleTextField.getText()))
				{
					int count = 3;
					
					double eachIntAngle = Double.parseDouble(intAngleTextField.getText());
					
					if (eachIntAngle < 180)
					{
						while (true)
						{
							if (eachIntAngle == (180 * (count - 2)) / count)
							{
								setTextFields(count);
								break;
							}
							
							if (eachIntAngle < (180 * (count - 2)) / count)
							{
								errorMessage.setText("Error: Not a polygon!");
								break;
							}
							count++;
						}
					}
					else
					{
						errorMessage.setText("You entered a value that is greater than 180, which isn't possible for a regular polygon.");
					}
				} 
				else if (checkIfNumber(extAngleTextField.getText()))
				{
					try
					{
						
						setTextFields((int)(360 / Double.parseDouble(extAngleTextField.getText())));
					} 
					catch (Exception ex)
					{
						errorMessage.setText(ex.toString());
					}
				} 
				else if (checkIfNumber(intAngleSumTextField.getText()))
				{
					try
					{
						setTextFields((Integer.parseInt(intAngleSumTextField.getText()) + 360) / 180);
					} 
					catch (Exception ex)
					{
						errorMessage.setText(ex.toString());
					}
				} 
				else if (checkIfNumber(diagonalsTextField.getText()))
				{
					try
					{
						int i = Integer.parseInt(diagonalsTextField.getText()),
								count = 3;
						
						
						while (true)
						{
							if (i == (count * (count - 3)) / 2)
							{
								setTextFields(count);
								break;
							}
							
							if (i < (count * (count - 3)) / 2)
							{
								errorMessage.setText("Error: Not a polygon!");
								break;
							}
							count++;
						}
					}
					catch (Exception ex)
					{
						errorMessage.setText("Not an integer");
					}
				}
				else
				{
					errorMessage.setText("Could not find any valid inputs!");
				}
			}
		});
		
		
		goButton.setBounds(167, 34, 117, 52);
		getContentPane().add(goButton);
		
		getRootPane().setDefaultButton(goButton);
		
		this.setVisible(true);
	}
	
	private static boolean checkIfNumber(String input)
	{
		try 
		{
			Double.parseDouble(input);	
		}
		catch (NumberFormatException e)
		{
			return false;
		}
		return true;	
	}
	
	private static boolean checkIfInt(double d)
	{
		return (d == (int)d);
	}
	
	public void resetAllTextFields(JTextField notThisOne)
	{
		if (!notThisOne.equals(sidesTextField))
			sidesTextField.setText("");
		if (!notThisOne.equals(intAngleSumTextField))
			intAngleSumTextField.setText("");
		if (!notThisOne.equals(intAngleTextField))
			intAngleTextField.setText("");
		if (!notThisOne.equals(extAngleTextField))
			extAngleTextField.setText("");
		if (!notThisOne.equals(diagonalsTextField))
			diagonalsTextField.setText("");
	}
	
	public void setTextFields(int sides)
	{
		errorMessage.setText("");
		sidesTextField.setText(String.valueOf(sides));
		intAngleSumTextField.setText(String.valueOf(180 * (sides-2)));
		intAngleTextField.setText(String.valueOf((180* (sides-2))/sides));
		extAngleTextField.setText(String.valueOf(360 / sides));
		diagonalsTextField.setText(String.valueOf((sides * (sides - 3))/2 ));
	}
	
	
	@PostConstruct
	public void createControls(Composite parent) {
		
	} 
	
	public static void main(String args[])
	{
		new PolygonGUI();
	}
}
