package facade;

import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;
import exceptions.CouponSystemException;
import exceptions.ErrMsg;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
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


    // TODO: 24/04/23  ask kobi about --  
    @Override
    public void updateCoupon(int couponId, Coupon coupon) throws CouponSystemException {
        if (!this.couponDAO.isExist(coupon.getId())) {
            throw new CouponSystemException(ErrMsg.UPDATE_COUPON__ID_NOT_EXIST);
        }
        if(couponId != coupon.getId()){
            throw new CouponSystemException(ErrMsg.UPDATE_COUPON_CANNOT_UPDATE_ID);
        }
        Coupon couponFromDB = couponDAO.getSingle(coupon.getId());
        couponFromDB.setTitle(coupon.getTitle());
        couponFromDB.setCategory(coupon.getCategory());
        couponFromDB.setAmount(coupon.getAmount());
        couponFromDB.setDescription(coupon.getDescription());
        couponFromDB.setPrice(coupon.getPrice());
        couponFromDB.setStartDate(coupon.getStartDate());
        couponFromDB.setEndDate(coupon.getEndDate());
        couponFromDB.setImage(coupon.getImage());
        
        couponDAO.update(couponId, couponFromDB);

    }

    

    @Override
    public void deleteCoupon(int couponId) {
        // TODO: 24/04/23  -- add validtion for couopn exist 
        couponDAO.deleteCouponPurchaseByCouponId(couponId);
        this.couponDAO.deleteCouponByCompanyId(companyId);

    }


    @Override
    public List<Coupon> getCompanyCoupons() {
        return couponDAO.getCouponsByCompanyId(companyId);
    }

    @Override
    public List<Coupon> getCompanyCoupons(Category category) {
        List<Coupon> coupons = new ArrayList<>();
        List<Coupon> couponFromDB =  couponDAO.getCouponsByCompanyId(companyId);
//        couponFromDB.stream().filter(c->c.getCategory() == category).forEach(coupons.add(c));
        for (Coupon coupon : couponFromDB ) {
            if(coupon.getCategory() == category){
                coupons.add(coupon);
            }
        }
        return coupons;
    }

//    @Override
//    public List<Coupon> getCompanyCoupons(Category category) {
//        return couponDAO.getCouponsByCompanyId(companyId).takeWhile((c)-> c.getCategory() ==category);
//    }

    @Override
    public List<Coupon> getCompanyCoupons(double MaxPrice) {
        return null;
    }

    @Override
    public Company getCompanyDetails() {
        return null;
    }


}
