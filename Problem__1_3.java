/*
 *  Write a method to replace all spaces in a string with '%20'. 
 *  You may assume that the string has sufficient space at the end to hold the additional characters,
 *  and that you are given the "true" length of the string. (Note: If implementing in Java,
 *  please use a character array so that you can perform this operation in place.)
 * 
 *  EXAMPLE
 *  Input: "Mr John Smith    ", 13
 *  Output: "Mr%20John%20Smith"
*/

class Problem__1_3 {
    private static final char SPACE = ' ';
    private static final char PERCENT = '%';
    private static final char TWO = '2';
    private static final char ZERO = '0';

    public String urlify(String inputString, Integer strLength) {
        char[] charArray = inputString.toCharArray();

        final Integer arrayLength = charArray.length;
        
        Integer spaces = arrayLength - strLength;

        for (int i = strLength-1; i >= 0; --i) {
            if (charArray[i] == SPACE) {
                spaces = spaces - 2;
                charArray[i+spaces] = PERCENT;
                charArray[i+spaces+1] = TWO;
                charArray[i+spaces+2] = ZERO;
            } else {
               charArray[i+spaces] = charArray[i];
            }
        }

        return new String(charArray);
    }

    public void test() {
        assert urlify("Mr John Smith    ", 13).equals("Mr%20John%20Smith") : "john smith failed " + urlify("Mr John Smith    ", 13);
    }

    public static void main(String[] args) {
        new Problem__1_3().test();
    }
}
