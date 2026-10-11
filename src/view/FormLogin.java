/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author anandaanugrah
 */
public class FormLogin extends javax.swing.JFrame {
    
    public static String tipe = "";
    private javax.swing.JTextField userIdTextField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton loginButton;
    
    public FormLogin() {
        initComponents();
    }
    
    private void initComponents() {
        userIdTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        
        setTitle("Login");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        loginButton.setText("Login");
        loginButton.addActionListener(evt -> loginButtonActionPerformed(evt));
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(userIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginButton)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        
        pack();
    }
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        controller.LoginController loginController = new controller.LoginController();
        if (loginController.validasi(userIdTextField, passwordField)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Login berhasil sebagai " + tipe);
            this.dispose();
            new FormUtama().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new FormLogin().setVisible(true));
    }
}