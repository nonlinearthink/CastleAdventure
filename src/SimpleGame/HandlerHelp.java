package SimpleGame;

public class HandlerHelp extends Handler {
    public HandlerHelp(Game game){
        super(game);
    }
    @Override
    public void doCmd(String word){
        System.out.println("Get lost? The commands you can do are: ");
        System.out.print("1.go ,which will enters the next room.");
        System.out.println(" You can choose one direction to enter. such as: go west.");
        System.out.println("2.bye ,which will end the game.");
        System.out.println("3.help ,which will get a guide.");
        System.out.print("4.search, which will search for a item in the room,");
        System.out.println(" You have to collect items to get through some rooms.");
        System.out.println();
    }
}
