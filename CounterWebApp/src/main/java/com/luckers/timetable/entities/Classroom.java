package com.luckers.timetable.entities;

import com.googlecode.ehcache.annotations.Cacheable;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 27.04.15
 * Time: 11:44
 * To change this template use File | Settings | File Templates.
 */


public class Classroom {
    @Id @GeneratedValue
    @Min(value=0)
    private int id;
    @Min(value=1)
    private int building;
    @Min(value=1)
    private int classroom;
    @Min(value=1)
    private int spaciousness;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "week")
    private List<Timetable> timetables;


    public Classroom(int id, int building, int classroom, int spaciousness) {
        this.id = id;
        this.building = building;
        this.classroom = classroom;
        this.spaciousness = spaciousness;
    }

    public int getSpaciousness() {
        return spaciousness;

    }

    public void setSpaciousness(int spaciousness) {
        this.spaciousness = spaciousness;
    }

    public int getBuilding() {

        return building;
    }


    public void setBuilding(int building) {
        this.building = building;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public Classroom() {
    }

    public int getClassroom() {

        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public List<Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(List<Timetable> timetables) {
        this.timetables = timetables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Classroom classroom1 = (Classroom) o;

        if (building != classroom1.building) return false;
        if (classroom != classroom1.classroom) return false;
        if (id != classroom1.id) return false;
        if (spaciousness != classroom1.spaciousness) return false;
        if (timetables != null ? !timetables.equals(classroom1.timetables) : classroom1.timetables != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + building;
        result = 31 * result + classroom;
        result = 31 * result + spaciousness;
        result = 31 * result + (timetables != null ? timetables.hashCode() : 0);
        return result;
    }
}
