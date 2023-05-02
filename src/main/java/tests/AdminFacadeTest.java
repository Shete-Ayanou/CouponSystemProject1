package tests;

import beans.Company;
import beans.Coupon;
import beans.Customer;
import facade.AdminFacade;
import facade.AdminFacadeImpl;
import facade.ClientFacade;
import utils.Test;

public class AdminFacadeTest {

    private AdminFacade adminFacade = new AdminFacadeImpl();

    public void testAsAdmin() throws Exception {
//        Test.test("Admin Facade - bad login - wrong email");
//        System.out.println(((ClientFacade) adminFacade).login("stam@gmail.com", "admin"));
//        Test.test("Admin Facade - bad login - wrong password");
//        System.out.println(((ClientFacade) adminFacade).login("admin@admin.com", "stam"));
//        Test.test("Admin Facade - bad login - wrong email and password");
//        System.out.println(((ClientFacade) adminFacade).login("stam@gmail.com", "stam"));
//        Test.test("Admin Facade - good login -");
//        System.out.println(((ClientFacade) adminFacade).login("admin@admin.com", "admin"));
//
//
//        System.out.println("---------------------------------------------------------------------------------");
//
        Company companyToAdd = null;
        Test.test("Admin Facade - add company - id already exist");
        companyToAdd = adminFacade.getSingleCompany(1).orElseThrow(() -> new Exception("company not exist"));
        companyToAdd.setName("stam");
        companyToAdd.setEmail("stam@gmail.com");
        try {
            adminFacade.addCompany(companyToAdd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - add company - name already exist");
        companyToAdd = adminFacade.getSingleCompany(1).orElseThrow(() -> new Exception("company not exist"));
        companyToAdd.setId(0);
        companyToAdd.setEmail("stam@info.com");
        try {
            adminFacade.addCompany(companyToAdd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - add company - email already exist");
        companyToAdd = adminFacade.getSingleCompany(1).orElseThrow(() -> new Exception("company not exist"));
        companyToAdd.setId(0);
        companyToAdd.setName("stam");
        try {
            adminFacade.addCompany(companyToAdd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - add company - success");
        companyToAdd = Company.builder().name("new company").email("new.company@info.com").password("1234").build();
        adminFacade.addCompany(companyToAdd);
        adminFacade.getAllCompanies().forEach(System.out::println);


        System.out.println("---------------------------------------------------------------------------------");

//        Company toUpdateCompany = null;
//        Test.test("Admin Facade - update company - cannot update id that not exist");
//        toUpdateCompany = adminFacade.getSingleCompany(1).orElseThrow(() -> new Exception("company not exist"));
//        try {
//            adminFacade.updateCompany(9000, toUpdateCompany);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        Test.test("Admin Facade - update company - cannot update company's id ");
//        toUpdateCompany = adminFacade.getSingleCompany(1).orElseThrow(() -> new Exception("company not exist"));
//        toUpdateCompany.setId(2);
//        try {
//            adminFacade.updateCompany(1, toUpdateCompany);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        Test.test("Admin Facade - update company - cannot update company's name ");
//        toUpdateCompany = adminFacade.getSingleCompany(1).orElseThrow(() -> new Exception("company not exist"));
//        toUpdateCompany.setName("stam name");
//        try {
//            adminFacade.updateCompany(1, toUpdateCompany);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        Test.test("Admin Facade - update company - success");
//        toUpdateCompany = adminFacade.getSingleCompany(1).orElseThrow(() -> new Exception("company not exist"));
//        toUpdateCompany.setEmail("update.mail@info.com");
//        toUpdateCompany.setPassword("7777");
//        adminFacade.updateCompany(1, toUpdateCompany);
//        adminFacade.getAllCompanies().forEach(System.out::println);
//
//        Test.test("Admin Facade - ge all companies - success");
//        adminFacade.getAllCompanies().forEach(System.out::println);
//
//        Test.test("Admin Facade - ge single company - success");
//        System.out.println(adminFacade.getSingleCompany(2));
//
//        System.out.println("---------------------------------------------------------------------------------");
//
//
//        Customer customerToAdd = null;
//        Test.test("Admin Facade - add customer - id already exist");
//        customerToAdd = adminFacade.getSingleCustomer(1).orElseThrow(() -> new Exception(("customer not exist")));
//        customerToAdd.setFirstName("stam");
//        customerToAdd.setLastName("stamstam");
//        customerToAdd.setEmail("stam@gmail.com");
//        customerToAdd.setPassword("4444");
//        try {
//            adminFacade.addCustomer(customerToAdd);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        Test.test("Admin Facade - add customer - email already exist");
//        customerToAdd = adminFacade.getSingleCustomer(1).orElseThrow(() -> new Exception("customer not exist"));
//        customerToAdd.setId(0);
//        customerToAdd.setFirstName("stam");
//        customerToAdd.setLastName("stamStam");
//        customerToAdd.setPassword("4444");
//        try {
//            adminFacade.addCustomer(customerToAdd);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        Test.test("Admin Facade - add customer - success");
//        customerToAdd = Customer.builder().firstName("Danny").lastName("Ayanou").email("Danny@gmail.com").password("1234").build();
//        adminFacade.addCustomer(customerToAdd);
//        adminFacade.getAllCustomer().forEach(System.out::println);
//
//        System.out.println("---------------------------------------------------------------------------------");
//
//        Customer toUpdateCustomer = null;
//        Test.test("Admin Facade - update customer - cannot update id that not exist");
//        toUpdateCustomer = adminFacade.getSingleCustomer(1).orElseThrow(() -> new Exception("customer not exist"));
//        try {
//            adminFacade.updateCustomer(9000, toUpdateCustomer);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        Test.test("Admin Facade - update customer - cannot update customer's id ");
//        toUpdateCustomer = adminFacade.getSingleCustomer(1).orElseThrow(() -> new Exception("company not exist"));
//        toUpdateCustomer.setId(2);
//        try {
//            adminFacade.updateCustomer(1, toUpdateCustomer);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        Test.test("Admin Facade - ge all customers - success");
//        adminFacade.getAllCustomer().forEach(System.out::println);
//
//        Test.test("Admin Facade - ge single customer - success");
//        System.out.println(adminFacade.getSingleCustomer(2));
//
//        System.out.println("---------------------------------------------------------------------------------");
//
//        Company toDeleteCompany = null;
//        Test.test("Admin Facade - delete company - cannot delete id that not exist");
//        toDeleteCompany = adminFacade.getSingleCompany(1).orElseThrow(()-> new Exception("company not exist"));
//        toDeleteCompany.setId(10);
//
//        try {
//            adminFacade.deleteCompany(10);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        adminFacade.getAllCompanies().forEach(System.out::println);
//
//
//
//
//
//    }
    }
}