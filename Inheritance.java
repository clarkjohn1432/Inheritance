package Tapales;
public class Inheritance {
    public static void main(String[] args) {
        
        // Create an instance of Ambulance with specific attributes
        Ambulance ambulance = new Ambulance("Boat Ambulance", "White", 93, 600);
        ambulance.move(); // Calls the overridden move method of Ambulance
        ambulance.pickUpAPatient(); // Adds a patient and turns on the siren
        ambulance.dropOffAPatient(); // Drops off a patient and prints a message

        // Create an instance of FireTruck with specific attributes
        FireTruck truck = new FireTruck("Isuzu NKR", "red and white", 110, 130);
        truck.move(truck.speed); // Calls the overloaded move method of FireTruck
        truck.displayDetails(); // Calls the method from Vehicle to display details
        truck.housesAreBurning(); // Sets the emergency status and turns on the siren
        truck.turnOnSiren(); // Turns on the siren if there is an emergency
        truck.waterThrowing(); // Pumps water if the siren is on

        // Create an instance of Taxi with specific attributes
        Taxi taxi = new Taxi("Airport Taxi", "Blue", 200, 70);
        taxi.move(taxi.speed); // Calls the overloaded move method of Taxi
        taxi.pickUpPassengers(); // Adds a passenger and starts the taximeter
        taxi.droppedOffPassengers(); // Drops off a passenger and prints a message
    }
}

// Parent class for all vehicle types
class Vehicle {  
    int speed, fuel;
    String color, brand;
   
    // Method to simulate vehicle movement
    public void move(){
        System.out.println("The " + brand + " is moving so patiently");
    }  
    
    // Method to simulate vehicle stopping
    public void stop(){ 
        System.out.println(brand + " Stopped");   
    }
    
    // Method to display the fuel level
    public void fuel(){ 
        System.out.println("Fuel: "+ fuel +" liters");    
    }
    
    // Method to display vehicle details
    public void displayDetails(){ 
        System.out.println("brand: " + brand + "\ncolor: " + color + "\nspeed: " + speed + "\nfuel: " + fuel);
    }
}

// Subclass representing an ambulance vehicle
class Ambulance extends Vehicle {
    boolean sirensAreOn = false; // Unique attribute for ambulance sirens
    int numPatient = 0; // Number of patients currently in the ambulance

    // Constructor for Ambulance class
    Ambulance(String brand, String color, int speed, int fuel) {
        this.brand = brand;
        this.color = color;
        this.speed = speed;
        this.fuel = fuel;
    } 

    // Overridden move method for Ambulance
    public void move(){
        System.out.println("The " + brand + " is moving fast to hospital");  
    }

    // Method to pick up a patient
    void pickUpAPatient() {
        numPatient = numPatient + 1;
        System.out.println("\nPatient has been added");
        turnOnSiren(); // Turn on the siren when a patient is picked up
    }   

    // Method to drop off a patient
    void dropOffAPatient() {
        if (numPatient == 0)
            System.out.println("No patient to be dropped off");
        else {
            numPatient -= 1;
            System.out.println("Patient has been dropped off");
            System.out.println("\n==========================\n");
        }
    }

    // Method to turn on the siren
    void turnOnSiren() {
        sirensAreOn = true;
        System.out.println("Siren On");
    }
}

// Subclass representing a fire truck vehicle
class FireTruck extends Vehicle {
    boolean sirensAreOn = false; // Unique attribute for fire truck sirens
    boolean waterPump = false; // Attribute to indicate if the water pump is on
    boolean emergency = false; // Attribute to indicate if there is an emergency

    // Constructor for FireTruck class
    FireTruck(String brand, String color, int speed, int fuel) {
        this.brand = brand;
        this.color = color;
        this.speed = speed;
        this.fuel = fuel;
    } 

    // Overloaded move method for FireTruck with speed parameter
    public void move (int speed) {
        if (speed <= 15 && speed >= 1 )
            System.out.println(brand + " is moving slow.");
        else if (speed >= 16 && speed <= 59)
            System.out.println(brand + " is moving average.");
        else if (speed >= 60)
            System.out.println(brand + " is moving fast.");
        else
            System.out.println(brand + " is not moving.");
    } 

    // Overridden stop method for FireTruck
    public void stop (){
        System.out.println("The " + brand + " Stopped and started to the water pump!");
    } 

    // Method to simulate water throwing
    void waterThrowing(){ 
        if(sirensAreOn){
            stop(); // Calls the stop method when water is thrown
            System.out.println("Water pumping!");
            System.out.println("\n==========================\n");
        }
    }

    // Method to turn on the siren based on emergency status
    void turnOnSiren() {
        if(emergency){
            sirensAreOn = true;
            System.out.println("Siren on");
        }
    }

    // Method to simulate an emergency
    void housesAreBurning(){
        emergency = true;
        System.out.println("\nThere's an emergency");
    }
}

// Subclass representing a taxi vehicle
class Taxi extends Vehicle {
    int numPassenger = 0; // Number of passengers in the taxi
    boolean taxAreOn = false; // Attribute to indicate if the taximeter is on

    // Constructor for Taxi class
    Taxi(String brand, String color, int speed, int fuel) {
        this.brand = brand;
        this.color = color;
        this.speed = speed;
        this.fuel = fuel;
    } 

    // Method to pick up passengers
    void pickUpPassengers(){ 
        numPassenger = numPassenger + 1;
        System.out.println("\nPassenger has been added");
        taxesAdded(); // Start the taximeter when a passenger is picked up
    }

    // Method to start the taximeter
    void taxesAdded(){
        taxAreOn = true;
        System.out.println("Tax started");
    }

    // Method to drop off passengers
    void droppedOffPassengers(){
        System.out.println("Passenger has been dropped off");
        System.out.println("Passenger paid the taxed");
    }

    // Overloaded move method for Taxi with speed parameter
    public void move (int speed) {
        if (speed <= 15 && speed >= 1 )
            System.out.println(brand + " is moving slow.");
        else if (speed >= 16 && speed <= 59)
            System.out.println(brand + " is moving average.");
        else if (speed >= 60)
            System.out.println(brand + " is moving fast.");
        else
            System.out.println(brand + " is not moving.");
    }
}
