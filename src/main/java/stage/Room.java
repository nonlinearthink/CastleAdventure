//: game/Room.java
package stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Jaycee Zhou
 */
enum Status {closed, open, bossRoom, reenter, outSide}

/**
 * @author www.icourse163.org/course/ZJU-1001542001
 * @author Jaycee Zhou
 */
public class Room {

    private String description;
    private HashMap<String, Room> exits = new HashMap<String, Room>();
    private Status status;
    private Item hideItem;
    private String Script;

    /**
     * Read file as script
     */
    private void readFileByLine() {
        File file = new File("././text/"+Script);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String Line = null;
            while ((Line = reader.readLine()) != null) {
                System.out.println(Line);
                try {
                    Thread.currentThread();
                    Thread.sleep(2000);
                } catch (Exception e) {
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     * Destructor of Room Class
     *
     * @param description Description of the room
     * @param status      Current room status: closed, open, bossRoom, reenter, outSide
     */
    Room(String description, Status status ,String Script) {
        this.description = description;
        this.status = status;
        this.Script = Script;
    }

    /**
     * run sricpt
     */
    public void runSript() {
        if(status == Status.outSide)
            System.out.println("The air is so fresh.");
        else if(status != Status.reenter)
            readFileByLine();
        else
            System.out.println("No Response");
        System.out.println();
    }

    /**
     * Set Exit
     *
     * @param dir  a string of direction from last room
     * @param room Next room
     */
    public void setExit(String dir, Room room) {
        exits.put(dir, room);
    }

    /**
     * get a status of room
     *
     * @return closed, open, bossRoom, reenter, outSide
     */
    public Status seeStatus() {
        return status;
    }

    /**
     * Set a status of room
     *
     * @param status closed, open, bossRoom, reenter, outSide
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Print room
     *
     * @return A formated String by room
     */
    @Override
    public String toString() {
        return description;
    }

    /**
     * Description of room exit
     *
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
     *
     * @param direction a String of direction
     * @return next Room
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    /**
     * Set Item
     *
     * @param name   Item's name
     * @param belong item: armor, weapon, key
     */
    public void setItem(String name, Belong belong) {
        hideItem = new Item(name, belong);
    }

    /**
     * erase Item
     *
     * @return the Item should be erased
     */
    public Item eraseItem() {
        Item temp = hideItem;
        hideItem = null;
        return temp;
    }

}
