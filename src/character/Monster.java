package character;

import java.util.Arrays;

/*
 * This class is a Monster. It contains an Attribute.
 * */
public class Monster extends Character {
    private Attribute<EnumerateMonsterAttribute> attribute;
    public int getAttributeAt(EnumerateMonsterAttribute key) {
        return attribute.valueOf(key);
    }
    public void addAttributeAt(EnumerateMonsterAttribute key, int value){ // actually add to buff
        attribute.setBuff(key, value);
    }

    public int getLevel() {
        return level;
    }

    public void addLevel(int dlevel) {
        this.level += dlevel;
    }

    private int level;
    final public EnumerateMonster type;

    public Monster(String name, int level, int damage, int defense, int dodge_chance, EnumerateMonster type){
        super(name);
        int health = level * 100;
        this.attribute = new Attribute<EnumerateMonsterAttribute>(EnumerateMonsterAttribute.class, Arrays.asList(health, damage, defense, dodge_chance));
        this.level = level;
        this.type = type;
    }

    public void display(){
        System.out.println("monster name: " + this.getName());
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "<Monster>" + "\n" +
                attribute.toString() +
                "level: " + level + "\n" +
                "type: " + type + "\n" +
                "</Monster>" + "\n";
    }
}

