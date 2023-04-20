package facade;

import beans.Category;
import beans.Company;
import beans.Coupon;

import java.util.List;

public class CompanyFacadeImpl extends ClientFacade implements CompanyFacade{

    private int companyId;



    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public void addCoupon(Coupon coupon) {

    }

    @Override
    public void updateCoupon(int couponId, Coupon coupon) {

    }

    @Override
    public void deleteCoupon(int couponId) {

    }

    @Override
    public List<Coupon> getCompanyCoupons() {
        return null;
    }

    @Override
    public List<Coupon> getCompanyCoupons(Category category) {
        return null;
    }

    @Override
    public List<Coupon> getCompanyCoupons(double MaxPrice) {
        return null;
    }

    @Override
    public Company getCompanyDetails() {
        return null;
    }
}
