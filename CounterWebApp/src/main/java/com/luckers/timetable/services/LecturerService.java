package com.luckers.timetable.services;

import com.luckers.timetable.entities.Lecturer;

/**
 * Created by ihor on 27.04.2015.
 */
public interface LecturerService {
    public void addLecturer(Lecturer lecturer);
    public void updateLecturer(Lecturer lecturer);
    public Lecturer findLecturer(int lecturer_id);
}
