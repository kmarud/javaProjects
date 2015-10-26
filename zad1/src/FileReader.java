
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader extends AbstractReader{
    public void read(String address, boolean showAllLinks, boolean onlyCurrentDomain)throws FileNotFoundException
    {
        loacalAddress=address;
        allLinks = showAllLinks;
        currentDomain = onlyCurrentDomain;
        System.out.println("Linki w pliku " + loacalAddress + " :\n");
        numberOfLinks=0;
        File file = new File(loacalAddress);
        if (file.exists() == false)
        {
            System.out.println("Nie mozna znalezc pliku !");
            return;
        }
        Scanner in = new Scanner(file);
        while (in.hasNextLine() == true)
        {
            word = in.nextLine();
            analyze(word);
        }
        System.out.println("\nliczba wszystkich linkow: " + numberOfLinks);
    }
}
