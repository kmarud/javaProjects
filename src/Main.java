
import java.util.Scanner;

public class Main
{
    public static void menu() throws Exception
    {
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Witaj, wpisz adres zaczynając od http:// lub adres do pliku z rozszerzeniem: ");
        String address = odczyt.nextLine();
        boolean wszLink, aktDom;
        System.out.println("Wyswietlic znalezione linki ? y/n ");
        String czyWszystkieLinki = odczyt.nextLine();
        System.out.println("Tylko z aktualnej domeny? y/n ");
        String aktualnaDomena = odczyt.nextLine();
        if (czyWszystkieLinki.equals("y"))
            wszLink=true;
        else
            wszLink=false;

        if (aktualnaDomena.equals("y"))
            aktDom=true;
        else
            aktDom=false;

        AbstractReader czytacz;
        if(address.startsWith("http://"))
            czytacz = new WebPageReader();
        else
            czytacz = new FileReader();
        czytacz.read(address,wszLink,aktDom);                 //POLIMORFIZM
    }

    public static void main(String[] args) throws Exception
    {
        menu();
    }
}