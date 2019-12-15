//: game/HandlerGo.java
package handler;

import stage.Game;

/**
 * @author www.icourse163.org/course/ZJU-1001542001
 * @author Jaycee Zhou
 */
public class HandlerGo extends Handler {

    /**
     * Destructor of HandlerGo Class
     * @param game Running Game Object
     */
    public HandlerGo(Game game) {
        super(game);
    }

    /**
     * Run command to go a room
     * @param word A string of characters representing a command
     */
    @Override
    public void doCmd(String word) {
        game.goRoom(word);
    }

}
