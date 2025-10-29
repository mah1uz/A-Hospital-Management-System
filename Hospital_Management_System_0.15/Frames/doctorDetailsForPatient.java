
package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;

//174 line if else

public class doctorDetailsForPatient extends JFrame implements MouseListener,ActionListener {


    JPanel panel;
    JLabel nameLabel, depLabel, feeLabel, availableLabel, imgLabel;
    //JButton settingsBtn;
    JButton appointmentBtn, backBtn;
    JRadioButton c1, c2;
    ButtonGroup cg1;
    ImageIcon img, vtcImg, backImg;
    Color myColor1, myColor2;
    Font myFont, myFont1;
    user u,b = null;
    users us = null;


    public doctorDetailsForPatient(user u, users us, user b) {


        super("DOCTOR DETAILS FOR PATIENTS");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        myFont = new Font("Roboto", Font.PLAIN, 14);
        myFont1 = new Font("Roboto", Font.BOLD, 18);

        myColor1 = new Color(250, 206, 97);
        myColor2 = new Color(147, 160, 255, 103);


        this.us = us;
        this.u = u;
        this.b=b;

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        img = new ImageIcon("Images/docDP.jpg");
        imgLabel = new JLabel(img);//background
        imgLabel.setBounds(100, 60, 100, 100);
        panel.add(imgLabel);


        nameLabel = new JLabel(" Name:  "+b.getName());
        nameLabel.setBounds(210, 80, 230, 26);
        nameLabel.setFont(myFont);
        nameLabel.setBackground(myColor2);
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


        depLabel = new JLabel(" DEP: "+((doctor)b).getDep());
        depLabel.setBounds(210, 105, 230, 25);
        depLabel.setFont(myFont);
        depLabel.setBackground(myColor2);
        depLabel.setForeground(Color.BLACK);
        depLabel.setBorder(null);
        depLabel.setOpaque(true);
        panel.add(depLabel);

        feeLabel = new JLabel(" Visiting Fee: "+((doctor)b).getFee());
        feeLabel.setBounds(210, 130, 200, 30);
        feeLabel.setFont(myFont);
        feeLabel.setBackground(myColor1);
        feeLabel.setForeground(Color.BLACK);
        feeLabel.setBorder(null);
        feeLabel.setOpaque(true);
        panel.add(feeLabel);


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

        appointmentBtn = new JButton("GET APPOINTMENT");
        appointmentBtn.setBounds(570, 410, 200, 25);
        appointmentBtn.setFont(myFont);
        appointmentBtn.setBackground(Color.LIGHT_GRAY);
        appointmentBtn.setForeground(Color.BLACK);
        appointmentBtn.setBorder(null);
        appointmentBtn.setOpaque(true);
        appointmentBtn.addActionListener(this);
        panel.add(appointmentBtn);




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
            dashboardPatient DB = new dashboardPatient(u, us);
            DB.setVisible(true);
            this.setVisible(false);


        } else if (appointmentBtn.getText().equals(command)) {
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(this, "Get his appointment?", "GET APPOINTMENT", dialog);


            if (result == 0) {
				
				if(us.appointmentExists(b.getName(), u.getName())) {
					
					JOptionPane.showMessageDialog(this, "You've already got an appointment");
				}else{us.appointDoctor(u, b);}  

				

            }}}}

