package BLL;

import DAO.CustomerDAO;
import Model.Customer;

/**
 * The Bussiness Logic Class for the Customer
 */
public class CustomerBLL {
    private CustomerDAO customerDAO;

    public CustomerBLL(){
        this.customerDAO = new CustomerDAO();
    }

    /**
     *
     * @param customerName the name of the customer that will be added to the database
     * @param customerMail the mail of the customer that will be added to the database
     * @return it return the Customer instance of the customer added to the database
     */
    public Customer addCustomer( String customerName,String customerMail){
        Customer customer = customerDAO.insert(new Customer(customerName,customerMail));
        return customer;
    }

    /**
     *
     * @param id the id of the customer that will be deleted
     */
    public void removeCustomerById(int id){
        customerDAO.deleteById(id);
    }

    /**
     *
     * @param id the id of the customer that must be modified
     * @param name the name of the customer which will be modified
     * @param mail the mail of the customer which will be modified
     */
    public void editCustomer(int id, String name, String mail){
        customerDAO.update(new Customer(id,name,mail));
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO( CustomerDAO customerDAO ) {
        this.customerDAO = customerDAO;
    }
}
