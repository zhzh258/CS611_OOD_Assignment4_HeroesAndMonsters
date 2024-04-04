package item;

public class Weaponry extends Item {
    final public int damage;
    final public int required_hands;

    public Weaponry(String name, int price, int required_level, int damage, int required_hands){
        super(name, price, required_level, EnumItem.Weaponry);
        this.damage = damage;
        this.required_hands = required_hands;
    }

    @Override
    public EnumItem getType() {
        return EnumItem.Weaponry;
    }

    @Override
    public String toString() {
        return super.toString() +
                "<Additional Data>" + "\n" +
                "\tdamage: " + damage + "\n" +
                "\trequired_hands: " + required_hands + "\n" +
                "</Additional Data>";
    }
}
