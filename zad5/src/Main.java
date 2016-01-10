
public class Main {
    public static void main(String[] args) {

        PropertiesReader propertiesObject = new PropertiesReader();
        propertiesObject.readProperties();
        DropboxAutorization dropboxObject = new DropboxAutorization();
        dropboxObject.autorizeDropbox();
        MyDropboxClient clientObject = new MyDropboxClient();
        clientObject.getDirectoryToWatch();
    }
}
