package event;
import java.util.*;

import character.Team;
import event.EventMarket;
import event.FactoryEvent;
import utility.InputHandler;
import item.*;
import utility.Rand;

/*
 * This class uses Factory Pattern.
 * A FactoryMarketEvent bf is stored in Team.java.
 * Whenever user enters a Market for the first time, it creates an event for the tile.
 * */
public class FactoryEventMarket extends FactoryEvent {
    private List<Item> fireSpells;
    private List<Item> frostSpells;
    private List<Item> lightningSpells;
    private List<Item> potions;
    private List<Item> armors;
    private List<Item> weapons;
    final private List<String> filenames = Arrays.asList("Armory", "FireSpells", "IceSpells", "LightningSpells", "Potions", "Weaponry");
    final private int maxCount = 5;
    final private Team team;
    public FactoryEventMarket(Team team){
        fireSpells = new ArrayList<>();
        frostSpells = new ArrayList<>();
        lightningSpells = new ArrayList<>();
        potions = new ArrayList<>();
        armors = new ArrayList<>();
        weapons = new ArrayList<>();
        this.team = team;


        List<String> filenames = Arrays.asList("Armory", "FireSpells", "IceSpells", "LightningSpells", "Potions", "Weaponry");

        for(String filename: filenames){
            InputHandler in = InputHandler.getInstance();
            List<List<String>> values = in.loadFileContents(in.toPath(filename));
            for(int i=1; i<values.size(); i++){
                if(filename.equals("Armory")){
                    List<String> armory = values.get(i);
                    String name = armory.get(0);
                    int price = Integer.parseInt(armory.get(1));
                    int required_level = Integer.parseInt(armory.get(2));
                    int damage_reduction = Integer.parseInt(armory.get(3));
                    armors.add(new Armory(name, price, required_level, damage_reduction));
                }
                else if(filename.equals("Weaponry")){
                    List<String> weaponry = values.get(i);
                    String name = weaponry.get(0);
                    int price = Integer.parseInt(weaponry.get(1));
                    int required_level = Integer.parseInt(weaponry.get(2));
                    int damage = Integer.parseInt(weaponry.get(3));
                    int required_hands = Integer.parseInt(weaponry.get(4));
                    weapons.add(new Weaponry(name, price, required_level, damage, required_hands));
                }
                else if(filename.equals("FireSpells")){
                    List<String> spell = values.get(i);
                    String name = spell.get(0);
                    int price = Integer.parseInt(spell.get(1));
                    int required_level = Integer.parseInt(spell.get(2));
                    int damage = Integer.parseInt(spell.get(3));
                    int mana_cost = Integer.parseInt(spell.get(4));
                    fireSpells.add(new FireSpells(name, price, required_level, damage, mana_cost));
                }
                else if(filename.equals("FrostSpells")){
                    List<String> spell = values.get(i);
                    String name = spell.get(0);
                    int price = Integer.parseInt(spell.get(1));
                    int required_level = Integer.parseInt(spell.get(2));
                    int damage = Integer.parseInt(spell.get(3));
                    int mana_cost = Integer.parseInt(spell.get(4));
                    frostSpells.add(new FrostSpells(name, price, required_level, damage, mana_cost));
                }
                else if(filename.equals("LightningSpells")){
                    List<String> spell = values.get(i);
                    String name = spell.get(0);
                    int price = Integer.parseInt(spell.get(1));
                    int required_level = Integer.parseInt(spell.get(2));
                    int damage = Integer.parseInt(spell.get(3));
                    int mana_cost = Integer.parseInt(spell.get(4));
                    lightningSpells.add(new LightningSpells(name, price, required_level, damage, mana_cost));
                }
                else if(filename.equals("Potions")){
                    List<String> potion = values.get(i);
                    String name = potion.get(0);
                    int price = Integer.parseInt(potion.get(1));
                    int required_level = Integer.parseInt(potion.get(2));
                    int attribute_increase = Integer.parseInt(potion.get(3));
                    String attribute_affected = potion.get(4);
                    potions.add(new Potions(name, price, required_level, attribute_increase, attribute_affected));
                }
            }
        }
    }
    @Override
    public EventMarket createInstance() {
        List<Item> products = new ArrayList<>();
        List<Item> currList;

        currList = fireSpells;
        selectOneFrom(products, currList);
        currList = frostSpells;
        selectOneFrom(products, currList);
        currList = lightningSpells;
        selectOneFrom(products, currList);
        currList = potions;
        selectOneFrom(products, currList);
        currList = armors;
        selectOneFrom(products, currList);
        currList = weapons;
        selectOneFrom(products, currList);

        return new EventMarket(products, team);
    }

    // randomly select an item from currList[]. Then add it to products[]
    private void selectOneFrom(List<Item> products, List<Item> currList){
        if(currList.isEmpty()){
            return;
        }
        int randIndex = Rand.randomInt(0, currList.size());
        products.add(currList.get(randIndex));
    }
}
