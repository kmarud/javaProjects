/**
 * Created by kamil on 11.11.15.
 */

import java.util.LinkedList;

public class LifoQueue<T> extends AbstractQueue<T>{

    public LifoQueue() {
        XXX = new LinkedList<obiekt>();
    }
    public void add(T ddd, ENN.priority cos)
    {
        abc = new obiekt<>();
        abc.dane=ddd;
        abc.prior= cos;
        XXX.addLast(abc);
    }
    public obiekt get()
    {
        //T obiect;
        try {
            obiekt obiect = XXX.getLast();
            XXX.removeLast();
            return obiect;

        }catch (java.util.NoSuchElementException e) {
            System.out.println("blad !");
            obiekt obiect = new obiekt();
            obiect.dane="";
            obiect.prior=ENN.priority.LOW;
            return obiect;
        }
    }
}
