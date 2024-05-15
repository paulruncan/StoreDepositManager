package BLL;

import DAO.ProductDAO;
import Model.Product;

/**
 * The bussines logic for the Product
 */
public class ProductBLL {
    private ProductDAO productDAO;
    public ProductBLL(){
        this.productDAO=new ProductDAO();
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    /**
     *
     * @param name the name of the product
     * @param quantity the quantity of the product
     * @return the instance of the product that will be added
     */
    public Product addProduct( String name, int quantity ) {
        Product product = productDAO.insert(new Product(name,quantity));
        return product;
    }

    /**
     *
     * @param id the id of the product that will be removed
     */
    public void removeProductById( int id ) {
        productDAO.deleteById(id);
    }

    /**
     *
     * @param id the id of the product that will be modified
     * @param name the name of the product that will be modified
     * @param quantity the quantity that will be modified
     */
    public void editProduct( int id, String name, int quantity ) {
        productDAO.update(new Product(id,name,quantity));
    }
}
