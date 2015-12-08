package me.polygons;

import java.util.Scanner;

public class PolygonUtil {

	static class Polygon
	{
		double sides;
		double intAngleSum;
		double eachIntAngle;
		double eachExtAngle;
		double diagonals;
		
		public Polygon(int sides, int intAngleSum, double eachIntAngle, double eachExtAngle, int diagonals) 
		{
			try
			{
				if (!(sides == 0))
				{
					setInfo(sides);	
				} 
				else if (!(eachExtAngle == 0))
				{
					setInfo(360 / eachExtAngle);
				} 
				else if (!(eachIntAngle == 0))
				{
					System.out.println(eachIntAngle);
					int count = 3;
					
					if (eachIntAngle < 180)
					{
						while (true)
						{
							if (eachIntAngle == (180 * (count - 2)) / count)
							{
								setInfo(count);
								System.out.println(count);
								break;
							}
							
							if (eachIntAngle < (180 * (count - 2)) / count)
							{
								System.out.println("Error: Not a polygon!");
								break;
							}
					
							count++;
						}
					}
					else
					{
						System.out.println("You entered a value that is greater than 180, which isn't possible for a regular polygon.");
					}
					
					
					//System.out.println(-360 / (eachIntAngle-180));
				}
				else if (!(intAngleSum == 0))
				{
					setInfo((intAngleSum + 360) / 180);
				}
				else if (!(diagonals == 0))
				{
					
				}
				
			}
			catch (Exception e)
			{
				System.out.println("Error: That isn't a regular polygon!");
				System.out.println(e.toString());
			}
		}
		
		public void setInfo(double sides)
		{
			if (sides == (int)sides)
			{
				if (sides > 2)
				{
					this.sides = sides;
					eachExtAngle = 360 / sides;
					eachIntAngle = (180 * (sides - 2) / sides);
					intAngleSum = 180 * (sides - 2);
					diagonals = (sides * (sides - 3)) / 2;
					printInfo();
				}
				else
				{
					System.out.println("I don't know what kind of planet you're living on, but that's not a polygon.");
				}
			} else
			{
				System.out.println("That isn't a regular polygon!");
			}
		}
		
		public void printInfo()
		{
			try
			{
				System.out.printf("--- Polygon with %s sides ---", sides);
				System.out.println();
				System.out.printf(">> Sum of all interior angles is %s degrees", intAngleSum);
				System.out.println();
				System.out.printf(">> Each interior angle is %s degrees", eachIntAngle);
				System.out.println();
				System.out.printf(">> Each exterior angle is %s degrees", eachExtAngle);
				System.out.println();
				System.out.printf(">> Has %s diagonals", diagonals);
				System.out.println();
			} 
			catch (NullPointerException e)
			{
				System.out.println("Error please try again");
			}
			
		}
		
	}

	static int modeID;
		
	public static void main(String args[])
	{
		askForMode();
		while (true)
		{
			if (modeID > 0)
			{
				double enter = askForNumber();
				
				if (enter != -1)
				{
					if (modeID == 1)
					{
						new Polygon((int)enter, 0, 0, 0, 0);
					} else if (modeID == 2)
					{
						new Polygon(0, (int)enter, 0, 0, 0);
					} else if (modeID == 3)
					{
						new Polygon(0, 0, enter, 0, 0);
					} else if (modeID == 4)
					{
						new Polygon(0, 0, 0, enter, 0);
					} else if (modeID == 5)
					{
						new Polygon(0, 0, 0, 0, (int)enter);
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
			if (Integer.parseInt(input) < 6 && Integer.parseInt(input) > 0)
				modeID = Integer.parseInt(input);
		}
		else
		{
			System.out.println("Hey, that isn't even a number, silly!");
			askForMode();
		}
	}
	
	public static double askForNumber()
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
				if (Double.parseDouble(input) <= 0) {
					System.out.println("Hey, negative numbers aren't allowed, silly!");
					return askForNumber();
				}
				
				return Double.parseDouble(input);
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
			Double.parseDouble(input);	
		}
		catch (NumberFormatException e)
		{
			return false;
		}
		return true;	
	}
}
