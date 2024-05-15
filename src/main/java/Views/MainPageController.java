package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageController implements ActionListener {
    private MainPage mainPage;

    public MainPageController(MainPage mainPage){
        this.mainPage=mainPage;
    }

    /**
     * based on the button opens the corresponding page
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        try{
            String command = e.getActionCommand();
            if(command.equals("Clients")){
                FirstPage firstPage = new FirstPage("CLIENTS");
                firstPage.setVisible(true);
            }
            if(command.equals("Products")){
                ProductsPage productsPage = new ProductsPage("PRODUCTS");
                productsPage.setVisible(true);
            }
            if(command.equals("Orders")){
                OrdersPage ordersPage=new OrdersPage("ORDERS");
                ordersPage.setVisible(true);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
