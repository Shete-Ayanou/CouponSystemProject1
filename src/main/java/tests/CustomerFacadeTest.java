package tests;

import beans.Category;
import beans.Coupon;
import exceptions.CouponSystemException;
import facade.ClientFacade;
import facade.CustomerFacade;
import facade.CustomerFacadeImpl;
import utils.Test;

import java.sql.Date;
import java.time.LocalDate;

public class CustomerFacadeTest {


    private CustomerFacade customerFacade = new CustomerFacadeImpl(2);

    public void testCustomer() throws CouponSystemException {
//
//        Test.test("Customer Facade - bad login - wrong email");
//      System.out.println((((ClientFacade) customerFacade).login("bob@gmail.com", "1234")));
//      Test.test("Customer Facade - bad login - wrong password");
//      System.out.println((((ClientFacade) customerFacade).login("info@Ista.com", "3254")));
//
//      System.out.println("---------------------------------------------------------------------------------");

        Test.test("Customer Facade - purchase Coupon - Succeeded");
         Coupon coupon5 = Coupon.builder()
                 .id(1)
                .companyId(5)
                .category(Category.HEALTH)
                .title("Get 3 for the price of 2 on all vitamins")
                .description("Buy 3 vitamin products and get the cheapest one for free")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(2)
                .price(20.0)
                .image("https://media.giphy.com/media/3oz8xwkewgvaFB75Nm/giphy.gif")
                .build();

        try {
         customerFacade.purchaseCoupon(coupon5);
      }catch (CouponSystemException e){
          System.out.println(e.getMessage());
      }
        Test.test("Customer Facade - purchase Coupon - already exits");
        Coupon coupon2 = Coupon.builder()
                .id(1)
                .companyId(5)
                .category(Category.HEALTH)
                .title("Get 3 for the price of 2 on all vitamins")
                .description("Buy 3 vitamin products and get the cheapest one for free")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(2)
                .price(20.0)
                .image("https://media.giphy.com/media/3oz8xwkewgvaFB75Nm/giphy.gif")
                .build();

        try {
            customerFacade.purchaseCoupon(coupon2);
        }catch (CouponSystemException e){
            System.out.println(e.getMessage());
        }

        Test.test("Customer Facade - can't purchase Coupon -  out of stock");

        Coupon coupon3 = Coupon.builder()
                .id(4)
                .companyId(9)
                .category(Category.HEALTH)
                .title("Get 3 for the price of 2 on all vitamins")
                .description("Buy 3 vitamin products and get the cheapest one for free")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(0)
                .price(20.0)
                .image("https://media.giphy.com/media/3oz8xwkewgvaFB75Nm/giphy.gif")
                .build();

        try {
            customerFacade.purchaseCoupon(coupon3);
        }catch (CouponSystemException e){
            System.out.println(e.getMessage());
        }
        customerFacade.getCustomerCoupons().forEach(System.out::println);
        System.out.println("---------------------------customer coupon-----------------------------------");

        customerFacade.getCustomerCoupons().forEach(System.out::println);
        System.out.println("---------------------------customer coupon by Category-----------------------------------");

        customerFacade.getCustomerCoupons(Category.FOOD).forEach(System.out::println);
        System.out.println("---------------------------customer coupon by Max price-----------------------------------");

        customerFacade.getCustomerCoupons(50).forEach(System.out::println);

        System.out.println(customerFacade.getCustomerDetails());




    }

}


