package facade;

import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;
import dao.CustomerDAOImpl;
import exceptions.CouponSystemException;
import exceptions.ErrMsg;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CustomerFacadeImpl extends ClientFacade implements CustomerFacade {

    private int customerId;

    @Override
    public boolean login(String email, String password) {
        List<Customer> customers = customerDAO.getAll();
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                customerId = customer.getId();
                return true;
            }
        }
        return false;
    }

    @Override
    public void purchaseCoupon(Coupon coupon) throws CouponSystemException {  // TODO: 25/04/23
        if (this.customerDAO.isCustomerAlreadyHaveCoupon(customerId, coupon.getId())) {
            throw new CouponSystemException(ErrMsg.CUSTOMER_ALREADY_HAVE_COUPON);
        }
        if (!this.couponDAO.isExist(coupon.getId())) {
            throw new CouponSystemException(ErrMsg.PURCHASE_COUPON_NOT_EXIST);
        }
        if (coupon.getEndDate().after(new Date())) {
            throw new CouponSystemException(ErrMsg.COUPON_EXPIRED);
        }
        couponDAO.addCouponPurchase(customerId, coupon.getId());
        couponDAO.delete(coupon.getId());

    }

    @Override
    public List<Coupon> getCustomerCoupons() {

        return customerDAO.getCouponBycustomeriD(customerId);
    }

    @Override
    public List<Coupon> getCustomerCoupons(Category category) {
        List<Coupon> couponFromDB = customerDAO.getCouponBycustomeriD(customerId);
        return couponFromDB.stream()
                .filter(coupon -> coupon.getCategory() == category)
                .collect(Collectors.toList());

    }

    @Override
    public List<Coupon> getCustomerCoupons(double maxPrice) {
        List<Coupon> coupons = customerDAO.getCouponBycustomeriD(customerId)
                .stream()
                .filter(coupon -> coupon.getPrice() < maxPrice)
                .collect(Collectors.toList());
        return coupons;
    }

    //     List<Coupon> coupons = new ArrayList<>();
//        List<Coupon> couponFromDB =  customerDAO.getCouponBycustomeriD(customerId);
//        for (Coupon coupon : couponFromDB ) {
//            if(coupon.getPrice() < MaxPrice){
//                coupons.add(coupon);
//            }
//        }
//        return coupons;
//    }
    @Override
    public Customer getCustomerDetails() {
        return customerDAO.getSingle(customerId);
    }
}
