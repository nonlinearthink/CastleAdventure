//: game/Handler.java
package game;

/**
 * @author www.icourse163.org/course/ZJU-1001542001
 * @author Jaycee Zhou
 */
public class Handler {

    protected Game game;

    /**
     * Destructor of Handler Class
     * @param game Running Game Object
     */
    public Handler(Game game) {
        this.game = game;
    }

    /**
     * Run command
     * @param word A string of characters representing a command
     */
    public void doCmd(String word) {
    }

    /**
     * End the game
     * @return When you return a false, it will end the game, and true continues.
     */
    public boolean isBye() {
        return false;
    }

}
