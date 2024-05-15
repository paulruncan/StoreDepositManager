package Views;

import BLL.OrderBLL;
import Model.OrderM;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrdersPageController implements ActionListener {
    private OrderBLL orderBLL;
    private OrdersPage ordersPage;

    public OrdersPageController(OrdersPage ordersPage){
        this.ordersPage=ordersPage;
        this.orderBLL=new OrderBLL();
    }
    public String[] giveFields() {
        return this.orderBLL.getOrderDAO().getFields();
    }

    public void getDataDatabase( DefaultTableModel tableModel ) {
        List<OrderM> orderss = orderBLL.getOrderDAO().findAll();
        String[] object;
        for( OrderM order : orderss){
            //System.out.println((String) customer.getId() + " " + customer.getName());
            //String da = customer.getId
            object = new String[]{Integer.toString(order.getId()), order.getCustomerName(),order.getProductName(),Integer.toString(order.getQuantity())};
            tableModel.addRow(object);
        }
    }

    /**
     * Opens the Order Creation page
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        try{
            String command = e.getActionCommand();
            if(command.equals("addorder")){
                AddOrderPage addOrderPage = new AddOrderPage(this.ordersPage, "DAAA");
                addOrderPage.setVisible(true);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }

    }

    public OrderBLL getOrderBLL() {
        return orderBLL;
    }

    public OrdersPage getOrdersPage() {
        return ordersPage;
    }
}
