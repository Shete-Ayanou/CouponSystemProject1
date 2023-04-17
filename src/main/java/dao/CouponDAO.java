package dao;

import beans.Coupon;

public interface CouponDAO extends DAO<Coupon, Integer> {

    void addCouponPurchase(int customerId, int CouponId);

    void deleteCouponPurchase(int customerId, int CouponId);

}
