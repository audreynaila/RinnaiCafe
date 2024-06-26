
package Connection;
import java.sql.Connection;
/**
 *
 * @author audreynaila
 */
public class Main {
    
public static void main(String[] args) {
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        System.out.println("JDBC Connection : " + conn);

    } 
    
}
