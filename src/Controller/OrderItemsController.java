
package Controller;



import Connection.ConnectionManager;
import Model.ModelOrderItems;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OrderItemsController {
    private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public int createOrderItem(ModelOrderItems orderItem) {
        int result = 0;
        String sql;

        sql = "INSERT INTO Order_Items (OrderItemID, OrderID, ProductID, Quantity, Price) "
                + "values('" + orderItem.getOrderItemID() + "','" + orderItem.getOrderID() + "','" + orderItem.getProductID() + "','" + orderItem.getQuantity() + "','" + orderItem.getPrice() + "')";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            result = st.executeUpdate(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(OrderItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }

    public List<ModelOrderItems> getALLOrderItems() throws SQLException {
    List<ModelOrderItems> orderItems = new ArrayList<>();
    String sql;

    sql = "SELECT * FROM Order_Items ORDER BY OrderItemID";

    conMan = new ConnectionManager();
    con = conMan.logOn();

    try {
        st = con.createStatement();
        rs = st.executeQuery(sql);

        while (rs.next()) {
            ModelOrderItems orderItem = new ModelOrderItems();
            orderItem.setOrderItemID(rs.getInt("OrderItemID"));
            orderItem.setOrderID(rs.getInt("OrderID"));
            orderItem.setProductID(rs.getInt("ProductID"));
            orderItem.setQuantity(rs.getInt("Quantity"));
            orderItem.setPrice(rs.getInt("Price"));

            orderItems.add(orderItem);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        java.util.logging.Logger.getLogger(OrderItemsController.class.getName()).log(Level.SEVERE, null, ex);
    }
    return orderItems;
}



    public int updateOrderItem(ModelOrderItems orderItem) {
        int result = 0;
        String sql = "UPDATE Order_Items SET Quantity='" + orderItem.getQuantity() + "', Price='" + orderItem.getPrice() + "' WHERE OrderID='" + orderItem.getOrderID() + "' AND ProductID='" + orderItem.getProductID() + "'";
        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            result = st.executeUpdate(sql);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(OrderItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }

    public int deleteOrderItem(int orderItemID) throws SQLException {
    String sql = "DELETE FROM Order_Items WHERE OrderItemID = ?";
    conMan = new ConnectionManager();
    con = conMan.logOn();
    
    try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
        stmt.setInt(1, orderItemID);
        return stmt.executeUpdate();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        java.util.logging.Logger.getLogger(OrderItemsController.class.getName()).log(Level.SEVERE, null, ex);
        return 0;
    } finally {
        conMan.logOff();
    }
}

    
    public void autonumber(JTextField textField) {
    try {
        conMan = new ConnectionManager();
        con = conMan.logOn();

        String sql = "SELECT * FROM Order_Items ORDER BY OrderItemID DESC";
        st = con.createStatement();
        rs = st.executeQuery(sql);

        if (rs.next()) {
            int lastOrderItemID = rs.getInt("OrderItemID");
            int newOrderItemID = lastOrderItemID + 1;
            textField.setText(String.valueOf(newOrderItemID));
        } else {
            textField.setText("1");
        }

        rs.close();
        st.close();
        conMan.logOff();
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(OrderItemsController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

   



}

