//UIUC CS125 FALL 2014 MP. File: Example_Ting.java, CS125 Project: Challenge2-Hollywood, Version: 2015-09-14T13:37:53-0500.202137908
public class Example_Ting {

// Here's one version of the 'ting' lecture problem.

	public static void main(String[] args) {
		TextIO.putln("Enter a word that includes the substring 'ting'");
		String blahdeblah = TextIO.getln();
		TextIO.put("You entered:");
		TextIO.putln(blahdeblah);
		TextIO.put("Found 'ting' at position " + (1 + blahdeblah.indexOf("ting")));
	}

}
