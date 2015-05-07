package com.luckers.timetable.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by ihor on 27.04.2015.
 */
@Entity
public class Timetable {

    @Id @GeneratedValue
    private Integer id;

    @NotNull @ManyToOne @JoinColumn(name="group_id")
    private Group group;

    @NotNull @Column(name="lesson_number")
    @Pattern(regexp = "/[1-6]/")
    private int lessonNumber;

    @NotNull @ManyToOne @JoinColumn(name="classroom_id")
    private Classroom classroom;

    @NotNull @ManyToOne @JoinColumn(name="week_id")
    private Week week;

    @NotNull @Enumerated(EnumType.STRING)
    private Day day;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Timetable timetable = (Timetable) o;

        if (lessonNumber != timetable.lessonNumber) return false;
        if (classroom != null ? !classroom.equals(timetable.classroom) : timetable.classroom != null) return false;
        if (day != timetable.day) return false;
        if (group != null ? !group.equals(timetable.group) : timetable.group != null) return false;
        if (id != null ? !id.equals(timetable.id) : timetable.id != null) return false;
        if (week != null ? !week.equals(timetable.week) : timetable.week != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + lessonNumber;
        result = 31 * result + (classroom != null ? classroom.hashCode() : 0);
        result = 31 * result + (week != null ? week.hashCode() : 0);
        result = 31 * result + (day != null ? day.hashCode() : 0);
        return result;
    }
}
