package dao;

import beans.Company;

public interface CompanyDAO extends DAO<Company, Integer> {

    boolean isExistByName(String name);

    boolean isExistByEmail(String email);
}
