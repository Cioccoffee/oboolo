package a4if1.insa.com.oboolo;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.Calendar;

public class Event extends WeekViewEvent {

    enum Type {Examen, Revision};

    Type type;
    String matière;

    public Event(Type type, String matière) {
        this.type = type;
        this.matière = matière;
    }

    public Event(long id, String name, int startYear, int startMonth, int startDay, int startHour, int startMinute, int endYear, int endMonth, int endDay, int endHour, int endMinute, Type type, String matière) {
        super(id, name, startYear, startMonth, startDay, startHour, startMinute, endYear, endMonth, endDay, endHour, endMinute);
        this.type = type;
        this.matière = matière;
    }

    public Event(long id, String name, String location, Calendar startTime, Calendar endTime, Type type, String matière) {
        super(id, name, location, startTime, endTime);
        this.type = type;
        this.matière = matière;
    }

    public Event(long id, String name, Calendar startTime, Calendar endTime, Type type, String matière) {
        super(id, name, startTime, endTime);
        this.type = type;
        this.matière = matière;
    }

    public Type getType() {
        return type;
    }

    public String getMatière() {
        return matière;
    }

    public void setType(Type type){
        this.type = type;
    }

    public void setMatière(String matière) {
        this.matière = matière;
    }
}
