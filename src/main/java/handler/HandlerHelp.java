//: game/HandlerHelp.java
package handler;

import stage.Game;

/**
 * @author www.icourse163.org/course/ZJU-1001542001
 * @author Jaycee Zhou
 */
public class HandlerHelp extends Handler {

    /**
     * Destructor of HandlerHelp Class
     * @param game Running Game Object
     */
    public HandlerHelp(Game game) {
        super(game);
    }

    /**
     * Run command to seek for guide
     * @param word A string of characters representing a command
     */
    @Override
    public void doCmd(String word) {
        System.out.println("Get lost? The commands you can do are: ");
        System.out.print("1.go ,which will enters the next room.");
        System.out.println(" You can choose one direction to enter. such as: go west.");
        System.out.println("2.bye ,which will end the game.");
        System.out.println("3.help ,which will get a guide.");
        System.out.print("4.search, which will search for a item in the room,");
        System.out.println(" You have to collect items to get through some rooms.");
        System.out.println("5.prompt, which will tell you the location information.");
        System.out.println();
    }

}
