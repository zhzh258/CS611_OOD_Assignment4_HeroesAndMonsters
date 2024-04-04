package item;

// FireSpells item
public class FireSpells extends Spell {

    public FireSpells(String name, int price, int required_level, int damage, int mana_cost){
        super(name, price, required_level, damage, mana_cost, EnumItem.FireSpells);
    }

    @Override
    public EnumItem getType() {
        return EnumItem.FireSpells;
    }

    @Override
    public String toString() {
        return super.toString() +
                "<Additional Data>" + "\n" +
                "\tdamage: " + damage + "\n" +
                "\tmana_cost: " + mana_cost + "\n" +
                "</Additional Data>";
    }
}
