package SimpleGame;

public class Handler {

    protected Game game;

    public Handler(Game game) {
        this.game = game;
    }

    public void doCmd(String word) {
    }

    public boolean isBye() {
        return false;
    }

}
