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
        zapam="";
       // String tmp;
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
                tmp=zdanie.substring(poczatek + 9, koniec);
                if(tmp.startsWith("http") && aktualnaDomena)
                {
                    zdanie = zdanie.replaceFirst("<a href=", "");
                    zdanie = zdanie.replaceFirst("</a>", "");
                    continue;
                }
                liczbaLinkow++;
                if (wszystkieLinki)
                    System.out.println(tmp);
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
                tmp =zapam.substring(poczatek + 9, koniec);
                if(tmp.startsWith("http") && aktualnaDomena)
                    continue;
                liczbaLinkow++;
                if(wszystkieLinki)
                    System.out.println(tmp);
                zapam = "";
            }
        }
        System.out.println("\nliczba wszystkich linkow: " + liczbaLinkow);
    }
}
