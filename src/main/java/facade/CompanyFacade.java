package facade;

import beans.Category;
import beans.Company;
import beans.Coupon;

import java.util.List;

public interface CompanyFacade {

    void addCoupon(Coupon coupon);

    void updateCoupon(int couponId, Coupon coupon);

    void deleteCoupon(int couponId);

    List<Coupon> getCompanyCoupons();

    List<Coupon> getCompanyCoupons(Category category);

    List<Coupon> getCompanyCoupons(double MaxPrice);

    Company getCompanyDetails();


}
