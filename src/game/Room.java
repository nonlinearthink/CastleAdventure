//: game/Room.java
package game;

import java.util.HashMap;

/**
 * @author Jaycee Zhou
 */
enum Status {closed, open, bossRoom}

/**
 * @author www.icourse163.org/course/ZJU-1001542001
 * @author Jaycee Zhou
 */
public class Room {

    private String description;
    private HashMap<String, Room> exits = new HashMap<String, Room>();
    private Status status;
    private Item hideItem;

    /**
     * Destructor of Room Class
     * @param description Description of the room
     * @param status Current room status: closed, open, bossRoom
     */
    Room(String description, Status status) {
        this.description = description;
        this.status = status;
    }

    /**
     * Set Exit
     * @param dir a string of direction from last room
     * @param room Next room
     */
    public void setExit(String dir, Room room) {
        exits.put(dir, room);
    }

    /**
     * get a status of room
     * @return closed, open, bossRoom
     */
    public Status seeStatus() {
        return status;
    }

    /**
     * Set a status of room
     * @param status closed, open, bossRoom
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Print room
     * @return A formated String by room
     */
    @Override
    public String toString() {
        return description;
    }

    /**
     * Description of room exit
     * @return a string of exit
     */
    public String getExitDesc() {
        StringBuffer sb = new StringBuffer();
        for (String dir : exits.keySet()) {
            sb.append(dir);
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * Get Exit
     * @param direction a String of direction
     * @return next Room
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    /**
     * Set Item
     * @param name Item's name
     * @param belong item: armor, weapon, key
     */
    public void setItem(String name, Belong belong) {
        hideItem = new Item(name, belong);
    }

    /**
     * erase Item
     * @return the Item should be erased
     */
    public Item eraseItem() {
        Item temp = hideItem;
        hideItem = null;
        return temp;
    }

}
