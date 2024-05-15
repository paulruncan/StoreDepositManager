package Views;

import BLL.ProductBLL;
import Model.Customer;
import Model.Product;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductsPageController implements ActionListener {

    private ProductsPage productsPage;
    private ProductBLL productBLL;

    public ProductsPageController(ProductsPage productsPage){
        this.productsPage=productsPage;
        this.productBLL=new ProductBLL();
    }
    public String[] giveFields(){
        return productBLL.getProductDAO().getFields();
    }
    public void getDataDatabase( DefaultTableModel tableModel ) {
        List<Product> products = productBLL.getProductDAO().findAll();
        String[] object;
        for(Product product : products){
            //System.out.println((String) customer.getId() + " " + customer.getName());
            //String da = customer.getId
            object = new String[]{Integer.toString(product.getId()), product.getName(),Integer.toString(product.getQuantity())};
            tableModel.addRow(object);
        }
    }

    /**
     * based on the buttons opens the corresponding page
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        try{
            String command = e.getActionCommand();
            if(command.equals("addproduct")){
                AddProductPage addClientPage = new AddProductPage(this.productsPage,"ADD");
                addClientPage.setVisible(true);
            }
            if(command.equals("deleteproduct")){
                RemoveProductPage removeProductPage = new RemoveProductPage(this.productsPage,"REMOVe");
                removeProductPage.setVisible(true);
            }
            if(command.equals("editproduct")){
                EditProductPage editProductPage = new EditProductPage(this.productsPage, "EDIT");
                editProductPage.setVisible(true);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public ProductsPage getProductsPage() {
        return productsPage;
    }

    public ProductBLL getProductBLL() {
        return productBLL;
    }
}
