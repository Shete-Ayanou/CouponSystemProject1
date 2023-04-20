package facade;

import beans.Category;
import beans.Coupon;
import beans.Customer;

import java.util.List;

public class CustomerFacadeImpl extends ClientFacade implements CustomerFacade{

    private int customerId;




    @Override
    public boolean login(String email, String password) {
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
