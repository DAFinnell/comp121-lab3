import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class BatchProcessorTest.
 *
 * @author  Derek Finnell
 * @version 3/18/25
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
}
