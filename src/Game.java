import grid.Grid;
import character.Team;
import utility.InputHandler;

import java.util.Arrays;

public class Game {
    private Grid grid;
    public Game() {
    }

    public void start() {
        System.out.println("You started a new game!");
        init();
        resume();
    }

    public void resume() {
        this.grid.display();
        this.grid.displayHint();
        InputHandler.getInstance().showInputFormat(
                Arrays.asList("w/a/s/d", "i", "m", "h", "t", "c", "p", "q"),
                Arrays.asList("move", "show inventory", "map", "hero stats", "trade", "change inventory", "drink potion", "back to menu")
        );
        String userInput = InputHandler.getInstance().getValidStringInput(Arrays.asList("w", "a", "s", "d", "i", "m", "h", "t", "c", "p", "q"));
        grid.onUserInput(userInput);
        if(grid.isGameOver()){
            return;
        }

        while(!userInput.equals("q")){
            grid.display();
            this.grid.displayHint();
            InputHandler.getInstance().showInputFormat(
                    Arrays.asList("w/a/s/d", "i", "m", "h", "t", "c", "p", "q"),
                    Arrays.asList("move", "show inventory", "map", "hero stats", "trade", "change inventory", "drink potion", "back to menu")
                    );
            userInput = InputHandler.getInstance().getValidStringInput(Arrays.asList("w", "a", "s", "d", "i", "m", "h", "t", "c", "p", "q"));
            grid.onUserInput(userInput);
            if(grid.isGameOver()){
                return;
            }
        }
    }
    private void init() {
        InputHandler.getInstance().showInputFormat("Please input the number of rows: (5~10)");
        int R = InputHandler.getInstance().getValidIntInput(5, 10);
        InputHandler.getInstance().showInputFormat("Please input the number of columns: (5~10)");
        int C = InputHandler.getInstance().getValidIntInput(5, 10);
        InputHandler.getInstance().showInputFormat("Please input the number of heroes: (1~4)");
        int heroes_count = InputHandler.getInstance().getValidIntInput(1, 4);

        this.grid = new Grid(R+2, C+2, heroes_count);
        System.out.println("A new grid has been successfully initialized!");
    }

    private void nextMove(){
        System.out.println("next move...");
    }
}
