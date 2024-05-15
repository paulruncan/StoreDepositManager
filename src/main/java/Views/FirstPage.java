package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FirstPage extends JFrame {
    private JTable tabel;
    private JButton buttonAdd;
    private JButton buttonEdit;
    private JButton buttonDelete;
    private JPanel contentPane;
    private JPanel buttons;
    private JPanel tablePane;
    private FirstPageController firstPageController = new FirstPageController(this);

    private DefaultTableModel tableModel;
    public FirstPage(String name){
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
        String[] columnNames = firstPageController.giveFields();
        tableModel = new DefaultTableModel(null,columnNames);
        this.tabel = new JTable(tableModel);
        firstPageController.getDataDatabase(tableModel);
        JScrollPane scp = new JScrollPane(tabel);
        scp.setBounds(70,50,200,20);
        this.contentPane.add(scp);
    }
    private void prepareButtons(){
        this.buttons=new JPanel();
        this.buttons.setLayout(new GridLayout(1,3));
        this.buttonAdd=new JButton("Add Client:");
        this.buttonAdd.setPreferredSize(new Dimension(10,10));
        this.buttonAdd.setActionCommand("addclient");
        this.buttonAdd.addActionListener(this.firstPageController);
        this.buttonDelete=new JButton("Delete Client");
        this.buttonDelete.setActionCommand("deleteclient");
        this.buttonDelete.addActionListener(this.firstPageController);
        this.buttonEdit=new JButton("Edit Client");
        this.buttonEdit.setActionCommand("editclient");
        this.buttonEdit.addActionListener(this.firstPageController);
        this.buttons.add(this.buttonAdd);
        this.buttons.add(this.buttonDelete);
        this.buttons.add(this.buttonEdit);
        this.contentPane.add(this.buttons);
    }
    private void prepareTable(){
        //this.tablePane = new JPanel();
        //this.tablePane.setLayout(new GridLayout(1,1));
        String data[][] = {{"ada","ada"},{"dada","dada"}};
        //DefaultTableModel model = new DefaultTableModel(data,firstPageController.giveFields());
        this.tabel=new JTable(data,firstPageController.giveFields());
        //tabel.setModel(model);
        tabel.getTableHeader().setBounds(10,10,10,10);
        this.add(tabel.getTableHeader());
        this.tabel.add(tabel.getTableHeader());
        //this.tablePane.add(this.tabel);
        this.contentPane.add(this.tabel);
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public JPanel getButtons() {
        return buttons;
    }

    public JPanel getTablePane() {
        return tablePane;
    }

    public FirstPageController getFirstPageController() {
        return firstPageController;
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

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel( DefaultTableModel tableModel ) {
        this.tableModel = tableModel;
    }
}
