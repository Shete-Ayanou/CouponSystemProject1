package dao;

import beans.Coupon;

import java.util.List;

public interface CouponDAO extends DAO<Coupon, Integer> {

    void addCouponPurchase(int customerId, int CouponId);

    void deleteCouponPurchase(int customerId, int CouponId);

    void deleteCouponByCompanyId(int companyId);

    Boolean isExistByTitle(String title);

    List<Coupon> getCouponsByCompanyId(int companyId );
    void deleteCouponPurchaseByCouponId(long couponId);

    public List<Coupon> getCouponsByTitle(String title);

}
