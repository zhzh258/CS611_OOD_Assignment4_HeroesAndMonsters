package item;

abstract public class Spell extends Item {
    final public int damage;
    final public int mana_cost;
    public Spell(String name, int price, int required_level, int damage, int mana_cost, EnumItem type){
        super(name, price, required_level, type);
        this.damage = damage;
        this.mana_cost = mana_cost;
    }

    public abstract EnumItem getType();
}
