package tests;

import job.CouponExpirationDailyJob;

public class JobTester {


    public static void main(String[] args) {

        CouponExpirationDailyJob couponExpirationDailyJob = new CouponExpirationDailyJob();

        Thread couponCleaner = new Thread(couponExpirationDailyJob);

        // cleaner is starting //
        couponCleaner.start();


//        couponExpirationDailyJob.stop();

    }

}
