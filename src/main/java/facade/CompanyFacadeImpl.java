package facade;

import beans.Category;
import beans.Company;
import beans.Coupon;
import exceptions.CouponSystemException;
import exceptions.ErrMsg;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
public class CompanyFacadeImpl extends ClientFacade implements CompanyFacade {

    private int companyId;


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
    public void addCoupon(Coupon coupon) throws CouponSystemException {
        String title = coupon.getTitle();
        if (this.couponDAO.isExistByTitle(title)) {
            throw new CouponSystemException(ErrMsg.ADD_COUPON_TITLE_EXIST);
        }
        this.couponDAO.add(coupon);

    }

    @Override
    public void updateCoupon(int couponId, Coupon coupon) throws CouponSystemException {

        if (!this.couponDAO.isExist(couponId)) {
            throw new CouponSystemException(ErrMsg.UPDATE_COUPON__ID_NOT_EXIST);
        }
        if (couponId != coupon.getId()) {
            throw new CouponSystemException(ErrMsg.UPDATE_COUPON_CANNOT_UPDATE_ID);
        }
        if (coupon.getCompanyId() != coupon.getCompanyId()){
            throw new CouponSystemException(ErrMsg.UPDATE_COUPON_COMPANY_ID);
        }
        this.couponDAO.update(couponId, coupon);

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
