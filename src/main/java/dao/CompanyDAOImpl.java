package dao;

import beans.Company;
import beans.Customer;
import db.ConvertUtils;
import db.DBUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyDAOImpl implements CompanyDAO{
    private static final  String INSERT_COMPANY ="INSERT INTO `coupon-system 159`.`companies` (`name`, `email`, `password`) VALUES (?, ?,?)";
    private static final String UPDATE_COMPANY ="UPDATE `coupon-system 159`.`companies` SET `name` = ?, `email` = ?, `password` = ? WHERE (`id` = ?);";
    private static final String DELETE_COMPANY = "DELETE FROM `coupon-system 159`.`companies` WHERE (`id` = ?);";
    private static final String GET_ALL_COMPANY ="SELECT * FROM `coupon-system 159`.companies";
    private static final String GET_SINGLE_COMPANY ="SELECT * FROM `coupon-system 159`.companies  WHERE (`id` = ?);";
    private static final String IS_COMPANY_EXIST_ID = "select exists (select * FROM `coupon-system 159`.companies where id = ?) as res";
    private static final String IS_COMPANY_EXISTS_BY_NAME ="select exists (select * FROM `coupon-system 159`.companies where name = ? ) as res;";
    private static final String IS_COMPANY_EXISTS_BY_EMAIL ="select exists (select * FROM `coupon-system 159`.companies where email = ? ) as res;";


    @Override
    public void add(Company company) {

        Map<Integer, Object> params = new HashMap<>();
        params.put(1,company.getName());
        params.put(2,company.getEmail());
        params.put(3,company.getPassword());

        DBUtils.runQuery(INSERT_COMPANY,params);

    }

    @Override
    public void update(Integer id, Company company) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,company.getName());
        params.put(2,company.getEmail());
        params.put(3,company.getPassword());
        params.put(4,company.getId());
        DBUtils.runQuery(UPDATE_COMPANY,params);

    }

    @Override
    public void delete(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,id);
        DBUtils.runQuery(DELETE_COMPANY,params);

    }

    @Override
    public List<Company> getAll() {
        List<Company> companies = new ArrayList<>();
        List<?> results = DBUtils.runQueryWithResultSet(GET_ALL_COMPANY);
        for (Object obj: results) {
            Map<String, Object> pairs = (Map<String, Object>) obj;
            Company company = ConvertUtils.companyFromPairs(pairs);
            companies.add(company);
        }

        return companies;

    }

    @Override
    public Company getSingle(Integer id) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,id);
        List<?> results = DBUtils.runQueryWithResultSet(GET_SINGLE_COMPANY,params);
        Object firstObject = results.get(0);
        Map<String, Object> pairs = (Map<String, Object>) firstObject;
        Company company = ConvertUtils.companyFromPairs(pairs);
        return company;
    }

    @Override
    public boolean isExist(Integer id) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,id);
        List<?> results = DBUtils.runQueryWithResultSet(IS_COMPANY_EXIST_ID,params);
        Object firstObject = results.get(0);
        Map<String, Object> pairs = (Map<String, Object>) firstObject;
        Boolean res = ConvertUtils.booleanFromPairs(pairs);
        return res;
    }

    @Override
    public boolean isExistByName(String name) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,name);
        List<?> results = DBUtils.runQueryWithResultSet(IS_COMPANY_EXISTS_BY_NAME,params);
        Object firstObject = results.get(0);
        Map<String, Object> pairs = (Map<String, Object>) firstObject;
        Boolean res = ConvertUtils.booleanFromPairs(pairs);
        return res;
    }

    @Override
    public boolean isExistByEmail(String email) {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,email);
        List<?> results = DBUtils.runQueryWithResultSet(IS_COMPANY_EXISTS_BY_EMAIL,params);
        Object firstObject = results.get(0);
        Map<String, Object> pairs = (Map<String, Object>) firstObject;
        Boolean res = ConvertUtils.booleanFromPairs(pairs);
        return res;
    }
}
