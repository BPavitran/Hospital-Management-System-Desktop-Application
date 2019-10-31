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
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.TableModel;

/**
 *
 * @author Pavi
 */
public class ViewDoctorTimeTable extends javax.swing.JFrame {
    String id;
    /**
     * Creates new form DoctorTimeTableView2
     */
    public ViewDoctorTimeTable() {
        initComponents();
    }
    
     public ViewDoctorTimeTable(String ID) {
        initComponents();
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int)tk.getScreenSize().getWidth();
        int ysize=(int)tk.getScreenSize().getHeight();
        this.setSize(xsize,ysize);
        id=ID;
        jScrollPane1.setBorder(null);
        jScrollPane2.setBorder(null);
        jTable1.setBorder((BorderFactory.createMatteBorder(0,1,1,0,Color.gray)));
        jDocTimeTable.setBorder((BorderFactory.createMatteBorder(0,0,1,1,Color.gray)));
        
        jTable1.getTableHeader().setFont(new Font("Raleway SemiBold", Font.PLAIN, 13));
        jTable1.getTableHeader().setForeground(Color.BLUE);;
        
        jDocTimeTable.getTableHeader().setFont(new Font("Raleway SemiBold", Font.PLAIN, 13));
        jDocTimeTable.getTableHeader().setForeground(Color.BLUE);;
        
        jOPDDocTimeTable.getTableHeader().setFont(new Font("Raleway SemiBold", Font.PLAIN, 13));
        jOPDDocTimeTable.getTableHeader().setForeground(Color.BLUE);;
        start();
        
        jDocTimeTable.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        
        int row = jDocTimeTable.rowAtPoint(evt.getPoint());
        int col = jDocTimeTable.columnAtPoint(evt.getPoint());
        String previous="";
        if(jDocTimeTable.getValueAt(row, col)!=null){
            previous=jDocTimeTable.getModel().getValueAt(row, col).toString();
        };
        if (evt.getClickCount() == 2 && jDocTimeTable.getSelectedRow() != -1) {
            String[] buttons = { "Change", "Delete","Cancel" };
            JPanel panel = new JPanel();
        panel.add(new JLabel("Choose Doctor Name"));
            JComboBox comboBox = new JComboBox();
            Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql2="select * from doctor";
        try{
        st=con.prepareStatement(sql2);
        rs=st.executeQuery();
        while(rs.next()){
            comboBox.addItem(rs.getString("full_name"));
        }
        }
        catch(Exception e){
               JOptionPane.showMessageDialog(null,e);
        }
            panel.add(comboBox);
            
        int rc=JOptionPane.showOptionDialog(null,panel,"Update or Delete Doctor", JOptionPane.PLAIN_MESSAGE,0,null,buttons,buttons[2]);
        if(rc==0){
            String doctor_id="";
            String value = comboBox.getSelectedItem().toString();
            String sql3="select * from doctor where full_name=?";
            try{
                st=con.prepareStatement(sql3);
                st.setString(1,value);
                rs=st.executeQuery();
                while(rs.next()){
                    doctor_id=rs.getString("id");
                }
            }
            catch(Exception e){
               JOptionPane.showMessageDialog(null,e);
                }
            
            if(!previous.isEmpty()){
                
            String time=jTable1.getModel().getValueAt(row, 0).toString();
            String day=jDocTimeTable.getColumnName(col);
            String sql1="update time_table set full_name=? , doctor_id=? where day=? and time=? ";
            try{
            st=con.prepareStatement(sql1);
            st.setString(1,value);
            st.setString(2,doctor_id);
            st.setString(3,day);
            st.setString(4,time);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Doctor Time Updated");
            start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            }else{

            String time=jTable1.getModel().getValueAt(row, 0).toString();
            String day=jDocTimeTable.getColumnName(col);
            String sql1="insert into time_table(day,time,full_name,doctor_id) value(?,?,?,?)";
            try{
            st=con.prepareStatement(sql1);
            st.setString(1,day);
            st.setString(2,time);
            st.setString(3,value);
            st.setString(4,doctor_id);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Doctor Time Updated");
            start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            } 
            }
            
        }else if(rc==1){
            String value = jDocTimeTable.getModel().getValueAt(row, col).toString();
            String time=jTable1.getModel().getValueAt(row, 0).toString();
            String day=jDocTimeTable.getColumnName(col);
            String sql1="delete from time_table where day=? and time=? and full_name=?";
            try{
            st=con.prepareStatement(sql1);
            st.setString(1,day);
            st.setString(2,time);
            st.setString(3,value);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Doctor Time Updated");
            start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
        }
    }
    });
        
    jScrollPane3.setBorder(null);
        jOPDDocTimeTable.setBorder((BorderFactory.createMatteBorder(0,0,1,1,Color.gray)));
        opd_start();
        
        jOPDDocTimeTable.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        
        int row = jOPDDocTimeTable.rowAtPoint(evt.getPoint());
        int col = jOPDDocTimeTable.columnAtPoint(evt.getPoint());
        String previous="";
        if(jOPDDocTimeTable.getValueAt(row, col)!=null){
            previous=jOPDDocTimeTable.getModel().getValueAt(row, col).toString();
        };
        if (evt.getClickCount() == 2 && jOPDDocTimeTable.getSelectedRow() != -1) {
            String[] buttons = { "Change", "Delete","Cancel" };
            JPanel panel = new JPanel();
        panel.add(new JLabel("Choose Doctor Name"));
            JComboBox comboBox = new JComboBox();
            Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql2="select * from doctor where specialization=?";
        try{
        st=con.prepareStatement(sql2);
        st.setString(1,"Consultant");
        rs=st.executeQuery();
        while(rs.next()){
            comboBox.addItem(rs.getString("full_name"));
        }
        }
        catch(Exception e){
               JOptionPane.showMessageDialog(null,e);
        }
            panel.add(comboBox);
            
        int rc=JOptionPane.showOptionDialog(null,panel,"Update or Delete Doctor", JOptionPane.PLAIN_MESSAGE,0,null,buttons,buttons[2]);
        if(rc==0){
            String doctor_id="";
            String value = comboBox.getSelectedItem().toString();
            String sql3="select * from doctor where full_name=?";
            try{
                st=con.prepareStatement(sql3);
                st.setString(1,value);
                rs=st.executeQuery();
                while(rs.next()){
                    doctor_id=rs.getString("id");
                }
            }
            catch(Exception e){
               JOptionPane.showMessageDialog(null,e);
                }
            
            if(!previous.isEmpty()){
                
            String day=jOPDDocTimeTable.getColumnName(col);
            String sql1="update opd_time_table set full_name=? , doctor_id=? where day=?";
            try{
            st=con.prepareStatement(sql1);
            st.setString(1,value);
            st.setString(2,doctor_id);
            st.setString(3,day);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Doctor Day Updated");
            opd_start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            }else{

            String day=jOPDDocTimeTable.getColumnName(col);
            String sql1="insert into opd_time_table(day,full_name,doctor_id) value(?,?,?)";
            try{
            st=con.prepareStatement(sql1);
            st.setString(1,day);
            st.setString(2,value);
            st.setString(3,doctor_id);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Doctor Time Updated");
            opd_start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            } 
            }
            
        }else if(rc==1){
            String value = jOPDDocTimeTable.getModel().getValueAt(row, col).toString();
            String day=jOPDDocTimeTable.getColumnName(col);
            String sql1="delete from opd_time_table where day=? and full_name=?";
            try{
            st=con.prepareStatement(sql1);
            st.setString(1,day);
            st.setString(2,value);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Doctor Date Updated");
            opd_start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
        }
    }
    });    
        
    }
    
    private void start(){
        String day,time,docname="";
        int rows = jDocTimeTable.getRowCount();
        int cols = jDocTimeTable.getColumnCount();
        TableModel tm = jTable1.getModel();
        
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select * from time_table";
        try{
        st=con.prepareStatement(sql);
        rs=st.executeQuery();
        Object[][] object = new Object[rows][cols];
        while(rs.next()){
            day=rs.getString("day");
            time=rs.getString("time");
            docname=rs.getString("full_name");
            int rowSearch=0,colSearch=0;
            
            for (int i = 0; i < tm.getRowCount(); i++) { 
            for (int j = 0; j < tm.getColumnCount(); j++) {
             String check = tm.getValueAt(i, j).toString();
             if(check.equals(time)){
                 rowSearch=i;
             }
                }        
                }
           colSearch = jDocTimeTable.getColumnModel().getColumnIndex(day);
           object[rowSearch][colSearch]=docname;
        }
        jDocTimeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {object[0][0], object[0][1], object[0][2], object[0][3], object[0][4], object[0][5], object[0][6]},
                {object[1][0], object[1][1], object[1][2], object[1][3], object[1][4], object[1][5], object[1][6]},
                {object[2][0], object[2][1], object[2][2], object[2][3], object[2][4], object[2][5], object[2][6]},
                {object[3][0], object[3][1], object[3][2], object[3][3], object[3][4], object[3][5], object[3][6]},
                {object[4][0], object[4][1], object[4][2], object[4][3], object[4][4], object[4][5], object[4][6]},
                {object[5][0], object[5][1], object[5][2], object[5][3], object[5][4], object[5][5], object[5][6]},
                {object[6][0], object[6][1], object[6][2], object[6][3], object[6][4], object[6][5], object[6][6]},
                {object[7][0], object[7][1], object[7][2], object[7][3], object[7][4], object[7][5], object[7][6]},
                {object[8][0], object[8][1], object[8][2], object[8][3], object[8][4], object[8][5], object[8][6]},
                {object[9][0], object[9][1], object[9][2], object[9][3], object[9][4], object[9][5], object[9][6]}
            },
            new String [] {
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ){
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            System.out.println(e.getStackTrace()[0]);
        }
    }
    
    private void opd_start(){
        String day,docname="";
        int rows = jOPDDocTimeTable.getRowCount();
        int cols = jOPDDocTimeTable.getColumnCount();
        
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select * from opd_time_table";
        try{
        st=con.prepareStatement(sql);
        rs=st.executeQuery();
        Object[][] object = new Object[rows][cols];
        while(rs.next()){
            day=rs.getString("day");
            docname=rs.getString("full_name");
            int rowSearch=0,colSearch=0;

           colSearch = jOPDDocTimeTable.getColumnModel().getColumnIndex(day);
           object[rowSearch][colSearch]=docname;
        }
        jOPDDocTimeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {object[0][0], object[0][1], object[0][2], object[0][3], object[0][4], object[0][5], object[0][6]},
            },
            new String [] {
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ){
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            System.out.println(e.getStackTrace()[0]);
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jOPDDocTimeTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDocTimeTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jClose = new javax.swing.JLabel();
        jBack = new javax.swing.JLabel();
        jHome = new javax.swing.JLabel();
        jLogout = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jViewProfile = new javax.swing.JMenu();
        jInsertProfile = new javax.swing.JMenu();
        jUpdateProfile = new javax.swing.JMenu();
        jTimeTable = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jOPDDocTimeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jOPDDocTimeTable.setName(""); // NOI18N
        jOPDDocTimeTable.setRowHeight(25);
        jScrollPane3.setViewportView(jOPDDocTimeTable);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 890, 70));

        jDocTimeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jDocTimeTable.setName(""); // NOI18N
        jDocTimeTable.setRowHeight(25);
        jScrollPane1.setViewportView(jDocTimeTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 880, 290));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"08.00 am - 09.00 am"},
                {"09.00 am - 10.00 am"},
                {"10.00 am - 11.00 am"},
                {"11.00 am - 12.00 am"},
                {"12.00 am - 01.00 pm"},
                {"01.00 pm - 02.00 pm"},
                {"02.00 pm - 03.00 pm"},
                {"03.00 pm - 04.00 pm"},
                {"04.00 pm - 05.00 pm"},
                {"05.00 pm - 06.00 pm"}
            },
            new String [] {
                "Time Period"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 130, 290));

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
        getContentPane().add(jBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 630, -1, -1));

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

        jLabel18.setFont(new java.awt.Font("Raleway Medium", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("View Time Table");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 290, 50));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/doctoricon.png"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 150, 140));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bar.png"))); // NOI18N
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jViewProfile.setText("View Profile");
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

        jInsertProfile.setText("Insert Profile");
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

        jUpdateProfile.setText("Update Profile");
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

        jTimeTable.setText("TimeTable");
        jTimeTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTimeTableMouseMoved(evt);
            }
        });
        jTimeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTimeTableMouseClicked(evt);
            }
        });
        jMenuBar2.add(jTimeTable);

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
        ViewDoctor view=new ViewDoctor(id);
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
        InsertDoctor insert=new InsertDoctor(id);
        insert.setVisible(true);
        dispose();
    }//GEN-LAST:event_jInsertProfileMouseClicked

    private void jUpdateProfileMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateProfileMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jUpdateProfile.setCursor(cur1);
    }//GEN-LAST:event_jUpdateProfileMouseMoved

    private void jUpdateProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateProfileMouseClicked
        // TODO add your handling code here:
        UpdateDoctor update = new UpdateDoctor(id);
        update.setVisible(true);
        dispose();
    }//GEN-LAST:event_jUpdateProfileMouseClicked

    private void jTimeTableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTimeTableMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jTimeTable.setCursor(cur1);
    }//GEN-LAST:event_jTimeTableMouseMoved

    private void jTimeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTimeTableMouseClicked
        // TODO add your handling code here:
        ViewDoctorTimeTable timetable=new ViewDoctorTimeTable(id);
        timetable.setVisible(true);
        dispose();
    }//GEN-LAST:event_jTimeTableMouseClicked

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
            java.util.logging.Logger.getLogger(ViewDoctorTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDoctorTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDoctorTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDoctorTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDoctorTimeTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBack;
    private javax.swing.JLabel jClose;
    private javax.swing.JTable jDocTimeTable;
    private javax.swing.JLabel jHome;
    private javax.swing.JMenu jInsertProfile;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLogout;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JTable jOPDDocTimeTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu jTimeTable;
    private javax.swing.JMenu jUpdateProfile;
    private javax.swing.JMenu jViewProfile;
    // End of variables declaration//GEN-END:variables
}
