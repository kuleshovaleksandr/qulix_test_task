package org.qulix.test_task.dao;

import org.qulix.test_task.entity.Task;

import java.util.List;

public interface TaskDao {

    List<Task> findAll();

    Task findById(Integer id);

    Task update(Task task);

    Task create(Task task);

    void delete(Integer id);
}
