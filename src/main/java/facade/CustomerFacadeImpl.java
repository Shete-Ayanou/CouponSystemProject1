package facade;

import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;

import java.util.List;

public class CustomerFacadeImpl extends ClientFacade implements CustomerFacade{

    private int customerId;




    @Override
    public boolean login(String email, String password) {
        List<Company> companies = companyDAO.getAll();
        for (Company company : companies) {
            if (company.getEmail().equals(email) && company.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void purchaseCoupon(Coupon coupon) {

    }

    @Override
    public List<Coupon> getCustomerCoupons() {
        return null;
    }

    @Override
    public List<Coupon> getCustomerCoupons(Category category) {
        return null;
    }

    @Override
    public List<Coupon> getCustomerCoupons(double maxPrice) {
        return null;
    }

    @Override
    public Customer getCustomerDetails() {
        return null;
    }
}
