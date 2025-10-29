import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class dashboardDoctor extends JFrame implements MouseListener,ActionListener  {

    JPanel panel;
    JLabel nameLabel, depLabel,title, availableLabel, imgLabel;
    JButton stgBtn;
	JButton aptBtn;
    JRadioButton c1, c2;
    ButtonGroup cg1;
	ImageIcon dcR,img,vtC;
    Color myColor1, myColor2;
    Font myFont, myFont1;
    user u = null;
	users us = null;
	
	
	    public dashboardDoctor(user u,users us) {

    
        super("DOCTOR DETAILS");
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
            imgLabel.setBounds(100,60,100,100);
            panel.add(imgLabel);


        nameLabel = new JLabel(" Name:");
        nameLabel.setBounds(210, 80, 100, 30);
        nameLabel.setFont(myFont);
        nameLabel.setBackground(myColor2);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setOpaque(true);
        nameLabel.setBorder(null);
        panel.add( nameLabel);


            vtC = new ImageIcon("Images/cardPic.jpg");
            imgLabel = new JLabel(vtC);//background
            imgLabel.setBounds(160,180,250,140);
            panel.add(imgLabel);



        depLabel = new JLabel(" DEP: ");
         depLabel.setBounds(210, 120, 100, 30);
         depLabel.setFont(myFont);
         depLabel.setBackground(myColor2);
         depLabel.setForeground(Color.BLACK);
         depLabel.setOpaque(true);
         depLabel.setBorder(null);
        panel.add( depLabel);


        availableLabel = new JLabel(" Select Time");
        availableLabel.setBounds(160, 340, 200, 30);
        availableLabel.setBackground(myColor2);
        availableLabel.setForeground(Color.BLACK);
        availableLabel.setBorder(null);
        panel.add(availableLabel);
        
		c1 = new JRadioButton("8.00am-3.00pm");
        c1.setBounds(160, 370, 180, 20);
          //  c1.setBackground(Color.WHITE);
       c1.setBackground(myColor2);
        c1.setForeground(Color.BLACK);
       // c1.setBorder(null);
        panel.add(c1);

        c2 = new JRadioButton("3.00pm-9.00pm");
        c2.setBounds(360, 370, 180, 20);
        c2.setBackground(myColor2);
        c2.setForeground(Color.BLACK);
        //c2.setBorder(null);
        panel.add(c2);

        
        cg1 = new ButtonGroup();
        cg1.add(c1);
        cg1.add(c2);
  
        aptBtn = new JButton("APPOINMENTS");
        aptBtn.setBounds(570, 410, 150, 25);
        aptBtn.setBackground(myColor2);
        aptBtn.setForeground(Color.BLACK);
        aptBtn.addActionListener(this);
        panel.add(aptBtn);
		
		dcR = new ImageIcon("Images/settingsBtn.jpg");
		stgBtn = new JButton(dcR);
		stgBtn.setBounds(680,15,36,30);
		stgBtn.setBackground(myColor1);
		stgBtn.addMouseListener(this);
		stgBtn.addActionListener(this);
		stgBtn.setBorder(null);
		panel.add(stgBtn);




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
	
	public void actionPerformed(ActionEvent ae){
        String command = ae.getActionCommand();

       // if(stgBtn.getText().equals(command)){
           /*Login hello= new Login();
            hello.setVisible(true);
            this.setVisible(false);*/
       // }
	
	}
	
}
