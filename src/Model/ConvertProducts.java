
package Model;

import java.util.ArrayList;
import java.util.List;
import Controller.ProductsController;
import java.sql.SQLException;

public class ConvertProducts {
    public String[][] getProducts() throws SQLException {
        List<ModelProducts> mycc = new ArrayList<ModelProducts>();
        ProductsController cp = new ProductsController();
        mycc = cp.getALLProducts();
        String[][] databarang = new String[mycc.size()][4];
        int i = 0;
        for (ModelProducts customer : mycc) {
            databarang[i][0] = "" + customer.getProductID();
            databarang[i][1] = customer.getName();
            databarang[i][2] = "" + customer.getPrice();
            databarang[i][3] = "" + customer.getStock();

            i++;
        }
        return databarang;
    }
}

