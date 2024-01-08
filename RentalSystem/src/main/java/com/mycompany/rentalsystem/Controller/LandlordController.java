/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mycompany.rentalsystem.Model.*;
import com.mycompany.rentalsystem.View.LandlordView;
import com.mycompany.rentalsystem.funcitons.Database;
import com.mycompany.rentalsystem.funcitons.FileConvertion;
import com.mycompany.rentalsystem.funcitons.Password;
import com.mycompany.rentalsystem.funcitons.SentEmail;
import com.mycompany.rentalsystem.funcitons.Sorting;
import com.mycompany.rentalsystem.funcitons.TableRefresh;
import com.mysql.cj.jdbc.Blob;

/**
 *
 * @author HP
 */
public class LandlordController {
    private LandlordView landlordView;
    private Landlord landlordModel;
    private Database database = new Database();
    private Timer timer = new Timer();

    public LandlordController(LandlordView landlordView, Landlord landlordModel) {
        this.landlordView = landlordView;
        this.landlordModel = landlordModel;

        // reference:
        // https://stackoverflow.com/questions/33073671/how-to-execute-a-method-every-minute
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                TableRefresh.refreshTable(landlordView, database, "Maintenance", landlordView.getErrorNewListTable());
                TableRefresh.refreshTable(landlordView, database, "Maintenance",
                        landlordView.getErrorReviewListTable());
                TableRefresh.refreshTable(landlordView, database, "Maintenance",
                        landlordView.getPreviousErrorListTable());

                landlordView.getHouseCountLabel().setText(String.valueOf(calculateCount("Houses")));
                landlordView.getTenantCountLabel().setText(String.valueOf(calculateCount("Tenants")));
                landlordView.getNewMaintenanceRequestCount().setText(String.valueOf(calculateCount("maintenance")));
            }
        };
        timer.schedule(task, 0, 600);

        TableRefresh.refreshTable(landlordView, database, "Houses", landlordView.getHouseListTable());
        TableRefresh.refreshTable(landlordView, database, "Tenants", landlordView.getTenantListTable());
        landlordView.getHouseCountLabel().setText(String.valueOf(calculateCount("Houses")));
        landlordView.getTenantCountLabel().setText(String.valueOf(calculateCount("Tenants")));
        landlordView.getNewMaintenanceRequestCount().setText(String.valueOf(calculateCount("maintenance")));

        landlordView.addDashboardButtonListener(new MenubarListener());
        landlordView.addHousesButtonListener(new MenubarListener());
        landlordView.addTenantsButtonListener(new MenubarListener());
        landlordView.addMaintenanceButtonListener(new MenubarListener());
        landlordView.addPaymentButtonListener(new MenubarListener());
        landlordView.addOtherButtonListener(new MenubarListener());
        landlordView.addSignoutButtonListener(new MenubarListener());
        landlordView.othersLogTenantViewButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                landlordView.othersLogTenantViewButtonActionPerformed(e);
                TableRefresh.refreshTable(landlordView, database, "maintenance", landlordView.getMaintenanceRequestListTable());
            }
        });

        landlordView.houseAddButtonListener(new HouseListener());
        landlordView.houseUpdateButtonListener(new HouseListener());
        landlordView.houseDeleteButtonListener(new HouseListener());
        landlordView.houseClearFormButtonListener(new HouseListener());

        landlordView.tenantDeleteButtonListener(new TenantListener());
        landlordView.tenantAddButtonListener(new TenantListener());
        landlordView.tenantClearFormButtonListener(new TenantListener());
        landlordView.tenantUpdateButtonListener(new TenantListener());

        landlordView.errorUpdateStatusButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = (String) landlordView.getErrorDetailsStatusComboBox().getSelectedItem();
                String id = (String) landlordView.getErrorDetailsLogidTextField().getText();
                database.updateMaintenance(value, id);
                landlordView.clearErrorDetailsForm();
            }

        });

        landlordView.houseListTableListener(new LandlordMouseListener());
        landlordView.tenantListTableListener(new LandlordMouseListener());
        landlordView.errorNewListTableListener(new LandlordMouseListener());
        landlordView.errorReviewListTableListener(new LandlordMouseListener());
        landlordView.previousErrorListTableListener(new LandlordMouseListener());
        landlordView.maintenanceRequestListTableListener(new LandlordMouseListener());

        landlordView.houseSearchTextFieldListener(new LandlordKeyListener());
        landlordView.tenantSearchTextFieldListener(new LandlordKeyListener());
        landlordView.maintenanceRequestSearchTextFieldListener(new LandlordKeyListener());
        landlordView.previousErrorSearchTextFieldListener(new LandlordKeyListener());

    }

    private int calculateCount(String table) {
        ResultSet result = database.findAll(table);
        int count = 0;
        try {
            while (result.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
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
                    case "Tenant":
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
                        landlordView.dispose();
                        // exits program
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
                            TableRefresh.insertValueTable(landlordView.getHouseListTable(), houseObj.getDataArray());
                            record.add(houseObj.getHouseId());
                            record.add(FileConvertion.toByteArray(houseObj));
                            try {
                                database.insert("houses", "houseId, houseObject", record);
                            } catch (Exception exception) {
                                exception.printStackTrace();
                                // add to logger
                            }
                            record.clear();
                            landlordView.clearHouseForm();
                            TableRefresh.refreshTable(landlordView, database, "Houses",
                                    landlordView.getHouseListTable());
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

                            TableRefresh.refreshTable(landlordView, database, "Houses",
                                    landlordView.getHouseListTable());
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

                        TableRefresh.refreshTable(landlordView, database, "Houses", landlordView.getHouseListTable());

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
                            record.add(FileConvertion.toByteArray(tempTenantObj));
                            try {
                                database.insert("tenants", "tenantId, tenantObject", record);
                                Password.savePassword(tempTenantObj.getTenantId(),
                                        String.valueOf(tempTenantObj.getFormatedDob(tempTenantObj.getDob())), "Tenant");
                            } catch (Exception exception) {
                                exception.printStackTrace();
                            }
                            record.clear();
                            landlordView.clearTenantForm();

                            TableRefresh.refreshTable(landlordView, database, "Tenants",
                                    landlordView.getTenantListTable());

                            // uncomment the code
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

                            TableRefresh.refreshTable(landlordView, database, "Tenants",
                                    landlordView.getTenantListTable());
                        }
                        break;
                    case "DELETE":
                        String id = landlordView.tenantDeleteButtonActionPerformed(e);
                        try {
                            database.delete("tenants", "tenantId", id);
                            database.delete("tenantpasswords", "username", id);

                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        landlordView.clearTenantForm();

                        TableRefresh.refreshTable(landlordView, database, "Tenants", landlordView.getTenantListTable());
                        break;
                    default:
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
                String id = getIdAtPoint(clickedTable, e);
                ResultSet result;
                switch (tableName) {
                    case "HOUSE TABLE":

                        House houseObject = (House) getObjectFromId(id, "houseObject");
                        landlordView.populateHouseForm(houseObject);
                        break;
                    case "TENANT TABLE":
                        Tenant tenantObject = (Tenant) getObjectFromId(id, "tenantObject");
                        landlordView.populateTenantForm(tenantObject);
                        break;

                    case "NEW ERROR":
                        result = database.find("maintenance", "logId", id);
                        try {
                            landlordView.populateErrorDetailsForm(result);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    case "REVIEW":
                        result = database.find("maintenance", "logId", id);
                        try {
                            landlordView.populateErrorDetailsForm(result);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        ;
                        break;
                    case "PREVIOUS":
                        result = database.find("maintenance", "logId", id);
                        try {
                            landlordView.populateErrorDetailsForm(result);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        ;
                        break;
                    case "MAINTENANCE SECONDARY":
                        result = database.find("maintenance", "logId", id);
                        try{
                            landlordView.populateOtherMaintenaceForm(result);
                        } catch(SQLException exception){
                            exception.printStackTrace();
                        }

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

    class LandlordKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getSource() instanceof JTextField) {
                JTextField textField = (JTextField) e.getSource();
                switch (textField.getName()) {
                    case "HOUSE SEARCH":
                        Sorting.sortTable(landlordView.getHouseListTable(), textField.getText());
                        break;
                    case "TENANT SEARCH":
                        Sorting.sortTable(landlordView.getTenantListTable(), textField.getText());
                        break;
                    case "PREVIOUS":
                        Sorting.sortTable(landlordView.getPreviousErrorListTable(), textField.getText());
                        break;

                    case "MAINTENANCE":   
                        Sorting.sortTable(landlordView.getMaintenanceRequestListTable(), textField.getText());
                        break;

                    default:
                        break;
                }
            }

        }

    }

    private String getIdAtPoint(JTable clickedTable, MouseEvent e) {
        int row = clickedTable.rowAtPoint(e.getPoint());
        int rowId = Integer.valueOf((String) clickedTable.getModel().getValueAt(row, 0));
        String id = (String.valueOf(rowId));
        return id;
    }

    private Object getObjectFromId(String id, String label) {
        ResultSet set = null;
        switch (label) {
            case "houseObject":
                set = database.findHouse(id);
                break;
            case "tenantObject":
                set = database.findTenant(id);
                break;
            default:
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

}
