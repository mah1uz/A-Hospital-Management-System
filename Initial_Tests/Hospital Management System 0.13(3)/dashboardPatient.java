import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;

public class dashboardPatient extends JFrame implements MouseListener,ActionListener {

	JPanel panel;
	JLabel namedepLabel, catagoryLabel, imgLabel;
	JButton settingsBtn, searchButton, doc1btn, doc2btn, doc3btn, backBtn;
	JTextField userTF;
	ImageIcon searchImg, img1, img2, img3, settingsImg, backImg;
	Color myColor1, myColor2;
	Font myFont, myFont1;
	users us;
	user u;

	public dashboardPatient(user u, users us) {

		super(" Patients Dashboard");
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


		namedepLabel = new JLabel(" Search for a doctor..");
		namedepLabel.setBounds(200, 45, 200, 30);
		namedepLabel.setFont(myFont);
		namedepLabel.setBackground(Color.WHITE);
		namedepLabel.setForeground(Color.BLACK);
		namedepLabel.setOpaque(true);
		namedepLabel.setBorder(null);
		panel.add(namedepLabel);


		searchImg = new ImageIcon("Images/search.png");
		searchButton = new JButton(searchImg);
		searchButton.setBounds(500, 83, 45, 45);
		searchButton.setBackground(Color.WHITE);
		searchButton.addMouseListener(this);
		searchButton.addActionListener(this);
		searchButton.setOpaque(true);
		searchButton.setBorder(null);
		panel.add(searchButton);


		userTF = new JTextField();
		userTF.setBounds(200, 85, 300, 40);
		panel.add(userTF);


		backImg = new ImageIcon("Images/back-48.png");
		backBtn = new JButton(backImg);
		backBtn.setBounds(60, 15, 45, 45);
		backBtn.setBackground(Color.WHITE);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setBorder(null);
		panel.add(backBtn);


		img1 = new ImageIcon("Images/docDP.jpg");
		imgLabel = new JLabel(img1);//background 
		imgLabel.setBounds(130, 150, 150, 100);
		panel.add(imgLabel);

		img2 = new ImageIcon("Images/docDP.jpg");
		imgLabel = new JLabel(img2);//background 
		imgLabel.setBounds(290, 150, 150, 100);
		panel.add(imgLabel);


		img3 = new ImageIcon("Images/docDP.jpg");
		imgLabel = new JLabel(img3);//background 
		imgLabel.setBounds(440, 150, 150, 100);
		panel.add(imgLabel);

		catagoryLabel = new JLabel("Medicine");
		catagoryLabel.setBounds(170, 275, 90, 20);
		catagoryLabel.setFont(myFont);
		catagoryLabel.setBackground(Color.WHITE);
		catagoryLabel.setForeground(Color.BLACK);
		catagoryLabel.setBorder(null);
		catagoryLabel.setOpaque(true);
		panel.add(catagoryLabel);

		doc1btn = new JButton("Doc 1");
		doc1btn.setBounds(155, 260, 90, 20);
		doc1btn.setBackground(Color.WHITE);
		doc1btn.setForeground(Color.BLACK);
		doc1btn.addActionListener(this);
		doc1btn.setBorder(null);
		panel.add(doc1btn);


		doc2btn = new JButton("Doc 2");
		doc2btn.setBounds(315, 260, 90, 20);
		doc2btn.setBackground(Color.WHITE);
		doc2btn.setForeground(Color.BLACK);
		doc2btn.addActionListener(this);
		doc2btn.setBorder(null);
		panel.add(doc2btn);

		catagoryLabel = new JLabel("Cardiologists");
		catagoryLabel.setBounds(315, 275, 90, 20);
		catagoryLabel.setFont(myFont);
		catagoryLabel.setBackground(Color.WHITE);
		catagoryLabel.setForeground(Color.BLACK);
		catagoryLabel.setOpaque(true);
		catagoryLabel.setBorder(null);
		panel.add(catagoryLabel);


		doc3btn = new JButton("Doc 3");
		doc3btn.setBounds(465, 260, 100, 20);
		doc3btn.setBackground(Color.WHITE);
		doc3btn.setForeground(Color.BLACK);
		doc3btn.addActionListener(this);
		doc3btn.setBorder(null);
		panel.add(doc3btn);


		catagoryLabel = new JLabel("Dermatologists");
		catagoryLabel.setBounds(465, 275, 100, 20);
		catagoryLabel.setFont(myFont);
		catagoryLabel.setBackground(Color.WHITE);
		catagoryLabel.setForeground(Color.BLACK);
		catagoryLabel.setBorder(null);
		catagoryLabel.setOpaque(true);
		panel.add(catagoryLabel);

		settingsImg = new ImageIcon("Images/settingsBtn.png");
		settingsBtn = new JButton(settingsImg);
		settingsBtn.setBounds(680, 15, 45, 45);
		settingsBtn.setBackground(Color.WHITE);
		settingsBtn.addMouseListener(this);
		settingsBtn.addActionListener(this);
		settingsBtn.setBorder(null);
		panel.add(settingsBtn);

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

			else if (doc1btn.getText().equals(command)) { 
				int dialog = JOptionPane.YES_NO_OPTION;
				int result = JOptionPane.showConfirmDialog(this, "Get his appointment?", "GET APPOINTMENT", dialog);
				
				
				if(result == 0){
					








					
					Login lg = new Login(us);    //TEMPORARY 
			        lg.setVisible(true);
			        this.setVisible(false);





				}else{ 
					//do nothing 
				}

			}	

			//if(stgBtn.getText().equals(command)){
			// Login hello= new Login();
			//hello.setVisible(true);
			//this.setVisible(false);
			// }

		}

	}


		
		



