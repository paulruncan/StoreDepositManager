package Model;

/**
 * the model class for Order
 */
public class OrderM {
    private int id;
    private String customerName;
    private String productName;

    private int quantity;

    public OrderM( int id, String customerName, String productName, int quantity ) {
        this.id = id;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
    }

    public OrderM() {
    }

    public OrderM( String customerName, String productName, int quantity ) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public void setCustomerName( String customerName ) {
        this.customerName = customerName;
    }

    public void setProductName( String productName ) {
        this.productName = productName;
    }

    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }
}
