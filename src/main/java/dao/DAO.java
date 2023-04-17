package dao;

import java.util.List;

public interface DAO<T, PK> {


    void add(T t);

    void update(PK pk, T t);

    void delete(PK pk);

    List<T> getAll();

    T getSingle(PK pk);

    boolean isExist(PK pk);

    default void addAll(List<T> List) {
        List.forEach(this::add);

    }
}
