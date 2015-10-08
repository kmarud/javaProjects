/**
 * Created by kamil on 07.10.15.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebPageReader extends AbstractReader {
    public void read(String address, boolean wszystkieLinki) throws Exception{
        loacalAddress=address;
        System.out.println("WEb page readeer dzialam");
        getData();
    }

    public void getData() throws Exception {
        URL page = new URL(loacalAddress);
        StringBuffer text = new StringBuffer();
        HttpURLConnection conn = (HttpURLConnection) page.openConnection();
        conn.connect();
        InputStreamReader in = new InputStreamReader((InputStream) conn.getContent(), "UTF-8");

        BufferedReader buff = new BufferedReader(in);
        String zdanie = buff.readLine();
        StringBuffer adverbs = new StringBuffer();
        boolean findAdv = false;
        String regex="a href";
        String zapam="";
        while (zdanie != null)
        {

           // System.out.println(line);
            while (zdanie.contains("a href") && zdanie.contains("</a>"))
            {
                poczatek = zdanie.indexOf("<a href=");
                koniec = zdanie.indexOf("</a>");
                liczbaLinkow++;
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
                System.out.println(zapam.substring(poczatek + 9, koniec));
                zapam = "";
            }
            zdanie = buff.readLine();

        }
        System.out.println("\nliczba wszystkich linkow: " + liczbaLinkow);
    }
}
