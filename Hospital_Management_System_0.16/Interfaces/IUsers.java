package Interfaces;
import Classes.*;
public interface IUsers{

	boolean appointmentExists(String name,String  pName);
	void addUser(user u);
	void appointDoctor(user u, user b);
	boolean userExists(String name);
	int searchUser(String name);
	int searchDoctor(String name);




	//void deleteUser(String name);

}