import java.io.*;
import java.util.Scanner;

/**
 * Processes commands on a Company object from a file.
 * 
 * @author Derek Finnell
 * @version 3/18/25
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
        FileInputStream in = new FileInputStream(fileName);
        try {
            return process(in);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /**
     * Reads the processing commands from the given input stream,
     * executing them on the company.
     * @param stream the input stream from which to read
     * @return the number of successfully executed commands
     */
    public int process(InputStream stream) {
        Scanner in = new Scanner(stream);
        int count = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String commandString = line.split(" ")[0];
            if (commandString.equalsIgnoreCase("add")) {
                String productName = line.split(" ")[1];
                if (productName.equals("Book") ||
                        productName.equals("Magazine") ||
                        productName.equals("Giftcard")) {
                    count++;
                } else {
                    return 0;
                }
            }
            if (commandString.equalsIgnoreCase("update")) {
                String productID = line.split(" ")[1];
                String update = line.split(" ")[2];

            }
        }
        return count;
    }
}
