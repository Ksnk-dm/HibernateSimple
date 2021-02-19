package dao;

import java.util.List;


public abstract class Dao<T> {
    public abstract void insert(T exch);

    public abstract void delete(T a);

    public abstract List<T> getAll();

}
