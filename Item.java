// One item from Risk of Rain 2, plus how many of it the player has picked up.
public class Item {
    String name;
    String rarity;   // Common, Uncommon, Legendary, Boss, or Lunar
    int stacks;      // how many copies the player is holding

    public Item(String name, String rarity) {
        this.name = name;
        this.rarity = rarity;
        this.stacks = 0;   // player starts the run with none
    }
}
