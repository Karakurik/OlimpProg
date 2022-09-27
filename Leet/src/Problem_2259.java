public class Problem_2259 {
    class Solution {
        public String removeDigit(String number, char digit) {
            int pos = 0;
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) == digit) {
                    pos = i;
                    if (i + 1 < number.length() && number.charAt(i) < number.charAt(i + 1)) {
                        break;
                    }
                }
            }
            return new StringBuilder(number).deleteCharAt(pos).toString();
        }
    }
}

// 2259. Remove Digit From Number to Maximize Result
