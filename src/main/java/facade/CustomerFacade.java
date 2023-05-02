package facade;

import beans.Category;
import beans.Coupon;
import beans.Customer;
import exceptions.CouponSystemException;

import java.util.List;

public interface CustomerFacade {


    void purchaseCoupon(Coupon coupon) throws CouponSystemException;

    List<Coupon> getCustomerCoupons();

    List<Coupon> getCustomerCoupons(Category category);

    List<Coupon> getCustomerCoupons(double maxPrice);

    Customer getCustomerDetails();


}
