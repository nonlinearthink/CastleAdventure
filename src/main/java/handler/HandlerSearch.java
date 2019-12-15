//: game/HandlerSearch.java
package handler;

import stage.Game;

/**
 * @author Jaycee Zhou
 */
public class HandlerSearch extends Handler {

    /**
     * Destructor of HandlerSearch Class
     * @param game Running Game Object
     */
    public HandlerSearch(Game game) {
        super(game);
    }

    /**
     * Run command to search items in the room
     * @param word A string of characters representing a command
     */
    @Override
    public void doCmd(String word) {
        game.searchRoom();
    }

}
