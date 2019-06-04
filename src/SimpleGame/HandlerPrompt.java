package SimpleGame;

public class HandlerPrompt extends Handler{

    public HandlerPrompt(Game game){
        super(game);
    }

    @Override
    public void doCmd(String word) {
        game.showPrompt();
    }
}
