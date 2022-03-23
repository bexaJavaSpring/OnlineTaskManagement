package uz.pdp.online.Service.user;

import uz.pdp.online.Service.admin.action.UserServiceAction;
import uz.pdp.online.model.User;

import java.util.Scanner;

public class UserService {
    public static final Scanner scanne=new Scanner(System.in);
    static UserServiceAction userServiceAction=new UserServiceAction();
    public void userMenyu(User user){
        while(true){
            System.out.println("1: MyTasks");
            System.out.println("2: ChangeMyTaskStatus");
            System.out.println("0: LOGOUT");
            int operation= scanne.nextInt();
            switch (operation){
                case 1:userServiceAction.usersListByTask(user);break;
                case 2:changeMyTaskStatus(user);break;
                case 0:
                    return;
            }
        }
    }

    private void changeMyTaskStatus(User user) {
        while (true){
            System.out.println("1.ChangeMyTaskStatus");
            System.out.println("2.ChangeMySubTaskStatus");
            System.out.println("0.Back");
            int option= scanne.nextInt();
            switch (option){
                case 1:userServiceAction.changeTask(user);break;
                case 2:userServiceAction.changeSubTask(user);break;
                case 0:
                    return;

            }
        }
    }

}
