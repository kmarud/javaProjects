import java.util.Scanner;

public class ProgramFactory {
    public void run() throws Exception{
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("Witaj, wpisz adres zaczynając od http:// lub adres do pliku z rozszerzeniem: ");
        String address = scannerObject.nextLine();
        System.out.println("Wyswietlic znalezione linki ? y/n ");
        String isAllLinks = scannerObject.nextLine();
        System.out.println("Tylko z aktualnej domeny? y/n ");
        String currentDomain = scannerObject.nextLine();

        AbstractReader mainReader;
        if (address.startsWith("http://"))
            mainReader = new WebPageReader();
        else
            mainReader = new FileReader();
        mainReader.read(address, isAllLinks.equals("y"), currentDomain.equals("y"));
    }
}
