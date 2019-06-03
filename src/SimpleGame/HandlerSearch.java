package SimpleGame;

public class HandlerSearch extends Handler{
    public HandlerSearch(Game game){
        super(game);
    }

    @Override
    public void doCmd(String word) {
        game.searchRoom();
    }
}
