package uz.pdp.online.Service.admin.action;

import uz.pdp.online.Service.Interfaces.CrudRepo;

import uz.pdp.online.model.TaskStatus;
import uz.pdp.online.repository.Database;

import java.util.Scanner;

import static uz.pdp.online.helpers.Messages.*;
import static uz.pdp.online.repository.Database.taskStatuses;

public class TAskStatusService implements CrudRepo<TaskStatus>{
public static final Scanner SCANNER_STR=new Scanner(System.in);
public static final Scanner SCANNER_NUM=new Scanner(System.in);
    @Override
    public void create() {
        System.out.print("Enter name:");
        String name=SCANNER_STR.nextLine();
        TaskStatus taskStatus=new TaskStatus((int)(Math.random()*10000),name);
        taskStatuses.add(taskStatus);
        System.out.println(CREATED);
    }
    @Override
    public void read() {
        if(taskStatuses.isEmpty()){
            System.out.println(NOT_FOUND);
        }else{
            taskStatuses.stream().forEach(taskStatus -> System.out.println("TaskStatus{ id: "+taskStatus.getId()+" ,name:"+taskStatus.getName()+" }"));
        }
    }

    @Override
    public void update() {
     TaskStatus taskStatus=returnObject();
     if(taskStatus!=null){
         System.out.print("Enter new name: ");
         String name=SCANNER_STR.nextLine();
         taskStatus.setName(name);
         System.out.println(UPDATED);
     }else{
         System.out.println(NOT_FOUND);
     }
    }
    @Override
    public void delete() {
        TaskStatus taskStatus=returnObject();
        if(taskStatus!=null){
       taskStatuses.remove(taskStatus);
            System.out.println(DELETED);
        }else{
            System.out.println(NOT_FOUND);
        }
    }

  public  TaskStatus returnObject() {
        read();
        System.out.print("Enter status's id: ");
        int statusid=SCANNER_NUM.nextInt();
        return taskStatuses.stream().filter(taskStatus -> taskStatus.getId()==statusid).findFirst().orElse(null);
    }

    @Override
    public void crudMenyu() {
     while (true){
         System.out.println("1.Task Status LIst ");
         System.out.println("2.ADD Status ");
         System.out.println("3.Edit Status ");
         System.out.println("4.Deleted Status ");
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
