/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Controller;

import com.mycompany.rentalsystem.Model.*;
import com.mycompany.rentalsystem.View.*;
import com.mycompany.rentalsystem.funcitons.Database;
import com.mycompany.rentalsystem.funcitons.Hashing;
import com.mycompany.rentalsystem.funcitons.SentEmail;
import com.mycompany.rentalsystem.funcitons.FileConvertion;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.swing.Action;
import javax.swing.JButton;



/**
 * 
 * @author Richard
 *
 */
public class TenantController{
    private TenantView tenantView;
    protected Tenant tenantModel;
    private Database database = new Database();

    public TenantController(TenantView tenantView, Tenant tenantModel) throws SQLException, Exception{
        this.tenantView = tenantView;
        this.tenantModel = tenantModel;

        ResultSet tenant = database.findTenant(tenantModel.getSessionId());
        while(tenant.next()){

            try {
                Blob tenantBlob =  tenant.getBlob("tenantObject");
            byte[] tenantByte = tenantBlob.getBytes(1, (int) tenantBlob.length());
            this.tenantModel = (Tenant) FileConvertion.toObject(tenantByte);
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            
        }
        

        
        
        tenantView.addDashboardButtonListener(new MenubarListener());
        tenantView.addPaymentButtonListener(new MenubarListener());
        tenantView.addMaintenanceButtonListener(new MenubarListener());
        tenantView.addOtherButtonListener(new MenubarListener());
        tenantView.addSignoutButtonListener(new MenubarListener());

        tenantView.maintenanceRequestSubmitButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String request = tenantView.maintenanceRequestSubmitButtonActionPerformed(e);
                //add request to database with all the needed values
            }
        } );

        tenantView.accountUpdatePasswordButtonListener(new ActionListener()  {
            public void actionPerformed(ActionEvent e){
                String tenantId = TenantController.this.tenantModel.getTenantId();
                String password = tenantView.accountUpdatePasswordButtonActionPerformed(e);
                if(password!=null){
                    try {
                        database.updatePassword("tenantpasswords",
                            Hashing.doHashing(password, tenantId),
                            tenantId);
                    } catch (NoSuchAlgorithmException exception) {
                        exception.printStackTrace();
                    }
                    tenantView.clearResetPassword();
                    try {
                        new SentEmail().sentMail(TenantController.this.tenantModel.geteMail(), "Password Change Detected", """
                                A Password change was detected!!

                                Contact Landlord Immediately!! if it was not you. Else ignore
                                
                                --auto generated
                                --do not reply
                                """);
                    } catch (GeneralSecurityException | IOException | MessagingException e1) {
                        e1.printStackTrace();
                    }
                } else{
                    throw new NullPointerException("passwords didn't match");
                }
            }
            
        });

        tenantView.addAccountLabelListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                tenantView.accountLabelMouseClicked(e);
                tenantView.populateAccountTenantForm(TenantController.this.getTenantModel());
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
            
        });
    }

    class MenubarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
                JButton menuButtonPressed = (JButton) e.getSource();
                String menuButtonName = menuButtonPressed.getText();
                switch (menuButtonName) {
                    case "Dashboard":
                        tenantView.dashboardButtonActionPerformed(e);
                        break;
                    case "Payment":
                        tenantView.paymentButtonActionPerformed(e);
                        break;
                    case "Maintenance":
                        tenantView.maintenanceButtonActionPerformed(e);
                        break;
                    case "Others":
                        tenantView.otherButtonActionPerformed(e);
                        break;
                    case "Sign Out":
                        tenantView.signoutButtonActionPerformed(e);
                        break;
                    default:
                        break;
                }
            }
        }
    }


    //getter and setter
    public Tenant getTenantModel() {
        return tenantModel;
    }

    public void setTenantModel(Tenant tenantModel) {
        this.tenantModel = tenantModel;
    }

    
    
}

