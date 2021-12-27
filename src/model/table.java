package model;

import javafx.scene.control.Button;

public class table {
    int ID;
    String Product_name;
    String Manu_date;
    String Exp_date;
    int Quantity;
    Button update;

    public table(int ID, String product_name, String manu_date, String exp_date, int quantity, Button update) {
        this.ID = ID;
        Product_name = product_name;
        Manu_date = manu_date;
        Exp_date = exp_date;
        Quantity = quantity;
        this.update = update;
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

    public Button getUpdate() {
        return update;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }
}
