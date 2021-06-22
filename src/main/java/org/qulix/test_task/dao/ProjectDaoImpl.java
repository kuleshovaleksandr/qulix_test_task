package org.qulix.test_task.dao;

import org.qulix.test_task.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

@Component
public class ProjectDaoImpl implements ProjectDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProjectDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Project> findAll() {
        return jdbcTemplate.query("SELECT * FROM projects",
                new BeanPropertyRowMapper<>(Project.class));
    }

    @Override
    public Project findById(Integer id) {
        return jdbcTemplate.query("SELECT * FROM projects WHERE id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Project.class))
                .stream().findAny().orElse(null);
    }

    @Override
    public void update(Integer id, Project project) {
        final String UPDATE_SQL = "UPDATE projects SET name = ?, short_name = ?, describe = ? WHERE id = ?";
        jdbcTemplate.update("UPDATE projects SET name = ?, short_name = ?, describe = ? WHERE id = ?",
                project.getName(), project.getShortName(), project.getDescribe(), id);
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection.prepareStatement(UPDATE_SQL,
//                    new String[] {"id"});
//            ps.setString(1, project.getName());
//            ps.setString(2, project.getShortName());
//            ps.setString(3, project.getDescribe());
//            ps.setInt(4, id);
//            return ps;
//        }, keyHolder);
    }

    @Override
    public void create(Project project) {
        final String INSERT_SQL = "INSERT INTO projects (name, short_name, describe) VALUES (?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL,
                    new String[] {"id"});
            ps.setString(1, project.getName());
            ps.setString(2, project.getShortName());
            ps.setString(3, project.getDescribe());
            return ps;
        }, keyHolder);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM projects WHERE id = ?", id);
    }
}
