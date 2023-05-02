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
import java.util.stream.Collectors;

@AllArgsConstructor
public class CompanyFacadeImpl extends ClientFacade implements CompanyFacade {

    private int companyId;


    @Override
    public boolean login(String email, String password) {
        List<Company> companies = companyDAO.getAll();
        for (Company company : companies) {
            if (company.getEmail().equals(email) && company.getPassword().equals(password)) {
                companyId = company.getId();
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


    // TODO: 24/04/23  ask kobi about --  ASK KOBI (  UPDATE_COUPON_COMPANY_ID("cannot update coupon companyId name"),
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
    public void deleteCoupon(int couponId) throws CouponSystemException {
        if(!this.couponDAO.isExist(couponId)){
            throw new CouponSystemException(ErrMsg.DELETE_COUPON_BY_ID);
        }
        couponDAO.deleteCouponPurchaseByCouponId(couponId);
        this.couponDAO.deleteCouponByCompanyId(companyId);

    }


    @Override
    public List<Coupon> getCompanyCoupons() {
        return couponDAO.getCouponsByCompanyId(companyId);
    }

    @Override
    public List<Coupon> getCompanyCoupons(Category category) {
        List<Coupon> couponFromDB = couponDAO.getCouponsByCompanyId(companyId);
        return couponFromDB.stream()
                .filter(coupon -> coupon.getCategory() == category)
                .collect(Collectors.toList());
    }
//        List<Coupon> coupons = new ArrayList<>();
//        List<Coupon> couponFromDB =  couponDAO.getCouponsByCompanyId(companyId);
//        for (Coupon coupon : couponFromDB ) {
//            if(coupon.getCategory() == category){
//                coupons.add(coupon);
//            }
//        }
//        return coupons;
//    }

//        List<Coupon> coupons1 = couponFromDB.stream().filter(c->c.getCategory() == category);

    @Override
    public List<Coupon> getCompanyCoupons(double MaxPrice) {

        List<Coupon> couponFromDB = couponDAO.getCouponsByCompanyId(companyId);
        return couponFromDB.stream()
                .filter(coupon -> coupon.getPrice() <MaxPrice)
                .collect(Collectors.toList());
    }
//        List<Coupon> coupons = new ArrayList<>();
//        List<Coupon> couponFromDB =  couponDAO.getCouponsByCompanyId(companyId);
//        for (Coupon coupon : couponFromDB ) {
//            if(coupon.getPrice() < MaxPrice){
//                coupons.add(coupon);
//            }
//        }
//        return coupons;
//    }


    @Override
    public Company getCompanyDetails() {
        return companyDAO.getSingle(companyId);
    }


}
