package item;

// FrostSpells item
public class FrostSpells extends Spell {

    public FrostSpells(String name, int price, int required_level, int damage, int mana_cost){
        super(name, price, required_level, damage, mana_cost, EnumItem.FrostSpells);
    }

    @Override
    public EnumItem getType() {
        return EnumItem.FrostSpells;
    }

    public String toString() {
        return super.toString() +
                "<Additional Data>" + "\n" +
                "\tdamage: " + damage + "\n" +
                "\tmana_cost: " + mana_cost + "\n" +
                "</Additional Data>";
    }
}
