public class lab3 {
    public static void main(String[] args) {
        C c = new C();
        c.displayPublicA(); // Public method of A accessible
        // c.displayPrivateA(); // Error: displayPrivateA() has private access in A
        c.displayProtectedA(); // Protected method of A accessible
        c.displayDefaultA(); // Default method of A accessible

        c.displayPublicC(); // Public method of C accessible
        // c.displayPrivateC(); // Error: displayPrivateC() has private access in C
        c.displayProtectedC(); // Protected method of C accessible
        c.displayDefaultC(); // Default method of C accessible

        c.accessMethods(); // Accessing methods from A and B through C
    }
}



