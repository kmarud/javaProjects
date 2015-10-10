/**
 * Created by kamil on 07.10.15.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader extends AbstractReader{
    public void read(String address, boolean wszystkieLinki, boolean aktualnaDomena)throws FileNotFoundException
    {
        loacalAddress=address;
        System.out.println("Linki w pliku " + loacalAddress + " :\n");
        liczbaLinkow=0;
        String zapam="", tmp ="";
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
            while (zdanie.contains("a href") && zdanie.contains("</a>"))
            {
                poczatek = zdanie.indexOf("<a href=");
                koniec = zdanie.indexOf("</a>");
                liczbaLinkow++;
                if (wszystkieLinki)
                    System.out.println(zdanie.substring(poczatek + 9, koniec));
                zdanie = zdanie.replaceFirst("<a href=", "");
                zdanie = zdanie.replaceFirst("</a>", "");
            }
            if (zdanie.contains("a href"))
            {
                zapam += zdanie;
                poczatek = zdanie.indexOf("<a href=");
            }
            if (zdanie.contains("</a>"))
            {
                if (!zapam.equals(zdanie))
                    zapam += zdanie;
                koniec = zapam.indexOf("</a>");
                liczbaLinkow++;
                if(wszystkieLinki)
                    System.out.println(zapam.substring(poczatek + 9, koniec));
                zapam = "";
            }
        }
        System.out.println("\nliczba wszystkich linkow: " + liczbaLinkow);
    }
}
