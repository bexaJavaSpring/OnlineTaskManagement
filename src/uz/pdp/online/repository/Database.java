package uz.pdp.online.repository;


import uz.pdp.online.model.Enums.UserRole;
import uz.pdp.online.model.Subtask;

import uz.pdp.online.model.Task;
import uz.pdp.online.model.TaskStatus;
import uz.pdp.online.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public  class Database {
   public static List<User> users=new ArrayList<>(Arrays.asList(new User(1,"Bekhruz","1111",UserRole.ADMIN)));
   public static List<TaskStatus> taskStatuses=new ArrayList<>();
   public static List<Subtask> subtasks=new ArrayList<>();
   public static List<Task> tasks=new ArrayList<>();
}

