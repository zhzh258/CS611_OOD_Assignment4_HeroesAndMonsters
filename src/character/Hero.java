package character;

import java.util.Arrays;

/*
 * This class is a Hero. It contains an Attributes, an Inventory, experience, and gold.
 * */
public class Hero extends Character {
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    public void addExperience(int dExperience) {
        this.experience += dExperience;
    }

    // from Character:
//    protected String name;
//    protected int level;
    private int experience;
    final public Level level;
    public int getLevel(){
        return level.getValue();
    }
    final private EnumerateHero type;

    public int getAttributeAt(EnumerateHeroAttribute key) {
        return attribute.valueOf(key);
    }
    public void addAttributeAt(EnumerateHeroAttribute key, int value){ // actually add to buff
        attribute.setBuff(key, value);
    }

    final private Attribute<EnumerateHeroAttribute> attribute;
    final public Inventory getInventory() {
        return inventory;
    }
    final private Inventory inventory;

    public Hero(String name, int mana, int strength, int agility, int dexterity, int starting_money, int starting_experience, EnumerateHero type){
        super(name);
        int health = (1 + starting_experience / 10) * 100;
        this.attribute = new Attribute<EnumerateHeroAttribute>(EnumerateHeroAttribute.class, Arrays.asList(
                health, mana, strength, agility, dexterity, 0
        )); // initially defense is 0 (without armor)
        this.experience = starting_experience;
        this.level = new Level(1 + starting_experience / 10);
        this.type = type;
        this.inventory = new Inventory();
        this.inventory.addGold(starting_money);
    }

    @Override
    public String toString() {
        return "<Hero>" + "\n" +
                attribute.toString() +
                "level: " + level + "\n" +
                "type: " + type + "\n" +
                "</Hero>" + "\n";
    }

    public void display(){
        System.out.println("hero name: " + this.getName());
        System.out.println(this.toString());
    }


}
