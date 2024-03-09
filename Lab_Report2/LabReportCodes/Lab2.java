
import java.util.Scanner;

// area calculate class created
class Area {
    double a, b, c, h, w, r, result;

    // traingle calculate constructor created
    Area(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // rectangle calculate constructor created
    Area(double h, double w) {
        this.h = h;
        this.w = w;
    }

    // circle calculate constructor created
    Area(double r) {
        this.r = r;
    }

    // traingle calculate method created
    double traingleCalculate() {
        result = (a + b + c) / 2;
        return Math.sqrt(result * (result - a) * (result - b) * (result - c));
    }

    // rectangle calculate method created
    double rectangleCalculate() {
        return h * w;
    }

    // circle calculate method created
    double circleCalculate() {
        return Math.PI * r * r;
    }

}

public class Lab2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter Your Spacific Case (Like traingle, rectangle, circle): ");
        String name = input.nextLine();

        switch (name) {
            case "traingle":
                // traingle value input
                System.out.println();
                System.out.println("Traingle Value Input");
                System.out.print("Input Value of a: ");
                int a = input.nextInt();
                System.out.print("Input Value of b: ");
                int b = input.nextInt();
                System.out.print("Input Value of c: ");
                int c = input.nextInt();
                Area trainangleObj = new Area(a, b, c);

                System.out.print("Traingle Value is: ");
                System.out.println(trainangleObj.traingleCalculate());
                break;
            case "rectangle":
                // rectangle value input
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
                // circle value input
                System.out.println();
                System.out.println("Circle Value Input");
                System.out.print("Input Value of Radius: ");
                int r = input.nextInt();
                Area circleObj = new Area(r);

                System.out.print("Circle Value is: ");
                System.out.println(circleObj.circleCalculate());
                break;

            default:
                System.out.println(
                        "This item is not found. Please try again and Exact value. You can write input line carefully!");
                break;
        }
        input.close();
    }
}