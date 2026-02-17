package com.example.java;

public class TaskManagerMain {
 public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        
        taskManager.addTask("Buy groceries");
        taskManager.addTask("Finish homework");
        taskManager.addTask("Call mom");
        
        System.out.println("Tasks:");
        for (TaskManager.Task task : taskManager.listTasks()) {
            System.out.println(task);
        }
        
        System.out.println("\nMarking 'Finish homework' as done...");
        taskManager.markTaskAsDone("Finish homework");
        
        System.out.println("\nUpdated Tasks:");
        for (TaskManager.Task task : taskManager.listTasks()) {
            System.out.println(task);
        }

        System.out.println("\nRemoving 'Finish homework' ...");
        taskManager.removeTask("Finish homework");

         System.out.println("\nRemaining Tasks:");
        for (TaskManager.Task task : taskManager.listTasks()) {
            System.out.println(task);
        }
    }  
}
