
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class FileReadWrite {
    String filename, outputFilename, errorsFilename;
    int rowsPerFile;
    File fileProperties = new File("properties.txt");

    private HashSet<User> userCollection = new HashSet<>();
    private ArrayList<User> illegalUserCollection = new ArrayList<>();

    FileReadWrite() {
        try {
            Scanner skaner = new Scanner(fileProperties);
            filename = skaner.nextLine().split("=")[1];
            outputFilename = skaner.nextLine().split("=")[1];
            errorsFilename = skaner.nextLine().split("=")[1];
            rowsPerFile = Integer.parseInt(skaner.nextLine().split("=")[1]);
        } catch(FileNotFoundException e) {
            System.out.println("brak pliku properties !");
        }
    }
    void read()
    {
        File fileData = new File(filename);
        try {
            Scanner dataScanner = new Scanner(fileData);
            dataScanner.nextLine();
            while (dataScanner.hasNextLine()) {
                String[] parts = dataScanner.nextLine().split(",");
                try {
                    User newPerson = new User(Long.parseLong(parts[0]), parts[1], User.PHONE_OPERATOR.valueOf(parts[2]), parts[3]);
                    if(parts[3].length()!=9)
                        throw new IllegalArgumentException();
                    userCollection.add(newPerson);
                } catch (IllegalArgumentException e) {
                    User newPerson = new User(Long.parseLong(parts[0]), parts[1], User.PHONE_OPERATOR.Other, parts[3]);
                    illegalUserCollection.add(newPerson);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak Pliku do odczytania!");
        }
    }

    void write()
    {
        try {
            PrintWriter outIllegal = new PrintWriter(errorsFilename + ".csv");
            Iterator<User> kamil = userCollection.iterator();
            PrintWriter out;
            for(int i=1; i<=Math.ceil(userCollection.size() / (double)rowsPerFile);i++) {
                if(i==Math.ceil(userCollection.size() / (double)rowsPerFile)) {
                     out = new PrintWriter(outputFilename + "_" + (userCollection.size() - ((i - 1) * rowsPerFile)) + "_" + i + ".csv");
                }else {
                    out = new PrintWriter(outputFilename + "_" + rowsPerFile + "_" + i + ".csv");
                }
                for (int j=0;j<rowsPerFile;j++) {
                    if(kamil.hasNext())
                        out.println(kamil.next().returnData());
                }
                out.close();
            }
            for (User ciagZnakow : illegalUserCollection) {
                outIllegal.println(ciagZnakow.returnData());
            }

            outIllegal.close();
        } catch(FileNotFoundException e)
        {
            System.err.print("nie dziala");
        }
    }
}
