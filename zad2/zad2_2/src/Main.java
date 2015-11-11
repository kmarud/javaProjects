
public class Main {

    public static void main(String[] args) {

        LifoQueue<String> myLifo= new LifoQueue<>();
        FifoQueue<Integer> myFifo = new FifoQueue<>();

        myLifo.add("kamil", MYQUEUE.priority.LOW);
        myLifo.add("Ola", MYQUEUE.priority.URGENT);
        myLifo.add("imie", MYQUEUE.priority.LOW);

       // System.out.println(myLifo.get().data);
        //System.out.println(myLifo.get().data);



        myFifo.add(1, MYQUEUE.priority.LOW);
        myFifo.add(2, MYQUEUE.priority.NORMAL);
        myFifo.add(3, MYQUEUE.priority.URGENT);

        System.out.println(myFifo.get().data);
        System.out.println(myLifo.get().id);
        //System.out.println(myFifo.get().data);
        //System.out.println(myFifo.get().data);
    }
}
