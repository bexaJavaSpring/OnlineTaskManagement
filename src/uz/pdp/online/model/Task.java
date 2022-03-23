package uz.pdp.online.model;


import sun.util.calendar.BaseCalendar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private Integer id;
    private String name;
    private String description;
    private TaskStatus status;
    private User user;
    private LocalDateTime startDate=LocalDateTime.now();
    private LocalDateTime endDate=LocalDateTime.of(2021,12,5,20,0,0);


    public Task() {
    }

    public Task(Integer id, String name, String description, TaskStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;

    }
    public Task(Integer id, String name, String description,TaskStatus status, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }
public String startFormat(){
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm::ss");
    return startDate.format(formatter);
}
    public String endFormat(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm::ss");
        return endDate.format(formatter);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", user=" + user +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
