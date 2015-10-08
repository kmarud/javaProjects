
import java.util.Scanner;

public class Main
{
    public static void menu() throws Exception
    {
        Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od użytkownika
        System.out.println("Witaj, wpisz adres http:// lub adres do pliku z rozszerzeniem: ");
        String address = odczyt.nextLine();
        boolean temp;
        System.out.println("Wyswietlic znalezione linki ? y/n ");
        String czyWszystkieLinki = odczyt.nextLine();
        if (czyWszystkieLinki.equals("y"))
            temp=true;
        else
            temp=false;
        if(address.startsWith("http://"))
        {
            WebPageReader czytaczOnline = new WebPageReader();
            czytaczOnline.read(address, temp);
           // czytaczOnline.getData();
        }
        else
        {
            FileReader czytaczPlikow = new FileReader();
            czytaczPlikow.read(address, temp);
           // czytaczPlikow.funk();
        }
        //String address = odczyt.nextLine();

        //System.out.println("Witaj "+ imie); //wyświetlamy powitanie
    }
    public static void main(String[] args) throws Exception
    {
        menu();
    }
}