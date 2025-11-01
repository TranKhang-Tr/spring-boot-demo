package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex1 extends JFrame {
    private JTextArea inputTextArea;
    private JTextArea resultTextArea;

    public Ex1() {
    	setLayout(new BorderLayout());
    	// tên của của sổ hiển thị
        setTitle("String Manipulation App");
        // chiều dài 500px, chiều rông 300px
        setSize(500,300);
        //
        setLocationRelativeTo(null);
        // kết thúc của sổ làm việc
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
        setBackground(Color.BLUE);

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
        JButton countVowelsAndConsonants = new JButton("Vowels and consonants");
        JButton largestWord = new JButton("largestWord");
        JButton exitButton = new JButton("Exit");

        // Add action listeners to buttons
        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputTextArea.getText();
                String reversed = reverseString(input);
                resultTextArea.setText("Reversed string: " + reversed);
            }
        });
        // add2
        palindromeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputTextArea.getText();
                boolean isPalindrome = checkPalindrome(input);
                resultTextArea.setText("Palindrome: " + isPalindrome);
            }
        });
        //add3
        countVowelsAndConsonants.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String input = inputTextArea.getText();
				String countVowelsAndConsonants = countVowelsAndConsonants(input);
				resultTextArea.setText(""+countVowelsAndConsonants);
				
			}
        //add4
        });
        largestWord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String input = inputTextArea.getText();
				String largestWord = largestWord(input);
				resultTextArea.setText("largestWord: "+largestWord);
			}
        	
        });
        // add exit
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add buttons to the frame: tạo nút và vị trị hiện trên màng hình
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(reverseButton);
        buttonPanel.add(palindromeButton);
        buttonPanel.add(countVowelsAndConsonants);
        buttonPanel.add(largestWord);
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Method to reverse a string: đảo ngược chuỗi
    private String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    // Method to check if a string is a palindrome: 
    // xem chuôi dảo ngược với chuổi ban đầu có giống nhau không
    // relaceAll("[^a-zA-Z]", ""): loại bỏ tất cả các ký tự khôn phải là chữ cái
    // to LowerCase(): chuyển đổi tất cả các kí tự trong chuỗi thành chữ thường
    private boolean checkPalindrome(String input) {
        String cleanInput = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return cleanInput.equals(reverseString(cleanInput));
    }
    
    // Methord to count vowels and consonants
    private String countVowelsAndConsonants(String input) {
        int vowels = 0, consonants = 0;
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
//        System.out.println("Vowels: " + vowels);
        return "Vowels: "+vowels+" and "+
//        System.out.println("Consonants: " + consonants);
         "Consonants: "+consonants;
    }
    // 4. Find the largest word
    private String largestWord(String input) {
        String[] words = input.split(" ");
        String largest = "";
        for (String word : words) {
            if (word.length() > largest.length()) {
                largest = word;
            }
        }
        return largest;
    }
    // viết hàm main 
    //SwingUtilities.invokeLater(...) đặt mã bên trong nó vào hàng đợi sự kiện của EDT
    //() -> { ... } là một biểu thức lambda (lambda expression) đại diện cho phương thức run() của giao diện Runnable
    // app.setVisible(true);: Đặt trạng thái hiển thị của cửa sổ app thành true, cho phép nó hiển thị trên màn hình
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ex1 app = new Ex1();
            app.setVisible(true);
        });
    }
}
