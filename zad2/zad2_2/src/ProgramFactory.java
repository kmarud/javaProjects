import java.util.NoSuchElementException;
import java.util.Scanner;

public class ProgramFactory {
    void preparedTest() {                           //metoda testowa
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
            System.out.println("\tKolejka pusta !\n");
        }

        FifoQueue<Integer> myFifo = new FifoQueue<>();

        myFifo.add(1, MYQUEUE.priority.LOW);
        myFifo.add(2, MYQUEUE.priority.NORMAL);
        myFifo.add(3, MYQUEUE.priority.URGENT);

        while(true) {
            try {
                object temp = myFifo.get();
                System.out.println("dane=" + temp.data + "\tpriorytet=" + temp.priority + "\tid=" + temp.id);
            }catch (NoSuchElementException e) {break;}
        }
    }

    void interactiveTest() {
        AbstractQueue myQueue;
        Scanner reader = new Scanner(System.in);

        System.out.println("Ktorej kolejki chcesz uzyc ?");
        System.out.println("1 - LIFO (stos)");
        System.out.println("2 - FIFO (kolejka)");
        String inputQueueType = reader.next();
        if(inputQueueType.equals("1"))
            myQueue = new LifoQueue<String>();
        else if (inputQueueType.equals("2"))
            myQueue = new FifoQueue<String>();
        else
            return;

        while(true) {
            System.out.println("1 - dodaj element");
            System.out.println("2 - pobierz element");
            System.out.println("3 - wyjscie");
            String inputOperation = reader.next();
            if (inputOperation.equals("1")) {
                System.out.println("Wpisz dane:");
                String inputData = reader.next();
                System.out.println("Priorytet: \n1 - LOW \n2 - NORMAL \n3 - URGNET");
                String inputPriority = reader.next();
                if (inputPriority.equals("1"))
                    myQueue.add(inputData, MYQUEUE.priority.LOW);
                else if (inputPriority.equals("2"))
                    myQueue.add(inputData, MYQUEUE.priority.NORMAL);
                else if (inputPriority.equals("3"))
                    myQueue.add(inputData, MYQUEUE.priority.URGENT);
                else
                    break;
            } else if (inputOperation.equals("2")) {
                try {
                    object temp = myQueue.get();
                    System.out.println("\tdane=" + temp.data + "\tpriorytet=" + temp.priority + "\tid=" + temp.id + "\n");
                } catch (NoSuchElementException e) {
                    System.out.println("\tKolejka pusta !\n");
                }
            }
            else
                break;
        }
    }
}
