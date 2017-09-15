package model;

import java.util.Scanner;

public class Text
{
	Scanner scan;
	
	public Text()
	{
		scan = new Scanner(System.in);
	}
	
	public void println(String print)
	{
		System.out.println(print);
	}
	
	public void print(String print)
	{
		System.out.println(print);
	}
	
	public String nextString()
	{
		return scan.next();
	}
	
	public int nextInt()
	{
		return scan.nextInt();
	}
}
