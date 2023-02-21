package EventBooking;
import EventCreation.Event;
import EventManager.Manage;

import java.util.ArrayList;
import java.util.List;
public class Student{
    private String RegNo;
    private String Name;
    private String Contact;
    private List<Event> Registered;
    private List<Event> Coordinating;
    public Student(String RegNo, String Name, String Contact){
        this.RegNo = RegNo;
        this.Name = Name;
        this.Contact = Contact;
        this.Registered = new ArrayList<>();
        this.Coordinating = new ArrayList<>();
    }
    public void RegisterEvent(Event event){
        Registered.add(event);
    }
    public void DeregisterEvent(Event event){
        Registered.remove(event);
        event.increaseCapacity();
    }
    public void Coordinate(Event event){
        Coordinating.add(event);
    }
    public String getName(){
        return Name;
    }
    public String getRegNo(){
        return RegNo;
    }
    public String getContact(){
        return Contact;
    }
    public List<Event> getRegistered(){
        return Registered;
    }
    public List<Event> getCoordinating(){
        return Coordinating;
    }
}
