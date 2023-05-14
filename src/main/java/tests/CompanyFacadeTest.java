package tests;

import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;
import exceptions.CouponSystemException;
import facade.ClientFacade;
import facade.CompanyFacade;
import facade.CompanyFacadeImpl;
import utils.Test;

import java.sql.Date;
import java.time.LocalDate;


public class CompanyFacadeTest {


    private CompanyFacade companyFacade = new CompanyFacadeImpl(5);

  public void testAsCompany() throws Exception {
      Test.test("Company Facade - bad login - wrong email");
      System.out.println((((ClientFacade) companyFacade).login("info@good-pharm.com", "1234")));
      Test.test("Company Facade - bad login - wrong password");
      System.out.println((((ClientFacade) companyFacade).login("info@Ista.com", "3254")));

      System.out.println("---------------------------------------------------------------------------------");
//
      Test.test("Company Facade - bad add - wrong title");

      Coupon coupon11 = Coupon.builder()
              .title("10% off all natural supplements")
              .companyId(5)
              .category(Category.FOOD)
              .description("Crazy sale of 1+1 all GDB hamburgers")
              .startDate(Date.valueOf(LocalDate.now()))
              .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
              .amount(100)
              .price(40.9)
              .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
              .build();
      try {
          companyFacade.addCoupon(coupon11);
      } catch (CouponSystemException e) {
          System.out.println(e.getMessage());
      }
      companyFacade.getCompanyCoupons().forEach(System.out::println);

      Test.test("Company Facade - Checking  title from another company - success");

      Coupon coupon22 = Coupon.builder()
              .title("Get in shape! 20% off all gym memberships")
              .companyId(5)
              .category(Category.FOOD)
              .description("Crazy sale of 1+1 all GDB hamburgers")
              .startDate(Date.valueOf(LocalDate.now()))
              .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
              .amount(100)
              .price(40.9)
              .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
              .build();
      try {
          companyFacade.addCoupon(coupon22);
      } catch (CouponSystemException e) {
          System.out.println(e.getMessage());
      }
      companyFacade.getCompanyCoupons().forEach(System.out::println);

      Test.test("Company Facade - another Checking  success! -");
      Coupon coupon33 = Coupon.builder()
              .title("adadadad")
              .companyId(7)
              .category(Category.FOOD)
              .description("Crazy sale of 1+1 all GDB hamburgers")
              .startDate(Date.valueOf(LocalDate.now()))
              .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
              .amount(100)
              .price(40.9)
              .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
              .build();
      try {
          companyFacade.addCoupon(coupon33);
      } catch (CouponSystemException e) {
          System.out.println(e.getMessage());
      }
      companyFacade.getCompanyCoupons().forEach(System.out::println);

      System.out.println("---------------------------------------------------------------------------------");

      Test.test("Company Facade - update coupon / no id to update ");

      Coupon coupon32 = Coupon.builder()
              .title("update")
              .companyId(2)
              .category(Category.FOOD)
              .description("updata")
              .startDate(Date.valueOf(LocalDate.now()))
              .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
              .amount(100)
              .price(40.9)
              .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
              .build();

      companyFacade.updateCoupon(1, coupon32);

      companyFacade.getCompanyCoupons().forEach(System.out::println);


      Test.test("Company Facade - update coupon / no company id to update ");


      Coupon coupon3 = Coupon.builder()
              .category(Category.COMPUTERS)
              .title("update")
              .description("update")
              .startDate(Date.valueOf(LocalDate.now()))
              .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
              .amount(100)
              .price(50.0)
              .image("https://media.giphy.com/media/9rtpurjbqiqZXbBBet/giphy.gif")
              .build();
      companyFacade.updateCoupon(3, coupon3);
      companyFacade.getCompanyCoupons().forEach(System.out::println);

      System.out.println("---------------------------------------------------------------------------------");

      Test.test("Company Facade - delete  coupon ");
      companyFacade.deleteCoupon(4);


      Test.test("Company Facade - get Company coupon");
      companyFacade.getCompanyCoupons().forEach(System.out::println);


      Test.test("Company Facade - get coupon by Category  coupon ");
      companyFacade.getCompanyCoupons(Category.COMPUTERS).forEach(System.out::println);


      Test.test("Company Facade - get coupon by Max-price  coupon ");
      companyFacade.getCompanyCoupons(300).forEach(System.out::println);


      Test.test("Company Facade - get company details ");
      System.out.println(companyFacade.getCompanyDetails());


  }
}
