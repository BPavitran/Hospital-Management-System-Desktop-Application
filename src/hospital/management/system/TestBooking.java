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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pavi
 */
public class TestBooking extends javax.swing.JFrame {
    String id;
    String value;
    String patient_doctor_id;
    String first;
    /**
     * Creates new form TestBooking
     */
    public TestBooking() {
        initComponents();
    }
    
    public TestBooking(String ID) {
        initComponents();
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int)tk.getScreenSize().getWidth();
        int ysize=(int)tk.getScreenSize().getHeight();
        this.setSize(xsize,ysize);
        id=ID;
        jTestPanel.setVisible(false);
        first = jFirst.getText();
    }
    
    public TestBooking(String ID,String Value) {
        initComponents();
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int)tk.getScreenSize().getWidth();
        int ysize=(int)tk.getScreenSize().getHeight();
        this.setSize(xsize,ysize);
        
        jTestList.getTableHeader().setFont(new Font("Raleway SemiBold", Font.PLAIN, 13));
        jTestList.getTableHeader().setForeground(Color.BLUE);
        
        id=ID;
        value=Value;
        first = jFirst.getText();
        
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select * from patient where id=?";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,value);
            rs=st.executeQuery();

            if(rs.next()){
                jFirst.setText(rs.getString("name"));
                jLast.setText(rs.getString("surname"));
                jAge.setText(rs.getString("age"));
                jGender.setText(rs.getString("gender"));
                jBlood.setText(rs.getString("blood"));
                jAddress.setText(rs.getString("address"));
                jCity.setText(rs.getString("city"));
                jEmail.setText(rs.getString("email"));
                jPhone.setText(rs.getString("phone"));
                jNIC.setText(rs.getString("NIC"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public JFrame getClosed(){
        TestBooking close=this;
        return close;
    }
    
    public JLabel getReturn(){
        return jSearch; 
    }
    
    public JLabel getBack(){
        return jBack; 
    }
    
    public JPanel getVisible(){
        return jTestPanel; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTestPanel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jSelectTest = new javax.swing.JComboBox<>();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jAddTest = new javax.swing.JLabel();
        jDeleteTest = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTestList = new javax.swing.JTable();
        jSearch = new javax.swing.JLabel();
        jBack = new javax.swing.JLabel();
        jDate1 = new javax.swing.JTextField();
        jNIC = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPhone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCity = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jAddress = new javax.swing.JTextField();
        jEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLast = new javax.swing.JTextField();
        jGender = new javax.swing.JTextField();
        jBlood = new javax.swing.JTextField();
        jAge = new javax.swing.JTextField();
        jFirst = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jHome = new javax.swing.JLabel();
        jLogout = new javax.swing.JLabel();
        jClose = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTestPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Raleway SemiBold", 0, 13), new java.awt.Color(11, 159, 207))); // NOI18N
        jTestPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(11, 159, 207));
        jLabel23.setText("New Test");
        jTestPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jSelectTest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jSelectTest.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSelectTestMouseMoved(evt);
            }
        });
        jTestPanel.add(jSelectTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 160, 30));

        jDateChooser.setDateFormatString("yyyy-MM-dd");
        jTestPanel.add(jDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 140, 30));

        jLabel24.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(11, 159, 207));
        jLabel24.setText("Date");
        jTestPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 50, -1));

        jAddTest.setBackground(new java.awt.Color(11, 159, 207));
        jAddTest.setForeground(new java.awt.Color(255, 255, 255));
        jAddTest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jAddTest.setText("Add");
        jAddTest.setOpaque(true);
        jAddTest.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jAddTestMouseMoved(evt);
            }
        });
        jAddTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddTestMouseClicked(evt);
            }
        });
        jTestPanel.add(jAddTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 61, 23));

        jDeleteTest.setBackground(new java.awt.Color(11, 159, 207));
        jDeleteTest.setForeground(new java.awt.Color(255, 255, 255));
        jDeleteTest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDeleteTest.setText("Delete");
        jDeleteTest.setOpaque(true);
        jDeleteTest.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jDeleteTestMouseMoved(evt);
            }
        });
        jDeleteTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDeleteTestMouseClicked(evt);
            }
        });
        jTestPanel.add(jDeleteTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 61, 23));

        jTestList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Test", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTestList);

        jTestPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 270, 90));

        getContentPane().add(jTestPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 470, 170));

        jSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search patient.png"))); // NOI18N
        jSearch.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSearchMouseMoved(evt);
            }
        });
        jSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSearchMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jSearchMousePressed(evt);
            }
        });
        getContentPane().add(jSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

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
        getContentPane().add(jBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, -1, -1));

        jDate1.setEditable(false);
        getContentPane().add(jDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 140, 30));

        jNIC.setEditable(false);
        getContentPane().add(jNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 140, 30));

        jLabel16.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(11, 159, 207));
        jLabel16.setText("Date");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, -1));

        jPhone.setEditable(false);
        getContentPane().add(jPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 140, 30));

        jLabel11.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(11, 159, 207));
        jLabel11.setText("Phone No.");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jLabel10.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(11, 159, 207));
        jLabel10.setText("City");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jCity.setEditable(false);
        getContentPane().add(jCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 140, 30));

        jLabel12.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(11, 159, 207));
        jLabel12.setText("NIC");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, -1, -1));

        jAddress.setEditable(false);
        getContentPane().add(jAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 280, 30));

        jEmail.setEditable(false);
        getContentPane().add(jEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 190, 30));

        jLabel13.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(11, 159, 207));
        jLabel13.setText("Email");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(11, 159, 207));
        jLabel5.setText("Gender");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

        jLabel31.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(11, 159, 207));
        jLabel31.setText("Last Name");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        jLast.setEditable(false);
        getContentPane().add(jLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 140, 30));

        jGender.setEditable(false);
        getContentPane().add(jGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 140, 30));

        jBlood.setEditable(false);
        getContentPane().add(jBlood, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 140, 30));

        jAge.setEditable(false);
        getContentPane().add(jAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 140, 30));

        jFirst.setEditable(false);
        getContentPane().add(jFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 140, 30));

        jLabel6.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(11, 159, 207));
        jLabel6.setText("Blood type");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel9.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(11, 159, 207));
        jLabel9.setText("Address");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel4.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(11, 159, 207));
        jLabel4.setText("Age");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel2.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(11, 159, 207));
        jLabel2.setText("First Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

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

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bookTest.png"))); // NOI18N
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, 140));

        jLabel28.setFont(new java.awt.Font("Raleway Medium", 0, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Booking Test");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 230, 50));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bar.png"))); // NOI18N
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAddTestMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddTestMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jAddTest.setCursor(cur1);
    }//GEN-LAST:event_jAddTestMouseMoved

    private void jAddTestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddTestMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)jTestList.getModel();
        model.setRowCount(0);
        Connection con = null;
        PreparedStatement st=null;
        con = Link.getConnection();
        String test=(String)jSelectTest.getSelectedItem();
        System.out.println(test);
        String date=((JTextField)jDateChooser.getDateEditor().getUiComponent()).getText();
        String sql="update patient_test set done=?,appointed_date=? where test=? and patient_doctor_id=?";
        if(!date.isEmpty()){
            if(!test.equals("Select")){
                try{
                st=con.prepareStatement(sql);
                st.setString(1,"Yes");
                st.setString(2,date);
                st.setString(3,test);
                st.setString(4,patient_doctor_id);
                Object o[]={test,date};
                model.addRow(o);
                st.execute();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            }   
            else{
                JOptionPane.showMessageDialog(null,"Plese select Test", 
                               "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Plese select Date", 
                               "WARNING", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jAddTestMouseClicked

    private void jDeleteTestMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteTestMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jDeleteTest.setCursor(cur1);
    }//GEN-LAST:event_jDeleteTestMouseMoved

    private void jDeleteTestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteTestMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTestList.getModel();

        int row = jTestList.getSelectedRow();
        String test = jTestList.getModel().getValueAt(row, 0).toString();

        Connection con = null;
        PreparedStatement st=null;
        con = Link.getConnection();
        String sql=("update patient_test set done=?,appointed_date=? where test=? and patient_doctor_id=?");
        try{
            st=con.prepareStatement(sql);
            st.setString(1,"No");
                st.setString(2,"00-00-0000");
                st.setString(3,test);
                st.setString(4,patient_doctor_id);
            st.execute();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Please select test to delete", 
                               "WARNING", JOptionPane.WARNING_MESSAGE);
        }

        model.removeRow(row);
    }//GEN-LAST:event_jDeleteTestMouseClicked

    private void jSelectTestMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSelectTestMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSelectTest.setCursor(cur1);

        jSelectTest.removeAllItems();
        jSelectTest.addItem("Select");

        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select * from patient_test where done=? and patient_doctor_id in (select patient_doctor_id from patient_doctor where patient_id=?)";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,"No");
            st.setString(2,value);
            rs=st.executeQuery();
            while(rs.next()){
                jSelectTest.addItem(rs.getString("test"));
                patient_doctor_id=rs.getString("patient_doctor_id");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jSelectTestMouseMoved

    private void jSearchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSearch.setCursor(cur1);
    }//GEN-LAST:event_jSearchMouseMoved

    private void jSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMouseClicked
        // TODO add your handling code here:
        jBack.setVisible(false);
        jSearch.setVisible(false);
        JFrame frame=this.getClosed();
        JLabel label=this.getReturn();
        JLabel label2=this.getBack();
        JPanel panel=this.getVisible();
        TestBookingList list = new TestBookingList(id,frame,label,label2,panel,first);
        list.setVisible(true);
    }//GEN-LAST:event_jSearchMouseClicked

    private void jSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMousePressed
        // TODO add your handling code here:
        jTestPanel.setVisible(false);
    }//GEN-LAST:event_jSearchMousePressed

    private void jBackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jBack.setCursor(cur1);
    }//GEN-LAST:event_jBackMouseMoved

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        // TODO add your handling code here:
        ReceptionistPanel portal=new ReceptionistPanel(id);
        portal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBackMouseClicked

    private void jHomeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jHome.setCursor(cur1);
    }//GEN-LAST:event_jHomeMouseMoved

    private void jHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMouseClicked
        // TODO add your handling code here:
        ReceptionistPanel panel = new ReceptionistPanel(id);
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
            java.util.logging.Logger.getLogger(TestBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestBooking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAddTest;
    private javax.swing.JTextField jAddress;
    private javax.swing.JTextField jAge;
    private javax.swing.JLabel jBack;
    private javax.swing.JTextField jBlood;
    private javax.swing.JTextField jCity;
    private javax.swing.JLabel jClose;
    private javax.swing.JTextField jDate1;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jDeleteTest;
    private javax.swing.JTextField jEmail;
    private javax.swing.JTextField jFirst;
    private javax.swing.JTextField jGender;
    private javax.swing.JLabel jHome;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLast;
    private javax.swing.JLabel jLogout;
    private javax.swing.JTextField jNIC;
    private javax.swing.JTextField jPhone;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jSearch;
    private javax.swing.JComboBox<String> jSelectTest;
    private javax.swing.JTable jTestList;
    private javax.swing.JPanel jTestPanel;
    // End of variables declaration//GEN-END:variables
}
