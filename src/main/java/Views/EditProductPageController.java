package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProductPageController implements ActionListener {
    EditProductPage editProductPage;
    public EditProductPageController( EditProductPage editProductPage ) {
    this.editProductPage=editProductPage;
    }

    /**
     * edits the entry of a Product table entry
     * @param e the event to be processed
     */
    @Override
        public void actionPerformed(ActionEvent e ) {
            try{
                String command = e.getActionCommand();
                if(command.equals("EDIT")){
                    String id = editProductPage.getIdField().getText();
                    String name = editProductPage.getNameField().getText();
                    String quantity = editProductPage.getQuantityField().getText();
                    editProductPage.getProductsPage().getProductsPageController().getProductBLL().editProduct(Integer.parseInt(id),name,Integer.parseInt(quantity));
                    editProductPage.getProductsPage().getTableModel().setRowCount(0);
                    editProductPage.getProductsPage().getProductsPageController().getDataDatabase(editProductPage.getProductsPage().getTableModel());
                }
            } catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

