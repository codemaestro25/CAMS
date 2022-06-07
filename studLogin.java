package CollegeAdmissionSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class studLogin extends JFrame implements ActionListener {
    public static int sesId;
    public static String rName, rDob, rAadhar;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton signIn, cancel;
    studLogin(){
        super("Student Login");
        setBounds(200,200,600,600);


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
            String str = "Select * from studlogin where studUsername='"+username+"'and studPass='"+password+"'";
            try{
                ResultSet rs = c.s.executeQuery(str);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Login credentials Validated");
                    String str1 = "Select id from studlogin where studUsername='"+username+"'and studPass='"+password+"'";
                    ResultSet rs1 = c.s.executeQuery(str1);
                    if(rs1.next()){                 //fetching the id of the respective login
                        sesId=rs1.getInt("id");
                        System.out.println(sesId);
//                        String str3 = "INSERT INTO files (fid) VALUES('"+sesId+"');";
//                        c.s.executeUpdate(str3);
                    }
                    String str2 = "Select name, dob, aadhar from studentdetails where id = '"+studLogin.sesId+"'";
                        ResultSet rs2 = c.s.executeQuery(str2);
                        while(rs2.next()) {
                            rName = rs2.getString("name");
                            rDob = rs2.getString("dob");
                            rAadhar=rs2.getString("aadhar");
                        }
                    new Main().setVisible(true);
                    this.setVisible(false);

                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Login credentials!");
                }
            }catch (Exception e){
                System.out.println(e);
                //e.printStackTrace();
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
        new studLogin();
    }

}
