// Given two strings,write a method to decide if one is a permutation of the other.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import util.Utilities;

class Problem__1_2 {

	// Implementation 1: Sort the strings and check if they
	// are the same. Time O(nlogn)
	boolean isPermutation(String firstStr, String secondStr) {
		char[] firstStrChars = firstStr.toCharArray();
		char[] secondStrChars = secondStr.toCharArray();

		Arrays.sort(firstStrChars);
		Arrays.sort(secondStrChars);

		if (Arrays.equals(firstStrChars, secondStrChars)) {
			return true;
		} 
			
		return false;
	}

	// Implementation 2: Get frequency distribution of both
	// the strings and find if it's equal.
	// Time: O(n) Space O(n)
	boolean isPermutation2(String firstStr, String secondStr) {
		Map<Character, Integer> firstStrFreq = getFrequencyMap(firstStr);
		Map<Character, Integer> secondStrFreq = getFrequencyMap(secondStr);

		for (Map.Entry<Character, Integer> mapEntry : firstStrFreq.entrySet()) {
			Character compareKey = mapEntry.getKey();

			if (secondStrFreq.getOrDefault(compareKey, 0) != mapEntry.getValue()) {
				return false;
			}
		}

		return true;
	}

	// Implementation 3: A more specific version of 2
	// Assume that all characters are ASCII characters
	// Create an integer array of size = 256
	// Put frequencies of all characters in it
	// Compare both the arrays
	// Boom: O(n) solution with constant extra space
	// I wont even implement this


	Map<Character, Integer> getFrequencyMap(String str) {
		Map<Character, Integer> frequencyMap = new HashMap<>();

		for (Character c : str.toCharArray()) {
			int currentFreq = frequencyMap.getOrDefault(c, 0);
			frequencyMap.put(c, currentFreq + 1);
		}

		return frequencyMap;
	}

	void test() {
		assert isPermutation2("aa", "ab") == false : "aa ab";
		assert isPermutation2("aa", "bb") == false : "aa bb";
		assert isPermutation2("ab", "ba") == true : "ab ba";

		System.out.println("Tests passed");
	}

	public static void main(String[] args){
		new Problem__1_2().test();
	}
}