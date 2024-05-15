package Views;

import javax.swing.*;
import java.awt.*;

public class AddProductPage extends JFrame {
    private ProductsPage productsPage;
    private JButton addButton;
    private TextField nameField;
    private TextField quantityField;
    private JPanel contentPane;
    private AddProductPageController addProductPageController = new AddProductPageController(this);

    public AddProductPage(ProductsPage firstPage, String name){
        super(name);
        this.productsPage=firstPage;
        this.prepareGUI();
    }

    private void prepareGUI() {
        this.setSize(100,100);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.contentPane = new JPanel(new GridLayout(3,1));
        this.nameField=new TextField("name");
        this.contentPane.add(nameField);
        this.quantityField= new TextField("quantity");
        this.contentPane.add(quantityField);
        this.addButton = new JButton("ADD");
        this.addButton.addActionListener(this.addProductPageController);
        this.addButton.setActionCommand("ADD");
        this.contentPane.add(addButton);
        this.setContentPane(contentPane);
    }

    public ProductsPage getProductsPage() {
        return productsPage;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getQuantityField() {
        return quantityField;
    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public AddProductPageController getAddProductPageController() {
        return addProductPageController;
    }
}
