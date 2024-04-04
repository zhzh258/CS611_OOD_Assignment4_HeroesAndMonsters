import utility.InputHandler;

import java.util.Arrays;

public class Menu {
    private Game game;

    public void launch() {
        System.out.println("==========MAIN MENU==========");
        InputHandler.getInstance().showInputFormat(
                Arrays.asList("1"),
                Arrays.asList("New Game")
        );
        System.out.println("=============================");
        String res = InputHandler.getInstance().getValidStringInput(Arrays.asList("1"));
        if(res.equals("q"))
            return;
        game = new Game();
        game.start();

        // the user pause (quit) the current game || win it || lose it
        System.out.println("==========MAIN MENU==========");
        InputHandler.getInstance().showInputFormat(
                Arrays.asList("1", "2"),
                Arrays.asList("New Game", "Resume Game")
        );
        System.out.println("=============================");
        res = InputHandler.getInstance().getValidStringInput(Arrays.asList("1", "2"));
        while(!res.equals("q")){
            if(res.equals("1")){ // restart
                game = new Game();
                game.start();
            } else if(res.equals("2")){ // resume
                game.resume();
            } else{ // quit
                return;
            }
            // the user pause (quit) the current game || win it || lose it
            System.out.println("==========MAIN MENU==========");
            InputHandler.getInstance().showInputFormat(
                    Arrays.asList("1", "2"),
                    Arrays.asList("New Game", "Resume Game")
            );
            System.out.println("=============================");
            res = InputHandler.getInstance().getValidStringInput(Arrays.asList("1", "2"));
        }
    }
}
