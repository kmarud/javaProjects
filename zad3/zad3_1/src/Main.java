import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private HashSet<User> zbior = new HashSet<>();
    public static void main(String[] args) {
	// write your code here

        // Nazwa pliku do którego zapiszemy i z którego odczytamy tekst
        //Main instance = new Main();
        FileReadWrite instance = new FileReadWrite();
        instance.read();
        instance.write();
        //instance.odczytajPlik("my.csv");


        //System.out.println("Odczytany tekst:\n" + odczytanyTekst);

       /* Set<String> zbior = new HashSet<String>();
        zbior.add("pierwszy");
        zbior.add("drugi");
        zbior.add("drugi");
        zbior.add("trzeci");
        zbior.add("pierwszy");
        for (String ciagZnakow : zbior) {
            //można też użyć po prostu zbior, zamiast zbior.iterator()
            System.out.println(ciagZnakow);
        }*/
    }
    /*public void analyze(String word)
    {
        zbior.add(word);
    }*/

    public String odczytajPlik(String nazwaPliku) {
        File plikDane = new File(nazwaPliku);
        String odczyt = "";
        try {

            Scanner skaner = new Scanner(plikDane);
            skaner.nextLine();
            while (skaner.hasNextLine()) {
                String temp = skaner.nextLine();
                String[] parts = temp.split(",");
                try {
                    User newPerson = new User(Long.parseLong(parts[0]), parts[1], PHONE_OPERATOR.valueOf(parts[2]), parts[3]);
                    zbior.add(newPerson);
                }catch (IllegalArgumentException e)
                {
                    System.err.println("error");
                }
                    /* newPerson.id=parts[0];
                newPerson.name=parts[1];
                newPerson.phone_operator=parts[2];
                newPerson.phone_number=parts[3];*/


                //String part1 = parts[0]; // 004
                //String part2 = parts[1]; // 034556
                //analyze(skaner.nextLine());
                //odczyt = odczyt + skaner.nextLine() + "\n";
            }

        } catch (FileNotFoundException e) {
            System.out.println("Brak Pliku do odczytania!");
        }

        for (User ciagZnakow : zbior) {
            //można też użyć po prostu zbior, zamiast zbior.iterator()
            ciagZnakow.przedstawSie();
        }
        System.out.println("\nsize: " + zbior.size());
        return odczyt;
    }
}
