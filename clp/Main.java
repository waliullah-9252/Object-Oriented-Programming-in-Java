
class Box {
    protected double length;
    protected double breadth;

    public Box() {
        this.length = 0;
        this.breadth = 0;
    }

    public Box(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void setDimensions(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double getArea() {
        return length * breadth;
    }
}

class Box3D extends Box {
    private double height;

    public Box3D() {
        super();
        this.height = 0;
    }

    public Box3D(double length, double breadth, double height) {
        super(length, breadth);
        this.height = height;
    }

    public void setDimensions(double length, double breadth, double height) {
        super.setDimensions(length, breadth);
        this.height = height;
    }

    public double getVolume() {
        return length * breadth * height;
    }
}

public class Main {
    public static void main(String[] args) {
        Box box = new Box(10, 5);
        System.out.println("Area of Box: " + box.getArea());

        Box3D box3d = new Box3D(10, 5, 8);
        System.out.println("Area of Box3D: " + box3d.getArea());
        System.out.println("Volume of Box3D: " + box3d.getVolume());
    }
}
