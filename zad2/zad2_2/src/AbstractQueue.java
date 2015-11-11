
import java.util.LinkedList;

class MYQUEUE {
    enum priority {URGENT, NORMAL, LOW}
}
class object <T>{
    public T data;
    public MYQUEUE.priority priority;
    public int id;
}


public abstract class AbstractQueue<T> {
    LinkedList<object> myList;
    object<T> myObiect;
    int counter = 0;
    public AbstractQueue() {
        myList = new LinkedList<>();
    }

    public abstract void add(T ddd, MYQUEUE.priority cos);

    public object get()
    {
        try {
            object temp = myList.getLast();
            myList.removeLast();
            return temp;

        }catch (java.util.NoSuchElementException e) {
            System.out.println("Blad, kolejka pusta !");
            object temp = new object();
            temp.data="";
            temp.priority=MYQUEUE.priority.LOW;
            temp.id=-1;
            return temp;
        }
    }

}
