package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;



public class dashboardDoctor extends JFrame implements MouseListener,ActionListener  {

   JPanel panel;
   JLabel nameLabel, depLabel,feeLabel , availableLabel, imgLabel;
   JButton stgBtn,backBtn;
   JButton appointmentBtn;
   JRadioButton c1, c2;
   ButtonGroup cg1;
   ImageIcon dcR,img,backImg;
   Color myColor1, myColor2;
   Font myFont, myFont1;
   user u = null;
   users us = null;


   public dashboardDoctor(user u,users us) {


      super("DOCTOR DASHBOARD");
      this.setSize(800, 500);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);

      myFont = new Font("Roboto", Font.PLAIN, 14);
      myFont1 = new Font("Roboto", Font.BOLD, 18);

      myColor1 = new Color(239, 92, 92);
      myColor2 = new Color(134, 248, 196, 103);


      this.us = us;
      this.u = u;

      panel = new JPanel();
      panel.setBackground(Color.WHITE);
      panel.setLayout(null);

      backImg = new ImageIcon("Images/back-48.png");
      backBtn = new JButton(backImg);
      backBtn.setBounds(60, 15, 45, 45);
      backBtn.setBackground(Color.WHITE);
      backBtn.addMouseListener(this);
      backBtn.addActionListener(this);
      backBtn.setBorder(null);
      panel.add(backBtn);

      img = new ImageIcon("Images/docDP.jpg");
      imgLabel = new JLabel(img);//background
      imgLabel.setBounds(110,60,100,100);
      panel.add(imgLabel);


      nameLabel = new JLabel(" Name:"+u.getName());
      nameLabel.setBounds(240, 90, 200, 30);
      nameLabel.setFont(myFont);
      nameLabel.setBackground(myColor2);
      nameLabel.setForeground(Color.BLACK);
      nameLabel.setBorder(null);
      nameLabel.setOpaque(true);
      panel.add( nameLabel);




      depLabel = new JLabel(" Dep : "+((doctor)u).getDep());
      depLabel.setBounds(240, 130, 200, 30);
      depLabel.setFont(myFont);
      depLabel.setBackground(myColor2);
      depLabel.setForeground(Color.BLACK);
      depLabel.setBorder(null);
      depLabel.setOpaque(true);
      panel.add( depLabel);


      availableLabel = new JLabel(" Select Time - ");
      availableLabel.setBounds(160, 200, 200, 30);
      availableLabel.setBackground(myColor2);
      availableLabel.setForeground(Color.BLACK);
      availableLabel.setBorder(null);
      panel.add(availableLabel);



      feeLabel = new JLabel(" Currunt fee-"+((doctor)u).getFee());                           //+u.getFee()
      feeLabel.setBounds(160, 300, 200, 30);
      feeLabel.setBackground(myColor2);
      feeLabel.setForeground(Color.BLACK);
      feeLabel.setBorder(null);
      panel.add(feeLabel);



      c1 = new JRadioButton("8.00am-3.00pm");
      c1.setBounds(160, 230, 180, 20);
      c1.setBackground(Color.WHITE);
      panel.add(c1);

      c2 = new JRadioButton("3.00pm-9.00pm");
      c2.setBounds(360, 230, 180, 20);
      c2.setBackground(Color.WHITE);
      panel.add(c2);


      cg1 = new ButtonGroup();
      cg1.add(c1);
      cg1.add(c2);

      appointmentBtn = new JButton("APPOINTMENTS");
      appointmentBtn.setBounds(550, 370, 150, 25);
      appointmentBtn.setFont(myFont);
      appointmentBtn.setBackground(myColor1);
      appointmentBtn.setForeground(Color.BLACK);
      appointmentBtn.setBorder(null);
      appointmentBtn.setOpaque(true);
      appointmentBtn.addActionListener(this);
      panel.add(appointmentBtn);

		/*dcR = new ImageIcon("settingsBtn.png");
		stgBtn = new JButton(dcR);
		stgBtn.setBounds(660,20,45,45);
		stgBtn.setBackground(myColor1);
		stgBtn.addMouseListener(this);
		stgBtn.addActionListener(this);
		stgBtn.setBorder(null);
		panel.add(stgBtn);*/







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
         Login lg = new Login(us);
         lg.setVisible(true);
         this.setVisible(false);
      }


      else if (appointmentBtn.getText().equals(command)) {
         patientList lg = new patientList(u,us);
         lg.setVisible(true);
         this.setVisible(false);


      }

   }}


