package character;

import utility.InputHandler;
import utility.Rand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * This class applies Factory Pattern and can be used to create some heroes.
 * FactoryHero hf is stored in Team
 * */
public class FactoryHero {
    private List<Hero> heroes;
    public FactoryHero(){
        this.heroes = new ArrayList<>();

        List<String> filenames = Arrays.asList("Paladins", "Warriors", "Sorcerers");

        for(String filename: filenames){
            InputHandler in = InputHandler.getInstance();
            List<List<String>> values = in.loadFileContents(in.toPath(filename));
            for(int i=1; i<values.size(); i++){
                if(filename.equals("Paladins")){
                    List<String> hero = values.get(i);
                    String name = hero.get(0);
                    int mana = Integer.parseInt(hero.get(1));
                    int strength = Integer.parseInt(hero.get(2));
                    int agility = Integer.parseInt(hero.get(3));
                    int dexterity = Integer.parseInt(hero.get(4));
                    int starting_money = Integer.parseInt(hero.get(5));
                    int starting_experience = Integer.parseInt(hero.get(6));

                    heroes.add(new Hero(name, mana, strength, agility, dexterity, starting_money, starting_experience, EnumerateHero.Paladins));

                }
                else if(filename.equals("Warriors")){
                    List<String> hero = values.get(i);
                    String name = hero.get(0);
                    int mana = Integer.parseInt(hero.get(1));
                    int strength = Integer.parseInt(hero.get(2));
                    int agility = Integer.parseInt(hero.get(3));
                    int dexterity = Integer.parseInt(hero.get(4));
                    int starting_money = Integer.parseInt(hero.get(5));
                    int starting_experience = Integer.parseInt(hero.get(6));
                    heroes.add(new Hero(name, mana, strength, agility, dexterity, starting_money, starting_experience, EnumerateHero.Warriors));

                }
                else if(filename.equals("Sorcerers")){
                    List<String> hero = values.get(i);
                    String name = hero.get(0);
                    int mana = Integer.parseInt(hero.get(1));
                    int strength = Integer.parseInt(hero.get(2));
                    int agility = Integer.parseInt(hero.get(3));
                    int dexterity = Integer.parseInt(hero.get(4));
                    int starting_money = Integer.parseInt(hero.get(5));
                    int starting_experience = Integer.parseInt(hero.get(6));
                    heroes.add(new Hero(name, mana, strength, agility, dexterity, starting_money, starting_experience, EnumerateHero.Sorcerers));
                }
            }
        }
    }

    public List<Hero> createInstance(int heroes_count){
        return Rand.selectRandomElements(heroes, heroes_count);
    }
}
