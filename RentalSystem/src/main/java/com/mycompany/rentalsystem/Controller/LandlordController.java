/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JTable;

import com.mycompany.rentalsystem.Model.*;
import com.mycompany.rentalsystem.View.LandlordView;
import com.mycompany.rentalsystem.funcitons.Database;
import com.mysql.cj.jdbc.Blob;


/**
 *
 * @author HP
 */
public class LandlordController{
    private LandlordView landlordView;
    private Landlord landlordModel;
    private HashMap<String, Object> houseArray = new HashMap<>();
    private ArrayList<Tenant> tenantArray = new ArrayList<>();
    private Database database = new Database();
    
    

    public LandlordController(LandlordView landlordView, Landlord landlordModel){
        this.landlordView = landlordView;
        this.landlordModel = landlordModel;

        ResultSet allHouseRows = database.findAll("Houses");

        try {
            while(allHouseRows.next()){
                String[] data = new String[4];
                data[0] = allHouseRows.getString("houseId");

                //rebuild House object form ByteArray
                Blob houseBlob = (Blob) allHouseRows.getBlob("houseObject");
                byte[] houseByte = houseBlob.getBytes(1, (int) houseBlob.length());
                ByteArrayInputStream byteArrInpStm = new ByteArrayInputStream(houseByte);
                ObjectInputStream objInpStm = new ObjectInputStream(byteArrInpStm);
                House tempHouseObj = (House) objInpStm.readObject();

                data[1] = tempHouseObj.getHouseType();
                data[2] = tempHouseObj.getHouseAddress();
                data[3] = String.valueOf(tempHouseObj.getHouseRentPrice());
                
                landlordView.insertValueTable(landlordView.getHouseListTable(), data);
                House.setHouseId(tempHouseObj.getHouseId());
                houseArray.put(data[0], tempHouseObj);
                
                
            }
            allHouseRows.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        


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

        landlordView.houseListTableListener(new LandlordMouseListener());;
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
            HashMap<String, Object> record = new HashMap<>();
            if(e.getSource() instanceof JButton){
                JButton buttonPressed = (JButton) e.getSource();
                String buttonPressedName = buttonPressed.getText();
                switch (buttonPressedName) {
                    case "ADD":
                        House houseObj = landlordView.houseAddButtonActionPerformed(e);
                        landlordView.insertValueTable(landlordView.getHouseListTable(), houseObj.getDataArray());
                        record.put("houseId", String.valueOf(houseObj.getHouseId()));
                        record.put("houseObject", houseObj);
                        record.clear();
                
                        try{
                            database.insert("houses", record);
                        }
                        catch (Exception exception) {
                            exception.getMessage();
                            //add to logger
                        }
                        
                        //refresh the table
                        break;
                    case "CLEAR":
                        landlordView.houseClearFormButtonActionPerformed(e);
                        break;
                    case "UPDATE":
                        House houseObject = landlordView.houseUpdateButtonActionPerformed(e);
                        record.put("houseId", houseObject.getHouseId());
                        record.put("houseObject", houseObject);

                        try {
                            database.update("Houses", record);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }

                        record.clear();
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

    class LandlordMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() instanceof JTable){
                JTable clickedTable = (JTable) e.getSource();
                String tableName = clickedTable.getName();
                switch (tableName) {
                    case "HOUSE TABLE":
                        int row = clickedTable.rowAtPoint(e.getPoint());
                        int rowId = Integer.valueOf((String) clickedTable.getModel().getValueAt(row, 0));
                        House houseobject = (House) houseArray.get(String.valueOf(rowId));
                        landlordView.populateHouseForm(houseobject);
                        
                        break;
                
                    default:
                        break;
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
    }

    public ArrayList<Tenant> getTenantArray() {
        return this.tenantArray;
    }

    public void setTenantArray(Tenant tenant) {
        this.tenantArray.add(tenant);
    }
}
