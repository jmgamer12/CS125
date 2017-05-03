//UIUC CS125 FALL 2014 MP. File: FindScriptLine.java, CS125 Project: Challenge2-Hollywood, Version: 2015-09-14T13:37:53-0500.202137908
/**
 * A program to search for specific lines and print their line number.
 * See FindScriptLine.txt for more details
 * TODO: add your netid to the line below
 * @author jmgreen5
 */
public class FindScriptLine {
	
	public static void main(String[] args) {
		boolean output=false; //Set to true when we find the desired character
		String search = ""; // Only print lines for this character
		
	
		TextIO.putln("Please enter the word(s) to search for");
		search = TextIO.getln();
		
		TextIO.readFile("thematrix.txt");
		TextIO.putln("Searching for " + "\'" + search + "\'");
		
		output = false;
		
		int count = 1;
		while (false == TextIO.eof()) {
			output = false;
			String term = TextIO.getln();
			if (term.isEmpty()) {
				output = false;
			}
			
			if (term.toUpperCase().indexOf(search.toUpperCase()) >= 0) {
				output = true;
			}
			
			if (output) {
				TextIO.putln(count + " - " + term.trim());
			}
			count++;
		}
		TextIO.putln("Done Searching for " + "\'" + search + "\'");
		//Declare string variables for future use
		//Call to get input from user
		//Remove any spaces and other unnecessary characters 
		// TODO: Implement the functionality described in FindScriptLine.txt
		// TODO: Test your code manually and using the automated unit tests in FindScriptLineTest		
	}
}
