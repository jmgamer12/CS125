//UIUC CS125 FALL 2014 MP. File: RobotLink.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2015-11-17T19:16:54-0600.231687838

// @author jmgreen5

public class RobotLink {

	private RobotLink next; 	
	private final Robot robot;

	public Robot getRobot() {
		return robot;
	}
	/** Constructs this link.
	 * @param next ; the next item in the chain (null, if there are no more items).
	 * @param robot ; a single robot (never null).
	 */
	public RobotLink(RobotLink next,Robot robot) {
		this.robot = robot;
		this.next = next;
	}

	/**
	 * Returns the number of entries in the linked list.
	 * @return number of entries.
	 */
	public int count() {
		if (next == null)
			return 1; // BASE CASE; no more recursion required!

		// Recursive case:
		return 1 + next.count();
	}
	/**
	 * Counts the number of flying robots in the linked list.
	 * Hint: robot.isFlying is useful here.
	 */
	public int countFlyingRobots() {
		if (next == null)
			if (robot.isFlying())
				return 1;
			else 
				return 0;
		else {
			if (robot.isFlying())
				return 1 + next.countFlyingRobots();
			else
				return next.countFlyingRobots();
		}
		
	}
	/**
	 * Counts the number of flying robots up to and excluding a sad robot.
	 * (i.e. do not count the sad robot if it is flying).
	 * If there are no sad robots this function will return the same value as countFlyingRobots().
	 * Hint: robot.isHappy() is useful.
	 */
	public int countFlyingRobotsBeforeSadRobot() {
		if (next == null)
			if (robot.isFlying() && robot.isHappy())
				return 1;
			else
				return 0;
		else {
			if (!robot.isHappy())
				return 0;
			if (robot.isFlying())
				return 1 + next.countFlyingRobotsBeforeSadRobot();
			else
				return next.countFlyingRobotsBeforeSadRobot();
		}
	}
	/** Creates a new LinkedList entry at the end of this linked list.
	 * Recursively finds the last entry then adds a new link to the end.
	 * @param robot - the robot value of the new last link
	 */
	public void append(Robot robot) {
		if (next == null)
			next = new RobotLink(null, robot);
		else
			next.append(robot);
		
	}
	/**
	 * Returns the first flying unhappy robot, or null
	 * if there are not robots that are flying and unhappy.
	 * @return
	 */
	public Robot getFirstFlyingUnhappyRobot() {
		if (next == null)
			if (robot.isFlying() && !robot.isHappy())
				return robot;
			else
				return null;
		else {
			if (!robot.isHappy() && robot.isFlying())
				return robot;
			else
				return next.getFirstFlyingUnhappyRobot();
		}
	}
	/**
	 * Returns the last flying unhappy robot in the linked list, or null
	 * if there are not robots that are flying and unhappy.
	 * @return
	 */
	public Robot getLastFlyingUnhappyRobot() {
		if (next == null)
			if (robot.isFlying() && !robot.isHappy())
				return robot;
			else
				return null;
		else {
			if (next.getLastFlyingUnhappyRobot() != null)
				return next.getLastFlyingUnhappyRobot();
			if (!robot.isHappy() && robot.isFlying())
				return robot;
			return null;
		}
	}
	/**
	 * Returns a reference to the happy most distant explorer.
	 * Returns null if there are no happy robots
	 * @return reference to the most distant happy robot
	 */
	public Robot findHappyRobotFurthestFromHome() {
			if (next == null)
				if (robot.isHappy())
					return robot;
				else
					return null;
			else {
				double distance = robot.getDistanceFromHome();
				if (distance > next.findHappyRobotFurthestFromHome().getDistanceFromHome())
					return robot;
				else
					return next.findHappyRobotFurthestFromHome();
			}
	}
	/**
	 * Returns true if linked list contains the robot.
	 * Hint: Use robot.equals(other).
	 * @param robot
	 * @return
	 */
	public boolean contains(Robot other) {
		if (robot.equals(other))
			return true;
		if (next == null)
			return false;
		return next.contains(other);
	}

	
}
