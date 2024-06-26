
package Controller;

/**
 *
 * @author audreynaila
 */
import Connection.ConnectionManager;
import Model.ModelCustomers;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;

public class CustomersController {
       private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public int createCustomer(ModelCustomers customer){
        int result = 0;
        String checkData, sql;
        
        checkData = "SELECT * FROM customers WHERE username = '" + customer.getUsername() + "'";
        sql = "INSERT INTO customers (name, username, password, email) "
                + "VALUES ('" + customer.getName() + "', '" + customer.getUsername() + "', '" + customer.getPassword() + "', '" + customer.getEmail() + "')";
        
        conMan = new ConnectionManager();
        con = conMan.logOn();
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(checkData);

            if (rs.next()) {
                result = -1; // Username already exists
            } else {
                result = st.executeUpdate(sql);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return result;
    }
    
    public List<ModelCustomers> getAllCustomers() throws SQLException {
        List<ModelCustomers> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers ORDER BY id";

        conMan = new ConnectionManager();
        con = conMan.logOn();
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                ModelCustomers customer = new ModelCustomers();
                customer.setid(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setEmail(rs.getString("email"));

                customers.add(customer);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return customers;
    }
     public void resetCustomerId() {
    String deleteSql = "DELETE FROM customers";
    String alterSql = "ALTER TABLE customers AUTO_INCREMENT = 1";

    conMan = new ConnectionManager();
    con = conMan.logOn();

    try {
        st = con.createStatement();
        st.executeUpdate(deleteSql);
        st.executeUpdate(alterSql);
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
    }

    conMan.logOff();
}

public int deleteCustomer(int id) {
    int result = 0;
    String deleteSql = "DELETE FROM customers WHERE id = ?";

    conMan = new ConnectionManager();
    con = conMan.logOn();

    try {
        PreparedStatement pstmt = con.prepareStatement(deleteSql);
        pstmt.setInt(1, id);
        result = pstmt.executeUpdate();
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
    }

    conMan.logOff();

    // Reset customerID numbering
    resetCustomerId();

    return result;
}


    private static class CustomerController {

        public CustomerController() {
        }
    }
}
