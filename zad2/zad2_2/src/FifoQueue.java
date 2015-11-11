/**
 * Created by kamil on 11.11.15
 *
 *
 * FIFO JESZCZE Nie skonczona
 */
import java.util.LinkedList;

public class FifoQueue<T> {
    LinkedList<T> XXX;
    public FifoQueue() {
        XXX = new LinkedList<T>();
    }
    public void add(T obiect, int priority)
    {
        XXX.addFirst(obiect);
    }
    public T get()
    {
        //T obiect;
        try {
            T obiect = XXX.getLast();
            XXX.removeLast();
            return obiect;

        }catch (java.util.NoSuchElementException e) {
            return (T)"Blad, kolejka pusta !";
            //return null;
        }
        //return XXX.pop();
        //return obiect;
    }
}
