import java.util.PriorityQueue;
import java.util.Random;

public class ToyStore {
    private static PriorityQueue<Toy> toyQueue = new PriorityQueue<>();
    private static FileWriterUtil fileWriterUtil = new FileWriterUtil("output.txt");

    public static void main(String[] args) {
        put("конструктор 20");
        put("робот 20");
        put("кукла 60");

        for (int i = 0; i < 10; i++) {
            String result = get();
            System.out.println("Get result: " + result);
            fileWriterUtil.writeToFile(result);
        }
    }

    private static void put(String input) {
        String[] parts = input.split(" ");
        String name = parts[0];
        int frequency = Integer.parseInt(parts[1]);

        Toy toy = new Toy(name, name, frequency);
        toyQueue.add(toy);
    }

    private static String get() {
        Random random = new Random();
        int randomValue = random.nextInt(100) + 1;

        Toy selectedToy = null;
        int cumulativeFrequency = 0;

        for (Toy toy : toyQueue) {
            cumulativeFrequency += toy.frequency;
            if (randomValue <= cumulativeFrequency) {
                selectedToy = toy;
                break;
            }
        }

        return selectedToy != null ? selectedToy.name : "Error";
    }
}