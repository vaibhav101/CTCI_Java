// Is Unique: Implement an algorithm to determine if a string has all unique characters.
// Follow up: What if you cannot use additional data structures?
import java.util.Map;
import java.util.HashMap;


class Problem__1_1 {
	private static final int INITIAL_FREQ = 0;

	// O(n) time but also needs O(n) space
	boolean hasUniqueChars_1(String inputStr) {
		Map<Character, Integer> charFrequency = new HashMap<>();
		for (Character c : inputStr.toCharArray()) {
			int currentFrequency = charFrequency.getOrDefault(c, INITIAL_FREQ);
			charFrequency.put(c, currentFrequency+1);
		}
		
		for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
			if (entry.getValue() > 1) {
				return false;
			}
		}

		return true;
	}

	// Use a bit set to make auxillary space constant while maintaining O(n) time
	// Assumption: the string is ASCII and made up of only lowercase alphabets
	// TODO: A more generic solution may be implemented using a BitSet data structure
	boolean hasUniqueChars(String inputStr) {
		// If string has more than 256 characters, it cannot be unique (ASCII)
		if (inputStr.length() > 256) {
			return false;
		}

		int uniqueBitset = 0;
		for (int c : inputStr.toCharArray()) {
			int bitIndex = c - 'a';
			int bitMask = (1 << bitIndex);
			if ((uniqueBitset & bitMask) > 0) {
				return false;
			}
			uniqueBitset |= bitMask;
		}

		return true;
	}

	boolean test() {
		Map<String, Boolean> testInputs = new HashMap<>();
		testInputs.put("aa",       Boolean.FALSE);
		testInputs.put("bab",      Boolean.FALSE);
		testInputs.put("babzsasa", Boolean.FALSE);
		testInputs.put("",         Boolean.TRUE);
		testInputs.put("ab",       Boolean.TRUE);
		testInputs.put("a",        Boolean.TRUE);
		
		for (Map.Entry<String, Boolean> entry : testInputs.entrySet()) {
			String testInput = entry.getKey();
			Boolean expectedOutput = entry.getValue();
			Boolean actualOutput = hasUniqueChars(testInput);

			if (expectedOutput != actualOutput){
				throw new RuntimeException("For input '" + testInput + "' expected " + expectedOutput + " but got " + actualOutput);
			} else {
				System.out.println("Test passed for '" + testInput + "'");
			}
		}

		return true;
	}

	public static void main(String[] args) {
		new Problem__1_1().test();
		return;
	}
}