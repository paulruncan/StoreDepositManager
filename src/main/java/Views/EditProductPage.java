package Views;

import javax.swing.*;
import java.awt.*;

public class EditProductPage extends JFrame {
    private ProductsPage productsPage;
    private JButton editButton;
    private TextField nameField;
    private TextField quantityField;
    private TextField idField;
    private JPanel contentPane;
    private EditProductPageController editProductPageController = new EditProductPageController(this);

    public EditProductPage(ProductsPage productsPage, String name){
        super(name);
        this.productsPage=productsPage;
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
        this.quantityField=new TextField("quantity");
        this.contentPane.add(quantityField);
        this.editButton = new JButton("EDIT");
        this.editButton.addActionListener(this.editProductPageController);
        this.editButton.setActionCommand("EDIT");
        this.contentPane.add(editButton);
        this.setContentPane(contentPane);

    }

    public ProductsPage getProductsPage() {
        return productsPage;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getQuantityField() {
        return quantityField;
    }

    public TextField getIdField() {
        return idField;
    }

    public EditProductPageController getEditProductPageController() {
        return editProductPageController;
    }
}
