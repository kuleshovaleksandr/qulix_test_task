package org.qulix.test_task.mapper;

import org.qulix.test_task.entity.Task;
import org.qulix.test_task.model.Status;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();

        task.setId(resultSet.getInt("id"));
        task.setName(resultSet.getString("name"));
        task.setWorkTime(resultSet.getInt("work_time"));
        task.setStartDate(resultSet.getTimestamp("start_date"));
        task.setEndDate(resultSet.getTimestamp("end_date"));
        task.setStatus(Status.valueOf(resultSet.getString("status")));
        task.setProjectId(resultSet.getInt("project_id"));

        return task;
    }
}
