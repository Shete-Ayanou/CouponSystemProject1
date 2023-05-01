import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;
import dao.CouponDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import db.DatabaseManager;
import tests.AdminFacadeTest;
import tests.CompanyFacadeTest;

public class App {

    public static void main(String[] args) throws Exception {


        System.out.println("Coupon System 159 started");
        DatabaseManager.startDatabase();

////        AdminFacadeTest adminFacadeTest = new AdminFacadeTest();
////        adminFacadeTest.testAsAdmin();
//        CompanyFacadeTest companyFacadeTest = new CompanyFacadeTest();
//        companyFacadeTest.testAsCompany();
//




        DatabaseManager.endDatabase();
        System.out.println("Coupon System 159 ended");


    }
}
