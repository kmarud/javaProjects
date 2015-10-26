
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebPageReader extends AbstractReader {
    public void read(String address, boolean allLin, boolean aktualnaDomena) throws Exception{
        loacalAddress=address;
        allLinks = allLin;
        currentDomain = aktualnaDomena;
        System.out.println("Linki na stronie " + loacalAddress + " :\n");
        numberOfLinks=0;
        URL page = new URL(loacalAddress);
        HttpURLConnection conn = (HttpURLConnection) page.openConnection();
        conn.connect();
        InputStreamReader in = new InputStreamReader((InputStream) conn.getContent(), "UTF-8");
        BufferedReader buff = new BufferedReader(in);
        while (true)
        {
            zdanie = buff.readLine();
            if(zdanie == null)
                break;
            analyze(zdanie);
        }
        System.out.println("\nliczba wszystkich linkow: " + numberOfLinks);
    }
}
