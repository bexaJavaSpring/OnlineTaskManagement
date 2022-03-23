package uz.pdp.online.Service.Interfaces;

import uz.pdp.online.model.User;

public interface DivideTask<T,S> {
    void usersListByAllTask(User user);

    void usersListByTask(User user);

    void usersListBySubTask(User user);

    void divideTaskByUser();

    void divideSubTaskByUser();

    void changeTask(User user);

    void changeSubTask(User user);

    void divideTaskMenu();

    void divideMenu(User user);

}
