/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pavi
 */
public class CurrentPatient extends javax.swing.JFrame {
    String first;
    String last;
    String test;
    String old;
    String id;
    String value;
    String patient_doctor_id;
    String date;
    byte[] report;
    int x,y;
    /**
     * Creates new form Current_patient2
     */
    public CurrentPatient() {
        initComponents();
    }
    
    public CurrentPatient(String ID) {
        initComponents();
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int)tk.getScreenSize().getWidth();
        int ysize=(int)tk.getScreenSize().getHeight();
        jTestList.getTableHeader().setFont(new Font("Raleway SemiBold", Font.PLAIN, 13));
        jTestList.getTableHeader().setForeground(Color.BLUE);
        
        jOldOperation.getTableHeader().setFont(new Font("Raleway SemiBold", Font.PLAIN, 13));
        jOldOperation.getTableHeader().setForeground(Color.BLUE);

        this.setSize(xsize,ysize);
        
           jToday.setEditable(false);
           
           jOperationPanel.setVisible(false);
           jTestPanel.setVisible(false);
           
           jLabel19.setVisible(false);
           jLabel15.setVisible(false);
           jLabel22.setVisible(false);
           jToday.setVisible(false);
           jList.setVisible(false);
           jMedicine.setVisible(false);
           jAddMedicine.setVisible(false);
           jDeleteMedicine.setVisible(false);
           
           jChange.setVisible(false);
           jUpdate.setVisible(false);
           jCancel.setVisible(false);
           
           jLabel27.setVisible(false);
           jSubmit.setVisible(false);
           jOperation.setVisible(false);
           
           jScrollPane5.setVisible(false);
           jScrollPane3.setBorder(null);
           
        id=ID;
    }
     
     public CurrentPatient(String ID,String Value) {
        initComponents();
        id=ID;
        value=Value;
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int)tk.getScreenSize().getWidth();
        int ysize=(int)tk.getScreenSize().getHeight();
        jTestList.getTableHeader().setFont(new Font("Raleway SemiBold", Font.PLAIN, 13));
        jTestList.getTableHeader().setForeground(Color.BLUE);
        this.setSize(xsize,ysize);
        
           jToday.setEditable(false);
           
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
            jEmail.setText(rs.getString("email"));
            jCity.setText(rs.getString("city"));
            jPhone.setText(rs.getString("phone"));
            jNIC.setText(rs.getString("NIC"));
            
            jSpecification.setText(rs.getString("specification"));
            
            first=rs.getString("name");
            last=rs.getString("surname");
            jDate.setText("");
            jPrevious.setText("");
            
            DefaultListModel cleanList = new DefaultListModel();
            cleanList.clear();
            jOldPrescription.setModel(cleanList);
           
            jMedicine.setEditable(true);
            jToday.setEditable(true);
            
            jTestPanel.setVisible(true);
            jView.setVisible(false);
            jSelectOldDate.setVisible(false);
            jOperationPanel.setVisible(true);
            jLabel27.setVisible(false);
            jSubmit.setVisible(false);
            jOperation.setVisible(false);
           
           jLabel19.setVisible(true);
           jLabel15.setVisible(true);
           jLabel22.setVisible(true);
           jToday.setVisible(true);
           jList.setVisible(true);
           jMedicine.setVisible(true);
           jAddMedicine.setVisible(true);
           jDeleteMedicine.setVisible(true);
           
           jChange.setVisible(true);
           
           jScrollPane5.setVisible(true);
           jScrollPane3.setBorder((BorderFactory.createLineBorder(Color.gray, 1)));
           
           Connection con1 = null;
        PreparedStatement st1=null;
        ResultSet rs1 = null;
        con1 = Link.getConnection();
           String sql4="select * from patient_doctor where doctor_id=? and patient_id=? and done=?";
           try{
               st1=con1.prepareStatement(sql4);
               st1.setString(1,id);
                st1.setString(2,value);
                st1.setString(3,"No");
                rs1=st1.executeQuery();
                if(rs1.next()){
                    patient_doctor_id=rs1.getString("id");
                }
           }
           catch(Exception e){
               JOptionPane.showMessageDialog(null,e);
           }
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        String sql3="select * from operation where done=? and patient_doctor_id in (select id from patient_doctor where patient_id=?)";
        try{
        st=con.prepareStatement(sql3);
        st.setString(1,"Yes");
        st.setString(2,value);
        rs=st.executeQuery();
        DefaultTableModel tm = (DefaultTableModel)jOldOperation.getModel();
        tm.setRowCount(0);
        
        while(rs.next()){
            Object o[]={rs.getString("operation"),rs.getString("date")};
            tm.addRow(o);
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
     }
     
    public JFrame getClosed(){
        CurrentPatient close=this;
        return close;
    }
    
    public JLabel getReturn(){
        return jSearch; 
    }
    
    public JLabel getBack(){
        return jNextPatient; 
    }
    
    public JLabel getVisible(){
        return jExit; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myGroup = new javax.swing.ButtonGroup();
        jGender = new javax.swing.JTextField();
        jAddMedicine = new javax.swing.JLabel();
        jNIC = new javax.swing.JTextField();
        jBlood = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jOperationPanel = new javax.swing.JPanel();
        jSubmit = new javax.swing.JLabel();
        jNo = new javax.swing.JRadioButton();
        jYes = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jOldOperation = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        jOperation = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jAge = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jMedicine = new javax.swing.JTextField();
        jSearch = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jCity = new javax.swing.JTextField();
        jTestPanel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jSelectTest = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jAddTest = new javax.swing.JLabel();
        jDeleteTest = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTestList = new javax.swing.JTable();
        jSelectOldDate = new javax.swing.JComboBox<>();
        jSelectOldTest = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jView = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jFirst = new javax.swing.JTextField();
        jNextPatient = new javax.swing.JLabel();
        jPhone = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jDate = new javax.swing.JTextField();
        jOld = new javax.swing.JComboBox<>();
        jPrevious = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        jExit = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jDeleteMedicine = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jAddress = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jOldPrescription = new javax.swing.JList<>();
        jToday = new javax.swing.JTextField();
        jSpecificationPanel = new javax.swing.JPanel();
        jChange = new javax.swing.JLabel();
        jUpdate = new javax.swing.JLabel();
        jCancel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jSpecification = new javax.swing.JTextArea();
        jLast = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jHome = new javax.swing.JLabel();
        jLogout = new javax.swing.JLabel();
        jClose = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jGender.setEditable(false);
        getContentPane().add(jGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 207, 140, 30));

        jAddMedicine.setBackground(new java.awt.Color(11, 159, 207));
        jAddMedicine.setForeground(new java.awt.Color(255, 255, 255));
        jAddMedicine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jAddMedicine.setText("Add");
        jAddMedicine.setOpaque(true);
        jAddMedicine.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jAddMedicineMouseMoved(evt);
            }
        });
        jAddMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddMedicineMouseClicked(evt);
            }
        });
        getContentPane().add(jAddMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 670, 61, 23));

        jNIC.setEditable(false);
        getContentPane().add(jNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 140, 30));

        jBlood.setEditable(false);
        getContentPane().add(jBlood, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 242, 140, 30));

        jLabel9.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(11, 159, 207));
        jLabel9.setText("Address");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel10.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(11, 159, 207));
        jLabel10.setText("City");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 325, -1, -1));

        jOperationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Raleway SemiBold", 0, 13), new java.awt.Color(11, 159, 207))); // NOI18N
        jOperationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSubmit.setBackground(new java.awt.Color(11, 159, 207));
        jSubmit.setForeground(new java.awt.Color(255, 255, 255));
        jSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jSubmit.setText("Submit");
        jSubmit.setOpaque(true);
        jSubmit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSubmitMouseMoved(evt);
            }
        });
        jSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSubmitMouseClicked(evt);
            }
        });
        jOperationPanel.add(jSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 395, 61, 23));

        myGroup.add(jNo);
        jNo.setText("No");
        jNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNoActionPerformed(evt);
            }
        });
        jOperationPanel.add(jNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        myGroup.add(jYes);
        jYes.setText("Yes");
        jYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jYesActionPerformed(evt);
            }
        });
        jOperationPanel.add(jYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel26.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(11, 159, 207));
        jLabel26.setText("Old Operations Details");
        jOperationPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        jOldOperation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Operation", "Date"
            }
        ));
        jScrollPane1.setViewportView(jOldOperation);

        jOperationPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 260, 90));

        jLabel32.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(11, 159, 207));
        jLabel32.setText("Make Operation");
        jOperationPanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, -1));
        jOperationPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 280, 20));

        jScrollPane6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jOperation.setColumns(20);
        jOperation.setRows(5);
        jScrollPane6.setViewportView(jOperation);

        jOperationPanel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 250, 110));

        jLabel27.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(11, 159, 207));
        jLabel27.setText("Operation Details");
        jOperationPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 120, -1));

        getContentPane().add(jOperationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 110, 280, 430));

        jLabel21.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(11, 159, 207));
        jLabel21.setText("Old Appointments");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 120, -1));

        jLabel19.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(11, 159, 207));
        jLabel19.setText("Today Diagnosis");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, -1, -1));

        jAge.setEditable(false);
        getContentPane().add(jAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 207, 140, 30));

        jLabel4.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(11, 159, 207));
        jLabel4.setText("Age");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMedicineMouseClicked(evt);
            }
        });
        getContentPane().add(jMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 630, 190, 30));

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
        getContentPane().add(jSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 107, -1, -1));

        jLabel31.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(11, 159, 207));
        jLabel31.setText("Last Name");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        jCity.setEditable(false);
        getContentPane().add(jCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 140, 30));

        jTestPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Raleway SemiBold", 0, 13), new java.awt.Color(11, 159, 207))); // NOI18N
        jTestPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(11, 159, 207));
        jLabel23.setText("New Test");
        jTestPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jSelectTest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blood Test", "Urine Test", "Sugar Test", "X-Ray", "ECG" }));
        jTestPanel.add(jSelectTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 160, 30));

        jLabel24.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(11, 159, 207));
        jLabel24.setText("Test");
        jTestPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 50, -1));

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
        jTestPanel.add(jAddTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 61, 23));

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
        jTestPanel.add(jDeleteTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 61, 23));

        jTestList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Test"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTestList);

        jTestPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 270, 90));

        jSelectOldDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jSelectOldDate.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSelectOldDateMouseMoved(evt);
            }
        });
        jSelectOldDate.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jSelectOldDatePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jTestPanel.add(jSelectOldDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 100, 30));

        jSelectOldTest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jSelectOldTest.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSelectOldTestMouseMoved(evt);
            }
        });
        jSelectOldTest.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jSelectOldTestPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jTestPanel.add(jSelectOldTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 140, 30));

        jLabel29.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(11, 159, 207));
        jLabel29.setText("Date");
        jTestPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 27, -1, -1));

        jView.setBackground(new java.awt.Color(11, 159, 207));
        jView.setForeground(new java.awt.Color(255, 255, 255));
        jView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jView.setText("View Report");
        jView.setOpaque(true);
        jView.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jViewMouseMoved(evt);
            }
        });
        jView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewMouseClicked(evt);
            }
        });
        jTestPanel.add(jView, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 71, 23));

        jLabel30.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(11, 159, 207));
        jLabel30.setText("Old Test");
        jTestPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 27, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jTestPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 10, 160));

        getContentPane().add(jTestPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 540, 750, 170));

        jFirst.setEditable(false);
        getContentPane().add(jFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 167, 140, 30));

        jNextPatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nextPatient.png"))); // NOI18N
        jNextPatient.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jNextPatientMouseMoved(evt);
            }
        });
        jNextPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNextPatientMouseClicked(evt);
            }
        });
        getContentPane().add(jNextPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 710, -1, -1));

        jPhone.setEditable(false);
        getContentPane().add(jPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 140, 30));

        jLabel14.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(11, 159, 207));
        jLabel14.setText("Previous Prescription");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        jDate.setEditable(false);
        getContentPane().add(jDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 140, 30));

        jOld.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jOld.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jOldMouseMoved(evt);
            }
        });
        jOld.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jOldPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        getContentPane().add(jOld, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 140, 30));

        jPrevious.setEditable(false);
        getContentPane().add(jPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 140, 30));

        jLabel6.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(11, 159, 207));
        jLabel6.setText("Blood type");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jScrollPane3.setViewportView(jList);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 630, 210, -1));

        jExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        jExit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jExitMouseMoved(evt);
            }
        });
        jExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jExitMouseClicked(evt);
            }
        });
        getContentPane().add(jExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 710, -1, -1));

        jLabel22.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(11, 159, 207));
        jLabel22.setText("Medicine");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 610, -1, -1));

        jDeleteMedicine.setBackground(new java.awt.Color(11, 159, 207));
        jDeleteMedicine.setForeground(new java.awt.Color(255, 255, 255));
        jDeleteMedicine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDeleteMedicine.setText("Delete");
        jDeleteMedicine.setOpaque(true);
        jDeleteMedicine.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jDeleteMedicineMouseMoved(evt);
            }
        });
        jDeleteMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDeleteMedicineMouseClicked(evt);
            }
        });
        getContentPane().add(jDeleteMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 670, 61, 23));

        jLabel12.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(11, 159, 207));
        jLabel12.setText("NIC");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, -1, -1));

        jLabel5.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(11, 159, 207));
        jLabel5.setText("Gender");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        jAddress.setEditable(false);
        getContentPane().add(jAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 280, 30));

        jScrollPane2.setViewportView(jOldPrescription);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 210, 100));
        getContentPane().add(jToday, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 590, 140, 30));

        jSpecificationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Specification", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Raleway SemiBold", 0, 13), new java.awt.Color(11, 159, 207))); // NOI18N
        jSpecificationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jChange.setBackground(new java.awt.Color(11, 159, 207));
        jChange.setForeground(new java.awt.Color(255, 255, 255));
        jChange.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jChange.setText("Change");
        jChange.setOpaque(true);
        jChange.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jChangeMouseMoved(evt);
            }
        });
        jChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChangeMouseClicked(evt);
            }
        });
        jSpecificationPanel.add(jChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 61, 23));

        jUpdate.setBackground(new java.awt.Color(11, 159, 207));
        jUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jUpdate.setText("Update");
        jUpdate.setOpaque(true);
        jUpdate.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jUpdateMouseMoved(evt);
            }
        });
        jUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateMouseClicked(evt);
            }
        });
        jSpecificationPanel.add(jUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 61, 23));

        jCancel.setBackground(new java.awt.Color(11, 159, 207));
        jCancel.setForeground(new java.awt.Color(255, 255, 255));
        jCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCancel.setText("Cancel");
        jCancel.setOpaque(true);
        jCancel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jCancelMouseMoved(evt);
            }
        });
        jCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCancelMouseClicked(evt);
            }
        });
        jSpecificationPanel.add(jCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 61, 23));

        jSpecification.setEditable(false);
        jSpecification.setColumns(20);
        jSpecification.setRows(5);
        jScrollPane4.setViewportView(jSpecification);

        jSpecificationPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 320, 150));

        getContentPane().add(jSpecificationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 430, 200));

        jLast.setEditable(false);
        getContentPane().add(jLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 167, 140, 30));

        jLabel20.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(11, 159, 207));
        jLabel20.setText("Previous Diagnosis");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jLabel11.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(11, 159, 207));
        jLabel11.setText("Phone No.");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel2.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(11, 159, 207));
        jLabel2.setText("First Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jEmail.setEditable(false);
        getContentPane().add(jEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 242, 190, 30));

        jLabel15.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(11, 159, 207));
        jLabel15.setText("Today Prescription");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, -1, -1));

        jLabel8.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(11, 159, 207));
        jLabel8.setText("Date");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, -1, -1));

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
        getContentPane().add(jHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 30, -1, -1));

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
        getContentPane().add(jLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 30, -1, -1));

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
        getContentPane().add(jClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 25, -1, -1));

        jLabel13.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(11, 159, 207));
        jLabel13.setText("Email");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/appointmenticon.png"))); // NOI18N
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 140));

        jLabel28.setFont(new java.awt.Font("Raleway Medium", 0, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Patients Details");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 280, 50));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bar.png"))); // NOI18N
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAddMedicineMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddMedicineMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jAddMedicine.setCursor(cur1);
    }//GEN-LAST:event_jAddMedicineMouseMoved

    DefaultListModel list=new DefaultListModel();
    private void jAddMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddMedicineMouseClicked
        // TODO add your handling code here:
        String medicine=jMedicine.getText();
        if(!medicine.isEmpty()){
            list.addElement(jMedicine.getText());
            jList.setModel(list);
            Connection con = null;
            PreparedStatement st=null;
            con = Link.getConnection();
            String sql=("insert into patient_prescription(date,patient_doctor_id,prescription,diagnosis) values(?,?,?,?)");
            try{
                st=con.prepareStatement(sql);
                st.setString(1,java.time.LocalDate.now().toString());
                st.setString(2,patient_doctor_id);
                st.setString(3,jMedicine.getText());
                st.setString(4,jToday.getText());
                st.execute();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            jMedicine.setText("");
        }else{
            JOptionPane.showMessageDialog(null,"Please enter medicines", 
                               "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jAddMedicineMouseClicked

    private void jSubmitMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSubmitMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSubmit.setCursor(cur1);
    }//GEN-LAST:event_jSubmitMouseMoved

    private void jSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSubmitMouseClicked
        // TODO add your handling code here:
        String operation=jOperation.getText();
        if(!operation.isEmpty()){
            Connection con = null;
            PreparedStatement st=null;
            con = Link.getConnection();
            String sql=("insert into operation(operation,date,done,patient_doctor_id) values(?,?,?,?)");
            try{
                st=con.prepareStatement(sql);
                st.setString(1,operation);
                st.setString(2,"00-00-0000");
                st.setString(3,"No");
                st.setString(4,patient_doctor_id);
                st.execute();
                JOptionPane.showMessageDialog(null,"Successfully submitted");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            jMedicine.setText("");
        }else{
            JOptionPane.showMessageDialog(null,"Please enter operation or date", 
                               "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jSubmitMouseClicked

    private void jNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNoActionPerformed
        // TODO add your handling code here:
        jLabel27.setVisible(false);
        jSubmit.setVisible(false);
        jOperation.setVisible(false);
    }//GEN-LAST:event_jNoActionPerformed

    private void jYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jYesActionPerformed
        // TODO add your handling code here:
        jLabel27.setVisible(true);
        jSubmit.setVisible(true);
        jOperation.setVisible(true);
    }//GEN-LAST:event_jYesActionPerformed

    private void jMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMedicineMouseClicked
        // TODO add your handling code here:
        if(jToday.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please enter today diagnosis");
            jToday.requestFocusInWindow();
        }
    }//GEN-LAST:event_jMedicineMouseClicked

    private void jSearchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSearch.setCursor(cur1);
    }//GEN-LAST:event_jSearchMouseMoved

    private void jSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMouseClicked
        // TODO add your handling code here:
        jNextPatient.setVisible(false);
        jExit.setVisible(false);
        jSearch.setVisible(false);
        JFrame frame=this.getClosed();
        JLabel label=this.getReturn();
        JLabel label2=this.getBack();
        JLabel label3=this.getVisible();
        CurrentPatientList list = new CurrentPatientList(id,frame,label,label2,label3);
        list.setVisible(true);
    }//GEN-LAST:event_jSearchMouseClicked

    private void jSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMousePressed
        // TODO add your handling code here:
        jToday.setEditable(false);

        jOperationPanel.setVisible(false);
        jTestPanel.setVisible(false);

        jLabel19.setVisible(false);
        jLabel15.setVisible(false);
        jLabel22.setVisible(false);
        jToday.setVisible(false);
        jList.setVisible(false);
        jMedicine.setVisible(false);
        jAddMedicine.setVisible(false);
        jDeleteMedicine.setVisible(false);

        jChange.setVisible(false);
        jUpdate.setVisible(false);
        jCancel.setVisible(false);

        jLabel27.setVisible(false);
        jSubmit.setVisible(false);
        jOperation.setVisible(false);

        jScrollPane5.setVisible(false);
        jScrollPane3.setBorder(null);
        
        jFirst.setText("");
        jLast.setText("");
        jAge.setText("");
        jGender.setText("");
        jBlood.setText("");
        jAddress.setText("");
        jCity.setText("");
        jEmail.setText("");
        jPhone.setText("");
        jNIC.setText("");
        jDate.setText("");
        jPrevious.setText("");
        jToday.setText("");
        jSpecification.setText("");
        jOld.removeAllItems();
        jOld.addItem("Select");

        DefaultListModel cleanList = new DefaultListModel();
        cleanList.clear();
        jOldPrescription.setModel(cleanList);
        jList.setModel(cleanList);

        DefaultTableModel model = (DefaultTableModel) jTestList.getModel();
        model.setRowCount(0);

        jDate.setText("");
        jMedicine.setText("");
        jOld.removeAllItems();
        jOld.addItem("Select");
    }//GEN-LAST:event_jSearchMousePressed

    private void jAddTestMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddTestMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jAddTest.setCursor(cur1);
    }//GEN-LAST:event_jAddTestMouseMoved

    int count=0;
    private void jAddTestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddTestMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)jTestList.getModel();
        model.setRowCount(count);
        Connection con = null;
        PreparedStatement st=null;
        con = Link.getConnection();
        String test=(String)jSelectTest.getSelectedItem();
        String sql=("insert into patient_test(patient_doctor_id,today_date,test,appointed_date,report,done) values(?,?,?,?,?,?)");
        if(!test.isEmpty()){
            try{
                st=con.prepareStatement(sql);
                st.setString(1,patient_doctor_id);
                st.setString(2,java.time.LocalDate.now().toString());
                st.setString(3,test);
                st.setString(4,"00-00-0000");
                st.setString(5,"");
                st.setString(6,"No");
                Object o[]={test};
                model.addRow(o);
                st.execute();
                count++;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
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
        String sql=("DELETE FROM patient_test WHERE test = ? and today_date = ? and patient_doctor_id=?");
        try{
            st=con.prepareStatement(sql);
            st.setString(1,test);
            st.setString(2,java.time.LocalDate.now().toString());
            st.setString(3,patient_doctor_id);
            st.execute();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Please select test to delete", 
                               "WARNING", JOptionPane.WARNING_MESSAGE);
        }

        model.removeRow(row);
    }//GEN-LAST:event_jDeleteTestMouseClicked

    private void jSelectOldDateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSelectOldDateMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSelectOldDate.setCursor(cur1);
        jSelectOldDate.removeAllItems();
        jSelectOldDate.addItem("Select");
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select distinct today_date from patient_test where test=? and patient_doctor_id in (select id from patient_doctor where patient_id=?)";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,old);
            st.setString(2,value);
            rs=st.executeQuery();
            while(rs.next()){
                jSelectOldDate.addItem(rs.getString("today_date"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        if(date!=null){
            jSelectOldDate.setSelectedItem(date);
        }
    }//GEN-LAST:event_jSelectOldDateMouseMoved

    private void jSelectOldDatePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jSelectOldDatePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        date=(String)jSelectOldDate.getSelectedItem();
        if(!date.equals("Select")){
            jView.setVisible(true);
        }
    }//GEN-LAST:event_jSelectOldDatePopupMenuWillBecomeInvisible

    private void jSelectOldTestMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSelectOldTestMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSelectOldTest.setCursor(cur1);
        
        jSelectOldTest.setCursor(cur1);
        jSelectOldTest.removeAllItems();
        jSelectOldTest.addItem("Select");
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select distinct test from patient_test where done=? and patient_doctor_id in (select id from patient_doctor where patient_id=?)";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,"Yes");
            st.setString(2,value);
            rs=st.executeQuery();
            while(rs.next()){
                jSelectOldTest.addItem(rs.getString("test"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        if(old!=null){
            jSelectOldTest.setSelectedItem(old);
        }
    }//GEN-LAST:event_jSelectOldTestMouseMoved

    private void jSelectOldTestPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jSelectOldTestPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        old=(String)jSelectOldTest.getSelectedItem();
        if(!old.equals("Select")){
            jSelectOldDate.setVisible(true);
        }
    }//GEN-LAST:event_jSelectOldTestPopupMenuWillBecomeInvisible

    private void jViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jView.setCursor(cur1);
    }//GEN-LAST:event_jViewMouseMoved

    private void jViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewMouseClicked
        // TODO add your handling code here:
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;

        InputStream input=null;
        FileOutputStream output=null;

        con = Link.getConnection();
        String sql="select report from patient_test where test=? and today_date=? and patient_doctor_id in (select id from patient_doctor where patient_id=?)";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,old);
            st.setString(2,date);
            st.setString(3,value);
            rs=st.executeQuery();

            File theFile=new File("report.pdf");
            output=new FileOutputStream(theFile);

            while(rs.next()){
                input=rs.getBinaryStream("report");

                byte[] buffer=new byte[1024];
                while(input.read(buffer)>0){
                    output.write(buffer);
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException ex) {
                    Logger.getLogger(CurrentPatient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(output!=null){
                try {
                    output.close();
                } catch (IOException ex) {
                    Logger.getLogger(CurrentPatient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("report.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Any file not added", 
                               "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jViewMouseClicked

    private void jNextPatientMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNextPatientMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jNextPatient.setCursor(cur1);
    }//GEN-LAST:event_jNextPatientMouseMoved

    private void jNextPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNextPatientMouseClicked
        // TODO add your handling code here:
        Connection con = null;
        PreparedStatement st=null;
        con = Link.getConnection();
        String sql="update patient_doctor set done=? where date=? and patient_id="+id;
        try{
            st=con.prepareStatement(sql);
            st.setString(1,"Yes");
            st.setString(2,java.time.LocalDate.now().toString());
            st.executeUpdate();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

        jFirst.setText("");
        jLast.setText("");
        jAge.setText("");
        jGender.setText("");
        jBlood.setText("");
        jAddress.setText("");
        jCity.setText("");
        jEmail.setText("");
        jPhone.setText("");
        jNIC.setText("");
        jDate.setText("");
        jPrevious.setText("");
        jToday.setText("");
        jSpecification.setText("");
        jOld.removeAllItems();
        jOld.addItem("Select");

        DefaultListModel cleanList = new DefaultListModel();
        cleanList.clear();
        jOldPrescription.setModel(cleanList);
        jList.setModel(cleanList);

        DefaultTableModel model = (DefaultTableModel) jTestList.getModel();
        model.setRowCount(0);

        jDate.setText("");
        jMedicine.setText("");
        jOld.removeAllItems();
        jOld.addItem("Select");

        jList.setVisible(false);
        jLabel19.setVisible(false);
        jToday.setVisible(false);
        jLabel15.setVisible(false);
        jLabel22.setVisible(false);
        jMedicine.setVisible(false);
        jAddMedicine.setVisible(false);
        jDeleteMedicine.setVisible(false);

        jOperationPanel.setVisible(false);
        jTestPanel.setVisible(false);

        jNextPatient.setVisible(false);

        jScrollPane5.setVisible(false);
        jScrollPane3.setBorder(null);
    }//GEN-LAST:event_jNextPatientMouseClicked

    private void jOldMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jOldMouseMoved
        // TODO add your handling code here:
        jOld.removeAllItems();
        jOld.addItem("Select");
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select distinct date from patient_prescription where patient_doctor_id in (select id from patient_doctor where doctor_id=? and patient_id=?)";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,id);
            st.setString(2,value);
            rs=st.executeQuery();
            while(rs.next()){
                jOld.addItem(rs.getString("date"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jOldMouseMoved

    private void jOldPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jOldPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String tmp2=(String)jOld.getSelectedItem();
        String sql="select diagnosis,prescription from patient_prescription where date=? and patient_doctor_id in (select id from patient_doctor where doctor_id=? and patient_id=?)";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,tmp2);
            st.setString(2,id);
            st.setString(3,value);
            rs=st.executeQuery();
            DefaultListModel list2=new DefaultListModel();
            while(rs.next()){

                jDate.setText(tmp2);
                jPrevious.setText(rs.getString("diagnosis"));
                list2.addElement(rs.getString("prescription"));
                jOldPrescription.setModel(list2);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jOldPopupMenuWillBecomeInvisible

    private void jExitMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jExitMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jExit.setCursor(cur1);
    }//GEN-LAST:event_jExitMouseMoved

    private void jExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jExitMouseClicked
        // TODO add your handling code here:
        DoctorPanel panel=new DoctorPanel(id);
        panel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jExitMouseClicked

    private void jDeleteMedicineMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteMedicineMouseMoved
        // TODO ad Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jDeleteMedicine.setCursor(cur1);
    }//GEN-LAST:event_jDeleteMedicineMouseMoved

    private void jDeleteMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteMedicineMouseClicked
        // TODO add your handling code here:
        if(!jList.isSelectionEmpty()){
            DefaultListModel model = (DefaultListModel) jList.getModel();
            String selected=jList.getSelectedValue();
            Connection con = null;
            PreparedStatement st=null;
            con = Link.getConnection();
            String sql=("DELETE FROM patient_prescription WHERE prescription=? and date=? and patient_doctor_id=?");
            try{
                st=con.prepareStatement(sql);
                st.setString(1,selected);
                st.setString(2,java.time.LocalDate.now().toString());
                st.setString(3,patient_doctor_id);
                st.execute();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            int selectedIndex = jList.getSelectedIndex();
            if (selectedIndex != -1) {
                model.remove(selectedIndex);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Please select medicine from list", 
                               "WARNING", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jDeleteMedicineMouseClicked

    private void jChangeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChangeMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jChange.setCursor(cur1);
    }//GEN-LAST:event_jChangeMouseMoved

    private void jChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChangeMouseClicked
        // TODO add your handling code here:
        jSpecification.setEditable(true);

        jChange.setVisible(false);

        jUpdate.setVisible(true);
        jCancel.setVisible(true);
    }//GEN-LAST:event_jChangeMouseClicked

    private void jUpdateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jUpdate.setCursor(cur1);
    }//GEN-LAST:event_jUpdateMouseMoved

    private void jUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateMouseClicked
        // TODO add your handling code here:
        String specification=jSpecification.getText();
        Connection con = null;
        PreparedStatement st=null;
        con = Link.getConnection();
        String sql="update patient set specification=? where id="+value;
        try{
            st=con.prepareStatement(sql);
            st.setString(1,specification);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Specification Updated");

            jUpdate.setVisible(false);
            jCancel.setVisible(false);

            jChange.setVisible(true);

            jSpecification.setEditable(false);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jUpdateMouseClicked

    private void jCancelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jCancel.setCursor(cur1);
    }//GEN-LAST:event_jCancelMouseMoved

    private void jCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelMouseClicked
        // TODO add your handling code here:
        jSpecification.setText("");
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
                jSpecification.setText(rs.getString("specification"));

                jUpdate.setVisible(false);
                jCancel.setVisible(false);

                jChange.setVisible(true);

                jSpecification.setEditable(false);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jCancelMouseClicked

    private void jHomeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jHome.setCursor(cur1);
    }//GEN-LAST:event_jHomeMouseMoved

    private void jHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMouseClicked
        // TODO add your handling code here:
        DoctorPanel panel = new DoctorPanel(id);
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
            java.util.logging.Logger.getLogger(CurrentPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrentPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrentPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrentPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrentPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAddMedicine;
    private javax.swing.JLabel jAddTest;
    private javax.swing.JTextField jAddress;
    private javax.swing.JTextField jAge;
    private javax.swing.JTextField jBlood;
    private javax.swing.JLabel jCancel;
    private javax.swing.JLabel jChange;
    private javax.swing.JTextField jCity;
    private javax.swing.JLabel jClose;
    private javax.swing.JTextField jDate;
    private javax.swing.JLabel jDeleteMedicine;
    private javax.swing.JLabel jDeleteTest;
    private javax.swing.JTextField jEmail;
    private javax.swing.JLabel jExit;
    private javax.swing.JTextField jFirst;
    private javax.swing.JTextField jGender;
    private javax.swing.JLabel jHome;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLast;
    private javax.swing.JList<String> jList;
    private javax.swing.JLabel jLogout;
    private javax.swing.JTextField jMedicine;
    private javax.swing.JTextField jNIC;
    private javax.swing.JLabel jNextPatient;
    private javax.swing.JRadioButton jNo;
    private javax.swing.JComboBox<String> jOld;
    private javax.swing.JTable jOldOperation;
    private javax.swing.JList<String> jOldPrescription;
    private javax.swing.JTextArea jOperation;
    private javax.swing.JPanel jOperationPanel;
    private javax.swing.JTextField jPhone;
    private javax.swing.JTextField jPrevious;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel jSearch;
    private javax.swing.JComboBox<String> jSelectOldDate;
    private javax.swing.JComboBox<String> jSelectOldTest;
    private javax.swing.JComboBox<String> jSelectTest;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jSpecification;
    private javax.swing.JPanel jSpecificationPanel;
    private javax.swing.JLabel jSubmit;
    private javax.swing.JTable jTestList;
    private javax.swing.JPanel jTestPanel;
    private javax.swing.JTextField jToday;
    private javax.swing.JLabel jUpdate;
    private javax.swing.JLabel jView;
    private javax.swing.JRadioButton jYes;
    private javax.swing.ButtonGroup myGroup;
    // End of variables declaration//GEN-END:variables
}
