The following class Vehicle, declares a protected variable name, inside package p1:
package p1;

public class Vehicle {
    protected String name;
}
Which of the following code(s) will give error?
  
  
A. 
package p1;

public class Car {
    void props() {
        Vehicle v = new Vehicle();
        v.name = "Vehicle 1st";      
    }
}



B. 
package p2;

class Car extends Vehicle {
    public static void main(String args[]) {
        Car c = new Car();
        c.name = "Ferrari";
    }
}



C. 
package p2;

import p1.Vehicle;
class Car {
    void props() {
        Vehicle v = new Vehicle();
        v.name = "BMW";
    }
}
