package org.qulix.test_task.controller;

import org.qulix.test_task.dao.TaskDao;
import org.qulix.test_task.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskDao taskDao;

    @Autowired
    public TaskController(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @GetMapping
    public String getAllTask(Model model) {
        model.addAttribute("task", taskDao.findAll());
        return "task/tasks";
    }

    @GetMapping("/{id}")
    public String getTask(@PathVariable("id") int id, Model model) {
        model.addAttribute("task", taskDao.findById(id));
        return "task/show";
    }

    @GetMapping("/new")
    public String createTask(@ModelAttribute("task") Task task) {
        return "task/new";
    }

    @PostMapping
    public String saveTask(@ModelAttribute("task") @Valid Task task) {
        taskDao.create(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String editTask(Model model, @PathVariable("id") int id) {
        model.addAttribute("task", taskDao.findById(id));
        return "task/edit";
    }

    @PatchMapping("/{id}")
    public String updateTask(@ModelAttribute("task") @Valid Task task,
                         @PathVariable("id") int id) {
        taskDao.update(id, task);
        return "redirect:/tasks";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskDao.delete(id);
        return "redirect:/tasks";
    }
}
