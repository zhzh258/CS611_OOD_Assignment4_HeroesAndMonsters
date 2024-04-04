package item;

import java.util.Objects;
import java.util.UUID;

/*
 * This is the base class of FireSpells, FrostFpess, Lightning spell.
 */
abstract public class Item {
    final private UUID id; // A unique UUID is assigned to an item when it's created in market
    final public String name;
    final public int price;
    final public int required_level;
    final public EnumItem type;
    public int getRequired_level() {
        return required_level;
    }
    abstract public EnumItem getType();

    public Item(String name, int price, int required_level, EnumItem type){
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.required_level = required_level;
        this.type = type;
    }


    @Override
    public String toString() {
        return "<Item>" + "\n" +
                "\tname: " + name + "\n" +
                "\tprice: " + price + "\n" +
                "\trequired_level: " + required_level + "\n" +
                "\ttype: " + type + "\n" +
                "</Item>\n";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return false;
        if (o == null || getClass() != o.getClass())
            return false;
        Item i = (Item) o;
        return this.id == i.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
