package uz.pdp.online.Service.admin.action;

import uz.pdp.online.Service.Interfaces.CrudRepo;
import uz.pdp.online.model.Subtask;
import uz.pdp.online.model.Task;
import uz.pdp.online.model.TaskStatus;

import java.util.Scanner;

import static uz.pdp.online.helpers.Messages.*;
import static uz.pdp.online.repository.Database.subtasks;

public class SubTaskService implements CrudRepo<Subtask> {
    public static final Scanner SCANNER_STR=new Scanner(System.in);
    public static final Scanner SCANNER_NUM=new Scanner(System.in);
static TaskService taskService=new TaskService();
static TAskStatusService tAskStatusService=new TAskStatusService();

    @Override
    public void create() {
        Task task = taskService.returnObject();
        if (task != null) {

            System.out.print("Enter subtask name: ");
            String name =SCANNER_STR.nextLine();
            TaskStatus taskStatus = tAskStatusService.returnObject();
            if (taskStatus != null) {
                Subtask subTask = new Subtask((int) (Math.random() * 10000), name, taskStatus,task);
                subtasks.add(subTask);
                System.out.println(CREATED);
            } else {
                System.out.println(NOT_FOUND);
                return;
            }

        } else {
            System.out.println(NOT_FOUND);
        }
    }

    @Override

    public void read() {
        if(subtasks.isEmpty()){
            System.out.println(NOT_FOUND);
        }else{
            subtasks.stream().forEach(subtask -> System.out.println("SubTask{ id: "+subtask.getId()+" ,name:"+subtask.getName()+" ,task:"+subtask.getTask().getName()+" ,status:"+subtask.getStatus()+" ,startTime:"+subtask.starFormat()+" ,endTime:"+subtask.endFormat()+" }"));
        }
          }

    @Override
    public void update() {
Subtask subtask=returnObject();
if(subtask!=null){
    System.out.print("Enter new name: ");
    String name=SCANNER_STR.nextLine();
    TaskStatus taskStatus=tAskStatusService.returnObject();
    if(taskStatus!=null){
        subtask.setName(name);
        System.out.println(UPDATED);
        subtask.setStatus(taskStatus);
    }else{
        System.out.println(NOT_FOUND);
        return;
    }
}else{
    System.out.println(NOT_FOUND);
    }
    }

    @Override
    public void delete() {
Subtask subtask=returnObject();
if(subtask!=null){
    subtasks.remove(subtask);
    System.out.println(DELETED);
}else{
    System.out.println(NOT_FOUND);
}
    }

   public Subtask returnObject() {
        read();
        System.out.print("Enter id: ");
        int subtaskid=SCANNER_NUM.nextInt();
        return subtasks.stream().filter(subtask -> subtask.getId()==subtaskid).findFirst().orElse(null);
    }

    @Override
    public void crudMenyu() {
    while (true){
        System.out.println("1.SubTask List");
        System.out.println("2.ADD SubTask");
        System.out.println("3.Edit SubTask");
        System.out.println("4.Delete SubTask");
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