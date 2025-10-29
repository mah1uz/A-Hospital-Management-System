package Classes;
import java.lang.*;


public abstract class user {
	private String name;
	private String password;
	private String type;

    public user(String name, String password,String type) {
		this.name = name;
		this.password = password;
		this.type = type;
		
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getName(){
		return name;
	}
	public String getPassword(){
		return password;
	}
	public String getType(){
		return type;
	}
	
}