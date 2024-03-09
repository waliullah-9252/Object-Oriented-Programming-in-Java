import java.util.Scanner;

public class lab2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter Your Specific Case (Like triangle, rectangle, circle): ");
        String name = input.nextLine();

        switch (name) {
            case "triangle":
                System.out.println();
                System.out.println("Triangle Value Input");
                System.out.print("Input Value of a: ");
                int a = input.nextInt();
                System.out.print("Input Value of b: ");
                int b = input.nextInt();
                System.out.print("Input Value of c: ");
                int c = input.nextInt();
                Area triangleObj = new Area(a, b, c);

                System.out.print("Triangle Value is: ");
                System.out.println(triangleObj.traingleCalculate());
                break;
            case "rectangle":
                System.out.println();
                System.out.println("Rectangle Value Input");
                System.out.print("Input Value of Height: ");
                int h = input.nextInt();
                System.out.print("Input Value of Width: ");
                int w = input.nextInt();
                Area rectangleObj = new Area(h, w);

                System.out.print("Rectangle Value is: ");
                System.out.println(rectangleObj.rectangleCalculate());
                break;
            case "circle":
                System.out.println();
                System.out.println("Circle Value Input");
                System.out.print("Input Value of Radius: ");
                int r = input.nextInt();
                Area circleObj = new Area(r);

                System.out.print("Circle Value is: ");
                System.out.println(circleObj.circleCalculate());
                break;

            default:
                System.out.println("This item is not found. Please try again and enter the exact value.");
                break;
        }
        input.close();
    }
}
