package BLL;

import DAO.OrderDAO;
import Model.Customer;
import Model.OrderM;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class OrderBLL {
    private OrderDAO orderDAO;

    public OrderBLL(){
        this.orderDAO=new OrderDAO();
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public DefaultTableModel genTable(){
        List<OrderM> orders = orderDAO.findAll();
        //System.out.println(customers.get(0).getName());
        return orderDAO.populateTable(orders);
    }

    /**
     *
     * @param customerName the name of the customer from the order
     * @param productName the name of the product from the order
     * @param neededQuantity the number of products that must exist
     * @return the instance of the order
     */
    public OrderM addOrder( String customerName, String productName, int neededQuantity ) {
        OrderM orderM = orderDAO.insert(new OrderM(customerName,productName,neededQuantity));
        return orderM;
    }
}
