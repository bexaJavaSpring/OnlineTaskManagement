package uz.pdp.online.model;

import uz.pdp.online.model.Enums.UserRole;



public class User {
    private Integer id;
    private String userName;
    private String password;
    private String email;
  private UserRole role=UserRole.USER;

  public User(Integer id, String username, String password,UserRole role) {
        this.id = id;
        this.userName = username;
        this.password = password;
        this.role=role;
    }
    public User(Integer id, String username, String password) {
        this.id = id;
        this.userName = username;
        this.password = password;

    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
