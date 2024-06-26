
package Controller;



import Connection.ConnectionManager;
import Model.ModelOrders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OrdersController {
    private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;

   public int createOrder(ModelOrders order) {
    int result = 0;
    String sql;

    sql = "INSERT INTO Orders (OrderID, CustomerID, TotalAmount) "
            + "VALUES ('" + order.getOrderID() + "','" + order.getCustomerID() + "'," + order.getTotalAmount() + ")";

    conMan = new ConnectionManager();
    con = conMan.logOn();

    try {
        st = con.createStatement();
        result = st.executeUpdate(sql);

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        java.util.logging.Logger.getLogger(OrdersController.class.getName()).log(Level.SEVERE, null, ex);
    }
    conMan.logOff();
    return result;
}

    public List<ModelOrders> getOrders() throws SQLException {
        List<ModelOrders> orders = new ArrayList<>();
        String sql;

        sql = "SELECT * FROM Orders ORDER BY OrderID";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                ModelOrders order = new ModelOrders();
                order.setOrderID(rs.getInt("OrderID"));
                order.setCustomerID(rs.getInt("CustomerID"));
                order.setTotalAmount(rs.getInt("TotalAmount"));

                orders.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(OrdersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    public int updateOrder(ModelOrders order) {
        int result = 0;
        String sql = "UPDATE Orders SET CustomerID='" + order.getCustomerID()  + "', TotalAmount=" + order.getTotalAmount() + " WHERE OrderID='" + order.getOrderID() + "'";
        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            result = st.executeUpdate(sql);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(OrdersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }

    public int deleteOrder(int orderID) {
        int result = 0;
        String sql = "DELETE FROM Orders WHERE OrderID = '" + orderID + "'";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            result = st.executeUpdate(sql);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(OrdersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }

    
    public void autonumber(JTextField textField) {
    try {
        conMan = new ConnectionManager();
        con = conMan.logOn();

        String sql = "SELECT * FROM Orders ORDER BY OrderID DESC";
        st = con.createStatement();
        rs = st.executeQuery(sql);

        if (rs.next()) {
            int lastOrderID = rs.getInt("OrderID");
            int newOrderID = lastOrderID + 1;
            textField.setText(String.valueOf(newOrderID));
        } else {
            textField.setText("1");
        }

        rs.close();
        st.close();
        conMan.logOff();
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(OrdersController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}



