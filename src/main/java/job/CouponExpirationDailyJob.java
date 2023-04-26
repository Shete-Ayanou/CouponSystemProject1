package job;

import beans.Coupon;
import dao.CouponDAO;
import dao.CouponDAOImpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class CouponExpirationDailyJob implements Runnable {


    private CouponDAO couponDAO;
    private boolean quit;

    private boolean shouldRun;


    public CouponExpirationDailyJob() {
        this.couponDAO = new CouponDAOImpl();

    }

    @Override
    public void run() {

        while (!shouldRun) {
            System.out.println("start checking coupon ex");
            List<Coupon> coupons = couponDAO.getAll();
            for (Coupon coupon : coupons) {
                if (coupon.getEndDate().after(getDate())) {
                    couponDAO.delete(coupon.getId());
                    couponDAO.deleteCouponPurchaseByCouponId(coupon.getId());
                }
            }
            System.out.println("stopped checking coupon ex");
            try {
                Thread.sleep(1000*60*60*60*24);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }

    public void stop() {
        shouldRun = true;

    }


    private Date getDate() {
        LocalDateTime currentDate = LocalDateTime.now();
        return new Date(currentDate.getYear()
                , currentDate.getMonthValue(), currentDate.getDayOfMonth()
                , currentDate.getHour(), currentDate.getMinute(), currentDate.getSecond());
    }


}
