package item;

public class Potions extends Item {
    final public int attribute_increase;
    final public String attribute_affected;

    public Potions(String name, int price, int required_level, int attribute_increase, String attribute_affected){
        super(name, price, required_level, EnumItem.Potions);
        this.attribute_increase = attribute_increase;
        this.attribute_affected = attribute_affected;
    }

    @Override
    public EnumItem getType() {
        return EnumItem.Potions;
    }

    @Override
    public String toString() {
        return super.toString() +
                "<Additional Data>" + "\n" +
                "\tattribute_affected: " + attribute_affected + "\n" +
                "\tattribute_increase: " + attribute_increase + "\n" +
                "</Additional Data>";
    }


}
