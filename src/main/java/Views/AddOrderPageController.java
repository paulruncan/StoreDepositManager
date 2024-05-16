package Views;

import BLL.BillBLL;
import Model.Bill;
import Model.Product;

import javax.management.BadAttributeValueExpException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.List;

public class AddOrderPageController implements ActionListener {
     private AddOrderPage addOrderPage;
     private BillBLL billBLL;

     public AddOrderPageController(AddOrderPage addOrderPage){

         this.addOrderPage=addOrderPage;
            this.billBLL=new BillBLL();
     }

    /**
     * When e = "ADD", adds a new entry to the Order Table;
     *      e = "BILLS", opens the BILLS page
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        try{
            String command = e.getActionCommand();
            if(command.equals("ADD")){
                int rowCustomer = addOrderPage.getTabelCustomer().getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) addOrderPage.getTabelCustomer().getModel();
                String customerName = model.getValueAt(rowCustomer,1).toString();
                int rowProduct = addOrderPage.getTabelProduct().getSelectedRow();
                DefaultTableModel modelP = (DefaultTableModel) addOrderPage.getTabelProduct().getModel();
                int productID = Integer.parseInt(modelP.getValueAt(rowProduct,0).toString());
                String productName = modelP.getValueAt(rowProduct,1).toString();
                int availableQuantity = Integer.parseInt(modelP.getValueAt(rowProduct,2).toString());
                int neededQuantity = Integer.parseInt(addOrderPage.getQuantityField().getText());
                System.out.println(customerName);
                System.out.println(productName);
                System.out.println(neededQuantity);
                System.out.println(availableQuantity);
                if(neededQuantity > availableQuantity)
                    throw new InputMismatchException("no");
                if(neededQuantity <= 0 )
                    throw new BadAttributeValueExpException("da");
                addOrderPage.getOrdersPage().getOrdersPageController().getOrderBLL().addOrder(customerName,productName,neededQuantity);
                billBLL.getBillDAO().insert(new Bill(0,customerName,productName,neededQuantity));
                addOrderPage.getOrdersPage().getTableModel().setRowCount(0);
                addOrderPage.getOrdersPage().getOrdersPageController().getDataDatabase(addOrderPage.getOrdersPage().getTableModel());
                addOrderPage.getProductBLL().editProduct(productID,productName,availableQuantity-neededQuantity);
                addOrderPage.getTableProductModel().setRowCount(0);
                this.updateTable();
            }
            if(command.equals("BILLS")){
                BillPage billPage = new BillPage("BILLS");
                billPage.setVisible(true);
            }
        } catch (InputMismatchException exception){
            exception.printStackTrace();
            JOptionPane.showMessageDialog(addOrderPage,"Not enough Stock","Error",JOptionPane.ERROR_MESSAGE);
        } catch (BadAttributeValueExpException exception){
            exception.printStackTrace();
            JOptionPane.showMessageDialog(addOrderPage,"NOT ACCEPTING NEGATIVE VALUES", "Error", JOptionPane.ERROR_MESSAGE);
        }catch (Exception exception){
            exception.printStackTrace();
            JOptionPane.showMessageDialog(addOrderPage,"Wrong Quantity Format","Error",JOptionPane.ERROR_MESSAGE);

        }
    }
    private void updateTable(){
        List<Product> products = addOrderPage.getProductBLL().getProductDAO().findAll();
        String[] object;
        for( Product product : products){
            //System.out.println((String) customer.getId() + " " + customer.getName());
            //String da = customer.getId
            object = new String[]{Integer.toString(product.getId()), product.getName(), Integer.toString(product.getQuantity())};
            addOrderPage.getTableProductModel().addRow(object);
        }

    }
}
