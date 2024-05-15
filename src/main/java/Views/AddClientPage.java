package Views;

import javax.swing.*;
import java.awt.*;

public class AddClientPage extends JFrame {
    private FirstPage firstPage;
    private JButton addButton;
    private TextField nameField;
    private TextField mailField;
    private JPanel contentPane;
    private AddClientPageController addClientPageController = new AddClientPageController(this);

    public AddClientPage(FirstPage firstPage, String name){
        super(name);
        this.firstPage=firstPage;
        this.prepareGUI();
    }

    private void prepareGUI() {
        this.setSize(100,100);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.contentPane = new JPanel(new GridLayout(3,1));
        this.nameField=new TextField("name");
        this.contentPane.add(nameField);
        this.mailField= new TextField("mail");
        this.contentPane.add(mailField);
        this.addButton = new JButton("ADD");
        this.addButton.addActionListener(this.addClientPageController);
        this.addButton.setActionCommand("ADD");
        this.contentPane.add(addButton);
        this.setContentPane(contentPane);
    }

    public TextField getNameField() {
        return nameField;
    }

    public FirstPage getFirstPage() {
        return firstPage;
    }

    public JButton getAddButton() {
        return addButton;
    }

    //@Override
    //public JPanel getContentPane() {
    //    return contentPane;
    //}

    public AddClientPageController getAddClientPageController() {
        return addClientPageController;
    }

    public TextField getMailField() {
        return mailField;
    }
}
