import java.io.*;

/**
 * An abstraction of a Company. 
 * 
 * @author Franklin University 
 * @version 2.0
 */
public interface Company extends Serializable
{
    /**
     * Add a product to the company.  The parameter product
     * should not be something already in the company.  As a
     * result of adding a product, the company will issue an ID starting
     * with 1 and increasing by 1 for each product added.  IDs
     * are not reused.  All products are kept
     * in a database internal to the company so that they may be searched
     * for using a query.
     * @param prod The product to add.
     * @return true when the product is added, false if the product cannot
     * be added for any reason.
     */
    boolean add(Product prod);
    
    /**
     * Remove a product.  The parameter prod should
     * be a product in the company.  The specified product is
     * located in the database and removed.
     * @param prod The product to remove.
     * @return true if the product was found and removed, false otherwise.
     */
    boolean remove(Product prod);
    
    /**
     * Return the number of products presently in the company.
     * @return the number of products.
     */
    int getProductCount();
    
    /**
     * Create and return an array of products what match the given query
     * criteria.  The query will identify which products match.  The length
     * of the returned array should be equal to the number of products
     * that match, and each element in the array should be a matching
     * product.
     * @param query a query indicating which products to find
     * @return an array of matching products.
     */
    Product [] findProducts(Lookup query);
    
    /**
     * Returns the entire internal collection of products as an array.
     * If there are no products, returns an array of Product with length = 0.
     * @return an array of all existing products.
     */
    Product [] allProducts();
    
    /**
     * Writes the current company to the given file name using
     * object serialization.
     * @param fileName the name of the file to write.
     */
    void writeToFile(String fileName) throws IOException;
    
    /**
     * The maximum number of products that a company can have.
     */
    static final int MAX_PRODUCTS = 300;
}
