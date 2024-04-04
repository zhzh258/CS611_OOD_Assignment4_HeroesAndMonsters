package event;

import java.util.*;

import character.Hero;
import character.Team;
import item.*;
import javafx.util.Pair;
import utility.InputHandler;

/*
 * This class represent a market.
 * It's created by the FactoryEventBattle and is bind to a TileMarket when user first enters it.
 * */
public class EventMarket extends Event {
    private List<Item> products;
    private int gold; // how much gold does the merchant have
    Team team; // the same team in Grid

    public EventMarket(List<Item> products, Team team) {
        this.products = products;
        this.gold = 1000;
        this.team = team;
    }

    @Override
    public void start() {
        System.out.println("========MARKET========");
        InputHandler in = InputHandler.getInstance();
        System.out.println("What item do you want to buy?");
        Item selected_item = in.selectFromListOptional(products);
        while(selected_item != null){
            int price = selected_item.price;
            int deposit = team.getHero().getInventory().getGold();
            if(price > deposit){ // fail
                System.out.printf("-> You can't affort this item! The price: %d. Your gold: %d\n", price, deposit);
            } else { // success
                // update market and hero
                products.remove(selected_item);
                team.getHero().getInventory().addItem(selected_item);
                this.gold -= price;
                team.getHero().getInventory().addGold(-price);
                System.out.println("-> You successfully bought an item! Check it in the inventory.");
                System.out.println("The item is " + selected_item.toString());
            }
            // ask for next user input
            System.out.println();
            System.out.println("Which item do you want to buy?");
            selected_item = in.selectFromListOptional(products);
        }
        System.out.println("========LEAVE MARKET========");
    }
}
