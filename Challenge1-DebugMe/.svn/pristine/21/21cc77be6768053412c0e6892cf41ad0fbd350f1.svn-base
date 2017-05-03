//UIUC CS125 FALL 2014 MP. File: Factorial.java, CS125 Project: Challenge1-DebugMe, Version: 2015-09-07T22:07:04-0500.818646126

/**
 * A program to calculate a factorial. The given code may contain errors. Fix the
 * given code and add additional code to calculate a factorial and pass the unit
 * tests. Hint sometimes an 'int' just 'aint big enough.
 * 
 * @see Factorial-ReadMe.txt for details on how to complete this program.
 * @author jmgreen5
 */
public class Factorial {
	public static void main(String[] args) {
		int number, secondary = 1;
		long factorial = 1;
		System.out.println("Enter a number between 1 and 20 inclusive.");
		number = TextIO.getlnInt();
			while (number < 1 || number >= 21) {
				System.out.println("Enter a number between 1 and 20 inclusive.");
				number = TextIO.getlnInt();
			}
			while (secondary <= number) {
				factorial = factorial * secondary;
				secondary++;
			}
			System.out.println(number + "! = " + factorial);
		}
	}
