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
//      Test.test("Company Facade - bad login - wrong email");
//      System.out.println((((ClientFacade) companyFacade).login("info@good-pharm.com", "1234")));
//      Test.test("Company Facade - bad login - wrong password");
//      System.out.println((((ClientFacade) companyFacade).login("info@Ista.com", "3254")));

      System.out.println("---------------------------------------------------------------------------------");

//      Test.test("Company Facade - bad add - wrong title");
//
//      Coupon coupon11 = Coupon.builder()
//              .title("adadadad")
//              .companyId(5)
//              .category(Category.FOOD)
//              .description("Crazy sale of 1+1 all GDB hamburgers")
//              .startDate(Date.valueOf(LocalDate.now()))
//              .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
//              .amount(100)
//              .price(40.9)
//              .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
//              .build();
//      try {
//          companyFacade.addCoupon(coupon11);
//      }catch (CouponSystemException e){
//          System.out.println(e.getMessage());
//      }
//      companyFacade.getCompanyCoupons().forEach(System.out::println);
//
//      Test.test("Company Facade - bad add - wrong title");
//
//      Coupon coupon22 = Coupon.builder()
//              .title("adadadad")
//              .companyId(5)
//              .category(Category.FOOD)
//              .description("Crazy sale of 1+1 all GDB hamburgers")
//              .startDate(Date.valueOf(LocalDate.now()))
//              .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
//              .amount(100)
//              .price(40.9)
//              .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
//              .build();
//      try {
//          companyFacade.addCoupon(coupon22);
//      }catch (CouponSystemException e){
//          System.out.println(e.getMessage());
//      }
//      companyFacade.getCompanyCoupons().forEach(System.out::println);
//
//      Test.test("Company Facade - success -");
//      Coupon coupon32 = Coupon.builder()
//              .title("adadadad")
//              .companyId(7)
//              .category(Category.FOOD)
//              .description("Crazy sale of 1+1 all GDB hamburgers")
//              .startDate(Date.valueOf(LocalDate.now()))
//              .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
//              .amount(100)
//              .price(40.9)
//              .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
//              .build();
//      try {
//          companyFacade.addCoupon(coupon32);
//      }catch (CouponSystemException e){
//          System.out.println(e.getMessage());
//      }
//      companyFacade.getCompanyCoupons().forEach(System.out::println);

      System.out.println("---------------------------------------------------------------------------------");
//
//            Coupon coupon32 = Coupon.builder()
//              .title("update")
//              .companyId(2)
//              .category(Category.FOOD)
//              .description("updata")
//              .startDate(Date.valueOf(LocalDate.now()))
//              .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
//              .amount(100)
//              .price(40.9)
//              .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
//              .build();
//
//      companyFacade.updateCoupon(1,coupon32);
//
//      companyFacade.getCompanyCoupons().forEach(System.out::println);


//            Test.test("Company Facade - update coupon ");
//
//
//      Coupon coupon3 = Coupon.builder()
//              .category(Category.COMPUTERS)
//              .title("update")
//              .description("update")
//              .startDate(Date.valueOf(LocalDate.now()))
//              .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
//              .amount(100)
//              .price(50.0)
//              .image("https://media.giphy.com/media/9rtpurjbqiqZXbBBet/giphy.gif")
//              .build();
//      companyFacade.updateCoupon(3,coupon3);
//      companyFacade.getCompanyCoupons().forEach(System.out::println);
//


//            Test.test("Company Facade - update coupon ");
//
//            companyFacade.deleteCoupon(4);

      companyFacade.getCompanyCoupons().forEach(System.out::println);

      System.out.println("category--------------");
      companyFacade.getCompanyCoupons(Category.HEALTH).forEach(System.out::println);

      System.out.println("maxPrice------------");

      companyFacade.getCompanyCoupons(50).forEach(System.out::println);

      System.out.println("details------------------");

      System.out.println(companyFacade.getCompanyDetails());


  }
}
