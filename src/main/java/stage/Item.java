//: game/Item.java
package stage;

/**
 * @author Jaycee Zhou
 */
enum Belong {armor, weapon, key}

/**
 * @author Jaycee Zhou
 */
public class Item {

    private String name;
    public Belong belong;

    /**
     * Destructor of Item Class
     * @param name Name of this item
     * @param belong The category of this item: armor, weapon, key
     */
    public Item(String name, Belong belong) {
        this.name = name;
        this.belong = belong;
    }

    /**
     * Print Item
     * @return A formated String by Item
     */
    @Override
    public String toString() {
        return name;
    }

}
