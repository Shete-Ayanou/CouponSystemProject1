import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;
import dao.CouponDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import db.DatabaseManager;
import job.CouponExpirationDailyJob;
import tests.AdminFacadeTest;
import tests.CompanyFacadeTest;
import tests.CustomerFacadeTest;

public class App {

    public static void main(String[] args) throws Exception {

        CouponExpirationDailyJob couponExpirationDailyJob = new CouponExpirationDailyJob();


        System.out.println("Coupon System 159 started");
        DatabaseManager.startDatabase();



        AdminFacadeTest adminFacadeTest = new AdminFacadeTest();
        adminFacadeTest.testAsAdmin();

        CompanyFacadeTest companyFacadeTest = new CompanyFacadeTest();
        companyFacadeTest.testAsCompany();

        CustomerFacadeTest customerFacadeTest = new CustomerFacadeTest();
        customerFacadeTest.testCustomer();

        Thread couponCleaner = new Thread(couponExpirationDailyJob);
        couponCleaner.setDaemon(true);
        couponCleaner.start();

        couponExpirationDailyJob.stop();

        DatabaseManager.endDatabase();
        System.out.println("Coupon System 159 ended");



//


    }
}



//
//        while (true){
//                Thread.sleep(1000*30);
//
//                }