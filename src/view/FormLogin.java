/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author anandaanugrah
 */
public class FormLogin extends javax.swing.JDialog {
    public static String tipe = "";

    private controller.LoginController loginController =
            new controller.LoginController();

    private String userLogin = "";

    public String getUserLogin() {
        return userLogin;
    }
    
    private javax.swing.JTextField userIdTextField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton loginButton;
    
    public FormLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
        public FormLogin() {
        super((java.awt.Frame) null, true);
        initComponents();
    }
    
    private void initComponents() {
        userIdTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        
        setTitle("Login");
                addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(
                    java.awt.event.WindowEvent evt) {
                userLogin = "";
            }
        });
        setDefaultCloseOperation(
            javax.swing.WindowConstants.DISPOSE_ON_CLOSE
        );        
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
    
    private void loginButtonActionPerformed(
            java.awt.event.ActionEvent evt) {

        if (loginController.validasi(
                userIdTextField, passwordField)) {

            userLogin = userIdTextField.getText();

            javax.swing.JOptionPane.showMessageDialog(
                    this, "Login berhasil sebagai " + tipe);

            userIdTextField.setText("");
            passwordField.setText("");

            this.dispose();
            new view.FormUtama().setVisible(true);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new view.FormUtama().setVisible(true);
        });
    }
}