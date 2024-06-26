
package Model;

/**
 *
 * @author audreynaila
 */
public class ModelAdmin {
    private int id_admin;
    private String nama;
    private String password;
    private String username;
   

    public ModelAdmin() {
    
    }

    public ModelAdmin(int id_admin, String nama, String password, String username) {
        this.id_admin = id_admin;
        this.nama = nama;
        this.password = password;
        this.username = username;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
   
    @Override
    public String toString() {
        return "ModelAdmin{" +
            "id_admin=" + id_admin +
            ", nama='" + nama + '\'' +
            ", password='" + password + '\'' +
            ", username='" + username + '\'' +'}';
    }

   
}
