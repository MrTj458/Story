/**
 * @author Trevor Hodsdon
 */

package view;

import java.util.Scanner;

public class Text
{
	Scanner scan;
	
	public Text()
	{
		scan = new Scanner(System.in);
	}
	
	/**
	 * Prints the inputted string to the console and adds a new line.
	 * @param print
	 */
	public void println(String print)
	{
		System.out.println(print);
	}
	
	/**
	 * Prints the inputted string to the console.
	 * @param print
	 */
	public void print(String print)
	{
		System.out.println(print);
	}
	
	/**
	 * Gets the next inputted value from the console.
	 * @return Input from the console as a string.
	 */
	public String nextString()
	{
		return scan.next();
	}
	
	/**
	 * Gets the next inputted integer from the console.
	 * @return The next integer inputted from the console.
	 */
	public int nextInt()
	{
		return scan.nextInt();
	}
}
