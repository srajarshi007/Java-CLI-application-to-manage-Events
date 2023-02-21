package EventCreation;
import EventBooking.Student;
import java.time.*;
import java.text.*;
import java.util.*;

class SeatunavailableException extends Exception{
    public SeatunavailableException(String str){
        super(str);
    }
}
public class Event {
    private String name;
    private String dateString;
    private String StartTime;
    private String EndTime;
    private long Duration;
    private String location;
    private int capacity;
    private static int count = 0;
    private int eventID;
    private Student Coordinator;
    private List<Student> Registeredstudents;

    public boolean validate(String StartString, String EndString){
        try {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm aa");
            Date StartTime = format.parse(StartString);
            Date EndTime = format.parse(EndString);
            if(EndTime.getTime()<StartTime.getTime()){
                System.out.println("Invalid Time input");
                return false;
            }
            else{
                this.Duration = Math.abs(EndTime.getTime() - StartTime.getTime())/(60*1000);
            }
        }
        catch (Exception e) {
            System.out.println("Invalid Time input. Please enter time in hh:mm aa format.");
            return false;
        }
        return true;
    }
    public boolean validate(String dateString){
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = dateFormat.parse(dateString);

        }
        catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in dd-mm-yyyy format.");
            return false;
        }
        return true;
    }
    public Event(String name, String dateString, String StartTime, String EndTime, String location, int capacity ) {

        if (validate(dateString) && validate(StartTime, EndTime)) {
            this.count = count + 1;
            this.dateString = dateString;
            this.StartTime = StartTime;
            this.EndTime = EndTime;
            this.name = name;
            this.location = location;
            this.capacity = capacity;
            this.eventID = count;
            this.Registeredstudents = new ArrayList<>();
        }
    }
    public void setCoordinator(Student student){
        Coordinator = student;
    }

    public void setRegistered(Student student) throws SeatunavailableException{
        if(this.capacity>0){
            this.Registeredstudents.add(student);
            this.capacity = this.capacity - 1;
        }
        else{
            throw new SeatunavailableException("No seats are available");
        }
    }

    public void increaseCapacity(){
        this.capacity = this.capacity + 1;
    }
    public List<Student> getRegistered(){
        return Registeredstudents;
    }

    public Student getCoordinator(){
        return Coordinator;
    }
    public int getEventID(){
        return eventID;
    }
    public String getName() {
        return name;
    }
    public String getDate() {
        return dateString;
    }
    public String getStartTime(){
        return StartTime;
    }
    public String getEndTime(){
        return EndTime;
    }
    public long getDuration(){
        return Duration;
    }
    public String getLocation() {
        return location;
    }
    public int getCapacity() {
        return capacity;
    }
}




