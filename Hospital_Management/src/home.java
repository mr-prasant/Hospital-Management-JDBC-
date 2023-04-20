
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    private int pressed = 0;
    private int val = 1;
    private String username = "root";
    private String password = "2507";
    private String location = "jdbc:mysql://localhost/project";
    Connection con;
    ResultSet rs;
    private String maxId = "Select max(id) from hospital_management;";

    String name_ = "";
    String code_ = "";
    String id_ = "";
    int age_ = 0;
    String mob_ = "";

    public int getVal(String q) {
        int n = 0;
        try {
            String Query = q;
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(location, username, password);
            Statement st = con.createStatement();
            rs = st.executeQuery(Query);
            if (rs.next()) {
                n = rs.getInt(1);
                n++;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public void Execute(String q) {
        try {
            String Query = q;
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(location, username, password);
            Statement st = con.createStatement();
            st.executeUpdate(Query);
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public void clear() {
        name.setText("");
        dob.setDate(null);
        bloodGp.setSelectedIndex(0);
        male.setSelected(false);
        female.setSelected(false);
        other.setSelected(false);
        mail.setText("");
        mob.setText("");
        dis.setSelectedIndex(0);
        disname.setText("-");
        addr.setText("");
        pinCode.setText("");
        rec.setSelected(false);
    }

    public void editable(boolean c) {
        if (c == false) {
            name.setEditable(false);
            dob.setEnabled(false);
            bloodGp.setEnabled(false);
            male.setEnabled(false);
            female.setEnabled(false);
            other.setEnabled(false);
            mail.setEditable(false);
            mob.setEditable(false);
            dis.setEnabled(false);
            disname.setEditable(false);
            addr.setEditable(false);
            pinCode.setEditable(false);
        } else {
            name.setEditable(true);
            dob.setEnabled(true);
            bloodGp.setEnabled(true);
            male.setEnabled(true);
            female.setEnabled(true);
            other.setEnabled(true);
            mail.setEditable(true);
            mob.setEditable(true);
            dis.setEnabled(true);
            disname.setEditable(true);
            addr.setEditable(true);
            pinCode.setEditable(true);
        }
    }

    public String receipt() {
        String p = "";
        //
        String id = idVal.getText();
        boolean ok = false;
        //getting variable name
        int pin = 0;
        String nameP = name.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(dob.getDate());
        String bloodG = (String) bloodGp.getSelectedItem();
        String gMail = mail.getText();
        String phoneN = mob.getText();
        String dise = (String) dis.getSelectedItem();
        String discDis = disname.getText();
        String address = addr.getText();
        pin = Integer.parseInt(pinCode.getText());
        String gender = "";
        if (male.isSelected() == true) {
            gender = "male";
        } else if (female.isSelected() == true) {
            gender = "female";
        } else if (other.isSelected() == true) {
            gender = "other";
        }
        //
        p = "______________________________________\n"
                + "-------------PRASH HOSPITAL-----------\n"
                + "______________________________________\n"
                + "_______________RECIEPT________________\n"
                + "======================================\n"
                + "  " + getTime() + "\n"
                + "  ID        : " + id + "\n"
                + "  NAME      : " + nameP + "\n"
                + "  DOB       : " + date + "\n"
                + "  BLOOD Grp : " + bloodG + "\n"
                + "  GENDER    : " + gender + "\n"
                + "  MOBILE    : " + phoneN + "\n"
                + "======================================\n"
                + "---------REG. FEE = Rs. 500-----------\n"
                + "-------PAYMENT SUCCESSFULLY ✓---------\n"
                + "______________________________________\n"
                + "______________________________________";
        return p;
    }

    public String getTime() {
        String time = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        time = "" + sdf.format(date);

        return time;
    }

    public String getUserID() {
        String r = "";
        logIn lg = new logIn();
        r = lg.getLogInUserID;

        return r;
    }

    public home() {
        initComponents();
        options.setVisible(false);
        String getID = getUserID();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(location, username, password);
            Statement st = con.createStatement();
            String Query = "select * from hospital_management_user where userID = '" + getID + "';";
            ResultSet rs = st.executeQuery(Query);
            rs.next();
            String code = rs.getString("userCode");
            Query = "select * from hospital_management_user_code where userCode = '" + code + "';";
            rs = st.executeQuery(Query);
            rs.next();
            name_ = rs.getString("name");
            code_ = rs.getString("userCode");
            id_ = getID;
            age_ = rs.getInt("age");
            mob_ = rs.getString("mobile");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        logOut = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        headline = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        options = new javax.swing.JTabbedPane();
        addUser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mob = new javax.swing.JTextField();
        dis = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        disname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        addr = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        pinCode = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        idVal = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        bloodGp = new javax.swing.JComboBox();
        dob = new com.toedter.calendar.JDateChooser();
        other = new javax.swing.JRadioButton();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        payment = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        rec = new javax.swing.JCheckBox();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        receipt = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        srch = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        name_s = new javax.swing.JTextField();
        date_s = new javax.swing.JTextField();
        mob_s = new javax.swing.JTextField();
        dis_s = new javax.swing.JTextField();
        pinCode_s = new javax.swing.JTextField();
        gender_s = new javax.swing.JTextField();
        vdate_s = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        bloodG_s = new javax.swing.JComboBox();
        edit = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        byId = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOut.setBackground(new java.awt.Color(255, 204, 204));
        logOut.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        logOut.setForeground(new java.awt.Color(255, 0, 0));
        logOut.setText("Log Out");
        logOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });
        getContentPane().add(logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 770, 190, 50));

        jButton3.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jButton3.setText("View PATIENTS");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 230, 60));

        jButton4.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jButton4.setText("Update Info");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 190, 41));

        jButton2.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jButton2.setText("Add PATIENT");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 392, 194, 41));

        headline.setBackground(new java.awt.Color(255, 255, 204));
        headline.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        headline.setForeground(new java.awt.Color(0, 0, 153));
        headline.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        headline.setText(" WELCOME");
        headline.setBorder(new javax.swing.border.MatteBorder(null));
        headline.setOpaque(true);
        getContentPane().add(headline, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 320, 30));

        jButton5.setBackground(new java.awt.Color(204, 204, 255));
        jButton5.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 204));
        jButton5.setText("i");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1870, 0, 50, 50));

        jButton7.setBackground(new java.awt.Color(255, 204, 255));
        jButton7.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(153, 0, 153));
        jButton7.setText("Setting");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 710, 190, 50));

        options.setEnabled(false);

        addUser.setBackground(new java.awt.Color(0, 51, 51));
        addUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        addUser.setForeground(new java.awt.Color(51, 0, 51));
        addUser.setMaximumSize(new java.awt.Dimension(1320, 32767));
        addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addUserMouseEntered(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel1.setText("Name : ");

        name.setBackground(new java.awt.Color(204, 255, 255));
        name.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 153));
        name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        name.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                namePropertyChange(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 204));
        jLabel3.setText("DOB : ");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Gender : ");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 204));
        jLabel4.setText("Mail ID :");

        mail.setBackground(new java.awt.Color(204, 255, 255));
        mail.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        mail.setForeground(new java.awt.Color(0, 0, 153));
        mail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mailKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 204));
        jLabel5.setText("Mobile Number :");

        mob.setBackground(new java.awt.Color(204, 255, 255));
        mob.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        mob.setForeground(new java.awt.Color(0, 0, 153));
        mob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobActionPerformed(evt);
            }
        });
        mob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobKeyTyped(evt);
            }
        });

        dis.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        dis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));
        dis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                disMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                disMouseReleased(evt);
            }
        });
        dis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disActionPerformed(evt);
            }
        });
        dis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                disFocusGained(evt);
            }
        });
        dis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                disKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 204));
        jLabel8.setText("Any Major Disease :  ");

        disname.setBackground(new java.awt.Color(204, 255, 255));
        disname.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        disname.setForeground(new java.awt.Color(0, 0, 153));
        disname.setText("-");
        disname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        disname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disnameActionPerformed(evt);
            }
        });
        disname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                disnameKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 204));
        jLabel7.setText("Address : ");

        addr.setBackground(new java.awt.Color(204, 255, 255));
        addr.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        addr.setForeground(new java.awt.Color(0, 0, 153));
        addr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addrKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 204));
        jLabel9.setText("Pin Code : ");

        pinCode.setBackground(new java.awt.Color(204, 255, 255));
        pinCode.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        pinCode.setForeground(new java.awt.Color(0, 0, 153));
        pinCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pinCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pinCodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pinCodeKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Trajan Pro", 1, 28)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 255, 255));
        jLabel10.setText("Patient_ID : ");

        idVal.setFont(new java.awt.Font("Trajan Pro", 1, 28)); // NOI18N
        idVal.setForeground(new java.awt.Color(153, 255, 255));
        idVal.setText("P010001");

        jButton8.setBackground(new java.awt.Color(153, 255, 153));
        jButton8.setFont(new java.awt.Font("Trajan Pro", 1, 20)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 0, 0));
        jButton8.setText("PAYMENT");
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 255, 204));
        jLabel11.setText("Blood Group : ");

        bloodGp.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        bloodGp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-", " " }));
        bloodGp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bloodGp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloodGpActionPerformed(evt);
            }
        });

        dob.setBackground(new java.awt.Color(204, 255, 255));
        dob.setForeground(new java.awt.Color(0, 0, 153));
        dob.setDateFormatString("dd-MM-yyyy");
        dob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dobKeyPressed(evt);
            }
        });

        other.setBackground(new java.awt.Color(0, 51, 51));
        buttonGroup1.add(other);
        other.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        other.setForeground(new java.awt.Color(204, 255, 204));
        other.setText("Other");
        other.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        male.setBackground(new java.awt.Color(0, 51, 51));
        buttonGroup1.add(male);
        male.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        male.setForeground(new java.awt.Color(204, 255, 204));
        male.setText("Male");
        male.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });

        female.setBackground(new java.awt.Color(0, 51, 51));
        buttonGroup1.add(female);
        female.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        female.setForeground(new java.awt.Color(204, 255, 204));
        female.setText("Female");
        female.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        payment.setBackground(new java.awt.Color(153, 255, 153));
        payment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        jLabel13.setText("Registration Fee : Rs. 500");

        rec.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        rec.setText("Recipt");

        jButton9.setBackground(new java.awt.Color(255, 255, 204));
        jButton9.setFont(new java.awt.Font("Trajan Pro", 1, 20)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 0, 204));
        jButton9.setText("PAYMENT DONE");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paymentLayout = new javax.swing.GroupLayout(payment);
        payment.setLayout(paymentLayout);
        paymentLayout.setHorizontalGroup(
            paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rec, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        paymentLayout.setVerticalGroup(
            paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jButton6.setFont(new java.awt.Font("Trajan Pro", 0, 36)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 102, 0));
        jButton6.setText("<");
        jButton6.setBorder(null);
        jButton6.setOpaque(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        save.setBackground(new java.awt.Color(102, 255, 0));
        save.setFont(new java.awt.Font("Trajan Pro", 1, 26)); // NOI18N
        save.setForeground(new java.awt.Color(0, 0, 204));
        save.setText("S A V E");
        save.setPreferredSize(new java.awt.Dimension(71, 50));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        receipt.setColumns(20);
        receipt.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        receipt.setRows(5);
        receipt.setText("______________________________________\n-------------PRASH HOSPITAL-----------\n______________________________________\n_______________RECIEPT________________\n======================================\n  ID        : \n  NAME      : \n  DOB       : \n  BLOOD Grp : \n  GENDER    : \n  MOBILE    : \n======================================\n---------REG. FEE = Rs. 500-----------\n-------PAYMENT SUCCESSFULLY ✓---------\n______________________________________\n______________________________________");
        receipt.setEnabled(false);
        jScrollPane1.setViewportView(receipt);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout addUserLayout = new javax.swing.GroupLayout(addUser);
        addUser.setLayout(addUserLayout);
        addUserLayout.setHorizontalGroup(
            addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addUserLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idVal, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addUserLayout.createSequentialGroup()
                        .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addUserLayout.createSequentialGroup()
                                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addUserLayout.createSequentialGroup()
                                        .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bloodGp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(name))
                                .addGap(46, 46, 46))
                            .addGroup(addUserLayout.createSequentialGroup()
                                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(32, 32, 32)
                                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addr)
                                    .addGroup(addUserLayout.createSequentialGroup()
                                        .addComponent(pinCode, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(addUserLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(disname))
                            .addGroup(addUserLayout.createSequentialGroup()
                                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addUserLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(1, 1, 1)
                                        .addComponent(male)
                                        .addGap(18, 18, 18)
                                        .addComponent(female)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(other))
                                    .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addUserLayout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(mail))
                                        .addGroup(addUserLayout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(mob, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(addUserLayout.createSequentialGroup()
                                        .addGap(379, 379, 379)
                                        .addComponent(jLabel6))
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
            .addGroup(addUserLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addUserLayout.setVerticalGroup(
            addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserLayout.createSequentialGroup()
                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addUserLayout.createSequentialGroup()
                        .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addUserLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(idVal))
                                .addGap(29, 29, 29)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addUserLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addUserLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addUserLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dob, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel11)
                                        .addComponent(bloodGp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(male)
                                    .addComponent(female)
                                    .addComponent(other))
                                .addGap(36, 36, 36)
                                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(mob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(disname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(addr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(pinCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        options.addTab("ADD USER", addUser);

        jPanel3.setBackground(new java.awt.Color(110, 175, 142));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        search.setFont(new java.awt.Font("Verdana", 0, 26)); // NOI18N
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });

        srch.setBackground(new java.awt.Color(153, 255, 255));
        srch.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        srch.setText("SEARCH");
        srch.setBorder(new javax.swing.border.MatteBorder(null));
        srch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srchActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 22)); // NOI18N
        jLabel14.setText("Name : ");

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 22)); // NOI18N
        jLabel16.setText("DOB : ");

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 22)); // NOI18N
        jLabel17.setText("Blood Group : ");

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 0, 22)); // NOI18N
        jLabel18.setText("Mobile : ");

        jLabel19.setFont(new java.awt.Font("Trebuchet MS", 0, 22)); // NOI18N
        jLabel19.setText("Disease : ");

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 0, 22)); // NOI18N
        jLabel20.setText("PinCode : ");

        jLabel21.setFont(new java.awt.Font("Trebuchet MS", 0, 22)); // NOI18N
        jLabel21.setText("Gender : ");

        jLabel22.setFont(new java.awt.Font("Trebuchet MS", 0, 22)); // NOI18N
        jLabel22.setText("Visited Date : ");

        name_s.setBackground(new java.awt.Color(204, 255, 204));
        name_s.setFont(new java.awt.Font("Verdana", 0, 23)); // NOI18N
        name_s.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        date_s.setBackground(new java.awt.Color(204, 255, 204));
        date_s.setFont(new java.awt.Font("Verdana", 0, 23)); // NOI18N
        date_s.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        mob_s.setBackground(new java.awt.Color(204, 255, 204));
        mob_s.setFont(new java.awt.Font("Verdana", 0, 23)); // NOI18N
        mob_s.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mob_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mob_sKeyTyped(evt);
            }
        });

        dis_s.setBackground(new java.awt.Color(204, 255, 204));
        dis_s.setFont(new java.awt.Font("Verdana", 0, 23)); // NOI18N
        dis_s.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pinCode_s.setBackground(new java.awt.Color(204, 255, 204));
        pinCode_s.setFont(new java.awt.Font("Verdana", 0, 23)); // NOI18N
        pinCode_s.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pinCode_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pinCode_sKeyTyped(evt);
            }
        });

        gender_s.setBackground(new java.awt.Color(204, 255, 204));
        gender_s.setFont(new java.awt.Font("Verdana", 0, 23)); // NOI18N
        gender_s.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        vdate_s.setBackground(new java.awt.Color(204, 255, 204));
        vdate_s.setFont(new java.awt.Font("Verdana", 0, 23)); // NOI18N
        vdate_s.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Enter Patient ID : ");

        bloodG_s.setBackground(new java.awt.Color(204, 255, 204));
        bloodG_s.setFont(new java.awt.Font("Times New Roman", 0, 26)); // NOI18N
        bloodG_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        bloodG_s.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edit.setBackground(new java.awt.Color(255, 255, 204));
        edit.setFont(new java.awt.Font("Trajan Pro", 1, 28)); // NOI18N
        edit.setText("EDIT");
        edit.setBorder(new javax.swing.border.MatteBorder(null));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(255, 204, 204));
        update.setFont(new java.awt.Font("Trajan Pro", 1, 28)); // NOI18N
        update.setText("UPDATE");
        update.setBorder(new javax.swing.border.MatteBorder(null));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton11.setFont(new java.awt.Font("Trajan Pro", 0, 36)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 102, 0));
        jButton11.setText("<");
        jButton11.setBorder(null);
        jButton11.setOpaque(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        byId.setFont(new java.awt.Font("Trebuchet MS", 1, 26)); // NOI18N
        byId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        byId.setText("BY");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(srch, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(jLabel16)
                        .addGap(27, 27, 27)
                        .addComponent(date_s, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabel15)
                        .addGap(139, 139, 139)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel19)
                                .addComponent(jLabel21)
                                .addComponent(jLabel22)
                                .addComponent(jLabel20))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(27, 27, 27)
                                .addComponent(bloodG_s, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(456, 456, 456)
                        .addComponent(jLabel18)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dis_s, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mob_s, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pinCode_s, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gender_s, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vdate_s, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(347, 347, 347)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(27, 27, 27)
                                .addComponent(name_s, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(503, 503, 503)
                .addComponent(byId, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(srch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(name_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(date_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(bloodG_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(mob_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(dis_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(pinCode_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(gender_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(vdate_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(byId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );

        options.addTab("UPDATE INFO", jPanel3);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "DOB", "BLOOD Grp", "MOB", "DIS", "PINCODE", "GENDER", "DATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton10.setFont(new java.awt.Font("Trajan Pro", 0, 36)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 102, 0));
        jButton10.setText("<");
        jButton10.setBorder(null);
        jButton10.setOpaque(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        total.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setText("Total : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        options.addTab("VIEW USER", jPanel1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1315, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 936, Short.MAX_VALUE)
        );

        options.addTab("", jPanel4);

        getContentPane().add(options, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 1320, 970));

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 50)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 204));
        jLabel24.setText("PRASH");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel25.setFont(new java.awt.Font("Verdana", 1, 50)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setText("HOSPITAL");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homeBG.jpg"))); // NOI18N
        jLabel12.setText("jLabel12");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do you want to LOG OUT?", "* * * ALERT * * *", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new logIn().setVisible(true);
            new logIn().request();
            setVisible(false);
        }
    }//GEN-LAST:event_logOutActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        headline.setText(" ADD PATIENT");
        options.setVisible(true);
        options.setSelectedIndex(0);
        name.requestFocus();
        int getId = getVal(maxId);
        String idp = "P01", ids = "", id = "";
        int realId = 0;
        if (getId < 10) {
            ids = "000";
        } else if (getId < 100) {
            ids = "00";
        } else if (getId < 1000) {
            ids = "0";
        }
        id = idp + ids + getId;
        idVal.setText(id);
        payment.setVisible(false);
        save.setVisible(false);
        receipt.setVisible(false);
        clear();
        editable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        headline.setText(" ALL PATIENTS");
        options.setVisible(true);
        options.setSelectedIndex(2);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(location, username, password);
            Statement st = con.createStatement();
            String Query = "select * from hospital_management;";
            ResultSet rs = st.executeQuery(Query);

            while (rs.next()) {
                String ID = rs.getString("full_id");
                String name = rs.getString("name");
                String dob = rs.getString("date");
                String bloodG = rs.getString("blood_group");
                String mob = rs.getString("mob");
                String dis = rs.getString("dis");
                String pinC = String.valueOf(rs.getString("pincode"));
                String gender = rs.getString("gender");
                String date = rs.getString("visit_date");

                String tbData[] = {ID, name, dob, bloodG, mob, dis, pinC, gender, date};
                DefaultTableModel tb1model1 = (DefaultTableModel) jTable1.getModel();

                tb1model1.addRow(tbData);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        total.setText("Total : " + getVal(maxId));

// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        headline.setText(" UPDATE INFORMATION");
        options.setVisible(true);
        options.setSelectedIndex(1);

        //non - editable
        name_s.setEditable(false);
        date_s.setEditable(false);
        bloodG_s.setEnabled(false);
        mob_s.setEditable(false);
        dis_s.setEditable(false);
        pinCode_s.setEditable(false);
        gender_s.setEditable(false);
        vdate_s.setEditable(false);
        edit.setEnabled(false);
        update.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        headline.setText(" WELCOME");
        new setting().setVisible(true);
        setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        //for update
        //getting value
        String getId = search.getText();
        String dob = date_s.getText();
        String phone = mob_s.getText();
        String pinCode = pinCode_s.getText();
        String Query = "update hospital_management set date = '" + dob + "', mob = '" + phone + "', pincode = '" + pinCode + "' where full_id = '" + getId + "';";
        Execute(Query);
        JOptionPane.showMessageDialog(null, "Updated successfully..!");
        //non - editable
        search.setEditable(true);
        search.requestFocus();
        name_s.setEditable(false);
        date_s.setEditable(false);
        bloodG_s.setEnabled(false);
        mob_s.setEditable(false);
        dis_s.setEditable(false);
        pinCode_s.setEditable(false);
        gender_s.setEditable(false);
        vdate_s.setEditable(false);

        //enabled
        name_s.setEnabled(true);
        dis_s.setEnabled(true);
        gender_s.setEnabled(true);
        vdate_s.setEnabled(true);
        update.setEnabled(false);
        edit.setEnabled(false);

        //clear
        search.setText("");
        name_s.setText("");
        date_s.setText("");
        bloodG_s.setSelectedIndex(0);
        mob_s.setText("");
        dis_s.setText("");
        pinCode_s.setText("");
        gender_s.setText("");
        vdate_s.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        date_s.setEditable(true);
        mob_s.setEditable(true);
        pinCode_s.setEditable(true);
        search.setEditable(false);
        name_s.setEnabled(false);
        dis_s.setEnabled(false);
        gender_s.setEnabled(false);
        vdate_s.setEnabled(false);

        update.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed

    private void pinCode_sKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pinCode_sKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        String s = pinCode_s.getText();
        if (s.length() > 5) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_pinCode_sKeyTyped

    private void mob_sKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mob_sKeyTyped
        String s = mob_s.getText();
        if (s.length() > 9) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_mob_sKeyTyped

    private void srchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchActionPerformed
        String s = search.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(location, username, password);
            String Query = "select * from hospital_management where full_id = '" + s + "';";

            Statement st = con.createStatement();
            rs = st.executeQuery(Query);

            rs.next();
            String name = rs.getString("name");
            String dob = rs.getString("date");
            String bloodG = rs.getString("blood_group");
            String mob = rs.getString("mob");
            String dis = rs.getString("dis");
            String pinC = String.valueOf(rs.getString("pincode"));
            String gender = rs.getString("gender");
            String date = rs.getString("visit_date");
            String by = rs.getString("added_By");

            switch (bloodG) {
                case "A+":
                    bloodG_s.setSelectedIndex(0);
                    break;
                case "A-":
                    bloodG_s.setSelectedIndex(1);
                    break;
                case "B+":
                    bloodG_s.setSelectedIndex(2);
                    break;
                case "B-":
                    bloodG_s.setSelectedIndex(3);
                    break;
                case "O+":
                    bloodG_s.setSelectedIndex(4);
                    break;
                case "O-":
                    bloodG_s.setSelectedIndex(5);
                    break;
                case "AB+":
                    bloodG_s.setSelectedIndex(6);
                    break;
                case "AB-":
                    bloodG_s.setSelectedIndex(7);
                    break;
                default:
                    System.out.println("error");
                    break;

            }
            name_s.setText(name);
            date_s.setText(dob);
            mob_s.setText(mob);
            dis_s.setText(dis);
            pinCode_s.setText(pinC);
            gender_s.setText(gender);
            vdate_s.setText(date);
            byId.setText(by);
            edit.setEnabled(true);

        } catch (Exception e) {
            name_s.setText("");
            date_s.setText("");
            bloodG_s.setSelectedIndex(0);
            mob_s.setText("");
            dis_s.setText("");
            pinCode_s.setText("");
            gender_s.setText("");
            vdate_s.setText("");
            byId.setText("By");
            edit.setEnabled(false);
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Patient of ID " + s + " does not exist!");

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_srchActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Do you want to back?", "* * * A L E R T * * *", JOptionPane.YES_NO_OPTION) == 0) {
            clear();
            headline.setText(" WELCOME");
            options.setVisible(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void addUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_addUserMouseEntered

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        int getId = getVal(maxId);
        String id = idVal.getText();
        boolean ok = false;
        //getting variable name
        int pin = 0;
        String nameP = name.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        String date = sdf.format(dob.getDate());
        String bloodG = (String) bloodGp.getSelectedItem();
        String gMail = mail.getText();
        String phoneN = mob.getText();
        String dise = (String) dis.getSelectedItem();
        String discDis = disname.getText();
        String address = addr.getText();
        pin = Integer.parseInt(pinCode.getText());
        String gender = "";
        ok = true;
        if (male.isSelected() == true) {
            gender = "male";
        } else if (female.isSelected() == true) {
            gender = "female";
        } else if (other.isSelected() == true) {
            gender = "other";
        } else {
            ok = false;
        }
        //check all feilds
        String Query = "insert into hospital_management values(" + getId + ", '" + id + "', '" + nameP + "', '" + date + "', '" + bloodG + "', '" + gMail + "', '" + phoneN + "', '" + dise + "', '" + discDis + "', '" + address + "', " + pin + ", '" + gender + "', '" + getTime() + "', '" + getUserID() + "');";
        Execute(Query);

        //for printing
        //updating id value
        getId = getId + 1;
        String idp1 = "P01", ids2 = "", id2 = "";
        if (getId < 10) {
            ids2 = "000";
        } else if (getId < 100) {
            ids2 = "00";
        } else if (getId < 1000) {
            ids2 = "0";
        }
        id = idp1 + ids2 + getId;
        System.out.println("" + id);
        idVal.setText(id);
        JOptionPane.showMessageDialog(null, "Patient " + nameP + "'s Data added successfully...\n * * *");

        // print the receipt
        try {
            receipt.print();
        } catch (Exception e) {
        }

        //clear all feilds
        clear();
        editable(true);
        payment.setVisible(false);
        save.setVisible(false);
        receipt.setVisible(false);
    }//GEN-LAST:event_saveActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Do you want to back?", "* * * A L E R T * * *", JOptionPane.YES_NO_OPTION) == 0) {
            clear();
            headline.setText(" WELCOME");
            options.setVisible(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        save.setVisible(true);
        if (rec.isSelected()) {
            save.setText("P R I N T  &  S A V E");
            receipt.setVisible(true);
            receipt.setText(receipt());
        } else {
            save.setText("S A V E");
            receipt.setVisible(false);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleActionPerformed

    private void dobKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dobKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            mail.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            name.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_dobKeyPressed

    private void bloodGpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloodGpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bloodGpActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if ((!name.getText().trim().isEmpty()) || (!mail.getText().trim().isEmpty()) || (!mob.getText().trim().isEmpty())) {
            if (pinCode.getText().length() == 6) {
                payment.setVisible(true);
                editable(false);

            } else {
                JOptionPane.showMessageDialog(null, "Please enter pinCode properly..!");
                pinCode.requestFocus();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please fill the form properly..!");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void pinCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pinCodeKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        String s = pinCode.getText();
        if (s.length() > 5) {
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_pinCodeKeyTyped

    private void pinCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pinCodeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ((!name.getText().trim().isEmpty()) || (!mail.getText().trim().isEmpty()) || (!mob.getText().trim().isEmpty())) {
                if (pinCode.getText().length() == 6) {
                    payment.setVisible(true);
                    editable(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter pinCode properly..!");
                    pinCode.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please fill the form properly..!");
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            addr.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_pinCodeKeyPressed

    private void addrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addrKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            pinCode.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            disname.requestFocus();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_addrKeyPressed

    private void disnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_disnameKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            addr.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            mob.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_disnameKeyPressed

    private void disnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disnameActionPerformed

    private void disKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_disKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_disKeyPressed

    private void disFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_disFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_disFocusGained

    private void disActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_disActionPerformed

    private void disMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_disMouseReleased

    private void disMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_disMouseEntered

    private void disMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_disMouseClicked

    private void mobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        String s = mob.getText();
        if (s.length() > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_mobKeyTyped

    private void mobKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobKeyPressed
        boolean t;
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            t = true;
            if ((mob.getText().length() > 10) || (mob.getText().length() < 10)) {
                JOptionPane.showMessageDialog(null, "Please Enter a Valid Phone Number!");
                mob.setText("");
                t = false;
            }
            if (t == true) {
                disname.requestFocus();
            } else {
                mob.requestFocus();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            t = true;
            if ((mob.getText().length() > 10) || (mob.getText().length() < 10)) {
                JOptionPane.showMessageDialog(null, "Please Enter a Valid Phone Number!");
                mob.setText("");
                t = false;
            }
            if (t == true) {
                mail.requestFocus();
            } else {
                mob.requestFocus();
            }
        }
    }//GEN-LAST:event_mobKeyPressed

    private void mobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobActionPerformed

    private void mailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mailKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            mob.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            dob.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_mailKeyPressed

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_nameKeyTyped

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            dob.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_nameKeyPressed

    private void namePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_namePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_namePropertyChange

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Do you want to back?", "* * * A L E R T * * *", JOptionPane.YES_NO_OPTION) == 0) {
            clear();
            headline.setText(" WELCOME");
            options.setVisible(false);
        }   // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String s = search.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(location, username, password);
                String Query = "select * from hospital_management where full_id = '" + s + "';";

                Statement st = con.createStatement();
                rs = st.executeQuery(Query);

                rs.next();
                String name = rs.getString("name");
                String dob = rs.getString("date");
                String bloodG = rs.getString("blood_group");
                String mob = rs.getString("mob");
                String dis = rs.getString("dis");
                String pinC = String.valueOf(rs.getString("pincode"));
                String gender = rs.getString("gender");
                String date = rs.getString("visit_date");
                String by = rs.getString("added_By");

                switch (bloodG) {
                    case "A+":
                        bloodG_s.setSelectedIndex(0);
                        break;
                    case "A-":
                        bloodG_s.setSelectedIndex(1);
                        break;
                    case "B+":
                        bloodG_s.setSelectedIndex(2);
                        break;
                    case "B-":
                        bloodG_s.setSelectedIndex(3);
                        break;
                    case "O+":
                        bloodG_s.setSelectedIndex(4);
                        break;
                    case "O-":
                        bloodG_s.setSelectedIndex(5);
                        break;
                    case "AB+":
                        bloodG_s.setSelectedIndex(6);
                        break;
                    case "AB-":
                        bloodG_s.setSelectedIndex(7);
                        break;
                    default:
                        System.out.println("error");
                        break;

                }
                name_s.setText(name);
                date_s.setText(dob);
                mob_s.setText(mob);
                dis_s.setText(dis);
                pinCode_s.setText(pinC);
                gender_s.setText(gender);
                vdate_s.setText(date);
                byId.setText(by);
                edit.setEnabled(true);

            } catch (Exception e) {
                name_s.setText("");
                date_s.setText("");
                bloodG_s.setSelectedIndex(0);
                mob_s.setText("");
                dis_s.setText("");
                pinCode_s.setText("");
                gender_s.setText("");
                vdate_s.setText("");
                byId.setText("By");
                edit.setEnabled(false);
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Patient of ID " + s + " does not exist!");

            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new info().setVisible(true);
        setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addUser;
    private javax.swing.JTextField addr;
    private javax.swing.JComboBox bloodG_s;
    private javax.swing.JComboBox bloodGp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel byId;
    private javax.swing.JTextField date_s;
    private javax.swing.JComboBox dis;
    private javax.swing.JTextField dis_s;
    private javax.swing.JTextField disname;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JButton edit;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextField gender_s;
    private javax.swing.JLabel headline;
    private javax.swing.JLabel idVal;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logOut;
    private javax.swing.JTextField mail;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField mob;
    private javax.swing.JTextField mob_s;
    private javax.swing.JTextField name;
    private javax.swing.JTextField name_s;
    private javax.swing.JTabbedPane options;
    private javax.swing.JRadioButton other;
    private javax.swing.JPanel payment;
    private javax.swing.JTextField pinCode;
    private javax.swing.JTextField pinCode_s;
    private javax.swing.JCheckBox rec;
    private javax.swing.JTextArea receipt;
    private javax.swing.JButton save;
    private javax.swing.JTextField search;
    private javax.swing.JButton srch;
    private javax.swing.JLabel total;
    private javax.swing.JButton update;
    private javax.swing.JTextField vdate_s;
    // End of variables declaration//GEN-END:variables
}
