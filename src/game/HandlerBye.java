//: game/HandlerBye.java
package game;

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

    /**
     * End the game
     * @return When you return a false, it will end the game, and true continues.
     */
    @Override
    public boolean isBye() {
        return true;
    }

}