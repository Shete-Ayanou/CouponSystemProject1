package dao;

import beans.Customer;

public interface CustomerDAO extends DAO<Customer,Integer> {
    boolean isExistByEmail(String email);
}
