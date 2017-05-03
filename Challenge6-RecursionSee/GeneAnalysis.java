//UIUC CS125 FALL 2014 MP. File: GeneAnalysis.java, CS125 Project: Challenge6-RecursionSee, Version: 2015-10-26T21:29:19-0500.299404275
/**
 * @author jmgreen5
 *
 */
public class GeneAnalysis
{
	/** Wrapper method. Returns the length of the longest 
	 * common subsequence
	 */
	public static int score(String gene1, String gene2)
	{
		char[] c = gene1.toCharArray();
		char[] g = gene2.toCharArray();
		return score(c, g, c.length, g.length);
		// Hint: Use toCharArray() to convert each string to a char array.
		 // call your recursive implementation here with
		// the genes as char arrays, starting at the end of each gene.
	}

	private static int score(char[] c, char[] g, int length, int length2) {
		
		if (length == 0 || length2 == 0)
			return 0;
		if(length == 1 && length2 == 1)
			if(c[length - 1] == g[length2 - 1])
				return 1;
			else
				return 0;
		else {
			int score1 = score(c, g, length - 1, length2);
			int score2 = score(c, g, length, length2 - 1);
			int score3 = score(c, g, length - 1, length2 -1);
			int score4 = 0;
			
			if (c[length - 1] == g[length2 - 1])
				score4 = score(c, g, length - 1, length2 - 1)+ 1;
			int max1 = Math.max(score1, score2);
			int max2 = Math.max(score3,  score4);
			return Math.max(max1, max2);
		}
	}

	/** Implements longest common subsequence recursive search
The recursive case is defined as
					S(i-1, j)
S(i,j) = max {		S(i,j-1)
					S(i-1,j-1)
					S(i-1,j-1) +1 if gene1[i] = gene2[j]

NB  0<=i < gene1.length
    0<=j < gene2.length

You need to figure out the base case.
	 * */
//	define a private recursive Class method 'score' that 
//	returns an integer the score.
//	The method should take four parameters- 
//	two char arrays and two integers (gene1,gene2,i,j)
//	i and j are the indices into gene1 and gene2 respectively.

}
// Use local variables to store a recursive result so that you  do not need to calculate it again.

// Do not use a loops.
