import java.util.Random;

// Part B.2: times RunTracker.countByRarity on a small array and a much larger one.
public class TimingTest {

    public static void main(String[] args) {
        Item[] small = buildRandomInventory(10000);
        Item[] large = buildRandomInventory(1000000);

        long start = System.nanoTime();
        RunTracker.countByRarity(small, "Legendary");
        long smallTime = System.nanoTime() - start;

        start = System.nanoTime();
        RunTracker.countByRarity(large, "Legendary");
        long largeTime = System.nanoTime() - start;

        System.out.println("n = 10,000:    " + smallTime + " ns");
        System.out.println("n = 1,000,000: " + largeTime + " ns");
    }

    // Makes an array of random items so we can test with any size we want.
    public static Item[] buildRandomInventory(int size) {
        String[] names = {"Soldier's Syringe", "Ukulele", "57 Leaf Clover", "Titanic Knurl", "Shaped Glass"};
        String[] rarities = {"Common", "Uncommon", "Legendary", "Boss", "Lunar"};
        Random rand = new Random();

        Item[] items = new Item[size];
        for (int i = 0; i < size; i++) {
            int pick = rand.nextInt(names.length);
            items[i] = new Item(names[pick], rarities[pick]);
            items[i].stacks = rand.nextInt(5) + 1;   // 1 to 5 stacks
        }
        return items;
    }
}
