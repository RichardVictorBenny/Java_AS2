/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JButton;

import com.mycompany.rentalsystem.Model.*;
import com.mycompany.rentalsystem.View.LandlordView;

/**
 *
 * @author HP
 */
public class LandlordController{
    private LandlordView landlordView;
    private Landlord landlordModel;
    private ArrayList<House> houseArray = new ArrayList<>();
    private ArrayList<Tenant> tenantArray = new ArrayList<>();
    
    

    public LandlordController(LandlordView landlordView, Landlord landlordModel){
        this.landlordView = landlordView;
        this.landlordModel = landlordModel;

        landlordView.addDashboardButtonListener(new MenubarListener());
        landlordView.addHousesButtonListener(new MenubarListener());
        landlordView.addTenantsButtonListener(new MenubarListener());
        landlordView.addMaintenanceButtonListener(new MenubarListener());
        landlordView.addPaymentButtonListener(new MenubarListener());
        landlordView.addOtherButtonListener(new MenubarListener());
        landlordView.addSignoutButtonListener(new MenubarListener());

        landlordView.houseAddButtonListener(new HouseListener());
        landlordView.houseUpdateButtonListener(new HouseListener());
        landlordView.houseDeleteButtonListener(new HouseListener());
        landlordView.houseClearFormButtonListener(new HouseListener());

        landlordView.tenantDeleteButtonListener(new TenantListener());
        landlordView.tenantAddButtonListener(new TenantListener());
        landlordView.tenantClearFormButtonListener(new TenantListener());
        landlordView.tenantUpdateButtonListener(new TenantListener());
    }

    class MenubarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
                JButton menuButtonPressed = (JButton) e.getSource();
                String menuButtonName = menuButtonPressed.getText();
                switch (menuButtonName) {
                    case "Dashboard":
                        landlordView.dashboardButtonActionPerformed(e);
                        break;
                    case "Houses":
                        landlordView.housesButtonActionPerformed(e);
                        break;
                    case "Tenants":
                        landlordView.tenantsButtonActionPerformed(e);
                        break;
                    case "Maintenance":
                        landlordView.maintenanceButtonActionPerformed(e);
                    break;
                    case "Payments":
                        landlordView.paymentButtonActionPerformed(e);
                    break;
                    case "Others":
                        landlordView.otherButtonActionPerformed(e);
                    break;
                    case "Sign Out":
                        landlordView.signoutButtonActionPerformed(e);
                        break;
                    default:
                        break;
                }
            }
        }

    }

    /**
     * 
     */
    class HouseListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
                JButton buttonPressed = (JButton) e.getSource();
                String buttonPressedName = buttonPressed.getText();
                switch (buttonPressedName) {
                    case "ADD":
                        House tempHouseObj = landlordView.houseAddButtonActionPerformed(e);
                        houseArray.add(tempHouseObj);
                        landlordView.insertValueTable(landlordView.getHouseListTable(), tempHouseObj.getDataArray());
                        //append file and save
                        //refresh the table
                        break;
                    case "CLEAR":
                        landlordView.houseClearFormButtonActionPerformed(e);
                        break;
                    case "UPDATE":
                        landlordView.houseUpdateButtonActionPerformed(e);
                        break;
                    case "DELETE":
                        landlordView.houseDeleteButtonActionPerformed(e);
                        break;
                    default:
                        // add an error log to logger
                        System.out.println("Action Not Recognised");
                        break;
                }
            }
        }

    }

    class TenantListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
                JButton buttonPressed = (JButton) e.getSource();
                String buttonPressedName = buttonPressed.getText();
                switch (buttonPressedName) {
                    case "ADD":
                    Tenant tempTenantObj = landlordView.tenantAddButtonActionPerformed(e);
                        tenantArray.add(tempTenantObj);
                        landlordView.insertValueTable(landlordView.getTenantListTable(), tempTenantObj.getDataArray());
                        
                        //append file and save
                        //refresh the table
                        break;
                    case "CLEAR":
                        landlordView.tenantClearFormButtonActionPerformed(e);
                        break;
                    case "UPDATE":
                        landlordView.tenantUpdateButtonActionPerformed(e);
                        break;
                    case "DELETE":
                        landlordView.tenantDeleteButtonActionPerformed(e);
                        break;
                    default:
                        // add an error log to logger
                        System.out.println("Action Not Recognised");
                        break;
                }
            }
        }

    }

    public void setHouseArray(House house){
        this.houseArray.add(house);
    }

    public ArrayList<House> getHouseArray(){
        return this.houseArray;
    }

    public ArrayList<Tenant> getTenantArray() {
        return this.tenantArray;
    }

    public void setTenantArray(Tenant tenant) {
        this.tenantArray.add(tenant);
    }
}
