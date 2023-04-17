package dao;

import beans.Coupon;
import db.ConvertUtils;
import db.DBUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CouponDAOImpl implements CouponDAO {

    private static final String INSERT_COUPON = "INSERT INTO `coupon-system 159`.`coupons` (`company_id`, `category_id`, `title`, `description`, `start_date`, `end_date`, `amount`, `price`, `image`) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_COUPON = "UPDATE `coupon-system 159`.`coupons` SET `company_id` = ?, `category_id` = ?, `title` = ?, `description` = ?, `start_date` = ?, `end_date` = ?, `amount` = ?, `price` = ?, `image` = ? WHERE (`id` = ?);";
    private static final String DELETE_COUPON = "DELETE FROM `coupon-system 159`.`coupons` WHERE (`id` = ?);";
    private static final String GET_ALL_COUPON = "SELECT * FROM `coupon-system 159`.coupons";
    private static final String GET_SINGLE_COUPON = "SELECT * FROM `coupon-system 159`.coupons WHERE (`id` = ?);";
    private static final String IS_COUPON_EXIST = "select exists (select * FROM `coupon-system 159`.coupons where id = 999 ) as res";
    private static final String INSERT_COUPON_PURCHASE ="INSERT INTO `coupon-system 159`.`customer_vs_coupons` (`customer_id`, `coupon_id`) VALUES (?, ?)";

    @Override
    public void add(Coupon coupon) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, coupon.getCompanyId());
        params.put(2, coupon.getCategory().getDBValue());
        params.put(3, coupon.getTitle());
        params.put(4, coupon.getDescription());
        params.put(5, coupon.getStartDate());
        params.put(6, coupon.getEndDate());
        params.put(7, coupon.getAmount());
        params.put(8, coupon.getPrice());
        params.put(9, coupon.getImage());
        DBUtils.runQuery(INSERT_COUPON, params);

    }

    @Override
    public void update(Integer id, Coupon coupon) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, coupon.getCompanyId());
        params.put(2, coupon.getCategory().getDBValue());
        params.put(3, coupon.getTitle());
        params.put(4, coupon.getDescription());
        params.put(5, coupon.getStartDate());
        params.put(6, coupon.getEndDate());
        params.put(7, coupon.getAmount());
        params.put(8, coupon.getPrice());
        params.put(9, coupon.getImage());
        params.put(10, coupon.getId());
        DBUtils.runQuery(UPDATE_COUPON, params);

    }

    @Override
    public void delete(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);
        DBUtils.runQuery(DELETE_COUPON, params);

    }

    @Override
    public List<Coupon> getAll() {
        List<Coupon> coupons = new ArrayList<>();
        List<?> results = DBUtils.runQueryWithResultSet(GET_ALL_COUPON);
        for (Object obj : results) {
            Map<String, Object> pairs = (Map<String, Object>) obj;
            Coupon coupon = ConvertUtils.couponFromPairs(pairs);
            coupons.add(coupon);
        }
        return coupons;
    }

    @Override
    public Coupon getSingle(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);
        List<?> results = DBUtils.runQueryWithResultSet(GET_SINGLE_COUPON);
        Object firstObject = results.get(0);
        Map<String, Object> pairs = (Map<String, Object>) firstObject;
        Coupon coupon = ConvertUtils.couponFromPairs(pairs);
        return coupon;

    }

    @Override
    public boolean isExist(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);
        List<?> results = DBUtils.runQueryWithResultSet(IS_COUPON_EXIST);
        Object firstObject = results.get(0);
        Map<String, Object> pairs = (Map<String, Object>) firstObject;
        boolean res = ConvertUtils.booleanFromPairs(pairs);
        return res;
    }

    @Override
    public void addCouponPurchase(int customerId, int couponId) {


    }

    @Override
    public void deleteCouponPurchase(int customerId, int couponId) {

    }
}
