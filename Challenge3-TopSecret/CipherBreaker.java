//UIUC CS125 FALL 2014 MP. File: CipherBreaker.java, CS125 Project: Challenge3-TopSecret, Version: 2015-09-20T21:55:13-0500.813115451
/**
 * See CipherBreaker.txt for instructions.
 * TODO: add your netid to the line below
 * 
 * @author jmgreen5
 */
public class CipherBreaker {

	public static void main(String[] args) {
		
		//int counter = 0;
		int digits = 0, punctuation = 0, spaces = 0;
		
		TextIO.putln("Text?");
		String line = TextIO.getln();
		TextIO.putln(line);
		line = line.toUpperCase();
		int lineLong = line.length();
		
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int[] numTimes = new int[26];
		
		
		
		for (int i = 0; i < lineLong; i++) {
			
			char c = line.charAt(i);
			int alphaIndex = alphabet.indexOf(c);
			
			if (alphaIndex >= 0) 
				numTimes[alphaIndex]++;
				else if (c >= '0' && c <= '9') {
					digits++;
				}
				else if (c == ' ') {
					spaces++;
				}
				else if (c == '"' || c == '-' || c == '\'' || c == '.' || c == '!' || c == ',') {
					punctuation++;
				}
		}
		
		for (int i = 0; i < numTimes.length; i++){
			
			if (numTimes[i] > 0) {
				TextIO.putln(alphabet.charAt(i) + ":" + numTimes[i]);
		}
		}
			if (digits > 0) {
				TextIO.putln("DIGITS:" + digits);
				}
			if (spaces > 0) {
				TextIO.putln("SPACES:" + spaces);
			}
			if (punctuation > 0) {
				TextIO.putln("PUNCTUATION:" + punctuation);
			}
}
}
