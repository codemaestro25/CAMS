package CollegeAdmissionSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class displayStudentList extends JFrame implements ActionListener {
    public static int row;
    public static String name;
    public static String id;
    public static String dob;
    public static String gender;
    public static String hscscore;
    public static String aadhar;
    public static String email;
    public static String contact;
    public static String college;
    JTable t1;
    JScrollPane sp1;
    JPanel contentPane;
    JTextField tf1;
    JButton b1, back;

    public void list1(){
        try{
            conn c = new conn();
            String str1 ="select * from studentdetails";
            ResultSet rs = c.s.executeQuery(str1);

            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.println(e);
        }
    }


    displayStudentList() {
        //setSize(1000, 800);
        setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        contentPane = new JPanel();
        contentPane.setBackground(Color.lightGray);
        setContentPane(contentPane);
        contentPane.setLayout(null);


        sp1 = new JScrollPane();
        sp1.setBounds(80, 60, 1350, 350);
//        setLayout(null);
//        setVisible(true);
        contentPane.add(sp1);



        t1= new JTable();
        t1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = t1.getSelectedRow();
                System.out.println(row);
                name = t1.getModel().getValueAt(row, 0).toString();
                id = t1.getModel().getValueAt(row, 6).toString();
                dob = t1.getModel().getValueAt(row, 1).toString();
                email= t1.getModel().getValueAt(row, 2).toString();
                gender= t1.getModel().getValueAt(row, 3).toString();
                aadhar= t1.getModel().getValueAt(row, 4).toString();
                contact= t1.getModel().getValueAt(row, 5).toString();
                //college = t1.getModel().getValueAt(row,7).toString();
                hscscore= t1.getModel().getValueAt(row, 8).toString();
                new displayStudentDetails().setVisible(true);
            }
        });
        sp1.setViewportView(t1);
        list1();

        tf1 = new JTextField();
        tf1.setBounds(500,700,100,40);
        tf1.setVisible(true);
        sp1.add(tf1);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(70,40, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        back=new JButton(i3);
        back.setBounds(5,5,50,50);
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/bg7.png"));
        Image i5 =i4.getImage().getScaledInstance(1550,900, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l3 = new JLabel(i6);
        l3.setBounds(0,0,1550,900);
        add(l3);

        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            new adminHome().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new displayStudentList();
    }
}