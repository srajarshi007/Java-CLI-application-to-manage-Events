package EventManager;

import EventCreation.Event;

import java.util.ArrayList;
import java.util.List;

public class Manage {
    private List<Event> events;

    public Manage() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    public List<Event> getEvents() {
        return events;
    }
}