import java.lang.*;
import java.io.*;
import java.util.Scanner;

public  class users{
	user userList[] = new user[100];
	static int userCount = 0;


	users(){
		user u1 = new user("Fahmida","78910","Female","A+","12","123456789");
		userList[userCount] = u1; userCount++;
		user u2 = new user("Rashed","abcd","Male","A+","12","123456789");
		userList[userCount] = u2; userCount++;
	}
	
	void addUser(user u){
		userList[userCount] = u; 
		userCount++;
	}
	
	int searchUser(String name){
		int index = -1;
		for(int i = 0; i<userCount ; i++){
			if(userList[i].getName().equals(name)){
				index = i;
				break;
			}
		}
		return index;
	}
	
	user checkCredentials(int index, String pass){
		if(userList[index].getPassword().equals(pass)){
			return userList[index];
		}else{
			return null;
		}
	}
}