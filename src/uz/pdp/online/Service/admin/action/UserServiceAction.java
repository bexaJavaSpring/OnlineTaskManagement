package uz.pdp.online.Service.admin.action;

import uz.pdp.online.Service.AuthService;
import uz.pdp.online.Service.Interfaces.DivideTask;
import uz.pdp.online.model.Subtask;
import uz.pdp.online.model.Task;
import uz.pdp.online.model.TaskStatus;
import uz.pdp.online.model.User;

import java.util.Scanner;

import static uz.pdp.online.helpers.Messages.NOT_FOUND;
import static uz.pdp.online.helpers.Messages.SUCCESS;
import static uz.pdp.online.repository.Database.subtasks;
import static uz.pdp.online.repository.Database.tasks;

public class UserServiceAction implements DivideTask<Task, Subtask> {
    public static final Scanner SCANNER_STR=new Scanner(System.in);
    public static final Scanner SCANNER_NUM=new Scanner(System.in);
static AuthService authService=new AuthService();
static TaskService taskService=new TaskService();
static SubTaskService subTaskService=new SubTaskService();
static TAskStatusService tAskStatusService=new TAskStatusService();
    @Override
    public void usersListByAllTask(User user) {
     switch (user.getRole()){
         case ADMIN:
             usersListByTask(user);
             usersListBySubTask(user);
          break;

         case USER:
             tasks.stream().filter(task -> task.getUser().equals(user)).forEach(task -> System.out.println("Task{ id: " + task.getId() + " ,name:" + task.getName() + " ,status:" + task.getStatus() + " ,user:" + task.getUser().getUserName()+" }"));
             subtasks.stream().filter(subtask -> subtask.getUser().equals(user)).forEach(subtask -> System.out.println("Task{ id: "+subtask.getId()+" ,name:"+subtask.getName()+" ,status:"+subtask.getStatus()+" ,user:"+subtask.getUser().getUserName()+" }"));
         break;

     }
    }

    @Override
    public void usersListByTask(User user) {
      switch (user.getRole()){
          case ADMIN:
              tasks.stream().filter(task ->task.getUser()!=null).forEach(task -> System.out.println("Task{ id: "+task.getId()+" ,name:"+task.getName()+" ,status: "+task.getStatus()+" ,user: "+task.getUser().getUserName()+" }"));
          break;

          case USER:
              tasks.stream().filter(task -> task.getUser().equals(user)).forEach(task -> System.out.println("Task{ id: "+task.getId()+" ,name:"+task.getName()+" ,status: "+task.getStatus()+" ,user: "+task.getUser().getUserName()+" }"));
          break;
      }
    }

    @Override
    public void usersListBySubTask(User user) {
         switch (user.getRole()){
             case ADMIN:
                 subtasks.stream().filter(subtask -> subtask.getUser()!=null).forEach(subtask -> System.out.println("SubTask{ id: "+subtask.getId()+" ,name:"+subtask.getName()+" ,status:"+subtask.getStatus()+" ,user:"+subtask.getUser().getUserName()+" }"));
             break;

             case USER:
                 subtasks.stream().filter(subtask -> subtask.getUser().equals(user)).forEach(subtask -> System.out.println("SubTask{ id: "+subtask.getId()+" ,name:"+subtask.getName()+" ,status:"+subtask.getStatus()+" ,user:"+subtask.getUser().getUserName()+" }"));
             break;
         }
    }

    @Override
    public void divideTaskByUser() {
        User user = authService.returnObject();
        if (user != null) {
            Task task = taskService.returnObject();
            if (task != null) {
                task.setUser(user);
                System.out.println(SUCCESS);
            } else {
                System.out.println(NOT_FOUND);
                return;
            }
        } else {
            System.out.println(NOT_FOUND);
        }
    }

    @Override
    public void divideSubTaskByUser() {
        User user = authService.returnObject();
        if (user != null) {
            Subtask  subtask = subTaskService.returnObject();
            if (subtask != null) {
                subtask.setUser(user);
                System.out.println(SUCCESS);
            } else {
                System.out.println(NOT_FOUND);
                return;
            }
        } else {
            System.out.println(NOT_FOUND);
        }
    }

    @Override
    public void changeTask(User user) {
     usersListByTask(user);
        System.out.print("Enter id: ");
        int taskid=SCANNER_NUM.nextInt();
        Task taskselected=tasks.stream().filter(task -> task.getUser().equals(user) && task.getId()==taskid).findFirst().orElse(null);
        if(taskselected!=null){
            TaskStatus taskStatus=tAskStatusService.returnObject();
            if(taskStatus!=null){
                taskselected.setStatus(taskStatus);
                System.out.println(SUCCESS);
            }else{
                System.out.println(NOT_FOUND);
                return;
            }
        }else{
            System.out.println(NOT_FOUND);
        }
    }

    @Override
    public void changeSubTask(User user) {
       usersListBySubTask(user);
        System.out.print("Enter id: ");
        int subtaskid=SCANNER_NUM.nextInt();
        Subtask subtaskselected=subtasks.stream().filter(subtask -> subtask.getUser().equals(user) && subtask.getId()==subtaskid).findFirst().orElse(null);
        if(subtaskselected!=null){
            TaskStatus taskStatus=tAskStatusService.returnObject();
            if(taskStatus!=null){
                subtaskselected.setStatus(taskStatus);
                System.out.println(SUCCESS);
            }else{
                System.out.println(NOT_FOUND);
                return;
            }
        }else{
            System.out.println(NOT_FOUND);
        }
    }

    @Override
    public void divideTaskMenu() {
     while (true){
         System.out.println("1.Task drive");
         System.out.println("2.SubTask drive");
         System.out.println("0.Back");
         int option=SCANNER_NUM.nextInt();
         switch (option){
             case 1:
                 divideTaskByUser();
             break;

             case 2:
                 divideSubTaskByUser();
             break;

             case 0:
                 return;

         }
     }
    }

    @Override
    public void divideMenu(User user) {
      while(true){
          System.out.println("1.Users");
          System.out.println("2.UserBytask");
          System.out.println("3.UserBySubtask");
          System.out.println("4.AllByTaskUser");
          System.out.println("5.DivideTask");
          System.out.println("0.Back");
          int option=SCANNER_NUM.nextInt();
          switch (option){
              case 1:
                  authService.userList();
              break;

              case 2:
                  usersListByTask(user);
              break;

              case 3:
                  usersListBySubTask(user);
              break;

              case 4:
                  usersListByAllTask(user);
                  break;

              case 5:
                  divideTaskByUser();
              break;

              case 0:
                  return;

          }
      }
    }

}
