package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;


public class Login extends JFrame implements MouseListener,ActionListener {
	JPanel panel;
	JLabel usernameLabel, passwordLabel, BG, bgm2;
	JTextField usernameTF;
	JPasswordField passwordTF;
	JButton lgnBtn, signUpBtn, forgotPass,backBtn;
	ImageIcon bgP,icon;
	Color myColor1, myColor2, myColor3;
	Font myFont, myFont1;
	user u = null;
	users us = null;
    //int index = a;

	public Login(users us){   //index a
		super("Hospital Management System 0.14");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.us = us;

        //this.a=a;
		myColor1 = new Color(102, 255, 255);//light blue
		myColor2 = new Color(39, 217, 128);
		myColor3 = new Color(0, 51, 102);

		myFont = new Font("Roboto", Font.PLAIN, 14);
		myFont1 = new Font("Roboto", Font.BOLD, 14);

		panel = new JPanel();
		panel.setLayout(null);

		usernameLabel = new JLabel(" Username:");
		usernameLabel.setBounds(240, 150, 285, 38);
		usernameLabel.setFont(myFont1);
		usernameLabel.setBackground(Color.WHITE);
		usernameLabel.setOpaque(true);
		panel.add(usernameLabel);

		passwordLabel = new JLabel(" Password:");
		passwordLabel.setBounds(240, 203, 285, 38);
		passwordLabel.setFont(myFont1);
		passwordLabel.setBackground(Color.WHITE);
		passwordLabel.setOpaque(true);
		panel.add(passwordLabel);

		usernameTF = new JTextField();
		usernameTF.setBounds(325, 152, 200, 36);
		usernameTF.setBorder(null);
		panel.add(usernameTF);

		passwordTF = new JPasswordField();
		passwordTF.setBounds(325,205,200,36);
		passwordTF.setBorder(null);
		passwordTF.setEchoChar('*');
		panel.add(passwordTF);

		lgnBtn = new JButton("Login");
		lgnBtn.setBounds(370,258,80,20);
		lgnBtn.setBackground(myColor3);
		lgnBtn.setForeground(Color.WHITE);
		lgnBtn.addMouseListener(this);
		lgnBtn.addActionListener(this);
		panel.add(lgnBtn);

		icon= new ImageIcon("Images/back-48.png");
		backBtn = new JButton(icon);
		backBtn.setBounds(20, 20, 40, 40);
		backBtn.setBorder(null);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		signUpBtn = new JButton("SignUp");
		signUpBtn.setBounds(465, 258, 80, 20);
		lgnBtn.setBackground(myColor3);
		lgnBtn.setForeground(Color.WHITE);
		signUpBtn.setBackground(myColor2);
		signUpBtn.addMouseListener(this);
		signUpBtn.addActionListener(this);
		panel.add(signUpBtn);

		forgotPass = new JButton("Forgotten password?");
		forgotPass.setBounds(220,258,140,20);
		forgotPass.setBackground(Color.GRAY);
		forgotPass.setForeground(Color.WHITE);
		forgotPass.addMouseListener(this);
		forgotPass.addActionListener(this);
		forgotPass.setBorder(null);
		panel.add(forgotPass);



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

		if (signUpBtn.getText().equals(command)) {    //SIGNUP
			SignUp in = new SignUp(us);
			in.setVisible(true);
			this.setVisible(false);

		}else if (lgnBtn.getText().equals(command)) {    //LOGIN
			if (!usernameTF.getText().isEmpty() && !passwordTF.getText().isEmpty()) {


				String name = usernameTF.getText();
				String pass = passwordTF.getText();

				int index;
				index = us.searchUser(name);

				if (index == -1) {
					JOptionPane.showMessageDialog(this, "User doesn't exist!");
				} else {
					user u = us.checkCredentials(index, pass);        
					if (u == null) {
						System.out.println("Checking 1");
						JOptionPane.showMessageDialog(this, "Password incorrect");
					} else if (u.getType().equals("Doctor") )  {
						dashboardDoctor db = new dashboardDoctor(u, us);
						db.setVisible(true);
						this.setVisible(false);
					} else if(u.getType().equals("Patient") ) {
						dashboardPatient db = new dashboardPatient(u, us);
						db.setVisible(true);
						this.setVisible(false);
					}

				}
			} else {
				//kisu khali thakle
				JOptionPane.showMessageDialog(this, "Information missing");
			}


		} else if(backBtn.getText().equals(command)){
			startPage lg= new startPage(us);
			lg.setVisible(true);
			this.setVisible(false);
		}
	}
}
		





