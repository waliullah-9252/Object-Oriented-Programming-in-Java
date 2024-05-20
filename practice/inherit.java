
class Animal{
    public void eat(){
        System.out.println("I can Eat");
    }
}

class Dog extends Animal{
    public Dog(){
        super();
        System.out.println("I am a Dog");
    }
    @Override
    public void eat(){
        super.eat();
        System.out.println("I eat dog food");
    }
    
    public void bark(){
        System.out.println("I can bark");
    }
}

class inherit {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.eat();
        dog1.bark();
    }
}