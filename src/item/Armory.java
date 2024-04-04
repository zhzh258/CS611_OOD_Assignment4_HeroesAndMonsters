package item;

// Armory item
public class Armory extends Item {
    final private int damage_reduction;

    public Armory(String name, int price, int required_level, int damage_reduction) {
        super(name, price, required_level, EnumItem.Armory);
        this.damage_reduction = damage_reduction;
    }

    @Override
    public EnumItem getType() {
        return EnumItem.Armory;
    }

    @Override
    public String toString() {
        return super.toString() +
                "<Additional Data>" + "\n" +
                "\tdamage_reduction: " + damage_reduction + "\n" +
                "</Additional Data>";
    }
}
