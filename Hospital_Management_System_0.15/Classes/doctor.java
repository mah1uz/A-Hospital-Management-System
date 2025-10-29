package Classes;
import java.lang.*;
public  class doctor  extends user {
	
    private String dep;
    private String fee;
    public doctor(String name, String password,String type,String dep,String fee ) {
        super(name,password,type);
        this.dep= dep;
        this.fee= fee;
    }
    public void setDep(String dep){
        this.dep=dep;
    }
    public String getDep(){
        return dep;
    }
    public void setFee(String fee){
        this.fee=fee;
    }
    public String getFee(){
        return fee;
    }
}