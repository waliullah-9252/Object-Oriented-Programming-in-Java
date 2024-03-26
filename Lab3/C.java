// Class C inherits from both A and B
public class C extends A{
    private B b = new B(); // Composition of B in C

    public void displayPublicC() {
        System.out.println("Public method of class C");
    }

    // private void displayPrivateC() {
    //     System.out.println("Private method of class C");
    // }

    protected void displayProtectedC() {
        System.out.println("Protected method of class C");
    }

    void displayDefaultC() {
        System.out.println("Default method of class C");
    }

    // Method to access methods from A and B
    public void accessMethods() {
        displayPublicA(); // Accessing public method of A
        // displayPrivateA(); // Error: displayPrivateA() has private access in A
        displayProtectedA(); // Accessing protected method of A
        displayDefaultA(); // Accessing default method of A

        b.displayPublicB(); // Accessing public method of B through composition
        // b.displayPrivateB(); // Error: displayPrivateB() has private access in B
        b.displayProtectedB(); // Accessing protected method of B
        b.displayDefaultB(); // Accessing default method of B
    }

}
