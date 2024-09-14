public class Inheritance {
    public static void main(String[] args) {
        
        Ambulance ambulance = new Ambulance("Boat Ambulance", "White", 93, 600);
        ambulance.move();
        ambulance.pickUpAPatient();
        ambulance.dropOffAPatient();

        FireTruck truck = new FireTruck("Isuzu NKR", "red and white", 110, 130);
        truck.move(truck.speed);
        truck.displayDetails();
        truck.housesAreBurning();
        truck.turnOnSiren();
        truck.waterThrowing();

        Taxi taxi = new Taxi ("Airport Taxi", "Blue", 200, 70);
        taxi.move(taxi.speed);
        taxi.pickUpPassengers();
        taxi.droppedOffPassengers();
    }
}
//mother class
class Vehicle {  
    int speed, fuel;
    String color, brand;
   
    public void move(){
        System.out.println("The " + brand + " is moving so patiently");
    }  
    public void stop(){ 
        System.out.println(brand + " Stopped" );   
    }
    public void fuel(){ 
        System.out.println("Fuel: "+ fuel +" liters ");    
    }
    public void displayDetails(){ 
        System.out.println("brand: " + brand + "\ncolor: " + color + "\nspeed: " + speed + "\nfuel: " + fuel);
    }

}
//sub classs
class Ambulance extends Vehicle {
        boolean sirensAreOn = false; //unique attributes
        int numPatient = 0;

        Ambulance(String brand, String color, int speed, int fuel) {
            this.brand = brand;
            this.color = color;
            this.speed = speed;
            this.fuel = fuel;
        } //override
        public void move(){
            System.out.println("The " + brand + " is moving fast to hostipal");  
        }//unique methods
        void pickUpAPatient() {
            numPatient = numPatient + 1;
                System.out.println("\nPatient has been added");
            turnOnSiren();
        }   
        void dropOffAPatient() {
            if (numPatient == 0)
                System.out.println("No patient to be dropped off");
            else {
                numPatient -= 1;
                System.out.println("Patient has been dropped off");
                System.out.println("\n==========================\n");
            }
        }
        void turnOnSiren() {
            sirensAreOn = true;
                System.out.println("Siren On");
        }

}
//sub class
class FireTruck extends Vehicle {
        boolean sirensAreOn = false; //unique attributes
        boolean waterPump = false;
        boolean emergency = false;
        FireTruck(String brand, String color, int speed, int fuel) {
            this.brand = brand;
            this.color = color;
            this.speed = speed;
            this.fuel = fuel;
        } //overload
        public void move (int speed) {
            if (speed <= 15 && speed >= 1 )
               System.out.println(brand+" is moving slow.");
            else if (speed >= 16 && speed <= 59)
               System.out.println(brand+" is moving average.");
            else if (speed >= 60)
               System.out.println(brand+" is moving fast.");
            else
               System.out.println(brand+" is not moving.");
         } //overide
        public void stop (){
            System.out.println("The " + brand + " Stopped and started to the water pump!");
        } //unique Methods
        void waterThrowing(){ 
            if(sirensAreOn){
                stop();
                System.out.println("Water pumping!");
                System.out.println("\n==========================\n");
            }
        }
        void turnOnSiren() {
            if(emergency){
                sirensAreOn = true;
                System.out.println("Siren on");
            }
        }
        void housesAreBurning(){
            emergency = true;
                System.out.println("\nThere's an emergency");
        }
}
//sub class
class Taxi extends Vehicle {
        int numPassenger = 0; //unique attributes
        boolean taxAreOn = false;

        Taxi(String brand, String color, int speed, int fuel) {
        this.brand = brand;
        this.color = color;
        this.speed = speed;
        this.fuel = fuel;
    } 
        void pickUpPassengers(){ //unique methods
            numPassenger = numPassenger + 1;
            System.out.println("\nPassenger has been added");
            taxesAdded();
       }
    
        void taxesAdded(){
            taxAreOn = true;
                System.out.println("Tax started");
       }
        void droppedOffPassengers(){
                System.out.println("Passenger has been dropped off");
                System.out.println("Passenger paid the taxed");
        }//overload
        public void move (int speed) {
            if (speed <= 15 && speed >= 1 )
               System.out.println(brand+" is moving slow.");
            else if (speed >= 16 && speed <= 59)
               System.out.println(brand+" is moving average.");
            else if (speed >= 60)
               System.out.println(brand+" is moving fast.");
            else
               System.out.println(brand+" is not moving.");
         }
    
}