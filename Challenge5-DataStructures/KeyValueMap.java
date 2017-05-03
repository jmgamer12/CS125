//UIUC CS125 FALL 2014 MP. File: KeyValueMap.java, CS125 Project: Challenge5-DataStructures, Version: 2015-10-10T22:06:32-0500.566295472

/*
 * @author jmgreen5
 */
import java.awt.Color;

public class KeyValueMap { // aka Dictionary or Map

	private String[] keys = new String[0];
	private Color[] colors = new Color[0];

	/**
	 * Adds a key and value. If the key already exists, it replaces the original
	 * entry.
	 */
	public void add(String key, Color value) {
		// boolean found = false;
		for (int i = 0; i < keys.length; i++) {
			if (keys[i].equals(key)) {
				colors[i] = value;
				// found = true;
			}
		}

		String[] newKey = new String[keys.length + 1];
		for (int i = 0; i < keys.length; i++) {
			newKey[i] = keys[i];
		}
		newKey[keys.length] = key;
		keys = newKey;

		Color[] newColor = new Color[colors.length + 1];
		for (int i = 0; i < colors.length; i++) {
			newColor[i] = colors[i];
		}
		newColor[colors.length] = value;
		colors = newColor;
	}

	/**
	 * Returns particular Color object previously added to this map.
	 */
	public Color find(String key) {
		for (int i = 0; i < keys.length; i++) {
			if (key.equals(keys[i]))
				return colors[i];
		}
		return null;
	}

	/**
	 * Returns true if the key exists in this map.
	 */
	public boolean exists(String key) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i].equals(key))
				return true;
		}
		return false;
	}

	/**
	 * Removes the key (and the color) from this map.
	 */
	public void remove(String key) {
		if (exists(key)) {
			String[] newKey = new String[keys.length - 1];
			Color[] newColor = new Color[colors.length - 1];

			int index = -1;
			for (int i = 0; i < keys.length; i++) {
				if (keys[i].equals(key))
					index = i;
			}

			if (index > -1) {
				for (int i = 0; i < index; i++) {
					newKey[i] = keys[i];
					newColor[i] = colors[i];
				}

				for (int i = index + 1; i < keys.length; i++) {
					newKey[i - 1] = keys[i];
					newColor[i - 1] = colors[i];
				}
			}

			keys = newKey;
			colors = newColor;
		}
	}

}