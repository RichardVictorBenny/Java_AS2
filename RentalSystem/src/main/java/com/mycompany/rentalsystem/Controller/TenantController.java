/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Controller;

import com.mycompany.rentalsystem.Model.*;
import com.mycompany.rentalsystem.View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



/**
 * 
 * @author Richard
 *
 */
public class TenantController {
    private TenantView tenantView;
    private TenantModel tenantModel;

    public TenantController(TenantView tenantView, TenantModel tenantModel){
        this.tenantView = tenantView;
        this.tenantModel = tenantModel;
        
        
        /*tenantView.addDashboardHomeButtonListener(new TenantListener());
        tenantView.addPaymentButtonListener(new TenantListener());
        tenantView.addMaintenanceButtonListener(new TenantListener());
        tenantView.addContractButtonListener(new TenantListener());
        tenantView.addOthersButtonListener(new TenantListener());
        tenantView.addSignoutButtonListener(new TenantListener());
    }

    

    class TenantListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            // TODO Auto-generated method stub
            JButton button = (JButton) e.getSource();
            String buttonPressed = button.getText();
            
            tenantView.setPage(buttonPressed);
            
            
            

            
        }*/
        
    }
    
}

