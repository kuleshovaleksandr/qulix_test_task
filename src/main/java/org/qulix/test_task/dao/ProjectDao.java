package org.qulix.test_task.dao;

import org.qulix.test_task.entity.Project;

import java.util.List;

public interface ProjectDao {

    List<Project> findAll();

    Project findById(Integer id);

    void update(Integer id, Project project);

    void create(Project project);

    void delete(Integer id);
}
