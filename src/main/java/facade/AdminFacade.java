package facade;

import beans.Company;
import beans.Customer;
import exceptions.CouponSystemException;

import java.util.List;
import java.util.Optional;

public interface AdminFacade {


    void addCompany(Company company) throws CouponSystemException;

    void updateCompany(int companyId, Company company) throws CouponSystemException;

    void deleteCompany(int companyId);

    List<Company> getAllCompanies();

    Optional<Company> getSingleCompany(int id);

    void addCustomer(Customer customer);

    void updateCustomer(int customerId, Customer customer);

    void deleteCustomer(int customerId);

    List<Customer> getAllCustomer();

    Optional<Customer> getSingleCustomer(int customerId);

}
