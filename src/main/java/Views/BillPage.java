package Views;

import BLL.BillBLL;
import Model.Bill;
import Model.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class BillPage extends JFrame {
    private JTable table;
    private JPanel contentPane;

    public BillPage(String name){
        super(name);
        this.prepareGUI();
    }

    private void prepareGUI() {
        this.setSize(1000,1000);
        this.contentPane=new JPanel(new GridLayout(1,1));
        this.prepareTable();
        this.setContentPane(contentPane);
    }

    private void prepareTable() {
        String[] columnNames = new String[]{"id","customerName","productName","quantity"};
        DefaultTableModel tableModel = new DefaultTableModel(null,columnNames);
        this.table = new JTable(tableModel);
        BillBLL billBLL = new BillBLL();
        List<Bill> bills = billBLL.getBillDAO().findAll();
        String[] object;
        for(Bill bill : bills){
            //System.out.println((String) customer.getId() + " " + customer.getName());
            //String da = customer.getId
            object = new String[]{Integer.toString(bill.id()), bill.customerName(),bill.productName(), Integer.toString(bill.quantity())};
            tableModel.addRow(object);
        }
        JScrollPane scp = new JScrollPane(table);
        scp.setBounds(70,50,200,20);
        this.contentPane.add(scp);
    }
}
