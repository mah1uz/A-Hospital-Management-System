package Classes;

import java.lang.*;

public  class patient extends user {
    
    private String blood;
    private String gender;

public patient(String name, String password,String type,String blood ,String gender){
    super(name,password, type);
   this.blood=blood;
    this.gender= gender;
}   


public void setBlood(String blood){
    this.blood=blood;
}
public String getBlood(){
    return blood;
}

public void setGender(String gender){
    this.gender=gender;
}
public String getGender(){
    return gender;
}
}