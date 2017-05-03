//UIUC CS125 FALL 2014 MP. File: CaesarCipher.java, CS125 Project: Challenge3-TopSecret, Version: 2015-09-20T21:55:13-0500.813115451
/**
 * A program to search for to encrypt and decrypt lines of text. See
 * CaesarCipher.txt
 * Hints: line.charAt( int ) is useful.
 * You'll need loops, and conditions and variables
 * You'll need to read the Test cases to understand how your program should work.
 * Good Programming Hints: "DRY: Don't Repeat Yourself"
 * Try to make your program as short as possible.
 * TODO: add your netid to the line below
 * @author jmgreen5
 */
public class CaesarCipher {

	public static void main(String[] strings) {
		//TODO: Delete the following line and write your implementation here- 
		
		boolean done = true;
		int offset = 0;
		String sourceText;
		int i;
		int encrypter;
		char c;
		
		TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
		offset = TextIO.getlnInt();
		
		while (offset < -25 || offset == 0 || offset > 25) {
			if (offset == 999 || offset == -999)
				break;
			TextIO.putln(offset + " is not a valid shift value.");
			TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
			offset = TextIO.getlnInt();
		}
		
		if (offset == 999 || offset == -999)
			TextIO.putln("Using position shift");
		else
			TextIO.putln("Using shift value of " + offset);
		
		do {
			TextIO.putln("Please enter the source text (empty line to quit)");
			sourceText = TextIO.getln();
			if (sourceText.isEmpty()) {
				TextIO.putln("Bye.");
				break;
			} 
			else {
				TextIO.putln("Source   :" + sourceText);
				sourceText = sourceText.toUpperCase();
				TextIO.put("Processed:");
				
				if (offset == 999) {
					i = 0;
					while (i <= sourceText.length() - 1) {
						c = sourceText.charAt(i);
						if (!Character.isLetter(c) || Character.isSpace(c)) {
							TextIO.put(c);
						} else if (c > 'A' || c < 'Z') {
							int letter = c - 'A';
							encrypter = (i + letter) % 26;
							c = (char) ('A' + encrypter);
							TextIO.put(c);
						}
						i++;
					}
				}
				else if (offset == -999) {
					i = 0;
					while (i <= sourceText.length() - 1) {
						c = sourceText.charAt(i);
						if (!Character.isLetter(c) || Character.isSpace(c)) {
							TextIO.put(c);
				} else if (c > 'A' || c < 'Z') {
					int letter = c - 'A';
					if (((letter - i) + 'A') < 'A') {
						int crap = letter - i;
						while (true) {
							crap += 26;
							if (crap >= 0 && crap <= 26) {
								break;
							}
						}
						c = (char) ('A' + crap);
						TextIO.put(c);
					}
					else {
						encrypter = (letter - i) % 26;
						c = (char) ('A' + encrypter);
						TextIO.put(c);
					}
				}
					i++;
				}
					}
					else 
					{
						i=0;
						while (i <= sourceText.length()-1)
						{
							c = sourceText.charAt(i);
							if(!Character.isLetter(c) || Character.isSpace(c))
							{
								TextIO.put(c);
							}
							else if (c > 'A' || c < 'Z')
							{
								int letter = c - 'A';
								if ((offset + letter + 'A') < 'A')
								{
									encrypter = (offset + letter) % 26;
									c = (char)('A' + encrypter);
									int newshift = Math.abs(c - 'A');
									c = (char)('Z' - newshift + 1);
									TextIO.put(c);
								}
								else 
								{
									encrypter = (offset + letter) % 26;
									c = (char) ('A' + encrypter);
									TextIO.put(c);	
								}
							}
							i++;
						}
					}
					TextIO.putln();
				}
		}while (done);
	}	
}
		/*
		TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
		int offset = TextIO.getlnInt();
		
		while (offset < -25 || offset > 25 || offset == 0) {
			if (offset == 999 || offset == -999)
				break;
			else
				TextIO.putln(offset + " is not a valid shift value.\nPlease enter the shift value (between -25..-1 and 1..25)");
				offset = TextIO.getlnInt();
		}
		if (offset == 999 || offset == -999)
			TextIO.putln("Using position shift");
		else
			TextIO.putln("Using shift value of " + offset);
		//TextIO.putln("Using shift value of " + offset);
		boolean finished = false;
		String sourceText = "";
		
		do {
			TextIO.putln("Please enter the source text (empty line to quit)");
			sourceText = TextIO.getln();
			if (sourceText.isEmpty() == true) {
				TextIO.putln("Bye.");
				break;
			}
			char shift[] = new char[sourceText.length()];
			shift = sourceText.toCharArray();
			finished = false;
			while (!finished) {
				if (sourceText.equals(""))
					break;
				TextIO.putln("Source   :" + sourceText);
				sourceText = sourceText.toUpperCase();
				
				for (int i = 0; i < shift.length; i++) {
					shift[i] = Character.toUpperCase(shift[i]);
					if (shift[i] <= 'Z' && shift[i] >= 'A') {
						if (shift[i] + offset > (int)'Z') {
							shift[i] = (char) ((int) ((shift[i] - 65 + offset) % 26) + 65);
						} else if (shift[i] + offset < (int) 'A') {
							shift[i] = (char) (91 - ((int) ((shift[i] - 65 + offset) * -1) % 26));
						} else {
							shift[i] = (char) ((int) shift[i] + offset);
						}
					}
				}
				String out = new String(shift);
				TextIO.putln("Processed:" + out);
				finished = true;	
			}			
		} while (finished);
			}
}*/
			
			