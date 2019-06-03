package SimpleGame;

import java.util.HashMap;

enum Status{closed, open}

public class Room {
    private String description;
    private HashMap<String, Room> exits = new HashMap<String, Room>();
    protected Status status;
    private Item hideItem;
    protected boolean bossRoom = false;

    Room(String description, Status status, boolean bossRoom) {
        this.description = description;
        this.status = status;
        this.bossRoom = bossRoom;
    }

    Room(String description, Status status){
        this.description = description;
        this.status = status;
    }

    public void setExit(String dir, Room room) {
        exits.put(dir, room);
    }

    @Override
    public String toString() {
        return description;
    }

    public String getExitDesc() {
        StringBuffer sb = new StringBuffer();
        for (String dir : exits.keySet()) {
            sb.append(dir);
            sb.append(" ");
        }
        return sb.toString();
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void setItem(String name, Belong belong){
        hideItem = new Item(name, belong);
    }

    public Item eraseItem(){
        Item temp = hideItem;
        hideItem = null;
        return temp;
    }
}
