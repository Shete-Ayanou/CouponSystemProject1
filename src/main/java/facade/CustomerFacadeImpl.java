package facade;

import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;
import dao.CustomerDAOImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerFacadeImpl extends ClientFacade implements CustomerFacade {

    private int customerId;

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
    public void purchaseCoupon(Coupon coupon) {  // TODO: 25/04/23
        if (customerDAO.isCustomerAlreadyHaveCoupon(customerId, coupon.getId())) {
            // TODO: 25/04/23  trow expition
        }
//


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
