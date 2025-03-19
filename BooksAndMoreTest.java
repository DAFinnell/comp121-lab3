import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class BooksAndMoreTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BooksAndMoreTest 
{
    private Company company;
    static Product [] products = buildProducts();

   /**
     * Build a list of products from census data.
     * @return an array of products.
     */
    private static Product [] buildProducts()
    {
        String [] names = {
            "Product 1", "Product 2", "Product 3", "Product 4", "Product 5",
            "Product 6", "Product 7", "Product 8", "Product 9"
        };
        String [] desc = {
            "Product 1", "Product 2", "Product 3", "Product 4", "Product 5",
            "Product 6", "Product 7", "Product 8", "Product 9"
        };
        
        Product [] tempProducts = new Product [names.length];
        
        int counter = 0;
        for (int i = 0; i < names.length; ++i)
        {
            Product emp;
            if (i % 3 == 0)
            {
                emp = new Book();
            }
            else if (i % 3 == 1)
            {
                emp = new GiftCard();
            }
            else
            {
                emp = new Magazine();
            }
            tempProducts[counter++] = emp;
            emp.setName(names[i]);
            emp.setDescription(desc[i]);
            emp.setQuantity(i);
            emp.setPrice( new Dollar(i * 100) );
        }
        return tempProducts;
    }

   /**
     * Build the company based on an array of employees.
     * @return a Company built
     */
    public static Company buildCompany()
    {
        Company comp = new BooksAndMore();
        for (int i = 0; i < products.length; ++i)
        {
            comp.add(products[i]);
        }
        return comp;
    }

   /**
     * Test adding a product.
     */
    @Test
    public void testSimpleAdding()
    {
        assertEquals("Hint: new company has products",
            0, company.getProductCount());
        company.add(null);
        assertEquals("Hint: added a null product",
            0, company.getProductCount());
        company.add(new Book());
        assertEquals("Hint: didn't add a product",
            1, company.getProductCount());
    }

   /**
     * Test assigning consecutive Ids.
     */
    @Test
    public void testIDAssignment()
    {
        Product emp1 = new Book();
        emp1.setName("Smith");
        company.add(emp1);
        assertNotNull("Hint: didn't assign an ID", emp1.getId());
        assertEquals("Hint: didn't assign correct ID", "1", emp1.getId());
        Product emp2 = new Book();
        emp2.setName("Smythe");
        company.add(emp2);
        assertNotNull("Hint: didn't assign an ID", emp2.getId());
        assertEquals("Hint: didn't assign correct ID", "2", emp2.getId());
    }

   /**
     * Test duplicate adds.
     */
    @Test
    public void testDuplicateAdds()
    {
        Product emp1 = new Book();
        company.add(emp1);
        Product emp2 = new Book();
        company.add(emp2);
        assertEquals("Hint: added duplicate product", 1,
            company.getProductCount());
    }
    
   /**
     * Test simple removal.
     */
    @Test
    public void testSimpleReleasing()
    {
        Product e = new Book();
        company.add(e);
        assertEquals("Hint: didn't add product",
            1, company.getProductCount());
        company.remove(e);
        assertEquals("Hint: didn't remove product",
            0, company.getProductCount());
    }

   /**
     * Test adding many products.
     */
    @Test
    public void testAddingMany()
    {
        company = buildCompany();
        assertEquals("Hint: didn't add batch of products",
            products.length, company.getProductCount());
    }
    
    /**
     * Test removing everything.
     */
    @Test
    public void testReleasingMany()
    {
        company = buildCompany();
        for (int i = products.length - 1; i >= 0; --i)
        {
            company.remove(products[i]);
        }
        assertEquals("Hint: didn't remove all products",
            0, company.getProductCount());
    }

    /**
     * Test finding by name.
     */
    @Test
    public void testFindingByName()
    {
        Lookup query = new NameLookup(products[0].getName());
        company = buildCompany();
        Product [] selected = company.findProducts(query);
        assertEquals("Hint: name query selected wrong number of products",
            1, selected.length);
    }

   /**
     * Test finding by id number.
     */
    @Test
    public void testFindingById()
    {
        Company aCompany = buildCompany();
        Lookup query = new IdLookup(products[0].getId());
        Product [] selected = aCompany.findProducts(query);
        assertEquals("Hint: id query selected wrong number of products",
            1, selected.length);
        assertTrue("Hint: wrong product selected in id query",
            products[0] == selected[0]);
    }

    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        this.company = new BooksAndMore();
    }

    /*# TODO: insert remaining tests here */
    
}
