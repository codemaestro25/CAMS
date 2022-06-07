package CollegeAdmissionSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStream extends javax.swing.JFrame implements ActionListener {

    JButton back;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    public AddStream() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();


        jLabel1.setText("Stream id");
        jLabel1.setFont(new Font("Arial", Font.PLAIN, 17));
        jLabel1.setForeground(Color.white);
        jLabel1.setBounds(160,30,120,30);
        jLabel2.setText("Stream name ");
        jLabel2.setBounds(160,90,120,30);
        jLabel2.setFont(new Font("Arial", Font.PLAIN, 17));
        jLabel2.setForeground(Color.white);
        jLabel3.setText("Stream Cutoff");
        jLabel3.setBounds(160,150,120,30);
        jLabel3.setFont(new Font("Arial", Font.PLAIN, 17));
        jLabel3.setForeground(Color.white);

        jLabel4.setText("Fees");
        jLabel4.setBounds(160,210,120,30);
        jLabel4.setFont(new Font("Arial", Font.PLAIN, 17));
        jLabel4.setForeground(Color.WHITE);

        jTextField1.setBounds(300,30,220,40);
        jTextField2.setBounds(300,90,220,40);
        jTextField3.setBounds(300,150,220,40);
        jTextField4.setBounds(300,210,220,40);
        jButton1.setBounds(300,330,150,40);
        jButton1.setText("Add");
        jButton1.addActionListener(this);
        setSize(800,480);
        setLayout(null);
        add(jLabel1);
        JLabel labels[] = {jLabel1,jLabel2,jLabel3,jLabel4};
        for (int i = 0; i < labels.length; i++) {
            add(labels[i]);
        }
        JTextField textFields[] = {jTextField1,jTextField2,jTextField3,jTextField4};
        for (int i = 0; i < textFields.length; i++) {
            add(textFields[i]);
        }
        JButton buttons[] = {jButton1};
        for (int i = 0; i < buttons.length; i++) {
            add(buttons[i]);
        }


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(70,40, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        back=new JButton(i3);
        back.setBounds(5,5,50,50);
        back.addActionListener(this);
        add(back);


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/bg6.png"));
        Image i5 =i4.getImage().getScaledInstance(1000,600, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l3 = new JLabel(i6);
        l3.setBounds(0,0,1000,600);
        add(l3);

        setVisible(true);
        setTitle("Add Stream");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jButton1){
            int id = Integer.parseInt(jTextField1.getText());
            String sName = jTextField2.getText();
            String sCutoff = jTextField3.getText();
            String sFees = jTextField4.getText();

            try{
                conn c = new conn();
                String str1 = "update streams set str_id='"+id+"', name='"+sName+"', cutoff='"+sCutoff+"', fees='"+sFees+"';";
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"Stream Added Successfully!");
            }catch (Exception e){
                System.out.println(e);
            }
        }
        if(ae.getSource()==back){
            new cutoffs().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStream();
    }


}
