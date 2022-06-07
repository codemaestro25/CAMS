package CollegeAdmissionSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class declareResults extends JFrame implements ActionListener {
    //public static boolean resultDeclared= false;
    JButton result, retrieve;
    declareResults(){
        setSize(600,300);

        result = new JButton("DECLARE RESULT");
        result.setBounds(70,60,200,70);
        result.addActionListener(this);
        add(result);

        retrieve = new JButton("RETRIEVE RESULT");
        retrieve.setBounds(320,60,200,70);
        retrieve.addActionListener(this);
        add(retrieve);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/bg6.png"));
        Image i5 =i4.getImage().getScaledInstance(600,300, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l3 = new JLabel(i6);
        l3.setBounds(0,0,600,300);
        add(l3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
//    select str_id, name, cutoff
//    from streams
//    where cutoff < (select hscScore from studentdetails where id = 100001);

//    select str_id, name, cutoff
//    from streams
//    where ((cutoff < (select hscScore from studentdetails where id = 100001))AND ((str_id = 3)OR(str_id = 4)));
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == result) {
            try {
                conn c = new conn();
                String str1 = "update adminlogin set result = '1' where usernameAdmin = '2512'";
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"RESULT DECLARED SUCCESSFULLY!!!");
                //resultDeclared=true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if(ae.getSource()==retrieve){
            try {
                conn c = new conn();
                String str2 = "update adminlogin set result = '0' where usernameAdmin = '2512'";
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"RESULT RETRIEVED SUCCESSFULLY!!!");
                //resultDeclared=true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
public static void main(String[] args) {
    new declareResults();
}
}
