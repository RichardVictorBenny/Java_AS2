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

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
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
import java.sql.Blob;

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

        landlordView.getCashReceivedLabel().setText(String.valueOf(calculateTotalRentFromTenants()));

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
        landlordView.homeHouseButtonListener(new MenubarListener());
        landlordView.homeTenantDetailsButtonListener(new MenubarListener());
        landlordView.seeNewRequestsButtonListener(new MenubarListener());
        landlordView.homeUpcomingPaymentButtonListener(new MenubarListener());

        landlordView.othersLogTenantViewButtonListener(new ActionListener() {
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
                Map<String, Object> record = new HashMap<>();
                record.put("status", value);
                try {
                    database.update("maintenance", record, "logId", id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                landlordView.clearErrorDetailsForm();
            }

        });

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
     * calculates the number of rows in a given table
     * 
     * @param table String table name as in the database
     * @return int count of the total rows
     */
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

    /**
     * Inner class that implements the ActionListener interface that handles
     * switching between different panels.
     */
    class MenubarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                JButton menuButtonPressed = (JButton) e.getSource();
                String menuButtonName = menuButtonPressed.getName();
                switch (menuButtonName) {
                    case "dashboard":
                        landlordView.dashboardButtonActionPerformed(e);
                        break;
                    case "houses":
                        landlordView.housesButtonActionPerformed(e);
                        break;
                    case "tenants":
                        landlordView.tenantsButtonActionPerformed(e);
                        break;
                    case "maintenance":
                        landlordView.maintenanceButtonActionPerformed(e);
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
                String buttonPressedName = buttonPressed.getText();
                switch (buttonPressedName) {
                    case "ADD":
                        // makes a houseObject and then adds that to the database
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
                        Map<String, Object> updateRecord = new HashMap<>();
                        updateRecord.put("houseObject", FileConvertion.toByteArray(houseObject));

                        if (houseObject != null) {
                            try {
                                database.update("houses", updateRecord, 
                                "houseId", String.valueOf(houseObject.getHouseId()));
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

                        if (tempTenantObj != null) {
                            record.add(tempTenantObj.getTenantId());
                            record.add(FileConvertion.toByteArray(tempTenantObj));
                            try {
                                database.insert("tenants", "tenantId, tenantObject", record);
                                database.insert("tenantjoindate",
                                        "tenantId, date",
                                        new ArrayList<>(Arrays.asList(
                                                tempTenantObj.getTenantId(),
                                                tempTenantObj.getFormatedDob(localDate))));
                                Password.savePassword(tempTenantObj.getTenantId(),
                                        String.valueOf(tempTenantObj.getFormatedDob(tempTenantObj.getDob())), "Tenant");
                            } catch (Exception exception) {
                                exception.printStackTrace();
                            }

                            record.clear();
                            landlordView.clearTenantForm();

                            TableRefresh.refreshTable(landlordView, database, "Tenants",
                                    landlordView.getTenantListTable());

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
                                e1.printStackTrace();
                            }

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
                                database.update("tenants", updateRecord, 
                                "tenantId", String.valueOf(tenantObject.getTenantId()));
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
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }
                        break;
                    case "REVIEW":
                        result = database.find("maintenance", "logId", id);
                        try {
                            landlordView.populateErrorDetailsForm(result);
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }
                        ;
                        break;
                    case "PREVIOUS":
                        result = database.find("maintenance", "logId", id);
                        try {
                            landlordView.populateErrorDetailsForm(result);
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }

                        break;
                    case "MAINTENANCE SECONDARY":
                        result = database.find("maintenance", "logId", id);
                        try {
                            landlordView.populateOtherMaintenaceForm(result);
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }
                    case "TENANT PAYMENTS":
                        result = database.find("payments", "id", id);
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
         * @deprecated
         */
        @Override
        public void mousePressed(MouseEvent e) {
        }

        /**
         * {@inheritDoc}
         * 
         * @deprecated
         */
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        /**
         * {@inheritDoc}
         * 
         * @deprecated
         */
        @Override
        public void mouseEntered(MouseEvent e) {
        }

        /**
         * {@inheritDoc}
         * 
         * @deprecated
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
         * @deprecated
         */
        @Override
        public void keyTyped(KeyEvent e) {
        }

        /**
         * {@inheritDoc}
         * 
         * @deprecated
         */
        @Override
        public void keyPressed(KeyEvent e) {
        }

        /**
         * {@inheritDoc}
         * 
         * @deprecated
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
                set = database.find("houses", "houseId", id);
                break;
            case "tenantObject":
                set = database.find("tenants", "tenantId", id);
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

}
