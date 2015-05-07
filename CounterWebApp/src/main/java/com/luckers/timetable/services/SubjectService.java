package com.luckers.timetable.services;


import com.luckers.timetable.entities.Subject;

/**
 * Created by ihor on 27.04.2015.
 */
public interface SubjectService {
    public void addSubject(Subject subject);
    public void margeSubject(Subject subject);
    public Subject findSubject(int subject_id);
}
