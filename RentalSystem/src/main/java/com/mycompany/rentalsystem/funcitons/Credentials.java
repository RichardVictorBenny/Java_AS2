package com.mycompany.rentalsystem.funcitons;

import com.mycompany.rentalsystem.Model.Tenant;

public class Credentials {
    private String username = null;
    private String password = null;
    private SentEmail sentEmail = null;



    public void generateTempCredentials(Tenant tenant){
        username = String.valueOf(tenant.getTenantId());
        password = String.valueOf(tenant.getFormatedDob(tenant.getDob()));
        
        


    }

    public static void removeTenantFromPasswordFile(){

    }
}
