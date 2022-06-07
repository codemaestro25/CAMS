package CollegeAdmissionSystem;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test extends JFrame {
    JLabel l1;
    JButton b1;
    test(){

        setSize(1000,700);
        setLocationRelativeTo(null);
        l1 = new JLabel();
        l1.setBounds(50,50,800,500);
        add(l1);

        InputStream input;
        FileOutputStream output;
        try {
            conn c = new conn();
            PreparedStatement pst = c.c.prepareStatement("Select cetResult from studentdetails where id = '100003'");
            ResultSet rs =  pst.executeQuery();
            File theFile = new File("test.png");
            output = new FileOutputStream(theFile);

            if(rs.next()){
                input = rs.getBinaryStream("cetResult");
                byte buffer[] = new byte[1024];
                while (input.read(buffer)>0){
                    output.write(buffer);
                }
                String path = theFile.getAbsolutePath();
                ImageIcon myImage = new ImageIcon(path);
                Image img = myImage.getImage();
              int w= img.getHeight(this);
              int h = img.getWidth(this);
                System.out.println(w);
                System.out.println(h);
               // Image newImg = img.getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(img);
                l1.setSize(w,h);
                l1.setIcon(image);
                JScrollPane sp = new JScrollPane(l1);
                sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                add(sp,BorderLayout.CENTER);
                pack();
            }
        }catch (Exception e){
            System.out.println(e);
        }
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new test();
    }
}
