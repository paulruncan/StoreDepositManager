package Views;

import javax.swing.*;
import java.awt.*;

public class EditClientPage extends JFrame {
    private FirstPage firstPage;
    private JButton editButton;
    private TextField nameField;
    private TextField mailField;
    private TextField idField;
    private JPanel contentPane;
    private EditClientPageController editClientPageController = new EditClientPageController(this);

    public EditClientPage(FirstPage firstPage, String name){
        super(name);
        this.firstPage=firstPage;
        this.prepareGUI();
    }

    private void prepareGUI() {
        this.setSize(100,300);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.contentPane = new JPanel(new GridLayout(3,1));
        this.idField = new TextField("id");
        this.contentPane.add(idField);
        this.nameField=new TextField("name");
        this.contentPane.add(nameField);
        this.mailField=new TextField("mail");
        this.contentPane.add(mailField);
        this.editButton = new JButton("EDIT");
        this.editButton.addActionListener(this.editClientPageController);
        this.editButton.setActionCommand("EDIT");
        this.contentPane.add(editButton);
        this.setContentPane(contentPane);

    }

    public TextField getMailField() {
        return mailField;
    }

    public FirstPage getFirstPage() {
        return firstPage;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getIdField() {
        return idField;
    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public EditClientPageController getEditClientPageController() {
        return editClientPageController;
    }
}
