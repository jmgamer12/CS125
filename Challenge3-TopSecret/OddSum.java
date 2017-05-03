//UIUC CS125 FALL 2014 MP. File: OddSum.java, CS125 Project: Challenge3-TopSecret, Version: 2015-09-20T21:55:13-0500.813115451
/**
 * Prints sum of odd numbers in a specific format.
 * TODO: add your netid to the line below
 * @author jmgreen5
 */
public class OddSum { 
/**
Example output if user enters 10:
Max?
1 + 3 + 5 + 7 + 9 = 25
25 = 9 + 7 + 5 + 3 + 1

Example output if user enters 11:
Max?
1 + 3 + 5 + 7 + 9 + 11 = 36
36 = 11 + 9 + 7 + 5 + 3 + 1

 */
 public static void main(String[] args) {
	 
	 int total = 0;
	
	 //TextIO.putln("Please enter a number");
	 int number = TextIO.getlnInt();
	 //total = number;
	 TextIO.putln("Max?");
	 
	 for (int i = 0; i <= number; i++) {
		if (i % 2 == 1) {
			total += i;
			if (i == number || i == number - 1) {
				TextIO.put(i);
			}
			else {
				TextIO.put(i + " + ");
			}
		}
	 }
	TextIO.putln(" = " + total);
	TextIO.put(total + " = ");
	 for (int i = number; i >= 1; i--) {
		 if (i % 2 == 1) {
				TextIO.put(i);
			}
			else if (i % 2 == 0 && i > 1 && i < number) {
				TextIO.put(" + ");
	 }
	 }
  } // end of main method
} // end of class 	
