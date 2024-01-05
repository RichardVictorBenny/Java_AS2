/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mycompany.rentalsystem.Model.*;
import com.mycompany.rentalsystem.View.LandlordView;
import com.mycompany.rentalsystem.funcitons.Credentials;
import com.mycompany.rentalsystem.funcitons.Database;
import com.mycompany.rentalsystem.funcitons.FileConvertion;
import com.mycompany.rentalsystem.funcitons.SentEmail;
import com.mysql.cj.jdbc.Blob;

/**
 *
 * @author HP
 */
public class LandlordController {
    private LandlordView landlordView;
    private Landlord landlordModel;
    private HashMap<String, Object> houseArray = new HashMap<>();
    private HashMap<String, Object> tenantArray = new HashMap<>();
    private Database database = new Database();
    private int houseCount = 0;
    private int tenantCount = 0;
    private Credentials credentials = new Credentials();

    public LandlordController(LandlordView landlordView, Landlord landlordModel) {
        this.landlordView = landlordView;
        this.landlordModel = landlordModel;

        refreshTable("Houses", landlordView.getHouseListTable());
        refreshTable("Tenants", landlordView.getTenantListTable());

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

        landlordView.houseListTableListener(new LandlordMouseListener());
        landlordView.tenantListTableListener(new LandlordMouseListener());
    }

    class MenubarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
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
    class HouseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Object> record = new ArrayList<>();
            if (e.getSource() instanceof JButton) {
                JButton buttonPressed = (JButton) e.getSource();
                String buttonPressedName = buttonPressed.getText();
                switch (buttonPressedName) {
                    case "ADD":
                        House houseObj = landlordView.houseAddButtonActionPerformed(e);
                        if (houseObj != null) {
                            landlordView.insertValueTable(landlordView.getHouseListTable(), houseObj.getDataArray());
                            record.add(houseObj.getHouseId());
                            record.add(houseObj);
                            try {
                                database.insert("houses", "houseId, houseObject", record);
                            } catch (Exception exception) {
                                exception.printStackTrace();
                                // add to logger
                            }
                            record.clear();
                            landlordView.clearHouseForm();
                            houseCount = 0;
                            refreshTable("Houses", landlordView.getHouseListTable());
                        }
                        break;
                    case "CLEAR":
                        landlordView.houseClearFormButtonActionPerformed(e);
                        break;
                    case "UPDATE":
                        House houseObject = landlordView.houseUpdateButtonActionPerformed(e);
                        if (houseObject != null) {
                            try {
                                database.updateHouse(String.valueOf(houseObject.getHouseId()), houseObject);
                            } catch (Exception exception) {
                                exception.printStackTrace();
                            }
                            record.clear();
                            landlordView.clearHouseForm();

                            houseCount = 0;
                            refreshTable("Houses", landlordView.getHouseListTable());
                        }
                        break;
                    case "DELETE":
                        String id = landlordView.houseDeleteButtonActionPerformed(e);
                        try {
                            database.delete("houses", "houseId", id);

                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        landlordView.clearHouseForm();

                        houseCount = 0;
                        refreshTable("Houses", landlordView.getHouseListTable());

                        break;
                    default:
                        // add an error log to logger
                        System.out.println("Action Not Recognised");
                        break;
                }
            }
        }

    }

    class TenantListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Object> record = new ArrayList<>();
            if (e.getSource() instanceof JButton) {
                JButton buttonPressed = (JButton) e.getSource();
                String buttonPressedName = buttonPressed.getText();
                switch (buttonPressedName) {
                    case "ADD":
                        Tenant tempTenantObj = landlordView.tenantAddButtonActionPerformed(e);
                        
                        if (tempTenantObj != null) {
                            record.add(tempTenantObj.getTenantId());
                            record.add(tempTenantObj);
                            try {
                                database.insert("tenants", "tenantId, tenantObject", record);
                            } catch (Exception exception) {
                                exception.printStackTrace();
                            }
                            record.clear();

                            try {
                                new SentEmail().sentMail(tempTenantObj.geteMail(), "YOUR CREDENTIALS", """
                                        Hi %s,

                                        Your login username is %s.
                                        Your temporary password is %s.
                                        the format is 'DD-MM-YYYY'.

                                        Kindly 
                                        Landlord
                                        """.formatted(tempTenantObj.getSurName(), 
                                        tempTenantObj.getTenantId(), 
                                        String.valueOf(tempTenantObj.getFormatedDob(tempTenantObj.getDob()))));
                            } catch (GeneralSecurityException | IOException | MessagingException e1) {
                                e1.printStackTrace();
                            }

                            landlordView.clearTenantForm();

                            tenantCount = 0;
                            refreshTable("Tenants", landlordView.getTenantListTable());
                        }
                        // functions.generateTempCredentials();
                        break;
                    case "CLEAR":
                        landlordView.tenantClearFormButtonActionPerformed(e);
                        break;
                    case "UPDATE":
                        Tenant tenantObject = landlordView.tenantUpdateButtonActionPerformed(e);
                        if (tenantObject != null) {
                            try {
                                database.updateTenant(String.valueOf(tenantObject.getTenantId()), tenantObject);
                            } catch (Exception exception) {
                                exception.printStackTrace();
                            }
                            record.clear();
                            landlordView.clearTenantForm();

                            tenantCount = 0;
                            refreshTable("Tenants", landlordView.getTenantListTable());
                        }
                        break;
                    case "DELETE":
                        String id = landlordView.tenantDeleteButtonActionPerformed(e);
                        try {
                            database.delete("tenants", "tenantId", id);

                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        landlordView.clearTenantForm();

                        tenantCount = 0;
                        refreshTable("Tenants", landlordView.getTenantListTable());
                        break;
                    default:
                        // add an error log to logger
                        System.out.println("Action Not Recognised");
                        break;
                }
            }
        }

    }

    class LandlordMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() instanceof JTable) {
                JTable clickedTable = (JTable) e.getSource();
                String tableName = clickedTable.getName();
                switch (tableName) {
                    case "HOUSE TABLE":
                        /*
                         * int row = clickedTable.rowAtPoint(e.getPoint());
                         * int rowId = Integer.valueOf((String) clickedTable.getModel().getValueAt(row,
                         * 0));
                         * House houseobject = (House) houseArray.get(String.valueOf(rowId));
                         */
                        House houseObject = (House) getObjectAtPoint(clickedTable, e, "houseObject");
                        landlordView.populateHouseForm(houseObject);
                        break;
                    case "TENANT TABLE":
                        Tenant tenantObject = (Tenant) getObjectAtPoint(clickedTable, e, "tenantObject");
                        landlordView.populateTenantForm(tenantObject);
                        break;

                    default:
                        break;
                }

            } else {
                System.out.println("not recon");
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

    private Object getObjectAtPoint(JTable clickedTable, MouseEvent e, String label) {
        int row = clickedTable.rowAtPoint(e.getPoint());
        int rowId = Integer.valueOf((String) clickedTable.getModel().getValueAt(row, 0));
        String id = (String.valueOf(rowId));
        ResultSet set = null;
        switch (label) {
            case "houseObject":
                set = database.findHouse(id);
                break;
            case "tenantObject":
                set = database.findTenant(id);
                break;

        }

        try {
            while (set.next()) {
                Blob objectBlob;
                objectBlob = (Blob) set.getBlob(label);
                byte[] byteArray = objectBlob.getBytes(1, (int) objectBlob.length());

                Object object = (Object) FileConvertion.toObject(byteArray);
                set.close();
                return object;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public void refreshTable(String tableName, JTable jTable) {
        ResultSet allRows = database.findAll(tableName);
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();

        try {
            tableModel.getDataVector().removeAllElements();
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (tableName) {
            case "Houses":
                refreshHouseListTable(allRows);
                break;
            case "Tenants":
                refreshTenantlistTable(allRows);
                break;
            default:
                break;
        }

    }

    public void refreshHouseListTable(ResultSet allHouseRows) {
        try {
            landlordView.getTenantHouseIdComboBox().removeAllItems();
            while (allHouseRows.next()) {
                String[] data = new String[4];
                data[0] = allHouseRows.getString("houseId");

                // adding adding houseId to the tenant panel combobox

                landlordView.getTenantHouseIdComboBox().addItem(data[0]);

                // rebuild House object form ByteArray
                Blob houseBlob = (Blob) allHouseRows.getBlob("houseObject");
                byte[] houseByte = houseBlob.getBytes(1, (int) houseBlob.length());
                /*
                 * ByteArrayInputStream byteArrInpStm = new ByteArrayInputStream(houseByte);
                 * ObjectInputStream objInpStm = new ObjectInputStream(byteArrInpStm);
                 * House tempHouseObj = (House) objInpStm.readObject();
                 */

                House tempHouseObj = (House) FileConvertion.toObject(houseByte);

                data[1] = tempHouseObj.getHouseType();
                data[2] = tempHouseObj.getHouseAddress();
                data[3] = String.valueOf(tempHouseObj.getHouseRentPrice());

                landlordView.insertValueTable(landlordView.getHouseListTable(), data);
                House.setHouseId(tempHouseObj.getHouseId());
                houseCount++;

            }

            landlordView.getHouseCountLabel().setText(String.valueOf(this.houseCount));
            allHouseRows.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void refreshTenantlistTable(ResultSet allTenantRows) {
        try {
            while (allTenantRows.next()) {
                // String data = allTenantRows.getString("tenantId");

                // rebuild House object form ByteArray
                Blob blob = (Blob) allTenantRows.getBlob("tenantObject");
                byte[] tenantByte = blob.getBytes(1, (int) blob.length());
                Tenant tempObj = (Tenant) FileConvertion.toObject(tenantByte);
                landlordView.insertValueTable(landlordView.getTenantListTable(), tempObj.getDataArray());
                Tenant.setTenantId(Integer.valueOf(tempObj.getTenantId()));
                // tenantArray.put(data, tempObj);
                tenantCount++;
            }
            landlordView.getTenantCountLabel().setText(String.valueOf(tenantCount));
            allTenantRows.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
