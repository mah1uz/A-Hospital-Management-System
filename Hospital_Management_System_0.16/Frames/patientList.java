package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;



public class patientList extends JFrame implements MouseListener,ActionListener  {

    JPanel panel;
    JLabel nameLabel, depLabel,  imgLabel,titleLabel,patientDetailsLabel;
    JButton nextBtn,backBtn,cancelBtn;
    ImageIcon dcR,img,backImg,nextImage;
    Color myColor1, myColor2;
    Font myFont, myFont1;
    user u = null;
    users us = null;
  int l = users.k;

    int noOfPatient=0;



    public patientList(user u,users us) {


        super("Patient List");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        myFont = new Font("Roboto", Font.PLAIN, 14);
        myFont1 = new Font("Roboto", Font.BOLD, 18);

        myColor1 = new Color(239, 92, 92);
        myColor2 = new Color(134, 248, 196, 103);


        this.us = us;
        this.u = u;
        noOfPatient= us.noOfPatients(u.getName());


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
		
		
		

       // nextImage = new ImageIcon("Images/icons8-next-45");
        nextBtn = new JButton("NEXT");
        nextBtn.setBounds(600, 175, 45, 45);
        nextBtn.setBackground(Color.GRAY);
        nextBtn.addMouseListener(this);
        nextBtn.addActionListener(this);
        nextBtn.setBorder(null);
        panel.add(nextBtn);


        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(240, 350, 45, 45);
        cancelBtn.setBackground(Color.GRAY);
        cancelBtn.addMouseListener(this);
        cancelBtn.addActionListener(this);
        cancelBtn.setBorder(null);
        panel.add(cancelBtn);


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



        patientDetailsLabel = new JLabel(us.getPatientList(u.getName(), l));
        patientDetailsLabel.setBounds(240, 170, 350, 100);
        patientDetailsLabel.setFont(myFont);
        patientDetailsLabel.setBackground(myColor2);
        patientDetailsLabel.setForeground(Color.BLACK);
        patientDetailsLabel.setBorder(null);
        patientDetailsLabel.setOpaque(true);
        panel.add( patientDetailsLabel);

        titleLabel = new JLabel(" YOUR PATIENTS: "+noOfPatient);
        titleLabel.setBounds(100, 175, 140, 30);
        titleLabel.setFont(myFont);
        titleLabel.setBackground(myColor2);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBorder(null);
        titleLabel.setOpaque(true);
        panel.add( titleLabel);




        depLabel = new JLabel(" Dep : "+((doctor)u).getDep());
        depLabel.setBounds(240, 130, 200, 30);
        depLabel.setFont(myFont);
        depLabel.setBackground(myColor2);
        depLabel.setForeground(Color.BLACK);
        depLabel.setBorder(null);
        depLabel.setOpaque(true);
        panel.add( depLabel);




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
            dashboardDoctor lg = new dashboardDoctor(u,us);
            lg.setVisible(true);
            this.setVisible(false);
            users.k=0;
        }
        else if (nextBtn.getText().equals(command)) {
           // l = users.k;
            if (l<=noOfPatient){
            patientList nw=new patientList(u,us);
            nw.setVisible(true);
            this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "No more patients today!");
                users.k=0;}
        }
    
	    else if (cancelBtn.getText().equals(command)) {
           // l = users.k;
            us.deleteUser(l);
        }
	    //cancelBtn
	
	
	
	
	         }
           }




