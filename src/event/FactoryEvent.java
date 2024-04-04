package event;

import event.Event;

// The base class of FactoryEventBattle
abstract public class FactoryEvent {
    abstract public Event createInstance();
}
