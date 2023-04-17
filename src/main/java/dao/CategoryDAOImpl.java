package dao;

import db.DBUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CategoryDAOImpl implements CategoryDAO {

    private static final String INSERT_CATEGORY = "INSERT INTO `coupon-system 159`.`categories` (`name`) VALUES (?)";

    @Override
    public void addCategory(String name) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,name);
        DBUtils.runQuery(INSERT_CATEGORY,params);

    }
}
