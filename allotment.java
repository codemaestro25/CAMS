package CollegeAdmissionSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class allotment extends JFrame  implements ActionListener {

    JLabel l1, l2, l3 , l4 , l5 , l6 , l7 , l8, l9, l10 ,la1, la2, la3, la4, la5, la6, la7, la8, la9, la10;
    JButton b1 , back;
    allotment(){
        setSize(600,800);

        l1 = new JLabel("Alloted Stream Name");
        l1.setBounds(60,60,150,40);
        add(l1);

        la1 = new JLabel("hey");
        la1.setBounds(280,60,180,40);
        la1.setText(confirmation.strName);
        add(la1);

        l2 = new JLabel("Stream ID");
        l2.setBounds(60,120,100,40);
        add(l2);

        la2 = new JLabel("hey");
        la2.setBounds(280,120,100,40);
        la2.setText(confirmation.strId);
        add(la2);

        l3 = new JLabel("HSC Score");
        l3.setBounds(60,180,100,40);
        add(l3);

        la3 = new JLabel("hey");
        la3.setBounds(280,180,180,40);
        la3.setText(displayStudentList.hscscore);
        add(la3);

        l4 = new JLabel("Enrollment ID");
        l4.setBounds(60,240,100,40);
        add(l4);

        la4 = new JLabel("hey");
        la4.setBounds(280,240,100,40);
        la4.setText(String.valueOf(studLogin.sesId));
        add(la4);

        l5 = new JLabel("Stream Cutoff");
        l5.setBounds(60,300,150,40);
        add(l5);

        la5 = new JLabel("hey");
        la5.setBounds(280,300,180,40);
        la5.setText(confirmation.strCutoff);
        add(la5);

        l6 = new JLabel("Stream Fees");
        l6.setBounds(60,360,100,40);
        add(l6);

        la6 = new JLabel("hey");
        la6.setBounds(280,360,100,40);
        la6.setText(confirmation.strFees);
        add(la6);

        b1 = new JButton("Confirm Allotment");
        b1.setBounds(180,450,150,80);
        b1.addActionListener(this);
        add(b1);

//        la6 = new JLabel("hey");
//        la6.setBounds(280,360,100,40);
//        la6.setText(displayStudentList.college);
//        add(la6);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/bg2.png"));
        Image i5 =i4.getImage().getScaledInstance(600,800, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l3 = new JLabel(i6);
        l3.setBounds(0,0,600,800);
        add(l3);


        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            int b = JOptionPane.showConfirmDialog(null, "Are Sure to Choose the Alloted Course?");
            if (b == 0) {
                try {
                    conn c = new conn();
                    String str1 = "update studentdetails set stream = '"+confirmation.strName+"' where id = '"+studLogin.sesId+"'";
                    System.out.println(confirmation.strName);
                    c.s.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null, "Admission Confirmed !");
                    this.setVisible(false);
                    new confirmation().setVisible(false);
                    new Main().setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }

            }
        }
    }

    public static void main(String[] args) {
        new allotment();
    }
}
