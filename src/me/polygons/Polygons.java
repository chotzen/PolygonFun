package com.devin.polygons;

import java.util.Scanner;

public class Polygons {
	
	public static void main(String args[])
	{
		while (true)
		{
			System.out.println("How many sides?");
			Scanner sc = new Scanner(System.in);
			
			int sides = sc.nextInt();
			
			if (sides == 0)
				printList();
			
			if (sides < 3) {
				break;
			}
			else {
				printInfo(sides);
			}		
		}
	}
	
	
	public static void printInfo(int sides)
	{
		System.out.println("------- " + sides + " sides -------");
		System.out.println("Sum of angles: " + getDegrees(sides));
		System.out.println("Amount of diagonals: " + getDiagonals(sides));
		System.out.println("Each Exterior Angle: " + getExterior(sides));
		System.out.println("Each Interior Angle: " + getInterior(sides));
	}
	
	public static double getDegrees(int sides)
	{
		return 180 * (sides - 2);
	}
	
	public static int getDiagonals(int sides)
	{		
		return (sides * (sides-3)) / 2;
	}
	
	public static double getExterior(int sides)
	{
		return 360.0 / sides;
	}
	
	public static double getInterior(int sides)
	{
		return getDegrees(sides) / sides;
	}
	
	public static void printList()
	{
		for (int count = 3; count <= 250; count++) 
		{
			printInfo(count);
		}
	}
}
