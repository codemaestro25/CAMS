package CollegeAdmissionSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class scrutinyList extends JFrame {
    JTable t1;
    JPanel contentPane;

    public void list1(){
        try{
            conn c = new conn();
            String str1 ="select name, id from studentdetails";
            ResultSet rs = c.s.executeQuery(str1);

            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.println(e);
        }
    }
    scrutinyList(){
        setSize(1300,700);

        contentPane = new JPanel();
        contentPane.setBackground(Color.lightGray);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane sp1 = new JScrollPane();
        sp1.setBounds(118,50,1100,500);
        setLayout(null);
        setVisible(true);
        contentPane.add(sp1);

        t1 = new JTable();
        t1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int stud = t1.getSelectedRow();
                System.out.println(stud);

            }
        });
        sp1.setViewportView(t1);

        list1();
        setLayout(null);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new scrutinyList();
    }
}
