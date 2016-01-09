
public class Main {
    public static void main(String[] args) {

        DropboxAutorization dropboxObject = new DropboxAutorization();
        dropboxObject.autorizeDropbox();
        MyDropboxClient clientObject = new MyDropboxClient();
        clientObject.getDirectoryToWatch();
    }
}
