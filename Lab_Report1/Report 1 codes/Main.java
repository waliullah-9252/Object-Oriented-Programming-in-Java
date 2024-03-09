
/* Prime number generation code in java */
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner inputNumber = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = inputNumber.nextInt();
        if(num%2==0){
            System.out.println(""+num+" is Even Number !");
        }
        else{
            System.out.println(""+num+" is odd Number!");
        }
        inputNumber.close();
    }
}