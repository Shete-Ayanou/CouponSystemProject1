package facade;


import beans.Company;
import beans.Coupon;
import beans.Customer;
import exceptions.CouponSystemException;
import exceptions.ErrMsg;

import java.util.List;
import java.util.Optional;

public class AdminFacadeImpl extends ClientFacade implements AdminFacade {


    @Override
    public boolean login(String email, String password) {
        return email.equals("admin@admin.com") && password.equals("admin");
    }

    @Override
    public void addCompany(Company company) throws CouponSystemException {
        int id = company.getId();
        if (this.companyDAO.isExist(id)) {
            throw new CouponSystemException(ErrMsg.ADD_COMPANY_ID_EXIST);
        }
        String name = company.getName();

        if (this.companyDAO.isExistByName(name)) {
            throw new CouponSystemException(ErrMsg.ADD_COMPANY_NAME_EXIST);
        }
        String email = company.getEmail();
        if (this.companyDAO.isExistByEmail(email)) {
            throw new CouponSystemException(ErrMsg.ADD_COMPANY_EMAIL_EXIST);
        }
        this.companyDAO.add(company);

    }

    @Override
    public void updateCompany(int companyId, Company company) throws CouponSystemException {
        if (!this.companyDAO.isExist(companyId)) {
            throw new CouponSystemException(ErrMsg.UPDATE_COMPANY_ID_NOT_EXIST);
        }
        if (companyId != company.getId()) {
            throw new CouponSystemException(ErrMsg.UPDATE_COMPANY_CANNOT_UPDATE_ID);
        }
        Company fromDB = this.companyDAO.getSingle(companyId);
        if (!fromDB.getName().equals(company.getName())) {
            throw new CouponSystemException(ErrMsg.UPDATE_COMPANY_CANNOT_UPDATE_NAME);
        }
        this.companyDAO.update(companyId, company);


    }

    @Override


    public void deleteCompany(int companyId) throws CouponSystemException {
        if (!this.companyDAO.isExist(companyId)) {
            throw new CouponSystemException(ErrMsg.DELETE_COMPANY_CANNOT_DELETE_COMPANY_NOT_EXIST);
        }
        List<Coupon> coupons = couponDAO.getCouponsByCompanyId(companyId);

        for (Coupon coupon : coupons) {
            couponDAO.deleteCouponPurchaseByCouponId(coupon.getId());
            couponDAO.deleteCouponByCompanyId(companyId);
        }
        companyDAO.delete(companyId);
    }

    @Override
    public List<Company> getAllCompanies() {
        return this.companyDAO.getAll();
    }

    @Override
    public Optional<Company> getSingleCompany(int id) {
        return Optional.of(this.companyDAO.getSingle(id));
    }

    @Override
    public void addCustomer(Customer customer) throws CouponSystemException {
        int id = customer.getId();
        if (this.customerDAO.isExist(id)) {
            throw new CouponSystemException(ErrMsg.ADD_CUSTOMER_ID_EXIST);
        }
        String email = customer.getEmail();
        if (this.customerDAO.isExistByEmail(email)) {
            throw new CouponSystemException(ErrMsg.ADD_CUSTOMER_EMAIL_EXIST);
        }
        this.customerDAO.add(customer);

    }

    @Override
    public void updateCustomer(int customerId, Customer customer) throws CouponSystemException {
        if (!this.customerDAO.isExist(customerId)) {
            throw new CouponSystemException(ErrMsg.UPDATE_CUSTOMER_ID_NOT_EXIST);
        }
        if (customerId != customer.getId()) {
            throw new CouponSystemException(ErrMsg.UPDATE_CUSTOMER_CANNOT_UPDATE_ID);
        }

        this.customerDAO.update(customerId, customer);

    }

    @Override
    public void deleteCustomer(int customerId) throws CouponSystemException {
        if (!this.customerDAO.isExist(customerId)) {
            throw new CouponSystemException(ErrMsg.DELETE_CUSTOMER_CANNOT_DELETE_CUSTOMER_NOT_EXIST);
        }
        customerDAO.deleteCouponsByCustomerId(customerId);
        customerDAO.delete(customerId);


    }

    @Override
    public List<Customer> getAllCustomer() {
        return this.customerDAO.getAll();
    }

    @Override
    public Optional<Customer> getSingleCustomer(int customerId) {
        return Optional.of(this.customerDAO.getSingle(customerId));
    }
}
