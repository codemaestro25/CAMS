package CollegeAdmissionSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton signIn, cancel;
    login(){
        super("Admin Login");
        setBounds(200,200,600,600);


        /*l1 = new JLabel("Username");
        l1.setBounds(90,45,100,40);
        l1.setFont(new Font("Serif", Font.BOLD,19));
        add(l1);*/

//        l2 = new JLabel("Password");
//        l2.setBounds(90,130,100,40);
//        l2.setFont(new Font("Serif", Font.BOLD,19));
//        add(l2);

        //textfields
        t1 = new JTextField();
        t1.setFont(new Font("Times New Roman", Font.PLAIN,19));
        t1.setBounds(200,270,180,40);
        add(t1);

        p1 = new JPasswordField();
        p1.setBounds(200,400,180,40);
        add(p1);

        signIn = new JButton();
        signIn.setBounds(200,480,180,60);
        signIn.setContentAreaFilled(false);
        signIn.setBorder(null);
        signIn.setBackground(null);
        signIn.addActionListener(this);
        add(signIn);

//        cancel = new JButton("Cancel");
//        cancel.setBounds(350,220,110,60);
//        cancel.addActionListener(this);
//        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/username.png"));
        Image i2 =i1.getImage().getScaledInstance(600,600, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0,0,600,600);
        add(l2);

        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==signIn){
            String username = t1.getText();
            String password = String.valueOf(p1.getPassword());
            conn c = new conn();
            String str = "Select * from adminlogin where usernameAdmin='"+username+"'and passAdmin='"+password+"'";
            try{
                ResultSet rs = c.s.executeQuery(str);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Login credentials Validated");
                    new adminHome().setVisible(true);
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Login credentials!");
                }
            }catch (Exception e){
                System.out.println(e);
                e.printStackTrace();
            }
        }
        if (ae.getSource()==cancel){
           int b = JOptionPane.showConfirmDialog(null,"Are Sure to Exit?");
                   if(b==0){
                       System.exit(0);
                   }
        }
    }

    public static void main(String[] args) {
        new login();

    }

}
