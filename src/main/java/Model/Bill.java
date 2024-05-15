package Model;

/**
 * A record corresponding to Bill
 * @param id the id of the bill
 * @param customerName the customer name from the bill
 * @param productName  the product name form the bill
 * @param quantity the quantity from the bill
 */
public record Bill(int id,String customerName, String productName, int quantity) {

}
