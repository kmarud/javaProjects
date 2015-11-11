
import java.util.LinkedList;

class ENN {
    enum priority {URGENT, NORMAL, LOW}
}
class obiekt <T>{
    public T dane;
    public ENN.priority prior;
   // public int id;
    //public String error = "blad";
}


public abstract class AbstractQueue<T> {
    LinkedList<obiekt> XXX;
    obiekt<T> abc;

    public AbstractQueue() {
        XXX = new LinkedList<obiekt>();
    }
    //LifoQueue<Integer> myLifo= new LifoQueue<>();

    public abstract void add(T ddd, ENN.priority cos);

    public abstract obiekt get();

}
