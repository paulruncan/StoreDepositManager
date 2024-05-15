package Views;

import Views.AddClientPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClientPageController implements ActionListener {
    AddClientPage addClientPage;

    public AddClientPageController(AddClientPage addClientPage){
        this.addClientPage=addClientPage;
    }

    /**
     * Adds a new entry to the Customer table
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        try{
            String command = e.getActionCommand();
            if(command.equals("ADD")){
                String name = addClientPage.getNameField().getText();
                String mail = addClientPage.getMailField().getText();
                addClientPage.getFirstPage().getFirstPageController().getCustomerBLL().addCustomer(name,mail);
                addClientPage.getFirstPage().getTableModel().setRowCount(0);
                addClientPage.getFirstPage().getFirstPageController().getDataDatabase(addClientPage.getFirstPage().getTableModel());
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
