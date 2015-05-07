package com.luckers.timetable.entities;

import com.luckers.timetable.staticinfo.StaticInfo;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by ihor on 27.04.2015.
 */
@Entity
public class Lecturer {
    /**
     * @param id
     * @param firstName
     * @param lastName
     * @param degree
     */
    public Lecturer(
            @Min(value = StaticInfo.LECTOR_ID_MIN_VALUE) int id,
            @Size(min = StaticInfo.LECTOR_FIRST_NAME_MIN_VALUE, max = StaticInfo.LECTOR_FIRST_NAME_MAX_VALUE) String firstName,
            @Size(min = StaticInfo.LECTOR_LAST_NAME_MIN_VALUE, max = StaticInfo.LECTOR_LAST_NAME_MAX_VALUE) String lastName,
            String degree) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
    }

    public Lecturer() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(@Min(value = StaticInfo.LECTOR_ID_MIN_VALUE) int id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(
            @Size(min = StaticInfo.LECTOR_FIRST_NAME_MIN_VALUE, max = StaticInfo.LECTOR_FIRST_NAME_MAX_VALUE) String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(
            @Size(min = StaticInfo.LECTOR_LAST_NAME_MIN_VALUE, max = StaticInfo.LECTOR_LAST_NAME_MAX_VALUE) String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the degree
     */
    public String getDegree() {
        return degree;
    }

    /**
     * @param degree
     *            the degree to set
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Lector [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", degree=" + degree + "]";
    }

    @Id @GeneratedValue
    @Min(value = StaticInfo.LECTOR_ID_MIN_VALUE)
    private int id;

    @Size(min = StaticInfo.LECTOR_FIRST_NAME_MIN_VALUE, max = StaticInfo.LECTOR_FIRST_NAME_MAX_VALUE)
    private String firstName;

    @Size(min = StaticInfo.LECTOR_LAST_NAME_MIN_VALUE, max = StaticInfo.LECTOR_LAST_NAME_MAX_VALUE)
    private String lastName;

    @Size(min = StaticInfo.LECTOR_LAST_DEGREE_VALUE, max = StaticInfo.LECTOR_DEGREE_MAX_VALUE)
    private String degree;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "lecturer")
    private List<Group> groups;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecturer lecturer = (Lecturer) o;

        if (id != lecturer.id) return false;
        if (degree != null ? !degree.equals(lecturer.degree) : lecturer.degree != null) return false;
        if (firstName != null ? !firstName.equals(lecturer.firstName) : lecturer.firstName != null) return false;
        if (groups != null ? !groups.equals(lecturer.groups) : lecturer.groups != null) return false;
        if (lastName != null ? !lastName.equals(lecturer.lastName) : lecturer.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (groups != null ? groups.hashCode() : 0);
        return result;
    }
}
