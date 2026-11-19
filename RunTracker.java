import java.util.Scanner;

// Risk of Rain 2 Run Tracker
// The player logs the items they picked up during a run, and the program
// reports how many items of each rarity they have.
public class RunTracker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // every item the player can pick from (plain array, no ArrayList)
        Item[] catalog = {
            new Item("Soldier's Syringe", "Common"),
            new Item("Tougher Times", "Common"),
            new Item("Lens-Maker's Glasses", "Common"),
            new Item("Bustling Fungus", "Common"),
            new Item("Ukulele", "Uncommon"),
            new Item("AtG Missile Mk. 1", "Uncommon"),
            new Item("Hopoo Feather", "Uncommon"),
            new Item("57 Leaf Clover", "Legendary"),
            new Item("Brilliant Behemoth", "Legendary"),
            new Item("Titanic Knurl", "Boss"),
            new Item("Shaped Glass", "Lunar")
        };

        System.out.println("=== Risk of Rain 2 Run Tracker ===");
        System.out.print("How many items did you pick up this run? ");
        int pickups = input.nextInt();

        printCatalog(catalog);

        // keep asking until we have logged every pickup
        int logged = 0;
        while (logged < pickups) {
            System.out.print("Item #" + (logged + 1) + " (enter 1-" + catalog.length + "): ");
            int choice = input.nextInt();

            if (choice >= 1 && choice <= catalog.length) {
                catalog[choice - 1].stacks++;
                logged++;
            } else {
                System.out.println("That is not an item number, try again.");
            }
        }

        printSummary(catalog);
        input.close();
    }

    // Adds up the stacks of every item with the given rarity.
    // Loops over the whole array, so the time grows with the array's size.
    // (This is the method timed in Part B.2.)
    public static int countByRarity(Item[] items, String rarity) {
        int total = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].rarity.equals(rarity)) {
                total += items[i].stacks;
            }
        }
        return total;
    }

    // Prints the numbered list of items the player can choose from.
    public static void printCatalog(Item[] items) {
        System.out.println();
        System.out.println("Item list:");
        for (int i = 0; i < items.length; i++) {
            System.out.println("  " + (i + 1) + ". " + items[i].name + " (" + items[i].rarity + ")");
        }
        System.out.println();
    }

    // Prints the end-of-run report.
    public static void printSummary(Item[] items) {
        String[] rarities = {"Common", "Uncommon", "Legendary", "Boss", "Lunar"};

        System.out.println();
        System.out.println("=== End of Run Summary ===");

        System.out.println("Items held:");
        for (int i = 0; i < items.length; i++) {
            if (items[i].stacks > 0) {
                System.out.println("  " + items[i].name + " x" + items[i].stacks);
            }
        }

        System.out.println("By rarity:");
        for (int r = 0; r < rarities.length; r++) {
            int count = countByRarity(items, rarities[r]);
            System.out.println("  " + rarities[r] + ": " + count);
        }
    }
}
