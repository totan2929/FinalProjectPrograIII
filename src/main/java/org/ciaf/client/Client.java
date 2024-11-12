package org.ciaf.client;

import org.ciaf.MainElectronicStore;
import org.ciaf.user.User;


import java.util.logging.Logger;

public class Client extends User {

    private String cellPhone;

    public Client(int id, String name,  String rol, String cellPhone) {
        super(id, name,  rol);
        this.cellPhone = cellPhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }


}

