package grid;

import event.FactoryEvent;

/*
* This abstract class is a tile.
* GridTileCommon extends GridTile
* GridTileBlock extends GridTile
* GridTileMarket extends GridTile
* GridTileBorder extends GridTile
* */
abstract public class Tile {
    final private int r;
    final private int c;


    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public Tile(int r, int c){
        this.r = r;
        this.c = c;
    }

    abstract public String getTypeSymbol();

    abstract public void generate(FactoryEvent f);
    abstract public String getTypeColor();
    abstract public EnumTile getType();
}
