package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductsPage extends JFrame {
    private JTable tabel;
    private JButton buttonAdd;
    private JButton buttonEdit;
    private JButton buttonDelete;
    private JPanel contentPane;
    private JPanel buttons;
    private JPanel tablePane;
    private ProductsPageController productsPageController = new ProductsPageController(this);

    private DefaultTableModel tableModel;
    public ProductsPage(String name){
        super(name);
        this.prepareGUI();
    }
    private void prepareGUI(){
        this.setSize(1500,1500);
        this.contentPane = new JPanel(new GridLayout(2,1));
        this.tabelPrepare();
        this.prepareButtons();
        this.setContentPane(this.contentPane);

    }
    public void tabelPrepare(){
        String[] columnNames = productsPageController.giveFields();
        tableModel = new DefaultTableModel(null,columnNames);
        this.tabel = new JTable(tableModel);
        productsPageController.getDataDatabase(tableModel);
        JScrollPane scp = new JScrollPane(tabel);
        scp.setBounds(70,50,200,20);
        this.contentPane.add(scp);
    }
    private void prepareButtons(){
        this.buttons=new JPanel();
        this.buttons.setLayout(new GridLayout(1,3));
        this.buttonAdd=new JButton("Add Product");
        this.buttonAdd.setPreferredSize(new Dimension(10,10));
        this.buttonAdd.setActionCommand("addproduct");
        this.buttonAdd.addActionListener(this.productsPageController);
        this.buttonDelete=new JButton("Delete Product");
        this.buttonDelete.setActionCommand("deleteproduct");
        this.buttonDelete.addActionListener(this.productsPageController);
        this.buttonEdit=new JButton("Edit Product");
        this.buttonEdit.setActionCommand("editproduct");
        this.buttonEdit.addActionListener(this.productsPageController);
        this.buttons.add(this.buttonAdd);
        this.buttons.add(this.buttonDelete);
        this.buttons.add(this.buttonEdit);
        this.contentPane.add(this.buttons);
    }

    public JTable getTabel() {
        return tabel;
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public JButton getButtonEdit() {
        return buttonEdit;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    public JPanel getButtons() {
        return buttons;
    }

    public JPanel getTablePane() {
        return tablePane;
    }

    public ProductsPageController getProductsPageController() {
        return productsPageController;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
