package uz.pdp.online.Service.Interfaces;

public interface CrudRepo<T> {
    void create();

    void read();

    void update();

    void delete();

    void crudMenyu();
}
