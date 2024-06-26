
package Controller;
import Connection.ConnectionManager;
import Model.ModelAdmin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;


/**
 *
 * @author audreynaila
 */
public class AdminController {
    
    private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public int createAdmin(ModelAdmin admin){
        int result = 0;
        String checkData, sql;
        
        checkData = "SELECT * FROM admins WHERE username = '" + admin.getNama()+ "'";
        sql = "INSERT INTO admins (nama, username, password) "
                + "VALUES ('" + admin.getNama() + "', '" + admin.getNama()+ "', '" + admin.getPassword() + "')";
        
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
            java.util.logging.Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return result;
    }
    
    public List<ModelAdmin> getAllAdmins() throws SQLException {
        List<ModelAdmin> admins = new ArrayList<>();
        String sql = "SELECT * FROM admins ORDER BY id_admin";

        conMan = new ConnectionManager();
        con = conMan.logOn();
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                ModelAdmin admin = new ModelAdmin();
                admin.setId_admin(rs.getInt("id_admin"));
                admin.setNama(rs.getString("nama"));
                admin.setNama(rs.getString("username"));
                admin.setPassword(rs.getString("password"));

                admins.add(admin);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return admins;
    }
    
    public int updateAdmin(ModelAdmin admin) {
        int result = 0;
        String sql = "UPDATE admins SET nama='" + admin.getNama() + "', username='" + admin.getNama() + "', password='" + admin.getPassword() + "' WHERE id_admin='" + admin.getId_admin() + "'";
        
        conMan = new ConnectionManager();
        con = conMan.logOn();
        
        try {
            st = con.createStatement();
            result = st.executeUpdate(sql);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return result;
    }
    
    public int deleteAdmin(ModelAdmin admin){
        int result = 0;
        String sql = "DELETE FROM admins WHERE id_admin = '" + admin.getId_admin() + "'";

        conMan = new ConnectionManager();
        con = conMan.logOn();
        
        try {
            st = con.createStatement();
            result = st.executeUpdate(sql);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return result;
    }
    
}
