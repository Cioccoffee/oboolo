package a4if1.insa.com.oboolo;

import android.util.Log;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class EventList {

    LinkedList<Event> eventList = new LinkedList<>();

    //WeekViewEvent(long id, String name, int startYear, int startMonth, int startDay, int startHour, int startMinute, int endYear, int endMonth, int endDay, int endHour, int endMinute) {

    //IE
    Event weekViewEvent1 =
            new Event(1, "IE - Physique",
                    2019, 1, 7, 16, 0,
                    2019, 1, 7, 17, 30,
                    Event.Type.Examen, "Physique");
    Event weekViewEvent2 =
            new Event(2, "IE - Thermodynamique",
                    2019, 1, 14, 16, 0,
                    2019, 1, 14, 17, 30,
                    Event.Type.Examen, "Thermodynamique");

    //DM
    Event weekViewEvent3 =
            new Event(3, "DM - Mathématiques",
                    2019, 1, 17, 10, 0,
                    2019, 1, 17, 12, 0,
                    Event.Type.Examen, "Mathématiques");

    //Partiels
    Event weekViewEvent4 =
            new Event(4, "Partiel - Physique",
                    2019, 1, 28, 9, 0,
                    2019, 1, 28, 12, 0,
                    Event.Type.Examen, "Physique");
    Event weekViewEvent5 =
            new Event(5, "Partiel - Mathématiques",
                    2019, 1, 30, 9, 0,
                    2019, 1, 30, 2, 0,
                    Event.Type.Examen, "Mathématiques");
    Event weekViewEvent6 =
            new Event(6, "Partiel - Informatique",
                    2019, 1, 29, 14, 0,
                    2019, 1, 29, 16, 0,
                    Event.Type.Examen, "Informatique");
    Event weekViewEvent7 =
            new Event(7, "Partiel - Thermodynamique",
                    2019, 1, 29, 10, 0,
                    2019, 1, 29, 12, 0,
                    Event.Type.Examen, "Thermodynamique");

    //Révisions
    Event weekViewEvent8 =
            new Event(8, "Révision - Thermodynamique",
                    2019, 1, 9, 20, 0,
                    2019, 1, 9, 22, 0,
                    Event.Type.Revision, "Thermodynamique");
    Event weekViewEvent9 =
            new Event(9, "Révision - Thermodynamique",
                    2019, 1, 12, 14, 0,
                    2019, 1, 12, 17, 0,
                    Event.Type.Revision, "Thermodynamique");
    Event weekViewEvent10 =
            new Event(10, "Révision - Thermodynamique",
                    2019, 1, 13, 14, 0,
                    2019, 1, 13, 17, 0,
                    Event.Type.Revision, "Thermodynamique");




    private EventList() {
        eventList.add(weekViewEvent1);
        eventList.add(weekViewEvent2);
        eventList.add(weekViewEvent3);
        eventList.add(weekViewEvent4);
        eventList.add(weekViewEvent5);
        eventList.add(weekViewEvent6);
        eventList.add(weekViewEvent7);
        eventList.add(weekViewEvent8);
        eventList.add(weekViewEvent9);
        eventList.add(weekViewEvent10);
    }

    private static EventList INSTANCE = new EventList();

    public static EventList getInstance() {
        return INSTANCE;
    }

    public LinkedList<Event> getList(){
        return eventList;
    }

    public LinkedList<Event> getEvents(int year, int month){
        LinkedList<Event> result = new LinkedList<>();

        for(int i = 0; i < eventList.size(); i++){
            Event event = eventList.get(i);
            Log.v("EVENTS","Month : "+event.getStartTime().get(Calendar.MONTH)+" | Year : "+event.getStartTime().get(Calendar.YEAR));
            if( event.getStartTime().get(Calendar.YEAR) == year &&
                    event.getStartTime().get(Calendar.MONTH) == month-1)
                result.add(event);
        }
        return result;
    }

    public Event getEvent(int i){
        return eventList.get(i);
    }
}
