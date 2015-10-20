/**
 * Created by kamil on 07.10.15.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader extends AbstractReader{
    public void read(String address, boolean allLin, boolean aktualnaDomena)throws FileNotFoundException
    {
        loacalAddress=address;
        allLinks = allLin;
        currentDomain = aktualnaDomena;
        System.out.println("Linki w pliku " + loacalAddress + " :\n");
        numberOfLinks=0;
        zapam="";
        File file = new File(loacalAddress);
        if (file.exists() == false)
        {
            System.out.println("Nie mozna znalezc pliku !");
            return;
        }
        Scanner in = new Scanner(file);
        while (in.hasNextLine() == true)
        {
            zdanie = in.nextLine();
            analyze(zdanie);
        }
        System.out.println("\nliczba wszystkich linkow: " + numberOfLinks);
    }
}
