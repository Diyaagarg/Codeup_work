/**
 * @filename - MainOperation.java
 * @description - This is the main file which contains the main function 
 * and a menu to call different functions of the Operation class.
 * @author - Diya Garg 
 */

import java.util.*;

public class MainOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Count Unique Palindromes");
            System.out.println("2. Fibonacci Sequence – Nth Number");
            System.out.println("3. Snake Case to Camel Case Conversion");
            System.out.println("4. Count Consonants in a String");
            System.out.println("5. Binary to Decimal Conversion");
            System.out.println("6. Expand Characters in a String");
            System.out.println("7. Character Frequency in a String");
            System.out.println("8. Prime Number Checker");
            System.out.println("9. Number to Words Converter");
            System.out.println("10. Longest Substring Without Repeating Characters");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice! Please enter a valid number between 1 and 11.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter a string: ");
                    String str1 = sc.nextLine();
                    System.out.println("Unique Palindromes Count: " + Operation.countUniquePalindromes(str1));
                    break;

                case 2:
                    System.out.print("Enter N: ");
                    int n = sc.nextInt();
                    System.out.println("Fibonacci Number: " + Operation.fibonacci(n));
                    break;

                case 3:
                    System.out.print("Enter snake_case string: ");
                    String snake = sc.nextLine();
                    System.out.println("Camel Case: " + Operation.snakeToCamel(snake));
                    break;

                case 4:
                    System.out.print("Enter a string: ");
                    String str4 = sc.nextLine();
                    System.out.println("Consonant Count: " + Operation.countConsonants(str4));
                    break;

                case 5:
                    System.out.print("Enter binary string: ");
                    String binary = sc.nextLine();
                    System.out.println("Decimal Value: " + Operation.binaryToDecimal(binary));
                    break;

                case 6:
                    System.out.print("Enter character+digit string (e.g. a1b4c3): ");
                    String expand = sc.nextLine();
                    System.out.println("Expanded String: " + Operation.expandCharacters(expand));
                    break;

                case 7:
                    System.out.print("Enter a string: ");
                    String freqStr = sc.nextLine();
                    System.out.println("Character Frequency: " + Operation.charFrequency(freqStr));
                    break;

                case 8:
                    System.out.print("Enter a number: ");
                    int num = sc.nextInt();
                    if (Operation.isPrime(num))
                        System.out.println("The given number is PRIME");
                    else
                        System.out.println("The given number is NOT prime");
                    break;

                case 9:
                    System.out.print("Enter an integer: ");
                    int number = sc.nextInt();
                    System.out.println("In Words: " + Operation.numberToWords(number));
                    break;

                case 10:
                    System.out.print("Enter a string: ");
                    String s = sc.nextLine();
                    System.out.println("Length of Longest Substring Without Repeating Characters: " +
                            Operation.lengthOfLongestSubstring(s));
                    break;

                case 11:
                    System.out.println("Exiting the program. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option between 1 and 11.");
            }

        } while (choice != 11);

        sc.close();
    }
}
