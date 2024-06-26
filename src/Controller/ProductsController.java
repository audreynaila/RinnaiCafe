
package Controller;

/**
 *
 * @author audreynaila
 */

import Connection.ConnectionManager;
import Model.ModelProducts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;


public class ProductsController {
     private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public int createProduct(ModelProducts product) {
    int result = 0;
    String checkData, sql;

    checkData = "SELECT * FROM Products WHERE Name = '" + product.getName() + "'";
    sql = "INSERT INTO products (Name, Price, Stock) "
            + "VALUES ('" + product.getName() + "', " + product.getPrice() + ", " + product.getStock() + ")";

    conMan = new ConnectionManager();
    con = conMan.logOn();

    try {
        st = con.createStatement();
        rs = st.executeQuery(checkData);

        if (rs.next()) {
            result = -1; // Product with the same name already exists
        } else {
            result = st.executeUpdate(sql);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        java.util.logging.Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        conMan.logOff();
    }
    return result;
}


    public List<ModelProducts> getALLProducts() throws SQLException {
        List<ModelProducts> products = new ArrayList<>();
        String sql;

        sql = "SELECT * FROM products ORDER BY ProductID";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                ModelProducts product = new ModelProducts();
                product.setProductID(rs.getInt("ProductID"));
                product.setName(rs.getString("Name"));
                product.setPrice(rs.getInt("Price"));
                product.setStock(rs.getInt("Stock"));

                products.add(product);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public int updateProduct(ModelProducts product) {
        int result = 0;
        String sql = "UPDATE products SET Name='" + product.getName() + "', Price='" + product.getPrice() +  "', Stock='" + product.getStock()+ "' WHERE ProductID='" + product.getProductID() + "'";
        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            result = st.executeUpdate(sql);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }

   public int deleteProduct(int productID) {
        int result = 0;
        String sql = "DELETE FROM products WHERE ProductID = ?";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, productID);
            result = pstmt.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }

        return result;
    }
    
}
