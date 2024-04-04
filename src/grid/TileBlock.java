package grid;

import event.FactoryEvent;

/*
 * This abstract class is a block tile. User can't cross it.
 * */
public class TileBlock extends Tile {
    final EnumTile type = EnumTile.Block;
    final String marker = "/";
    final String color = "GREEN";

    public TileBlock(int r, int c){
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
