/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Controller;

import com.mycompany.rentalsystem.View.*;
import com.mycompany.rentalsystem.Model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 *
 * @author Richard
 */
public class LoginController{
    LoginView loginView;
    LoginModel loginModel;
    
    
    public LoginController(LoginView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;
        
        loginView.addLoginButtonListener(new LoginListener());
    }
    
    class LoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            String username, password, usermode;
            
            try{
                username = loginView.getUsername();
                password = loginView.getPassword();
                usermode = loginView.getUsermode();
                
                // checking for usertype input
                if (usermode.equals("Please Select")){
                    JOptionPane.showMessageDialog(loginView, "Please select a user type!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                
                //does validation and moves to dashboard
                if (loginModel.validate(username, password, usermode)){
                    //loginView.dispose();
                    System.out.println("logged in");
                    //call for dashboard
                } else {
                    JOptionPane.showMessageDialog(loginView, "Wrong credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            catch (Exception exception){
                System.out.println(exception);
            }
        }
            
    }
    



    
}