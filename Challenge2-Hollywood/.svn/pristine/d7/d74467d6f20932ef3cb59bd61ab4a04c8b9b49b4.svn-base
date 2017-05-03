import java.text.DecimalFormat;

//UIUC CS125 FALL 2014 MP. File: MovieSurvey.java, CS125 Project: Challenge2-Hollywood, Version: 2015-09-14T13:37:53-0500.202137908
/**
 * A program to run a simple survey and report the results. See MovieSurvey.txt
 * for more information. TODO: add your netid to the line below
 * 
 * @author jmgreen5
 */
public class MovieSurvey {
	public static void main(String[] arg) {
		int cinema;
		int dvdOrVhs;
		int computer;
		double fractionInside;
		double fractionOutside;
			
			System.out.println("Welcome. We're interested in how people are watching movies this year.\nThanks for your time. - The WRITERS GUILD OF AMERICA.");
			TextIO.putln("Please tell us about how you've watched movies in the last month.");
			TextIO.putln("How many movies have you seen at the cinema?");
			cinema = TextIO.getlnInt();
			TextIO.putln("How many movies have you seen using a DVD or VHS player?");
			dvdOrVhs = TextIO.getlnInt();
			TextIO.putln("How many movies have you seen using a Computer?");
			computer = TextIO.getlnInt();
		
		System.out.println("Summary: " + cinema + " Cinema movies, " + dvdOrVhs + " DVD/VHS movies, " + computer + " Computer movies");
		double total = cinema + dvdOrVhs + computer;
		TextIO.putln("Total: " + (int)(total)+ " movies");
		
		
		fractionInside = (cinema/total)*100;
		String formatFraction = (new DecimalFormat("0.00").format(fractionInside));		
		TextIO.putln("Fraction of movies seen at a cinema: " + formatFraction + "%");
		
		fractionOutside = ((total-cinema)/total)*100;
		String secondFraction = (new DecimalFormat("0.00").format(fractionOutside));		
		TextIO.putln("Fraction of movies seen outside of a cinema: " + secondFraction + "%");
		
		
		// TODO: Write your program here
		// Hints :
		// Formatted output
		// http://math.hws.edu/javanotes/c2/s4.html#basics.4.4
		
		// Don't just copy paste the expected output
		// For grading purposes your code may be tested
		// with other input values.
	}
}