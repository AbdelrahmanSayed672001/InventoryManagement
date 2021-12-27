package sample;
import DataBase.products;
import Domain.pro;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    TextField id;
    @FXML
    TextField product_name;
    @FXML
    TextField manu_date;
    @FXML
    TextField exp_date;
    @FXML
    TextField quantity;
    @FXML
    TableView<pro> table;
    @FXML
    TableColumn<pro, Integer> col_id;
    @FXML
    TableColumn<pro,String> col_product_name;
    @FXML
    TableColumn<pro,String> col_manu_date;
    @FXML
    TableColumn<pro,String> col_exp_date;
    @FXML
    TableColumn<pro,Integer> col_quantity;


    public void AddProduct(javafx.event.ActionEvent event) {
        int ID = Integer.parseInt(id.getText());
        String Product_name = product_name.getText();
        String Manu_date = manu_date.getText();
        String Exp_date = exp_date.getText();
        int Quantity = Integer.parseInt(quantity.getText());
        try {
            Connection c = products.GetConnection();
            products.AddProduct(ID, Product_name, Manu_date, Exp_date, Quantity);
            TableUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "The database is not exist"
                    , "Error Connection", JOptionPane.ERROR_MESSAGE);
        }
    }






    public void DeleteProduct(javafx.event.ActionEvent event){
        int ID= Integer.parseInt(id.getText());
        String Product_name=product_name.getText();
       /* String Manu_date=manu_date.getText();
        String Exp_date=exp_date.getText();
        int Quantity= Integer.parseInt(quantity.getText());*/
        try {
            Connection c = products.GetConnection();
            products.Delete(ID, Product_name/*, Manu_date, Exp_date, Quantity*/);
            TableUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "The database is not exist"
                    , "Error Connection", JOptionPane.ERROR_MESSAGE);
        }
    }









    public void TableUpdate(){
        ObservableList<pro> list;
        int index=-1;
        Connection c=null;
        ResultSet rs=null;
        PreparedStatement pst=null;
        col_id.setCellValueFactory(new PropertyValueFactory<pro,Integer>("ID"));
        col_product_name.setCellValueFactory(new PropertyValueFactory<pro,String>("product_name"));
        col_manu_date.setCellValueFactory(new PropertyValueFactory<pro,String>("Manu_date"));
        col_exp_date.setCellValueFactory(new PropertyValueFactory<pro,String>("Exp_date"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<pro,Integer>("quantity"));
        list=products.GetDatePro();
        table.setItems(list);
    }






    public void UpdateProduct(){
        int ID= Integer.parseInt(id.getText());
        String Product_name=product_name.getText();
        try {
            Connection c = products.GetConnection();
            products.Update(ID, Product_name);
            TableUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "The database is not exist"
                    , "Error Connection", JOptionPane.ERROR_MESSAGE);
        }
    }









    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableUpdate();

    }
}
