//UIUC CS125 FALL 2014 MP. File: Stack.java, CS125 Project: Challenge5-DataStructures, Version: 2015-10-10T22:06:32-0500.566295472
/*
 * 
 * @author jmgreen5
 * 
 */
public class Stack {
	/** Adds a value to the top of the stack.*/
	String[] stack = new String[0];
	
	public void push(String value){
		//throw new RuntimeException("Elevator stuck. Abort Retry Fail?");
		String[] stackTwo = new String[stack.length + 1];
		stackTwo[0] = value;
		for (int i = 0; i < stack.length; i++) {
			stackTwo[i + 1] = stack[i];
		}
		stack = stackTwo;
	}
	
	/** Removes the topmost string. If the stack is empty, returns null. */
	public String pop() {
		if(isEmpty()) {
			return null;
		}
		else {
			String top = stack[0];
			String[] stackTwo = new String[stack.length - 1];
			for(int i = 0; i < stackTwo.length; i++) {
				stackTwo[i] = stack[i + 1];
			}
			stack = stackTwo;
			return top;
		}
		//throw new RuntimeException("Ones and Zeros. Mostly.");
	}
	
	/** Returns the topmost string but does not remove it. If the stack is empty, returns null. */
	public String peek() {
		if(isEmpty()) {
			return null;
		}
		else {
			return stack[0];
		}
		//throw new RuntimeException("Don't peek. It's too scary");
	}
	
	/** Returns true iff the stack is empty */
	public boolean isEmpty() {
		return stack.length == 0;
		//throw new RuntimeException("Need more");
	}

	/** Returns the number of items in the stack. */
	public int length() {
		return stack.length;
		//throw new RuntimeException("Must be relative");
	}
	
	/** Returns a string representation of the stack. Each string is separated by a newline. Returns an empty string if the stack is empty. */
	public String toString() {
		String result = "";
		if (stack.length > 0) {
			for (int i = 0; i < stack.length; i++) {
				result = stack[i] + "\n" + result;
			}
		}
		return result;
		//throw new RuntimeException("Rope is thicker but String is quicker");
	}
}
