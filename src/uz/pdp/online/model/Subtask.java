package uz.pdp.online.model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Subtask {
    private Integer id;
    private String name;
    private TaskStatus status;
    private User user;
    private Task task;
    private LocalDateTime startDate=LocalDateTime.now();
    private LocalDateTime endDate=LocalDateTime.now();

    public Subtask(Integer id, String name, TaskStatus status, Task task) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.task = task;
    }
    public String starFormat(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyyHH:mm:");
        return startDate.format(formatter);
    }
    public String endFormat(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyyHH:mm:");
        return endDate.format(formatter);
    }

    public Subtask() {
    }

    public Subtask(Integer id, String name, TaskStatus status,Task task, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.task = task;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", user=" + user +
                ", task=" + task +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
