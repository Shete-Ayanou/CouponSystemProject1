import beans.Company;
import beans.Customer;
import dao.CouponDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import db.DatabaseManager;

public class App {

    public static void main(String[] args) {
        System.out.println("Coupon System 159 started");
        DatabaseManager.startDatabase();







        DatabaseManager.endDatabase();
        System.out.println("Coupon System 159 ended");



    }
}
