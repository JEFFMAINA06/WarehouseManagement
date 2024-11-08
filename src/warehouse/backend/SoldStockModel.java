/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warehouse.backend;

/**
 *
 * @author agoi-sharif
 */
public class SoldStockModel {

    private int ProductID;
    private String Name;
    private String Quantitysold;
    private String Sellingprice;
    private String Datesold;

    public SoldStockModel(int ProductID, String Name, String Quantitysold, String Sellingprice, String Datesold) {
        this.ProductID = ProductID;
        this.Name = Name;
        this.Quantitysold = Quantitysold;
        this.Sellingprice = Sellingprice;
        this.Datesold = Datesold;
    }

    public Object[] toRowTable() {
        return new Object[]{ProductID, Name, Quantitysold, Sellingprice, Datesold};
    }

    public int getProductid() {
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

    public String getQuantitysold() {
        return Quantitysold;
    }

    public void setQuantity(String Quantitysold) {
        this.Quantitysold = Quantitysold;
    }

    public String getSellingprice() {
        return Sellingprice;
    }

    public void setSellingprice(String Sellingprice) {
        this.Sellingprice = Sellingprice;
    }

    public String getDatesold() {
        return Datesold;
    }

    public void setDatesold(String Datesold) {
        this.Datesold = Datesold;

    }

}
