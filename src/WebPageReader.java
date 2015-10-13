/**
 * Created by kamil on 07.10.15.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebPageReader extends AbstractReader {
    public void read(String address, boolean wszystkieLinki, boolean aktualnaDomena) throws Exception{
        loacalAddress=address;
        System.out.println("Linki na stronie " + loacalAddress + " :\n");
        liczbaLinkow=0;
        URL page = new URL(loacalAddress);
        HttpURLConnection conn = (HttpURLConnection) page.openConnection();
        conn.connect();
        InputStreamReader in = new InputStreamReader((InputStream) conn.getContent(), "UTF-8");
        BufferedReader buff = new BufferedReader(in);
        zapam="";
        while (true)
        {
            zdanie = buff.readLine();
            if(zdanie == null)
                break;
            while (zdanie.contains("a href") && zdanie.contains("</a>"))
            {
                poczatek = zdanie.indexOf("<a href=");
                koniec = zdanie.indexOf("</a>");
                tmp=zdanie.substring(poczatek + 9, koniec); // +9 bo nie wyswietlamy <a href="
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
                if (wszystkieLinki)
                    System.out.println(tmp);
                zapam = "";
            }
        }
        System.out.println("\nliczba wszystkich linkow: " + liczbaLinkow);
    }
}
