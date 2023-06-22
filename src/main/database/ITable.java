package main.database;

import java.util.List;

public interface ITable {
    public void insert(Object object);
    public void deleteAll();
    public List<Object> getAll();
    public void createTable();
}
