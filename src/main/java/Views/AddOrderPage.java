package Views;

import BLL.CustomerBLL;
import BLL.ProductBLL;
import Model.Customer;
import Model.OrderM;
import Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AddOrderPage extends JFrame {
    private JTable tabelCustomer;
    private JTable tabelProduct;
    private DefaultTableModel tableCustomerModel;
    private DefaultTableModel tableProductModel;


    private OrdersPage ordersPage;
    private ProductBLL productBLL;
    private CustomerBLL customerBLL;
    private JButton addButton;
    private JButton billButton;
    private TextField quantityField;
//    private TextField mailField;
    private JPanel contentPane;
    private AddOrderPageController addOrderPageController = new AddOrderPageController(this);

    public AddOrderPage(OrdersPage ordersPage, String name){
        super(name);
        productBLL=new ProductBLL();
        customerBLL = new CustomerBLL();
        this.ordersPage=ordersPage;
        this.prepareGUI();
    }

    private void prepareGUI() {
        this.setSize(1500,1500);
        this.contentPane = new JPanel(new GridLayout(1,3));
        this.tabelCustomerPrepare();
        this.prepareButtons();
        this.tabelProductPrepare();
        this.setContentPane(this.contentPane);
    }

    private void tabelProductPrepare() {
        String[] columnNames = productBLL.getProductDAO().getFields();
        tableProductModel = new DefaultTableModel(null,columnNames);
        this.tabelProduct = new JTable(tableProductModel);
        List<Product> products = productBLL.getProductDAO().findAll();
        String[] object;
        for( Product product : products){
            //System.out.println((String) customer.getId() + " " + customer.getName());
            //String da = customer.getId
            object = new String[]{Integer.toString(product.getId()), product.getName(), Integer.toString(product.getQuantity())};
            tableProductModel.addRow(object);
        }
        JScrollPane scp = new JScrollPane(tabelProduct);
        scp.setBounds(70,50,200,20);
        this.contentPane.add(scp);
    }


    private void prepareButtons() {
        this.quantityField=new TextField("quantity");
        this.contentPane.add(quantityField);
        this.addButton = new JButton("ADD");
        this.addButton.addActionListener(this.addOrderPageController);
        this.addButton.setActionCommand("ADD");

        this.billButton = new JButton("BILLS");
        this.billButton.addActionListener(this.addOrderPageController);
        this.billButton.setActionCommand("BILLS");
        this.contentPane.add(addButton);
        this.contentPane.add(billButton);
    }

    private void tabelCustomerPrepare() {
        String[] columnNames = customerBLL.getCustomerDAO().getFields();
        tableCustomerModel = new DefaultTableModel(null,columnNames);
        this.tabelCustomer = new JTable(tableCustomerModel);
        List<Customer> customers = customerBLL.getCustomerDAO().findAll();
        String[] object;
        for( Customer customer : customers){
            //System.out.println((String) customer.getId() + " " + customer.getName());
            //String da = customer.getId
            object = new String[]{Integer.toString(customer.getId()), customer.getName(), customer.getMail()};
            tableCustomerModel.addRow(object);
        }
        JScrollPane scp = new JScrollPane(tabelCustomer);
        scp.setBounds(70,50,200,20);
        this.contentPane.add(scp);
    }

    public JTable getTabelCustomer() {
        return tabelCustomer;
    }

    public JTable getTabelProduct() {
        return tabelProduct;
    }

    public DefaultTableModel getTableCustomerModel() {
        return tableCustomerModel;
    }

    public DefaultTableModel getTableProductModel() {
        return tableProductModel;
    }

    public OrdersPage getOrdersPage() {
        return ordersPage;
    }

    public ProductBLL getProductBLL() {
        return productBLL;
    }

    public CustomerBLL getCustomerBLL() {
        return customerBLL;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public TextField getQuantityField() {
        return quantityField;
    }

    public AddOrderPageController getAddOrderPageController() {
        return addOrderPageController;
    }
}
