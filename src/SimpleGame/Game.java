package SimpleGame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Game {
    private Room curentRoom;
    private HashMap<String, Handler> handlers = new HashMap<String, Handler>();
    private HashSet<Item> bag = new HashSet<Item>();

    public Game() {
        handlers.put("go", new HandlerGo(this));
        handlers.put("bye", new HandlerBye(this));
        handlers.put("help", new HandlerHelp(this));
        handlers.put("search", new HandlerSearch(this));
        createRooms();
    }

    private void createRooms() {
        Room outside, lobby, pub, study, bedroom;
        Room backroom, kitchen, prison, trap, bossroom;

        outside = new Room("outside", Status.open);
        lobby = new Room("lobby", Status.open);
        pub = new Room("pub", Status.open);
        study = new Room("study", Status.open);
        bedroom = new Room("bedroom", Status.closed);
        backroom = new Room("backroom", Status.open);
        kitchen = new Room("kitchen", Status.open);
        prison = new Room("prison", Status.open);
        trap = new Room("trap", Status.open);
        bossroom = new Room("\b\b\b\b\b\b\b\b\b\b\b\b\b\b! ! ! Woke up the master of the castle ! ! !",
                Status.open, true);

        outside.setExit("east", lobby);
        outside.setExit("west", pub);
        lobby.setExit("north", backroom);
        lobby.setExit("down", kitchen);
        lobby.setExit("up", study);
        backroom.setExit("unkown", trap);
        backroom.setExit("south", lobby);
        backroom.setExit("cross", pub);
        kitchen.setExit("up", lobby);
        kitchen.setExit("west", prison);
        prison.setExit("east", kitchen);
        study.setExit("down", lobby);
        study.setExit("south", bedroom);
        bedroom.setExit("up", bossroom);
        bedroom.setExit("north", study);
        bossroom.setExit("unkown", pub);
        pub.setExit("east", outside);

        kitchen.setItem("Fruit knife", Belong.weapon);
        prison.setItem("Helmet", Belong.armor);
        pub.setItem("Key", Belong.key);

        curentRoom = outside;
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the Castle Adventure!");
        System.out.println("If you don't mind playing this boring game.");
        System.out.println("If you need help，just enter 'help' .");
        System.out.println();
        showPrompt();
    }

    public void showPrompt() {
        System.out.println("You are here: " + curentRoom);
        System.out.print("exit has：");
        System.out.println(curentRoom.getExitDesc());
        System.out.println();
    }

    public void searchRoom() {
        Item find = curentRoom.eraseItem();
        if (find != null) {
            System.out.print("get a new Item: ");
            System.out.println(find.toString());
            bag.add(find);
        } else {
            System.out.println("No Item find!");
        }
        System.out.println();
    }

    public void goRoom(String direction) {
        Room nextRoom = curentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door.");
            return;
        } else if (nextRoom.status == Status.closed) {
            boolean flag = false;
            for (Item each : bag) {
                if (each.belong == Belong.key) {
                    nextRoom.status = Status.open;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("The door is closed.");
                return;
            }
        } else if (nextRoom.bossRoom) {
            boolean hasArmor = false, hasWeapon = false;
            for (Item each : bag) {
                if (hasArmor && hasWeapon) {
                    break;
                }
                if (each.belong == Belong.armor) {
                    hasArmor = true;
                }
                if (each.belong == Belong.weapon) {
                    hasWeapon = true;
                }
            }
            curentRoom = nextRoom;
            showPrompt();
            if (!hasArmor || !hasWeapon) {
                System.out.println("Lose Game!");
                System.exit(0);
            }
            System.out.println("You have Killed master and continue to your adventure\n");
            return;
        }
        curentRoom = nextRoom;
        showPrompt();
    }

    public void play() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlers.get(words[0]);
            String value = "";
            if (words.length > 1)
                value = words[1];
            if (handler != null) {
                handler.doCmd(value);
                if (handler.isBye())
                    break;
            }
        }
        in.close();
    }

    public void putInBag(Item item) {
        bag.add(item);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.printWelcome();
        game.play();

        System.out.println("Thank you for coming. Bye! ");
    }
}
