package CollegeAdmissionSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class displayStudentDetails extends JFrame implements ActionListener {
    JButton back;
    JLabel l1, l2, l3 , l4 , l5 , l6 , l7 , l8, l9, l10 ,la1, la2, la3, la4, la5, la6, la7, la8, la9, la10;

    displayStudentDetails(){
        setSize(500,700);

        l1 = new JLabel("Name");
        l1.setBounds(60,60,100,40);
        add(l1);

        la1 = new JLabel("hey");
        la1.setBounds(280,60,180,40);
        la1.setText(displayStudentList.name);
        add(la1);

        l2 = new JLabel("Process ID");
        l2.setBounds(60,120,100,40);
        add(l2);

        la2 = new JLabel("hey");
        la2.setBounds(280,120,100,40);
        la2.setText(displayStudentList.id);
        add(la2);

        l3 = new JLabel("HSC Score");
        l3.setBounds(60,180,100,40);
        add(l3);

        la3 = new JLabel("hey");
        la3.setBounds(280,180,180,40);
        la3.setText(displayStudentList.hscscore);
        add(la3);

        l4 = new JLabel("Aadhar");
        l4.setBounds(60,240,100,40);
        add(l4);

        la4 = new JLabel("hey");
        la4.setBounds(280,240,100,40);
        la4.setText(displayStudentList.aadhar);
        add(la4);

        l5 = new JLabel("E-Mail");
        l5.setBounds(60,300,150,40);
        add(l5);

        la5 = new JLabel("hey");
        la5.setBounds(280,300,180,40);
        la5.setText(displayStudentList.email);
        add(la5);
        
        l6 = new JLabel("College Name");
        l6.setBounds(60,360,100,40);
        add(l6);

        la6 = new JLabel("hey");
        la6.setBounds(280,360,100,40);
        la6.setText(displayStudentList.college);
        add(la6);

        l7 = new JLabel("Gender");
        l7.setBounds(60,420,100,40);
        add(l7);

        la7 = new JLabel("hey");
        la7.setBounds(280,420,100,40);
        la7.setText(displayStudentList.gender);
        add(la7);

        l8 = new JLabel("Date of Birth");
        l8.setBounds(60,480,100,40);
        add(l8);

        la8 = new JLabel("hey");
        la8.setBounds(280,480,100,40);
        la8.setText(displayStudentList.dob);
        add(la8);

        l9 = new JLabel("Contact Number");
        l9.setBounds(60,540,100,40);
        add(l9);

        la9 = new JLabel("hey");
        la9.setBounds(280,540,100,40);
        la9.setText(displayStudentList.contact);
        add(la9);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(70,40, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        back=new JButton(i3);
        back.setBounds(5,5,50,50);
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/bg2.png"));
        Image i5 =i4.getImage().getScaledInstance(500,700, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l3 = new JLabel(i6);
        l3.setBounds(0,0,500,700);
        add(l3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){

            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new displayStudentDetails();
    }
}
