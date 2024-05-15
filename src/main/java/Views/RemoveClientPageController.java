package Views;

import Views.RemoveClientPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveClientPageController implements ActionListener {
    RemoveClientPage removeClientPage;

    public RemoveClientPageController(RemoveClientPage removeClientPage){
        this.removeClientPage=removeClientPage;
    }

    /**
     * Removes the entry from the Client Table
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        try{
            String command = e.getActionCommand();
            if(command.equals("REMOVE")){
                String name = removeClientPage.getNameField().getText();
                removeClientPage.getFirstPage().getFirstPageController().getCustomerBLL().removeCustomerById(Integer.parseInt(name));
                removeClientPage.getFirstPage().getTableModel().setRowCount(0);
                removeClientPage.getFirstPage().getFirstPageController().getDataDatabase(removeClientPage.getFirstPage().getTableModel());
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
