// Risk of Rain 2 Run Tracker
public class RunTracker {

    public static void main(String[] args) {
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
        printCatalog(catalog);
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
}

