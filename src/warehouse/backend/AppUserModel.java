/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warehouse.backend;

/**
 *
 * @author HP
 */
public class AppUserModel {
    private int appuserid;
    private String name;
    private String mobile;
    private String email;
    private String password;
    
    
    
    public AppUserModel(int appuserid,String username, String mobileno,String email,String password){
        this.appuserid=appuserid;
        this.name= username;
        this.mobile = mobileno;
        this.email = email;
        this.password=password;
        
        
    }

    
    
    public Object[] toRowTable(){
        return new Object[]{appuserid,name,mobile,email,password};
        
    }
    public int getappuserid(){
        return appuserid;
}
public void setAppuserid(int appuserid){
    this.appuserid=appuserid;
    }
    
    public String getName(){
        return name;
        
    }
    public void setName(String name){
        this.name=name;
    }
    public String getMobile(){
        return mobile;
    }
    public void setMobile(String mobile){
        this.mobile =mobile;
    }
     public String  getEmail(){
         return email;
    }
     public void setEmail(String email){
         this.email=email;
     }
   public String getPassword(){
        return password;
    }
   public void setPassword(String password){
       this.password=password;
   }
}
