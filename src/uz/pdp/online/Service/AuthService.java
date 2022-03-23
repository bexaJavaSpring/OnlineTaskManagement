package uz.pdp.online.Service;

import uz.pdp.online.Service.Action.FindObject;
import uz.pdp.online.Service.Interfaces.AuthRepo;
import uz.pdp.online.Service.Interfaces.UserBuilder;
import uz.pdp.online.Service.admin.AdminService;
import uz.pdp.online.Service.user.UserService;
import uz.pdp.online.model.User;
import uz.pdp.online.helpers.Messages.*;
import java.util.Scanner;

import static uz.pdp.online.helpers.Messages.*;
import static uz.pdp.online.repository.Database.users;

public class AuthService implements AuthRepo<User> {
    public static final Scanner SCANNER_STR=new Scanner(System.in);
    public static final Scanner SCANNER_NUM=new Scanner(System.in);
static FindObject findObject=new FindObject();
static AdminService adminService=new AdminService();
static UserService userService=new UserService();

    @Override
    public void login() {
        System.out.print("Enter username: ");
        String username=SCANNER_STR.nextLine();
        System.out.print("Enter password: ");
        String password=SCANNER_STR.nextLine();

        User user=users.stream().filter(user1 -> user1.getUserName().equals(username) && user1.getPassword().equals(password)).findFirst().orElse(null);
        if(user!=null){
            switch (user.getRole()){
                case ADMIN: {
                    adminService.adminMenyu(user);
                    break;
                }
                case USER: {
                    userService.userMenyu(user);
                    break;
                }
            }
        }else{
            System.out.println("Login yoki parol xato 😒");
        }
    }

    @Override
    public void register() {
        System.out.println("Enter username: ");
        String username=SCANNER_STR.nextLine();
        System.out.println("Enter password: ");
        String password=SCANNER_STR.nextLine();
        User user=findObject.checkUser(username);
        if(user!=null){
            System.out.println(USERNAME_EXIST);
            return;
        }
        UserBuilder userBuilder=User::new;
        users.add(userBuilder.build((int)(Math.random()*100),username,password));
        System.out.println(CREATED);
    }

    @Override
    public void userList() {
      users.stream().forEach(user -> System.out.println("User{ id: "+user.getId()+" ,username:"+user.getUserName()+" }"));
    }

    @Override
    public User returnObject() {
     userList();
        System.out.println("Enter id: ");
        int userid=SCANNER_NUM.nextInt();
        return users.stream().filter(user -> user.getId()==userid).findFirst().orElse(null);
    }
}
