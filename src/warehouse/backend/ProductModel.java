/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warehouse.backend;

/**
 *
 * @author agoi-sharif
 */
public class ProductModel {

   
    
    private int ProductID;
    private String Name;
    private String Quantity;
    private String Price;
    private String Description;
    private String Category;

    public ProductModel(int ProductID, String Name, String Quantity, String Price, String Description, String Category) {
        this.ProductID = ProductID;
        this.Name = Name;
        this.Quantity = Quantity;
        this.Price = Price;
        this.Description = Description;
        this.Category = Category;
    }

    public Object[] toRowTable() {
        return new Object[]{ProductID, Name, Quantity, Price, Description, Category};
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

}
