package CollegeAdmissionSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class studentSignUp extends JFrame implements ActionListener {
    JDateChooser DOB;
    ButtonGroup b1;
    JRadioButton r1,r2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField name,email,aadhar,contact,username, password;
    JButton submit;
    JButton back;
    JButton home;
    public boolean bA, bC;
    int jbtnW=100;
    int jbtnh=40;
    int txtW = 180;
    int txtH = 40;
    studentSignUp(){
        setBounds(400,20,550,620);//frame dimensions

        l1=new JLabel("Name");
        l1.setBounds(40,40,jbtnW,jbtnh);
        l1.setFont(new Font("SEGIO",Font.BOLD,14));
        l1.setForeground(Color.BLACK);
        add(l1);

        l2=new JLabel("D.O.B");
        l2.setBounds(40,90,jbtnW,jbtnh);
        l2.setFont(new Font("SEGIO",Font.BOLD,14));
        l2.setForeground(Color.BLACK);
        add(l2);

        l3=new JLabel("Email-ID");
        l3.setBounds(40,140,jbtnW,jbtnh);
        l3.setFont(new Font("SEGIO",Font.BOLD,14));
        l3.setForeground(Color.BLACK);
        add(l3);

        l4=new JLabel("Gender");
        l4.setBounds(40,190,jbtnW,jbtnh);
        l4.setFont(new Font("SEGIO",Font.BOLD,14));
        l4.setForeground(Color.BLACK);
        add(l4);

        l5=new JLabel("Aadhar");
        l5.setBounds(40,240,jbtnW,jbtnh);
        l5.setFont(new Font("SEGIO",Font.BOLD,14));
        l5.setForeground(Color.BLACK);
        add(l5);

        l6=new JLabel("Contact");
        l6.setBounds(40,290,jbtnW,jbtnh);
        l6.setFont(new Font("SEGIO",Font.BOLD,14));
        l6.setForeground(Color.BLACK);
        add(l6);

        l7=new JLabel("Username");
        l7.setBounds(40,340,jbtnW,jbtnh);
        l7.setFont(new Font("SEGIO",Font.BOLD,14));
        l7.setForeground(Color.BLACK);
        add(l7);

        l8=new JLabel("Password");
        l8.setBounds(40,390,jbtnW,jbtnh);
        l8.setFont(new Font("SEGIO",Font.BOLD,14));
        l8.setForeground(Color.BLACK);
        add(l8);

        // text field
        name= new JTextField();
        name.setBounds(175,40,txtW,txtH);
        add(name);

        DOB = new JDateChooser();
        DOB.setBounds(175,90,txtW,txtH);
        add(DOB);

        email= new JTextField();
        email.setBounds(175,140,txtW,txtH);
        add(email);

        b1 = new ButtonGroup(); // creationg a button group for radio buttons to make only one selection at a time


        r1 = new JRadioButton("Male");
        r1.setBounds(175,190,80,40);
        b1.add(r1);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(255,190,80,40);
        b1.add(r2);
        add(r2);

        aadhar= new JTextField();
        aadhar.setBounds(175,240,txtW,txtH);
        add(aadhar);

        contact= new JTextField();
        contact.setBounds(175,290,txtW,txtH);
        add(contact);

        username= new JTextField();
        username.setBounds(175,340,txtW,txtH);
        add(username);

        password = new JTextField();
        password.setBounds(175,390 , txtW,txtH);
        add(password);


        submit=new JButton("Sign UP");
        submit.setBounds(250,460,100,70);
        submit.addActionListener(this);
        add(submit);

        //back button
//        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
//        Image i12 = i11.getImage().getScaledInstance(60,30, Image.SCALE_SMOOTH);
//        ImageIcon i13 = new ImageIcon(i12);
//        back=new JButton(i13);
//        back.setBounds(5,5,35,35);
//
//        //dasboard button
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/home.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);
//        ImageIcon i3 = new ImageIcon(i2);
//        home=new JButton(i3);
//        home.setBounds(490,5,35,30);
//        home.addActionListener(this);
//        add(home);

//        back.addActionListener(this);
//        add(back);
//
//        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/b9.jpg"));
//        Image i5 = i4.getImage().getScaledInstance(600,700, Image.SCALE_SMOOTH);
//        ImageIcon i6= new ImageIcon(i5);
//        JLabel j1 = new JLabel(i6);
//        j1.setBounds(1,1,600,700);
//        add(j1);
 
        setLayout(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit) {
            String aadhar = this.aadhar.getText();
            if (aadhar.length() != 12) {
                JOptionPane.showMessageDialog(null, "Enter 12 digit aadhar number");
                bA = false;
            } else {
                bA = true;
            }
            String contact = this.contact.getText();
            if (contact.length() != 10) {
                JOptionPane.showMessageDialog(null, "Enter 10 digit Mobile number");
                bC = false;
            } else {
                bC = true;
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String dob = dateFormat.format(DOB.getDate());

            String gender = null;
            if (r1.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            String name = this.name.getText();
            String username = this.username.getText();
            String password = this.password.getText();
            String email = this.email.getText();


            if (bA & bC) {
                conn c = new conn();
                String str1 = "insert into studentdetails (name, dob, email, gender, aadhar, contact) values('" + name + "','" + dob + "','" + email + "','" + gender + "','" + aadhar + "','" + contact + "')";
                String str2 = "insert into studlogin (studUsername, studPass) values('" + username + "','" + password + "')";//storing login crednetails in logindetails table
                // storing id in the files table
                try {
                    c.s.executeUpdate(str1);
                    c.s.executeUpdate(str2);

                    JOptionPane.showMessageDialog(null, "Signed up Successfully");
                    this.name.setText(null);
                    this.email.setText(null);
                    this.username.setText(null);
                    this.contact.setText(null);
                    this.aadhar.setText(null);
                    this.password.setText(null);
                    this.r1.setSelected(false);
                    this.r2.setSelected(false);

                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println(dob);
                }

            }
        }



        }


    public static void main(String[] args) {
        new studentSignUp();
    }
}
