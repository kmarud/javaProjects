
public class FifoQueue<T> extends AbstractQueue<T>{

    /*public LifoQueue() {
        myList = new LinkedList<>();
    }*/
    public void add(T parameterData, MYQUEUE.priority parameterPriority)
    {
        myObiect = new object<>();
        myObiect.data=parameterData;
        myObiect.priority= parameterPriority;
        myObiect.id=counter++;
        myList.addFirst(myObiect);
    }
    /*public object get()
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
            return temp;
        }
    }*/
}
