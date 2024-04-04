package character;

import utility.Observer;

/*
 * This class manages the level of a hero.
 * It leverages the Observer Pattern to monitor the hero experience and keep the level up to date.
 * */
public class Level implements Observer {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public void addValue(int dValue){
        this.value += dValue;
    }
    private int value;

    public Level(int value){
        this.value = value;
    }

    public void update(int new_value){
        this.value = new_value;
    }
}
