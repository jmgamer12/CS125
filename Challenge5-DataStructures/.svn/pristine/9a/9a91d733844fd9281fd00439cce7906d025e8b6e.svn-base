 //UIUC CS125 FALL 2014 MP. File: UsingPublicFieldsIsEasy.java, CS125 Project: Challenge5-DataStructures, Version: 2015-10-10T22:06:32-0500.566295472

/**
 * Complete the class method 'analyze' that takes a SimplePublicPair object as an argument
 * and returns a new SimplePublicTriple object.
 * The SimplePublicTriple needs to set up as follows:
 * x = the minimum value of 'a' and 'b'
 * y = the maximum value of 'a' and 'b'
 * description:a*b=M 
 *   where a,b, and M are replaced with the numerical values of a, b and the multiplication of a and b.
 * Your code will create a SimplePublicTriple, initializes the three fields and return a reference to the SimplePublicTriple object.
 *
 *@author jmgreen5
 */
public class UsingPublicFieldsIsEasy {
	
	
	public static SimplePublicTriple analyze(SimplePublicPair in) {
		int x;
		int y;
		int M = in.a * in.b;
		
		if (in.a < in.b) {
			x = in.a;
			y = in.b;
		}
		else {
			x = in.b;
			y = in.a;
		}
		
		SimplePublicTriple newObject = new SimplePublicTriple();
		newObject.x = x;
		newObject.y = y;
		newObject.description = in.a + "*" + in.b + "=" + M;
		
		return newObject;
	}
}
