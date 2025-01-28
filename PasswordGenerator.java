import java.util.Random;
import java.util.Scanner;
public class PasswordGenerator {
    // Creating a password generator
    public static String generatePassword(int length) {
        // The characters used in the password
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+<>?/";
        String allCharacters = upperCaseLetters + lowerCaseLetters + digits + specialCharacters;
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        // Atleast one character should be included from each category
        password.append(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));
        password.append(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
        for (int i = 4; i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }
        // Randomly shuffle the password
        char[] passwordArray = password.toString().toCharArray();
        for (int i = passwordArray.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[j];
            passwordArray[j] = temp;
        }
        return new String(passwordArray);
    }
    public static void main(String[] args) {
        // Create a scanner to get the length of the password from the user
        Scanner sc = new Scanner(System.in);
        // Get the length of the password from the user
        System.out.print("Enter the desired password length (minimum 8 characters): ");
        int length = sc.nextInt();
        // The length should be at least 8
        if (length < 8) {
            System.out.println("Password length must be at least 8 charactes");
        } else {
            String password = generatePassword(length);
            System.out.println("Generated Password: " + password);
        }
    }
}