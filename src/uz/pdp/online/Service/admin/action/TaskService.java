package uz.pdp.online.Service.admin.action;

import uz.pdp.online.Service.Interfaces.CrudRepo;
import uz.pdp.online.model.Task;
import uz.pdp.online.model.TaskStatus;
import java.util.Scanner;

import static uz.pdp.online.helpers.Messages.*;
import static uz.pdp.online.repository.Database.tasks;

public class TaskService implements CrudRepo<Task>{
    public static final Scanner SCANNER_STR=new Scanner(System.in);
    public static final Scanner SCANNER_NUM=new Scanner(System.in);
static TAskStatusService tAskStatusService=new TAskStatusService();
    @Override
    public void create() {
        System.out.print("Enter task name: ");
        String name=SCANNER_STR.nextLine();
        System.out.print("Enter task description: ");
        String description=SCANNER_STR.nextLine();
        TaskStatus taskStatus=tAskStatusService.returnObject();
        if(taskStatus!=null){
            Task task=new Task((int)(Math.random()*10000),name,description,taskStatus);
            tasks.add(task);
            System.out.println(CREATED);
        }else{
            System.out.println(NOT_FOUND);
        }
    }

    @Override
    public void read() {
        if(tasks.isEmpty()){
            System.out.println(NOT_FOUND);
        }else{
            tasks.stream().forEach(task -> System.out.println("Task{ id: "+task.getId()+" ,name:"+task.getName()+" ,body:"+task.getDescription()+" ,status:"+task.getStatus()+" ,startTime:"+task.startFormat()+" ,endTime:"+task.endFormat()+" }"));
        }
    }

    @Override
    public void update() {
        Task task=returnObject();
        if(task!=null){
            System.out.print("Enter new name: ");
            String name=SCANNER_STR.nextLine();
            System.out.print("Enter new description: ");
            String description=SCANNER_STR.nextLine();
            System.out.print("Change status: ");
            TaskStatus taskStatus=tAskStatusService.returnObject();
            if(taskStatus!=null){
                task.setName(name);
                task.setDescription(description);
                task.setStatus(taskStatus);
                System.out.println(UPDATED);
            }else{
                System.out.println(NOT_FOUND);
                return;
            }
        }else {
            System.out.println(NOT_FOUND);
        }
    }
    @Override
    public void delete() {
      Task task=returnObject();
      if(task!=null){
          tasks.remove(task);
          System.out.println(DELETED);
      }else {
          System.out.println(NOT_FOUND);
      }
    }

   public Task returnObject() {
        read();
        System.out.print("Enter id: ");
        int taskid=SCANNER_NUM.nextInt();
        return tasks.stream().filter(task -> task.getId()==taskid).findFirst().orElse(null);
    }

    @Override
    public void crudMenyu() {
     while (true){
         System.out.println("1.Task List");
         System.out.println("2.ADD Task");
         System.out.println("3.Edit Task");
         System.out.println("4.Delete Task");
         System.out.println("0.Back");
         int option=SCANNER_NUM.nextInt();
         switch (option){
             case 1:
                 read();
             break;

             case 2:
                 create();
             break;

             case 3:
                 update();
             break;

             case 4:
                 delete();
             break;

             case 0:
                 return;

         }
     }
    }
}
