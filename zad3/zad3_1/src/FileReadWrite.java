
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class FileReadWrite {
    private String filename, outputFilename, errorsFilename;
    private int rowsPerFile;
    private HashSet<User> userCollection = new HashSet<>();
    private ArrayList<User> illegalUserCollection = new ArrayList<>();
    private class badPhoneNumber extends Exception {}

    public FileReadWrite() {
        try {
            File fileProperties = new File("properties.txt");
            Scanner dataScanner = new Scanner(fileProperties);
            filename = dataScanner.nextLine().split("=")[1];
            outputFilename = dataScanner.nextLine().split("=")[1];
            errorsFilename = dataScanner.nextLine().split("=")[1];
            rowsPerFile = Integer.parseInt(dataScanner.nextLine().split("=")[1]);
        } catch(FileNotFoundException e) {
            System.err.println("brak pliku properties !");
        }
    }
    public void verifyNumber(String number) throws badPhoneNumber
    {
        if(number.length()!=9)
            throw new badPhoneNumber();
    }
    public void readFromFile()
    {
        File fileData = new File(filename);
        try {
            Scanner dataScanner = new Scanner(fileData);
            dataScanner.nextLine();
            while (dataScanner.hasNextLine()) {
                String[] parts = dataScanner.nextLine().split(",");
                try {
                    User newPerson = new User(Long.parseLong(parts[0]), parts[1], User.PHONE_OPERATOR.valueOf(parts[2]), parts[3]);
                    verifyNumber(parts[3]);
                    userCollection.add(newPerson);
                } catch (IllegalArgumentException e) {
                    User newPerson = new User(Long.parseLong(parts[0]), parts[1], User.PHONE_OPERATOR.BAD_OPERATOR, parts[3]);
                    illegalUserCollection.add(newPerson);
                } catch (badPhoneNumber e) {
                    User newPerson = new User(Long.parseLong(parts[0]), parts[1], User.PHONE_OPERATOR.valueOf(parts[2]), parts[3]);
                    illegalUserCollection.add(newPerson);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Brak pliku do odczytania!");
        }
    }

    public void writeToFiles()
    {
        try {
            PrintWriter outIllegal = new PrintWriter(errorsFilename + ".csv");
            Iterator<User> collectionIterator = userCollection.iterator();
            PrintWriter out;
            for(int i=1; i<=Math.ceil(userCollection.size() / (double)rowsPerFile);i++) {
                if(i==Math.ceil(userCollection.size() / (double)rowsPerFile)) {
                     out = new PrintWriter(outputFilename + "_" + (userCollection.size() - ((i - 1) * rowsPerFile)) + "_" + i + ".csv");
                }else {
                    out = new PrintWriter(outputFilename + "_" + rowsPerFile + "_" + i + ".csv");
                }
                for (int j=0;j<rowsPerFile;j++) {
                    if(collectionIterator.hasNext())
                        out.println(collectionIterator.next().returnData());
                }
                out.close();
            }
            for (User illegalUser : illegalUserCollection) {
                outIllegal.println(illegalUser.returnData());
            }
            outIllegal.close();
        } catch(FileNotFoundException e)
        {
            System.err.print("Problem z zapisem !");
        }
    }
}
