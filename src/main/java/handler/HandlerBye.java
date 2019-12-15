//: game/HandlerBye.java
package handler;

import stage.Game;

/**
 * @author www.icourse163.org/course/ZJU-1001542001
 * @author Jaycee Zhou
 */
public class HandlerBye extends Handler {

    /**
     * Destructor of HandlerBye Class
     * @param game Running Game Object
     */
    public HandlerBye(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String word) {
        
    }

    /**
     * End the game
     * @return When you return a false, it will end the game, and true continues.
     */
    @Override
    public boolean isBye() {
        return true;
    }

}