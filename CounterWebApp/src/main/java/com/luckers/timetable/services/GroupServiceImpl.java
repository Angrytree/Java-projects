package com.luckers.timetable.services;

import com.luckers.timetable.dao.DAO;
import com.luckers.timetable.entities.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ihor on 27.04.2015.
 */
@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private DAO dao;

    @Override
    public void addGroup(Group group) {
        dao.insertGroup(group);
    }

    @Override
    public void margeGroup(Group group) {
        dao.updateGroup(group);
    }

    @Override
    public Group findGroup(int group_id) {
        return dao.selectGroupById(group_id);
    }
}
