import java.util.NoSuchElementException;
import java.util.Scanner;

public class ProgramFactory {
    void test() {
        LifoQueue<String> myLifo = new LifoQueue<>();

        myLifo.add("To", MYQUEUE.priority.LOW);
        myLifo.add("jest", MYQUEUE.priority.URGENT);
        myLifo.add("test", MYQUEUE.priority.LOW);
        System.out.println(myLifo.get().data);
        myLifo.add("TEST", MYQUEUE.priority.LOW);
        myLifo.add("Stosu", MYQUEUE.priority.LOW);

        System.out.println(myLifo.get().data);
        System.out.println(myLifo.get().data);
        System.out.println(myLifo.get().data);
        System.out.println(myLifo.get().data);
        try {
            System.out.println(myLifo.get().data);
        }catch (NoSuchElementException e)
        {
            System.out.println("\tBlad, kolejka pusta !\n");
        }

        FifoQueue<Integer> myFifo = new FifoQueue<>();

        myFifo.add(1, MYQUEUE.priority.LOW);
        myFifo.add(2, MYQUEUE.priority.NORMAL);
        myFifo.add(3, MYQUEUE.priority.URGENT);

        while(true) {
            try {
                object temp = myFifo.get();
                System.out.println("dane=" + temp.data + " priorytet=" + temp.priority + " id=" + temp.id);
            }catch (NoSuchElementException e) {break;}
        }
    }

    void mojTest() {
        AbstractQueue<String> myQueue;
        System.out.println("Ktorej kolejki chcesz uzyc ?");
        System.out.println("1 - LIFO (stos)");
        System.out.println("2 - FIFO (kolejka)");

        Scanner reader = new Scanner(System.in); //obiekt do odebrania danych od użytkownika
        String input = reader.next();
        if (input.equals("1"))
            myQueue = new LifoQueue<>();
        else if (input.equals("2"))
            myQueue = new FifoQueue<>();
        else
            return;

        System.out.println("1 - dodaj element");
        System.out.println("2 - pobierz element");
        input = reader.next();
        if (input.equals("1"))
        {
            System.out.println("Wpisz dane:");
           // myQueue.add();
        }
        else if (input.equals("2"))
            myQueue = new FifoQueue<>();
        else
            return;
    }
}
