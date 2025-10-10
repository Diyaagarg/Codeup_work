
/**
 * @Filename - MyString.java
 * @Description - This will perform all operations of string
 * @author - Diya Garg
 */

import java.util.Arrays;

public class MyString {

    // 1. Append
    public static void Append(String str1, String str2) {
        String newstr = str1.concat(str2);
        System.out.println("Appended string is " + newstr);
    }

    // 2. Count words
    public static int count(String str1) {
        int wordCount = 0;
        boolean isWord = false;

        for (int i = 0; i < str1.length(); i++) {
            char characters = str1.charAt(i);
            if (characters != ' ') {
                if (!isWord) {
                    wordCount++;
                    isWord = true;
                }
            } else {
                isWord = false;
            }
        }
        System.out.println("Total number of words: " + wordCount);
        return wordCount;
    }

    // 3. Replace
    public static void replace(String str1, String oldChar, String newChar) {
        String replacedStr = str1.replace(oldChar, newChar);
        System.out.println("Updated string: " + replacedStr);
    }

    // 4. Palindrome check
    public static void palindrome(String str1) {
        boolean isPalindrome = true;
        int i = 0, j = str1.length() - 1;

        while (i < j) {
            if (str1.charAt(i) != str1.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        if (isPalindrome)
            System.out.println("The string is a palindrome.");
        else
            System.out.println("The string is NOT a palindrome.");
    }

    // 5. Splice
    public static void splice(String str1, int start, int length) {
        if (start < 0 || start >= str1.length()) {
            System.out.println("Invalid start index!");
        } else if (length < 0 || start + length > str1.length()) {
            System.out.println("Invalid length!");
        } else {
            String spliced = str1.substring(0, start) + str1.substring(start + length);
            System.out.println("String after splicing: " + spliced);
        }
    }

    // 6. Split
    public static String[] split(String str1) {
        int n = count(str1);
        String[] arr = new String[n];

        int i = 0, index = 0;
        while (i < str1.length()) {
            while (i < str1.length() && str1.charAt(i) == ' ')
                i++;
            if (i >= str1.length())
                break;

            int j = i;
            while (j < str1.length() && str1.charAt(j) != ' ')
                j++;

            arr[index++] = str1.substring(i, j);
            i = j + 1;
        }

        return arr;
    }

    // 7. Max repeating character
    public static void maxRepeat(String str1) {
        int[] freq = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i)]++;
        }
        int max = -1;
        char result = ' ';
        for (int i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
                result = (char) i;
            }
        }
        System.out.println("Max repeating character is: " + result + " -> " + max + " times");
    }

    // 8. Sort
    public static String sortCharacters(String str1) {
        char[] chars = str1.replace(" ", "").toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // 9. Shift
    public static String shift(String str, int n) {
        int len = str.length();
        n = n % len;
        if (n < 0)
            n += len;
        return str.substring(len - n) + str.substring(0, len - n);
    }

    // 10. Reverse
    public static void reverse(String str1) {
        char[] arr = str1.toCharArray();
        int i = 0, j = arr.length - 1;

        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        String reversed = new String(arr);
        System.out.println("Reversed string: " + reversed);
    }
}
