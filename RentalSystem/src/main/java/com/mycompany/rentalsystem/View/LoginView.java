/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rentalsystem.View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
/**
 *
 * @author Richard
 */
public class LoginView extends JFrame {

    /**
     * Creates new form Login
     */
    public LoginView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * 
     * @return String-username
     */
    public String getUsername() {
        return usernameInput.getText();
    }
    public String getPassword() {
        return String.valueOf(passwordInput.getPassword());
    }
    public String getUsermode() {
        return usermode.getSelectedItem();
    }
    
    public void addLoginButtonListener(ActionListener loginButtonListener){
        loginButton.addActionListener(loginButtonListener);
    }

    public void addforgotPasswordListener(MouseListener forgotPasswordListener){
        forgotPasswordLabel.addMouseListener(forgotPasswordListener);
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        loginLabel = new javax.swing.JLabel();
        usermodePanel = new javax.swing.JPanel();
        usermode = new java.awt.Choice();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        usernamePanel = new javax.swing.JPanel();
        usernameInnerPanel = new javax.swing.JPanel();
        usernameInput = new javax.swing.JFormattedTextField();
        usernameLabel = new javax.swing.JLabel();
        passwordPanel = new javax.swing.JPanel();
        passwordInnerPanel = new javax.swing.JPanel();
        passwordLabel = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        passwordResetPanel = new javax.swing.JPanel();
        forgotPasswordLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();
        companyLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("loginFrame");

        leftPanel.setBackground(new java.awt.Color(255, 204, 204));
        leftPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        titlePanel.setBackground(new java.awt.Color(255, 204, 204));
        titlePanel.setPreferredSize(new java.awt.Dimension(400, 100));

        loginLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        loginLabel.setText("LOGIN");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(loginLabel)
                .addGap(140, 140, 140))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(loginLabel)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        loginLabel.getAccessibleContext().setAccessibleDescription("");

        leftPanel.add(titlePanel);

        usermode.add("Please Select");
        usermode.add("Tenant");
        usermode.add("Landlord");
        usermode.add("Admin");

        usermodePanel.setBackground(new java.awt.Color(255, 204, 204));
        usermodePanel.setPreferredSize(new java.awt.Dimension(200, 30));
        usermodePanel.setLayout(new java.awt.BorderLayout());
        usermodePanel.add(usermode, java.awt.BorderLayout.CENTER);
        usermodePanel.add(filler1, java.awt.BorderLayout.EAST);

        leftPanel.add(usermodePanel);

        usernamePanel.setBackground(new java.awt.Color(255, 204, 204));
        usernamePanel.setPreferredSize(new java.awt.Dimension(400, 100));

        usernameInnerPanel.setBackground(new java.awt.Color(255, 204, 204));
        usernameInnerPanel.setPreferredSize(new java.awt.Dimension(250, 0));
        usernameInnerPanel.setLayout(new java.awt.BorderLayout());

        
        usernameInnerPanel.add(usernameInput, java.awt.BorderLayout.CENTER);

        usernameLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        usernameLabel.setText("Username");
        usernameInnerPanel.add(usernameLabel, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout usernamePanelLayout = new javax.swing.GroupLayout(usernamePanel);
        usernamePanel.setLayout(usernamePanelLayout);
        usernamePanelLayout.setHorizontalGroup(
            usernamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernamePanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(usernameInnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        usernamePanelLayout.setVerticalGroup(
            usernamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernamePanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(usernameInnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        leftPanel.add(usernamePanel);

        passwordPanel.setBackground(new java.awt.Color(255, 204, 204));
        passwordPanel.setPreferredSize(new java.awt.Dimension(400, 100));

        passwordInnerPanel.setBackground(new java.awt.Color(255, 204, 204));
        passwordInnerPanel.setPreferredSize(new java.awt.Dimension(250, 0));
        passwordInnerPanel.setLayout(new java.awt.BorderLayout());

        passwordLabel.setBackground(new java.awt.Color(255, 204, 204));
        passwordLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        passwordLabel.setText("Password");
        passwordInnerPanel.add(passwordLabel, java.awt.BorderLayout.PAGE_START);

        
        passwordInnerPanel.add(passwordInput, java.awt.BorderLayout.CENTER);

        passwordResetPanel.setBackground(new java.awt.Color(255, 204, 204));
        passwordResetPanel.setPreferredSize(new java.awt.Dimension(250, 30));
        passwordResetPanel.setLayout(new java.awt.BorderLayout());

        forgotPasswordLabel.setForeground(new java.awt.Color(255, 0, 0));
        forgotPasswordLabel.setText("Forgot password");
        
        passwordResetPanel.add(forgotPasswordLabel, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
        passwordPanel.setLayout(passwordPanelLayout);
        passwordPanelLayout.setHorizontalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(passwordInnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(passwordResetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        passwordPanelLayout.setVerticalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(passwordInnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordResetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        leftPanel.add(passwordPanel);

        buttonPanel.setBackground(new java.awt.Color(255, 204, 204));
        buttonPanel.setPreferredSize(new java.awt.Dimension(300, 50));

        loginButton.setText("Log In");
        loginButton.setPreferredSize(new java.awt.Dimension(150, 30));
        
        buttonPanel.add(loginButton);

        leftPanel.add(buttonPanel);

        rightPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        companyLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/rentalsystem/images/home.png"))); // NOI18N

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(companyLogo)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(companyLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );

        leftPanel.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

/*     private void usernameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameInputActionPerformed

    private void passwordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordInputActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        //add login checks and input checks here:
    }//GEN-LAST:event_loginButtonActionPerformed

    private void forgotPasswordLabelFocusGained(java.awt.event.FocusEvent evt) {                                                
        // TODO add your handling code here:
    }    
    */                                              

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel companyLogo;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel forgotPasswordLabel;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPanel passwordInnerPanel;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JPanel passwordResetPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel titlePanel;
    private java.awt.Choice usermode;
    private javax.swing.JPanel usermodePanel;
    private javax.swing.JPanel usernameInnerPanel;
    private javax.swing.JFormattedTextField usernameInput;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JPanel usernamePanel;
    // End of variables declaration//GEN-END:variables
}
