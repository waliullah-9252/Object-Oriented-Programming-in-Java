import java.util.Scanner;

public class evenOddCheck {
    public static void main(String[] args){
        Scanner inputNumebr = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = inputNumebr.nextInt();
        if(num%2==0){
            System.out.println(""+num+" is a even number.");
        }else{
            System.out.println(""+num+" is odd number.");
        }
        inputNumebr.close();
    }
}
