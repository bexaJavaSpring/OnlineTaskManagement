package uz.pdp.online.Service.Interfaces;

public interface AuthRepo<T> {
    void login();

    void register();

    void userList();

    T returnObject();
}
