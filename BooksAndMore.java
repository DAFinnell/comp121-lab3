import java.io.*;
/**
 * An implementation of a company called BooksAndMore.
 * 
 * @author Derek Finnell
 * @version 3/18/25
 */
public class BooksAndMore implements Company, Serializable
{
    private Product [] products;
    private int nextProduct;
    private int nextIdNumber;
    private int productCount;
    
    /**
     * Zero arg constructor.
     */
    public BooksAndMore()
    {
        this.products = new Product[MAX_PRODUCTS];
        this.nextProduct = 0;
        this.nextIdNumber = 1;
        this.productCount = 0;
    }
    
    /**
     * Return the number of products presently in the company.
     * @return the number of products.
     */
    public int getProductCount()
    {
        return productCount;
    }
    
    /**
     * Utility method to compare two objects.
     * @param obj1 First object
     * @param obj2 Second object
     * @return True if and only if the two objects are the same
     */
    private static boolean nullSafeEquals(Object obj1, Object obj2)
    {
        return obj1 == null ? obj2 == null : obj1.equals(obj2);
    }
    
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
    public boolean add(Product prod)
    {
        if (prod != null && this.nextProduct < MAX_PRODUCTS)
        {
            for (int i = 0; i < this.nextProduct; ++i)
            {
                if (nullSafeEquals(
                    this.products[i].getName(),
                    prod.getName()))
                {
                    return false;
                }
            }
            
            prod.setId(Integer.toString(this.nextIdNumber++));
            this.products[this.nextProduct++] = prod;
            this.productCount++;
            return true;
        }
        return false;
    }
    
    /**
     * Remove a product.  The parameter prod should
     * be a product in the company.  The specified product is
     * located in the database and removed.
     * @param prod The product to remove.
     * @return true if the product was found and removed, false otherwise.
     */
    public boolean remove(Product prod)
    {
        for (int i = 0; i < this.nextProduct; ++i)
        {
            if (prod.getId() == this.products[i].getId() ||
                this.products[i].getId().equals(prod.getId()))
            {
                this.products[i] = this.products[this.nextProduct - 1];
                this.products[--this.nextProduct] = null;
                this.productCount--;
                return true;
            }
        }
        return false;
    }

    /**
     * Create and return an array of products what match the given query
     * criteria.  The query will identify which products match.  The length
     * of the returned array should be equal to the number of products
     * that match, and each element in the array should be a matching
     * product.
     * @param query a query indicating which products to find
     * @return an array of matching products.
     */
    public Product [] findProducts(Lookup query)
    {
        int count = 0;
        for (int i = 0; i < this.nextProduct; ++i)
        {
            if (query.matches(this.products[i]))
            {
                ++count;
            }
        }
        Product [] selected = new Product[count];
        count = 0;
        for (int i = 0; i < this.nextProduct; ++i)
        {
            if (query.matches(this.products[i]))
            {
                selected[count++] = this.products[i];
            }
        }
        return selected;
    }

    /**
     * Returns the entire internal collection of products as an array.
     * If there are no products, returns an array of Product with length = 0.
     * @return an array of all existing products.
     */
    public Product[] allProducts()
    {
        return this.products;
    }
    
    /**
     * Builds a company from a persisted object file.  The file should
     * have been created by serialization of a prior company.
     * @param fileName the name of the file containing the company object
     * @return a Company read from the file
     * @throws IOException if fileName is invalid/unreadable, ClassNotFoundException
     *          if the class is invalid
     */
    public static Company readFromFile(String fileName) 
                    throws IOException, ClassNotFoundException
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Company) ois.readObject();
        } catch (IOException e) {
            System.out.println("Error reading from file: " + fileName);
        } catch (ClassNotFoundException e) {
            System.out.println("Company not found in file: " + fileName);
        } return null;
    }
    
    /**
     * Writes the current company to the given file name using
     * object serialization.
     * @param fileName the name of the file to write.
     * @throws IOException if fileName is invalid/unreadable.
     */
    public void writeToFile(String fileName) throws IOException
    {
       try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
           oos.writeObject(this);
       } catch (FileNotFoundException e) {
           System.out.println("File not found or Invalid " + fileName);
       }
    }    
    
}
