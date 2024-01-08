/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rentalsystem.View;

import com.mycompany.rentalsystem.Model.House;
import com.mycompany.rentalsystem.Model.Tenant;
import com.mycompany.rentalsystem.funcitons.Sorting;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.*;

/**
 *
 * @author HP
 */
public class LandlordView extends javax.swing.JFrame {

    /**
     * Creates new form LandlordView
     */
    public LandlordView() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Dashboard");

        dashboardButton.setName("dashboard");
        housesButton.setName("houses");
        tenantsButton.setName("tenants");
        maintenanceButton.setName("maintenance");
        paymentButton.setName("payments");
        otherButton.setName("others");
        signoutButton.setName("signOut");
        homeHouseButton.setName("houses");
        homeTenantDetailsButton.setName("tenants");
        seeNewRequestsButton.setName("maintenance");
        homeUpcomingPaymentButton.setName("payments");
    

        this.getHouseListTable().setName("HOUSE TABLE");
        this.getTenantListTable().setName("TENANT TABLE");
        this.getErrorNewListTable().setName("NEW ERROR");
        this.getErrorReviewListTable().setName("REVIEW");
        this.getPreviousErrorListTable().setName("PREVIOUS");
        this.getMaintenanceRequestListTable().setName("MAINTENANCE SECONDARY");

        this.getHouseSearchTextField().setName("HOUSE SEARCH");
        this.getTenantSearchTextField().setName("TENANT SEARCH");
        this.getMaintenanceRequestSearchTextField().setName("MAINTENANCE");
        this.getPreviousErrorSearchTextField().setName("PREVIOUS");

        lastnameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lastnameTextFieldActionPerformed(evt);
            }
        });
        phoneNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneNumberTextFieldActionPerformed(evt);
            }
        });
        firstnameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                firstnameTextFieldActionPerformed(evt);
            }
        });
        emailTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });

    }
    
    public void othersTenantResetPasswordButtonListener(ActionListener listener) {
        othersTenantResetPasswordButton.addActionListener(listener);
    }

    public void sendNewTenantPasswordListener(ActionListener listener){
        sendNewTenantPassword.addActionListener(listener);
    }

    public void homeHouseButtonListener(ActionListener menubarListener){
        homeHouseButton.addActionListener(menubarListener);
    }
    
    public void homeTenantDetailsButtonListener(ActionListener menubarListener){
        homeTenantDetailsButton.addActionListener(menubarListener);
    }
    
    public void seeNewRequestsButtonListener(ActionListener menubarListener){
        seeNewRequestsButton.addActionListener(menubarListener);
    }
    
    public void homeUpcomingPaymentButtonListener(ActionListener menubarListener){
        homeUpcomingPaymentButton.addActionListener(menubarListener);
    }

    public void addDashboardButtonListener(ActionListener menubarListener) {
        dashboardButton.addActionListener(menubarListener);
    }

    public void addHousesButtonListener(ActionListener menubarListener) {
        housesButton.addActionListener(menubarListener);
    }

    public void addTenantsButtonListener(ActionListener menubarListener) {
        tenantsButton.addActionListener(menubarListener);
    }

    public void addMaintenanceButtonListener(ActionListener menubarListener) {
        maintenanceButton.addActionListener(menubarListener);
    }

    public void addPaymentButtonListener(ActionListener menubarListener) {
        paymentButton.addActionListener(menubarListener);
    }

    public void addOtherButtonListener(ActionListener menubarListener) {
        otherButton.addActionListener(menubarListener);
    }

    public void addSignoutButtonListener(ActionListener menubarListener) {
        signoutButton.addActionListener(menubarListener);
    }

    public void houseAddButtonListener(ActionListener houseListener) {
        houseAddButton.addActionListener(houseListener);
    }

    public void houseClearFormButtonListener(ActionListener houseListener) {
        houseClearFormButton.addActionListener(houseListener);
    }

    public void houseUpdateButtonListener(ActionListener houseListener) {
        houseUpdateButton.addActionListener(houseListener);
    }

    public void houseDeleteButtonListener(ActionListener houseListener) {
        houseDeleteButton.addActionListener(houseListener);
    }

    public void tenantAddButtonListener(ActionListener tenantListener) {
        tenantAddButton.addActionListener(tenantListener);
    }

    public void tenantClearFormButtonListener(ActionListener tenantListener) {
        tenantClearFormButton.addActionListener(tenantListener);
    }

    public void tenantDeleteButtonListener(ActionListener tenantListener) {
        tenantDeleteButton.addActionListener(tenantListener);
    }

    public void tenantUpdateButtonListener(ActionListener tenantListener) {
        tenantUpdateButton.addActionListener(tenantListener);
    }

    public void errorUpdateStatusButtonListener(ActionListener moreButtons) {
        errorUpdateStatusButton.addActionListener(moreButtons);
    }

    public void errorTenantInfoButtonListener(ActionListener moreButton) {
        errorTenantInfoButton.addActionListener(moreButton);
    }

    public void errorDetailsHouseInfoButtonListener(ActionListener moreButtons) {
        errorDetailsHouseInfoButton.addActionListener(moreButtons);
    }

    public void othersLogTenantViewButtonListener(ActionListener moreButtons) {
        othersLogTenantViewButton.addActionListener(moreButtons);
    }

    // Mouse Listeners
    public void houseListTableListener(MouseListener clickListener) {
        houseListTable.addMouseListener(clickListener);
    }

    public void tenantListTableListener(MouseListener clickListener) {
        tenantListTable.addMouseListener(clickListener);
    }

    public void errorNewListTableListener(MouseListener clickListener) {
        errorNewListTable.addMouseListener(clickListener);
    }

    public void errorReviewListTableListener(MouseListener clickListener) {
        errorReviewListTable.addMouseListener(clickListener);
    }

    public void previousErrorListTableListener(MouseListener clickListener) {
        previousErrorListTable.addMouseListener(clickListener);
    }

    public void maintenanceRequestListTableListener(MouseListener clickListener){
        maintenanceRequestListTable.addMouseListener(clickListener);
    }

    // key listeners
    public void houseSearchTextFieldListener(KeyListener keyStroke) {
        houseSearchTextField.addKeyListener(keyStroke);
    }

    public void tenantSearchTextFieldListener(KeyListener keyStroke) {
        tenantSearchTextField.addKeyListener(keyStroke);
    }

    public void maintenanceRequestSearchTextFieldListener(KeyListener keyStroke) {
        maintenanceRequestSearchTextField.addKeyListener(keyStroke);
    }

    public void previousErrorSearchTextFieldListener(KeyListener keyStroke) {
        previousErrorSearchTextField.addKeyListener(keyStroke);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        landlordPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        accountLabel = new javax.swing.JLabel();
        menubarPanel = new javax.swing.JPanel();
        dashboardButton = new javax.swing.JButton();
        housesButton = new javax.swing.JButton();
        tenantsButton = new javax.swing.JButton();
        maintenanceButton = new javax.swing.JButton();
        paymentButton = new javax.swing.JButton();
        otherButton = new javax.swing.JButton();
        signoutButton = new javax.swing.JButton();
        landlordDashboard = new javax.swing.JLayeredPane();
        homeScrollPanel = new javax.swing.JScrollPane();
        home = new javax.swing.JPanel();
        greetingPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        landlordName = new javax.swing.JLabel();
        homeHousePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        houseIconLabel = new javax.swing.JLabel();
        houseCountLabel = new javax.swing.JLabel();
        houseDisplayLabel = new javax.swing.JLabel();
        homeHouseButton = new javax.swing.JButton();
        homeTenantPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        peopleIconLabel = new javax.swing.JLabel();
        tenantCountLabel = new javax.swing.JLabel();
        tenantDisplayLabel = new javax.swing.JLabel();
        homeTenantDetailsButton = new javax.swing.JButton();
        homeMaintenancePanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        maintenanceIconLabel = new javax.swing.JLabel();
        newMaintenanceRequestCount = new javax.swing.JLabel();
        requestDisplayLabel = new javax.swing.JLabel();
        seeNewRequestsButton = new javax.swing.JButton();
        homePaymentPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        maintenanceIconLabel1 = new javax.swing.JLabel();
        newMaintenanceRequestCount1 = new javax.swing.JLabel();
        requestDisplayLabel1 = new javax.swing.JLabel();
        homeUpcomingPaymentButton = new javax.swing.JButton();
        homeCashPanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        moneyIconLabel = new javax.swing.JLabel();
        cashReceivedLabel = new javax.swing.JLabel();
        cashDisplayLabel = new javax.swing.JLabel();
        homeTotalCashButton = new javax.swing.JButton();
        housesPanel = new javax.swing.JPanel();
        houseFormPanel = new javax.swing.JPanel();
        houseidDisplayLabel = new javax.swing.JLabel();
        houseTypeDisplayLabel = new javax.swing.JLabel();
        descriptionDisplayLabel = new javax.swing.JLabel();
        houseAddressDisplayLabel = new javax.swing.JLabel();
        houseRentDisplayLabel = new javax.swing.JLabel();
        houseidTextField = new javax.swing.JTextField();
        houseTypeComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        houseDescriptionTextArea = new javax.swing.JTextArea();
        houseAddressTextField = new javax.swing.JTextField();
        houseRentTextField = new javax.swing.JTextField();
        houseButtonPanel = new javax.swing.JPanel();
        houseClearFormButton = new javax.swing.JButton();
        houseAddButton = new javax.swing.JButton();
        houseUpdateButton = new javax.swing.JButton();
        houseDeleteButton = new javax.swing.JButton();
        houseListPanel = new javax.swing.JPanel();
        houseListScrollPane = new javax.swing.JScrollPane();
        houseListTable = new javax.swing.JTable();
        houseSearchTextField = new javax.swing.JTextField();
        tenantsPanel = new javax.swing.JPanel();
        tenantFormPanel = new javax.swing.JPanel();
        tenantidDisplayLabel = new javax.swing.JLabel();
        genderDisplayLabel = new javax.swing.JLabel();
        emailDisplayLabel = new javax.swing.JLabel();
        phoneNumberDisplayLabel = new javax.swing.JLabel();
        tenantidTextField = new javax.swing.JTextField();
        genderComboBox = new javax.swing.JComboBox<>();
        firstnameTextField = new javax.swing.JTextField();
        phoneNumberTextField = new javax.swing.JTextField();
        lastnameDisplayLabel = new javax.swing.JLabel();
        lastnameTextField = new javax.swing.JTextField();
        firstnameDisplayLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        dobDisplayLabel = new javax.swing.JLabel();
        dobDateChooser = new com.toedter.calendar.JDateChooser();
        tenantButtonPanel = new javax.swing.JPanel();
        tenantClearFormButton = new javax.swing.JButton();
        tenantAddButton = new javax.swing.JButton();
        tenantUpdateButton = new javax.swing.JButton();
        tenantDeleteButton = new javax.swing.JButton();
        tenantHouseIdDisplayLabel = new javax.swing.JLabel();
        tenantHouseIdComboBox = new javax.swing.JComboBox<>();
        tenantListPanel = new javax.swing.JPanel();
        tenantSearchTextField = new javax.swing.JTextField();
        tenantListScrollPane = new javax.swing.JScrollPane();
        tenantListTable = new javax.swing.JTable();
        paymentsPanel = new javax.swing.JPanel();
        paymentUpcomingPanel = new javax.swing.JPanel();
        paymentUpcomingDisplayLabel = new javax.swing.JLabel();
        paymentUpcomingScrollPane = new javax.swing.JScrollPane();
        paymentUpcomingListTable = new javax.swing.JTable();
        paymentUpcomingDetailsPanel = new javax.swing.JPanel();
        paymentUpcomingIdDisplayLabel = new javax.swing.JLabel();
        paymentUpcomingAmountDisplayLabel = new javax.swing.JLabel();
        paymentUpcomingTypeDisplayLabel = new javax.swing.JLabel();
        paymentUpcomingHouseDisplayLabel = new javax.swing.JLabel();
        paymentUpcomingDueDateDisplayLabel = new javax.swing.JLabel();
        paymentUpcomingStatusDisplayLabel = new javax.swing.JLabel();
        paymentUpcomingDescriptionLabel = new javax.swing.JLabel();
        paymentUpcomingIdTextField = new javax.swing.JTextField();
        paymentUpcomingAmountTextField = new javax.swing.JTextField();
        paymentUpcomingTypeTextField = new javax.swing.JTextField();
        paymentUpcomingHouseTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        paymentUpcomingDescriptionTextArea = new javax.swing.JTextArea();
        paymentUpcomingStatusComboBox = new javax.swing.JComboBox<>();
        paymentUpcomingHouseDetailsButton = new javax.swing.JButton();
        paymentUpcomingUpdateDetailsButton = new javax.swing.JButton();
        paymentUpcomingDueDateChooser = new com.toedter.calendar.JDateChooser();
        paymentUpcomingHouseAddButton = new javax.swing.JButton();
        paymentTenantPanel = new javax.swing.JPanel();
        paymentTenantDisplayLabel = new javax.swing.JLabel();
        paymentTenantScrollPane = new javax.swing.JScrollPane();
        paymentTenantListTable = new javax.swing.JTable();
        paymentUpcomingDetailsPanel1 = new javax.swing.JPanel();
        paymentTenantIdDisplayLabel = new javax.swing.JLabel();
        paymentTenantAmountDisplayLabel = new javax.swing.JLabel();
        paymentTenantDueDateDisplayLabel = new javax.swing.JLabel();
        paymentTenantHouseDisplayLabel = new javax.swing.JLabel();
        paymentTenantNameDisplayLabel = new javax.swing.JLabel();
        paymentTenantDescriptionDisplayLabel = new javax.swing.JLabel();
        paymentTenantIdTextField = new javax.swing.JTextField();
        paymentTenantAmountTextField = new javax.swing.JTextField();
        paymentTenantNameTextField = new javax.swing.JTextField();
        paymentTenantHouseTextField = new javax.swing.JTextField();
        paymentTenantDescriptionScrollPane = new javax.swing.JScrollPane();
        paymentTenantDescriptionTextArea = new javax.swing.JTextArea();
        paymentTenantTeantDetailsButton = new javax.swing.JButton();
        paymentTenantHouseDetailsButton = new javax.swing.JButton();
        paymentTenantDueDateChooser = new com.toedter.calendar.JDateChooser();
        errorPanel = new javax.swing.JPanel();
        errorNewDisplayLabel = new javax.swing.JLabel();
        errorDetailsPanel = new javax.swing.JPanel();
        errorDetailsDisplayLabel = new javax.swing.JLabel();
        errorDetailsLogidDisplayLabel = new javax.swing.JLabel();
        errorDetialsDateDisplayLabel = new javax.swing.JLabel();
        errorDescriptionDisplayLabel = new javax.swing.JLabel();
        errorDetailsLogidTextField = new javax.swing.JTextField();
        errorDetailsDateTextField = new javax.swing.JTextField();
        errorDescriptionScrollPane = new javax.swing.JScrollPane();
        errorDescriptionTextArea = new javax.swing.JTextArea();
        errorTenantDisplayLabel = new javax.swing.JLabel();
        errorTenantTextField = new javax.swing.JTextField();
        errorTenantInfoButton = new javax.swing.JButton();
        errorUpdateStatusButton = new javax.swing.JButton();
        errorDetialsStatusDisplayLabel = new javax.swing.JLabel();
        errorDetailsStatusComboBox = new javax.swing.JComboBox<>();
        errorDetailsHouseDiplayLabel = new javax.swing.JLabel();
        errorDetailsHouseidTextField = new javax.swing.JTextField();
        errorDetailsHouseInfoButton = new javax.swing.JButton();
        errorReviewListScrollPane = new javax.swing.JScrollPane();
        errorReviewListTable = new javax.swing.JTable();
        errorReviewDisplayLabel = new javax.swing.JLabel();
        errorNewListScrollPane = new javax.swing.JScrollPane();
        errorNewListTable = new javax.swing.JTable();
        previousErrorListScrollPane = new javax.swing.JScrollPane();
        previousErrorListTable = new javax.swing.JTable();
        previousErrorDisplayLabel = new javax.swing.JLabel();
        previousErrorSearchTextField = new javax.swing.JTextField();
        othersLayeredPane = new javax.swing.JLayeredPane();
        othersHomePanel = new javax.swing.JPanel();
        othersGreetingPanel = new javax.swing.JPanel();
        othersHomeGreetingDisplaylabel = new javax.swing.JLabel();
        othersDashboardPanel = new javax.swing.JPanel();
        othersContractPanel = new javax.swing.JPanel();
        othersContractDisplayLabel = new javax.swing.JLabel();
        othersContractNewButton = new javax.swing.JButton();
        othersContractViewButton = new javax.swing.JButton();
        othersLogTenantPanel = new javax.swing.JPanel();
        othersLogTenantDisplayLabel = new javax.swing.JLabel();
        othersLogTenantViewButton = new javax.swing.JButton();
        othersLogTenantPanel1 = new javax.swing.JPanel();
        othersLogTenantDisplayLabel1 = new javax.swing.JLabel();
        othersScheduleInspectionButton = new javax.swing.JButton();
        othersLogTenantPanel2 = new javax.swing.JPanel();
        othersLogTenantDisplayLabel2 = new javax.swing.JLabel();
        othersTenantResetPasswordButton = new javax.swing.JButton();
        othersViewContractPanel = new javax.swing.JPanel();
        othersIssueContractPanel = new javax.swing.JPanel();
        othersMaintenancePanel = new javax.swing.JPanel();
        otherMaintenanceRequestPanel = new javax.swing.JPanel();
        maintenanceRequestSearchTextField = new javax.swing.JTextField();
        maintenanceRequestListScrollPane = new javax.swing.JScrollPane();
        previousErrorListScrollPane1 = new javax.swing.JScrollPane();
        maintenanceRequestListTable = new javax.swing.JTable();
        otherMaintenanceDetailsPanel = new javax.swing.JPanel();
        maintenanceDescriptionLabel = new javax.swing.JLabel();
        maintenanceRequestieDisplayLabel = new javax.swing.JLabel();
        maintenanceHouseDisplayLabel = new javax.swing.JLabel();
        maintenanceRequestScrollPane = new javax.swing.JScrollPane();
        maintenanceDescriptionTextArea = new javax.swing.JTextArea();
        maintenanceRequestieTextField = new javax.swing.JTextField();
        maintenanceHouseTextField = new javax.swing.JTextField();
        tenantResetPasswordPanel = new javax.swing.JPanel();
        tenantResetTenantIdTextField = new javax.swing.JTextField();
        sendNewTenantPassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        landlordPanel.setBackground(new java.awt.Color(255, 204, 204));

        titlePanel.setBackground(new java.awt.Color(255, 204, 204));
        titlePanel.setForeground(new java.awt.Color(255, 255, 255));

        titleLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        titleLabel.setText("Company Name");

        accountLabel.setIcon(new javax.swing.ImageIcon(
                "D:\\OneDrive\\Documents\\UoN-notes\\YEAR 2\\CSY2094 - JAVA\\1 AS2\\RentalSystem\\src\\main\\java\\com\\mycompany\\rentalsystem\\images\\account.png")); // NOI18N

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(titlePanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(titleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1188,
                                        Short.MAX_VALUE)
                                .addComponent(accountLabel)
                                .addGap(30, 30, 30)));
        titlePanelLayout.setVerticalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(titlePanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(
                                        titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(titleLabel)
                                                .addComponent(accountLabel))
                                .addGap(30, 30, 30)));

        menubarPanel.setBackground(new java.awt.Color(255, 204, 204));
        menubarPanel.setPreferredSize(new java.awt.Dimension(320, 100));

        dashboardButton.setBackground(new java.awt.Color(242, 242, 242));
        dashboardButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dashboardButton.setForeground(new java.awt.Color(51, 51, 51));
        dashboardButton.setText("Dashboard");
        dashboardButton
                .setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(51, 51, 51)));
        dashboardButton.setFocusPainted(false);
        dashboardButton.setFocusable(false);
        dashboardButton.setPreferredSize(new java.awt.Dimension(200, 50));

        housesButton.setBackground(new java.awt.Color(242, 242, 242));
        housesButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        housesButton.setForeground(new java.awt.Color(51, 51, 51));
        housesButton.setText("Houses");
        housesButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(51, 51, 51)));
        housesButton.setFocusPainted(false);
        housesButton.setPreferredSize(new java.awt.Dimension(200, 50));

        tenantsButton.setBackground(new java.awt.Color(242, 242, 242));
        tenantsButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tenantsButton.setForeground(new java.awt.Color(51, 51, 51));
        tenantsButton.setText("Tenant");
        tenantsButton
                .setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(51, 51, 51)));
        tenantsButton.setFocusPainted(false);
        tenantsButton.setPreferredSize(new java.awt.Dimension(200, 50));

        maintenanceButton.setBackground(new java.awt.Color(242, 242, 242));
        maintenanceButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        maintenanceButton.setForeground(new java.awt.Color(51, 51, 51));
        maintenanceButton.setText("Maintenance");
        maintenanceButton
                .setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(51, 51, 51)));
        maintenanceButton.setFocusPainted(false);
        maintenanceButton.setPreferredSize(new java.awt.Dimension(200, 50));

        paymentButton.setBackground(new java.awt.Color(242, 242, 242));
        paymentButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        paymentButton.setForeground(new java.awt.Color(51, 51, 51));
        paymentButton.setText("Payments");
        paymentButton
                .setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(51, 51, 51)));
        paymentButton.setFocusPainted(false);
        paymentButton.setPreferredSize(new java.awt.Dimension(200, 50));

        otherButton.setBackground(new java.awt.Color(242, 242, 242));
        otherButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        otherButton.setForeground(new java.awt.Color(51, 51, 51));
        otherButton.setText("Others");
        otherButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(51, 51, 51)));
        otherButton.setFocusPainted(false);
        otherButton.setPreferredSize(new java.awt.Dimension(200, 50));

        signoutButton.setBackground(new java.awt.Color(242, 242, 242));
        signoutButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signoutButton.setForeground(new java.awt.Color(51, 51, 51));
        signoutButton.setText("Sign Out");
        signoutButton
                .setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(51, 51, 51)));
        signoutButton.setFocusPainted(false);
        signoutButton.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout menubarPanelLayout = new javax.swing.GroupLayout(menubarPanel);
        menubarPanel.setLayout(menubarPanelLayout);
        menubarPanelLayout.setHorizontalGroup(
                menubarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menubarPanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(menubarPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(housesButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tenantsButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(maintenanceButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signoutButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paymentButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(otherButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(60, Short.MAX_VALUE)));
        menubarPanelLayout.setVerticalGroup(
                menubarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menubarPanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(dashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(housesButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(tenantsButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(maintenanceButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(paymentButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(otherButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190,
                                        Short.MAX_VALUE)
                                .addComponent(signoutButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)));

        landlordDashboard.setBackground(new java.awt.Color(204, 255, 255));
        landlordDashboard.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        landlordDashboard.setLayout(new java.awt.CardLayout());

        homeScrollPanel.setBorder(null);
        homeScrollPanel.setEnabled(false);
        homeScrollPanel.setFocusable(false);

        home.setBackground(new java.awt.Color(255, 255, 255));
        home.setPreferredSize(new java.awt.Dimension(1345, 810));

        greetingPanel.setBackground(new java.awt.Color(255, 204, 204));
        greetingPanel
                .setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 153)));
        greetingPanel.setPreferredSize(new java.awt.Dimension(286, 120));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 52)); // NOI18N
        jLabel1.setText("Hi");

        landlordName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 52)); // NOI18N
        landlordName.setText("Name");

        javax.swing.GroupLayout greetingPanelLayout = new javax.swing.GroupLayout(greetingPanel);
        greetingPanel.setLayout(greetingPanelLayout);
        greetingPanelLayout.setHorizontalGroup(
                greetingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(greetingPanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(landlordName)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        greetingPanelLayout.setVerticalGroup(
                greetingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                greetingPanelLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(greetingPanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(landlordName))
                                        .addGap(30, 30, 30)));

        homeHousePanel.setBackground(new java.awt.Color(153, 153, 255));
        homeHousePanel.setPreferredSize(new java.awt.Dimension(400, 275));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        houseIconLabel.setIcon(new javax.swing.ImageIcon(
                "D:\\OneDrive\\Documents\\UoN-notes\\YEAR 2\\CSY2094 - JAVA\\1 AS2\\RentalSystem\\src\\main\\java\\com\\mycompany\\rentalsystem\\images\\home-icon-silhouette (2).png")); // NOI18N

        houseCountLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        houseCountLabel.setForeground(new java.awt.Color(255, 255, 255));
        houseCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        houseCountLabel.setText("99");

        houseDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        houseDisplayLabel.setForeground(new java.awt.Color(255, 255, 255));
        houseDisplayLabel.setText("Houses");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(houseIconLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93,
                                        Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(houseCountLabel)
                                        .addComponent(houseDisplayLabel))
                                .addGap(32, 32, 32)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(houseIconLabel))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(houseCountLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(houseDisplayLabel)))
                                .addGap(30, 30, 30)));

        homeHouseButton.setBackground(new java.awt.Color(204, 204, 255));
        homeHouseButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        homeHouseButton.setForeground(new java.awt.Color(102, 102, 255));
        homeHouseButton.setText("View Details");
        homeHouseButton.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(homeHouseButton, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homeHouseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        javax.swing.GroupLayout homeHousePanelLayout = new javax.swing.GroupLayout(homeHousePanel);
        homeHousePanel.setLayout(homeHousePanelLayout);
        homeHousePanelLayout.setHorizontalGroup(
                homeHousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homeHousePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        homeHousePanelLayout.setVerticalGroup(
                homeHousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homeHousePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        homeTenantPanel.setBackground(new java.awt.Color(0, 204, 204));
        homeTenantPanel.setPreferredSize(new java.awt.Dimension(400, 275));

        jPanel3.setBackground(new java.awt.Color(206, 247, 247));

        jPanel4.setBackground(new java.awt.Color(206, 247, 247));

        peopleIconLabel.setIcon(new javax.swing.ImageIcon(
                "D:\\OneDrive\\Documents\\UoN-notes\\YEAR 2\\CSY2094 - JAVA\\1 AS2\\RentalSystem\\src\\main\\java\\com\\mycompany\\rentalsystem\\images\\multiple-users-silhouette.png")); // NOI18N

        tenantCountLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        tenantCountLabel.setForeground(new java.awt.Color(255, 255, 255));
        tenantCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tenantCountLabel.setText("99");

        tenantDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tenantDisplayLabel.setForeground(new java.awt.Color(255, 255, 255));
        tenantDisplayLabel.setText("Tenants");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(peopleIconLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86,
                                        Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tenantCountLabel)
                                        .addComponent(tenantDisplayLabel))
                                .addGap(32, 32, 32)));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(peopleIconLabel))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(tenantCountLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tenantDisplayLabel)))
                                .addGap(30, 30, 30)));

        homeTenantDetailsButton.setBackground(new java.awt.Color(206, 247, 247));
        homeTenantDetailsButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        homeTenantDetailsButton.setForeground(new java.awt.Color(0, 204, 204));
        homeTenantDetailsButton.setText("View Details");
        homeTenantDetailsButton.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(homeTenantDetailsButton,
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homeTenantDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        javax.swing.GroupLayout homeTenantPanelLayout = new javax.swing.GroupLayout(homeTenantPanel);
        homeTenantPanel.setLayout(homeTenantPanelLayout);
        homeTenantPanelLayout.setHorizontalGroup(
                homeTenantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homeTenantPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        homeTenantPanelLayout.setVerticalGroup(
                homeTenantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homeTenantPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        homeMaintenancePanel.setBackground(new java.awt.Color(255, 204, 204));
        homeMaintenancePanel.setPreferredSize(new java.awt.Dimension(400, 275));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));

        jPanel6.setBackground(new java.awt.Color(255, 102, 102));

        maintenanceIconLabel.setIcon(new javax.swing.ImageIcon(
                "D:\\OneDrive\\Documents\\UoN-notes\\YEAR 2\\CSY2094 - JAVA\\1 AS2\\RentalSystem\\src\\main\\java\\com\\mycompany\\rentalsystem\\images\\settings.png")); // NOI18N

        newMaintenanceRequestCount.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        newMaintenanceRequestCount.setForeground(new java.awt.Color(255, 255, 255));
        newMaintenanceRequestCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newMaintenanceRequestCount.setText("99");

        requestDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        requestDisplayLabel.setForeground(new java.awt.Color(255, 255, 255));
        requestDisplayLabel.setText("New Requests");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(maintenanceIconLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56,
                                        Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(requestDisplayLabel)
                                        .addComponent(newMaintenanceRequestCount))
                                .addGap(32, 32, 32)));
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(maintenanceIconLabel))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addComponent(newMaintenanceRequestCount)
                                                .addGap(18, 18, 18)
                                                .addComponent(requestDisplayLabel)))
                                .addGap(30, 30, 30)));

        seeNewRequestsButton.setBackground(new java.awt.Color(255, 102, 102));
        seeNewRequestsButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        seeNewRequestsButton.setForeground(new java.awt.Color(255, 255, 255));
        seeNewRequestsButton.setText("View Requests");
        seeNewRequestsButton.setBorder(null);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(seeNewRequestsButton, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seeNewRequestsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        javax.swing.GroupLayout homeMaintenancePanelLayout = new javax.swing.GroupLayout(homeMaintenancePanel);
        homeMaintenancePanel.setLayout(homeMaintenancePanelLayout);
        homeMaintenancePanelLayout.setHorizontalGroup(
                homeMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homeMaintenancePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        homeMaintenancePanelLayout.setVerticalGroup(
                homeMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homeMaintenancePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        homePaymentPanel.setBackground(new java.awt.Color(255, 204, 204));
        homePaymentPanel.setPreferredSize(new java.awt.Dimension(400, 275));

        jPanel7.setBackground(new java.awt.Color(255, 102, 102));

        jPanel8.setBackground(new java.awt.Color(255, 102, 102));

        maintenanceIconLabel1.setIcon(new javax.swing.ImageIcon(
                "D:\\OneDrive\\Documents\\UoN-notes\\YEAR 2\\CSY2094 - JAVA\\1 AS2\\RentalSystem\\src\\main\\java\\com\\mycompany\\rentalsystem\\images\\income.png")); // NOI18N

        newMaintenanceRequestCount1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        newMaintenanceRequestCount1.setForeground(new java.awt.Color(255, 255, 255));
        newMaintenanceRequestCount1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newMaintenanceRequestCount1.setText("99");

        requestDisplayLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        requestDisplayLabel1.setForeground(new java.awt.Color(255, 255, 255));
        requestDisplayLabel1.setText("Upcoming Payments");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(maintenanceIconLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36,
                                        Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(requestDisplayLabel1)
                                        .addComponent(newMaintenanceRequestCount1))
                                .addGap(32, 32, 32)));
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(maintenanceIconLabel1)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(newMaintenanceRequestCount1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(requestDisplayLabel1,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)));

        homeUpcomingPaymentButton.setBackground(new java.awt.Color(255, 102, 102));
        homeUpcomingPaymentButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        homeUpcomingPaymentButton.setForeground(new java.awt.Color(255, 255, 255));
        homeUpcomingPaymentButton.setText("More Info");
        homeUpcomingPaymentButton.setBorder(null);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(homeUpcomingPaymentButton,
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homeUpcomingPaymentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        javax.swing.GroupLayout homePaymentPanelLayout = new javax.swing.GroupLayout(homePaymentPanel);
        homePaymentPanel.setLayout(homePaymentPanelLayout);
        homePaymentPanelLayout.setHorizontalGroup(
                homePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homePaymentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)));
        homePaymentPanelLayout.setVerticalGroup(
                homePaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homePaymentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        homeCashPanel.setBackground(new java.awt.Color(153, 153, 0));
        homeCashPanel.setPreferredSize(new java.awt.Dimension(400, 275));

        jPanel9.setBackground(new java.awt.Color(200, 248, 200));

        jPanel10.setBackground(new java.awt.Color(200, 248, 200));

        moneyIconLabel.setIcon(new javax.swing.ImageIcon(
                "D:\\OneDrive\\Documents\\UoN-notes\\YEAR 2\\CSY2094 - JAVA\\1 AS2\\RentalSystem\\src\\main\\java\\com\\mycompany\\rentalsystem\\images\\money-bag.png")); // NOI18N

        cashReceivedLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        cashReceivedLabel.setForeground(new java.awt.Color(255, 255, 255));
        cashReceivedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cashReceivedLabel.setText("999+");

        cashDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cashDisplayLabel.setForeground(new java.awt.Color(255, 255, 255));
        cashDisplayLabel.setText("Money Received");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(moneyIconLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58,
                                        Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cashReceivedLabel)
                                        .addComponent(cashDisplayLabel))
                                .addGap(32, 32, 32)));
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(moneyIconLabel))
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(cashReceivedLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cashDisplayLabel)))
                                .addGap(30, 30, 30)));

        homeTotalCashButton.setBackground(new java.awt.Color(200, 248, 200));
        homeTotalCashButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        homeTotalCashButton.setForeground(new java.awt.Color(153, 153, 0));
        homeTotalCashButton.setText("More Info");
        homeTotalCashButton.setBorder(null);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(homeTotalCashButton, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homeTotalCashButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        javax.swing.GroupLayout homeCashPanelLayout = new javax.swing.GroupLayout(homeCashPanel);
        homeCashPanel.setLayout(homeCashPanelLayout);
        homeCashPanelLayout.setHorizontalGroup(
                homeCashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homeCashPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        homeCashPanelLayout.setVerticalGroup(
                homeCashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homeCashPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
                homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(greetingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1345, Short.MAX_VALUE)
                        .addGroup(homeLayout.createSequentialGroup()
                                .addContainerGap(53, Short.MAX_VALUE)
                                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(homeHousePanel, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(homePaymentPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(homeTenantPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(homeCashPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(homeMaintenancePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE)));
        homeLayout.setVerticalGroup(
                homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homeLayout.createSequentialGroup()
                                .addComponent(greetingPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(homeLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(homeHousePanel, javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                        .addComponent(homeTenantPanel, javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                        .addComponent(homeMaintenancePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 266,
                                                Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(
                                        homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(homePaymentPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        266, Short.MAX_VALUE)
                                                .addComponent(homeCashPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 266,
                                                        Short.MAX_VALUE))
                                .addContainerGap(132, Short.MAX_VALUE)));

        homeScrollPanel.setViewportView(home);

        landlordDashboard.add(homeScrollPanel, "card3");

        houseidDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        houseidDisplayLabel.setText("House ID");

        houseTypeDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        houseTypeDisplayLabel.setText("Type");

        descriptionDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        descriptionDisplayLabel.setText("Description");

        houseAddressDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        houseAddressDisplayLabel.setText("Address");

        houseRentDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        houseRentDisplayLabel.setText("Rent Price");

        houseidTextField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N

        houseTypeComboBox.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        houseTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Detached", "Semi-Detached", "Terraced Houses", "End of Terrace" }));

        houseDescriptionTextArea.setColumns(20);
        houseDescriptionTextArea.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        houseDescriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(houseDescriptionTextArea);

        houseAddressTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N


        houseRentTextField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N


        houseClearFormButton.setBackground(new java.awt.Color(255, 255, 204));
        houseClearFormButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        houseClearFormButton.setText("CLEAR");
        houseClearFormButton.setBorder(null);

        houseAddButton.setBackground(new java.awt.Color(255, 255, 204));
        houseAddButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        houseAddButton.setText("ADD");
        houseAddButton.setBorder(null);

        houseUpdateButton.setBackground(new java.awt.Color(255, 255, 204));
        houseUpdateButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        houseUpdateButton.setText("UPDATE");
        houseUpdateButton.setBorder(null);

        houseDeleteButton.setBackground(new java.awt.Color(255, 255, 204));
        houseDeleteButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        houseDeleteButton.setText("DELETE");
        houseDeleteButton.setBorder(null);

        javax.swing.GroupLayout houseButtonPanelLayout = new javax.swing.GroupLayout(houseButtonPanel);
        houseButtonPanel.setLayout(houseButtonPanelLayout);
        houseButtonPanelLayout.setHorizontalGroup(
                houseButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(houseButtonPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(houseButtonPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, houseButtonPanelLayout
                                                .createSequentialGroup()
                                                .addComponent(houseAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, 181,
                                                        Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(houseClearFormButton,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 181,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(houseButtonPanelLayout.createSequentialGroup()
                                                .addComponent(houseUpdateButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(houseDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(16, 16, 16)));
        houseButtonPanelLayout.setVerticalGroup(
                houseButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(houseButtonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(houseButtonPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(houseClearFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(houseAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(houseButtonPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(houseUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(houseDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout houseFormPanelLayout = new javax.swing.GroupLayout(houseFormPanel);
        houseFormPanel.setLayout(houseFormPanelLayout);
        houseFormPanelLayout.setHorizontalGroup(
                houseFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(houseFormPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(houseFormPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(houseFormPanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(houseAddressTextField,
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(houseTypeComboBox,
                                                        javax.swing.GroupLayout.Alignment.LEADING, 0,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(houseTypeDisplayLabel,
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(houseidDisplayLabel,
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(descriptionDisplayLabel,
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(houseidTextField,
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(houseRentDisplayLabel,
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                                                .addComponent(houseAddressDisplayLabel,
                                                        javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGroup(houseFormPanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(houseButtonPanel,
                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(houseRentTextField,
                                                        javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addContainerGap(53, Short.MAX_VALUE)));
        houseFormPanelLayout.setVerticalGroup(
                houseFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(houseFormPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(houseidDisplayLabel)
                                .addGap(8, 8, 8)
                                .addComponent(houseidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(houseTypeDisplayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(houseTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(descriptionDisplayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(houseAddressDisplayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(houseAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(houseRentDisplayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(houseRentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30,
                                        Short.MAX_VALUE)
                                .addComponent(houseButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)));

        houseListTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "House Id", "Type", "Address", "Rent Price"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        houseListScrollPane.setViewportView(houseListTable);

        houseSearchTextField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N

        javax.swing.GroupLayout houseListPanelLayout = new javax.swing.GroupLayout(houseListPanel);
        houseListPanel.setLayout(houseListPanelLayout);
        houseListPanelLayout.setHorizontalGroup(
                houseListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(houseListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                        .addGroup(houseListPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(houseSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 298,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        houseListPanelLayout.setVerticalGroup(
                houseListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                houseListPanelLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(houseSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(houseListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 708,
                                                Short.MAX_VALUE)));

        javax.swing.GroupLayout housesPanelLayout = new javax.swing.GroupLayout(housesPanel);
        housesPanel.setLayout(housesPanelLayout);
        housesPanelLayout.setHorizontalGroup(
                housesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(housesPanelLayout.createSequentialGroup()
                                .addComponent(houseFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(houseListPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(34, 34, 34)));
        housesPanelLayout.setVerticalGroup(
                housesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(housesPanelLayout.createSequentialGroup()
                                .addComponent(houseFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, housesPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(houseListPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        landlordDashboard.add(housesPanel, "card3");

        tenantsPanel.setFocusable(false);

        tenantidDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        tenantidDisplayLabel.setText("Tenant ID");

        genderDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        genderDisplayLabel.setText("Gender");

        emailDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        emailDisplayLabel.setText("Email");

        phoneNumberDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        phoneNumberDisplayLabel.setText("Phone Number");

        tenantidTextField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N

        genderComboBox.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        firstnameTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        phoneNumberTextField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N

        lastnameDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lastnameDisplayLabel.setText("Last Name");

        lastnameTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        firstnameDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        firstnameDisplayLabel.setText("First Name");

        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        dobDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        dobDisplayLabel.setText("Date of Birth");

        tenantClearFormButton.setBackground(new java.awt.Color(255, 255, 204));
        tenantClearFormButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tenantClearFormButton.setText("CLEAR");
        tenantClearFormButton.setBorder(null);

        tenantAddButton.setBackground(new java.awt.Color(255, 255, 204));
        tenantAddButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tenantAddButton.setText("ADD");
        tenantAddButton.setBorder(null);

        tenantUpdateButton.setBackground(new java.awt.Color(255, 255, 204));
        tenantUpdateButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tenantUpdateButton.setText("UPDATE");
        tenantUpdateButton.setBorder(null);

        tenantDeleteButton.setBackground(new java.awt.Color(255, 255, 204));
        tenantDeleteButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tenantDeleteButton.setText("DELETE");
        tenantDeleteButton.setBorder(null);

        javax.swing.GroupLayout tenantButtonPanelLayout = new javax.swing.GroupLayout(tenantButtonPanel);
        tenantButtonPanel.setLayout(tenantButtonPanelLayout);
        tenantButtonPanelLayout.setHorizontalGroup(
                tenantButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tenantButtonPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(tenantButtonPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tenantAddButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tenantUpdateButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(tenantButtonPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tenantDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tenantClearFormButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16)));
        tenantButtonPanelLayout.setVerticalGroup(
                tenantButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tenantButtonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(tenantButtonPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tenantClearFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tenantAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(tenantButtonPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tenantUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tenantDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        tenantHouseIdDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        tenantHouseIdDisplayLabel.setText("House ID");

        javax.swing.GroupLayout tenantFormPanelLayout = new javax.swing.GroupLayout(tenantFormPanel);
        tenantFormPanel.setLayout(tenantFormPanelLayout);
        tenantFormPanelLayout.setHorizontalGroup(
                tenantFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tenantFormPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(tenantFormPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(firstnameDisplayLabel)
                                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 404,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastnameDisplayLabel)
                                        .addComponent(lastnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 404,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(tenantFormPanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(firstnameTextField,
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(genderComboBox, javax.swing.GroupLayout.Alignment.LEADING,
                                                        0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(genderDisplayLabel,
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tenantidDisplayLabel,
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tenantidTextField,
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(phoneNumberDisplayLabel,
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(emailDisplayLabel,
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(phoneNumberTextField)
                                                .addComponent(tenantButtonPanel,
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(tenantFormPanelLayout.createSequentialGroup()
                                                        .addGroup(tenantFormPanelLayout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(tenantFormPanelLayout.createSequentialGroup()
                                                                        .addComponent(dobDisplayLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        tenantFormPanelLayout.createSequentialGroup()
                                                                                .addComponent(tenantHouseIdDisplayLabel)
                                                                                .addGap(135, 135, 135)))
                                                        .addGroup(tenantFormPanelLayout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(dobDateChooser,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE, 198,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(tenantHouseIdComboBox, 0,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)))))
                                .addContainerGap(33, Short.MAX_VALUE)));
        tenantFormPanelLayout.setVerticalGroup(
                tenantFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tenantFormPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(tenantidDisplayLabel)
                                .addGap(8, 8, 8)
                                .addComponent(tenantidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(genderDisplayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(firstnameDisplayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(firstnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lastnameDisplayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(emailDisplayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(phoneNumberDisplayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(tenantFormPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dobDisplayLabel)
                                        .addComponent(dobDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(tenantFormPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tenantHouseIdDisplayLabel)
                                        .addComponent(tenantHouseIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16,
                                        Short.MAX_VALUE)
                                .addComponent(tenantButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)));

        tenantSearchTextField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N

        tenantListTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Tenant ID", "Gender", "First Name", "Last Name", "Email", "Phone Number", "Date of Birth"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tenantListScrollPane.setViewportView(tenantListTable);

        javax.swing.GroupLayout tenantListPanelLayout = new javax.swing.GroupLayout(tenantListPanel);
        tenantListPanel.setLayout(tenantListPanelLayout);
        tenantListPanelLayout.setHorizontalGroup(
                tenantListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tenantListPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(tenantSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 298,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(tenantListPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tenantListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 833,
                                        Short.MAX_VALUE)
                                .addContainerGap()));
        tenantListPanelLayout.setVerticalGroup(
                tenantListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tenantListPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(tenantSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tenantListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 633,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout tenantsPanelLayout = new javax.swing.GroupLayout(tenantsPanel);
        tenantsPanel.setLayout(tenantsPanelLayout);
        tenantsPanelLayout.setHorizontalGroup(
                tenantsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tenantsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tenantFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tenantListPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        tenantsPanelLayout.setVerticalGroup(
                tenantsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tenantsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(tenantsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tenantFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(tenantsPanelLayout.createSequentialGroup()
                                                .addComponent(tenantListPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(60, 60, 60)))
                                .addContainerGap()));

        landlordDashboard.add(tenantsPanel, "card4");

        paymentUpcomingPanel.setPreferredSize(new java.awt.Dimension(834, 400));

        paymentUpcomingDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        paymentUpcomingDisplayLabel.setText("Upcoming Payments");

        paymentUpcomingScrollPane.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        paymentUpcomingListTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null }
                },
                new String[] {
                        "Payment ID", "Amount", "Type", "House ID", "Due Date", "Status"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class,
                    java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        paymentUpcomingScrollPane.setViewportView(paymentUpcomingListTable);

        paymentUpcomingIdDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        paymentUpcomingIdDisplayLabel.setText("ID");

        paymentUpcomingAmountDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        paymentUpcomingAmountDisplayLabel.setText("Amount");

        paymentUpcomingTypeDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        paymentUpcomingTypeDisplayLabel.setText("Type");

        paymentUpcomingHouseDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        paymentUpcomingHouseDisplayLabel.setText("House ID");

        paymentUpcomingDueDateDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        paymentUpcomingDueDateDisplayLabel.setText("Due Date");

        paymentUpcomingStatusDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        paymentUpcomingStatusDisplayLabel.setText("Status");

        paymentUpcomingDescriptionLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        paymentUpcomingDescriptionLabel.setText("Description");

        paymentUpcomingIdTextField.setPreferredSize(new java.awt.Dimension(250, 30));

        paymentUpcomingAmountTextField.setPreferredSize(new java.awt.Dimension(250, 30));

        paymentUpcomingTypeTextField.setPreferredSize(new java.awt.Dimension(250, 30));

        paymentUpcomingHouseTextField.setPreferredSize(new java.awt.Dimension(250, 30));

        paymentUpcomingDescriptionTextArea.setColumns(20);
        paymentUpcomingDescriptionTextArea.setRows(5);
        paymentUpcomingDescriptionTextArea.setPreferredSize(new java.awt.Dimension(250, 50));
        jScrollPane2.setViewportView(paymentUpcomingDescriptionTextArea);

        paymentUpcomingStatusComboBox
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UnPaid", "Paid" }));
        paymentUpcomingStatusComboBox.setPreferredSize(new java.awt.Dimension(250, 30));

        paymentUpcomingHouseDetailsButton.setBackground(new java.awt.Color(248, 255, 255));
        paymentUpcomingHouseDetailsButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        paymentUpcomingHouseDetailsButton.setText("More Details");
        paymentUpcomingHouseDetailsButton.setEnabled(false);
        paymentUpcomingHouseDetailsButton.setPreferredSize(new java.awt.Dimension(150, 30));

        paymentUpcomingUpdateDetailsButton.setBackground(new java.awt.Color(248, 255, 255));
        paymentUpcomingUpdateDetailsButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        paymentUpcomingUpdateDetailsButton.setText("Update");
        paymentUpcomingUpdateDetailsButton.setPreferredSize(new java.awt.Dimension(150, 30));

        paymentUpcomingDueDateChooser.setPreferredSize(new java.awt.Dimension(250, 30));

        paymentUpcomingHouseAddButton.setBackground(new java.awt.Color(248, 255, 255));
        paymentUpcomingHouseAddButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        paymentUpcomingHouseAddButton.setText("Add New");
        paymentUpcomingHouseAddButton.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout paymentUpcomingDetailsPanelLayout = new javax.swing.GroupLayout(
                paymentUpcomingDetailsPanel);
        paymentUpcomingDetailsPanel.setLayout(paymentUpcomingDetailsPanelLayout);
        paymentUpcomingDetailsPanelLayout.setHorizontalGroup(
                paymentUpcomingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paymentUpcomingDetailsPanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(paymentUpcomingDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(paymentUpcomingDescriptionLabel)
                                        .addComponent(paymentUpcomingIdDisplayLabel)
                                        .addComponent(paymentUpcomingAmountDisplayLabel)
                                        .addComponent(paymentUpcomingTypeDisplayLabel)
                                        .addComponent(paymentUpcomingDueDateDisplayLabel)
                                        .addComponent(paymentUpcomingStatusDisplayLabel)
                                        .addComponent(paymentUpcomingHouseDisplayLabel))
                                .addGap(18, 18, 18)
                                .addGroup(paymentUpcomingDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(paymentUpcomingDetailsPanelLayout.createSequentialGroup()
                                                .addGroup(paymentUpcomingDetailsPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(paymentUpcomingHouseTextField,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(paymentUpcomingTypeTextField,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(paymentUpcomingAmountTextField,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(paymentUpcomingIdTextField,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane2))
                                                .addGroup(paymentUpcomingDetailsPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(paymentUpcomingDetailsPanelLayout
                                                                .createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(paymentUpcomingHouseDetailsButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(paymentUpcomingDetailsPanelLayout
                                                                .createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(paymentUpcomingHouseAddButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(paymentUpcomingDetailsPanelLayout.createSequentialGroup()
                                                .addComponent(paymentUpcomingStatusComboBox,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(paymentUpcomingUpdateDetailsButton,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(paymentUpcomingDueDateChooser,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        paymentUpcomingDetailsPanelLayout.setVerticalGroup(
                paymentUpcomingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paymentUpcomingDetailsPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(paymentUpcomingDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(paymentUpcomingIdDisplayLabel)
                                        .addComponent(paymentUpcomingIdTextField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paymentUpcomingDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(paymentUpcomingAmountDisplayLabel)
                                        .addComponent(paymentUpcomingAmountTextField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paymentUpcomingDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(paymentUpcomingTypeDisplayLabel)
                                        .addComponent(paymentUpcomingTypeTextField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paymentUpcomingDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(paymentUpcomingDueDateDisplayLabel)
                                        .addComponent(paymentUpcomingDueDateChooser,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paymentUpcomingDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(paymentUpcomingHouseTextField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paymentUpcomingHouseDisplayLabel)
                                        .addComponent(paymentUpcomingHouseDetailsButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paymentUpcomingDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(paymentUpcomingStatusComboBox,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paymentUpcomingUpdateDetailsButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paymentUpcomingStatusDisplayLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paymentUpcomingDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(paymentUpcomingDetailsPanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(paymentUpcomingDetailsPanelLayout.createSequentialGroup()
                                                        .addComponent(paymentUpcomingDescriptionLabel)
                                                        .addGap(39, 39, 39))
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                        Short.MAX_VALUE))
                                        .addComponent(paymentUpcomingHouseAddButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)));

        javax.swing.GroupLayout paymentUpcomingPanelLayout = new javax.swing.GroupLayout(paymentUpcomingPanel);
        paymentUpcomingPanel.setLayout(paymentUpcomingPanelLayout);
        paymentUpcomingPanelLayout.setHorizontalGroup(
                paymentUpcomingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paymentUpcomingPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(paymentUpcomingPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(paymentUpcomingPanelLayout.createSequentialGroup()
                                                .addComponent(paymentUpcomingScrollPane,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 700,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(paymentUpcomingDetailsPanel,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(paymentUpcomingPanelLayout.createSequentialGroup()
                                                .addComponent(paymentUpcomingDisplayLabel)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap()));
        paymentUpcomingPanelLayout.setVerticalGroup(
                paymentUpcomingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paymentUpcomingPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(paymentUpcomingDisplayLabel)
                                .addGap(12, 12, 12)
                                .addGroup(paymentUpcomingPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(paymentUpcomingDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(paymentUpcomingScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                0, Short.MAX_VALUE))
                                .addContainerGap()));

        paymentTenantDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        paymentTenantDisplayLabel.setText("Payments from Tenants");

        paymentTenantScrollPane.setBackground(new java.awt.Color(242, 242, 242));

        paymentTenantListTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Payment ID", "Tenant Name", "Amount", "House ID", "Date of Payment", "Type"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        paymentTenantScrollPane.setViewportView(paymentTenantListTable);

        paymentTenantIdDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        paymentTenantIdDisplayLabel.setText("ID ");

        paymentTenantAmountDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        paymentTenantAmountDisplayLabel.setText("Amount");

        paymentTenantDueDateDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        paymentTenantDueDateDisplayLabel.setText("Due Date");

        paymentTenantHouseDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        paymentTenantHouseDisplayLabel.setText("House ID");

        paymentTenantNameDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        paymentTenantNameDisplayLabel.setText("Tenant Name");

        paymentTenantDescriptionDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        paymentTenantDescriptionDisplayLabel.setText("Description");

        paymentTenantIdTextField.setPreferredSize(new java.awt.Dimension(250, 30));

        paymentTenantAmountTextField.setPreferredSize(new java.awt.Dimension(250, 30));

        paymentTenantNameTextField.setPreferredSize(new java.awt.Dimension(250, 30));

        paymentTenantHouseTextField.setPreferredSize(new java.awt.Dimension(250, 30));

        paymentTenantDescriptionTextArea.setColumns(20);
        paymentTenantDescriptionTextArea.setRows(5);
        paymentTenantDescriptionTextArea.setPreferredSize(new java.awt.Dimension(250, 50));
        paymentTenantDescriptionScrollPane.setViewportView(paymentTenantDescriptionTextArea);

        paymentTenantTeantDetailsButton.setBackground(new java.awt.Color(248, 255, 255));
        paymentTenantTeantDetailsButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        paymentTenantTeantDetailsButton.setText("More Details");
        paymentTenantTeantDetailsButton.setEnabled(false);
        paymentTenantTeantDetailsButton.setPreferredSize(new java.awt.Dimension(150, 30));

        paymentTenantHouseDetailsButton.setBackground(new java.awt.Color(248, 255, 255));
        paymentTenantHouseDetailsButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        paymentTenantHouseDetailsButton.setText("More Details");
        paymentTenantHouseDetailsButton.setEnabled(false);
        paymentTenantHouseDetailsButton.setPreferredSize(new java.awt.Dimension(150, 30));

        paymentTenantDueDateChooser.setPreferredSize(new java.awt.Dimension(250, 30));

        javax.swing.GroupLayout paymentUpcomingDetailsPanel1Layout = new javax.swing.GroupLayout(
                paymentUpcomingDetailsPanel1);
        paymentUpcomingDetailsPanel1.setLayout(paymentUpcomingDetailsPanel1Layout);
        paymentUpcomingDetailsPanel1Layout.setHorizontalGroup(
                paymentUpcomingDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paymentUpcomingDetailsPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(paymentUpcomingDetailsPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(paymentTenantDescriptionDisplayLabel)
                                        .addComponent(paymentTenantIdDisplayLabel)
                                        .addComponent(paymentTenantAmountDisplayLabel)
                                        .addComponent(paymentTenantDueDateDisplayLabel)
                                        .addComponent(paymentTenantNameDisplayLabel)
                                        .addComponent(paymentTenantHouseDisplayLabel))
                                .addGap(18, 18, 18)
                                .addGroup(paymentUpcomingDetailsPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(paymentUpcomingDetailsPanel1Layout.createSequentialGroup()
                                                .addGroup(paymentUpcomingDetailsPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(paymentTenantHouseTextField,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(paymentTenantNameTextField,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(paymentTenantAmountTextField,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(paymentTenantIdTextField,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(paymentTenantDescriptionScrollPane))
                                                .addGap(18, 18, 18)
                                                .addGroup(paymentUpcomingDetailsPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(paymentTenantTeantDetailsButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(paymentTenantHouseDetailsButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(paymentTenantDueDateChooser,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(26, Short.MAX_VALUE)));
        paymentUpcomingDetailsPanel1Layout.setVerticalGroup(
                paymentUpcomingDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paymentUpcomingDetailsPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(paymentUpcomingDetailsPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(paymentTenantIdDisplayLabel)
                                        .addComponent(paymentTenantIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paymentUpcomingDetailsPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(paymentTenantAmountDisplayLabel)
                                        .addComponent(paymentTenantAmountTextField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paymentUpcomingDetailsPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(paymentTenantDueDateChooser,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paymentTenantDueDateDisplayLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paymentUpcomingDetailsPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(paymentTenantNameTextField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paymentTenantNameDisplayLabel)
                                        .addComponent(paymentTenantTeantDetailsButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paymentUpcomingDetailsPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(paymentTenantHouseTextField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paymentTenantHouseDisplayLabel)
                                        .addComponent(paymentTenantHouseDetailsButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(paymentUpcomingDetailsPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(paymentUpcomingDetailsPanel1Layout.createSequentialGroup()
                                                .addComponent(paymentTenantDescriptionDisplayLabel)
                                                .addGap(39, 39, 39))
                                        .addComponent(paymentTenantDescriptionScrollPane,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap(20, Short.MAX_VALUE)));

        javax.swing.GroupLayout paymentTenantPanelLayout = new javax.swing.GroupLayout(paymentTenantPanel);
        paymentTenantPanel.setLayout(paymentTenantPanelLayout);
        paymentTenantPanelLayout.setHorizontalGroup(
                paymentTenantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paymentTenantPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(paymentTenantPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(paymentTenantPanelLayout.createSequentialGroup()
                                                .addComponent(paymentTenantScrollPane,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 700,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(paymentUpcomingDetailsPanel1,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(paymentTenantDisplayLabel))
                                .addContainerGap()));
        paymentTenantPanelLayout.setVerticalGroup(
                paymentTenantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paymentTenantPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(paymentTenantDisplayLabel)
                                .addGap(12, 12, 12)
                                .addGroup(paymentTenantPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(paymentUpcomingDetailsPanel1,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(paymentTenantScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                0, Short.MAX_VALUE))
                                .addContainerGap()));

        javax.swing.GroupLayout paymentsPanelLayout = new javax.swing.GroupLayout(paymentsPanel);
        paymentsPanel.setLayout(paymentsPanelLayout);
        paymentsPanelLayout.setHorizontalGroup(
                paymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paymentsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(paymentsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(paymentUpcomingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1333,
                                                Short.MAX_VALUE)
                                        .addComponent(paymentTenantPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        paymentsPanelLayout.setVerticalGroup(
                paymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paymentsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(paymentUpcomingPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(paymentTenantPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        landlordDashboard.add(paymentsPanel, "card6");

        errorNewDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        errorNewDisplayLabel.setText("New");

        errorDetailsDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        errorDetailsDisplayLabel.setText("Details");

        errorDetailsLogidDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        errorDetailsLogidDisplayLabel.setText("Log ID");

        errorDetialsDateDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        errorDetialsDateDisplayLabel.setText("Date Issued");

        errorDescriptionDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        errorDescriptionDisplayLabel.setText("Description");

        errorDetailsLogidTextField.setPreferredSize(new java.awt.Dimension(200, 30));

        errorDetailsDateTextField.setPreferredSize(new java.awt.Dimension(200, 30));

        errorDescriptionScrollPane.setPreferredSize(new java.awt.Dimension(200, 90));

        errorDescriptionTextArea.setColumns(20);
        errorDescriptionTextArea.setRows(5);
        errorDescriptionScrollPane.setViewportView(errorDescriptionTextArea);

        errorTenantDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        errorTenantDisplayLabel.setText("Tenant");

        errorTenantTextField.setPreferredSize(new java.awt.Dimension(200, 30));

        errorTenantInfoButton.setBackground(new java.awt.Color(239, 255, 255));
        errorTenantInfoButton.setText("More Info");
        errorTenantInfoButton.setEnabled(false);
        errorTenantInfoButton.setPreferredSize(new java.awt.Dimension(150, 30));

        errorUpdateStatusButton.setBackground(new java.awt.Color(239, 255, 255));
        errorUpdateStatusButton.setText("Update Status");
        errorUpdateStatusButton.setPreferredSize(new java.awt.Dimension(150, 30));

        errorDetialsStatusDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        errorDetialsStatusDisplayLabel.setText("Status");

        errorDetailsStatusComboBox.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Send", "Received", "In Review", "Rectified" }));
        errorDetailsStatusComboBox.setPreferredSize(new java.awt.Dimension(200, 30));

        errorDetailsHouseDiplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        errorDetailsHouseDiplayLabel.setText("House ID");

        errorDetailsHouseidTextField.setPreferredSize(new java.awt.Dimension(200, 30));

        errorDetailsHouseInfoButton.setBackground(new java.awt.Color(239, 255, 255));
        errorDetailsHouseInfoButton.setText("More Info");
        errorDetailsHouseInfoButton.setEnabled(false);
        errorDetailsHouseInfoButton.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout errorDetailsPanelLayout = new javax.swing.GroupLayout(errorDetailsPanel);
        errorDetailsPanel.setLayout(errorDetailsPanelLayout);
        errorDetailsPanelLayout.setHorizontalGroup(
                errorDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(errorDetailsPanelLayout.createSequentialGroup()
                                .addGroup(errorDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(errorDetailsPanelLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(errorDetailsPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(errorDetialsDateDisplayLabel)
                                                        .addComponent(errorDetailsLogidDisplayLabel)
                                                        .addComponent(errorTenantDisplayLabel)
                                                        .addComponent(errorDetialsStatusDisplayLabel)
                                                        .addComponent(errorDetailsHouseDiplayLabel)
                                                        .addComponent(errorDescriptionDisplayLabel))
                                                .addGap(36, 36, 36))
                                        .addGroup(errorDetailsPanelLayout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(errorDetailsDisplayLabel,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 118,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(errorDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(errorDetailsPanelLayout.createSequentialGroup()
                                                .addComponent(errorDetailsStatusComboBox,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(errorUpdateStatusButton,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(errorDetailsLogidTextField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(errorDetailsDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(errorDetailsPanelLayout.createSequentialGroup()
                                                .addGroup(errorDetailsPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(errorDescriptionScrollPane,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(errorTenantTextField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(errorDetailsHouseidTextField,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(errorDetailsPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(errorDetailsHouseInfoButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(errorTenantInfoButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(126, 126, Short.MAX_VALUE)));
        errorDetailsPanelLayout.setVerticalGroup(
                errorDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(errorDetailsPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(errorDetailsDisplayLabel)
                                .addGap(18, 18, 18)
                                .addGroup(errorDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(errorDetailsLogidDisplayLabel)
                                        .addComponent(errorDetailsLogidTextField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(errorDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(errorDetailsDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(errorDetialsDateDisplayLabel))
                                .addGap(17, 17, 17)
                                .addGroup(errorDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(errorDetialsStatusDisplayLabel)
                                        .addComponent(errorUpdateStatusButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(errorDetailsStatusComboBox,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(errorDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(errorTenantTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(errorTenantDisplayLabel)
                                        .addComponent(errorTenantInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(errorDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(errorDetailsHouseidTextField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(errorDetailsHouseDiplayLabel)
                                        .addComponent(errorDetailsHouseInfoButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(errorDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(errorDescriptionScrollPane,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 111,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(errorDescriptionDisplayLabel))));

        errorReviewListTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Log ID", "Tenant Name", "Date Issued", "House ID"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        errorReviewListScrollPane.setViewportView(errorReviewListTable);

        errorReviewDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        errorReviewDisplayLabel.setText("In Review");

        errorNewListTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Log ID", "Tenant Name", "Date Issued", "House ID"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        errorNewListScrollPane.setViewportView(errorNewListTable);

        previousErrorListTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "Tenant Name", "Date Issued", "House ID"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        previousErrorListScrollPane.setViewportView(previousErrorListTable);

        previousErrorDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        previousErrorDisplayLabel.setText("Previous");

        previousErrorSearchTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        previousErrorSearchTextField.setText("Search");
        previousErrorSearchTextField.setPreferredSize(new java.awt.Dimension(200, 40));

        javax.swing.GroupLayout errorPanelLayout = new javax.swing.GroupLayout(errorPanel);
        errorPanel.setLayout(errorPanelLayout);
        errorPanelLayout.setHorizontalGroup(
                errorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(errorPanelLayout.createSequentialGroup()
                                .addGroup(errorPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(errorPanelLayout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(errorNewListScrollPane,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 634,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(errorPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(errorPanelLayout.createSequentialGroup()
                                                                .addGap(60, 60, 60)
                                                                .addGroup(errorPanelLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(previousErrorDisplayLabel)
                                                                        .addComponent(previousErrorSearchTextField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 436, Short.MAX_VALUE))
                                                        .addGroup(errorPanelLayout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(previousErrorListScrollPane,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE, 678,
                                                                        Short.MAX_VALUE))))
                                        .addGroup(errorPanelLayout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(errorNewDisplayLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(errorPanelLayout.createSequentialGroup()
                                                .addGroup(errorPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(errorPanelLayout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addComponent(errorReviewListScrollPane,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 634,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(errorPanelLayout.createSequentialGroup()
                                                                .addGap(60, 60, 60)
                                                                .addComponent(errorReviewDisplayLabel)))
                                                .addGap(18, 18, 18)
                                                .addComponent(errorDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(42, 42, 42)));
        errorPanelLayout.setVerticalGroup(
                errorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(errorPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(
                                        errorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(errorNewDisplayLabel)
                                                .addComponent(previousErrorDisplayLabel))
                                .addGap(18, 18, 18)
                                .addGroup(errorPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(errorPanelLayout.createSequentialGroup()
                                                .addComponent(previousErrorSearchTextField,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(previousErrorListScrollPane,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 279,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(errorPanelLayout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(errorNewListScrollPane,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 325,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(errorPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(errorPanelLayout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(errorReviewDisplayLabel)
                                                .addGap(8, 8, 8)
                                                .addComponent(errorReviewListScrollPane,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addGroup(errorPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(errorDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap()));

        landlordDashboard.add(errorPanel, "card3");

        othersLayeredPane.setLayout(new java.awt.CardLayout());

        

        othersGreetingPanel.setBackground(new java.awt.Color(255, 204, 204));
        othersGreetingPanel
                .setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 153)));
        othersGreetingPanel.setPreferredSize(new java.awt.Dimension(286, 120));

        othersHomeGreetingDisplaylabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        othersHomeGreetingDisplaylabel.setText("Other Options...");

        javax.swing.GroupLayout othersGreetingPanelLayout = new javax.swing.GroupLayout(othersGreetingPanel);
        othersGreetingPanel.setLayout(othersGreetingPanelLayout);
        othersGreetingPanelLayout.setHorizontalGroup(
                othersGreetingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(othersGreetingPanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(othersHomeGreetingDisplaylabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        othersGreetingPanelLayout.setVerticalGroup(
                othersGreetingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                othersGreetingPanelLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(othersHomeGreetingDisplaylabel)
                                        .addGap(30, 30, 30)));

        othersContractPanel.setBackground(new java.awt.Color(204, 204, 204));
        othersContractPanel
                .setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        othersContractPanel.setPreferredSize(new java.awt.Dimension(250, 150));

        othersContractDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        othersContractDisplayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        othersContractDisplayLabel.setText("Contracts");

        othersContractNewButton.setBackground(new java.awt.Color(239, 255, 255));
        othersContractNewButton.setText("New Contract");
        othersContractNewButton.setBorder(null);
        othersContractNewButton.setPreferredSize(new java.awt.Dimension(200, 40));

        othersContractViewButton.setBackground(new java.awt.Color(239, 255, 255));
        othersContractViewButton.setText("View All");
        othersContractViewButton.setBorder(null);
        othersContractViewButton.setPreferredSize(new java.awt.Dimension(200, 40));

        javax.swing.GroupLayout othersContractPanelLayout = new javax.swing.GroupLayout(othersContractPanel);
        othersContractPanel.setLayout(othersContractPanelLayout);
        othersContractPanelLayout.setHorizontalGroup(
                othersContractPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(othersContractPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(othersContractPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(othersContractViewButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(othersContractNewButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                othersContractPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(othersContractDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap()));
        othersContractPanelLayout.setVerticalGroup(
                othersContractPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(othersContractPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(othersContractDisplayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15,
                                        Short.MAX_VALUE)
                                .addComponent(othersContractViewButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(othersContractNewButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)));

        othersLogTenantPanel.setBackground(new java.awt.Color(204, 204, 204));
        othersLogTenantPanel
                .setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        othersLogTenantPanel.setPreferredSize(new java.awt.Dimension(250, 150));

        othersLogTenantDisplayLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        othersLogTenantDisplayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        othersLogTenantDisplayLabel.setText("Tenant Request");

        othersLogTenantViewButton.setBackground(new java.awt.Color(239, 255, 255));
        othersLogTenantViewButton.setText("View All");
        othersLogTenantViewButton.setBorder(null);
        othersLogTenantViewButton.setPreferredSize(new java.awt.Dimension(200, 40));

        javax.swing.GroupLayout othersLogTenantPanelLayout = new javax.swing.GroupLayout(othersLogTenantPanel);
        othersLogTenantPanel.setLayout(othersLogTenantPanelLayout);
        othersLogTenantPanelLayout.setHorizontalGroup(
                othersLogTenantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                othersLogTenantPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(othersLogTenantDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())
                        .addGroup(othersLogTenantPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(othersLogTenantViewButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)));
        othersLogTenantPanelLayout.setVerticalGroup(
                othersLogTenantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(othersLogTenantPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(othersLogTenantDisplayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61,
                                        Short.MAX_VALUE)
                                .addComponent(othersLogTenantViewButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)));

        othersLogTenantPanel1.setBackground(new java.awt.Color(204, 204, 204));
        othersLogTenantPanel1
                .setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        othersLogTenantPanel1.setPreferredSize(new java.awt.Dimension(250, 150));

        othersLogTenantDisplayLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        othersLogTenantDisplayLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        othersLogTenantDisplayLabel1.setText("Inspection");

        othersScheduleInspectionButton.setBackground(new java.awt.Color(239, 255, 255));
        othersScheduleInspectionButton.setText("Schedule");
        othersScheduleInspectionButton.setBorder(null);
        othersScheduleInspectionButton.setPreferredSize(new java.awt.Dimension(200, 40));

        javax.swing.GroupLayout othersLogTenantPanel1Layout = new javax.swing.GroupLayout(othersLogTenantPanel1);
        othersLogTenantPanel1.setLayout(othersLogTenantPanel1Layout);
        othersLogTenantPanel1Layout.setHorizontalGroup(
                othersLogTenantPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, othersLogTenantPanel1Layout
                                .createSequentialGroup()
                                .addContainerGap()
                                .addComponent(othersLogTenantDisplayLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(othersLogTenantPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(othersScheduleInspectionButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)));
        othersLogTenantPanel1Layout.setVerticalGroup(
                othersLogTenantPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(othersLogTenantPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(othersLogTenantDisplayLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61,
                                        Short.MAX_VALUE)
                                .addComponent(othersScheduleInspectionButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)));

        othersLogTenantPanel2.setBackground(new java.awt.Color(204, 204, 204));
        othersLogTenantPanel2
                .setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        othersLogTenantPanel2.setPreferredSize(new java.awt.Dimension(250, 150));

        othersLogTenantDisplayLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        othersLogTenantDisplayLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        othersLogTenantDisplayLabel2.setText("Reset Tenant Password");

        othersTenantResetPasswordButton.setBackground(new java.awt.Color(239, 255, 255));
        othersTenantResetPasswordButton.setText("Reset");
        othersTenantResetPasswordButton.setBorder(null);
        othersTenantResetPasswordButton.setPreferredSize(new java.awt.Dimension(200, 40));

        javax.swing.GroupLayout othersLogTenantPanel2Layout = new javax.swing.GroupLayout(othersLogTenantPanel2);
        othersLogTenantPanel2.setLayout(othersLogTenantPanel2Layout);
        othersLogTenantPanel2Layout.setHorizontalGroup(
                othersLogTenantPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, othersLogTenantPanel2Layout
                                .createSequentialGroup()
                                .addContainerGap()
                                .addComponent(othersLogTenantDisplayLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(othersLogTenantPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(othersTenantResetPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)));
        othersLogTenantPanel2Layout.setVerticalGroup(
                othersLogTenantPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(othersLogTenantPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(othersLogTenantDisplayLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61,
                                        Short.MAX_VALUE)
                                .addComponent(othersTenantResetPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)));

        javax.swing.GroupLayout othersDashboardPanelLayout = new javax.swing.GroupLayout(othersDashboardPanel);
        othersDashboardPanel.setLayout(othersDashboardPanelLayout);
        othersDashboardPanelLayout.setHorizontalGroup(
                othersDashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(othersDashboardPanelLayout.createSequentialGroup()
                                .addContainerGap(76, Short.MAX_VALUE)
                                .addComponent(othersContractPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(othersLogTenantPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(othersLogTenantPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(othersLogTenantPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(191, Short.MAX_VALUE)));
        othersDashboardPanelLayout.setVerticalGroup(
                othersDashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(othersDashboardPanelLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(othersDashboardPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(othersLogTenantPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(othersLogTenantPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(othersLogTenantPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(othersContractPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(524, Short.MAX_VALUE)));

        javax.swing.GroupLayout othersHomePanelLayout = new javax.swing.GroupLayout(othersHomePanel);
        othersHomePanel.setLayout(othersHomePanelLayout);
        othersHomePanelLayout.setHorizontalGroup(
                othersHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(othersGreetingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1345, Short.MAX_VALUE)
                        .addComponent(othersDashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        othersHomePanelLayout.setVerticalGroup(
                othersHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(othersHomePanelLayout.createSequentialGroup()
                                .addComponent(othersGreetingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 106,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(othersDashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));

        othersLayeredPane.add(othersHomePanel, "card2");

        javax.swing.GroupLayout othersViewContractPanelLayout = new javax.swing.GroupLayout(othersViewContractPanel);
        othersViewContractPanel.setLayout(othersViewContractPanelLayout);
        othersViewContractPanelLayout.setHorizontalGroup(
                othersViewContractPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1387, Short.MAX_VALUE));
        othersViewContractPanelLayout.setVerticalGroup(
                othersViewContractPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 832, Short.MAX_VALUE));

        othersLayeredPane.add(othersViewContractPanel, "card3");

        javax.swing.GroupLayout othersIssueContractPanelLayout = new javax.swing.GroupLayout(othersIssueContractPanel);
        othersIssueContractPanel.setLayout(othersIssueContractPanelLayout);
        othersIssueContractPanelLayout.setHorizontalGroup(
                othersIssueContractPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1387, Short.MAX_VALUE));
        othersIssueContractPanelLayout.setVerticalGroup(
                othersIssueContractPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 832, Short.MAX_VALUE));

        othersLayeredPane.add(othersIssueContractPanel, "card3");

        maintenanceRequestSearchTextField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N

        maintenanceRequestListTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "Tenant Name", "Date Issued", "House ID", "Status"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        previousErrorListScrollPane1.setViewportView(maintenanceRequestListTable);

        maintenanceRequestListScrollPane.setViewportView(previousErrorListScrollPane1);

        javax.swing.GroupLayout otherMaintenanceRequestPanelLayout = new javax.swing.GroupLayout(
                otherMaintenanceRequestPanel);
        otherMaintenanceRequestPanel.setLayout(otherMaintenanceRequestPanelLayout);
        otherMaintenanceRequestPanelLayout.setHorizontalGroup(
                otherMaintenanceRequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(otherMaintenanceRequestPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(maintenanceRequestSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(otherMaintenanceRequestPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(maintenanceRequestListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        1329, Short.MAX_VALUE)
                                .addContainerGap()));
        otherMaintenanceRequestPanelLayout.setVerticalGroup(
                otherMaintenanceRequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, otherMaintenanceRequestPanelLayout
                                .createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(maintenanceRequestSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(maintenanceRequestListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        281, Short.MAX_VALUE)
                                .addContainerGap()));

        maintenanceDescriptionLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        maintenanceDescriptionLabel.setText("Description");

        maintenanceRequestieDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        maintenanceRequestieDisplayLabel.setText("Requested By");

        maintenanceHouseDisplayLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        maintenanceHouseDisplayLabel.setText("House");

        maintenanceDescriptionTextArea.setColumns(20);
        maintenanceDescriptionTextArea.setRows(5);
        maintenanceRequestScrollPane.setViewportView(maintenanceDescriptionTextArea);

        javax.swing.GroupLayout otherMaintenanceDetailsPanelLayout = new javax.swing.GroupLayout(
                otherMaintenanceDetailsPanel);
        otherMaintenanceDetailsPanel.setLayout(otherMaintenanceDetailsPanelLayout);
        otherMaintenanceDetailsPanelLayout.setHorizontalGroup(
                otherMaintenanceDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(otherMaintenanceDetailsPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(otherMaintenanceDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(maintenanceRequestScrollPane,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 665,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(otherMaintenanceDetailsPanelLayout.createSequentialGroup()
                                                .addGroup(otherMaintenanceDetailsPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                otherMaintenanceDetailsPanelLayout
                                                                        .createSequentialGroup())
                                                        .addGroup(otherMaintenanceDetailsPanelLayout
                                                                .createSequentialGroup()
                                                                .addGroup(otherMaintenanceDetailsPanelLayout
                                                                        .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(maintenanceRequestieDisplayLabel)
                                                                        .addComponent(maintenanceHouseDisplayLabel))
                                                                .addGap(29, 29, 29)))
                                                .addGroup(otherMaintenanceDetailsPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(maintenanceRequestieTextField)
                                                        .addComponent(maintenanceHouseTextField, 0, 304,
                                                                Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(otherMaintenanceDetailsPanelLayout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addComponent(maintenanceDescriptionLabel))
                                .addContainerGap(30, Short.MAX_VALUE)));
        otherMaintenanceDetailsPanelLayout.setVerticalGroup(
                otherMaintenanceDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(otherMaintenanceDetailsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(maintenanceDescriptionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maintenanceRequestScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 163,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(otherMaintenanceDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(otherMaintenanceDetailsPanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(maintenanceRequestieDisplayLabel,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(maintenanceRequestieTextField,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(otherMaintenanceDetailsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                                        .addComponent(maintenanceHouseTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(maintenanceHouseDisplayLabel,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)

                                .addContainerGap(12, Short.MAX_VALUE)));

        javax.swing.GroupLayout othersMaintenancePanelLayout = new javax.swing.GroupLayout(othersMaintenancePanel);
        othersMaintenancePanel.setLayout(othersMaintenancePanelLayout);
        othersMaintenancePanelLayout.setHorizontalGroup(
                othersMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(othersMaintenancePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(otherMaintenanceRequestPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(othersMaintenancePanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(otherMaintenanceDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        othersMaintenancePanelLayout.setVerticalGroup(
                othersMaintenancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(othersMaintenancePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(otherMaintenanceRequestPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(otherMaintenanceDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        othersLayeredPane.add(othersMaintenancePanel, "card5");

        tenantResetTenantIdTextField.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tenantResetTenantIdTextField.setPreferredSize(new java.awt.Dimension(250, 50));


        sendNewTenantPassword.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        sendNewTenantPassword.setText("Send Password");
        sendNewTenantPassword.setPreferredSize(new java.awt.Dimension(250, 50));

        javax.swing.GroupLayout tenantResetPasswordPanelLayout = new javax.swing.GroupLayout(tenantResetPasswordPanel);
        tenantResetPasswordPanel.setLayout(tenantResetPasswordPanelLayout);
        tenantResetPasswordPanelLayout.setHorizontalGroup(
            tenantResetPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tenantResetPasswordPanelLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(tenantResetPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tenantResetTenantIdTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(sendNewTenantPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(908, Short.MAX_VALUE))
        );
        tenantResetPasswordPanelLayout.setVerticalGroup(
            tenantResetPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tenantResetPasswordPanelLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(tenantResetTenantIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(sendNewTenantPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(538, Short.MAX_VALUE))
        );

        othersLayeredPane.add(tenantResetPasswordPanel, "card6");

        landlordDashboard.add(othersLayeredPane, "card7");

        javax.swing.GroupLayout landlordPanelLayout = new javax.swing.GroupLayout(landlordPanel);
        landlordPanel.setLayout(landlordPanelLayout);
        landlordPanelLayout.setHorizontalGroup(
                landlordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(landlordPanelLayout.createSequentialGroup()
                                .addGroup(landlordPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(landlordPanelLayout.createSequentialGroup()
                                                .addComponent(menubarPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(landlordDashboard, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        0, Short.MAX_VALUE))
                                        .addGroup(landlordPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap()));
        landlordPanelLayout.setVerticalGroup(
                landlordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(landlordPanelLayout.createSequentialGroup()
                                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(landlordPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(menubarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 810,
                                                Short.MAX_VALUE)
                                        .addComponent(landlordDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                Short.MAX_VALUE))
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(landlordPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(landlordPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_dashboardButtonActionPerformed
        // TODO add your handling code here:
        // landlordDashboard.setSelectedIndex(0);
        landlordDashboard.removeAll();
        landlordDashboard.add(homeScrollPanel);
        landlordDashboard.repaint();
        landlordDashboard.revalidate();

    }// GEN-LAST:event_dashboardButtonActionPerformed

    public void housesButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_housesButtonActionPerformed
        // TODO add your handling code here:
        landlordDashboard.removeAll();
        landlordDashboard.add(housesPanel);
        landlordDashboard.repaint();
        landlordDashboard.revalidate();
    }// GEN-LAST:event_housesButtonActionPerformed

    public void tenantsButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tenantsButtonActionPerformed

        landlordDashboard.removeAll();
        landlordDashboard.add(tenantsPanel);
        landlordDashboard.repaint();
        landlordDashboard.revalidate();
    }// GEN-LAST:event_tenantsButtonActionPerformed

    public void maintenanceButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_maintenanceButtonActionPerformed
        // TODO add your handling code here:
        landlordDashboard.removeAll();
        landlordDashboard.add(errorPanel);
        landlordDashboard.repaint();
        landlordDashboard.revalidate();
    }// GEN-LAST:event_maintenanceButtonActionPerformed


    public void paymentButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_paymentButtonActionPerformed
        // TODO add your handling code here:
        landlordDashboard.removeAll();
        landlordDashboard.add(paymentsPanel);
        landlordDashboard.repaint();
        landlordDashboard.revalidate();
    }// GEN-LAST:event_paymentButtonActionPerformed

    public void otherButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_otherButtonActionPerformed
        // TODO add your handling code here:
        landlordDashboard.removeAll();
        landlordDashboard.add(othersHomePanel);
        landlordDashboard.repaint();
        landlordDashboard.revalidate();
    }// GEN-LAST:event_otherButtonActionPerformed

    public void signoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public void firstnameTextFieldActionPerformed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_firstnameTextFieldActionPerformed
        checkNameInput(this.firstnameTextField.getText(), this.firstnameTextField);
    }// GEN-LAST:event_firstnameTextFieldActionPerformed

    public void lastnameTextFieldActionPerformed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_lastnameTextFieldActionPerformed
        checkNameInput(this.lastnameTextField.getText(), this.lastnameTextField);
    }// GEN-LAST:event_lastnameTextFieldActionPerformed

    public void emailTextFieldActionPerformed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_emailTextFieldActionPerformed
        checkEmailInput(this.emailTextField.getText(), this.emailTextField);
    }// GEN-LAST:event_emailTextFieldActionPerformed

    public void phoneNumberTextFieldActionPerformed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_phoneNumberTextFieldActionPerformed
        checkNumberInput(this.phoneNumberTextField.getText(), this.phoneNumberTextField);
    }// GEN-LAST:event_phoneNumberTextFieldActionPerformed

    public void tenantSearchTextFieldActionPerformed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_tenantSearchTextFieldActionPerformed
        Sorting.sortTable(this.tenantListTable, this.getTenantSearchTextField().getText());
    }// GEN-LAST:event_tenantSearchTextFieldActionPerformed

    public void houseClearFormButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_houseClearFormButtonActionPerformed
        clearHouseForm();
    }// GEN-LAST:event_houseClearFormButtonActionPerformed

    public void houseSearchTextFieldActionPerformed(java.awt.event.KeyEvent evt) {
        Sorting.sortTable(this.houseListTable, this.houseSearchTextField.getText());
    }

    public House houseAddButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_houseAddButtonActionPerformed
        String houseType = this.getHouseTypeComboBox();
        String houseAddress = this.getHouseAddressTextField();
        String houseDescription = this.getHouseDescriptionTextArea();
        String houseRent = this.getHouseRentPriceTextField();

        House houseObj;
        if (houseAddress != null && houseDescription != null && houseRent != null) {
            houseObj = new House(houseType, houseAddress, houseDescription, Integer.valueOf(houseRent));
        } else {
            houseObj = null;
        }
        return houseObj;

    }// GEN-LAST:event_houseAddButtonActionPerformed

    public House houseUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_houseUpdateButtonActionPerformed
        String houseId = this.getHouseidTextField();
        String houseType = this.getHouseTypeComboBox();
        String houseAddress = this.getHouseAddressTextField();
        String houseDescription = this.getHouseDescriptionTextArea();
        String houseRent = this.getHouseRentPriceTextField();

        House houseObj;

        if (houseAddress != null && houseDescription != null && houseRent != null) {
            houseObj = new House(houseId, houseType, houseAddress, houseDescription, Integer.valueOf(houseRent));
        } else {
            houseObj = null;
        }
        return houseObj;

    }// GEN-LAST:event_houseUpdateButtonActionPerformed

    public String houseDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_houseDeleteButtonActionPerformed
        String houseToDelete = this.getHouseidTextField();
        return houseToDelete;
    }// GEN-LAST:event_houseDeleteButtonActionPerformed

    public void tenantClearFormButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tenantClearFormButtonActionPerformed
        clearTenantForm();
    }// GEN-LAST:event_tenantClearFormButtonActionPerformed

    public Tenant tenantAddButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tenantAddButtonActionPerformed
        String firstName = this.getFirstNameTextField();
        String lastName = this.getLastNameTextField();
        String eMail = this.getemailTextField();
        String phn = this.getPhoneNumberTextField();
        String gender = this.getGenderComboBox();
        LocalDate dob = this.getDobDateChooser();
        String houseId = (String) this.getTenantHouseIdComboBox().getSelectedItem();

        Tenant tenantModelObj;
        if (firstName != null && lastName != null && eMail != null && phn != null && dob != null) {
            tenantModelObj = new Tenant(firstName, lastName, eMail, phn, gender, dob, houseId);
        } else {
            tenantModelObj = null;
        }
        return tenantModelObj;

    }// GEN-LAST:event_tenantAddButtonActionPerformed

    public Tenant tenantUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tenantUpdateButtonActionPerformed
        String extTenantId = this.getTenantidTextField();
        String firstName = this.getFirstNameTextField();
        String lastName = this.getLastNameTextField();
        String eMail = this.getemailTextField();
        String phn = this.getPhoneNumberTextField();
        String gender = this.getGenderComboBox();
        LocalDate dob = this.getDobDateChooser();
        String houseId = (String) this.getTenantHouseIdComboBox().getSelectedItem();

        Tenant tenantModelObj;
        if (firstName != null && lastName != null && eMail != null && phn != null && dob != null) {
            tenantModelObj = new Tenant(firstName, lastName, eMail, phn, extTenantId, gender, dob, houseId);
        } else {
            tenantModelObj = null;
        }

        return tenantModelObj;
    }// GEN-LAST:event_tenantUpdateButtonActionPerformed

    public String tenantDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tenantDeleteButtonActionPerformed
        String tenantToDelete = this.getTenantidTextField();
        return tenantToDelete;
    }// GEN-LAST:event_tenantDeleteButtonActionPerformed

    public void othersContractViewButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_othersContractViewButtonActionPerformed
        // TODO add your handling code here:
        landlordDashboard.removeAll();
        landlordDashboard.add(othersViewContractPanel);
        landlordDashboard.repaint();
        landlordDashboard.revalidate();
    }// GEN-LAST:event_othersContractViewButtonActionPerformed

    public void othersContractNewButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_othersContractNewButtonActionPerformed
        // TODO add your handling code here:
        landlordDashboard.removeAll();
        landlordDashboard.add(othersIssueContractPanel);
        landlordDashboard.repaint();
        landlordDashboard.revalidate();
    }// GEN-LAST:event_othersContractNewButtonActionPerformed

    public void othersLogTenantViewButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_othersLogTenantViewButtonActionPerformed
        // TODO add your handling code here:
        landlordDashboard.removeAll();
        landlordDashboard.add(othersMaintenancePanel);
        landlordDashboard.repaint();
        landlordDashboard.revalidate();
    }// GEN-LAST:event_othersLogTenantViewButtonActionPerformed

    public void othersTenantResetPasswordButtonActionPerformed(java.awt.event.ActionEvent evt){
        landlordDashboard.removeAll();
        landlordDashboard.add(tenantResetPasswordPanel);
        landlordDashboard.repaint();
        landlordDashboard.revalidate();
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountLabel;
    private javax.swing.JLabel cashDisplayLabel;
    private javax.swing.JLabel cashReceivedLabel;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JLabel descriptionDisplayLabel;
    private com.toedter.calendar.JDateChooser dobDateChooser;
    private javax.swing.JLabel dobDisplayLabel;
    private javax.swing.JLabel emailDisplayLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel errorDescriptionDisplayLabel;
    private javax.swing.JScrollPane errorDescriptionScrollPane;
    private javax.swing.JTextArea errorDescriptionTextArea;
    private javax.swing.JTextField errorDetailsDateTextField;
    private javax.swing.JLabel errorDetailsDisplayLabel;
    private javax.swing.JLabel errorDetailsHouseDiplayLabel;
    private javax.swing.JButton errorDetailsHouseInfoButton;
    private javax.swing.JTextField errorDetailsHouseidTextField;
    private javax.swing.JLabel errorDetailsLogidDisplayLabel;
    private javax.swing.JTextField errorDetailsLogidTextField;
    private javax.swing.JPanel errorDetailsPanel;
    private javax.swing.JComboBox<String> errorDetailsStatusComboBox;
    private javax.swing.JLabel errorDetialsDateDisplayLabel;
    private javax.swing.JLabel errorDetialsStatusDisplayLabel;
    private javax.swing.JLabel errorNewDisplayLabel;
    private javax.swing.JScrollPane errorNewListScrollPane;
    private javax.swing.JTable errorNewListTable;
    private javax.swing.JPanel errorPanel;
    private javax.swing.JLabel errorReviewDisplayLabel;
    private javax.swing.JScrollPane errorReviewListScrollPane;
    private javax.swing.JTable errorReviewListTable;
    private javax.swing.JLabel errorTenantDisplayLabel;
    private javax.swing.JButton errorTenantInfoButton;
    private javax.swing.JTextField errorTenantTextField;
    private javax.swing.JButton errorUpdateStatusButton;
    private javax.swing.JLabel firstnameDisplayLabel;
    private javax.swing.JTextField firstnameTextField;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderDisplayLabel;
    private javax.swing.JPanel greetingPanel;
    private javax.swing.JPanel home;
    private javax.swing.JPanel homeCashPanel;
    private javax.swing.JPanel homeHousePanel;
    private javax.swing.JPanel homeMaintenancePanel;
    private javax.swing.JButton homeHouseButton;
    private javax.swing.JPanel homePaymentPanel;
    private javax.swing.JScrollPane homeScrollPanel;
    private javax.swing.JButton homeTenantDetailsButton;
    private javax.swing.JPanel homeTenantPanel;
    private javax.swing.JButton homeTotalCashButton;
    private javax.swing.JButton homeUpcomingPaymentButton;
    private javax.swing.JButton houseAddButton;
    private javax.swing.JLabel houseAddressDisplayLabel;
    private javax.swing.JTextField houseAddressTextField;
    private javax.swing.JPanel houseButtonPanel;
    private javax.swing.JButton houseClearFormButton;
    private javax.swing.JLabel houseCountLabel;
    private javax.swing.JButton houseDeleteButton;
    private javax.swing.JTextArea houseDescriptionTextArea;
    private javax.swing.JLabel houseDisplayLabel;
    private javax.swing.JPanel houseFormPanel;
    private javax.swing.JLabel houseIconLabel;
    private javax.swing.JPanel houseListPanel;
    private javax.swing.JScrollPane houseListScrollPane;
    private javax.swing.JTable houseListTable;
    private javax.swing.JLabel houseRentDisplayLabel;
    private javax.swing.JTextField houseRentTextField;
    private javax.swing.JTextField houseSearchTextField;
    private javax.swing.JComboBox<String> houseTypeComboBox;
    private javax.swing.JLabel houseTypeDisplayLabel;
    private javax.swing.JButton houseUpdateButton;
    private javax.swing.JLabel houseidDisplayLabel;
    private javax.swing.JTextField houseidTextField;
    private javax.swing.JButton housesButton;
    private javax.swing.JPanel housesPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLayeredPane landlordDashboard;
    private javax.swing.JLabel landlordName;
    private javax.swing.JPanel landlordPanel;
    private javax.swing.JLabel lastnameDisplayLabel;
    private javax.swing.JTextField lastnameTextField;
    private javax.swing.JButton maintenanceButton;
    private javax.swing.JLabel maintenanceDescriptionLabel;
    private javax.swing.JTextArea maintenanceDescriptionTextArea;
    private javax.swing.JLabel maintenanceHouseDisplayLabel;
    private javax.swing.JTextField maintenanceHouseTextField;
    private javax.swing.JLabel maintenanceIconLabel;
    private javax.swing.JLabel maintenanceIconLabel1;
    private javax.swing.JScrollPane maintenanceRequestListScrollPane;
    private javax.swing.JScrollPane maintenanceRequestScrollPane;
    private javax.swing.JTextField maintenanceRequestSearchTextField;
    private javax.swing.JLabel maintenanceRequestieDisplayLabel;
    private javax.swing.JTextField maintenanceRequestieTextField;
    private javax.swing.JPanel menubarPanel;
    private javax.swing.JLabel moneyIconLabel;
    private javax.swing.JLabel newMaintenanceRequestCount;
    private javax.swing.JLabel newMaintenanceRequestCount1;
    private javax.swing.JButton otherButton;
    private javax.swing.JPanel otherMaintenanceDetailsPanel;
    private javax.swing.JPanel otherMaintenanceRequestPanel;
    private javax.swing.JLabel othersContractDisplayLabel;
    private javax.swing.JButton othersContractNewButton;
    private javax.swing.JPanel othersContractPanel;
    private javax.swing.JButton othersContractViewButton;
    private javax.swing.JPanel othersDashboardPanel;
    private javax.swing.JPanel othersGreetingPanel;
    private javax.swing.JLabel othersHomeGreetingDisplaylabel;
    private javax.swing.JPanel othersHomePanel;
    private javax.swing.JPanel othersIssueContractPanel;
    private javax.swing.JLayeredPane othersLayeredPane;
    private javax.swing.JLabel othersLogTenantDisplayLabel;
    private javax.swing.JLabel othersLogTenantDisplayLabel1;
    private javax.swing.JLabel othersLogTenantDisplayLabel2;
    private javax.swing.JPanel othersLogTenantPanel;
    private javax.swing.JPanel othersLogTenantPanel1;
    private javax.swing.JPanel othersLogTenantPanel2;
    private javax.swing.JButton othersLogTenantViewButton;
    private javax.swing.JPanel othersMaintenancePanel;
    private javax.swing.JButton othersScheduleInspectionButton;
    private javax.swing.JButton othersTenantResetPasswordButton;
    private javax.swing.JPanel othersViewContractPanel;
    private javax.swing.JButton paymentButton;
    private javax.swing.JLabel paymentTenantAmountDisplayLabel;
    private javax.swing.JTextField paymentTenantAmountTextField;
    private javax.swing.JLabel paymentTenantDescriptionDisplayLabel;
    private javax.swing.JScrollPane paymentTenantDescriptionScrollPane;
    private javax.swing.JTextArea paymentTenantDescriptionTextArea;
    private javax.swing.JLabel paymentTenantDisplayLabel;
    private com.toedter.calendar.JDateChooser paymentTenantDueDateChooser;
    private javax.swing.JLabel paymentTenantDueDateDisplayLabel;
    private javax.swing.JButton paymentTenantHouseDetailsButton;
    private javax.swing.JLabel paymentTenantHouseDisplayLabel;
    private javax.swing.JTextField paymentTenantHouseTextField;
    private javax.swing.JLabel paymentTenantIdDisplayLabel;
    private javax.swing.JTextField paymentTenantIdTextField;
    private javax.swing.JTable paymentTenantListTable;
    private javax.swing.JLabel paymentTenantNameDisplayLabel;
    private javax.swing.JTextField paymentTenantNameTextField;
    private javax.swing.JPanel paymentTenantPanel;
    private javax.swing.JScrollPane paymentTenantScrollPane;
    private javax.swing.JButton paymentTenantTeantDetailsButton;
    private javax.swing.JLabel paymentUpcomingAmountDisplayLabel;
    private javax.swing.JTextField paymentUpcomingAmountTextField;
    private javax.swing.JLabel paymentUpcomingDescriptionLabel;
    private javax.swing.JTextArea paymentUpcomingDescriptionTextArea;
    private javax.swing.JPanel paymentUpcomingDetailsPanel;
    private javax.swing.JPanel paymentUpcomingDetailsPanel1;
    private javax.swing.JLabel paymentUpcomingDisplayLabel;
    private com.toedter.calendar.JDateChooser paymentUpcomingDueDateChooser;
    private javax.swing.JLabel paymentUpcomingDueDateDisplayLabel;
    private javax.swing.JButton paymentUpcomingHouseAddButton;
    private javax.swing.JButton paymentUpcomingHouseDetailsButton;
    private javax.swing.JLabel paymentUpcomingHouseDisplayLabel;
    private javax.swing.JTextField paymentUpcomingHouseTextField;
    private javax.swing.JLabel paymentUpcomingIdDisplayLabel;
    private javax.swing.JTextField paymentUpcomingIdTextField;
    private javax.swing.JTable paymentUpcomingListTable;
    private javax.swing.JPanel paymentUpcomingPanel;
    private javax.swing.JScrollPane paymentUpcomingScrollPane;
    private javax.swing.JComboBox<String> paymentUpcomingStatusComboBox;
    private javax.swing.JLabel paymentUpcomingStatusDisplayLabel;
    private javax.swing.JLabel paymentUpcomingTypeDisplayLabel;
    private javax.swing.JTextField paymentUpcomingTypeTextField;
    private javax.swing.JButton paymentUpcomingUpdateDetailsButton;
    private javax.swing.JPanel paymentsPanel;
    private javax.swing.JLabel peopleIconLabel;
    private javax.swing.JLabel phoneNumberDisplayLabel;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JLabel previousErrorDisplayLabel;
    private javax.swing.JScrollPane previousErrorListScrollPane;
    private javax.swing.JScrollPane previousErrorListScrollPane1;
    private javax.swing.JTable previousErrorListTable;
    private javax.swing.JTable maintenanceRequestListTable;
    private javax.swing.JTextField previousErrorSearchTextField;
    private javax.swing.JLabel requestDisplayLabel;
    private javax.swing.JLabel requestDisplayLabel1;
    private javax.swing.JButton seeNewRequestsButton;
    private javax.swing.JButton signoutButton;
    private javax.swing.JButton tenantAddButton;
    private javax.swing.JPanel tenantButtonPanel;
    private javax.swing.JButton tenantClearFormButton;
    private javax.swing.JLabel tenantCountLabel;
    private javax.swing.JButton tenantDeleteButton;
    private javax.swing.JLabel tenantDisplayLabel;
    private javax.swing.JPanel tenantFormPanel;
    private javax.swing.JComboBox<String> tenantHouseIdComboBox;
    private javax.swing.JLabel tenantHouseIdDisplayLabel;
    private javax.swing.JPanel tenantListPanel;
    private javax.swing.JScrollPane tenantListScrollPane;
    private javax.swing.JTable tenantListTable;
    private javax.swing.JPanel tenantResetPasswordPanel;
    private javax.swing.JTextField tenantResetTenantIdTextField;
    private javax.swing.JTextField tenantSearchTextField;
    private javax.swing.JButton tenantUpdateButton;
    private javax.swing.JLabel tenantidDisplayLabel;
    private javax.swing.JTextField tenantidTextField;
    private javax.swing.JButton tenantsButton;
    private javax.swing.JPanel tenantsPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JButton sendNewTenantPassword;
    // End of variables declaration//GEN-END:variables

    /**
     * getter and setter
     * 
     * 
     */

    public javax.swing.JTextField getTenantSearchTextField() {
        return tenantSearchTextField;
    }

    public javax.swing.JButton getErrorDetailsHouseInfoButton() {
        return errorDetailsHouseInfoButton;
    }

    public void setErrorDetailsHouseInfoButton(javax.swing.JButton errorDetailsHouseInfoButton) {
        this.errorDetailsHouseInfoButton = errorDetailsHouseInfoButton;
    }

    public javax.swing.JComboBox<String> getErrorDetailsStatusComboBox() {
        return errorDetailsStatusComboBox;
    }

    public void setErrorDetailsStatusComboBox(javax.swing.JComboBox<String> errorDetailsStatusComboBox) {
        this.errorDetailsStatusComboBox = errorDetailsStatusComboBox;
    }

    public javax.swing.JButton getErrorTenantInfoButton() {
        return errorTenantInfoButton;
    }

    public void setErrorTenantInfoButton(javax.swing.JButton errorTenantInfoButton) {
        this.errorTenantInfoButton = errorTenantInfoButton;
    }

    public javax.swing.JButton getErrorUpdateStatusButton() {
        return errorUpdateStatusButton;
    }

    public void setErrorUpdateStatusButton(javax.swing.JButton errorUpdateStatusButton) {
        this.errorUpdateStatusButton = errorUpdateStatusButton;
    }

    public void setTenantSearchTextField(javax.swing.JTextField tenantSearchTextField) {
        this.tenantSearchTextField = tenantSearchTextField;
    }

    public JComboBox<String> getTenantHouseIdComboBox() {
        return tenantHouseIdComboBox;
    }

    public void setTenantHouseIdComboBox(JComboBox<String> tenantHouseIdComboBox) {
        this.tenantHouseIdComboBox = tenantHouseIdComboBox;
    }

    public void setTenantHouseIdComboBoxText(String text) {
        this.tenantHouseIdComboBox.setSelectedItem(text);
    }

    public void setTenantidTextField(String value) {
        this.tenantidTextField.setText(value);
    }

    public String getTenantidTextField() {
        return this.tenantidTextField.getText();
    }

    public void setFirstnameTextField(String value) {
        this.firstnameTextField.setText(value);
    }

    public String getFirstNameTextField() {
        if (!this.firstnameTextField.getText().isEmpty()) {
            return this.firstnameTextField.getText();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter first name!", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;

        }
    }

    public void setLastnameTextField(String value) {
        this.lastnameTextField.setText(value);
    }

    public String getLastNameTextField() {
        if (!this.lastnameTextField.getText().isEmpty()) {
            return this.lastnameTextField.getText();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter last name!", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public void setEmailTextField(String value) {
        this.emailTextField.setText(value);
    }

    public String getemailTextField() {// needs further validation
        if (!this.emailTextField.getText().isEmpty()) {
            return this.emailTextField.getText();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter email!", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public void setDobDateChooser(Date date) {
        if (date != null) {
            this.dobDateChooser.setDate(date);
        } else {
            this.dobDateChooser.setCalendar(null);
        }

    }

    public LocalDate getDobDateChooser() {
        if (this.dobDateChooser.getDate() != null) {

            // reference
            // https://stackoverflow.com/questions/6262310/display-java-util-date-in-a-specific-format

            LocalDate date = this.dobDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return date;
        }
        JOptionPane.showMessageDialog(this, "Please select date!", "Warning", JOptionPane.WARNING_MESSAGE);
        return null;

    }

    public void setPhoneNumberTextField(String value) {
        this.phoneNumberTextField.setText(value);
    }

    public String getPhoneNumberTextField() {
        if (!this.phoneNumberTextField.getText().isEmpty()) {
            return this.phoneNumberTextField.getText();
        }
        JOptionPane.showMessageDialog(this, "Please enter phone Number!", "Warning", JOptionPane.WARNING_MESSAGE);
        return null;
    }

    public void setGenderComboBox(String value) {
        if (value.equals("Male")) {
            genderComboBox.setSelectedIndex(0);
        } else if (value.equals("Female")) {
            genderComboBox.setSelectedIndex(1);
        }
    }

    public String getGenderComboBox() {
        if ((String) this.genderComboBox.getSelectedItem() == "Male") {
            return "Male";

        } else if ((String) this.genderComboBox.getSelectedItem() == "Female") {
            return "Female";

        } else {
            JOptionPane.showMessageDialog(this, "Please select a value within the option!", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public javax.swing.JTextField getMaintenanceHouseTextField() {
        return maintenanceHouseTextField;
    }

    public void setMaintenanceHouseTextField(javax.swing.JTextField maintenanceHouseTextField) {
        this.maintenanceHouseTextField = maintenanceHouseTextField;
    }

    public javax.swing.JTextField getMaintenanceRequestieTextField() {
        return maintenanceRequestieTextField;
    }

    public void setMaintenanceRequestieTextField(javax.swing.JTextField maintenanceRequestieTextField) {
        this.maintenanceRequestieTextField = maintenanceRequestieTextField;
    }

    public javax.swing.JTextArea getMaintenanceDescriptionTextArea() {
        return maintenanceDescriptionTextArea;
    }

    public void setMaintenanceDescriptionTextArea(javax.swing.JTextArea maintenanceDescriptionTextArea) {
        this.maintenanceDescriptionTextArea = maintenanceDescriptionTextArea;
    }

    public void clearOtherMaintenanceForm() {
        maintenanceDescriptionTextArea.setText("");
        maintenanceRequestieTextField.setText("");
        maintenanceHouseTextField.setText("");
    }

    public void populateOtherMaintenaceForm(ResultSet result) throws SQLException{
        while(result.next()){
           maintenanceDescriptionTextArea.setText(result.getString("description"));
        maintenanceRequestieTextField.setText(result.getString("tenantId"));
        maintenanceHouseTextField.setText(result.getString("houseId")); 
        }
        
    }

    public void clearTenantForm() {
        setFirstnameTextField("");
        setLastnameTextField("");
        setEmailTextField("");
        setPhoneNumberTextField("");
        setDobDateChooser(null);
        setGenderComboBox("Male");
        setTenantidTextField("");
    }

    public void setHouseidTextField(String value) {
        this.houseidTextField.setText(value);
    }

    public String getHouseidTextField() {
        return houseidTextField.getText();
    }

    public void setHouseTypeComboBox(String value) {
        this.houseTypeComboBox.setSelectedItem(value);
    }

    public String getHouseTypeComboBox() {
        return (String) houseTypeComboBox.getSelectedItem();
    }

    public void setHouseDescriptionTextArea(String value) {
        this.houseDescriptionTextArea.setText(value);
    }

    public String getHouseDescriptionTextArea() {
        if (!houseDescriptionTextArea.getText().isEmpty()) {
            return houseDescriptionTextArea.getText();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter Description!", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public javax.swing.JTable getPreviousErrorListTable() {
        return previousErrorListTable;
    }

    public void setPreviousErrorListTable(javax.swing.JTable previousErrorListTable) {
        this.previousErrorListTable = previousErrorListTable;
    }

    public void setHouseAddressTextField(String value) {
        this.houseAddressTextField.setText(value);
    }

    public String getHouseAddressTextField() {
        if (!houseAddressTextField.getText().isEmpty()) {
            return houseAddressTextField.getText();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter an Address", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public void setHouseRentPriceTextField(String value) {
        this.houseRentTextField.setText(value);
    }

    public String getHouseRentPriceTextField() {
        if (!houseRentTextField.getText().isEmpty()) {
            return houseRentTextField.getText();
        } else {
            JOptionPane.showMessageDialog(this, "Please a Rent price!", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    

    public javax.swing.JButton getOthersTenantResetPasswordButton() {
        return othersTenantResetPasswordButton;
    }


    public void setOthersTenantResetPasswordButton(javax.swing.JButton othersTenantResetPasswordButton) {
        this.othersTenantResetPasswordButton = othersTenantResetPasswordButton;
    }


    public javax.swing.JTextField getPreviousErrorSearchTextField() {
        return previousErrorSearchTextField;
    }

    public void setPreviousErrorSearchTextField(javax.swing.JTextField previousErrorSearchTextField) {
        this.previousErrorSearchTextField = previousErrorSearchTextField;
    }

    public void clearHouseForm() {
        setHouseidTextField("");
        setHouseTypeComboBox("");
        setHouseAddressTextField("");
        setHouseRentPriceTextField("");
        setHouseDescriptionTextArea("");
    }

    public void populateHouseForm(House house) {
        setHouseidTextField(String.valueOf(house.getHouseId()));
        setHouseTypeComboBox(house.getHouseType());
        setHouseAddressTextField(house.getHouseAddress());
        setHouseRentPriceTextField(String.valueOf(house.getHouseRentPrice()));
        setHouseDescriptionTextArea(house.getHouseDescription());
    }

    public void populateTenantForm(Tenant tenant) {
        setTenantidTextField(tenant.getTenantId());
        setGenderComboBox(tenant.getGender());
        setFirstnameTextField(tenant.getFirstName());
        setLastnameTextField(tenant.getSurName());
        setEmailTextField(tenant.geteMail());
        setPhoneNumberTextField(tenant.getPhoneNumber());
        setDobDateChooser(tenant.getDateOfBirth(tenant.getDob()));
        setTenantHouseIdComboBoxText(tenant.getHouseId());

    }

    public void populateErrorDetailsForm(ResultSet result) throws SQLException {
        while (result.next()) {
            this.getErrorDetailsLogidTextField().setText(result.getString("logId"));
            this.getErrorDetailsDateTextField().setText(result.getString("dateOfIssue"));
            this.getErrorDetailsStatusComboBox().setSelectedItem(result.getString("Status"));
            this.getErrorTenantTextField().setText(result.getString("tenantId"));
            this.getErrorDetailsHouseidTextField().setText(result.getString("houseId"));
            this.getErrorDescriptionTextArea().setText(result.getString("description"));
        }

    }

    public void clearErrorDetailsForm() {
        this.getErrorDetailsLogidTextField().setText("");
        this.getErrorDetailsDateTextField().setText("");
        this.getErrorDetailsStatusComboBox().setSelectedItem("Received");
        this.getErrorTenantTextField().setText("");
        this.getErrorDetailsHouseidTextField().setText("");
        this.getErrorDescriptionTextArea().setText("");
    }

    // count label getters and setters
    public JLabel getHouseCountLabel() {
        return houseCountLabel;
    }

    public void setHouseCountLabel(JLabel houseCountLabel) {
        this.houseCountLabel = houseCountLabel;
    }

    public JLabel getTenantCountLabel() {
        return tenantCountLabel;
    }

    public void setTenantCountLabel(JLabel tenantCountLabel) {
        this.tenantCountLabel = tenantCountLabel;
    }

    public javax.swing.JTextField getHouseSearchTextField() {
        return houseSearchTextField;
    }

    public void setHouseSearchTextField(javax.swing.JTextField houseSearchTextField) {
        this.houseSearchTextField = houseSearchTextField;
    }

    public javax.swing.JTextField getMaintenanceRequestSearchTextField() {
        return maintenanceRequestSearchTextField;
    }

    public void setMaintenanceRequestSearchTextField(javax.swing.JTextField maintenanceRequestSearchTextField) {
        this.maintenanceRequestSearchTextField = maintenanceRequestSearchTextField;
    }

    public javax.swing.JTable getErrorReviewListTable() {
        return errorReviewListTable;
    }

    public void setErrorReviewListTable(javax.swing.JTable errorReviewListTable) {
        this.errorReviewListTable = errorReviewListTable;
    }

    public javax.swing.JTable getErrorNewListTable() {
        return errorNewListTable;
    }

    public void setErrorNewListTable(javax.swing.JTable errorNewListTable) {
        this.errorNewListTable = errorNewListTable;
    }

    public javax.swing.JLabel getNewMaintenanceRequestCount() {
        return newMaintenanceRequestCount;
    }

    public void setNewMaintenanceRequestCount(javax.swing.JLabel newMaintenanceRequestCount) {
        this.newMaintenanceRequestCount = newMaintenanceRequestCount;
    }

    public javax.swing.JTextArea getErrorDescriptionTextArea() {
        return errorDescriptionTextArea;
    }

    public void setErrorDescriptionTextArea(javax.swing.JTextArea errorDescriptionTextArea) {
        this.errorDescriptionTextArea = errorDescriptionTextArea;
    }

    public javax.swing.JTextField getErrorTenantTextField() {
        return errorTenantTextField;
    }

    public void setErrorTenantTextField(javax.swing.JTextField errorTenantTextField) {
        this.errorTenantTextField = errorTenantTextField;
    }

    public javax.swing.JTextField getErrorDetailsDateTextField() {
        return errorDetailsDateTextField;
    }

    public void setErrorDetailsDateTextField(javax.swing.JTextField errorDetailsDateTextField) {
        this.errorDetailsDateTextField = errorDetailsDateTextField;
    }

    public javax.swing.JTextField getErrorDetailsHouseidTextField() {
        return errorDetailsHouseidTextField;
    }

    public void setErrorDetailsHouseidTextField(javax.swing.JTextField errorDetailsHouseidTextField) {
        this.errorDetailsHouseidTextField = errorDetailsHouseidTextField;
    }

    public javax.swing.JTextField getErrorDetailsLogidTextField() {
        return errorDetailsLogidTextField;
    }

    public void setErrorDetailsLogidTextField(javax.swing.JTextField errorDetailsLogidTextField) {
        this.errorDetailsLogidTextField = errorDetailsLogidTextField;
    }
    

    public javax.swing.JButton getSendNewTenantPassword() {
        return sendNewTenantPassword;
    }


    public void setSendNewTenantPassword(javax.swing.JButton sendNewTenantPassword) {
        this.sendNewTenantPassword = sendNewTenantPassword;
    }


    // table functions
    public JTable getHouseListTable() {
        return houseListTable;
    }

    public JTable getTenantListTable() {
        return tenantListTable;
    }

    public void setTenantListTable(javax.swing.JTable tenantListTable) {
        this.tenantListTable = tenantListTable;
    }

    // validation functions

    public javax.swing.JTable getMaintenanceRequestListTable() {
        return maintenanceRequestListTable;
    }

    public void setMaintenanceRequestListTable(javax.swing.JTable maintenanceRequestListTable) {
        this.maintenanceRequestListTable = maintenanceRequestListTable;
    }

    /**
     * reference: https://www.javatpoint.com/post/java-character-isalphabetic-method
     * 
     * @param input     String takes the value entered
     * @param component JComponent the component where the change is to showed
     */
    public void checkNameInput(String input, JTextField component) {
        char[] codepoint = input.toCharArray();

        for (char i : codepoint) {
            if (!Character.isAlphabetic(i)) {
                component.setBackground(new Color(255, 128, 128));
            } else if (input.isEmpty()) {
                component.setBackground(new Color(255, 255, 255));
            } else {
                component.setBackground(new Color(255, 255, 255));
            }
        }

    }

    /**
     * reference
     * https://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method
     * 
     * @param input     String takes the value entered
     * @param component JTextField the component where the change is to showed
     */
    public void checkEmailInput(String input, JTextField component) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(input);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        if (!result) {
            component.setBackground(new Color(255, 128, 128));
        } else {
            component.setBackground(new Color(255, 255, 255));
        }
    }

    public void checkNumberInput(String input, JTextField component) {
        char[] codepoint = input.toCharArray();
        for (char i : codepoint) {
            if (!Character.isDigit(i)) {
                component.setBackground(new Color(255, 128, 128));
            } else {
                component.setBackground(new Color(255, 255, 255));
            }
        }
    }

}
