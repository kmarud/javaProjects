import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;


public class FileReadWrite {
    String filename;
    String outputFilename;
    String errorsFilename;
    int rowsPerFile;
    File fileHandle = new File("properties.txt");
    private HashSet<User> zbior = new HashSet<>();
    FileReadWrite() {
        try {
            Scanner skaner = new Scanner(fileHandle);
            filename = skaner.nextLine().split("=")[1];
            //System.out.println(filename);
            outputFilename = skaner.nextLine().split("=")[1];
            errorsFilename = skaner.nextLine().split("=")[1];
            rowsPerFile = 123;//skaner.nextLine().split("=")[1];
        }catch(FileNotFoundException e)
        {
            System.out.println("brak pliku properties");
        }
    }
    void read()
    {
        File plikDane = new File(filename);
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
            ciagZnakow.przedstawSie();
        }
        System.out.println("\nsize: " + zbior.size());
    }

    void write()
    {

        try {
            PrintWriter out = new PrintWriter(outputFilename);
            for (User ciagZnakow : zbior) {
                //System.out.println(ciagZnakow.returnData());
                out.println(ciagZnakow.returnData());

            }
            out.close();
        }catch(FileNotFoundException e)
        {}

    }
}
