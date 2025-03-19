import java.io.*;

/**
 * Processes commands on a Company object from a file.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BatchProcessor
{
    private Company company;
    
    /**
     * Constructor for objects of class BatchProcessor.
     * @param c the Company object for batch processing
     */
    public BatchProcessor(Company c)
    {
        this.company = c;
    }

    /**
     * Reads the commands from a file and executes them on
     * the company.
     * @param fileName the name of the file from which to read
     * @return the number of successfully executed commands
     */
    public int process(String fileName) throws IOException
    {
        /*# TODO: insert Code here */
        return 0;
    }
    
    /**
     * Reads the processing commands from the given input stream,
     * executing them on the company.
     * @param stream the input stream from which to read
     * @return the number of successfully executed commands
     */
    public int process(InputStream stream)
    {
        /*# TODO: insert Code here */
        return 0;
    }
}
