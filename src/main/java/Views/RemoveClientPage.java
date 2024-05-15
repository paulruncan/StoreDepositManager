package Views;

import javax.swing.*;
import java.awt.*;

public class RemoveClientPage extends JFrame {
    private FirstPage firstPage;
    private JButton removeButton;
    private TextField nameField;
    private JPanel contentPane;
    private RemoveClientPageController removeClientPageController = new RemoveClientPageController(this);

    public RemoveClientPage(FirstPage firstPage, String name){
        super(name);

        this.prepareGUI();
        this.firstPage=firstPage;
    }
    private void prepareGUI() {
        this.setSize(200,200);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.contentPane = new JPanel(new GridLayout(2,1));
        System.out.println("Dadadada");
        this.nameField=new TextField("id");
        this.contentPane.add(nameField);
        this.removeButton = new JButton("REMOVE");
        this.removeButton.addActionListener(this.removeClientPageController);
        this.removeButton.setActionCommand("REMOVE");
        this.contentPane.add(removeButton);
        this.setContentPane(contentPane);
    }

    public FirstPage getFirstPage() {
        return firstPage;
    }

    public void setFirstPage( FirstPage firstPage ) {
        this.firstPage = firstPage;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public void setRemoveButton( JButton removeButton ) {
        this.removeButton = removeButton;
    }

    public TextField getNameField() {
        return nameField;
    }

    public void setNameField( TextField nameField ) {
        this.nameField = nameField;
    }

    //@Override
    //public JPanel getContentPane() {
    //    return contentPane;
    //}

    //public void setContentPane( JPanel contentPane ) {
    //    this.contentPane = contentPane;
    //}

    public RemoveClientPageController getRemoveClientPageController() {
        return removeClientPageController;
    }

    public void setRemoveClientPageController( RemoveClientPageController removeClientPageController ) {
        this.removeClientPageController = removeClientPageController;
    }
}
