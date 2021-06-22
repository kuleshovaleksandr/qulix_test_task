package org.qulix.test_task.controller;

import org.qulix.test_task.dao.ProjectDao;
import org.qulix.test_task.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectDao projectDao;

    @Autowired
    public ProjectController(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @GetMapping
    public String getAllProjects(Model model) {
        model.addAttribute("project", projectDao.findAll());
        return "project/projects";
    }

    @GetMapping("/{id}")
    public String getProject(@PathVariable("id") int id, Model model) {
        model.addAttribute("project", projectDao.findById(id));
        return "project/show";
    }

    @GetMapping("/new")
    public String createProject(@ModelAttribute("project") Project project) {
        return "project/new";
    }

    @PostMapping
    public String saveProject(@ModelAttribute("project") @Valid Project project) {
        projectDao.create(project);
        return "redirect:/projects";
    }

    @GetMapping("/{id}/edit")
    public String editProject(Model model, @PathVariable("id") int id) {
        model.addAttribute("project", projectDao.findById(id));
        return "project/edit";
    }

    @PatchMapping("/{id}")
    public String updateProject(@ModelAttribute("project") @Valid Project project,
                         @PathVariable("id") int id) {
        projectDao.update(id, project);
        return "redirect:/projects";
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable("id") int id) {
        projectDao.delete(id);
        return "redirect:/projects";
    }
}
