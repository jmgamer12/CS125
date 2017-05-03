//UIUC CS125 FALL 2014 MP. File: Queue.java, CS125 Project: Challenge5-DataStructures, Version: 2015-10-10T22:06:32-0500.566295472
/*
 * 
 * @author jmgreen5
 * 
 */

public class Queue {
	/** Adds the value to the front of the queue.
	 * Note the queue automatically resizes as more items are added. */
	
	private double[] queue = new double[0];
	
	public void add(double value) {
		
		double[] queueTwo = new double[queue.length + 1];
		queueTwo[0] = value;
		for (int i = 0; i < queue.length; i++) {
			queueTwo[i + 1] = queue[i];
		}
		queue = queueTwo;
		//throw new RuntimeException("Don't step on the cracks");
	}
	/** Removes the value from the end of the queue. If the queue is empty, returns 0 */
	public double remove() {
		if(queue.length == 0) {
			return 0.0;
		}
		else {
			
			double endOfQueue =  queue[queue.length - 1];
			double[] queueTwo = new double[queue.length - 1];
			
			for (int i = 0; i < queueTwo.length; i++) {
				queueTwo[i] = queue[i];
			}
			queue = queueTwo;
			return endOfQueue;
		}
		//throw new RuntimeException("Grilled Cheese");
	}
	
	/** Returns the number of items in the queue. */
	public int length() {
		return queue.length;
		//throw new RuntimeException("I am not a number; I am free man.");		
	}
	
	/** Returns true iff the queue is empty */
	public boolean isEmpty() {
		return queue.length == 0;
		//throw new RuntimeException("The butler did it");
	}
	
	/** Returns a comma separated string representation of the queue. */
	public String toString() {
		
		String result = "";
		result = result + queue[queue.length-1];
		if (queue.length > 0) {
			for (int i = queue.length - 2; i > -1; i--) {
				result = result + "," + queue[i];
			}
		}
		return result;
		//throw new RuntimeException("Daisy daisy daisy");
	}
}
