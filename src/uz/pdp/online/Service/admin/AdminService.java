package uz.pdp.online.Service.admin;

import uz.pdp.online.Service.admin.action.SubTaskService;
import uz.pdp.online.Service.admin.action.TAskStatusService;
import uz.pdp.online.Service.admin.action.TaskService;
import uz.pdp.online.Service.admin.action.UserServiceAction;
import uz.pdp.online.model.User;

import java.util.Scanner;

import static uz.pdp.online.repository.Database.taskStatuses;

public class AdminService {
    public static final Scanner SCANNER_STR=new Scanner(System.in);
    public static final Scanner SCANNER_NUM=new Scanner(System.in);
    static TaskService taskService = new TaskService();
 static TAskStatusService taskStatusService=new TAskStatusService();
 static SubTaskService subTaskService=new SubTaskService();
 static UserServiceAction userServiceAction=new UserServiceAction();

 public void adminMenyu(User user) {
        while (true){
            if(taskStatuses.isEmpty()) {
                System.out.println("! Eslatma: avval taskni status yarating,keyin task yarating( yani 4 tugmasini bosing)");
            }else {
                System.out.println("✔✔✔");
            }
            System.out.println("1.CRUD Task");
            System.out.println("2.CRUD SubTask");
            System.out.println("3.User Action");
            System.out.println("4.CRUD Task Status");
            System.out.println("0.LOGOUT");
            int option=SCANNER_NUM.nextInt();
            switch (option){
                case 1:
                taskService.crudMenyu();
                break;

                case 2:
                    subTaskService.crudMenyu();
                break;

                case 3:
                    userServiceAction.divideMenu(user);
                break;

                case 4:
                    taskStatusService.crudMenyu();
                break;

                case 0:
                    return;

            }
        }
    }
}
