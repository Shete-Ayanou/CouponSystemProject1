package loginManager;

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

    public ClientFacade login(String email, String password, ClientType clientType) {
        switch (clientType) {
            case ADMINISTRATOR:
                ClientFacade adminFacade = new AdminFacadeImpl();
                if (adminFacade.login(email, password))
                    return adminFacade;
                break;
            case COMPANY:
                ClientFacade companyFacade = new CompanyFacadeImpl(0);
                if (companyFacade.login(email, password))
                    return companyFacade;
                break;
            case CUSTOMER:
                ClientFacade customerFacade = new CustomerFacadeImpl(0);
                if(customerFacade.login(email, password))
                    return customerFacade;
                break;
        }
        return null;
    }
}
