
package jpl.pk;


import java.awt.Color;
import javax.swing.*;
import java.sql.*;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        UIManage();
    }
    public void UIManage(){
//        try{
//        UIManager UI = new UIManager();
//         UIManager.setLookAndFeel("com.swing.plaf.windows.WindowsLookAndFeel");
//        }
//        catch(Exception e){
//            System.out.println("UI exception");
//        }
//        UI.put("OptionPane.background", Color.white);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userNameTxt = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        passTxt = new javax.swing.JPasswordField();
        registerBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        loginBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userNameTxt.setBorder(null);
        jPanel1.add(userNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 195, -1));

        usernameLabel.setText("username");
        jPanel1.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        passLabel.setText("password");
        jPanel1.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        passTxt.setBorder(null);
        jPanel1.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 195, -1));

        registerBtn.setForeground(new java.awt.Color(51, 51, 51));
        registerBtn.setText("Create account");
        registerBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 255, 255), 1, true));
        registerBtn.setBorderPainted(false);
        registerBtn.setContentAreaFilled(false);
        registerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerBtn.setFocusPainted(false);
        registerBtn.setFocusable(false);
        registerBtn.setMaximumSize(new java.awt.Dimension(32767, 32767));
        registerBtn.setMinimumSize(new java.awt.Dimension(32767, 32767));
        registerBtn.setRequestFocusEnabled(false);
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });
        jPanel1.add(registerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 100, 34));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 190, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 190, -1));

        loginBtn1.setBackground(new java.awt.Color(153, 153, 255));
        loginBtn1.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn1.setText("Login");
        loginBtn1.setBorder(null);
        loginBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn1.setFocusable(false);
        loginBtn1.setRequestFocusEnabled(false);
        loginBtn1.setRolloverEnabled(false);
        loginBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(loginBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 100, 34));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtn1ActionPerformed
        // TODO add your handling code here:
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","2000");  
            //here mydb is database name, root is username and 2000 is password  
            
            
            String username = userNameTxt.getText();
            String password = new String(passTxt.getPassword());
//            JOptionPane.showMessageDialog(null, "Login started");
            
            Statement stmt=con.createStatement(); 
            String query = "SELECT * FROM userInfo WHERE username ='"+username+"' and password='"+password+"'";
            ResultSet rs=stmt.executeQuery(query);  

            if(username.equals(""))
                JOptionPane.showMessageDialog(this, "Please enter a valid username");
            else if(rs.next() ){
                dispose();
                Home homepage = new Home(username);
                homepage.show();
                JOptionPane.showMessageDialog(this, "Login Successful!");
    
            }
            else{
                JOptionPane.showMessageDialog(this, "Username or Password Invalid !");
                userNameTxt.setText("");
                passTxt.setText("");
            }
            con.close();
    }
    catch(Exception e){ System.out.println(e.getMessage());}

    }//GEN-LAST:event_loginBtn1ActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // TODO add your handling code here:
        Register newRegistration = new Register();
        newRegistration.show();              

    }//GEN-LAST:event_registerBtnActionPerformed

   
    public static void main(String args[]) {
 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
                        
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loginBtn1;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField userNameTxt;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
