package CollegeAdmissionSystem;

import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class cutoffs extends JFrame implements  ActionListener{
    JButton b1,b2,b3,back;
    cutoffs(){
        setSize(500,400);

        b1 = new JButton("Add Stream");
        b1.setBounds(50,125,150,80);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Set Cutoffs");
        b2.setBounds(300,125,150,80);
        b2.addActionListener(this);
        add(b2);
//        b3 = new JButton("Show Streams");
//        b3.setBounds(50,200,150,50);
//        b3.addActionListener(this);
//        add(b3);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(70,40, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        back=new JButton(i3);
        back.setBounds(5,5,50,50);
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/bg6.png"));
        Image i5 =i4.getImage().getScaledInstance(1000,600, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l3 = new JLabel(i6);
        l3.setBounds(0,0,1000,600);
        add(l3);

        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);




    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new AddStream().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource()==b2){
            new cutoffList().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource()==back){
            new adminHome().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new cutoffs();
    }



}
