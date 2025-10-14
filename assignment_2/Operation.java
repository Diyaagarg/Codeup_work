/**
 * @filename - Operation.java
 * @description - This file contains all functions related to string and number operations.
 * @author - Diya Garg 
 */


public class Operation {

    // 1. Count Unique Palindromes
    public static int countUniquePalindromes(String s) {
        String unique = "";
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expandAndCount(s, i, i, unique);
            count += expandAndCount(s, i, i + 1, unique);
        }
        return count;
    }

    private static int expandAndCount(String s, int left, int right, String unique) {
        int localCount = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            String sub = s.substring(left, right + 1);
            if (!unique.contains(sub + ",")) {
                unique += sub + ",";
                localCount++;
            }
            left--;
            right++;
        }
        return localCount;
    }

    // 2. Fibonacci Sequence – Nth Number
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    // 3. Snake Case to Camel Case Conversion
    public static String snakeToCamel(String str) {
        String[] parts = str.split("_");
        StringBuilder sb = new StringBuilder(parts[0]);
        for (int i = 1; i < parts.length; i++) {
            sb.append(parts[i].substring(0, 1).toUpperCase()).append(parts[i].substring(1));
        }
        return sb.toString();
    }

    // 4. Count Consonants in a String
    public static int countConsonants(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z' && "aeiou".indexOf(ch) == -1) {
                count++;
            }
        }
        return count;
    }

    // 5. Binary to Decimal Conversion 
    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            char ch = binary.charAt(i);
            if (ch == '1') {
                decimal += Math.pow(2, power);
            } else if (ch != '0') {
                throw new IllegalArgumentException("Invalid binary input");
            }
            power++;
        }
        return decimal;
    }

    // 6. Characters in a String 
    public static String expandCharacters(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i += 2) {
            char ch = str.charAt(i);
            int count = str.charAt(i + 1) - '0';
            for (int j = 0; j < count; j++) {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // 7. Character Frequency in a String 
    public static String charFrequency(String str) {
        str = str.toLowerCase();
        String result = "";
        boolean[] counted = new boolean[str.length()];

        for (int i = 0; i < str.length(); i++) {
            if (counted[i]) continue;
            char ch = str.charAt(i);
            int count = 1;

            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    count++;
                    counted[j] = true;
                }
            }
            result += ch + "" + count;
        }
        return result;
    }

    // 8. Prime Number Checker
    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    // 9. Number to Words Converter
    private static final String[] belowTwenty = {"", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"};

    public static String numberToWords(int num) {
        if (num == 0)
            return "zero";
        return helper(num).trim();
    }

    private static String helper(int num) {
        if (num < 20)
            return belowTwenty[num];
        else if (num < 100)
            return tens[num / 10] + (num % 10 != 0 ? " " + belowTwenty[num % 10] : "");
        else if (num < 1000)
            return belowTwenty[num / 100] + " hundred" + (num % 100 != 0 ? " " + helper(num % 100) : "");
        else
            return String.valueOf(num);
    }

    // 10. Longest Substring Without Repeating Characters 
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            String sub = "";
            for (int j = i; j < s.length(); j++) {
                if (sub.contains(s.charAt(j) + "")) {
                    break;
                }
                sub += s.charAt(j);
            }
            if (sub.length() > maxLen) {
                maxLen = sub.length();
            }
        }
        return maxLen;
    }
}
