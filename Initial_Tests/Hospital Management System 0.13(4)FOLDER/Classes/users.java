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
			File file = new File("Files/userList.txt"); //location must be the path where the file is saved
			Scanner sc = new Scanner(file);
				while(sc.hasNext()){
					String line1 = sc.nextLine();  //name
					String line2 = sc.nextLine();  //password
					String line3 = sc.nextLine();  //gender or profession
					String line4 = sc.nextLine();  //blood
					String line5 = sc.nextLine();  //age
					String line6 = sc.nextLine();  //nid
					String line7 = sc.nextLine(); //GAP
				
					
					//user u = new user(name,pass,gender,blood,age,nid);
					user u = new user(line1,line2,line3,line4,line5,line6);
					userList[userCount] = u; userCount++;
					
				}
			sc.close();   //closing the file 		
		}catch(Exception ex){
			
			System.out.println("File not found.");
			return;
		}
	}
	
	public void addUser(user u){
		userList[userCount] = u; 
		userCount++;
	}

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
		for(int i = 0; i<userCount ; i++){
			if(userList[i].getName().equals(name)){
				index = i;
				break;
			}
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