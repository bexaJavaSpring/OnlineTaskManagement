package uz.pdp.online.Service.Action;

import uz.pdp.online.model.User;

import static uz.pdp.online.repository.Database.users;

public class FindObject {
    public User checkUser(String username){
        return users.stream().filter(user -> user.getUserName().equals(username)).findFirst().orElse(null);
    }
}
