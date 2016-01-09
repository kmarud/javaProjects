import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWriteMode;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


   public class SendFileThread implements Runnable {
        String filename;
        DbxClient clientLocal;
        //ExecutorService executor;

       public SendFileThread(String name,DbxClient client){//, ExecutorService e ){
           filename = name;
           clientLocal = client;
           //executor = e;
       }

       @Override
       public void run() {

           try {
               sendFile();
           } catch (Exception e) {
               System.out.println("błąd !");
           }

       }
        public void sendFile() throws IOException, DbxException {
            File inputFile = new File("test/"  + filename);
            FileInputStream inputStream = new FileInputStream(inputFile);
            try {
                //DbxEntry.File uploadedFile =
                 clientLocal.uploadFile("/" + filename,
                        DbxWriteMode.add(), inputFile.length(), inputStream);
                System.out.println("Przesłano plik " + filename);

            }catch (DbxException e)
            {
                System.out.println("błąd podczas przesyłania pliku: " + filename);
            }catch (IOException e){
                System.out.println("ioexp");
            }
            finally {
                inputStream.close();
                //executor.shutdown();
            }
        }
    }
