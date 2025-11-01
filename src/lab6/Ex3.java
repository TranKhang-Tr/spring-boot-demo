package lab6;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Ex3 extends JFrame {
    private JTextArea inputTextArea;
    private JTextArea resultTextArea;

    public Ex3() {
    	// tên của của sổ hiển thị
        setTitle("String Manipulation App");
        // chiều dài 500px, chiều rông 300px
        setSize(500, 300);
        // kết thúc của sổ làm việc
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // TextArea for input
        // NORTH : vị trí hiển thị nhập dữ liệu vào
        inputTextArea = new JTextArea();
        add(inputTextArea, BorderLayout.NORTH);

        // TextArea for displaying results
        // vị trí trả ra kết quả của phương thức
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        add(resultTextArea, BorderLayout.CENTER);

        // Create buttons for methods
        JButton reverseButton = new JButton("Reverse String");
        JButton palindromeButton = new JButton("Check Palindrome");
        JButton exitButton = new JButton("Exit");
    }
    // 1. Reverse a string
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    // 2. Check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        String reversed = reverseString(str);
        return str.equalsIgnoreCase(reversed);
    }

    // 3. Count vowels and consonants
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    // 4. Find the largest word
    public static String largestWord(String str) {
        String[] words = str.split(" ");
        String largest = "";
        for (String word : words) {
            if (word.length() > largest.length()) {
                largest = word;
            }
        }
        return largest;
    }

    // 5. Check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : str1.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str2.toCharArray()) {
            if (!frequencyMap.containsKey(ch) || frequencyMap.get(ch) == 0) {
                return false;
            }
            frequencyMap.put(ch, frequencyMap.get(ch) - 1);
        }
        return true;
    }

    // 6. Remove all white spaces
    public static String removeSpaces(String str) {
        return str.replaceAll("\\s", "");
    }

    // 7. Find the second most frequent character
    public static char secondMostFrequentChar(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        int maxFrequency = 0, secondMaxFrequency = 0;
        char secondMostFreqChar = '\0'; // default value if there's no second most frequent char
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > maxFrequency) {
                secondMaxFrequency = maxFrequency;
                maxFrequency = frequency;
                secondMostFreqChar = entry.getKey();
            } else if (frequency > secondMaxFrequency && frequency != maxFrequency) {
                secondMaxFrequency = frequency;
                secondMostFreqChar = entry.getKey();
            }
        }
        return secondMostFreqChar;
    }

    // 8. Remove first and last character
    public static String removeFirstAndLast(String str) {
        if (str.length() <= 2) {
            return ""; // return empty string if length is less than or equal to 2
        }
        return str.substring(1, str.length() - 1);
    }

    // 9. Count number of words
    public static int countWords(String str) {
        String[] words = str.split("\\s+");
        return words.length;
    }

    // 10. Check if string contains only digits
    public static boolean containsOnlyDigits(String str) {
        return str.matches("[0-9]+");
    }

    // 11. Count number of vowels
    public static int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    // 12. Reverse a string without using reverse() method
    public static String reverseWithoutUsingReverse(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
        return new String(charArray);
    }

    // 13. Check if two strings are anagrams
    // Already implemented above as method number 5

    // 14. Remove all white spaces
    // Already implemented above as method number 6

    // 15. Capitalize first letter of each word
    public static String capitalizeFirstLetter(String str) {
        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1)).append(" ");
            }
        }
        return result.toString().trim();
    }

    // 16. Check if string is palindrome
    // Already implemented above as method number 2

    // 17. Return all possible substrings
    public static String allSubstrings(String str) {
        int n = str.length();
        int count = n * (n + 1) / 2;
        String[] substrings = new String[count];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                substrings[index++] = str.substring(i, j);
            }
        }
        return "substrings";
    }

    // 18. Return characters of string in reverse order
    // Already implemented above as method number 1

    // 19. Concatenate two strings
    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }

    // 20. Remove all special characters
    public static String removeSpecialCharacters(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }
}
