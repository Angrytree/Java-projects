package com.luckers.timetable.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Created by ihor on 27.04.2015.
 */
@Entity
public class Subject {

    @Id @GeneratedValue
    private Integer id;

    @NotNull @Pattern(regexp = "/^[a-zA-Z]+$/")
    private String name;

    @NotNull
    private Double hours;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "subject")
    @JoinColumn(name = "subject_id")
    private List<Group> groups;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (groups != null ? !groups.equals(subject.groups) : subject.groups != null) return false;
        if (hours != null ? !hours.equals(subject.hours) : subject.hours != null) return false;
        if (id != null ? !id.equals(subject.id) : subject.id != null) return false;
        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        result = 31 * result + (groups != null ? groups.hashCode() : 0);
        return result;
    }
}
