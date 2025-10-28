package model;

import java.sql.Time;

public class Schedule {
    private int id;
    private int userId;
    private String dayOfWeek;
    private String title;
    private Time startTime;
    private Time endTime;
    private String note;

    public Schedule(int id, int userId, String dayOfWeek, String title, Time startTime, Time endTime, String note) {
        this.id = id;
        this.userId = userId;
        this.dayOfWeek = dayOfWeek;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.note = note;
    }

    // getter/setter...
}
