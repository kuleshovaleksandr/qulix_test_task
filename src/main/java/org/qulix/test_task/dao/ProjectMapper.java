package org.qulix.test_task.dao;

import org.qulix.test_task.entity.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMapper implements RowMapper<Project> {

    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {
        Project project = new Project();

        project.setId(resultSet.getInt("id"));
        project.setName(resultSet.getString("name"));
        project.setShortName(resultSet.getString("short_name"));
        project.setDescribe(resultSet.getString("describe"));

        return project;
    }
}
