import beans.Company;
import beans.Customer;
import dao.CouponDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import db.DatabaseManager;
import tests.AdminFacadeTest;

public class App {

    public static void main(String[] args) throws Exception {


        System.out.println("Coupon System 159 started");
        DatabaseManager.startDatabase();

        AdminFacadeTest adminFacadeTest = new AdminFacadeTest();
        adminFacadeTest.testAsAdmin();


        DatabaseManager.endDatabase();
        System.out.println("Coupon System 159 ended");


    }
}
