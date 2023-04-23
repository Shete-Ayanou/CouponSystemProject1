package tests;

import beans.Company;
import beans.Coupon;
import facade.ClientFacade;
import facade.CompanyFacade;
import facade.CompanyFacadeImpl;
import utils.Test;


public class CompanyFacadeTest {


    private CompanyFacade companyFacade = new CompanyFacadeImpl(1);

  public void testAsCompany() throws Exception {
      Test.test("Company Facade - bad login - wrong email");
      System.out.println((((ClientFacade) companyFacade).login("sdfsfs@gmail.com", "1234")));
      Test.test("Company Facade - bad login - wrong password");
      System.out.println((((ClientFacade) companyFacade).login("info@gmail.com", "1234")));

      System.out.println("---------------------------------------------------------------------------------");


      Test.test("Coupon Facade - add Coupon - id already exist");

//      couponToAdd = companyFacade.getSingleCoupon(2).orElseThrow(()-> new Exception("coupon already exist"));
//
//
//      Test.test("Coupon Facade - add Coupon - title already exist");
//      couponToAdd = companyFacade.getSingleCoupon(1).orElseThrow(()-> new Exception("coupon already exist"));
//      couponToAdd.setTitle("1+1 All Burgers");
//      try {
//          companyFacade.addCoupon(couponToAdd);
//      } catch (Exception e) {
//          System.out.println(e.getMessage());
//      }
//
//      Coupon toUpdateCoupon = null;
//      Test.test("Admin Facade - update coupon - cannot update id that not exist");
//      toUpdateCoupon = companyFacade.getSingleCoupon(1).orElseThrow(() -> new Exception("company not exist"));
//      try {
//          companyFacade.updateCoupon(21,toUpdateCoupon);
//
//      } catch (Exception e) {
//          System.out.println(e.getMessage());
//      }

//      Test.test("Admin Facade - ge all customers - success");
//      companyFacade.getCompanyCoupons().forEach(System.out::println);
//
//  }
  }
}
