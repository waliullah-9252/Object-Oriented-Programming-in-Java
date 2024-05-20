// create a interface for isEmergency
interface isEmergency{
    void soundSiren();
}

// create a class fireEmergency and implements isEmergency interface
class fireEmergency implements isEmergency{
    public void soundSiren(){
        System.out.println("Siren sound!");
    }
}

// create a smokeAlarm class with no implementation and empty body
class smokeAlarm{

}

public class myInterface {
    public static void main(String[] args) { 
        Object[] myArray = new Object[4];

        // Construct 2 SmokeAlarm objects and add to the array      
        for (int i = 0; i < 2; i++) {
            myArray[i] = new smokeAlarm();
        }
    
        // Construct 2 FireEmergency objects and add to the array
        for (int i = 2; i < 4; i++) {
            myArray[i] = new fireEmergency();
        }
        
         
         // Loop through the array to identify instances of IsEmergency and call soundSiren method
         for (Object element : myArray) {
            if (element instanceof isEmergency) {
                System.out.println(element.getClass().getName() + " can sound siren");
                ((isEmergency) element).soundSiren();
            }
        }
    }
}
