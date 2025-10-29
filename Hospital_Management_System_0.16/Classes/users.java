package Classes;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import Interfaces.*;
//user has users
public class users implements IUsers {
	user userList[] = new user[100];
	user visitList[] = new user[100];

	public static int visitCount = 0;
	static int userCount = 0;
	static int docCount = 0;
	static int depCount = 0;
    public static int k = 0;
	


	String docNames[] = new String[100];
	String depNames[] = new String[100];


	public users() {
		try {
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

			sc.close();//closing the file
		} catch (Exception ex) {
			System.out.println("File not found -patientList");
			return;
		}

		try {
			File foul = new File("Files/docList.txt"); //location must be the path where the file is saved
			Scanner sk = new Scanner(foul);
			while (sk.hasNext()) {
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
				userList[userCount] = d;
				docNames[docCount] = line1;
				depNames[docCount] = line4;

				userCount++;
				docCount++;
				depCount++;
			}
			sk.close();
		} catch (Exception ex1) {
			System.out.println("File not found docList");
			return;
		}

		try {
			File fl = new File("Files/doc1List.txt"); //location must be the path where the file is saved
			Scanner skan = new Scanner(fl);
			while (skan.hasNext()) {
				String line1 = skan.nextLine();  //name
				String line2 = skan.nextLine();  //password
				String line3 = skan.nextLine();  //type
				String line4 = skan.nextLine();  //dep
				String line5 = skan.nextLine();  //fee
				String line6 = skan.nextLine(); //GAP


				System.out.println(line1);
				System.out.println(line2);
				System.out.println(line3);
				System.out.println(line4);
				System.out.println(line5);
				System.out.println(line6);

				//doctor(name,doc name,doc dep, blood, gender )
				user b = new patient(line1, line2, line3, line4, line5);
				visitList[visitCount] = b;
				visitCount++;
			}
			skan.close();   //closing the file
		} catch (Exception ex) {
			System.out.println("File not found- doc1List");
			return;
		}
	}


	public void appointDoctor(user u, user b) {

		//if(u.getType().equals("Patient")){

		String userDetails = u.getName() + "\n" + b.getName() + "\n" + ((doctor) b).getDep() + "\n" + ((patient) u).getBlood() + "\n" + ((patient) u).getGender() + "\n" + "\n";
		user x = new patient(u.getName(), b.getName(), ((doctor) b).getDep(), ((patient) u).getBlood(), ((patient) u).getGender());
		visitList[visitCount] = x;
		visitCount++;


		try {
			FileWriter fw = new FileWriter("Files/doc1List.txt", true);
			fw.write(userDetails);
			fw.close();
		} catch (Exception ex) {
			System.out.println("Error writing to file: doc1List ");
		}
	}

	public void addUser(user u) {
		userList[userCount] = u;
		userCount++;
		if (u.getType().equals("Doctor")) {
			String userDetails = u.getName() + "\n" + u.getPassword() + "\n" + u.getType() +
					"\n" + ((doctor) u).getDep() + "\n" + ((doctor) u).getFee() + "\n" + "\n";
			try {
				FileWriter fw = new FileWriter("Files/docList.txt", true);
				fw.write(userDetails);
				fw.close();
			} catch (Exception ex) {
				System.out.println("Error writing to file:doc1List ");
			}
		} else if (u.getType().equals("Patient")) {
			String userDetails = u.getName() + "\n" + u.getPassword() + "\n" + u.getType() +
					"\n" + ((patient) u).getBlood() + "\n" + ((patient) u).getGender() + "\n" + "\n";
			try {
				FileWriter fw = new FileWriter("Files/patientList.txt", true);
				fw.write(userDetails);
				fw.close();
			} catch (Exception ex) {
				System.out.println("Error writing to file:doc1List ");
			}
		}
	}
	//before writing in file check "type" then create object in their respective txt files


	public boolean appointmentExists(String name,String  pName) {
		for (int i = 0; i < visitCount; i++) {
			if (visitList[i].getPassword().equals(name) && visitList[i].getName().equals(pName) )  {
				return true;
			}
		}
		return false;
	}


	public boolean userExists(String name) {
		for (int i = 0; i < userCount; i++) {
			if (userList[i].getName().equals(name)) {
				return true;

			}
		}
		return false;
	}




	public int searchUser(String name) {
		int index = -1;
		for (int i = 0; i < userCount; i++) { //(int i=0;i<userCount;i++)
			if (userList[i].getName().equals(name)) {
				index = i;
				break;
			} else {
			}
		}
		return index;
	}


	public int searchDoctor(String name) {
		int index = -1;
		for (int i = 0; i < userCount; i++) { //(int i=0;i<userCount;i++)
			if (userList[i].getName().equals(name) && userList[i].getType().equals("Doctor")) {
				index = i;
				break;
			} else {
			}
		}
		return index;
	}


	public user checkCredentials(int index, String pass) {
		if (userList[index].getPassword().equals(pass)) {
			return userList[index];
		} else {
			return null;
		}
	}


	public String getDocName(int a) {
		if (a < docCount) {
			return docNames[a];
		} else {
			return null;
		}
	}

	public user getProfile(int index) {
		if (index < userCount) {
			return userList[index];
		} else {
			return null;
		}
	}


	public String getDep(int a) {
		if (a < depCount) {
			return depNames[a];
		} else {
			return null;
		}
	}



	public int noOfPatients(String docName) {
		int noOfPatient = 0;
		for(int i=0;i<visitCount;i++) {
			if (visitList[i].getPassword().equals(docName)) {

				noOfPatient++;
continue;
			}
		} return noOfPatient;
	}




	public String getPatientList(String docName, int y) {
		String patientDetails = "";

		for (int i = y; i < visitCount; i++) {
			if (visitList[i].getPassword().equals(docName)) {
				patientDetails = "\n " + "Name :" + visitList[i].getName() + "\n   " +
						"Blood Group: " + ((patient) visitList[i]).getBlood() + "\n  " + "Gender :" + ((patient) visitList[i]).getGender() + "\n";
				k = i + 1;
				break;
			}
		}
		return patientDetails;
	}
	
	
	
	
	public void deleteUser(int i){
		//deleting them from array not the actul file
		user u = null;
		
			
				u = visitList[i];
				for(int j = i; j< visitCount; j++){
					visitList[j] = visitList[j+1];
				}
				visitCount--;
				visitList[visitCount] = null;

				
				
            }


}



/*public void deleteUser(int i){
		//deleting them from array
		user u = null;
		
			
				u = visitList[i];
				for(int j = i; j< visitCount; j++){
					visitList[j] = visitList[j+1];
				}
				visitCount--;
				visitList[visitCount] = null;
				break;
				
				
            }*/






	/*public void deleteUser(user v,int noOfPatients){
		//deleting them from array
		//user u = null;

			//if(userList[noOfPatients].getName().equals(name)){
				u = userList[noOfPatients];

					visitList[noOfPatients] = visitList[noOfPatients+1];

				visitCount--;
				visitList[visitCount] = null;

			}


		//also deleting from file
		String userDetails = u.getName() + "\n" + u.getName() + "\n" + ((doctor) b).getDep() + "\n" + ((patient) u).getBlood() + "\n" + ((patient) u).getGender() + "\n" ;

		try{
			String filepath = "Files/doc1List.txt";
			File originalFile = new File(filepath);

			String newDetails = "";
			Scanner sc = new Scanner(originalFile);
			while(sc.hasNext()){
				String readUser = sc.nextLine() + "\n";
				readUser += sc.nextLine() + "\n";
				readUser += sc.nextLine() + "\n";
				readUser += sc.nextLine() + "\n";
				readUser += sc.nextLine() +"\n";
				readUser += sc.nextLine();

				System.out.println(readUser);
				System.out.println(userDetails);

				if(readUser.equals(userDetails)){
					System.out.println("Equal, so deleting");
					continue;
				}
				System.out.println("Writing");
				newDetails += readUser + "\n";
			} sc.close();
			FileWriter fw = new FileWriter(filepath);
			fw.write(newDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}*/

