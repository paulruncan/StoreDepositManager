package Views;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {
    private JButton clientButton;
    private JButton productButton;
    private JButton orderButton;
    private JPanel contentPane;

    private MainPageController mainPageController = new MainPageController(this);

    public MainPage(String name){
        super(name);
        this.prepareGUI();
    }

    private void prepareGUI() {
        this.setSize(400,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.contentPane = new JPanel(new GridLayout(1,3));
        this.clientButton=new JButton("CLIENTS");
        this.clientButton.setActionCommand("Clients");
        this.clientButton.addActionListener(this.mainPageController);

        this.productButton=new JButton("PRODUCTS");
        this.productButton.setActionCommand("Products");
        this.productButton.addActionListener(this.mainPageController);

        this.orderButton=new JButton("ORDERS");
        this.orderButton.setActionCommand("Orders");
        this.orderButton.addActionListener(this.mainPageController);
        this.contentPane.add(clientButton);
        this.contentPane.add(productButton);
        this.contentPane.add(orderButton);
        this.setContentPane(this.contentPane);
    }
}
