/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Controller;

import com.mycompany.rentalsystem.View.*;
import com.mycompany.rentalsystem.Model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

/**
 *
 * @author Richard
 */
public class LoginController {

    LoginView loginView;
    LoginModel loginModel;

    public LoginController(LoginView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;

        loginView.addLoginButtonListener(new LoginListener());
        loginView.addforgotPasswordListener(new ForgotPasswordListener());

    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String username, password, usermode;

            try {
                username = loginView.getUsername();
                password = loginView.getPassword();
                usermode = loginView.getUsermode();

                // checking for usertype input
                if (usermode.equals("Please Select")) {
                    JOptionPane.showMessageDialog(loginView, "Please select a user type!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }

                // does validation and moves to dashboard
                if (loginModel.validate(username, password, usermode)) {
                    loginView.dispose();
                    switch (usermode) {
                        case "Tenant" -> {
                            TenantView view = new TenantView();
                            Tenant model = new Tenant();
                            TenantController controller = new TenantController(view, model);

                            java.awt.EventQueue.invokeLater(() -> {
                                view.setVisible(true);
                            });

                        }

                        case "Landlord" -> {
                            LandlordView view = new LandlordView();
                            Landlord model = new Landlord();
                            LandlordController controller = new LandlordController(view, model);

                            java.awt.EventQueue.invokeLater(() -> {
                                view.setVisible(true);
                            });
                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(loginView, "Wrong credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }

    }

    class ForgotPasswordListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            String userMode;
            try {
                userMode = loginView.getUsermode();

                switch (userMode) {
                    case "Please Select":
                        JOptionPane.showMessageDialog(loginView, "Please select a user type!", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                        break;
                    case "Tenant":
                        JOptionPane.showMessageDialog(loginView, "Contact Landlord!", "Reset",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case "Landlord":
                        JOptionPane.showMessageDialog(loginView, "Contact Admin!", "Reset",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case "Admin":
                        String pin = JOptionPane.showInputDialog("Enter your secert key:");
                        loginModel.resetPassword(pin);
                        break;
                }
            } catch (Exception exe) {
                System.out.println(exe);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

}
