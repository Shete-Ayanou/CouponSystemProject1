package tests;

import beans.Category;
import beans.Company;
import beans.Coupon;
import exceptions.CouponSystemException;
import facade.ClientFacade;
import facade.CompanyFacade;
import facade.CompanyFacadeImpl;
import utils.Test;

import java.sql.Date;
import java.time.LocalDate;


public class CompanyFacadeTest {


    private CompanyFacade companyFacade = new CompanyFacadeImpl(2);

  public void testAsCompany() throws Exception {
      Test.test("Company Facade - bad login - wrong email");
      System.out.println((((ClientFacade) companyFacade).login("info@apple.com", "1234")));
      Test.test("Company Facade - bad login - wrong password");
      System.out.println((((ClientFacade) companyFacade).login("info@gmail.com", "1234")));

      System.out.println("---------------------------------------------------------------------------------");

      Test.test("Company Facade - bad add - wrong email");

      Coupon coupon = Coupon.builder()
              .title("20% off all laptops")
              .companyId(9)
              .category(Category.FOOD)
              .description("Crazy sale of 1+1 all GDB hamburgers")
              .startDate(Date.valueOf(LocalDate.now()))
              .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
              .amount(100)
              .price(40.9)
              .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
              .build();
      try {
          companyFacade.addCoupon(coupon);
      }catch (CouponSystemException e){
          System.out.println(e.getMessage());
      }












  }
}
