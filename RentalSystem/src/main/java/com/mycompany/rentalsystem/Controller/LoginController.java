/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Controller;

import com.mycompany.rentalsystem.View.*;
import com.mycompany.rentalsystem.Model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author HP
 */
public class LoginController implements ActionListener{
    LoginView loginView;
    LoginModel loginModel;
    
    
    public LoginController(LoginView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;
        
        this.loginView.addLoginListener(new LoginListener());
    }
    
    class LoginListener impplements ActionListener{
        @override
        public void actionPerformed(ActionEvent e){
            String username, password;
            
            try{
                username = loginView.getUsername();
                password = loginView.getPassword();
                
                boolean validation = loginModel.validate(username, password);
                
                if (validation){
                    loginView.dispose();
                }
                
                
            }
        }
            
    }
    



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}