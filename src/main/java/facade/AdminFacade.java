package facade;

import beans.Company;
import beans.Customer;
import exceptions.CouponSystemException;

import java.util.List;
import java.util.Optional;

public interface AdminFacade {


    void addCompany(Company company) throws CouponSystemException;

    void updateCompany(int companyId, Company company) throws CouponSystemException;

    void deleteCompany(int companyId) throws CouponSystemException;

    List<Company> getAllCompanies();

    Optional<Company> getSingleCompany(int id);

    void addCustomer(Customer customer) throws CouponSystemException;

    void updateCustomer(int customerId, Customer customer) throws CouponSystemException;

    void deleteCustomer(int customerId) throws CouponSystemException;

    List<Customer> getAllCustomer();

    Optional<Customer> getSingleCustomer(int customerId);

}
