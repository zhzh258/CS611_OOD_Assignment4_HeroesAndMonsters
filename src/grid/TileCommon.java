package grid;

import event.Event;
import event.EventBattle;
import event.FactoryEvent;

/*
 * This abstract class is a common tile.
 * It contains an EventBattle object. The object will only be initialized by EventBattleFactory when generateEvent() is called.
 * */
public class TileCommon extends Tile {
    final EnumTile type = EnumTile.Common;
    final String marker = " ";
    final String color = "RESET";
    Event battle;

    public TileCommon(int r, int c){
        super(r, c);
    }

    @Override
    public String getTypeSymbol() {
        return this.marker;
    }

    @Override
    public void generate(FactoryEvent f) {
        this.battle = f.createInstance(); // in Grid.java, the grid.bf should be passed to f. So that battle is EventBattle
        assert battle instanceof EventBattle;
        battle.start();
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
