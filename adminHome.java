package CollegeAdmissionSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminHome extends JFrame implements ActionListener {
    JMenuBar menu;
    JMenu scrutiny, cutoff, lists, settings;
    JMenuItem scrList, cutoffSettings, appStuList, results;
    adminHome(){
        setSize(800,400);
        Rectangle r = (this.getBounds());
        int w= (int) r.getWidth();
        int h = (int) r.getHeight();
        System.out.println(h);

        menu = new JMenuBar();
        menu.setLayout(new GridLayout(0,1));
        menu.setBounds(0,0,180,380);
        menu.setBackground(new Color(255,237,105));
        add(menu);

        scrutiny = new JMenu("Scrutiny");
        scrList = new JMenuItem("Scrutiny List");
        scrutiny.add(scrList);
        scrList.addActionListener(this);


        cutoff = new JMenu("Cutoffs");
        cutoffSettings = new JMenuItem("Cutoffs & Courses");
        cutoff.add(cutoffSettings);
        cutoffSettings.addActionListener(this);

        lists = new JMenu("Lists");
        appStuList= new JMenuItem("Applied Students List");
        lists.add(appStuList);
        appStuList.addActionListener(this);

        settings = new JMenu("Settings");
        JMenuItem profSetting = new JMenuItem("Profile Settings");
        results = new JMenuItem("Declare/Retrieve Results");
        results.addActionListener(this);
        settings.add(results);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/bg5.png"));
        Image i2 =i1.getImage().getScaledInstance(600,600, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(180,0,600,600);
        add(l2);


        settings.add(profSetting);

        add(menu);
        //menu.add(scrutiny);
        menu.add(cutoff);
        menu.add(lists);
        menu.add(settings);






        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Scrutiny List")){
                       new scrutinyList().setVisible(true);
        }

        if(ae.getActionCommand().equals("Cutoffs & Courses")){
            new cutoffs().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getActionCommand().equals("Applied Students List")){
            new displayStudentList().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getActionCommand().equals("Declare/Retrieve Results")){
            new declareResults().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new adminHome();
    }
}
