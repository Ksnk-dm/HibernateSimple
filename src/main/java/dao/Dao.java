package dao;

import java.util.List;


public abstract class Dao<T> {
    public abstract void insert(T exch);

    public abstract Double getMax(String currency);

    public abstract Double getAvg(String currency);

    public abstract void delete();

    public abstract List<T> getAll();

}
