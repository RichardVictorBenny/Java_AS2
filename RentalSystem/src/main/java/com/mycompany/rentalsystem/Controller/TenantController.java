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
public class TenantController implements ActionListener{
    private TenantView tenantView;
    private Tenant tenantModel;

    public TenantController(TenantView tenantView, Tenant tenantModel){
        this.tenantView = tenantView;
        this.tenantModel = tenantModel;
        
        
        tenantView.addDashboardButtonListener(new MenubarListener());
        tenantView.addPaymentButtonListener(new MenubarListener());
        tenantView.addMaintenanceButtonListener(new MenubarListener());
        tenantView.addOtherButtonListener(new MenubarListener());
        tenantView.addSignoutButtonListener(new MenubarListener());
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

    



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}

