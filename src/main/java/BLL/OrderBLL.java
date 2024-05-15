package BLL;

import DAO.OrderDAO;
import Model.OrderM;

public class OrderBLL {
    private OrderDAO orderDAO;

    public OrderBLL(){
        this.orderDAO=new OrderDAO();
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
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
