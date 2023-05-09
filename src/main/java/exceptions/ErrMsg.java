package exceptions;

import lombok.Getter;

@Getter
public enum ErrMsg {

    ADD_COMPANY_ID_EXIST("cannot add company since company's  id already exist"),
    ADD_COMPANY_NAME_EXIST("cannot add company since company's  name already exist"),
    ADD_COMPANY_EMAIL_EXIST("cannot add company since company's  email already exist"),
    DELETE_COMPANY_CANNOT_DELETE_COMPANY_NOT_EXIST("cannot delete company since company's  not exist"),

    UPDATE_COMPANY_ID_NOT_EXIST("cannot update company since company id not exist"),
    UPDATE_COMPANY_CANNOT_UPDATE_ID("cannot update company's id"),
    UPDATE_COMPANY_CANNOT_UPDATE_NAME("cannot update company's name"),

    ADD_CUSTOMER_ID_EXIST("cannot add customer since customer's id already exist"),
    ADD_CUSTOMER_EMAIL_EXIST("cannot add customer since customer's  email already exist"),
    UPDATE_CUSTOMER_ID_NOT_EXIST("cannot update customer's since customer id not exist"),
    UPDATE_CUSTOMER_CANNOT_UPDATE_ID("cannot update customer's id"),
    DELETE_CUSTOMER_CANNOT_DELETE_CUSTOMER_NOT_EXIST("cannot delete customer's customer not exist"),
    ADD_COUPON_TITLE_EXIST("cannot add coupon title already exist"),
    UPDATE_COUPON__ID_NOT_EXIST("cannot update coupon since coupon id not exist"),
    UPDATE_COUPON_CANNOT_UPDATE_ID("cannot update coupon's id"),
    DELETE_COUPON_BY_ID("cannot delete coupon since coupon id not exist"),

    UPDATE_COUPON_COMPANY_ID("cannot update coupon companyId name"),
    CUSTOMER_ALREADY_HAVE_COUPON ("cannot purchase Coupon since customer already have the coupon "),
    PURCHASE_COUPON_NOT_EXIST("cannot purchase coupon since No coupons in stock"),
    COUPON_EXPIRED ("cannot purchase coupon since coupon expired"),
    LOGIN_MANAGER("Invalid email or password");


    private  String message;

    ErrMsg(String message) {
        this.message = message;
    }
}
