import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import java.util.Locale;


public class DropboxAutorization {

    static DbxClient client;

    public void autorizeDropbox() {

        DbxRequestConfig config = new DbxRequestConfig(
                "JavaTutorial/1.0", Locale.getDefault().toString());

        String accessToken = "XoxwrQlUvJIAAAAAAAAAvxcxsaNjRTdWVb4QM9l6jjds3IdkhmmOWGWxRAPnW2D1";

        client = new DbxClient(config, accessToken);

        try {
            System.out.println("Połączono z kontem: " + client.getAccountInfo().displayName);
        } catch (DbxException e) {
            System.out.println("Błąd połączenia z kontem! ");
        }
    }
}
