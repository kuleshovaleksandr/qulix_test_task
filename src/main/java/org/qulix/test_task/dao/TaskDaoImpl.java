package org.qulix.test_task.dao;

import org.qulix.test_task.entity.Task;
import org.qulix.test_task.exception.DBNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

@Component
public class TaskDaoImpl implements TaskDao {

    private final String NOT_FOUND = "There is no such element in database";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Task> findAll() {
        return jdbcTemplate.query("SELECT * FROM tasks",
                new BeanPropertyRowMapper<>(Task.class));
    }

    @Override
    public Task findById(Integer id) {
        return jdbcTemplate.query("SELECT * FROM tasks WHERE id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Task.class))
                .stream().findAny().orElseThrow(() -> new DBNotFoundException(NOT_FOUND));
    }

    @Override
    public void update(Integer id, Task task) {
        final String UPDATE_SQL = "UPDATE tasks SET name = ?, work_time = ?, start_date = ?, end_date = ?, status = ?, project_id = ? WHERE id = ?";
        jdbcTemplate.update(UPDATE_SQL,
                task.getName(), task.getWorkTime(), task.getStartDate(),
                task.getEndDate(), task.getStatus().toString(), task.getProjectId(), id);
    }

    @Override
    public void create(Task task) {
        final String INSERT_SQL = "INSERT INTO tasks (name, work_time, start_date, end_date, status, project_id) VALUES (?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL,
                    new String[] {"id"});
            ps.setString(1, task.getName());
            ps.setInt(2, task.getWorkTime());
            ps.setTimestamp(3, task.getStartDate());
            ps.setTimestamp(4, task.getEndDate());
            ps.setString(5, task.getStatus().toString());
            ps.setInt(6, task.getProjectId());
            return ps;
        }, keyHolder);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM tasks WHERE id = ?", id);
    }
}
