package event;

/*
 * This abstract class is reserved for extensibility.
 *
 * Each TileMarket or TileCommon comes up with an event.
 * */
abstract public class Event {
    public Event(){
        ;
    }

    // start the event
    abstract public void start();
}
