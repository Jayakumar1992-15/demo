package com.example.java;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    
    static class Task {
        private String description;
        private boolean done;
        
        public Task(String description) {
            this.description = description;
            this.done = false;
        }
        
        public String getDescription() {
            return description;
        }
        
        public boolean isDone() {
            return done;
        }
        
        public void setDone(boolean done) {
            this.done = done;
        }
        
        /**
         * Returns a string representation of the task.
         * 
         * The string includes a checkbox indicator followed by the task description.
         * A completed task is marked with [✓], while an incomplete task is marked with [ ].
         * 
         * @return a formatted string showing the task's completion status and description
         */
        @Override
        public String toString() {
            return (done ? "[✓] " : "[ ] ") + description;
        }
    }
    
    private List<Task> tasks;
    
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }
    
    public void addTask(String description) {
        tasks.add(new Task(description));
    }
    
    public List<Task> listTasks() {
        return new ArrayList<>(tasks);
    }
    
    public boolean markTaskAsDone(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                task.setDone(true);
                return true;
            }
        }
        return false;
    }

    public void removeTask(String description) {
        tasks.removeIf(task -> task.getDescription().equals(description));
    }
}