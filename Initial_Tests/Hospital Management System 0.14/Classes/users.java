package Classes;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import Interfaces.*;


public class users implements IUsers{
	user userList[] = new user[100];
	static int userCount = 0;


	public users(){
    try{
        File file = new File("Files/patientList.txt"); //location must be the path where the file is saved
        Scanner sc = new Scanner(file);

		while (sc.hasNext()) {
			String line1 = sc.nextLine();  //name
			String line2 = sc.nextLine();  //password
			String line3 = sc.nextLine();  //type
			String line4 = sc.nextLine();  //bloodP
			String line5 = sc.nextLine();  //genderP
			String line6 = sc.nextLine(); //GAP
		
			System.out.println(line1);
			System.out.println(line2);
			System.out.println(line3);
			System.out.println(line4);
			System.out.println(line5);
			System.out.println(line6);
		   
			//patient( name,  password, type, blood , gender)
			user p = new patient(line1, line2, line3, line4, line5);
			userList[userCount] = p;
			userCount++;
		}

        sc.close();   //closing the file

    

   
        File foul = new File("Files/docList.txt"); //location must be the path where the file is saved
        Scanner sk = new Scanner(foul);

        while(sk.hasNext()){
            String line1 = sk.nextLine();  //name
            String line2 = sk.nextLine();  //password
            String line3 = sk.nextLine();  //type
            String line4 = sk.nextLine();  //dep
            String line5 = sk.nextLine();  //fee
            String line6 = sk.nextLine(); //GAP


			System.out.println(line1);
			System.out.println(line2);
			System.out.println(line3);
			System.out.println(line4);
			System.out.println(line5);
			System.out.println(line6);
               
			    //doctor(name,password,type, dep, fee )
                user d = new doctor(line1, line2, line3, line4, line5);
                userList[userCount] = d;  userCount++;
            
        }

        sk.close();   //closing the file
 
    }catch(Exception ex){

        System.out.println("File not found.");
        return;
    }
}




public void addUser(user u){
    userList[userCount] = u; 
    userCount++;  
	if(u.getType().equals("Doctor")){
        String userDetails=u.getName() + "\n" + u.getPassword() + "\n"+ u.getType() + "\n" + ((doctor)u).getDep() + "\n" + ((doctor)u).getFee() + "\n" + "\n";
        try{
            FileWriter fw = new FileWriter("Files/docList.txt",true);
            fw.write(userDetails);
            fw.close();
        }catch(Exception ex){
            System.out.println("Error writing to file: ");
        }
    }else if(u.getType().equals("Patient")){
        String userDetails=u.getName() + "\n" + u.getPassword() + "\n"+ u.getType() + "\n" + ((patient)u).getBlood() + "\n" + ((patient)u).getGender() + "\n" + "\n";
        try{
            FileWriter fw = new FileWriter("Files/patientList.txt",true);
            fw.write(userDetails);
            fw.close();
        }catch(Exception ex){
            System.out.println("Error writing to file: ");
        }
    }
}
		//before writing in file check "type" then create object in their respective txt files
	
	public boolean userExists(String name){
		for(int i = 0; i < userCount; i++){
			if(userList[i].getName().equals(name)){
				return true;
			}
		}
		return false;
	}

	public int searchUser(String name){
		int index = -1;
		for(int i=0;i<userCount;i++){ //(int i=0;i<userCount;i++)
			if(userList[i].getName().equals(name)){
				index = i;
				break;
			}else{}
		}
		return index;
	}
	
	public user checkCredentials(int index, String pass){
		if(userList[index].getPassword().equals(pass)){
			return userList[index];
		}else{
			return null;
		}
	}



}