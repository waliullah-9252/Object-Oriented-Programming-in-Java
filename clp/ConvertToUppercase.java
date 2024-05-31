import java.util.Scanner;

public class ConvertToUppercase {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of characters to convert: ");
    int numChars = scanner.nextInt();

    System.out.print("Enter " + numChars + " characters: ");
    String userInput = scanner.next();

    // Convert to uppercase 
    String convertedString = userInput.toUpperCase();

    System.out.println("Converted characters: " + convertedString);

    scanner.close();
  }
}

