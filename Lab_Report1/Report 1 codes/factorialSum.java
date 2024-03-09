import java.util.Scanner;

public class factorialSum {
    public static long calculateFact(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * calculateFact(num - 1);
        }
    }

    public static void main(String[] args) {
        Scanner inputNumebr = new Scanner(System.in);
        System.out.print("Enter a number X: ");
        int x = inputNumebr.nextInt();
        System.out.print("Enter a number N: ");
        int n = inputNumebr.nextInt();
        double result = 0;
        for (int i = 1; i <= n-1; i += 2) {
            double power = Math.pow(x, i + 1);
            long fact = calculateFact(i);
            result += (power / fact);
        }
        
        String formattedResult = String.format("%.2f", result);

        System.out.println("The Odd Factorail Series Answer is: " + formattedResult);

        inputNumebr.close();
    }
}
