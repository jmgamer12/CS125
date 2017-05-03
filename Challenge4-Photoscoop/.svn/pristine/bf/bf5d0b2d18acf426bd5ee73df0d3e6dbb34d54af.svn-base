//UIUC CS125 FALL 2014 MP. File: PlayListUtil.java, CS125 Project: Challenge4-Photoscoop, Version: 2015-09-28T09:02:11-0500.685752155
/**
 * 
 * @author jmgreen5
 *
 */
public class PlayListUtil {

	/**
	 * Debug ME! Use the unit tests to reverse engineer how this method should
	 * work. Hint: Fix the formatting (shift-cmd-F) to help debug the following
	 * code
	 * 
	 * @param list
	 * @param maximum
	 */
	public static void list(String[] list, int maximum) {
		if (maximum == -1) {
			int newMax = list.length;
			for (int i = 0; i < newMax; i++) {
				int j = i + 1;
				TextIO.putln("" + j + ". " + list[i]);
			}
		}
		else {
			for (int k = 0 ; k < maximum; k++) {
				int p = k + 1;
				TextIO.putln("" + p + ". " + list[k]);
			}
		}
	}

	/**
	 * Appends or prepends the title
	 * 
	 * @param list
	 * @param title
	 * @param prepend
	 *            if true, prepend the title otherwise append the title
	 * @return a new list with the title prepended or appended to the original
	 *         list
	 */
	public static String[] add(String[] list, String title, boolean prepend) {
		String[] newList = new String[list.length + 1];
		if (prepend) {
			newList[0] = title;
			for (int i = 0; i < list.length; i++)
				newList[i + 1] = list[i];
		} else {
			for (int i = 0; i < list.length; i++)
				newList[i] = list[i];
			newList[newList.length - 1] = title;
		}
		return newList;
	}

	/**
	 * Returns a new list with the element at index removed.
	 * 
	 * @param list
	 *            the original list
	 * @param index
	 *            the array index to remove.
	 * @return a new list with the String at position 'index', absent.
	 */
	public static String[] discard(String[] list, int index) {
		String[] newList = new String[list.length - 1];
		if (index > -1 && index < list.length) {
			for (int i = 0; i < index; i++)
				newList[i] = list[i];
			for (int i = index + 1; i < list.length; i++)
				newList[i - 1] = list[i];
			return newList;
		} else
			return list;

	}
}
