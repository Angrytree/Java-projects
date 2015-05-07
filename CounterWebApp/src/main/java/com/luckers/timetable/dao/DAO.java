package com.luckers.timetable.dao;

import com.luckers.timetable.entities.*;

/**
 * Created by ihor on 27.04.2015.
 */
public interface DAO {

    public void insertGroup(Group group);
    public void updateGroup(Group group);
    public Group selectGroupById(int groupId);

    public void insertLecturer(Lecturer lecturer);
    public void updateLecturer(Lecturer lecturer);
    public Lecturer selectLecturerById(int lecturerId);

    public void insertSubject(Subject subject);
    public void updateSubject(Subject subject);
    public Subject selectSubjectById(int subjectId);

    public void insertWeek(Week week);
    public Week selectWeekById(int id);

    public void addClassroom(Classroom classroom);
    public void updateClassroom(Classroom classroom);
    public Classroom selectClassroomById(int id);


}
