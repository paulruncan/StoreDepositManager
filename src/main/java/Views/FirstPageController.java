package Views;

import Model.Customer;
import BLL.CustomerBLL;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FirstPageController implements ActionListener {
    private FirstPage firstPage;
    private CustomerBLL customerBLL;

    public FirstPageController(FirstPage firstPage){
        this.firstPage =firstPage;
        this.customerBLL = new CustomerBLL();
    }
    public String[] giveFields(){
        return customerBLL.getCustomerDAO().getFields();
    }

    /**
     * Based on the button opens the needed page
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        try{
            String command = e.getActionCommand();
            if(command.equals("addclient")){
                AddClientPage addClientPage = new AddClientPage(this.firstPage,"ADD");
                addClientPage.setVisible(true);
            }
            if(command.equals("deleteclient")){
                RemoveClientPage removeClientPage = new RemoveClientPage(this.firstPage,"REMOVE");
                removeClientPage.setVisible(true);
            }
            if(command.equals("editclient")){
                EditClientPage editClientPage = new EditClientPage(this.firstPage,"EDIT");
                editClientPage.setVisible(true);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public void getDataDatabase( DefaultTableModel tableModel ) {
        List<Customer> customers = customerBLL.getCustomerDAO().findAll();
        String[] object;
        for(Customer customer : customers){
            //System.out.println((String) customer.getId() + " " + customer.getName());
            //String da = customer.getId
            object = new String[]{Integer.toString(customer.getId()), customer.getName(),customer.getMail()};
            tableModel.addRow(object);
        }
    }

    public void updateTable(DefaultTableModel tableModel) {
        List<Customer> customers = customerBLL.getCustomerDAO().findAll();
    }

    public FirstPage getFirstPage() {
        return firstPage;
    }


    public CustomerBLL getCustomerBLL() {
        return customerBLL;
    }
}
