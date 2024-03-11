package View;

import controller.FoodManagement;
import util.Commands;

public class UserView {

    private final FoodManagement fm;
    public UserView(FoodManagement fm) {
        this.fm = fm;
    }

    public void showCommands() {
        System.out.println("The commands are :");
        for (Commands c : Commands.values()) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void run() {
        showCommands();
        Commands com;
        while (true) {
            while (true) {
                String command = fm.prompt("insert command: ");
                try {
                    com = Commands.valueOf(command);
                    break;
                } catch (Exception e) {
                    System.out.println("Error: wrong command " + command);
                }
            }
            if (com == Commands.EXIT) return;
            switch (com) {
                case ADD:
                    fm.AddFood();
                    break;
                case FREQUENCY:
                    fm.frequencyOfWords();
                    break;
                case LIST:
                    fm.listFood();
                    break;
                case LONGEST:
                    fm.printLongestWord();
                    break;
                case COUNT:
                    fm.countFood();
                    break;
            }
        }
    }
}