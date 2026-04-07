import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistUC9 {

    // Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    public static void main(String[] args) {

        // Step 1: Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 56));

        // Step 2: Convert to stream & group
        Map<String, List<Bogie>> grouped =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        // Step 3: Display grouped result
        System.out.println("Grouped Bogies:\n");

        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println("Type: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                System.out.println("  Capacity: " + b.getCapacity());
            }
            System.out.println();
        }

        // Step 4: Check original list unchanged
        System.out.println("Original List Size: " + bogies.size());
    }
}

