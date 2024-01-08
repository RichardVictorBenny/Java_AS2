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
import com.mycompany.rentalsystem.funcitons.Sorting;
import com.mycompany.rentalsystem.funcitons.TableRefresh;
import com.mycompany.rentalsystem.funcitons.FileConvertion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * class that perform controls the flow according to the user input
 * @author Richard
 *
 */
public class TenantController {
    private TenantView tenantView;
    protected Tenant tenantModel;
    private Database database = new Database();

    /**
     * Constructor for the class
     * refreshes the needed tables.
     * get the user form the SESSION.txt file
     * 
     * @param tenantView 
     * @param tenantModel
     * @throws SQLException
     * @throws Exception
     */
    public TenantController(TenantView tenantView, Tenant tenantModel) throws SQLException, Exception {
        this.tenantView = tenantView;
        this.tenantModel = tenantModel;

        ResultSet tenant = database.findTenant(tenantModel.getSessionId());
        while (tenant.next()) {
            try {
                Blob tenantBlob = tenant.getBlob("tenantObject");
                byte[] tenantByte = tenantBlob.getBytes(1, (int) tenantBlob.length());
                this.tenantModel = (Tenant) FileConvertion.toObject(tenantByte);
            } catch (ClassCastException e) {
                e.printStackTrace();
            }

        }

        TableRefresh.refreshTable(tenantView, database, "maintenance", tenantView.getMaintenanceRequestListTable());

        tenantView.addDashboardButtonListener(new MenubarListener());
        tenantView.addPaymentButtonListener(new MenubarListener());
        tenantView.addMaintenanceButtonListener(new MenubarListener());
        tenantView.addSignoutButtonListener(new MenubarListener());
        tenantView.homePaymentButtonListener(new MenubarListener());
        tenantView.dashboardNewMaintenanceButtonListener(new MenubarListener());

        tenantView.maintenanceRequestSearchTextFieldListener(new TenantKeyListener());

        tenantView.maintenanceRequestSubmitButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String request = tenantView.maintenanceRequestSubmitButtonActionPerformed(e);
                ArrayList<Object> data = new ArrayList<>();
                LocalDate today = LocalDate.now();

                if (!request.equals(null)) {
                    data.add(String.valueOf(Maintenance.getLogId()));
                    data.add(TenantController.this.tenantModel.getFirstName() + " "
                            + TenantController.this.tenantModel.getSurName());
                    data.add(TenantController.this.tenantModel.getFormatedDob(today));
                    data.add(TenantController.this.tenantModel.getHouseId());
                    data.add(TenantController.this.tenantModel.getTenantId());
                    data.add(request);
                    data.add("Received");

                    database.insert("maintenance", "logId, tenantName, dateOfIssue, houseId, tenantId, description, status", data);
                    TableRefresh.refreshTable(tenantView, database, "maintenance", tenantView.getMaintenanceRequestListTable());

                    tenantView.getMaintenanceDescriptionTextArea().setText("");
                    JOptionPane.showMessageDialog(tenantView, "New Request made successfully.", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }

        });
        tenantView.contactMessageSendButtonListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String message = tenantView.contactMessageSendButtonActionPerformed(e);
                if(!message.equals("")){
                    try {
                        sendMessage(message);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(tenantView, "Message cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }});

        tenantView.accountUpdatePasswordButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tenantId = TenantController.this.tenantModel.getTenantId();
                String password = tenantView.accountUpdatePasswordButtonActionPerformed(e);
                if (password != null) {
                    try {
                        database.updatePassword("tenantpasswords",
                                Hashing.doHashing(password, tenantId),
                                tenantId);
                    } catch (NoSuchAlgorithmException exception) {
                        exception.printStackTrace();
                    }
                    tenantView.clearResetPassword();
                    try {
                        new SentEmail().sentMail(TenantController.this.tenantModel.geteMail(),
                                "Password Change Detected", """
                                        A Password change was detected!!

                                        Contact Landlord Immediately!! if it was not you. Else ignore

                                        --auto generated
                                        --do not reply
                                        """);
                    } catch (GeneralSecurityException | IOException | MessagingException e1) {
                        e1.printStackTrace();
                    }
                } else {
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

    /**
     * Inner class that implements the ActionListener interface that handles switching between different panels.
     */
    class MenubarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                JButton menuButtonPressed = (JButton) e.getSource();
                String menuButtonName = menuButtonPressed.getName();
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
                    case "signOut":
                        tenantView.signoutButtonActionPerformed(e);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * inner class to handle filtering tables
     */
    class TenantKeyListener implements KeyListener {

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
                    case "MAINTENANCE":
                        Sorting.sortTable(tenantView.getMaintenanceRequestListTable(), textField.getText() );
                        break;

                    default:
                        break;
                }
            }
        }

    }

    
    /**
     * Send email to Landlord.
     * @param message
     * @throws Exception
     */
    public void sendMessage(String message) throws Exception{
        String landlordEmail = "uk.developer.java@gmail.com";
        new SentEmail().sentMail(landlordEmail, "Message From Tenant", message);
    }

    // getter and setter
    public Tenant getTenantModel() {
        return tenantModel;
    }

    public void setTenantModel(Tenant tenantModel) {
        this.tenantModel = tenantModel;
    }

}
