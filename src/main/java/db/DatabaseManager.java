package db;

import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;
import dao.*;
import utils.Art;

import java.sql.Date;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kobis on 13 Mar, 2023
 */
public class DatabaseManager {


    private static final String CREATE_SCHEMA = "CREATE SCHEMA `coupon-system 159`";
    private static final String DROP_SCHEMA = "DROP SCHEMA `coupon-system 159`";
    private static final CategoryDAO categoryDAO = new CategoryDAOImpl();
    private static final CustomerDAO customerDAO = new CustomerDAOImpl();
    private static final CompanyDAO companyDAO = new CompanyDAOImpl();
    private static final CouponDAO couponDAO = new CouponDAOImpl();


    private static final String CREATE_TABLE_COMPANIES = "CREATE TABLE `coupon-system 159`.`companies` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(45) NOT NULL,\n" +
            "  `email` VARCHAR(45) NOT NULL,\n" +
            "  `password` VARCHAR(45) NOT NULL,\n" +
            "  PRIMARY KEY (`id`));\n";
    private static final String CREATE_TABLE_CUSTOMERS = "CREATE TABLE `coupon-system 159`.`customers` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `first_name` VARCHAR(45) NOT NULL,\n" +
            "  `last_name` VARCHAR(45) NOT NULL,\n" +
            "  `email` VARCHAR(45) NOT NULL,\n" +
            "  `password` VARCHAR(45) NOT NULL,\n" +
            "  PRIMARY KEY (`id`));";
    private static final String CREATE_TABLE_CATEGORIES = "CREATE TABLE `coupon-system 159`.`categories` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(45) NOT NULL,\n" +
            "  PRIMARY KEY (`id`));";
    private static final String CREATE_TABLE_COUPONS = "CREATE TABLE `coupon-system 159`.`coupons` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `company_id` INT NOT NULL,\n" +
            "  `category_id` INT NOT NULL,\n" +
            "  `title` VARCHAR(45) NOT NULL,\n" +
            "  `description` VARCHAR(200) NOT NULL,\n" +
            "  `start_date` DATE NOT NULL,\n" +
            "  `end_date` DATE NOT NULL,\n" +
            "  `amount` INT NOT NULL,\n" +
            "  `price` DOUBLE NOT NULL,\n" +
            "  `image` VARCHAR(255) NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  INDEX `company_id_idx` (`company_id` ASC) VISIBLE,\n" +
            "  INDEX `category_id_idx` (`category_id` ASC) VISIBLE,\n" +
            "  CONSTRAINT `company_id`\n" +
            "    FOREIGN KEY (`company_id`)\n" +
            "    REFERENCES `coupon-system 159`.`companies` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `category_id`\n" +
            "    FOREIGN KEY (`category_id`)\n" +
            "    REFERENCES `coupon-system 159`.`categories` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION);";
    private static final String CREATE_TABLE_CUSTOMER_COUPONS = "CREATE TABLE `coupon-system 159`.`customer_vs_coupons` (\n" +
            "  `customer_id` INT NOT NULL,\n" +
            "  `coupon_id` INT NOT NULL,\n" +
            "  PRIMARY KEY (`customer_id`, `coupon_id`),\n" +
            "  INDEX `coupon_id_idx` (`coupon_id` ASC) VISIBLE,\n" +
            "  CONSTRAINT `customer_id`\n" +
            "    FOREIGN KEY (`customer_id`)\n" +
            "    REFERENCES `coupon-system 159`.`customers` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `coupon_id`\n" +
            "    FOREIGN KEY (`coupon_id`)\n" +
            "    REFERENCES `coupon-system 159`.`coupons` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION);";


    public static void startDatabase() {
        DBUtils.runQuery(DROP_SCHEMA);
        DBUtils.runQuery(CREATE_SCHEMA);
        DBUtils.runQuery(CREATE_TABLE_COMPANIES);
        DBUtils.runQuery(CREATE_TABLE_CUSTOMERS);
        DBUtils.runQuery(CREATE_TABLE_CATEGORIES);
        DBUtils.runQuery(CREATE_TABLE_COUPONS);
        DBUtils.runQuery(CREATE_TABLE_CUSTOMER_COUPONS);
        ConnectionPool.getConnectionPool();
        initDatabase();


    }

    private static void initDatabase() {
        loadCategoryTable();
        loadCustomer();
        loadCompany();
        loadCoupons();
    }

    public static void endDatabase() {
        ConnectionPool.getConnectionPool().closeAllConnections();
    }

    private static void loadCategoryTable() {
        System.out.println(Art.CATEGORIES);
        for (Category category : Category.values()) {
            String name = category.name();
            categoryDAO.addCategory(name);
        }
        Arrays.stream(Category.values()).forEach(c-> System.out.println(c.getDBValue()+ "\t" + c.name()));
    }

    private static void loadCustomer() {
        System.out.println(Art.CUSTOMERS);
        Customer customer1 = Customer.builder()
                .firstName("Alice")
                .lastName("Anderson")
                .email("alice@gmail.com")
                .password("1234")
                .build();
        Customer customer2 = Customer.builder()
                .firstName("Bob")
                .lastName("Brown")
                .email("bob@gmail.com")
                .password("1234")
                .build();
        Customer customer3 = Customer.builder()
                .firstName("Charlie")
                .lastName("Clark")
                .email("charlie@gmail.com")
                .password("1234")
                .build();
        Customer customer4 = Customer.builder()
                .firstName("David")
                .lastName("Davis")
                .email("david@gmail.com")
                .password("1234")
                .build();
        Customer customer5 = Customer.builder()
                .firstName("Emily")
                .lastName("Evans")
                .email("emily@gmail.com")
                .password("1234")
                .build();
        Customer customer6 = Customer.builder()
                .firstName("Frank")
                .lastName("Ford")
                .email("frank@gmail.com")
                .password("1234")
                .build();
        Customer customer7 = Customer.builder()
                .firstName("Grace")
                .lastName("Green")
                .email("grace@gmail.com")
                .password("1234")
                .build();
        Customer customer8 = Customer.builder()
                .firstName("Henry")
                .lastName("Harris")
                .email("henry@gmail.com")
                .password("1234")
                .build();
        Customer customer9 = Customer.builder()
                .firstName("Isaac")
                .lastName("Irving")
                .email("isaac@gmail.com")
                .password("1234")
                .build();
        Customer customer10 = Customer.builder()
                .firstName("Jack")
                .lastName("Johnson")
                .email("jack@gmail.com")
                .password("1234")
                .build();

        List<Customer> customers = List.of(customer1, customer2, customer3, customer4,
                customer5, customer6, customer7, customer8, customer9, customer10);
        customerDAO.addAll(customers);
        customerDAO.getAll().forEach(System.out::println);
    }

    private static void loadCompany() {
        System.out.println(Art.COMPANIES);
        Company company1 = Company.builder()
                .name("Apple")
                .email("info@apple.com")
                .password("1234")
                .build();
        Company company2 = Company.builder()
                .name("Microsoft")
                .email("info@gmail.com")
                .password("1234")
                .build();
        Company company3 = Company.builder()
                .name("good-pharm")
                .email("info@gmail.com")
                .password("1234")
                .build();
        Company company4 = Company.builder()
                .name("Ista")
                .email("info@gmail.com")
                .password("1234")
                .build();
        Company company5 = Company.builder()
                .name("Super-pharm")
                .email("info@gmail.com")
                .password("1234")
                .build();
        Company company6 = Company.builder()
                .name("PizaHat")
                .email("info@gmail.com")
                .password("1234")
                .build();
        Company company7 = Company.builder()
                .name("Polo")
                .email("info@gmail.com")
                .password("1234")
                .build();
        Company company8 = Company.builder()
                .name("Holiday-finder")
                .email("info@gmail.com")
                .password("1234")
                .build();
        Company company9 = Company.builder()
                .name("GDB Burger")
                .email("info@gmail.com")
                .password("1234")
                .build();
        Company company10 = Company.builder()
                .name("Fitbody")
                .email("info@gmail.com")
                .password("1234")
                .build();
        List<Company> companies = List.of(company1, company2, company3, company4,
                company5, company6, company7, company8, company9, company10);
        companyDAO.addAll(companies);
        companyDAO.getAll().forEach(System.out::println);

    }

    private static void loadCoupons() {
        System.out.println(Art.COUPONS);
        Coupon coupon1 = Coupon.builder()
                .companyId(9)
                .category(Category.FOOD)
                .title("1+1 All Burgers")
                .description("Crazy sale of 1+1 all GDB hamburgers")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(40.9)
                .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
                .build();
        Coupon coupon2 = Coupon.builder()
                .companyId(1)
                .category(Category.COMPUTERS)
                .title("test good")
                .description("Get 20% discount on all laptops")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(2000.0)
                .image("https://media.giphy.com/media/mCRJDo24UvJMA/giphy.gif")
                .build();

        Coupon coupon3 = Coupon.builder()
                .companyId(2)
                .category(Category.COMPUTERS)
                .title("Buy one get one free on keyboards")
                .description("Buy one keyboard and get another one for free")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(50.0)
                .image("https://media.giphy.com/media/9rtpurjbqiqZXbBBet/giphy.gif")
                .build();
        Coupon coupon4 = Coupon.builder()
                .companyId(6)
                .category(Category.FOOD)
                .title("50% off all pizzas")
                .description("Get 50% discount on all pizza orders")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(50.0)
                .image("https://media.giphy.com/media/9fuvOqZ8tbZOU/giphy.gif")
                .build();
        Coupon coupon5 = Coupon.builder()
                .companyId(3)
                .category(Category.HEALTH)
                .title("Get 3 for the price of 2 on all vitamins")
                .description("Buy 3 vitamin products and get the cheapest one for free")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(20.0)
                .image("https://media.giphy.com/media/3oz8xwkewgvaFB75Nm/giphy.gif")
                .build();
        Coupon coupon6 = Coupon.builder()
                .companyId(5)
                .category(Category.HEALTH)
                .title("10% off all natural supplements")
                .description("Get 10% discount on all natural supplements")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(80.0)
                .image("https://www.example.com/supplements.jpg")
                .build();
        Coupon coupon7 = Coupon.builder()
                .companyId(5)
                .category(Category.VACATIONS)
                .title("Summer Sale - 50% off all resorts!")
                .description("GBook your next vacation and get 50% off all resort packages!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(200.0)
                .image("https://media.giphy.com/media/j0QzDgFZRX2njRxxtP/giphy.gif")
                .build();
        Coupon coupon8 = Coupon.builder()
                .companyId(5)
                .category(Category.VACATIONS)
                .title("Winter Wonderland - 25% off all ski trips!")
                .description("Escape to the mountains and get 25% off all ski trips!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(500.0)
                .image("https://media.giphy.com/media/hs3qvWPf6X4fWP1cwk/giphy.gif")
                .build();
        Coupon coupon9 = Coupon.builder()
                .companyId(5)
                .category(Category.SPORTS)
                .title("Get in shape! 20% off all gym memberships")
                .description("Join now and get 20% off all gym memberships!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(100.0)
                .image("https://giphy.com/clips/perfectketo-workout-training-working-out-y48NCmNho57e12ALdR")
                .build();
        Coupon coupon10 = Coupon.builder()
                .companyId(5)
                .category(Category.SPORTS)
                .title("New Running Shoes - 15% off!")
                .description("Upgrade your running game with our latest collection of running shoes")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(200)
                .price(80.0)
                .image("https://media.giphy.com/media/fPeqMskwclbZj2TWg6/giphy.gif")
                .build();


        List<Coupon> coupons = List.of(coupon1,coupon2,coupon3,coupon4,coupon5,coupon6,coupon7,coupon8,coupon9,coupon10);

                couponDAO.addAll(coupons);

                couponDAO.getAll().forEach(System.out::println);
    }

}
