
public class Main {

    public static void main(String[] args) {

        //LIFOqueue<"String"> listLifo = new LIFOqueue<String>();
        LifoQueue<String> myLifo= new LifoQueue<>();
        //LinkedList<String> lista = new LinkedList<String>();
        //myLifo.add("1", 2);
       // myLifo.add("witam", LifoQueue.priority.NORMAL);
       // myLifo.add("123", LifoQueue.priority.LOW);
        //myLifo.add("zegnam !", 2);
        //myLifo.add(3, 2);

        myLifo.add("kamil", ENN.priority.LOW);
        myLifo.add("Ola", ENN.priority.URGENT);
        //obiekt <String> obiekcik =myLifo.get();
        //System.out.println(obiekcik.priority);
        //obiekcik =myLifo.get();
        obiekt sadasdas= myLifo.get();
        System.out.print(sadasdas.dane+ " ");
        System.out.println(sadasdas.prior);
        /*System.out.println(myLifo.get());
        System.out.println(myLifo.get());
        System.out.println(myLifo.get());
        System.out.println(myLifo.get());*/
            //System.out.println("Blad !");
    }
}
