package character;

import item.EnumItem;
import item.Item;
import item.Armory;
import item.Weaponry;
import utility.InputHandler;

import java.util.*;
import java.util.stream.Collectors;

/*
 * This class is the Inventory of a character.
 * */
public class Inventory {
    public HashSet<Item> getItems() {
        return items;
    }
    public void addItem(Item item){
        items.add(item);
    }
    public int getSize(){
        return items.size();
    }

    // get all items within the given category. example : List<Item> li = getByCategory(Potions.class)
    public <T extends Item> List<Item> getByCategory(Class<T> categoryClass) {
        return this.items.stream()
                .filter(categoryClass::isInstance)
                .collect(Collectors.toList());
    }
    public boolean removeItem(Item i){
        if(items.contains(i)){
            items.remove(i);
            return true;
        } else{
            return false;
        }
    }

    public int getGold() {
        return gold;
    }

    public void addGold(int dg){ // gold can be negative
        this.gold += dg;
    }

    public Armory getEquipped_armory() {
        return equipped_armory;
    }

    public Weaponry getEquipped_weaponry() {
        return equipped_weaponry;
    }

    private HashSet<Item> items;
    private int gold;
    private Armory equipped_armory;
    private Weaponry equipped_weaponry;

    public Inventory(){
        this.items = new HashSet<>();
        this.gold = 0;
        this.equipped_armory = null;
        this.equipped_weaponry = null;
    }

    public void equipWeaponry(){
        InputHandler in = InputHandler.getInstance();
        List<Weaponry> ws = new ArrayList<>();
        for(Item i : items){
            if(i.getType() == EnumItem.Weaponry && i instanceof Weaponry){
                ws.add((Weaponry) i);
            }
        }
        if(ws.isEmpty()) {
            System.out.println("This hero has no weaponry in the inventory!");
        } else {
            System.out.println("Please select a weaponry from below: ");
            Weaponry selected_w = in.selectFromList(ws);
            if(equipped_weaponry == null){ // equip
                items.remove(selected_w);
                equipped_weaponry = selected_w;
            } else{ // replace
                items.add(equipped_weaponry);
                items.remove(selected_w);
                equipped_weaponry = selected_w;
            }
        }
    }

    public void equipArmory(){
        InputHandler in = InputHandler.getInstance();
        List<Armory> as = new ArrayList<>();
        for(Item i : items){
            if(i.getType() == EnumItem.Armory && i instanceof Armory){
                as.add((Armory) i);
            }
        }
        if(as.isEmpty()) {
            System.out.println("This hero has no armory in the inventory!");
        } else {
            System.out.println("Please select a armory from below: ");
            Armory selected_a = in.selectFromList(as);
            if(equipped_armory == null){ // equip
                items.remove(selected_a);
                equipped_armory = selected_a;
            } else{ // replace
                items.add(equipped_armory);
                items.remove(selected_a);
                equipped_armory = selected_a;
            }
        }
    }

    public void display(){
        for(Item item : items){
            System.out.println(item.toString());
        }
    }
}
