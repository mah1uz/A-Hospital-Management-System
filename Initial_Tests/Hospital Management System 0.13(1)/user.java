import java.lang.*;

public class user {
	private String name;
	private String password;
	private String gender;
	private String blood;
	private String age;
	private String nid;


    public user(String name, String password, String gender, String blood, String age, String nid) {


		this.name = name;
		this.password = password;
		this.gender = gender;
		this.blood = blood;
		this.age= age;
		this.nid= nid;
		
		
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public void setBlood(String blood){
		this.blood = blood;
	}
	public void setAge(String age){
		this.age = age;
	}
	public void setNID(String nid){
		this.nid = nid;
	}



	public String getName(){
		return name;
	}
	public String getPassword(){
		return password;
	}
	public String getGender(){
		return gender;
	}
	public String getBlood(){
		return blood;
	}
	public String getAge(){
		return age;
	}
	public String getNID(){
		return nid;
	}
}