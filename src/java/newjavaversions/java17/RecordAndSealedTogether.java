package java.newjavaversions.java17;

public class RecordAndSealedTogether {


        public static void main(String[] args) {
            Vehicle car = new Car("ABC123");
            Vehicle truck = new Truck("DEF456");

            System.out.println(car.getRegistrationNumber()); // "ABC123"
            System.out.println(truck.getRegistrationNumber()); // "DEF456"
        }


}
 sealed interface Vehicle permits Car, Truck {
    String getRegistrationNumber();
}

 record Car(String registrationNumber) implements Vehicle {
    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

 record Truck(String registrationNumber) implements Vehicle {
    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
