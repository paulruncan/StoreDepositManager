package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OrdersPage extends JFrame {
    private JTable tabel;
    private JButton buttonAdd;
    private JButton buttonEdit;
    private JButton buttonDelete;
    private JPanel contentPane;
    private JPanel buttons;
    private JPanel tablePane;
    private OrdersPageController ordersPageController = new OrdersPageController(this);

    private DefaultTableModel tableModel;

    public OrdersPage(String name){
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

    private void prepareButtons() {
        this.buttons=new JPanel();
        this.buttons.setLayout(new GridLayout(1,3));
        this.buttonAdd=new JButton("Add Order");
        this.buttonAdd.setPreferredSize(new Dimension(10,10));
        this.buttonAdd.setActionCommand("addorder");
        this.buttonAdd.addActionListener(this.ordersPageController);
       // this.buttonDelete=new JButton("Delete Order");
       // this.buttonDelete.setActionCommand("deleteorder");
       // this.buttonDelete.addActionListener(this.ordersPageController);
       // this.buttonEdit=new JButton("Edit Order");
       // this.buttonEdit.setActionCommand("editorder");
       // this.buttonEdit.addActionListener(this.ordersPageController);
        this.buttons.add(this.buttonAdd);
       // this.buttons.add(this.buttonDelete);
       // this.buttons.add(this.buttonEdit);
        this.contentPane.add(this.buttons);
    }

    public void tabelPrepare(){
        //String[] columnNames = ordersPageController.giveFields();
        //tableModel = new DefaultTableModel(null,columnNames);
        tableModel= ordersPageController.getOrderBLL().genTable();
        this.tabel = new JTable(tableModel);
        //ordersPageController.getDataDatabase(tableModel);
        JScrollPane scp = new JScrollPane(tabel);
        scp.setBounds(70,50,200,20);
        this.contentPane.add(scp);
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

    public OrdersPageController getOrdersPageController() {
        return ordersPageController;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
