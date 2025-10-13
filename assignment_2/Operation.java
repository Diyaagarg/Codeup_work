/**
 * @filename - Operation.java
 * @description - This is the  file which contains the all functions
 * related to string and number operations.
 * @author - Diya Garg 
 */


import java.util.*;

public class Operation {

    // 1. Count Unique Palindromes

    public static int countUniquePalindromes(String s) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            
            expandAroundCenter(s, i, i, set);
        
            expandAroundCenter(s, i, i + 1, set);
        }
        return set.size();
    }

    private static void expandAroundCenter(String s, int left, int right, HashSet<String> set) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            set.add(s.substring(left, right + 1));
            left--;
            right++;
        }
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
        return Integer.parseInt(binary, 2);
    }

    // 6. Characters in a String (Expanding Characters)
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
        StringBuilder result = new StringBuilder();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            result.append(entry.getKey()).append(entry.getValue());
        }
        return result.toString();
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
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
