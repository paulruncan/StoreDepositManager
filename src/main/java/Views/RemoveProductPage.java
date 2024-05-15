package Views;

import javax.swing.*;
import java.awt.*;

public class RemoveProductPage extends JFrame {
    private ProductsPage productsPage;
    private JButton removeButton;
    private TextField nameField;
    private JPanel contentPane;
    private RemoveProductPageController removeProductPageController = new RemoveProductPageController(this);

    public RemoveProductPage(ProductsPage productsPage, String name){
        super(name);

        this.prepareGUI();
        this.productsPage=productsPage;
    }
    private void prepareGUI() {
        this.setSize(200,200);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.contentPane = new JPanel(new GridLayout(2,1));
        System.out.println("Dadadada");
        this.nameField=new TextField("id");
        this.contentPane.add(nameField);
        this.removeButton = new JButton("REMOVE");
        this.removeButton.addActionListener(this.removeProductPageController);
        this.removeButton.setActionCommand("REMOVE");
        this.contentPane.add(removeButton);
        this.setContentPane(contentPane);
    }

    public ProductsPage getProductsPage() {
        return productsPage;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public TextField getNameField() {
        return nameField;
    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public RemoveProductPageController getRemoveProductPageController() {
        return removeProductPageController;
    }
}
