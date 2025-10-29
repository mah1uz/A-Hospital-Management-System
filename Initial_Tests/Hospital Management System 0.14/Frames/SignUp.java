package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;


public class SignUp extends JFrame implements MouseListener,ActionListener{

    JPanel panel;
    JLabel userLabel, passLabel, genderLabel, ageLabel, nidLabel, bloodLabel, title,conPass;
    JTextField userTF; //,ageTF,nidTF
    JPasswordField passTF,conPassTF;
    JButton registerBtn,backBtn;
    JRadioButton r1, r2, r3;
    ButtonGroup bg1;
    JComboBox bloodT;;
    Color myColor1, myColor2;
    Font myFont, myFont1;
    ImageIcon icon;
    user u = null;
    users us = null;
    String appointment1="", appointment2="", appointment3="";


    public SignUp(users us) {

        super("Personal Info");
        this.setSize(800, 500);
        icon = new ImageIcon("Images/signup.png");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.us = us;

        myFont = new Font("Roboto", Font.PLAIN, 14);
        myFont1 = new Font("Roboto", Font.BOLD, 18);

        myColor1 = new Color(247, 231, 191);
        myColor2 = new Color(191, 198, 247, 103);


        panel = new JPanel();
        panel.setLayout(null);
        //img();

        title = new JLabel(" PERSONAL INFO");
        title.setBounds(300, 68, 200, 30);
        title.setFont(myFont1);
        this.add(title);


        userLabel = new JLabel(" User Name:");
        userLabel.setBounds(200, 100, 100, 28);
        userLabel.setFont(myFont);
        userLabel.setBackground(myColor1);
        userLabel.setOpaque(true);
        panel.add(userLabel);

        passLabel = new JLabel(" Password: ");
        passLabel.setBounds(200, 140, 100, 28);
        passLabel.setFont(myFont);
        passLabel.setBackground(Color.GRAY);
        passLabel.setForeground(Color.WHITE);
        passLabel.setOpaque(true);
        panel.add(passLabel);

        userTF = new JTextField();
        userTF.setBounds(305, 100, 200, 30);
        panel.add(userTF);

        passTF = new JPasswordField();
        passTF.setBounds(305, 140, 200, 30);
        passTF.setEchoChar('*');
        panel.add(passTF);

        genderLabel = new JLabel(" Select your gender");
        genderLabel.setBounds(200, 170, 200, 30);
        panel.add(genderLabel);
        r1 = new JRadioButton("Male");
        r1.setBounds(200, 200, 60, 20);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(260, 200, 70, 20);
        panel.add(r2);

        r3 = new JRadioButton("Other");
        r3.setBounds(330, 200, 60, 20);
        panel.add(r3);
        bg1 = new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);
        bg1.add(r3);

        bloodLabel = new JLabel(" Select Blood ");
        bloodLabel.setBounds(200, 220, 150, 20);
        panel.add(bloodLabel);

        String[] items = {"A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-"};
        bloodT = new JComboBox(items);
       bloodT.setBounds(200, 240, 100, 20);
        panel.add(bloodT);

       
        conPass = new JLabel(" Confirm Password To Finish: ");
        conPass.setBounds(200, 270, 195, 30);
        conPass.setFont(myFont);
        conPass.setBackground(Color.GRAY);
        conPass.setForeground(Color.WHITE);
        conPass.setOpaque(true);
        panel.add(conPass);


        conPassTF = new JPasswordField();
        conPassTF.setBounds(200, 310, 200, 30);
        conPassTF.setEchoChar('*');
        panel.add(conPassTF);

        icon= new ImageIcon("Images/back-48.png");

        backBtn = new JButton(icon);
        backBtn.setBounds(20, 20, 40, 40);
        backBtn.setBorder(null);
        backBtn.addActionListener(this);
        panel.add(backBtn);


        registerBtn = new JButton("REGISTER");
        registerBtn.setBounds(500, 390, 110, 25);
        registerBtn.setBackground(Color.GREEN);
        registerBtn.setForeground(Color.WHITE);
        registerBtn.addActionListener(this);
        panel.add(registerBtn);

        this.add(panel);
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

        if(backBtn.getText().equals(command)){
           Login lg= new Login(us);
            lg.setVisible(true);
            this.setVisible(false);
        }
		
        if(registerBtn.getText().equals(command)){
            String name="", pass="", gender="", type="Patient", blood="",conPass="";


            //user p = new user(name,pass,type,blood,gender);
            name = userTF.getText();         //TF input
            pass = passTF.getText();
            conPass = conPassTF.getText();

            if(r1.isSelected()){         //Radio button input
                gender = "Male";
            }else if(r2.isSelected()){
                gender = "Female";
            }else if(r3.isSelected()){
                gender = "Other";
            }

            blood = bloodT.getSelectedItem().toString();       //combobox input

            if(!name.isEmpty() && !pass.isEmpty() && !conPass.isEmpty() && !gender.isEmpty() && !blood.isEmpty() ){
                //jodi khali na thake
				
                if(us.userExists(name)){
                                                    //username same thakbe na
                    JOptionPane.showMessageDialog(this,"Username already exists. Please choose a different username.");
                }else{
                   if(pass.equals(conPass)){
                    //jodi pass and confrm pass same hoy
                        JOptionPane.showMessageDialog(this,"Sign up successful. Please login to continue.");
					     user u = new patient(name,pass,type,blood,gender);
                         us.addUser(u);
					
					
					     Login lg = new Login(us);
                         lg.setVisible(true);
                         this.setVisible(false);
                   }else{
                    //pass na mille
                    JOptionPane.showMessageDialog(this,"Password missmatched");
                }}
            }else{
                //kisu khali thakle
                JOptionPane.showMessageDialog(this,"Information missing");
            }
        

    }}}