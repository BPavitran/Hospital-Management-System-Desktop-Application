/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
/**
 *
 * @author Pavi
 */
public class AdminProfileView extends javax.swing.JFrame {
    String filename;
    byte[] person_image;
    byte[] imageBytes;
    String id;
    String job;
    /**
     * Creates new form AdminProfileView
     */
    public AdminProfileView() {
        initComponents();
    }
    
    public AdminProfileView(String ID){
        initComponents();
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int)tk.getScreenSize().getWidth();
        int ysize=(int)tk.getScreenSize().getHeight();
        this.setSize(xsize,ysize);
        
        id=ID;
        byte[] imageBytes;
        Image image;
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select * from admin where id=?";
        try{
        st=con.prepareStatement(sql);
        st.setString(1,id);
        rs=st.executeQuery();
            
       while(rs.next()){
           jFirst.setText(rs.getString("name"));
           jLast.setText(rs.getString("surname"));
           jAge.setText(rs.getString("age"));
           jSpecial.setText(rs.getString("job"));
           jGender.setText(rs.getString("gender"));
           jBlood.setText(rs.getString("blood"));
           jAddress.setText(rs.getString("address"));
           jCity.setText(rs.getString("city"));
           jPhone.setText(rs.getString("phone"));
           jNIC.setText(rs.getString("NIC"));
           jEmail.setText(rs.getString("email"));
           jDate.setText(rs.getString("joining"));
           jUsername.setText(rs.getString("username"));
           jPassword.setText(rs.getString("password"));
           
           job=rs.getString("job");
           
           imageBytes=rs.getBytes("photo");
           if(imageBytes!=null && imageBytes.length>0){
           image=getToolkit().createImage(imageBytes);
           ImageIcon icon=new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(jImage.getWidth(),jImage.getHeight(),Image.SCALE_SMOOTH));
           jImage.setIcon(icon);
           }
       }
        }
        catch(Exception e){
           e.printStackTrace(); 
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jUsername = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPhone = new javax.swing.JTextField();
        jLast = new javax.swing.JTextField();
        jBack = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jImage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jAge = new javax.swing.JTextField();
        jBlood = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jGender = new javax.swing.JTextField();
        jDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jNIC = new javax.swing.JTextField();
        jSpecial = new javax.swing.JTextField();
        jEmail = new javax.swing.JTextField();
        jAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jFirst = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jHome = new javax.swing.JLabel();
        jLogout = new javax.swing.JLabel();
        jClose = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jMenuBar2 = new javax.swing.JMenuBar();
        jViewProfile = new javax.swing.JMenu();
        jUpdateProfile = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jUsername.setEditable(false);
        getContentPane().add(jUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 510, 80, -1));

        jLabel16.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 153));
        jLabel16.setText("Password");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 540, -1, -1));

        jPhone.setEditable(false);
        getContentPane().add(jPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 140, 30));

        jLast.setEditable(false);
        getContentPane().add(jLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, 140, 30));

        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Back_1.png"))); // NOI18N
        jBack.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jBackMouseMoved(evt);
            }
        });
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });
        getContentPane().add(jBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 640, -1, -1));

        jLabel9.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("City");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, -1, -1));

        jCity.setEditable(false);
        getContentPane().add(jCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 120, 30));

        jLabel2.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("First Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Last Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, -1, -1));

        jImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 190, 150, 160));

        jLabel5.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Potition");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, -1, -1));

        jLabel13.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 153));
        jLabel13.setText("Joining Date");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, -1, -1));

        jLabel4.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Age");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        jLabel15.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 153));
        jLabel15.setText("Username");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 510, -1, -1));

        jAge.setEditable(false);
        getContentPane().add(jAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 140, 30));

        jBlood.setEditable(false);
        getContentPane().add(jBlood, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 140, 30));

        jLabel11.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("NIC");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, -1, -1));

        jGender.setEditable(false);
        getContentPane().add(jGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 140, 30));

        jDate.setEditable(false);
        getContentPane().add(jDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 520, 140, 30));

        jLabel7.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Blood Groop");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, -1, -1));

        jNIC.setEditable(false);
        getContentPane().add(jNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, 120, 30));

        jSpecial.setEditable(false);
        getContentPane().add(jSpecial, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 140, 30));

        jEmail.setEditable(false);
        getContentPane().add(jEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 120, 30));

        jAddress.setEditable(false);
        getContentPane().add(jAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 280, 30));

        jLabel6.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Gender");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, -1));

        jFirst.setEditable(false);
        getContentPane().add(jFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 140, 30));

        jLabel14.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("Email");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, -1, -1));

        jHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        jHome.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jHomeMouseMoved(evt);
            }
        });
        jHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jHomeMouseClicked(evt);
            }
        });
        getContentPane().add(jHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 60, -1, -1));

        jLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout_icon.png"))); // NOI18N
        jLogout.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLogoutMouseMoved(evt);
            }
        });
        jLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLogoutMouseClicked(evt);
            }
        });
        getContentPane().add(jLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 60, -1, -1));

        jClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        jClose.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jCloseMouseMoved(evt);
            }
        });
        jClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCloseMouseClicked(evt);
            }
        });
        getContentPane().add(jClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 55, -1, -1));

        jLabel8.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Address");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, -1, -1));

        jLabel10.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Phone No.");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile_profile.png"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 150, 140));

        jLabel18.setFont(new java.awt.Font("Raleway Medium", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("View Profile");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 210, 50));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bar.png"))); // NOI18N
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jPassword.setEditable(false);
        getContentPane().add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 540, 80, -1));

        jViewProfile.setText("View Profile");
        jMenuBar2.add(jViewProfile);

        jUpdateProfile.setText("Update Profile");
        jUpdateProfile.setToolTipText("");
        jUpdateProfile.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jUpdateProfileMouseMoved(evt);
            }
        });
        jUpdateProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateProfileMouseClicked(evt);
            }
        });
        jMenuBar2.add(jUpdateProfile);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jUpdateProfileMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateProfileMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jUpdateProfile.setCursor(cur1);
    }//GEN-LAST:event_jUpdateProfileMouseMoved

    private void jUpdateProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateProfileMouseClicked
        // TODO add your handling code here:
        AdminProfileUpdate update = new AdminProfileUpdate(id);
        update.setVisible(true);
        dispose();
    }//GEN-LAST:event_jUpdateProfileMouseClicked

    private void jBackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jBack.setCursor(cur1);
    }//GEN-LAST:event_jBackMouseMoved

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        // TODO add your handling code here:
            AdminPanel panel=new AdminPanel(id);
            panel.setVisible(true);
            dispose();
    }//GEN-LAST:event_jBackMouseClicked

    private void jHomeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jHome.setCursor(cur1);
    }//GEN-LAST:event_jHomeMouseMoved

    private void jHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMouseClicked
        // TODO add your handling code here:
        AdminPanel panel = new AdminPanel(id);
        panel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jHomeMouseClicked

    private void jLogoutMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogoutMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jLogout.setCursor(cur1);
    }//GEN-LAST:event_jLogoutMouseMoved

    private void jLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogoutMouseClicked
        // TODO add your handling code here:
        LoginPanel panel = new LoginPanel();
        panel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLogoutMouseClicked

    private void jCloseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCloseMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jClose.setCursor(cur1);
    }//GEN-LAST:event_jCloseMouseMoved

    private void jCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCloseMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jCloseMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminProfileView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAddress;
    private javax.swing.JTextField jAge;
    private javax.swing.JLabel jBack;
    private javax.swing.JTextField jBlood;
    private javax.swing.JTextField jCity;
    private javax.swing.JLabel jClose;
    private javax.swing.JTextField jDate;
    private javax.swing.JTextField jEmail;
    private javax.swing.JTextField jFirst;
    private javax.swing.JTextField jGender;
    private javax.swing.JLabel jHome;
    private javax.swing.JLabel jImage;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLast;
    private javax.swing.JLabel jLogout;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JTextField jNIC;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jPhone;
    private javax.swing.JTextField jSpecial;
    private javax.swing.JMenu jUpdateProfile;
    private javax.swing.JTextField jUsername;
    private javax.swing.JMenu jViewProfile;
    // End of variables declaration//GEN-END:variables
}
