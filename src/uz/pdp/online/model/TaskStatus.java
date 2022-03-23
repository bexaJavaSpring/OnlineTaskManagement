package uz.pdp.online.model;

public class TaskStatus {
    private Integer id;
    private String name;


    public TaskStatus(Integer id, String name) {
        this.id = id;
        this.name = name;

    }

    public TaskStatus() {
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

    @Override
    public String toString() {
        return "TaskStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
