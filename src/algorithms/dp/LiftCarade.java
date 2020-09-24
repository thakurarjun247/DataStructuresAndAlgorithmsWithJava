package algorithms.dp;

import java.util.*;
import java.util.stream.Collectors;

/// <param name="A">weight of people</param>
/// <param name="B">floors they need to get down</param>
/// <param name="M">total floors in the building</param>
/// <param name="X">Max people to carry at a time</param>
/// <param name="Y">max weight to carry at a time</param>
/// <returns></returns>

public class LiftCarade {
    class Person {
        int weight;

        @Override
        public String toString() {
            return "weight: " + this.weight + " floor: " + this.floor;
        }

        public int getWeight() {
            return weight;
        }

        public int getFloor() {
            return floor;
        }

        int floor;

        Person() {
        }

        Person(int weight, int floor) {
            this.weight = weight;
            this.floor = floor;
        }
    }

    public int solution(int[] weight, int[] floor, int totalFloors, int maxPerson, int maxWeight) {
        Queue<Person> q = new LinkedList<>();

        for (int i = 0; i < weight.length; i++) {
            q.add(new Person(weight[i], floor[i]));
        }
        int numberOfFloors = 0;
        int weightInCurrentTrip = 0;
        int numberPersonInCurretTrip = 0;
        List<Person> pessengers = new ArrayList<Person>();
        //take people from q and insert in pessangers one by one
        while (!q.isEmpty()) {

            Person person = q.peek();
            while ((weightInCurrentTrip + person.weight) < maxWeight && numberPersonInCurretTrip < maxPerson) {
                pessengers.add(q.poll());
                weightInCurrentTrip += person.weight;
                numberPersonInCurretTrip++;
                if (q.isEmpty()) {
                    break;
                }
                person = q.peek();
            }

            Set<Integer> floors = new HashSet<>();
            floors = pessengers.stream().map(p -> p.getFloor()).collect(Collectors.toSet());
            Set<Integer> uniqueFloors = new HashSet<>(floors);
            numberOfFloors += uniqueFloors.size() + 1;
            floors.clear();
            uniqueFloors.clear();
            pessengers.clear();
            weightInCurrentTrip = 0;
            numberPersonInCurretTrip = 0;
        }

        return numberOfFloors;
    }
}
