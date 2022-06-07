package CollegeAdmissionSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;

public class addProfileData extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16;
    JTextField cetScore, hscScore, address, school, pNumber;
    JButton back ,bHscResult, next1, next2, bPhoto, bAadhar, bCasteCert, bLeavingCert, submit;
    JPanel pn;
    JTabbedPane tabs;
    JComboBox course1, course2, caste;
    ButtonGroup b1;
    JRadioButton pcm, pcb;
    int lw = 150, lh = 80, font = 16, th = 40;

    addProfileData() {
        setSize(1200, 800);
        setLocationRelativeTo(null);
        Container c = this.getContentPane();

        pn = new JPanel();
        pn.setBounds(80, 80, 1100, 100);
        pn.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        pn.setBackground(new Color(222,158,220));
        c.add(pn);

        l1 = new JLabel("Name: " + studLogin.rName);
        l1.setBounds(100, 50, lw, lh);
        l1.setFont(new Font("Tahoma", Font.BOLD, font));
        pn.add(l1);

        l2 = new JLabel("DOB: " + studLogin.rDob);
        l2.setBounds(700, 50, lw, lh);
        l2.setFont(new Font("Tahoma", Font.BOLD, font));
        pn.add(l2);

        l3 = new JLabel("ID = " + studLogin.sesId);
        l3.setBounds(400, 50, lw, lh);
        l3.setFont(new Font("Tahoma", Font.BOLD, font));
        pn.add(l3);

        l4 = new JLabel("Aadhar = " + studLogin.rAadhar);
        l4.setBounds(1100, 50, lw, lh);
        l4.setFont(new Font("Tahoma", Font.BOLD, font));
        pn.add(l4);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        JPanel p3 = new JPanel();
        p3.setLayout(null);
        JPanel p4 = new JPanel();
        p4.setLayout(null);

        //panel p2 contents


//        l5 = new JLabel("CET Score");
//        l5.setBounds(20, 50, lw, 40);
//        p2.add(l5);
//
//        cetScore = new JTextField();
//        // cetScore.setFont(new Font("Tahoma",Font.PLAIN,font));
//        cetScore.setBounds(200, 50, lw, 40);
//        p2.add(cetScore);

        l6 = new JLabel("HSC Score");
        l6.setBounds(520, 70, lw, 40);
        p2.add(l6);

        hscScore = new JTextField();
        hscScore.setBounds(700, 70, lw, 40);
        p2.add(hscScore);

        l7 = new JLabel("HSC Result ");
        l7.setBounds(30, 70, lw, 40);
        p2.add(l7);

        bHscResult = new JButton("Upload File");
        bHscResult.setBounds(200, 70, 180, 30);
        bHscResult.addActionListener(this);
        p2.add(bHscResult);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/bg3.png"));
        Image i5 =i4.getImage().getScaledInstance(1500,900, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l3 = new JLabel(i6);
        l3.setBounds(0,0,1500,900);
        add(l3);

//        l8 = new JLabel("HSC Result ");
//        l8.setBounds(530,160,lw,40);
//        p2.add(l8);
//
//        hscResult = new JButton("Upload File");
//        hscResult.setBounds(720,160,180,30);
//
//        p2.add(hscResult);

//        b1 = new ButtonGroup();
//
//        pcm = new JRadioButton("PCM");
//        pcm.setBounds(950, 50, 80, 40);
//        pcm.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                course1.setVisible(true);
//                course2.setVisible(false);
//            }
//        });
//        b1.add(pcm);
//        p2.add(pcm);

//        pcb = new JRadioButton("PCB");
//        pcb.setBounds(1050, 50, 80, 40);
//        pcb.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                course2.setVisible(true);
//                course1.setVisible(false);
//            }
//        });
//        b1.add(pcb);
//        p2.add(pcb);


//        String pcmCourse[] = {"B.Tech/B.E", "BSc", "B.Arch", "B.Agriculture"};
//        course1 = new JComboBox(pcmCourse);
//        course1.setBounds(530, 160, 170, 30);
//        p2.add(course1);
//        //course2.setVisible(false);
//        course1.setVisible(false);


//        String pcbCourse[] = {"B.Pharm", "B.Ayurved", "B.Chem"};
//        course2 = new JComboBox(pcbCourse);
//        course2.setBounds(530, 160, 170, 30);
//        p2.add(course2);
//        course2.setVisible(false);


        next1 = new JButton("Next");
        next1.setBounds(500, 280, 100, 50);
        next1.addActionListener(this);
        p2.add(next1);
//End of CET Details tab

        //Personal Details tab
        l8 = new JLabel("Address");
        l8.setBounds(30, 50, lw, 40);
        p3.add(l8);

        address = new JTextField();
        address.setBounds(150, 50, 700, 30);
        p3.add(address);

        l9 = new JLabel("School Name ");
        l9.setBounds(30, 120, lw, 40);
        p3.add(l9);

        school = new JTextField();
        school.setBounds(160, 120, 150, 30);
        p3.add(school);

        l10 = new JLabel("Parents Mobile Number ");
        l10.setBounds(400, 120, lw, 40);
        p3.add(l10);

        pNumber = new JTextField();
        pNumber.setBounds(600, 120, 150, 30);
        p3.add(pNumber);

        l11 = new JLabel("Caste");
        l11.setBounds(850, 120, lw, 40);
        p3.add(l11);

        String caste1[] = {"General", "OBC", "SC", "ST", "VJNT", "EBC/EWS/SEBC"};
        caste = new JComboBox(caste1);
        caste.setBounds(920, 120, 150, 30);
        p3.add(caste);

        l12 = new JLabel("Photo");
        l12.setBounds(230, 250, lw, 40);
        p3.add(l12);

        bPhoto = new JButton("Upload Photo");
        bPhoto.setBounds(320, 250, 150, 30);
        bPhoto.addActionListener(this);
        p3.add(bPhoto);

        l13 = new JLabel("Aadhar ");
        l13.setBounds(600, 250, lw, 40);
        p3.add(l13);

        bAadhar = new JButton("Upload Aadhar");
        bAadhar.setBounds(680, 250, 150, 30);
        bAadhar.addActionListener(this);
        p3.add(bAadhar);

        next2 = new JButton("Next");
        next2.setBounds(500, 320, 100, 50);
        next2.addActionListener(this);
        p3.add(next2);
        //End of personal details page

        //documents tab

        l14 = new JLabel("Caste Certificate");
        l14.setBounds(50, 70, lw, 40);
        p4.add(l14);

        bCasteCert = new JButton("Upload Caste Certificate");
        bCasteCert.setBounds(200, 70, 190, 30);
        bCasteCert.addActionListener(this);
        p4.add(bCasteCert);

        l15 = new JLabel("Leaving Certificate");
        l15.setBounds(700, 70, lw, 40);
        p4.add(l15);

        bLeavingCert = new JButton("Upload Leaving Certificate");
        bLeavingCert.setBounds(870, 70, 190, 30);
        p4.add(bLeavingCert);

//        l16 = new JLabel("HSC Result");
//        l16.setBounds(50, 220, lw, 40);
//        p4.add(l16);

//        bHscResult = new JButton("Upload Hsc Result");
//        bHscResult.setBounds(200, 220, 190, 30);
//        bHscResult.addActionListener(this);
//        p4.add(bHscResult);

        submit = new JButton("Submit");
        submit.setBounds(200, 230, 200, 80);
        submit.addActionListener(this);
        p4.add(submit);

        tabs = new JTabbedPane();
        tabs.setBounds(80, 280, 1100, 400);
        tabs.setFont(new Font("Tahoma", Font.BOLD, font));

        tabs.add("HSC Details", p2);
        tabs.add("Personal", p3);
        tabs.add("Documents", p4);
        l3.add(tabs);

        //JButton back;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(70,40, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        back=new JButton(i3);
        back.setBounds(5,5,50,50);
        back.addActionListener(this);
        add(back);


        setLayout(null);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        int result = 1;
        if(ae.getSource()==back){
            new Main().setVisible(true);
            this.setVisible(false);
        }
        //cetresult upload
        if (ae.getSource() == bHscResult) {
            JFileChooser add = new JFileChooser();
            result = add.showOpenDialog(null);
            System.out.println(result); // will rteturn 0 if file is choosen successfully
            File selectedFile = add.getSelectedFile();
            String fileName = selectedFile.getName();
            String path = selectedFile.getAbsolutePath();
            System.out.println(fileName);
            System.out.println(path);
            String dbpath = "C:\\Users\\DEVESH\\Desktop\\Files\\";
            dbpath = dbpath.concat(fileName);
            System.out.println(dbpath); // path created for files successfully

            try{
                conn c = new conn();
                String str = "update files set hscResult = '"+dbpath+"' where fid ='"+studLogin.sesId+"'";
                c.s.executeUpdate(str);

            }catch (Exception e){
                System.out.println(e);
            }
//            if (result == JFileChooser.APPROVE_OPTION) {
//                String path = selectedFile.getAbsolutePath();
//
//
//                FileInputStream fis = null;
//                try {
//                    conn c = new conn();
//                    fis = new FileInputStream(path);
//                    String str = "insert into photos (cetResult, pid) values(?,'" + studLogin.sesId + "')";
//                    PreparedStatement pst = c.c.prepareStatement(str);
//                    //c.s.executeUpdate(str);
//                    pst.setBinaryStream(1, fis);
//                    int record = pst.executeUpdate();
//                    if (record == 1) {
//                        JOptionPane.showMessageDialog(null, "Successfully Uploaded the file");
//                        String str1 = "update studentdetails set cetResult = (select cetResult from photos where photos.pid=studentdetails.id)";
//                        c.s.executeUpdate(str1);
//                        System.out.println(studLogin.sesId);
//                        String str2 = "delete from photos";
//                        c.s.executeUpdate(str2);
//                    }
//
//
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//            }
        }
        if (ae.getSource() == next1) {
            if (result != 0) {
                JOptionPane.showMessageDialog(null, "Please Upload the CET Result");
            } else {
                tabs.setSelectedIndex(1);
            }
        }
        if (ae.getSource() == next2) {
            tabs.setSelectedIndex(2);
        }
        //photograph upload
        if (ae.getSource() == bPhoto) {
            JFileChooser add = new JFileChooser();
            result = add.showOpenDialog(null);
            System.out.println(result); // will rteturn 0 if file is choosen successfully
            File selectedFile = add.getSelectedFile();
            String fileName = selectedFile.getName();
            String path = selectedFile.getAbsolutePath();
            System.out.println(fileName);
            System.out.println(path);
            String dbpath = "C:\\Users\\DEVESH\\Desktop\\Files\\";
            dbpath = dbpath.concat(fileName);
            System.out.println(dbpath); // path created for files successfully

            try{
                conn c = new conn();
                String str = "update files set photo = '"+dbpath+"' where fid ='"+studLogin.sesId+"'";
                c.s.executeUpdate(str);

            }catch (Exception e){
                System.out.println(e);
            }

        }
        //aadhar card photo upload
        if (ae.getSource() == bAadhar) {
            JFileChooser add = new JFileChooser();
            result = add.showOpenDialog(null);
            System.out.println(result); // will rteturn 0 if file is choosen successfully
            File selectedFile = add.getSelectedFile();
            String fileName = selectedFile.getName();
            String path = selectedFile.getAbsolutePath();
            System.out.println(fileName);
            System.out.println(path);
            String dbpath = "C:\\Users\\DEVESH\\Desktop\\Files\\";
            dbpath = dbpath.concat(fileName);
            System.out.println(dbpath); // path created for files successfully

            try{
                conn c = new conn();
                String str = "update files set aadhar = '"+dbpath+"' where fid ='"+studLogin.sesId+"'";
                c.s.executeUpdate(str);

            }catch (Exception e){
                System.out.println(e);
            }
        }
        //caste certificate upload
        if (ae.getSource() == bCasteCert) {
            JFileChooser add = new JFileChooser();
            result = add.showOpenDialog(null);
            System.out.println(result); // will rteturn 0 if file is choosen successfully
            File selectedFile = add.getSelectedFile();
            String fileName = selectedFile.getName();
            String path = selectedFile.getAbsolutePath();
            System.out.println(fileName);
            System.out.println(path);
            String dbpath = "C:\\Users\\DEVESH\\Desktop\\Files\\";
            dbpath = dbpath.concat(fileName);
            System.out.println(dbpath); // path created for files successfully

            try{
                conn c = new conn();
                String str = "update files set caste = '"+dbpath+"' where fid ='"+studLogin.sesId+"'";
                c.s.executeUpdate(str);

            }catch (Exception e){
                System.out.println(e);
            }
        }
        // leaving certificate upload
        if (ae.getSource() == bLeavingCert) {
            JFileChooser add = new JFileChooser();
            result = add.showOpenDialog(null);
            System.out.println(result); // will rteturn 0 if file is choosen successfully
            File selectedFile = add.getSelectedFile();
            String fileName = selectedFile.getName();
            String path = selectedFile.getAbsolutePath();
            System.out.println(fileName);
            System.out.println(path);
            String dbpath = "C:\\Users\\DEVESH\\Desktop\\Files\\";
            dbpath = dbpath.concat(fileName);
            System.out.println(dbpath); // path created for files successfully

            try{
                conn c = new conn();
                String str = "update files set leavingCertificate = '"+dbpath+"' where fid ='"+studLogin.sesId+"'";
                c.s.executeUpdate(str);

            }catch (Exception e){
                System.out.println(e);
            }
        }
        //HSC result upload


        if (ae.getSource() == submit) {
            //String cetScore = this.cetScore.getText();
            String hscScore = this.hscScore.getText();
            String address = this.address.getText();
            String schoolName = this.school.getText();
            String parentsNumber = this.pNumber.getText();
            String caste = this.caste.getName();
            int b = JOptionPane.showConfirmDialog(null,"Are you Sure to Submit?");
            if(b==0) {
                try {
                    conn c = new conn();
                    String str1 = "update studentdetails set hscScore = '" + hscScore + "', parentsNumber = '" + parentsNumber + "' , schoolname = '" + schoolName + "' address = '" + address + "'";
                    c.s.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null, "Profile Details Added Successfully!");
                    this.setVisible(false);
                    new Main().setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
    }
        public static void main (String[]args){
            new addProfileData();
        }
    }


