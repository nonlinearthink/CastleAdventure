package SimpleGame;

enum Belong{armor, weapon, key}

public class Item {
    private String name;
    public Belong belong;

    public Item(String name, Belong belong){
        this.name = name;
        this.belong = belong;
    }

    @Override
    public String toString() {
        return name;
    }
}
