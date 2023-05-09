package login;

import exceptions.CouponSystemException;
import exceptions.ErrMsg;
import facade.AdminFacadeImpl;
import facade.ClientFacade;
import facade.CompanyFacadeImpl;
import facade.CustomerFacadeImpl;

public class LoginManager {

    private LoginManager instance;

    private LoginManager() {
    }

    public LoginManager getInstance() {
        return instance;
    }

    public ClientFacade login(String email, String password, ClientType clientType) throws CouponSystemException {
        switch (clientType) {
            case ADMINISTRATOR:
                ClientFacade adminFacade = new AdminFacadeImpl();
                if (adminFacade.login(email, password))
                    return adminFacade;
                break;
            case COMPANY:
                ClientFacade companyFacade = new CompanyFacadeImpl();
                if (companyFacade.login(email, password))
                    return companyFacade;
                break;
            case CUSTOMER:
                ClientFacade customerFacade = new CustomerFacadeImpl();
                if(customerFacade.login(email, password))
                    return customerFacade;
                break;
        }
        throw new CouponSystemException(ErrMsg.LOGIN_MANAGER);
    }
}
