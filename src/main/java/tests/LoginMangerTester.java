package tests;

import exceptions.CouponSystemException;
import facade.ClientFacade;
import login.ClientType;
import login.LoginManager;
import utils.Test;

public class LoginMangerTester {


    public static void main(String[] args) throws CouponSystemException {

        LoginManager loginManager = LoginManager.getInstance();


        Test.test("ADMINISTRATOR  - bad login - wrong email or password");
        try {
            ClientFacade client1 = loginManager.login("admin@admin.com","admkin",ClientType.ADMINISTRATOR );
        }catch (CouponSystemException e){
            System.out.println(e.getMessage());
        }

        Test.test("ADMINISTRATOR  - good login - success");

        try {
            ClientFacade client1 = loginManager.login("admin@admin.com","admin",ClientType.ADMINISTRATOR );
        }catch (CouponSystemException e){
            System.out.println(e.getMessage());
        }

        Test.test("COMPANY  - bad login - wrong email or password");
        try {
            ClientFacade client2 = loginManager.login("info@good-pharm./com","1234",ClientType.COMPANY);
        }catch (CouponSystemException e){
            System.out.println(e.getMessage());
        }
        Test.test("COMPANY  - good login - success");
        try {
            ClientFacade client2 = loginManager.login("info@good-pharm.com","1234",ClientType.COMPANY);
        }catch (CouponSystemException e){
            System.out.println(e.getMessage());
        }
        Test.test("CUSTOMER  - bad login - wrong email or password");

        try {
            ClientFacade client3 = loginManager.login("alice@gmail.com","145234",ClientType.CUSTOMER );
        }catch (CouponSystemException e){
            System.out.println(e.getMessage());
        }

        Test.test("CUSTOMER  - good login - success");

        try {
            ClientFacade client3 = loginManager.login("alice@gmail.com","1234",ClientType.CUSTOMER );
        }catch (CouponSystemException e){
            System.out.println(e.getMessage());
        }














    }
}
