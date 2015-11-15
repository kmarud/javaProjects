
class LifoQueue<T> extends AbstractQueue<T>{

    public void add(T parameterData, MYQUEUE.priority parameterPriority)
    {
        myObiect = new object<>();
        myObiect.data=parameterData;
        myObiect.priority= parameterPriority;
        myObiect.id=idCounter++;
        myList.addLast(myObiect);
    }
}
