/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warehouse.backend;

/**
 *
 * @author HP
 */
public class CategoryModel {

    
    private int categoryid;
    private String nametxt;
    
    
    public CategoryModel(int categoryid,String name){
        this.nametxt = name;
        this.categoryid=categoryid;
        
    }

   
    
    public Object[] toRowTable(){
        return new Object[]{categoryid,nametxt};
        
    }
    public int getCategoryID(){
        return categoryid;
    }
    public void setCategoryID(int Categoryid){
        this.categoryid=Categoryid;
        
    }
    
    public String getName(){
        return nametxt;
    }
    public void setName(String Name){
        this.nametxt= Name;
    }

}
    
