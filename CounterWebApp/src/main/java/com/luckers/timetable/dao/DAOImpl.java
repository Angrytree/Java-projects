package com.luckers.timetable.dao;

import com.luckers.timetable.entities.*;
import org.hibernate.dialect.MySQL5Dialect;

import com.googlecode.ehcache.annotations.Cacheable;
import com.luckers.timetable.entities.Group;
import com.luckers.timetable.entities.Lecturer;
import com.luckers.timetable.entities.Subject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ihor on 27.04.2015.
 */
@Repository
@Transactional
public class DAOImpl implements DAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertGroup(Group group) {
           entityManager.persist(group);
    }

    @Override
    public void updateGroup(Group group) {
        entityManager.merge(group);
    }

    @Cacheable(cacheName = "groupCache")
    @Override
    public Group selectGroupById(int groupId) {
        return entityManager.find(Group.class,groupId);
    }

    @Override
    public void insertLecturer(Lecturer lecturer) {
            entityManager.persist(lecturer);
    }

    @Override
    public void updateLecturer(Lecturer lecturer) {
        entityManager.merge(lecturer);
    }
    @Cacheable(cacheName = "lecturersCache")
    @Override
    public Lecturer selectLecturerById(int lecturerId) {
        return entityManager.find(Lecturer.class,lecturerId);
    }

    @Override
    public void insertSubject(Subject subject) {
          entityManager.persist(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        entityManager.merge(subject);
    }
    @Cacheable(cacheName = "subjectCache")
    @Override
    public Subject selectSubjectById(int subjectId) {
        return entityManager.find(Subject.class,subjectId);
    }

    @Override
    public void insertWeek(Week week) {
        entityManager.persist(week);
    }

    @Override
    public Week selectWeekById(int id) {
        Week week = entityManager.find(Week.class, id);
        return week;
    }

    @Override
    public void addClassroom(Classroom classroom) {
        entityManager.persist(classroom);
    }

    @Override
    public void updateClassroom(Classroom classroom) {
        entityManager.merge(classroom);
    }

    @Override
    public Classroom selectClassroomById(int id) {
        return entityManager.find(Classroom.class, id);
    }
}
