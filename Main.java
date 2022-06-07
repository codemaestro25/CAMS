package CollegeAdmissionSystem;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.sql.ResultSet;

public class Main extends JFrame implements ActionListener{
    JMenuBar m1;
    JMenu Profile, Result, Settings, choices;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JPanel p1;
    int result;

    Main(){
        setBounds(150,50,1000,600);

        JLabel label= new JLabel();
        label.setText("Notice Board");
        label.setForeground(Color.RED);
        //label.setBackground(new Color());
        m1 = new JMenuBar();
        m1.setLayout(new GridLayout(0,1));
        //m1.setBackground(Color.BLACK);
        m1.setBackground(new Color(11,51,92));
        //m1.setBackground(37,159,161)
        m1.setBounds(0,0,150,600);

        Profile = new JMenu("Profile");
        Profile.setForeground(Color.WHITE);
        JMenuItem ap = new JMenuItem("Add Details");
        ap.addActionListener(this);
        //JMenuItem up = new JMenuItem("Update Profile");


        Result = new JMenu("Result");
        Result.setForeground(Color.WHITE);
        JMenuItem cr = new JMenuItem("Check Result");
        cr.addActionListener(this);
        //JMenuItem dml = new JMenuItem("Display Merit list");

        choices = new JMenu("Choices");
        choices.setForeground(Color.WHITE);
        JMenuItem fillChoices = new JMenuItem("Fill Choices");
        fillChoices.addActionListener(this);


        Settings = new JMenu("Settings");
        Settings.setForeground(Color.WHITE);

        add(m1);
        m1.add(Profile);
        m1.add(Result);
        m1.add(choices);
        m1.add(Settings);

        Profile.add(ap);
        //Profile.add(up);

        Result.add(cr);
        //Result.add(dml);

        choices.add(fillChoices);

        l1 = new JLabel("NAME               :");
        l1.setFont(new Font("SEIGO",Font.BOLD,20));
        l1.setBounds(250,75,150,100);
        l1.setForeground(Color.BLACK);

        add(l1);

        l2 = new JLabel("DOB                 :");
        l2.setFont(new Font("SEIGO",Font.BOLD,20));
        l2.setBounds(250,125,150,100);
        l2.setForeground(Color.BLACK);
        add(l2);

        l3 = new JLabel("ID                      :");
        l3.setFont(new Font("SEIGO",Font.BOLD,20));
        l3.setBounds(250,175,150,100);
        l3.setForeground(Color.black);
        add(l3);

        l4 = new JLabel("Mobile no.       :");
        l4.setFont(new Font("SEIGO",Font.BOLD,20));
        l4.setBounds(250,225,150,100);
        l4.setForeground(Color.BLACK);
        add(l4);

        l5 = new JLabel("HSC Marks      :");
        l5.setFont(new Font("SEIGO",Font.BOLD,20));
        l5.setBounds(250,275,150,100);
        l5.setForeground(Color.BLACK);
        add(l5);

        l6 = new JLabel(studLogin.rName);
        l6.setFont(new Font("SEIGO",Font.BOLD,16));
        l6.setBounds(450,75,200,100);
        l6.setForeground(Color.BLACK);
        add(l6);

        l7 = new JLabel(studLogin.rDob);
        l7.setFont(new Font("SEIGO",Font.BOLD,20));
        l7.setBounds(450,125,150,100);
        l7.setForeground(Color.BLACK);
        add(l7);

        l8 = new JLabel(String.valueOf(studLogin.sesId));
        l8.setFont(new Font("SEIGO",Font.BOLD,20));
        l8.setBounds(450,175,150,100);
        l8.setForeground(Color.BLACK);
        add(l8);

        l9 = new JLabel("9876543210");
        l9.setBounds(450,225,150,100);
        l9.setFont(new Font("SEIGO",Font.BOLD,18));
        l9.setForeground(Color.BLACK);
        add(l9);

        l10= new JLabel("100%");
        l10.setBounds(450,275,150,100);
        l10.setFont(new Font("SEIGO",Font.BOLD,18));
        l10.setForeground(Color.BLACK);
        add(l10);

        p1 = new JPanel();
        p1.setBounds(750,75,200,350);
        p1.setBackground(Color.orange);
        p1.add(label);
        add(p1);
        try{
            conn c = new conn();
            String str1 = "select * from adminlogin  where usernameAdmin = '2512'";
            ResultSet rs = c.s.executeQuery(str1);
            while(rs.next()){
                result = rs.getInt("result");
                System.out.println(result);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/bg2.png"));
        Image i2 =i1.getImage().getScaledInstance(1000,600, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0,0,1000,600);
        add(l2);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Details")){
            new addProfileData().setVisible(true);
        }
        if(ae.getActionCommand().equals("Check Result")){
            if(result==0) {
                JOptionPane.showMessageDialog(null,"Result is not yet declared");
            }

             else if(result==1){
                new confirmation().setVisible(true);
                this.setVisible(false);
            }
             else{
                 JOptionPane.showMessageDialog(null,"System Error");
            }
        }
        if(ae.getActionCommand().equals("Choose Courses")){
            new selectCourses().setVisible(true);
        }
        if (ae.getActionCommand().equals("Fill Choices")){
            new selectCourses().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Main();

    }
}