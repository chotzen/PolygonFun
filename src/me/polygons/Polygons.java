package me.polygons;

public class Polygon
{
	int sides;
	int intAngleSum;
	double eachIntAngle;
	double eachExtAngle;
	int diagonals;
	
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
				setInfo((int)(360 / eachExtAngle));
			} 
			else if (!(eachIntAngle == 0))
			{
				setInfo((int)(-360 / (eachIntAngle-180)));
			}
			else if (!(intAngleSum == 0))
			{
				setInfo((int)(((1/180) * intAngleSum) + 2));
			}
			else if (!(diagonals == 0))
			{
				setInfo((int)(((1/2) * diagonals^2) + ((-3 / 2) * diagonals)));
			}
			printInfo();
		}
		catch (Exception e)
		{
			System.out.println("Error: That isn't a regular polygon!");
			System.out.println(e.toString());
		}
		
		
	}
	
	public void setInfo(int sides)
	{
		this.sides = sides;
		eachExtAngle = 360 / sides;
		eachIntAngle = (180 * (sides - 2) / sides);
		intAngleSum = 180 * (sides - 2);
		diagonals = (sides * (sides - 3)) / 2; 
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
