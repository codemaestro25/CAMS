package CollegeAdmissionSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author BHUSHAN
 */
public class SetCutOff extends javax.swing.JFrame implements ActionListener {

    JButton back;
    String streamId;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private JLabel jLabel8;
    private javax.swing.JTextField jTextField1;

    // End of variables declaration//GEN-END:variables
    public SetCutOff(String sid, String sName, String sCutoff, String sFees) {



        streamId = sid;
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();


        jLabel1.setText("Stream name");

        jLabel2.setText("Stream id");

        jLabel3.setText("Stream fees");

        jLabel4.setText("Cutoff");

        jLabel8.setText("Previous Cutoff");
        jButton1.setText("Set");
        jLabel1.setBounds(160, 30, 120, 30);
        jLabel2.setBounds(160, 90, 120, 30);
        jLabel3.setBounds(160, 150, 120, 30);
        jLabel4.setBounds(160, 210, 120, 30);
        jLabel1.setFont(new Font("Arial", Font.PLAIN, 17));
        jLabel2.setFont(new Font("Arial", Font.PLAIN, 17));
        jLabel3.setFont(new Font("Arial", Font.PLAIN, 17));
        jLabel4.setFont(new Font("Arial", Font.PLAIN, 17));

        jLabel5.setBounds(300, 30, 220, 40);
        jLabel5.setText(sName);
        jLabel6.setBounds(300, 90, 220, 40);
        jLabel6.setText(sid);
        jLabel7.setBounds(300, 150, 220, 40);
        jLabel7.setText(sCutoff);
        jLabel8.setBounds(160,270,220,40);
        jTextField1.setBounds(300, 340, 220, 40);
        setLayout(null);
        setLocation(30, 40);
        setSize(900, 680);
        setLocation(50, 20);
        JLabel labels[] = {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5,jLabel6,jLabel7,jLabel8};
        for (int i = 0; i < labels.length; i++) {
            add(labels[i]);
        }
        JTextField[] textBoxes = {jTextField1};
        for (int i = 0; i < textBoxes.length; i++) {
            add(textBoxes[i]);
        }
        jButton1.setBounds(300, 400, 150, 40);
        jButton1.setText("Set");
        jButton1.addActionListener(this);
        setVisible(true);
        add(jButton1);
        setTitle("Set cutoff");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        try {
            conn c = new conn();
            //String str1 = "Select * from streams where "
        } catch (Exception e) {

        }
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("jproject_images/back.png"));
        Image i2 = i1.getImage().getScaledInstance(70,40, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        back=new JButton(i3);
        back.setBounds(5,5,50,50);
        back.addActionListener(this);
        add(back);
    }
        public void actionPerformed (ActionEvent ae) {
            if (ae.getSource() == jButton1) {
                String cutoff = jTextField1.getText();
                try{
                    conn c = new conn();
                    String str1 = "update streams set cutoff = '"+cutoff+"' where str_id = '"+streamId+"';";
                    c.s.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null,"Cutoff Updated Successfully!");
                }catch (Exception e){
                    System.out.println(e);
                }

            }
            if(ae.getSource()==back){
                new cutoffList().setVisible(true);
                this.setVisible(false);
            }
        }


        public static void main (String[]args){
           // new SetCutOff();
        }



}
