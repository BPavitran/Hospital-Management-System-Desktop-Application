/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pavi
 */
public class AdminViewWard extends javax.swing.JFrame {
    String id;
    String previous="";
    String ward_selected="";
    /**
     * Creates new form AdminViewWard
     */
    public AdminViewWard() {
        initComponents();
    }
    
    public AdminViewWard(String ID) {
        initComponents();
        
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int)tk.getScreenSize().getWidth();
        int ysize=(int)tk.getScreenSize().getHeight();
        this.setSize(xsize,ysize);
        
        jWardTable.getTableHeader().setFont(new Font("Raleway SemiBold", Font.PLAIN, 13));
        jWardTable.getTableHeader().setForeground(Color.BLUE);;
        
        id=ID;
        start();
        
        jWardTable.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        
        int row = jWardTable.rowAtPoint(evt.getPoint());
        if(jWardTable.getValueAt(row, 0)!=null){
            previous=jWardTable.getModel().getValueAt(row, 0).toString();
            ward_selected=jWardTable.getModel().getValueAt(row, 1).toString();
        }
        
        if(previous.equals("Normal")){
            normal(evt);
        }else{
            luxury(evt);
        }       
        }
    });
    }
    
    public void normal(java.awt.event.MouseEvent evt){
        if (evt.getClickCount() == 2 && jWardTable.getSelectedRow() != -1) {
            String[] buttons = { "Update", "Delete","Cancel" };
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
            
            JLabel label = new JLabel("Choose Ward Type");
            panel.add(label);
            JComboBox comboBox = new JComboBox();
            comboBox.addItem("Luxury");
            comboBox.addItem("Normal");
            comboBox.setSelectedItem("Normal");
            
            panel.add(comboBox);
            
            JLabel label2 = new JLabel("Quantity of Beds");
            panel.add(label2);
            JTextField textField = new JTextField();
            panel.add(textField);
            
            comboBox.addItemListener(new ItemListener(){
                @Override
                public void itemStateChanged(ItemEvent e) {
                    String value = comboBox.getSelectedItem().toString();           
            if(value.equals("Luxury")){
                try{
                    Window win = SwingUtilities.getWindowAncestor(panel);
                    win.dispose();
                    luxury(evt);
                }catch(Exception et){       
                }   
            }
                }   
            });
            
        int rc=JOptionPane.showOptionDialog(null,panel,"Update or Delete Ward Details", JOptionPane.PLAIN_MESSAGE,0,null,buttons,buttons[2]);
        if(rc==0){
            String bed_no=textField.getText();
            Connection con = null;
            PreparedStatement st=null;
            con = Link.getConnection();
            
            if(!bed_no.isEmpty()){
                String sql="delete from ward where ward_no=?";
                try{
                    st=con.prepareStatement(sql);
                    st.setString(1,ward_selected);
                    st.executeUpdate();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
                
                int foo = Integer.parseInt(bed_no);
                for(int i=1;i<=foo;i++){
                String sql1="insert into ward(type, ward_no, bed_no, booked) values(?,?,?,?)";
                try{
                    st=con.prepareStatement(sql1);
                    st.setString(1,"Normal");
                    st.setString(2,ward_selected);
                    st.setString(3,String.valueOf(i));
                    st.setString(4,"No");
                    st.executeUpdate(); 
                    }
                catch(Exception e){
                    e.printStackTrace();
                    }
                    }
                JOptionPane.showMessageDialog(null,"Insert Successfully");
                start();
                
            }else{
                JOptionPane.showMessageDialog(null,"Please enter Quantity of Beds", 
                               "WARNING", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        else if(rc==1){
            Connection con = null;
            PreparedStatement st=null;
            con = Link.getConnection();
            
                String sql="delete from ward where ward_no=?";
                try{
                    st=con.prepareStatement(sql);
                    st.setString(1,ward_selected);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Delete Successfully");
                    start();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
        }
        }
    }
    
    public void luxury(java.awt.event.MouseEvent evt){
        if (evt.getClickCount() == 2 && jWardTable.getSelectedRow() != -1) {
            String[] buttons = { "Update", "Delete","Cancel" };
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
            
            JLabel label = new JLabel("Choose Ward Type");
        panel.add(label);
            JComboBox comboBox = new JComboBox();
            comboBox.addItem("Luxury");
            comboBox.addItem("Normal");
            comboBox.setSelectedItem("Luxury");
            panel.add(comboBox);
            
            comboBox.addItemListener(new ItemListener(){
                @Override
                public void itemStateChanged(ItemEvent e) {
                    String value = comboBox.getSelectedItem().toString();           
            if(value.equals("Normal")){
                try{
                    Window win = SwingUtilities.getWindowAncestor(panel);
                    win.dispose();
                    normal(evt);
                }catch(Exception et){  
                    JOptionPane.showMessageDialog(null, et);
                }  
            }
                }
                
            });
            
        int rc=JOptionPane.showOptionDialog(null,panel,"Update or Delete Ward Details", JOptionPane.PLAIN_MESSAGE,0,null,buttons,buttons[2]);
        if(rc==0){
            Connection con = null;
            PreparedStatement st=null;
            con = Link.getConnection();
            
                String sql="delete from ward where ward_no=?";
                try{
                    st=con.prepareStatement(sql);
                    st.setString(1,ward_selected);
                    st.executeUpdate();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
                
                String sql1="insert into ward(type, ward_no, bed_no, booked) values(?,?,?,?)";
                try{
                    st=con.prepareStatement(sql1);
                    st.setString(1,"Luxury");
                    st.setString(2,ward_selected);
                    st.setString(3,"0");
                    st.setString(4,"No");
                    st.executeUpdate();
                    start();
                    JOptionPane.showMessageDialog(null,"Insert Successfully");            
                    }
                catch(Exception e){
                    e.printStackTrace();
                    } 
        }
        else if(rc==1){
            Connection con = null;
            PreparedStatement st=null;
            con = Link.getConnection();
            
                String sql="delete from ward where ward_no=?";
                try{
                    st=con.prepareStatement(sql);
                    st.setString(1,ward_selected);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Delete Successfully");
                    start();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
        }
        }
    }
    
    public void start(){
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select type, ward_no, count(ward_no) as total from ward group by ward_no";
        try{
        st=con.prepareStatement(sql);
        rs=st.executeQuery();
        DefaultTableModel model=(DefaultTableModel)jWardTable.getModel();
        model.setRowCount(0);
        while(rs.next()){
            Object o[]={rs.getString("type"),rs.getString("ward_no"),rs.getString("total")};
            model.addRow(o);
        }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
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

        jClose = new javax.swing.JLabel();
        jLogout = new javax.swing.JLabel();
        jHome = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jWardTable = new javax.swing.JTable();
        jBack = new javax.swing.JLabel();
        jType = new javax.swing.JComboBox<>();
        jMenuBar2 = new javax.swing.JMenuBar();
        jViewProfile = new javax.swing.JMenu();
        jInsertProfile = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/addWard.png"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 140));

        jLabel18.setFont(new java.awt.Font("Raleway Medium", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("View Ward");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 190, 50));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bar.png"))); // NOI18N
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jLabel1.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Ward Type");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, -1, -1));

        jWardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ward Type", "Ward Number", "Quantity of Beds"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jWardTable.setToolTipText("");
        jScrollPane1.setViewportView(jWardTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 640, 250));

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
        getContentPane().add(jBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 640, -1, -1));

        jType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Luxury", "Normal" }));
        jType.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jTypePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        getContentPane().add(jType, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 220, 30));

        jViewProfile.setText("View Ward");
        jViewProfile.setToolTipText("");
        jViewProfile.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jViewProfileMouseMoved(evt);
            }
        });
        jViewProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewProfileMouseClicked(evt);
            }
        });
        jMenuBar2.add(jViewProfile);

        jInsertProfile.setText("Insert Ward");
        jInsertProfile.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jInsertProfileMouseMoved(evt);
            }
        });
        jInsertProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jInsertProfileMouseClicked(evt);
            }
        });
        jMenuBar2.add(jInsertProfile);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jViewProfileMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewProfileMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jViewProfile.setCursor(cur1);
    }//GEN-LAST:event_jViewProfileMouseMoved

    private void jViewProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewProfileMouseClicked
        // TODO add your handling code here:
        AdminViewWard view=new AdminViewWard(id);
        view.setVisible(true);
        dispose();
    }//GEN-LAST:event_jViewProfileMouseClicked

    private void jInsertProfileMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jInsertProfileMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jInsertProfile.setCursor(cur1);
    }//GEN-LAST:event_jInsertProfileMouseMoved

    private void jInsertProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jInsertProfileMouseClicked
        // TODO add your handling code here:
        AdminAddWard insert=new AdminAddWard(id);
        insert.setVisible(true);
        dispose();
    }//GEN-LAST:event_jInsertProfileMouseClicked

    private void jBackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jBack.setCursor(cur1);
    }//GEN-LAST:event_jBackMouseMoved

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        // TODO add your handling code here:
        AdminPanel panel =new AdminPanel(id);
        panel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBackMouseClicked

    private void jTypePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jTypePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String start=(String)jType.getSelectedItem();
        if(!start.equals("Select")){
            Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select type, ward_no, count(ward_no) as total from ward where type like '"+start+"%'";
        try{
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            DefaultTableModel model=(DefaultTableModel)jWardTable.getModel();
            model.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getString("type"),rs.getString("ward_no"),rs.getString("total")};
                model.addRow(o);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        }     
    }//GEN-LAST:event_jTypePopupMenuWillBecomeInvisible

    private void jCloseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCloseMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jClose.setCursor(cur1);
    }//GEN-LAST:event_jCloseMouseMoved

    private void jCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCloseMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jCloseMouseClicked

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
            java.util.logging.Logger.getLogger(AdminViewWard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminViewWard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminViewWard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminViewWard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminViewWard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBack;
    private javax.swing.JLabel jClose;
    private javax.swing.JLabel jHome;
    private javax.swing.JMenu jInsertProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLogout;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jType;
    private javax.swing.JMenu jViewProfile;
    private javax.swing.JTable jWardTable;
    // End of variables declaration//GEN-END:variables
}
