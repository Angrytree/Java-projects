package com.luckers.timetable.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Created by ihor on 27.04.2015.
 */
@Entity
public class Group {

    @Id @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(columnDefinition = "subject_id")
    private Subject subject;

    @NotNull @Pattern(regexp = "/^[a-zA-Z]+$/")
    @Column(name = "group_name")
    private String name;

    @NotNull @Pattern(regexp = "/^[0-9]+$/")
    private int course;

    @NotNull @Pattern(regexp = "/^[0-9]+$/")
    @Column(name = "number_of_students")
    private int numberOfStudents;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="lecturer_id")
    private Lecturer lecturer;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "group")
    private List<Timetable> timetables;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
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

        Group group = (Group) o;

        if (course != group.course) return false;
        if (numberOfStudents != group.numberOfStudents) return false;
        if (id != null ? !id.equals(group.id) : group.id != null) return false;
        if (lecturer != null ? !lecturer.equals(group.lecturer) : group.lecturer != null) return false;
        if (name != null ? !name.equals(group.name) : group.name != null) return false;
        if (subject != null ? !subject.equals(group.subject) : group.subject != null) return false;
        if (timetables != null ? !timetables.equals(group.timetables) : group.timetables != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + course;
        result = 31 * result + numberOfStudents;
        result = 31 * result + (lecturer != null ? lecturer.hashCode() : 0);
        result = 31 * result + (timetables != null ? timetables.hashCode() : 0);
        return result;
    }
}
