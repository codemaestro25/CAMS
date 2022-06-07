package CollegeAdmissionSystem;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class confirmation extends JFrame implements ActionListener {

    JButton b1,b2, back;
    JTable t;
    JPanel contentPane;
    int ch1,ch2,ch3,ch4,ch5,ch6, row;
    public static String strName, strFees, strCutoff, strId;

    confirmation()
    {
        setSize(900,900);

        contentPane = new JPanel();
        contentPane.setBackground(Color.lightGray);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        b1= new JButton("CONFIRM");
        b1.setBounds(100,550,220,40);
        b1.setFont(new Font("SEGIO",Font.PLAIN,20));
        b1.addActionListener(this);
        add(b1);

        b2= new JButton("WAIT FOR NEXT ROUND");
        b2.setBounds(500,550,300,40);
        b2.setFont(new Font("SEGIO",Font.PLAIN,20));
        b2.addActionListener(this);
        add(b2);

        JScrollPane pane = new JScrollPane(t);
        pane.setBounds(100,50,600,400);
        setLayout(null);
        setVisible(true);
        contentPane.add(pane);

        t=new JTable();
        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = t.getSelectedRow();
                strName = t.getModel().getValueAt(row,1).toString();
                strCutoff = t.getModel().getValueAt(row,2).toString();
                strId = t.getModel().getValueAt(row,0).toString();
                strFees = t.getModel().getValueAt(row,3).toString();


            }
        });
        t.setFont(new Font("SEGIO",Font.PLAIN,18));
        //
        // add(new JScrollPane(t));
//        t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        pane.setViewportView(t);
        //BLOCK FOR IMPORTING THE STUDENT CHOICES

        try{
            conn c = new conn();
            String str2 = "select * from selectstreams where stud_id='100001'";
            ResultSet rs2 = c.s.executeQuery(str2);
            while(rs2.next()){
                ch1 = rs2.getInt("ch1");
                ch2 = rs2.getInt("ch2");
                ch3 = rs2.getInt("ch3");
                ch4 = rs2.getInt("ch4");
                ch5 = rs2.getInt("ch5");
                ch6 = rs2.getInt("ch6");

                System.out.println(ch1);
                System.out.println(ch2);
                System.out.println(ch3);
                System.out.println(ch4);


            }
        }catch (Exception e){
            System.out.println(e);

        }



        //BLOCK FOR DECLARING RESULTS
        try{
          conn c = new conn();
          String str1 = "select * from streams where ((cutoff < (select hscScore from studentdetails where id = 100001))AND ((str_id = '"+ch1+"')OR(str_id = '"+ch2+"')OR(str_id = '"+ch3+"')OR(str_id = '"+ch4+"')OR(str_id = '"+ch5+"')OR(str_id = '"+ch6+"')));";
          ResultSet rs = c.s.executeQuery(str1);
          t.setModel(DbUtils.resultSetToTableModel(rs));


        }catch (Exception e){
            System.out.println(e);
        }



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(70,40, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        back=new JButton(i3);
        back.setBounds(5,5,50,50);
        back.addActionListener(this);
        contentPane.add(back);

        setLayout(null);
        setVisible(true);




    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new allotment().setVisible(true);

        }
        if(ae.getSource()==b2){
            int b = JOptionPane.showConfirmDialog(null, "Are Sure to Wait for the next round");
            if (b == 0) {
                this.setVisible(true);
                new selectCourses().setVisible(true);
            }
        }
        if(ae.getSource()==back){
            new Main().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String args[])
    {
        new confirmation();
    }
}

