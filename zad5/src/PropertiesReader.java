import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PropertiesReader {

    static String folderToWatch,accessToken;
    static int threadPool, secondBetweenStatisticWriting;

    void readProperties(){

        try {
            File fileProperties = new File("properties.txt");
            Scanner dataScanner = new Scanner(fileProperties);
            folderToWatch = dataScanner.nextLine().split("=")[1];
            threadPool = Integer.parseInt(dataScanner.nextLine().split("=")[1]);
            accessToken = dataScanner.nextLine().split("=")[1];
            secondBetweenStatisticWriting = Integer.parseInt(dataScanner.nextLine().split("=")[1]);
        } catch(FileNotFoundException e) {
            System.err.println("brak pliku properties.txt !");
        }
    }
}
