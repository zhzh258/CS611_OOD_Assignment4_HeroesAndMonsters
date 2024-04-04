package grid;

import event.Event;
import event.FactoryEvent;
import event.EventMarket;

/*
 * This abstract class is a market tile.
 * It contains an EventMarket object. The object will only be initialized by EventMarketFactory when generateEvent() is called.
 * */
public class TileMarket extends Tile {
    final EnumTile type = EnumTile.Market;
    final String marker = "M";
    final String color = "YELLOW";
    public Event market;

    public TileMarket(int r, int c){
        super(r, c);
    }

    @Override
    public String getTypeSymbol() {
        return this.marker;
    }

    @Override
    public void generate(FactoryEvent f) {
        this.market = f.createInstance();// in Grid.java, the grid.mf should be passed as f. So that market is EventMarket
        assert market instanceof EventMarket;
        market.start(); // market can start() again if user input <m>
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
