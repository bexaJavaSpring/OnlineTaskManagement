package uz.pdp.online.Service.Interfaces;

import uz.pdp.online.model.User;

@FunctionalInterface
public interface UserBuilder {
  User build(Integer id,String username,String password);
}
