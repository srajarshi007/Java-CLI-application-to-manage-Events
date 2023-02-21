import EventCreation.Event;
import EventManager.Manage;
import EventBooking.Student;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int count=2;
        Student demo1 = new Student("20BKT0103","Adwaita Raj Modak", "8973215347");
        Student demo2 = new Student("20BDS0003","Arnab Banik", "8971234347");
        Student demo3 = new Student("20BCE2103","Ankan Ray", "8942042069");
        Student coordinator1 = new Student("20BCT0163","Rajarshi Saha", "8017329178");
        Manage eventManager = new Manage();
        String name1 ="Agaaz 3.0";
        String dateString1 ="23-02-2023";
        String StartTime1 = "10:00 AM";
        String EndTime1 = "01:00 PM";
        String location1 = "Anna Auditorium";
        int capacity1 = 400;
        Event e1 = new Event(name1, dateString1, StartTime1, EndTime1, location1, capacity1);
        e1.setCoordinator(coordinator1);
        try{
            e1.setRegistered(demo1);
        }
        catch(Exception ex){
            System.out.println("Exception Caught "+ ex);
        }
        try{
            e1.setRegistered(demo3);
        }
        catch(Exception ex){
            System.out.println("Exception Caught "+ ex);
        }
        Student coordinator2 = new Student("20BCT0133","Mayukh Mondal", "7962532945");
        String name2 ="RockwithBanik 4.0";
        String dateString2 ="27-02-2023";
        String StartTime2 = "07:00 AM";
        String EndTime2 = "09:00 AM";
        String location2 = "Foodies";
        int capacity2 = 100;
        Event e2 = new Event(name2, dateString2, StartTime2,EndTime2, location2, capacity2);
        e2.setCoordinator(coordinator2);
        try{
            e2.setRegistered(demo1);
        }
        catch(Exception ex){
            System.out.println("Exception Caught "+ ex);
        }
        try{
            e2.setRegistered(demo2);
        }
        catch(Exception ex){
            System.out.println("Exception Caught "+ ex);
        }
        try{
            e2.setRegistered(demo3);
        }
        catch(Exception ex){
            System.out.println("Exception Caught "+ ex);
        }
        try{
            e2.setRegistered(coordinator1);
        }
        catch(Exception ex){
            System.out.println("Exception Caught "+ ex);
        }
        eventManager.addEvent(e1);
        eventManager.addEvent(e2);
        while(true){
            System.out.println("Choose the Operation you want to perform");
            System.out.println("1.Show Events");
            System.out.println("2.Open Admin Portal");
            System.out.println("3.Open Student Portal");
            System.out.println("4.Exit");
            Scanner sc = new Scanner(System.in);
            int ch1 = sc.nextInt();
            sc.nextLine();
            switch(ch1){
                case 1:
                    List<Event> eventslist= eventManager.getEvents();
                    for(Event e:eventslist) {
                        System.out.println(e.getEventID() + ". " + e.getName());
                        System.out.println("Venue:" + e.getLocation());
                        System.out.println("From: " + e.getStartTime() + " To: " + e.getEndTime() + " on " + e.getDate());
                        System.out.println("Duration: " + e.getDuration() + " Mins");
                        System.out.println("Capacity: " + e.getCapacity());
                    }
                    break;
                case 2:
                    while(true) {
                        System.out.println("Choose the Operation you want to perform");
                        System.out.println("1.Show Event Registration Details");
                        System.out.println("2.Add Events");
                        System.out.println("3.Exit");
                        boolean brk = false;
                        int ch2 = sc.nextInt();
                        sc.nextLine();
                        switch (ch2) {
                            case 1:
                                System.out.println("Select Event from the list");
                                int event_idx = sc.nextInt();
                                sc.nextLine();
                                Event e = eventManager.getEvents().get(event_idx - 1);
                                System.out.println(e.getEventID() + ". " + e.getName());
                                System.out.println("Coordinator details: Name: " + e.getCoordinator().getName() + " RegNo.: " + e.getCoordinator().getRegNo() + " Contact: " + e.getCoordinator().getContact());
                                System.out.println("Registration details:");
                                List<Student> Registered = e.getRegistered();
                                for (Student s : Registered) {
                                    System.out.println("Name: " + s.getName() + " RegNo.: " + s.getRegNo() + " Contact: " + s.getContact());
                                }
                                break;
                            case 2:
                                System.out.println("Enter Event Name");
                                String name = sc.nextLine();
                                System.out.println("Enter Venue");
                                String location = sc.nextLine();
                                System.out.println("Enter Date(dd-mm-yyyy)");
                                String dateString = sc.nextLine();
                                System.out.println("Enter Start Time(hh-mm aa)");
                                String StartTime = sc.nextLine();
                                System.out.println("Enter End Time(hh-mm aa)");
                                String EndTime = sc.nextLine();
                                System.out.println("Enter capacity");
                                int capacity = sc.nextInt();
                                sc.nextLine();
                                break;
                            case 3:
                                brk = true;
                                break;
                            default:
                                break;

                        }
                        if(brk){
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter your Name");
                    String Name = sc.nextLine();
                    System.out.println("Enter your Registration Number");
                    String RegNo = sc.nextLine();
                    System.out.println("Enter your Contact");
                    String Contact = sc.nextLine();
                    Student s = new Student(RegNo, Name, Contact);
                    while(true){
                        System.out.println("Choose the Operation you want to perform");
                        System.out.println("1.Show Events Registered");
                        System.out.println("2.Show Events Coordinating");
                        System.out.println("3.Register Events");
                        System.out.println("4.Deregister Events");
                        System.out.println("5.Exit");
                        boolean brk = false;
                        int ch2 = sc.nextInt();
                        sc.nextLine();
                        switch(ch2){
                            case 1:
                                List<Event> events = s.getRegistered();
                                for(Event e:events) {
                                    System.out.println(e.getEventID() + ". " + e.getName());
                                    System.out.println("Venue:" + e.getLocation());
                                    System.out.println("From: " + e.getStartTime() + " To: " + e.getEndTime() + " on " + e.getDate());
                                    System.out.println("Duration: " + e.getDuration() + " Mins");
                                    System.out.println("Capacity: " + e.getCapacity());
                                }
                                break;
                            case 2:
                                List<Event> Coordinating_events = s.getCoordinating();
                                for(Event e:Coordinating_events) {
                                    System.out.println(e.getEventID() + ". " + e.getName());
                                    System.out.println("Venue:" + e.getLocation());
                                    System.out.println("From: " + e.getStartTime() + " To: " + e.getEndTime() + " on " + e.getDate());
                                    System.out.println("Duration: " + e.getDuration() + " Mins");
                                    System.out.println("Capacity: " + e.getCapacity());
                                }
                                break;
                            case 3:
                                System.out.println("Select Event from the list");
                                int event_idx = sc.nextInt();
                                sc.nextLine();
                                Event e = eventManager.getEvents().get(event_idx - 1);
                                boolean success = true;
                                try{
                                    e.setRegistered(s);
                                }
                                catch(Exception ex){
                                    System.out.println("Exception Caught "+ ex);
                                    success = false;
                                }
                                if(success){
                                    s.RegisterEvent(e);
                                }
                                break;
                            case 4:
                                System.out.println("Select Event from the list");
                                int idx = sc.nextInt();
                                sc.nextLine();
                                Event event = eventManager.getEvents().get(idx - 1);
                                s.DeregisterEvent(event);
                                break;
                            case 5:
                                brk = true;
                                break;
                            default:
                                break;
                        }
                        if(brk){
                            break;
                        }
                    }

            }
        }


    }
}