package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;

public class startPage extends JFrame implements MouseListener,ActionListener {
    JPanel panel;
    JLabel BG, aboutusLabel,title;
    /*JTextField adminTF;
    JTextField DoctorTF;
    JTextField patientTF;*/

    JButton adminBtn, DoctorBtn, patientBtn,LoginBtn;
    ImageIcon bgP;
    Color myColor1, myColor2, myColor3;
    Font myFont, myFont1;

    users us = null;


    public startPage(users us) {
        super("Start Page");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.us = us;

        myColor1 = new Color(27, 28, 28);//light blue
        myColor2 = new Color(241, 246, 244);
        myColor3 = new Color(229, 232, 236);

        myFont = new Font("Roboto", Font.PLAIN, 20);
        myFont1 = new Font("Roboto", Font.BOLD, 20);

        panel = new JPanel();
        panel.setLayout(null);

        title = new JLabel("HOME");
        title.setBounds(300, 68, 200, 30);
        title.setFont(myFont1);
        this.add(title);


        aboutusLabel = new JLabel("ABOUT US");
        aboutusLabel.setBounds(320, 320, 140, 38);
        aboutusLabel.setFont(myFont1);
        aboutusLabel.setBackground(Color.WHITE);
        aboutusLabel.setOpaque(true);
        aboutusLabel.setBorder(null);
        panel.add( aboutusLabel);

        adminBtn = new JButton("Admin");
        adminBtn.setBounds(200, 200, 100, 35);
        adminBtn.setBackground(myColor3);
        adminBtn.setForeground(Color.BLACK);
        adminBtn.addMouseListener(this);
        adminBtn.addActionListener(this);
        panel.add(adminBtn);

        DoctorBtn = new JButton("Doctor");
        DoctorBtn.setBounds(400, 200, 100, 35);
        DoctorBtn.setBackground(myColor3);
        DoctorBtn.setForeground(Color.BLACK);
        DoctorBtn.setBackground(myColor2);
        DoctorBtn.addMouseListener(this);
        DoctorBtn.addActionListener(this);
        panel.add(DoctorBtn);

        patientBtn = new JButton("Patient");
        patientBtn.setBounds(600, 200, 100, 35);
        patientBtn.setBackground(myColor3);
        patientBtn.setForeground(Color.BLACK);
        patientBtn.setBackground(myColor2);
        patientBtn.addMouseListener(this);
        patientBtn.addActionListener(this);
        panel.add(patientBtn);

        bgP = new ImageIcon("Images/home.jpg");
        BG = new JLabel(bgP);//background
        BG.setBounds(0, 0, 800, 500);
        panel.add(BG);


        this.add(panel);
        this.setVisible(true);
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();


            if(adminBtn.getText().equals(command) || patientBtn.getText().equals(command)||DoctorBtn.getText().equals(command)){
                Login lg = new Login(us);
                lg.setVisible(true);
                this.setVisible(false);

            }

        }

    }
