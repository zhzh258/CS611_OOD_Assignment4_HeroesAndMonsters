package grid;

import event.FactoryEvent;

/*
 * This abstract class is a border tile. User can't cross it.
 * */
public class TileBorder extends Tile {
    final EnumTile type = EnumTile.Border;
    final String marker = "X";
    final String color = "GREEN";
    public TileBorder(int r, int c){
        super(r, c);
    }

    @Override
    public String getTypeSymbol() {
        return this.marker;
    }

    @Override
    public void generate(FactoryEvent f) {
        ; // do nothing
    }

    @Override
    public String getTypeColor() {
        return this.color;
    }

    @Override
    public EnumTile getType() {
        return this.type;
    }
}
