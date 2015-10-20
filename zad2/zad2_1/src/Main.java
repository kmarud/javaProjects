/**
 * Created by kamil on 20.10.15.
 */

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args){
        //tworzymy tablicę
        List<String> lista = new ArrayList<String>();
        MyCustomList<String> sample = new MyCustomList<>();
        //sample.set("aa");
        System.out.println("przed " + sample.size());
        sample.add("Ala");
        sample.add("Ala");
        sample.add("ma");
        sample.add("kota");
        sample.add("i");
        sample.add("psa");
        System.out.println("po " + sample.size());
        sample.remove("Ala");
        System.out.println("po po" + sample.size());
        System.out.println(sample.findFirst("psa"));
       // System.out.println(sample.get(0));
//        //dodajemy elementy typu Object - czyli dowolne, my dodamy ciągi znaków
//        lista.add("Asia");
//        lista.add("Basia");
//        lista.add("Krzysiek");
//        lista.add("Wojtek");
//
//        //sprawdzamy rozmiar listy
//        System.out.println("Rozmiar listy to: "+lista.size());
//
//        //usuwamy obiekt "Asia" i sprawdzamy rozmiar
//        lista.remove("Asia");
//        System.out.println("Rozmiar listy to: "+lista.size());
//
//        //usuwamy obiekt zajmujący 2 miejsce, czyli o indeksie 1 - u nas "Krzysiek"
//        lista.remove(1);
//        System.out.println("Rozmiar listy to: "+lista.size());
//
//        //na koniec przypiszmy pierwszy element listy zmiennej imie i wyświetlmy go
//        //musimy użyć rzutowania, ponieważ inaczej próbowalibyśmy przypisać Object do String
//        String imie = (String)lista.get(0);
//        System.out.println("Pierwszy element listy to: "+imie);

    }
}
