
package Model;

import java.util.ArrayList;
import java.util.List;
import Controller.CustomersController;
import Controller.CustomersController;
import java.sql.SQLException;


public class ConvertCustomer {
    public String[][] getCustomer() throws SQLException {
        List<ModelCustomers> mycc = new ArrayList<ModelCustomers>();
        CustomersController cc = new CustomersController();
        mycc = cc.getAllCustomers();
        String[][] databarang = new String[mycc.size()][5];
        int i = 0;
        for (ModelCustomers customer : mycc) {
            databarang[i][0] = "" + customer.id();
            databarang[i][1] = customer.getName();
            databarang[i][2] = customer.getEmail();
            databarang[i][3] = "" + customer.getUsername();
            databarang[i][4] = "" + customer.getPassword();

            i++;
        }
        return databarang;
    }
}

