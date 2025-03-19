import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class BatchProcessorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BatchProcessorTest 
{
    private Company company;
    private BatchProcessor processor;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        company = new BooksAndMore();
        processor = new BatchProcessor(company);
    }
    
    /*# TODO: insert remaining tests here */
}
