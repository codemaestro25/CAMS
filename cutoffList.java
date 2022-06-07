package CollegeAdmissionSystem;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class cutoffList extends JFrame implements ActionListener {
    JScrollPane sp1;
    JPanel contentPane;
    JTable streamList;
    int strId;
    JTextField textField;
    JButton button, back;
    String sid, sname, sfees, scutoff;
    public void list() {
        try {
            conn c = new conn();
            String str1 = "select * from streams;";
            ResultSet rs1 = c.s.executeQuery(str1);
            streamList.setModel(DbUtils.resultSetToTableModel(rs1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public cutoffList() {
//        Object[] column = {"col-one", "col-two","col-three"};
//        Object[][] sampleData = {{1, 2,"Bhushan"}, {3, 4,0}, {5, 6,0}, {5, 6,0}, {5, 6,0}, {5, 6,0}};

        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        sp1 = new JScrollPane();
        sp1.setBounds(100,50,550,200);
        setLayout(null);
        contentPane.add(sp1);

        streamList = new JTable();
        streamList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                strId = streamList.getSelectedRow();
                System.out.println(strId);
                textField.setText(streamList.getModel().getValueAt(strId,0).toString());
                sid = streamList.getModel().getValueAt(strId,0).toString();
                sname = streamList.getModel().getValueAt(strId,1).toString();
                scutoff = streamList.getModel().getValueAt(strId,2).toString();
                sfees = streamList.getModel().getValueAt(strId,3).toString();
                System.out.println(sid);
                System.out.println(sname);
                System.out.println(scutoff);
                System.out.println(sfees);
            }
        });
        sp1.setViewportView(streamList);

         textField = new JTextField();
        textField.setBounds(180,330,130,40);
        contentPane.add(textField);
        button = new JButton();
        button.setBounds(380,330,170,40);
        button.setText("Set cutoff");
        button.addActionListener(this);
        contentPane.add(button);

        list();

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/bg6.png"));
        Image i5 =i4.getImage().getScaledInstance(1000,600, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l3 = new JLabel(i6);
        l3.setBounds(0,0,1000,600);
        add(l3);



//        frame.add(button);
//        frame.add(textField);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(70,40, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        back=new JButton(i3);
        back.setBounds(5,5,50,50);
        back.addActionListener(this);
        add(back);

        setVisible(true);
        setSize(800,500);
        setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(3);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==button){
            new SetCutOff(sid,sname,scutoff,sfees);
        }
        if(ae.getSource()==back){
            new adminHome().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new cutoffList();
    }
}