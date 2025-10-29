
package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;

public class doctorDetailsForPatient extends JFrame implements MouseListener,ActionListener {


    JPanel panel;
    JLabel nameLabel, depLabel, title, availableLabel, imgLabel;
    //JButton settingsBtn;
    JButton appointmentBtn, backBtn;
    JRadioButton c1, c2;
    ButtonGroup cg1;
    ImageIcon img, vtcImg, backImg;
    Color myColor1, myColor2;
    Font myFont, myFont1;
    user u = null;
    users us = null;


    public doctorDetailsForPatient(user u, users us) {


        super("DOCTOR DETAILS FOR PATIENTS");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        myFont = new Font("Roboto", Font.PLAIN, 14);
        myFont1 = new Font("Roboto", Font.BOLD, 18);

        myColor1 = new Color(247, 231, 191);
        myColor2 = new Color(191, 198, 247, 103);


        this.us = us;
        this.u = u;

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        img = new ImageIcon("Images/docDP.jpg");
        imgLabel = new JLabel(img);//background
        imgLabel.setBounds(100, 60, 100, 100);
        panel.add(imgLabel);


        nameLabel = new JLabel(" Name:");
        nameLabel.setBounds(210, 80, 100, 30);
        nameLabel.setFont(myFont);
        nameLabel.setBackground(Color.WHITE);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBorder(null);
        nameLabel.setOpaque(true);
        panel.add(nameLabel);


        backImg = new ImageIcon("Images/back-48.png");
        backBtn = new JButton(backImg);
        backBtn.setBounds(60, 15, 45, 45);
        backBtn.setBackground(Color.WHITE);
        backBtn.addMouseListener(this);
        backBtn.addActionListener(this);
        backBtn.setBorder(null);
        panel.add(backBtn);


        vtcImg = new ImageIcon("Images/cardPic.jpg");
        imgLabel = new JLabel(vtcImg);//background
        imgLabel.setBounds(160, 180, 250, 140);
        panel.add(imgLabel);


        depLabel = new JLabel(" DEP: ");
        depLabel.setBounds(210, 120, 100, 30);
        depLabel.setFont(myFont);
        depLabel.setBackground(Color.WHITE);
        depLabel.setForeground(Color.BLACK);
        depLabel.setBorder(null);
        depLabel.setOpaque(true);
        panel.add(depLabel);


        availableLabel = new JLabel(" Select Time");
        availableLabel.setBounds(160, 340, 200, 30);
        availableLabel.setBackground(myColor2);
        availableLabel.setForeground(Color.BLACK);
        availableLabel.setBorder(null);
        panel.add(availableLabel);

        c1 = new JRadioButton("8.00am-3.00pm");
        c1.setBounds(160, 370, 180, 20);
        c1.setBackground(Color.WHITE);
        panel.add(c1);

        c2 = new JRadioButton("3.00pm-9.00pm");
        c2.setBounds(360, 370, 180, 20);
        c2.setBackground(Color.WHITE);
        panel.add(c2);


        cg1 = new ButtonGroup();
        cg1.add(c1);
        cg1.add(c2);

        appointmentBtn = new JButton("APPOINTMENTS");
        appointmentBtn.setBounds(570, 410, 150, 25);
        appointmentBtn.setFont(myFont);
        appointmentBtn.setBackground(Color.WHITE);
        appointmentBtn.setForeground(Color.BLACK);
        appointmentBtn.setBorder(null);
        appointmentBtn.setOpaque(true);
        appointmentBtn.addActionListener(this);
        panel.add(appointmentBtn);


          /*  settingsImg = new ImageIcon("Images/settingsBtn.png");
            settingsBtn = new JButton(settingsImg);
            settingsBtn.setBounds(680, 15, 45, 45);
            settingsBtn.setBackground(Color.WHITE);
            settingsBtn.addMouseListener(this);
            settingsBtn.addActionListener(this);
            settingsBtn.setBorder(null);
            panel.add(settingsBtn);*/


        this.add(panel);
        //this.setVisible(true);

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


        if (backBtn.getText().equals(command)) {
            dashboardPatient db = new dashboardPatient(u, us);
            db.setVisible(true);
            this.setVisible(false);
        } else if (appointmentBtn.getText().equals(command)) {
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(this, "Get his appointment?", "GET APPOINTMENT", dialog);


            if (result == 0) {


                Login lg = new Login(us);    //TEMPORARY
                lg.setVisible(true);
                this.setVisible(false);


            }


            // if(stgBtn.getText().equals(command)){
           /*Login hello= new Login();
            hello.setVisible(true);
            this.setVisible(false);*/
            // }

        }

    }
}