/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warehouse.backend;

/**
 *
 * @author agoi-sharif
 */
public class CustomerModel {
     private int customerid;
       private String name;
    private String phone;
    private String email;
   
    
    
    
    public CustomerModel(int customerid, String name,String phone,String email){
        this.customerid= customerid;
        this.name = name;
        this.phone=phone;
        this.email = email;
        
        
        
    }

    
    
    public Object[] toRowTable(){
        return new Object[]{customerid,name,phone,email,};
        
    }
    public int getCustomerid(){
        return customerid;
    }
   public void setCustomerid(int customerid){
       this.customerid=customerid;
   }
    
    public String getName(){
        return name;
        
    }
    public void setName(String name){
        this.name=name;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone =phone;
    }
     public String  getEmail(){
         return email;
    }
     public void setEmail(String email){
         this.email=email;
     }

}

    

