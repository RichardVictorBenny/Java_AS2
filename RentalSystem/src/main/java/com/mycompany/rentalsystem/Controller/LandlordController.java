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
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mycompany.rentalsystem.Model.*;
import com.mycompany.rentalsystem.View.LandlordView;
import com.mycompany.rentalsystem.funcitons.Database;
import com.mycompany.rentalsystem.funcitons.FileConvertion;
import com.mycompany.rentalsystem.funcitons.Hashing;
import com.mycompany.rentalsystem.funcitons.Password;
import com.mycompany.rentalsystem.funcitons.PasswordGenerator;
import com.mycompany.rentalsystem.funcitons.SentEmail;
import com.mycompany.rentalsystem.funcitons.Sorting;
import com.mycompany.rentalsystem.funcitons.TableRefresh;

/**
 * controls the flow of actions as per the user input
 * 
 * @author Richard
 */
public class LandlordController {
    private LandlordView landlordView;
    private Landlord landlordModel;
    private Database database = new Database();
    private Timer timer = new Timer();

    /**
     * Constructor of the LanlordController class.
     * 
     * @param landlordView
     * @param landlordModel
     * @throws SQLException
     * @throws NumberFormatException
     */
    public LandlordController(LandlordView landlordView, Landlord landlordModel)
            throws NumberFormatException, SQLException {
        this.landlordView = landlordView;
        this.landlordModel = landlordModel;

        // reference:
        // https://stackoverflow.com/questions/33073671/how-to-execute-a-method-every-minute
        // refreshes the table in the maintenance panel periodically to
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

        // setting values of different metrics in dashboard.
        landlordView.getHouseCountLabel().setText(String.valueOf(calculateCount("Houses")));
        landlordView.getTenantCountLabel().setText(String.valueOf(calculateCount("Tenants")));
        landlordView.getNewMaintenanceRequestCount().setText(String.valueOf(calculateCount("maintenance")));
        landlordView.getCashReceivedLabel().setText(String.valueOf(calculateTotalRentFromTenants()));
        // ------------------

        // adding listeners for the different elements in the frame
        landlordView.addDashboardButtonListener(new MenubarListener());
        landlordView.addHousesButtonListener(new MenubarListener());
        landlordView.addTenantsButtonListener(new MenubarListener());
        landlordView.addMaintenanceButtonListener(new MenubarListener());
        landlordView.addPaymentButtonListener(new MenubarListener());
        landlordView.addOtherButtonListener(new MenubarListener());
        landlordView.addSignoutButtonListener(new MenubarListener());
        landlordView.homeHouseButtonListener(new MenubarListener());
        landlordView.homeTenantDetailsButtonListener(new MenubarListener());
        landlordView.seeNewRequestsButtonListener(new MenubarListener());
        landlordView.homeUpcomingPaymentButtonListener(new MenubarListener());

        landlordView.othersLogTenantViewButtonListener(new ActionListener() {
            /**
             * {@inherit}
             * 
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                landlordView.othersLogTenantViewButtonActionPerformed(e);
                TableRefresh.refreshTable(landlordView, database, "maintenance",
                        landlordView.getMaintenanceRequestListTable());
            }
        });
        landlordView.sendNewTenantPasswordListener(new ActionListener() {
            /**
             * {@inheritDoc}
             * 
             * updates database and sents email to the tenant who requested a manual
             * password reset.
             * 
             * @param e ActionEvent instance
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = PasswordGenerator.generatePassword();
                String tenantId = landlordView.getTenantResetTenantIdTextField().getText();
                Tenant tenant = null;
                Map<String, Object> record = new HashMap<>();

                try {
                    record.put("password", Hashing.doHashing(password, tenantId));
                    database.update("tenantpasswords",
                            record, "username",
                            tenantId);

                    tenant = (Tenant) getObjectFromId(tenantId, "tenantObject");
                    try {
                        new SentEmail().sentMail(tenant.geteMail(), "Your new Password", """
                                Hi %s,
                                This is the newly generated password for your account.
                                Password: %s

                                Change your password immediately.

                                -landlord
                                -do not reply
                                """.formatted(tenant.getFirstName(), password));
                    } catch (AddressException e1) {
                        e1.printStackTrace();
                    } catch (GeneralSecurityException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (MessagingException e1) {
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(landlordView, "Password reset successfully", "password reset",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | NoSuchAlgorithmException exception) {
                    exception.printStackTrace();
                }

            }
        });
        landlordView.othersTenantResetPasswordButtonListener(new ActionListener() {
            /**
             * {@inheritDoc}
             * switches to the change reset tenant password panel.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                landlordView.othersTenantResetPasswordButtonActionPerformed(e);
            }

        });
        landlordView.errorUpdateStatusButtonListener(new ActionListener() {
            /**
             * Action listener to update the status of a maintenance request.
             * {@inherit}
             * 
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = (String) landlordView.getErrorDetailsStatusComboBox().getSelectedItem();
                String id = (String) landlordView.getErrorDetailsLogidTextField().getText();

                // required for doing database actions.
                Map<String, Object> record = new HashMap<>();
                record.put("status", value);

                if (landlordView.getErrorDetailsLogidTextField() != null) {
                    try {
                        database.update("maintenance", record, "logId", id);
                        JOptionPane.showMessageDialog(landlordView, "Updated.", "Successful",
                                JOptionPane.INFORMATION_MESSAGE);
                        landlordView.clearErrorDetailsForm();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
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

        landlordView.houseListTableListener(new LandlordMouseListener());
        landlordView.tenantListTableListener(new LandlordMouseListener());
        landlordView.errorNewListTableListener(new LandlordMouseListener());
        landlordView.errorReviewListTableListener(new LandlordMouseListener());
        landlordView.previousErrorListTableListener(new LandlordMouseListener());
        landlordView.maintenanceRequestListTableListener(new LandlordMouseListener());
        landlordView.paymentTenantListTableListener(new LandlordMouseListener());

        landlordView.houseSearchTextFieldListener(new LandlordKeyListener());
        landlordView.tenantSearchTextFieldListener(new LandlordKeyListener());
        landlordView.maintenanceRequestSearchTextFieldListener(new LandlordKeyListener());
        landlordView.previousErrorSearchTextFieldListener(new LandlordKeyListener());
    }

    /**
     * Inner class that implements the ActionListener interface that handles
     * switching between different panels.
     */
    class MenubarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                JButton menuButtonPressed = (JButton) e.getSource();

                //names are given to different buttons in the LandlordView class.
                String menuButtonName = menuButtonPressed.getName();
                switch (menuButtonName) {
                    case "dashboard":
                        landlordView.dashboardButtonActionPerformed(e);
                        try {
                            landlordView.getCashReceivedLabel()
                                    .setText(String.valueOf(calculateTotalRentFromTenants()));
                        } catch (NumberFormatException | NullPointerException | SQLException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    case "houses":
                        landlordView.housesButtonActionPerformed(e);
                        break;
                    case "tenants":
                        landlordView.tenantsButtonActionPerformed(e);
                        break;
                    case "maintenance":
                        landlordView.maintenanceButtonActionPerformed(e);
                        //tables are refreshed perodically, so do not need to refresh the table here.
                        break;
                    case "payments":
                        landlordView.paymentButtonActionPerformed(e);
                        TableRefresh.refreshTable(landlordView, database, "payments",
                                landlordView.getPaymentTenantListTable());
                        break;
                    case "others":
                        landlordView.otherButtonActionPerformed(e);
                        break;
                    case "signOut":
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
     * Innner .class that implements the ActionListener interface for performing
     * tasks on the house panel.
     */
    class HouseListener implements ActionListener {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Object> record = new ArrayList<>();
            if (e.getSource() instanceof JButton) {
                JButton buttonPressed = (JButton) e.getSource();

                //names are given in the LandlordView class.
                String buttonPressedName = buttonPressed.getText();
                switch (buttonPressedName) {
                    case "ADD":
                        // makes a houseObject and then adds that to the database
                        House houseObj = landlordView.houseAddButtonActionPerformed(e);
                        if (houseObj != null) {
                            TableRefresh.insertValueTable(landlordView.getHouseListTable(), houseObj.getDataArray());
                            
                            //needed to perfrom database actions.
                            record.add(houseObj.getHouseId());
                            record.add(FileConvertion.toByteArray(houseObj));

                            try {
                                database.insert("houses", "houseId, houseObject", record);
                                JOptionPane.showMessageDialog(landlordView, "House added.", "Successful",
                                        JOptionPane.INFORMATION_MESSAGE);
                                landlordView.clearHouseForm();
                            } catch (Exception exception) {
                                exception.printStackTrace();
                                JOptionPane.showMessageDialog(landlordView, "Transaction failed", "Unuccessful",
                                        JOptionPane.ERROR_MESSAGE);

                            }
                            record.clear();
                            TableRefresh.refreshTable(landlordView, database, "Houses",
                                    landlordView.getHouseListTable());
                        }
                        break;
                    case "CLEAR":
                        landlordView.houseClearFormButtonActionPerformed(e);
                        break;
                    case "UPDATE":
                        House houseObject = landlordView.houseUpdateButtonActionPerformed(e);
                        //needed for performing database actions.
                        Map<String, Object> updateRecord = new HashMap<>();
                        updateRecord.put("houseObject", FileConvertion.toByteArray(houseObject));

                        if (houseObject != null) {
                            try {
                                database.update("houses", updateRecord, "houseId", String.valueOf(houseObject.getHouseId()));
                                JOptionPane.showMessageDialog(landlordView, "House updated.", "Successful", JOptionPane.INFORMATION_MESSAGE);
                                landlordView.clearHouseForm();
                            } catch (Exception exception) {
                                JOptionPane.showMessageDialog(landlordView, "Transaction failed", "Unuccessful", JOptionPane.ERROR_MESSAGE);
                                exception.printStackTrace();
                            }
                            record.clear();
                            TableRefresh.refreshTable(landlordView, database, "Houses", landlordView.getHouseListTable());
                        }
                        break;
                    case "DELETE":
                        String id = landlordView.houseDeleteButtonActionPerformed(e);
                        if (!houseOccupied(id)) {
                            try {
                                database.delete("houses", "houseId", id);
                                JOptionPane.showMessageDialog(landlordView, "House deleted.", "Successful", JOptionPane.INFORMATION_MESSAGE);
                            } catch (Exception exception) {
                                JOptionPane.showMessageDialog(landlordView, "Transaction failed", "Unsuccessful", JOptionPane.ERROR_MESSAGE);
                                exception.printStackTrace();
                            }
                            landlordView.clearHouseForm();
                            TableRefresh.refreshTable(landlordView, database, "Houses", landlordView.getHouseListTable());
                        }
                        break;
                    default:
                        System.out.println("Action Not Recognised");
                        break;
                }
            }
        }

    }

    /**
     * Inner class that implements AcitonListener inferface and performs action on
     * the tenantPanel.
     * Adds the date of creation to the tenantjoindate table in database
     */
    class TenantListener implements ActionListener {
        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Object> record = new ArrayList<>();
            if (e.getSource() instanceof JButton) {
                JButton buttonPressed = (JButton) e.getSource();
                String buttonPressedName = buttonPressed.getText();
                switch (buttonPressedName) {
                    case "ADD":
                        // makes the needed Tenant instance and add that to the database
                        Tenant tempTenantObj = landlordView.tenantAddButtonActionPerformed(e);
                        LocalDate localDate = LocalDate.now();

                        if (tempTenantObj != null && !tenantEmailCheck(tempTenantObj.geteMail())) {
                            record.add(tempTenantObj.getTenantId());
                            record.add(FileConvertion.toByteArray(tempTenantObj));
                            try {
                                database.insert("tenants", "tenantId, tenantObject", record);
                                database.insert("tenantjoindate", "tenantId, date",
                                        new ArrayList<>(Arrays.asList(
                                                tempTenantObj.getTenantId(),
                                                tempTenantObj.getFormatedDob(localDate))));
                                Password.savePassword(tempTenantObj.getTenantId(), String.valueOf(tempTenantObj.getFormatedDob(tempTenantObj.getDob())), "Tenant");
                                JOptionPane.showMessageDialog(landlordView, "Tenant added.", "Successful", JOptionPane.INFORMATION_MESSAGE);

                                // sends and email to the tenant, providing them with their username and
                                // password.
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
                                    JOptionPane.showMessageDialog(landlordView, "Email was not sent", "Unuccessful", JOptionPane.ERROR_MESSAGE);
                                    e1.printStackTrace();
                                }
                            } catch (Exception exception) {
                                JOptionPane.showMessageDialog(landlordView, "Transaction failed", "Unuccessful", JOptionPane.ERROR_MESSAGE);
                                exception.printStackTrace();
                            }
                            record.clear();
                            landlordView.clearTenantForm();
                            TableRefresh.refreshTable(landlordView, database, "Tenants", landlordView.getTenantListTable());
                        }
                        break;
                    case "CLEAR":
                        landlordView.tenantClearFormButtonActionPerformed(e);
                        break;
                    case "UPDATE":
                        Tenant tenantObject = landlordView.tenantUpdateButtonActionPerformed(e);
                        Map<String, Object> updateRecord = new HashMap<>();
                        updateRecord.put("tenantObject", tenantObject);

                        if (tenantObject != null) {
                            try {
                                database.update("tenants", updateRecord, "tenantId", String.valueOf(tenantObject.getTenantId()));
                                JOptionPane.showMessageDialog(landlordView, "Updated.", "Successful", JOptionPane.INFORMATION_MESSAGE);
                            } catch (Exception exception) {
                                JOptionPane.showMessageDialog(landlordView, "Transaction failed", "Unuccessful", JOptionPane.ERROR_MESSAGE);
                                exception.printStackTrace();
                            }
                            record.clear();
                            landlordView.clearTenantForm();
                            TableRefresh.refreshTable(landlordView, database, "Tenants", landlordView.getTenantListTable());
                        }
                        break;
                    case "DELETE":
                        String id = landlordView.tenantDeleteButtonActionPerformed(e);
                        try {
                            database.delete("tenants", "tenantId", id);
                            database.delete("tenantpasswords", "username", id);
                            JOptionPane.showMessageDialog(landlordView, "Tenant deleted.", "Successful", JOptionPane.INFORMATION_MESSAGE);

                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(landlordView, "Transaction failed", "Unuccessful", JOptionPane.ERROR_MESSAGE);
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

    /**
     * Inner class that implements the MouseListener interface and fills the
     * relevant forms.
     */
    class LandlordMouseListener implements MouseListener {
        /**
         * {@inheritDoc}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() instanceof JTable) {
                JTable clickedTable = (JTable) e.getSource();
                String tableName = clickedTable.getName();
                String id = TableRefresh.getIdAtPoint(clickedTable, e);
                ResultSet result = null;
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
                        try {
                            result = database.find("maintenance", "logId", id);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        try {
                            landlordView.populateErrorDetailsForm(result);
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }
                        break;
                    case "REVIEW":
                        try {
                            result = database.find("maintenance", "logId", id);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        try {
                            landlordView.populateErrorDetailsForm(result);
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }
                        ;
                        break;
                    case "PREVIOUS":
                        try {
                            result = database.find("maintenance", "logId", id);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        try {
                            landlordView.populateErrorDetailsForm(result);
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }

                        break;
                    case "MAINTENANCE SECONDARY":
                        try {
                            result = database.find("maintenance", "logId", id);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        try {
                            landlordView.populateOtherMaintenaceForm(result);
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }
                    case "TENANT PAYMENTS":
                        try {
                            result = database.find("payments", "id", id);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        try {
                            landlordView.populateTenantPaymentForm(result);
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }

                    default:
                        break;
                }
            }
        }

        /**
         * {@inheritDoc}
         * 
         */
        @Override
        public void mousePressed(MouseEvent e) {
        }

        /**
         * {@inheritDoc}
         * 
         */
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        /**
         * {@inheritDoc}
         * 
         */
        @Override
        public void mouseEntered(MouseEvent e) {
        }

        /**
         * {@inheritDoc}
         * 
         */
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    /**
     * Inner class that implements the KeyListener interface to do validations
     */
    class LandlordKeyListener implements KeyListener {
        /**
         * {@inheritDoc}
         * 
         */
        @Override
        public void keyTyped(KeyEvent e) {
        }

        /**
         * {@inheritDoc}
         * 
         */
        @Override
        public void keyPressed(KeyEvent e) {
        }

        /**
         * {@inheritDoc}
         * 
         */
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

    /**
     * 
     * @param id    String id of the object to be converted
     * @param label String column name of the relevant table and type
     * @return Object of the object associated with given id
     */
    private Object getObjectFromId(String id, String label) {
        ResultSet set = null;
        switch (label) {
            case "houseObject":
                try {
                    set = database.find("houses", "houseId", id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "tenantObject":
                try {
                    set = database.find("tenants", "tenantId", id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        try {
            while (set.next()) {
                Object object = (Object) FileConvertion.toObject(set.getBlob(label));
                set.close();
                return object;
            }
        } catch (SQLException | NullPointerException exception) {
            exception.printStackTrace();
        }

        return null;

    }

    /**
     * calculates the total rent paid by tenants and output as a Double
     * 
     * @throws SQLException
     * @throws NumberFormatException
     * @return Double total rent paid.
     */
    public Double calculateTotalRentFromTenants() throws NullPointerException, NumberFormatException, SQLException {
        ResultSet result = database.findAll("payments");
        Double rentTotal = 0.0;
        while (result.next()) {
            rentTotal += Double.valueOf(result.getString("Amount"));

        }
        return rentTotal;
    }

    /**
     * extension of deleting house.
     * Prevents house from getting deleted if tenants are assigned to the house
     * genertes a error message.
     * 
     * @param houseId String house to be deleted
     * @return boolean true if the house is occupied
     */
    private boolean houseOccupied(String houseId) {
        try {
            ResultSet result = database.findAll("tenants");
            while (result.next()) {
                String tenantId = result.getString("tenantId");
                Tenant tenantObj = (Tenant) FileConvertion.toObject(result.getBlob("tenantObject"));
                if (tenantObj.getHouseId().equals(houseId)) {
                    JOptionPane.showMessageDialog(landlordView, "House Occupied by " + tenantId, "error",
                            JOptionPane.ERROR_MESSAGE);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * extension of adding tenants
     * Prevents email dupication.
     * if a tenant with the same email exsists then an 
     * error message is thrown.
     * 
     * @param email String new email provided by user.
     * @return boolean true if the email already exsists
     */
    private boolean tenantEmailCheck(String email) {
        try {
            ResultSet result = database.findAll("tenants");
            while (result.next()) {
                String tenantId = result.getString("tenantId");
                Tenant tenantObj = (Tenant) FileConvertion.toObject(result.getBlob("tenantObject"));

                if (tenantObj.geteMail().equals(email)) {
                    JOptionPane.showMessageDialog(landlordView, "Email already exsists. Used by " + tenantId, "error",
                            JOptionPane.ERROR_MESSAGE);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * calculates the number of rows in a given table
     * 
     * @param table String table name as in the database
     * @return int count of the total rows
     */
    private int calculateCount(String table) {
        int count = 0;
        try (ResultSet result = database.findAll(table)) {
            try {
                while (result.next()) {
                    count++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
