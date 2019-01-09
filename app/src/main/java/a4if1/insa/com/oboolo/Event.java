package a4if1.insa.com.oboolo;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.Calendar;

public class Event extends WeekViewEvent {

    enum Type {Exam, Revision};
    enum Frequency {Once, Day, Week, Month}

    Type type;
    String course;
    Frequency frequency;

    public Event(Type type, String course) {
        this.type = type;
        this.course = course;
    }

    public Event(long id, String name, int startYear, int startMonth, int startDay, int startHour, int startMinute, int endYear, int endMonth, int endDay, int endHour, int endMinute, Type type, String course, Frequency frequency) {
        super(id, name, startYear, startMonth, startDay, startHour, startMinute, endYear, endMonth, endDay, endHour, endMinute);
        this.type = type;
        this.course = course;
        this.frequency = frequency;
    }

    public Event(long id, String name, String location, Calendar startTime, Calendar endTime, Type type, String course, Frequency frequency) {
        super(id, name, location, startTime, endTime);
        this.type = type;
        this.course = course;
        this.frequency = frequency;
    }

    public Event(long id, String name, Calendar startTime, Calendar endTime, Type type, String course, Frequency frequency) {
        super(id, name, startTime, endTime);
        this.type = type;
        this.course = course;
        this.frequency = frequency;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type){
        this.type = type;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Frequency getFrequency() { return frequency; }

    public void setFrequency(Frequency frequency) { this.frequency = frequency; }
}
