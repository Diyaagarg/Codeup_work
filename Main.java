import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter a String:");
            String str1 = sc.nextLine();

            System.out.println("\nChoices:");
            System.out.println(
                "1. Append a string \n2. Count words \n3. Replace \n4. Is palindrome \n5. Splice \n6. Split \n7. Max Repeating Character \n8. Sort \n9. Shift \n10. Reverse \n11. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter string to append: ");
                    String str2 = sc.nextLine();
                    MyString.Append(str1, str2);
                    break;

                case 2:
                    MyString.count(str1);
                    break;

                case 3:
                    System.out.print("Enter character to replace: ");
                    String oldChar = sc.next();
                    System.out.print("Enter new character: ");
                    String newChar = sc.next();
                    MyString.replace(str1, oldChar, newChar);
                    break;

                case 4:
                    MyString.palindrome(str1);
                    break;

                case 5:
                    System.out.print("Enter start index: ");
                    int start = sc.nextInt();
                    System.out.print("Enter length to splice: ");
                    int length = sc.nextInt();
                    MyString.splice(str1, start, length);
                    break;

                case 6:
                    String[] words = MyString.split(str1);
                    System.out.println("Split words:");
                    for (String word : words) {
                        System.out.println(word);
                    }
                    break;

                case 7:
                    MyString.maxRepeat(str1);
                    break;

                case 8:
                    String sorted = MyString.sortCharacters(str1);
                    System.out.println("Sorted string: " + sorted);
                    break;

                case 9:
                    System.out.print("Enter number of characters to shift: ");
                    int n = sc.nextInt();
                    String shifted = MyString.shift(str1, n);
                    System.out.println("Shifted string: " + shifted);
                    break;

                case 10:
                    MyString.reverse(str1);
                    break;

                case 11:
                    System.out.println("Exiting program.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
