package com.todo.controller;

import com.todo.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {

    // An in-memory list to save our tasks without needing a database setup yet
    private final List<Task> taskList = new ArrayList<>();

    public TodoController() {
        // Pre-populate with two sample tasks so the website isn't blank on first load
        taskList.add(new Task("Initialize AWS CodePipeline Environment", "High"));
        taskList.add(new Task("Review Maven dependencies for production compilation", "Medium"));
    }

    @GetMapping("/")
    public String viewTasks(Model model) {
        model.addAttribute("tasks", taskList);
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String description, @RequestParam String priority) {
        if (description != null && !description.trim().isEmpty()) {
            taskList.add(new Task(description, priority));
        }
        return "redirect:/"; // Reload the page to show the updated list
    }
}