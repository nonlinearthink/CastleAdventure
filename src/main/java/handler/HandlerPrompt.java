//: game/HandlerPrompt.java
package handler;

import stage.Game;

/**
 * @author Jaycee Zhou
 */
public class HandlerPrompt extends Handler{

    /**
     * Destructor of HandlerPrompt Class
     * @param game Running Game Object
     */
    public HandlerPrompt(Game game){
        super(game);
    }

    /**
     * Run command to prompt your location
     * @param word A string of characters representing a command
     */
    @Override
    public void doCmd(String word) {
        game.showPrompt();
    }
}
