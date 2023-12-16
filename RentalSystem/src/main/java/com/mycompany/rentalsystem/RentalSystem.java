/* /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rentalsystem;

import javax.security.auth.login.LoginContext;

import com.mycompany.rentalsystem.Controller.LoginController;
import com.mycompany.rentalsystem.Model.LoginModel;
import com.mycompany.rentalsystem.View.LoginView;

/**
 *
 * @author Richard
 */
public class RentalSystem {

    public static void main(String[] args) {
        LoginView view = new LoginView();
        LoginModel model = new LoginModel();
        LoginController controller = new LoginController(view, model);
        
        java.awt.EventQueue.invokeLater(() -> {
            view.setVisible(true);
        });
    }
}
