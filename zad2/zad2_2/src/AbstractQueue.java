
import java.util.LinkedList;
import java.util.NoSuchElementException;

class MYQUEUE {
    enum priority {URGENT, NORMAL, LOW}
}
class object <T>{
    public T data;
    public MYQUEUE.priority priority;
    public int id;
}


abstract class AbstractQueue<T> {
    LinkedList<object> myList;
    object<T> myObiect;
    int idCounter = 0;
    public AbstractQueue() {
        myList = new LinkedList<>();
    }

    public abstract void add(T parameterData, MYQUEUE.priority parameterPriority);

    public object get() throws NoSuchElementException
    {
       // try {
            object temp = myList.getLast();
            myList.removeLast();
            return temp;
       /* }catch (java.util.NoSuchElementException e) {
            System.err.print("Blad, kolejka pusta ! ");
            object temp = new object();
            temp.data="";
            temp.priority=MYQUEUE.priority.LOW;
            temp.id=-1;
            return temp;
        }*/
    }

}
