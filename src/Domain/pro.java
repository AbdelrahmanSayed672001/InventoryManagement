package Domain;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class pro {
    private int ID;
    private String Product_name;
    private String Manu_date;
    private String Exp_date;
    private int Quantity;


    public pro(int ID, String product_name, String manu_date, String exp_date, int quantity) {
        this.ID = ID;
        this.Product_name = product_name;
        this.Manu_date = manu_date;
        this.Exp_date = exp_date;
        this.Quantity = quantity;
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public String getManu_date() {
        return Manu_date;
    }

    public void setManu_date(String manu_date) {
        Manu_date = manu_date;
    }

    public String getExp_date() {
        return Exp_date;
    }

    public void setExp_date(String exp_date) {
        Exp_date = exp_date;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
