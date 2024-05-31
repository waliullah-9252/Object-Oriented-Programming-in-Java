import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    
    public static void main(String[] args) {
        guessTheNumber();
    }

    public static void guessTheNumber() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean guessed = false;
        int attempts = 0;
        
        int secretNumber = random.nextInt(15) + 1; 
        
        System.out.println("Welcome to the number guessing game!");
        System.out.println("I have selected a random number between 1 and 15. Try to guess it!");

        while (!guessed) {
            System.out.print("Please enter your guess number: ");
            int guess = scanner.nextInt();
            attempts++;
            
            if (guess < secretNumber) {
                System.out.println("Your guess number is low! Please try again!");
            } else if (guess > secretNumber) {
                System.out.println("Your guess number is high! Please try again!");
            } else {
                guessed = true;
                System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
            }
        }
        
        System.out.print("Do you want to play again? (y/n): ");
        String playAgain = scanner.next();
        
        if (playAgain.equalsIgnoreCase("y")) {
            guessTheNumber();
        } else {
            System.out.println("Thanks for playing!");
            scanner.close();
        }
    }
}
