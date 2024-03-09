
public class Area {
    double a, b, c, h, w, r, result;

    public Area(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Area(double h, double w) {
        this.h = h;
        this.w = w;
    }

    public Area(double r) {
        this.r = r;
    }

    public double traingleCalculate() {
        result = (a + b + c) / 2;
        return Math.sqrt(result * (result - a) * (result - b) * (result - c));
    }

    public double rectangleCalculate() {
        return h * w;
    }

    public double circleCalculate() {
        return Math.PI * r * r;
    }
}

