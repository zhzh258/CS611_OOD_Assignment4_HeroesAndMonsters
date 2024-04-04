package utility;

/*
* This class is the Observer of the Observer Pattern. The Subject of it has a List<Observer>
Whenever Subject's state changes, it's Observer.update() will be called.
* */
public interface Observer {
    void update(int message);
}
