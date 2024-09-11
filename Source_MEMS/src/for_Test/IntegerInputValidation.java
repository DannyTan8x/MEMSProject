package for_Test;

import java.util.Scanner;
import java.util.regex.Pattern;

public class IntegerInputValidation {

    public static void main(String[] args) {
        // Create a scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Define the RegEx pattern for integer validation
        String integerPattern = "^-?\\d+$";  // Matches positive and negative integers

        // Create the pattern object
        Pattern pattern = Pattern.compile(integerPattern);

        // Prompt the user for input
        System.out.print("Please enter an integer: ");
        String userInput = scanner.nextLine();

        // Validate input using regex
        if (pattern.matcher(userInput).matches()) {
            // Input is a valid integer
            System.out.println("Valid integer input: " + userInput);
        } else {
            // Input is not a valid integer
            System.out.println("Invalid input. Please enter a valid integer.");
        }

        // Close the scanner
        scanner.close();
    }
}
