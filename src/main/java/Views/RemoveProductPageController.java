package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveProductPageController implements ActionListener {
    RemoveProductPage removeProductPage;

    public RemoveProductPageController(RemoveProductPage removeProductPage){
        this.removeProductPage=removeProductPage;
    }

    /**
     * Removes the entry from the Product Table
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        try{
            String command = e.getActionCommand();
            if(command.equals("REMOVE")){
                String name = removeProductPage.getNameField().getText();
                removeProductPage.getProductsPage().getProductsPageController().getProductBLL().removeProductById(Integer.parseInt(name));
                removeProductPage.getProductsPage().getTableModel().setRowCount(0);
                removeProductPage.getProductsPage().getProductsPageController().getDataDatabase(removeProductPage.getProductsPage().getTableModel());
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
