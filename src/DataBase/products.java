package DataBase;

import Domain.pro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class products {


    public static ObservableList<pro> GetDatePro(){
        ObservableList<pro> list= FXCollections.observableArrayList();
        try {
            Connection c=GetConnection();
            PreparedStatement pst=c.prepareStatement(
                    "SELECT ID, Product_name,Manu_date,Exp_date,quantity FROM products");
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                list.add(new pro(Integer.parseInt(rs.getString("ID")),
                        rs.getString("Product_name"),rs.getString("Manu_date"),
                        rs.getString("Exp_date"),Integer.parseInt(rs.getString("quantity")) ) );

            }

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "The database is not exist"
                    , "Error Connection", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }





    public static Connection GetConnection() throws Exception {
        return DriverManager.getConnection("jdbc:mysql://localhost/im", "root", "");
    }




    public static void AddProduct(int ID, String Product_name, String Manu_date
            , String Exp_date, int Quantity) {

        try {
            Connection c = GetConnection();
            try {
                PreparedStatement pst = c.prepareStatement(
                        "INSERT INTO products(ID,Product_name,Manu_date,Exp_date,quantity) VALUES (?,?,?,?,?)");
                pst.setString(1, String.valueOf(ID));
                pst.setString(2, Product_name);
                pst.setString(3, Manu_date);
                pst.setString(4, Exp_date);
                pst.setString(5, String.valueOf(Quantity));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, " The product is added"
                        , "insert successful", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"ID "+ID+" is already exist"
                ,"Error",JOptionPane.WARNING_MESSAGE);
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Connection"
                    , "The database is not exist", JOptionPane.ERROR_MESSAGE);
        }

    }




    public static ArrayList<pro> GetProducts() {
        ArrayList<pro> list = new ArrayList<>();
        try {
            Connection c = GetConnection();
            PreparedStatement pst = c.prepareStatement("SELECT * FROM products");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new pro(rs.getInt("ID"), rs.getString("Product_name")
                        , rs.getString("Manu_date"), rs.getString("Exp_date"),
                        rs.getInt("quantity")));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error", "Error occurred", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }




    public static void Delete(int ID, String Product_name/*, String Manu_date
            , String Exp_date, int Quantity*/){
       try {
           Connection c = GetConnection();
               Statement pst = c.createStatement();
               String sql="DELETE FROM products WHERE ID="+ID;
               pst.execute(sql);
               JOptionPane.showMessageDialog(null, " The product is deleted"
                       , "Delete successful", JOptionPane.INFORMATION_MESSAGE);

       }catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Error Connection"
                   , "The database is not exist", JOptionPane.ERROR_MESSAGE);
       }

   }




    public static void Check(int ID, String Product_name, String Manu_date
            , String Exp_date, int Quantity) {

        ArrayList<pro> list = GetProducts();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID() == ID) {
                if (list.get(i).getProduct_name() == Product_name) {

                    if (list.get(i).getManu_date() == Manu_date) {

                        if (list.get(i).getExp_date() == Exp_date) {

                            if (list.get(i).getQuantity() == Quantity) {
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Error in Quantity", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Error in Exp_date", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Error in Manu_date", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error in Product_name", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "Error in ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }




    public static void Update(int ID, String Product_name){
        try {
            Connection c = GetConnection();
            Statement pst = c.createStatement();
            String sql="UPDATE products SET Product_name='"+Product_name+"'where ID='"+ID+"'";
            pst.execute(sql);
            JOptionPane.showMessageDialog(null, " The product is updated"
                    , "Update successful", JOptionPane.INFORMATION_MESSAGE);

        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Connection"
                    , "The database is not exist", JOptionPane.ERROR_MESSAGE);
        }
    }






}