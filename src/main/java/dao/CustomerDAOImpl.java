package dao;

import beans.Company;
import beans.Customer;
import db.ConvertUtils;
import db.DBUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAOImpl implements CustomerDAO {
    private static final String INSERT_CUSTOMER = "INSERT INTO `coupon-system 159`.`customers` (`first_name`, `last_name`, `email`, `password`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_CUSTOMER = "UPDATE `coupon-system 159`.`customers` SET `first_name` = ?, `last_name` = ?, `email` = ?, `password` = ? WHERE (`id` = ?)";
    private static final String DELETE_CUSTOMER = "DELETE FROM `coupon-system 159`.`customers` WHERE (`id` = ?)";
    private static final String GET_ALL_CUSTOMER = "SELECT * FROM `coupon-system 159`.customers;";
    private static final String GET_SINGLE_CUSTOMER = "SELECT * FROM `coupon-system 159`.customers WHERE (`id` = ?)";
    private static final String IS_CUSTOMER_EXIST = "select exists(select * FROM `coupon-system 159`.customers where id = ?) as res";

    @Override
    public void add(Customer customer) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer.getFirstName());
        params.put(2, customer.getLastName());
        params.put(3, customer.getEmail());
        params.put(4, customer.getPassword());
        DBUtils.runQuery(INSERT_CUSTOMER, params);

    }

    @Override
    public void update(Integer id, Customer customer) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer.getFirstName());
        params.put(2, customer.getLastName());
        params.put(3, customer.getEmail());
        params.put(4, customer.getPassword());
        params.put(5, customer.getId());
        DBUtils.runQuery(UPDATE_CUSTOMER, params);

    }

    @Override
    public void delete(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);
        DBUtils.runQuery(DELETE_CUSTOMER, params);

    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        List<?> results = DBUtils.runQueryWithResultSet(GET_ALL_CUSTOMER);
        for (Object obj : results) {
            Map<String, Object> pairs = (Map<String, Object>) obj;
            Customer customer = ConvertUtils.customerFromPairs(pairs);
            customers.add(customer);

        }
        return customers;
    }

    @Override
    public Customer getSingle(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);
        List<?> results = DBUtils.runQueryWithResultSet(GET_SINGLE_CUSTOMER, params);
        Object firstObject = results.get(0);
        Map<String, Object> pairs = (Map<String, Object>) firstObject;
        Customer customer = ConvertUtils.customerFromPairs(pairs);
        return customer;
    }

    @Override
    public boolean isExist(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);
        List<?> results = DBUtils.runQueryWithResultSet(IS_CUSTOMER_EXIST, params);
        Object firstObject = results.get(0);
        Map<String, Object> pairs = (Map<String, Object>) firstObject;
        boolean res = ConvertUtils.booleanFromPairs(pairs);
        return res;
    }


}
