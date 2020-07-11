package util;

import java.util.Map;

public class Utilities {
	// Iterate over a map and print it out like
	// a python dictionary for debugging
	// @param Map<Object, Object> inputMap
	public static <T, G> void printMap(Map<T, G> inputMap, String mapName) {
		if (!mapName.isEmpty()) {
			System.out.print(mapName + " = ");
		}
		System.out.println("{");
		for (Map.Entry<T, G> entry : inputMap.entrySet()) {
			System.out.print("    ");
			System.out.print(entry.getKey());
			System.out.print(" : ");
			System.out.println(entry.getValue());
		}
		System.out.println("}");
	}

	public static <T, G> void printMap(Map<T, G> inputMap) {
		printMap(inputMap, "");
	}
}