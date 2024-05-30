import java.util.Scanner;

// AgeOutOfRangeException as a public inner class
class AgeOutOfRangeException extends Exception {
    public AgeOutOfRangeException(int age) {
        super("You are older than the requested age (25 years), you are " + age + "!!!");
    }
}
// LowGpaException as a public inner class
class LowGpaException extends Exception {
    public LowGpaException() {
        super("Your GPA is not sufficient to apply for this job (2.5)");
    }
}
public class GPA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Prompt for age
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            
            // Check age and throw exception if necessary
            if (age > 25) {
                throw new AgeOutOfRangeException(age);
            }

            // Prompt for GPA
            System.out.print("Enter your GPA: ");
            double gpa = scanner.nextDouble();

            // Check GPA and throw exception if necessary
            if (gpa < 2.5) {
                throw new LowGpaException();
            }

            // If no exceptions are thrown, the application is accepted
            System.out.println("Your application is accepted and is under study");

        } catch (AgeOutOfRangeException e) {
            System.out.println(e.getMessage());
        } catch (LowGpaException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
