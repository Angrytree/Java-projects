package com.luckers.timetable.services;


import com.luckers.timetable.entities.Group;

/**
 * Created by ihor on 27.04.2015.
 */
public interface GroupService {
    public void addGroup(Group group);
    public void margeGroup(Group group);
    public Group findGroup(int group_id);
}
