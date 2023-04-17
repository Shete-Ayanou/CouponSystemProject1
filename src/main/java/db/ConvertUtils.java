package db;


import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;

import java.sql.Date;
import java.util.Map;

/**
 * Created by kobis on 13 Mar, 2023
 */
public class ConvertUtils {

    public static Coupon couponFromPairs(Map<String, Object> map) {
        long id = (int) map.get("id");
        int companyId = (int) map.get("company_id");
        int category = (int) map.get("category_id");
        String title = (String) map.get("title");
        String description = (String) map.get("description");
        Date startDate = (Date) map.get("start_date");
        Date endDate = (Date) map.get("end_date");
        int amount = (int) map.get("amount");
        double price = (double) map.get("price");
        String image = (String) map.get("image");

        return new Coupon(id, companyId, Category.byDBId(category), title, description, startDate, endDate, amount, price, image);
    }


    public static boolean booleanFromPairs(Map<String, Object> map) {
        boolean res = ((long) map.get("res") == 1);
        return res;
    }

    public static Company companyFromPairs(Map<String, Object> map) {
        int id = (int) map.get("id");
        String name = (String) map.get("name");
        String email = (String) map.get("email");
        String password = (String) map.get("password");

        return Company.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .build();
    }

    public static Customer customerFromPairs(Map<String, Object> map) {
        int id = (int) map.get("id");
        String firstName = (String) map.get("first_name");
        String lastName = (String) map.get("last_name");
        String email = (String) map.get("email");
        String password = (String) map.get("password");

        return Customer.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
    }
}
