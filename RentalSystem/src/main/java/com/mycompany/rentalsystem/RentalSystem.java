/* /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rentalsystem;


import com.mycompany.rentalsystem.Controller.LoginController;
import com.mycompany.rentalsystem.Controller.TenantController;/*  */
import com.mycompany.rentalsystem.Model.LoginModel;
import com.mycompany.rentalsystem.Model.TenantModel;
import com.mycompany.rentalsystem.View.LandlordView;
import com.mycompany.rentalsystem.View.LoginView;
import com.mycompany.rentalsystem.View.TenantView;


/**
 *
 * @author Richard
 */
public class RentalSystem {

    public static void main(String[] args) {
        
        /* LoginView view = new LoginView();
        LoginModel model = new LoginModel();
        LoginController controller = new LoginController(view, model); 
        

        TenantView view = new TenantView();
        TenantModel model = new TenantModel();
        TenantController controller = new TenantController(view, model);*/
        
        LandlordView view = new LandlordView();
        

        java.awt.EventQueue.invokeLater(() -> {
            view.setVisible(true);
        });
    }
}
