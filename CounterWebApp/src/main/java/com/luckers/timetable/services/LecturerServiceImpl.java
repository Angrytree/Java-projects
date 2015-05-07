package com.luckers.timetable.services;

import com.luckers.timetable.dao.DAO;
import com.luckers.timetable.entities.Lecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Created by ihor on 27.04.2015.
 */
@Service
@Lazy
public class LecturerServiceImpl implements LecturerService {
    @Autowired
    private DAO dao;

    @Override
    public void addLecturer(Lecturer lecturer) {
          dao.insertLecturer(lecturer);
    }

    @Override
    public void updateLecturer(Lecturer lecturer) {
         dao.updateLecturer(lecturer);
    }

    @Override
    public Lecturer findLecturer(int lecturer_id) {
         return dao.selectLecturerById(lecturer_id);
    }
}
