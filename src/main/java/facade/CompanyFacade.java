package facade;

import beans.Category;
import beans.Company;
import beans.Coupon;
import exceptions.CouponSystemException;

import java.util.List;
import java.util.Optional;

public interface CompanyFacade {

    void addCoupon(Coupon coupon) throws CouponSystemException;

    void updateCoupon(int couponId, Coupon coupon) throws CouponSystemException;

    void deleteCoupon(int couponId);

    List<Coupon> getCompanyCoupons();

    List<Coupon> getCompanyCoupons(Category category);

    List<Coupon> getCompanyCoupons(double MaxPrice);

    Company getCompanyDetails();


}
