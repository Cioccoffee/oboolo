package a4if1.insa.com.oboolo;

import android.util.Log;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class EventList {

    LinkedList<WeekViewEvent> eventList = new LinkedList<>();

    //WeekViewEvent(long id, String name, int startYear, int startMonth, int startDay, int startHour, int startMinute, int endYear, int endMonth, int endDay, int endHour, int endMinute) {

    //IE
    WeekViewEvent weekViewEvent1 =
            new WeekViewEvent(1, "IE - Physique",
                    2019, 1, 7, 16, 0,
                    2019, 1, 7, 17, 30);
    WeekViewEvent weekViewEvent2 =
            new WeekViewEvent(2, "IE - Thermodynamique",
                    2019, 1, 14, 16, 0,
                    2019, 1, 14, 17, 30);

    //DM
    WeekViewEvent weekViewEvent3 =
            new WeekViewEvent(3, "DM - Mathématiques",
                    2019, 1, 17, 10, 0,
                    2019, 1, 17, 12, 0);

    //Partiels
    WeekViewEvent weekViewEvent4 =
            new WeekViewEvent(4, "Partiel - Physique",
                    2019, 1, 28, 9, 0,
                    2019, 1, 28, 12, 0);
    WeekViewEvent weekViewEvent5 =
            new WeekViewEvent(5, "Partiel - Mathématiques",
                    2019, 1, 30, 9, 0,
                    2019, 1, 30, 2, 0);
    WeekViewEvent weekViewEvent6 =
            new WeekViewEvent(6, "Partiel - Informatique",
                    2019, 1, 29, 14, 0,
                    2019, 1, 29, 16, 0);
    WeekViewEvent weekViewEvent7 =
            new WeekViewEvent(7, "Partiel - Thermodynamique",
                    2019, 1, 29, 10, 0,
                    2019, 1, 29, 12, 0);

    //Révisions
    WeekViewEvent weekViewEvent8 =
            new WeekViewEvent(8, "Révision - Thermodynamique",
                    2019, 1, 9, 20, 0,
                    2019, 1, 9, 22, 0);
    WeekViewEvent weekViewEvent9 =
            new WeekViewEvent(9, "Révision - Thermodynamique",
                    2019, 1, 12, 14, 0,
                    2019, 1, 12, 17, 0);
    WeekViewEvent weekViewEvent10 =
            new WeekViewEvent(10, "Révision - Thermodynamique",
                    2019, 1, 13, 14, 0,
                    2019, 1, 13, 17, 0);

    


    private EventList() {
        eventList.add(weekViewEvent1);
        eventList.add(weekViewEvent2);
        eventList.add(weekViewEvent3);
        eventList.add(weekViewEvent4);
        eventList.add(weekViewEvent5);
        eventList.add(weekViewEvent6);
        eventList.add(weekViewEvent7);
    }

    private static EventList INSTANCE = new EventList();

    public static EventList getInstance() {
        return INSTANCE;
    }

    public LinkedList<WeekViewEvent> getList(){
        return eventList;
    }

    public LinkedList<WeekViewEvent> getEvents(int year, int month){
        LinkedList<WeekViewEvent> result = new LinkedList<>();

        for(int i = 0; i < eventList.size(); i++){
            WeekViewEvent weekViewEvent = eventList.get(i);
            Log.v("EVENTS","Month : "+weekViewEvent.getStartTime().get(Calendar.MONTH)+" | Year : "+weekViewEvent.getStartTime().get(Calendar.YEAR));
            if( weekViewEvent.getStartTime().get(Calendar.YEAR) == year &&
                    weekViewEvent.getStartTime().get(Calendar.MONTH) == month-1)
                result.add(weekViewEvent);
        }
        return result;
    }
}
