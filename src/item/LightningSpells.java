package item;

//
public class LightningSpells extends Spell {
    public LightningSpells(String name, int price, int required_level, int damage, int mana_cost){
        super(name, price, required_level, damage, mana_cost, EnumItem.LightningSpells);
    }

    @Override
    public EnumItem getType() {
        return EnumItem.LightningSpells;
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
