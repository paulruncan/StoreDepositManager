package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductPageController implements ActionListener {
    AddProductPage addProductPage;

    public AddProductPageController(AddProductPage addProductPage){
        this.addProductPage=addProductPage;
    }

    /**
     * Adds a new entry to the Product table
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        try{
            String command = e.getActionCommand();
            if(command.equals("ADD")){
                String name = addProductPage.getNameField().getText();
                int quantity = Integer.parseInt(addProductPage.getQuantityField().getText());
                addProductPage.getProductsPage().getProductsPageController().getProductBLL().addProduct(name,quantity);
                addProductPage.getProductsPage().getTableModel().setRowCount(0);
                addProductPage.getProductsPage().getProductsPageController().getDataDatabase(addProductPage.getProductsPage().getTableModel());
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
