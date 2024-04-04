package event;

import character.*;
import item.*;
import item.Weaponry;
import utility.InputHandler;
import utility.Observer;
import utility.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * This class represent a battle.
 * It's created by the FactoryEventBattle and is bind to a TileCommon when user first enters it.
 * */
public class EventBattle extends Event implements Subject {
    List<Observer> observers;
    private int round; // 1, 2, 3, ...
    private List<Monster> b_monsters;
    private List<Monster> monsters;
    private List<Hero> b_heroes; // team.b_heroes is a List<CharacterHero>
    private List<Hero> heroes; // team.b_heroes is a List<CharacterHero>

    private boolean result; // Indicates the outcome of the battle
    private boolean win = false;

    public EventBattle(List<Monster> monsters, Team team) {
        this.round = 0;
        this.monsters = monsters;
        this.b_monsters = new ArrayList<>(monsters);
        this.heroes = team.getHeroes();
        this.b_heroes = new ArrayList<>(team.getHeroes());

        this.result = false; // Battle starts as undecided
        this.observers = new ArrayList<>();
        for(int i = 0; i < heroes.size(); i++){
            if(heroes.get(i).level != null) this.observers.add(heroes.get(i).level);
        }
    }

    @Override
    public void start() {
        System.out.println("battle start!");
        while (!finished()) {
            // Increment the round number at the start of each loop
            round++;
            System.out.println("Round " + round + " begins!");

            // Heroes' turn
            for (int i = b_heroes.size() - 1; i > -1; i--) {
                Hero hero = b_heroes.get(i);
                if (finished()) break;
                if (hero.getAttributeAt(EnumerateHeroAttribute.Health) <= 0) {
                    b_heroes.remove(hero);
                    System.out.printf("\nNow is the turn of Hero No.%d: %s. It is skipped because it's dead!\n", i+1, hero.getName());
                    continue;
                };
                System.out.printf("\nNow is the turn of Hero No.%d: %s\n", i+1, hero.getName());
                heroTurn(hero);
            }

            // Monsters' turn
            for (int j = b_monsters.size() - 1; j > -1; j--) {
                Monster monster = b_monsters.get(j);
                if (finished()) break;
                if (monster.getAttributeAt(EnumerateMonsterAttribute.Health) <= 0) {
                    b_monsters.remove(monster);
                    System.out.printf("\nNow is the turn of Monster No.%d: %s. It is skipped because it's dead!\n", j+1, monster.getName());
                    continue;
                }
                System.out.printf("\nNow is the turn of Monster No.%d: %s\n", j+1, monster.getName());
                monsterTurn(monster);
            }
        }
        if(allMonstersDead() && !allHeroesDead()){
            // victory
            System.out.println("Your team wins the battle!");
            battleGain();
        } else{
            // lose
            System.out.println("Your team loses the battle!");
        }
    }

    private void heroTurn(Hero hero) {
        System.out.println("This is hero's turn. The hero is: ");
        hero.display();
        InputHandler in = InputHandler.getInstance();
        in.showInputFormat(
                Arrays.asList("a", "s", "p", "h", "m", "i"),
                Arrays.asList("Basic Attack", "Cast a Spell", "Use a Potion", "Show Heroes Status", "Show Monsters Status", "Show Inventory")
        );
        String userInput = in.getValidStringInput(Arrays.asList("a", "s", "p", "h", "m", "i"));
        while("hmi".contains(userInput)){
            if(userInput.equals("h")){
                for(Hero h : b_heroes){
                    h.display();;
                }
            } else if(userInput.equals("m")){
                for(Monster m : b_monsters){
                    m.display();
                }
            } else if(userInput.equals("i")){
                System.out.println("Showing the inventory of Hero " + hero.getName());
                hero.getInventory().display();
            }
            in.showInputFormat(
                    Arrays.asList("a", "s", "p", "h", "m", "i"),
                    Arrays.asList("Basic Attack", "Cast a Spell", "Use a Potion", "Show Heroes Status", "Show Monsters Status", "Show Inventory")
            );
            userInput = in.getValidStringInput(Arrays.asList("a", "s", "p", "h", "m", "i"));
        }

        if(userInput.equals("a")){
            Monster target = in.selectFromList(b_monsters);
            if(target == null) return;
            int hero_strength = hero.getAttributeAt(EnumerateHeroAttribute.Strength);
            Weaponry w = hero.getInventory().getEquipped_weaponry(); // w may be null
            int weapon_attack =  w != null ? w.damage : 0;
            int basic_damage = (int) ((hero_strength + weapon_attack) * 0.05f);
            System.out.println("The weapon attack is " + weapon_attack);
            System.out.println("The hero strength is " + hero_strength);
            System.out.println("==> The basic damage is " + basic_damage);
            target.addAttributeAt(EnumerateMonsterAttribute.Health, -basic_damage);
            if(target.getAttributeAt(EnumerateMonsterAttribute.Health) <= 0){
                b_monsters.remove(target);
                System.out.println("monster die: " + target.getName());
            }
            System.out.printf("%s deals %d damage to %s\n", hero.getName(), basic_damage, target.getName());
        } else if(userInput.equals("s")){
            // load available spells
            List<Item> fireSpells = hero.getInventory().getByCategory(FireSpells.class);
            List<Item> frostSpells = hero.getInventory().getByCategory(FrostSpells.class);
            List<Item> lightningSpells = hero.getInventory().getByCategory(LightningSpells.class);
            List<Item> spells = new ArrayList<Item>(fireSpells);
            spells.addAll(frostSpells);
            spells.addAll(lightningSpells);
            // calc
            Spell spell = (Spell) in.selectFromList(spells);
            if(spell == null) return;
            hero.getInventory().removeItem(spell);
            Monster target = in.selectFromList(b_monsters);
            if(target == null) return;

            int spell_base_damage = spell.damage;
            int hero_dexterity = hero.getAttributeAt(EnumerateHeroAttribute.Dexterity);
            int spell_damage = (int) (spell_base_damage + hero_dexterity * spell_base_damage / 10000f);
            System.out.println("The spell base damage is " + spell_base_damage);
            System.out.println("The hero dexterity is " + hero_dexterity);
            System.out.println("==> The spell damage is " + spell_damage);
            int monster_dodge_chance = target.getAttributeAt(EnumerateMonsterAttribute.DodgeChance);
            target.addAttributeAt(EnumerateMonsterAttribute.Health, -spell_damage);
            System.out.printf("%s deals %d damage to %s\n", hero.getName(), spell_damage, target.getName());
            if(target.getAttributeAt(EnumerateMonsterAttribute.Health) <= 0){
                b_monsters.remove(target);
                System.out.println("monster die: " + target.getName());
            }
        } else if(userInput.equals("p")){
            List<Item> potions = hero.getInventory().getByCategory(Potions.class);
            Potions potion = (Potions) in.selectFromListOptional(potions);
            if(potion == null) return;
        }
    }

    // Implement monsterTurn similar to the b_monsters' turn logic in file2
    private void monsterTurn(Monster monster) {
        System.out.println("This is monster's turn. The monster is:");
        monster.display();
        int monster_damage = monster.getAttributeAt(EnumerateMonsterAttribute.Damage);
        System.out.println("The monster damage is " + monster_damage);
        Hero target = b_heroes.get(0);
        target.addAttributeAt(EnumerateHeroAttribute.Health, -monster_damage);
        System.out.printf("%s deals %d damage to %s\n", monster.getName(), monster_damage, target.getName());
        if(target.getAttributeAt(EnumerateHeroAttribute.Health) <= 0){
            b_heroes.remove(target);
            System.out.println("hero die: " + target.getName());
        }
    }

    // Check if the battle has finished based on the state of b_heroes and b_monsters
    private boolean finished() {
        return allHeroesDead() || allMonstersDead();
    }

    private void battleGain() {
        // Distribute experience and rewards to b_heroes
        int totalGold = 0;
        for(Monster m : monsters){
            totalGold += m.getLevel() * 100;
        }
        int totalExperience = monsters.size() * 2;

        for(Hero h : b_heroes){
            System.out.printf("hero %s get %d gold\n", h.getName(), totalGold);
            System.out.printf("hero %s get %d experience\n", h.getName(), totalExperience);
            h.getInventory().addGold(totalGold);
            h.addExperience(totalExperience);
        }
    }

    private boolean allMonstersDead() {
        return b_monsters.isEmpty();
    }
    private boolean allHeroesDead() {
        // Check if all b_heroes are dead
        return b_heroes.isEmpty();
    }

    private void showHeroes(){
        System.out.println("The heroes alive are:");
        for(Hero h : b_heroes){
            h.display();
        }
    }

    private void showMonsters() {
        System.out.println("The monsters alive are:");
        for(Monster m : b_monsters){
            m.display();
        }
    }

    @Override
    public void trigger() {
        for(int i = 0; i < heroes.size(); i++){
            Observer o = observers.get(i);
            int experience = heroes.get(i).getExperience();
            int new_level = experience / 10 + 1;
            o.update(new_level);
        }
    }
}
