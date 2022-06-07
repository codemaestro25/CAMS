package CollegeAdmissionSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class start extends JFrame implements ActionListener {
    JButton admin , studSignUp, studLogin, back;
    start(){
        setBounds(350,100,800,800);
        admin = new JButton();
        admin.setBounds(280,450,250,50);
        admin.setBackground(null);
        admin.setBorder(null);
        admin.setContentAreaFilled(false);
        admin.addActionListener(this);
        add(admin);

        studSignUp = new JButton();
        studSignUp.setBounds(310,680,230,60);
        //studSignUp.setForeground(new Color(177,128,0));
        studSignUp.setBackground(null);
        studSignUp.setBorder(null);
        studSignUp.setContentAreaFilled(false);
        studSignUp.addActionListener(this);
        add(studSignUp);

        studLogin = new JButton();
        studLogin.setBounds(280,530,240,55);
        studLogin.setBackground(null);
        studLogin.setBorder(null);
       studLogin.setContentAreaFilled(false);
        studLogin.addActionListener(this);
        add(studLogin);


        /*JLabel l1 = new JLabel("College Admission System");
        l1.setBounds(100,100,500,150);
        l1.setFont(new Font("Tahoma", Font.BOLD, 36));
        l1.setForeground(Color.WHITE);
        add(l1);*/

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/clg.png"));
        Image i2 =i1.getImage().getScaledInstance(800,800, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0,0,800,800);
        add(l2);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
        Image i5 = i4.getImage().getScaledInstance(70,40, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        back=new JButton(i6);
        back.setBounds(5,5,50,50);
        back.addActionListener(this);
        add(back);


        setLayout(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==admin){
            new login().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource()==studSignUp){
            new studentSignUp().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource()==studLogin){
            new studLogin().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource()==back){
            new start().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new start();
    }
}
