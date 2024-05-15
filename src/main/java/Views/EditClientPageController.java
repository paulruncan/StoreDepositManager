package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditClientPageController implements ActionListener {
    private EditClientPage editClientPage;

    public EditClientPageController(EditClientPage editClientPage){
        this.editClientPage=editClientPage;
    }

    /**
     * Edits the data from a Client table entry
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        try{
            String command = e.getActionCommand();
            if(command.equals("EDIT")){
                String id = editClientPage.getIdField().getText();
                String name = editClientPage.getNameField().getText();
                String mail = editClientPage.getMailField().getText();
                editClientPage.getFirstPage().getFirstPageController().getCustomerBLL().editCustomer(Integer.parseInt(id),name,mail);
                editClientPage.getFirstPage().getTableModel().setRowCount(0);
                editClientPage.getFirstPage().getFirstPageController().getDataDatabase(editClientPage.getFirstPage().getTableModel());
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
