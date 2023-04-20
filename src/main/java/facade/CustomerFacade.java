package facade;

import beans.Category;
import beans.Coupon;
import beans.Customer;

import java.util.List;

public interface CustomerFacade {


    void purchaseCoupon(Coupon coupon);

    List<Coupon> getCustomerCoupons();

    List<Coupon> getCustomerCoupons(Category category);

    List<Coupon> getCustomerCoupons(double maxPrice);

    Customer getCustomerDetails();


}
