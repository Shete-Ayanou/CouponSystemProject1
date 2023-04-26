package dao;

import beans.Coupon;
import beans.Customer;

import java.util.List;

public interface CustomerDAO extends DAO<Customer,Integer> {
    boolean isExistByEmail(String email);
    void deleteCouponsByCustomerId(int customerId);
    boolean isCustomerAlreadyHaveCoupon(int customerId, int couponId);

    List<Coupon> getCouponBycustomeriD(int customerId);




}
