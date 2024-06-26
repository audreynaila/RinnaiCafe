
package Model;


public class ModelProducts {
    private int ProductID;
    private String Name;
    private int Price;
    private int Stock;

    public ModelProducts() {
    }

    public ModelProducts(int ProductID, String Name, int Price, int Stock) {
        this.ProductID = ProductID;
        this.Name = Name;
        this.Price = Price;
        this.Stock = Stock;
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

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

   

    @Override
    public String toString() {
        return "ModelProducts{" + "productID=" + ProductID + ", name=" + Name + ", price=" + Price + ", stock=" + Stock + '}';
    }

   
}

