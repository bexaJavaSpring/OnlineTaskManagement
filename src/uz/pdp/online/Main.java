package uz.pdp.online;

import uz.pdp.online.Service.AuthService;

import java.util.Scanner;

public class Main {
    static AuthService authService=new AuthService();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
      boolean Active=true;
      while (Active){
          System.out.println("************** Welcome to Task Mangement ******************");
          System.out.println("Mention😉: if you are a User,press button 1,else press button 2");
          System.out.println("1.Login");
          System.out.println("2.Register");
          System.out.println("0.Exit");
          System.out.print("Select:");
          int option= scanner.nextInt();
          switch (option){
              case 1:
                  authService.login();
              break;

              case 2:
                  authService.register();
              break;

              case 0:
                  Active=false;
                  break;
              
          }
      }
    }
}
