import java.io.*;
import java.util.GregorianCalendar;
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
     * Method for processing the "add" command
     */
    private boolean processAdd (String [] tokens) {
        Product product = null;
        switch (tokens[1]) {
            case "Book":
                product = new Book();
                break;
            case "Magazine":
                product = new Magazine();
                break;
            case "GiftCard":
                product = new GiftCard();
                break;
            default:
                return false;
        }

        if (tokens.length == 3) {
            processFieldsAdd(product, tokens[2]);
        }

        company.add(product);
        return true;
    }
    /**
     * Method to format date for input
     */
    private GregorianCalendar processDate(String value) {
        int year = Integer.parseInt(value.substring(0, 4));
        int month = Integer.parseInt(value.substring(4, 6)) - 1;
        int day = Integer.parseInt(value.substring(6, 8));
        return new GregorianCalendar(year, month, day);
    }
    /**
     * Method to process fields further to add to product
     */
    public void processFieldsAdd (Product product, String fields) {
        String[] pairs = fields.split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");

            String key = keyValue[0].trim();
            String value = keyValue[1].trim();

            switch (key) {
                case "name":
                    product.setName(value);
                    break;
                case "desc":
                    product.setDescription(value);
                    break;
                case "price":
                    Double price = Double.parseDouble(value);
                    product.setPrice(new Dollar(price));
                    break;
                case "quantity":
                    product.setQuantity(Integer.parseInt(value));
                    break;
                case "date":
                    GregorianCalendar date = processDate(value);
                    if (product instanceof Book) {
                        ((Book) product).setDate(date);
                    } else if (product instanceof Magazine) {
                        ((Magazine) product).setDate(date);
                    } else {
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }
    /**
     * Method for processing the "update" command
     */
    public void processUpdate (String [] fields) {

    }

    /**
     * Method for processing the "delete" command
     * @param fields
     */
    public void processDelete (String [] fields) {

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
            String[] tokens = line.split(" ");
            switch (tokens[0].toLowerCase()) {
                case "add":
                    if (processAdd(tokens)) {
                        count++;
                    }
                    break;
                case "update":
                    if (processUpdate(tokens)) {
                        count++;
                    }
                    break;
                case "delete":
                    processDelete(tokens);
                    break;
                default:
                    break;
            }

        } return count;
    }
}
