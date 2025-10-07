import java.util.Arrays;
import java.util.Scanner;

public class MyString {

    // 1. Append 
    public static void Append(String str1, String str2) {

        String newstr = str1.concat(str2);
        System.out.println("Apppended string is " + newstr);
    }

    // 2. count word 
   public static int count(String str1) {
        int wordCount = 0;
        boolean isWord = false;

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);

            if (ch != ' ') {
                if (!isWord) {
                    wordCount++;
                    isWord = true; 
                }
            } else {
                isWord = false; 
            }
        }
        System.out.println("Total number of words: " + wordCount);
          return wordCount ;
        
    }
    //  3. replace 
public static void replace(String str1 , String oldChar, String newChar) {
        

         String replacedStr = str1.replace(oldChar, newChar);

        System.out.println("Updated string: " + replacedStr);
            
         }

    //  4. isPalindrome
        public static void palindrome(String str1){
         boolean isPalindrome = true;

        // Compare characters from both ends
        int i = 0;
        int j = str1.length() - 1;

        while (i < j) {
            if (str1.charAt(i) != str1.charAt(j)) {
                isPalindrome = false;  
                break;
            }
            i++;
            j--;
        }

        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }
        }

    // 5. splice 
        public static void splice(String str1,int start , int length){
       if (start < 0 || start >= str1.length()) {
            System.out.println("Invalid start index!");
        } else if (length < 0 || start + length > str1.length()) {
            System.out.println("Invalid length!");
        } else {
            String spliced = str1.substring(0, start) + str1.substring(start + length);

            System.out.println("String after splicing: " + spliced);
        }
        }

    // 6. split 
          
        public static String[] split(String str1) {
        int n = count(str1); // 
        String[] arr = new String[n];

        int i = 0;
        int index = 0;

        while (i < str1.length()) {
            // skip spaces
            while (i < str1.length() && str1.charAt(i) == ' ') i++;
            if (i >= str1.length()) break;

            int j = i;
            while (j < str1.length() && str1.charAt(j) != ' ') j++;

            arr[index++] = str1.substring(i, j);
            i = j + 1;
        }

        return arr;
    }


        // 7. maxRepeat
      public static void maxRepeat(String str1)
    {
        int[] freq = new int[256];
        for(int i=0;i<str1.length();i++){
            freq[str1.charAt(i)]++;
        }
        int max= -1;
        char result = ' ';
        for(int i=0;i<256;i++){
            if(freq[i]>max){
                max=freq[i];
                result = (char) i;
            }
        }
         System.out.println("Max repeating character is : "+result +" -> "+max+" times");
    }

    // 8. sort 
    public static String sortCharacters(String str1) {
    
    char[] chars = str1.replace(" ", "").toCharArray();  
    Arrays.sort(chars); 
    return new String(chars);
}


    // 9. shift 
    public static String shift(String str, int n) {
    int len = str.length();
    n = n % len;          
    if (n < 0) n += len;
    return str.substring(len - n) + str.substring(0, len - n);
}


    // 10. reverse
     public static void reverse(String str1) {
        char[] arr = str1.toCharArray(); // 
        int i = 0;
        int j = str1.length() - 1;

        while (i < j) {
            // swap arr[i] and arr[j]
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
    

// main function

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
        sc.nextLine(); 

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
