import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWriteMode;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class SendFileThread implements Runnable {
        String filename;
        DbxClient clientLocal;

       public SendFileThread(String name,DbxClient client){
           filename = name;
           clientLocal = client;
       }

       @Override
       public void run() {

           try {
               sendFile();
           } catch (Exception e) {
               e.printStackTrace();
           }

       }
        public void sendFile()  throws IOException{
            File inputFile = new File(PropertiesReader.folderToWatch + "/"  + filename);

            while(true) {
                FileInputStream inputStream = new FileInputStream(inputFile);
                try {
                    clientLocal.uploadFile("/" + filename,
                            DbxWriteMode.add(), inputFile.length(), inputStream);
                    System.out.println("Przesłano plik " + filename);
                    StatisticThread.incrementStaticticCounter();
                    break;

                } catch (Exception e) { //błąd podczas przesyłania pliku
                    /*System.out.println("AAA");
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e1) {
                    }*/
                    //System.out.println("błąd podczas przesyłania pliku");
                }
                inputStream.close();
            }
        }
    }
