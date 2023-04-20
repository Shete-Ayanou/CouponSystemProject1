package exceptions;

import lombok.Getter;

@Getter
public enum ErrMsg {

    ADD_COMPANY_ID_EXIST("cannot add company since company's  id already exist"),
    ADD_COMPANY_NAME_EXIST("cannot add company since company's  name already exist"),
    ADD_COMPANY_EMAIL_EXIST("cannot add company since company's  email already exist"),

    UPDATE_COMPANY_ID_NOT_EXIST("cannot update company since company id not exist"),
    UPDATE_COMPANY_CANNOT_UPDATE_ID("cannot update company's id"),
    UPDATE_COMPANY_CANNOT_UPDATE_NAME("cannot update company's name"),

    ADD_CUSTOMER_ID_EXIST("cannot add customer since customer's id already exist"),
    ADD_CUSTOMER_EMAIL_EXIST("cannot add customer since customer's  email already exist");


    private String message;

    ErrMsg(String message) {
        this.message = message;
    }
}
