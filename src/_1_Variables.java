public class _1_Variables {

    // 🔹 Class Variable (Static Field)
    static int totalBicycles = 0;

    // 🔹 Instance Variables (Non-Static Fields)
    int speed;
    int gear;

    // 🔸 Constructor with Parameters
    public _1_Variables(int speed, int gear) {
        // 🔸 Parameters used to initialize instance variables
        this.speed = speed;
        this.gear = gear;

        // Modifying class variable (shared across all instances)
        totalBicycles++;
    }

    public void displayInfo() {
        // 🔸 Local Variable
        String info = "Speed: " + speed + ", Gear: " + gear;

        // Print local variable
        System.out.println(info);

        // Access class variable
        System.out.println("Total Bicycles: " + totalBicycles);
    }

    public static void main(String[] args) {
        _1_Variables bike1 = new _1_Variables(10, 2);
        _1_Variables bike2 = new _1_Variables(15, 3);

        bike1.displayInfo();
        bike2.displayInfo();
    }
}
