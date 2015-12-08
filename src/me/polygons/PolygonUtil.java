package me.polygons;

import java.util.Scanner;

public class PolygonUtil {
	
	
	static int modeID;
		
	public static void main(String args[])
	{
		askForMode();
		while (true)
		{
			if (modeID > 0)
			{
				int enter = askForNumber();
				
				if (enter != -1)
				{
					if (modeID == 1)
					{
						new Polygon(enter, 0, 0, 0, 0);
					} else if (modeID == 2)
					{
						new Polygon(0, enter, 0, 0, 0);
					} else if (modeID == 3)
					{
						new Polygon(0, 0, enter, 0, 0);
					} else if (modeID == 4)
					{
						new Polygon(0, 0, 0, enter, 0);
					} else if (modeID == 5)
					{
						new Polygon(0, 0, 0, 0, enter);
					}
				}
			}
		}	
	}
	
	public static void askForMode()
	{
		System.out.println("Type the number of the mode that you want to select.");
		System.out.println("[1] Input number of sides");
		System.out.println("[2] Input sum of interior angles");
		System.out.println("[3] Input the measure of one interior angle");
		System.out.println("[4] Input the measure of one exterior angle");
		System.out.println("[5] Input amount of diagonals");
		
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		
		
		if (checkIfNumber(input))
		{
			modeID = Integer.parseInt(input);
		}
		else
		{
			System.out.println("Hey, that isn't even a number, silly!");
			askForMode();
		}
		
		System.out.println(modeID);
	}
	
	
	public static int askForNumber()
	{
		if (modeID != -1)
		{
			if (modeID == 1)
				System.out.println("Please enter the number of sides of the shape");
			else if (modeID == 2)
				System.out.println("Please enter the sum of the interior angles in the shape");
			else if (modeID == 3)
				System.out.println("Please enter the measure of one interior angle");
			else if (modeID == 4)
				System.out.println("Please enter the measure of one exterior angle");
			else if (modeID == 5)
				System.out.println("Please enter the number of diagonals in the polygon");
			
			
			System.out.println("Enter 'mode' if you would like to change the mode.");
			
			Scanner scanner = new Scanner(System.in);
			
			String input = scanner.nextLine();
			
			
			if (checkIfNumber(input))
			{
				if (Integer.parseInt(input) <= 0) {
					System.out.println("Hey, negative numbers aren't allowed, silly!");
					return askForNumber();
				}
				
				return Integer.parseInt(input);
			} 
			else
			{
				if (input.equalsIgnoreCase("mode"))
				{
					modeID = -1;
					askForMode();
					return -1;
				}
				else 
				{
					//System.out.println("That was not recognized as a number. Please try again.");
					return askForNumber();
				}
			}
			
			
		}
		else 
		{
			System.out.println("Sorry! We messed up. Let's do this one more time.");
			askForMode();
			return -1;
		}
		
	}
	
	private static boolean checkIfNumber(String input)
	{
		try 
		{
			Integer.parseInt(input);	
		}
		catch (NumberFormatException e)
		{
			return false;
		}
		return true;	
	}
	
}
