package org.qulix.test_task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping
    public String getAllProjects() {
        return "task/tasks";
    }
}
