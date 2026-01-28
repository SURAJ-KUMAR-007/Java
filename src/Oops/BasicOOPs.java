package Oops;

interface BicycleInterface{
    //by default all interface methods are implicitly public and abstract
    //So, the implementing methods in the class must also be public,
    // otherwise you're reducing their visibility — which is not allowed.
    void changeSpeed(int newValue);
    void changeCadence(int newValue);
    void changeGear(int newValue);
    void printState();
}
class Bicycle implements BicycleInterface {
    int speed=0;
    int cadence=0;
    int gear =1;

    public void changeSpeed(int newValue){
        speed=newValue;
    }
    public void changeCadence(int newValue){
        cadence=newValue;
    }
    public void changeGear(int newValue){
        gear= newValue;
    }
    public void printState(){
        System.out.println("speed   = " + speed  );
        System.out.println("cadence = " + cadence);
        System.out.println("gear = " + gear);
    }

}


class MountainBike extends Bicycle{
    boolean SpikyTyre = true;
    String durability = "medium";

    void changeIsSpikyType(boolean newValue){
        SpikyTyre=newValue;
    }
    void changeDurabilityType(String newValue){
        durability=newValue;
    }

    @Override
    public  void printState() {
        super.printState();
        System.out.println("SpikyTyre = " + SpikyTyre);
        System.out.println("durability = " + durability);
    }

}




public class BasicOOPs {

    public static void main(String[] args){
        Bicycle bike1 = new Bicycle();
        MountainBike mounBike = new MountainBike();

        bike1.changeCadence(2);
        bike1.changeSpeed(2);
        bike1.changeGear(3);
        bike1.printState();

        System.out.println();
        mounBike.changeCadence(2);
        mounBike.changeSpeed(2);
        mounBike.changeGear(3);
        mounBike.changeDurabilityType("high");
        mounBike.printState();
    }

}
