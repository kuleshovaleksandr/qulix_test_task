package org.qulix.test_task.dao;

import org.qulix.test_task.entity.Task;
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
                .stream().findAny().orElse(null);
    }

    @Override
    public void update(Integer id, Task task) {
        final String UPDATE_SQL = "UPDATE tasks SET work_time = ?, start_date = ?, end_date = ?, status = ?, project_id = ? WHERE id = ?";
        jdbcTemplate.update(UPDATE_SQL,
                task.getWorkTime(), task.getStartDate(), task.getEndDate(), task.getStatus(), task.getProjectId(), id);
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection.prepareStatement(UPDATE_SQL,
//                    new String[] {"id"});
//            ps.setString(1, task.getName());
//            ps.setString(2, task.getShortName());
//            ps.setString(3, task.getDescribe());
//            ps.setInt(4, id);
//            return ps;
//        }, keyHolder);
    }

    @Override
    public void create(Task task) {
        final String INSERT_SQL = "INSERT INTO tasks (work_time, start_date, end_date, status, project_id) VALUES (?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL,
                    new String[] {"id"});
            ps.setInt(1, task.getWorkTime());
            ps.setTimestamp(2, task.getStartDate());
            ps.setTimestamp(3, task.getEndDate());
            ps.setString(4, task.getStatus().toString());
            ps.setInt(5, task.getProjectId());
            return ps;
        }, keyHolder);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM tasks WHERE id = ?", id);
    }
}
