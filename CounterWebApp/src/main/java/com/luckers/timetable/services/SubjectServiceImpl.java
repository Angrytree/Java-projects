package com.luckers.timetable.services;

import com.luckers.timetable.dao.DAO;
import com.luckers.timetable.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Created by ihor on 27.04.2015.
 */
@Service
@Lazy
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private DAO dao;
    @Override
    public void addSubject(Subject subject) {
           dao.insertSubject(subject);
    }

    @Override
    public void margeSubject(Subject subject) {
           dao.updateSubject(subject);
    }

    @Override
    public Subject findSubject(int subject_id) {
        return dao.selectSubjectById(subject_id);
    }
}
