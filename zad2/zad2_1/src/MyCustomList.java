import java.util.Arrays;

/**
 * Created by kamil on 20.10.15.
 * lista:
 1.add
 2.remove
 3.removeIndex
 4.size
 5.get
 6.findFirst
 7.
 */
public class MyCustomList<T> {

    private  T firstParameter;
    private T[] table, tempTable;
    private int index;
    private final int MAX = 50;
    MyCustomList()
    {
        index = 0;
        table = (T[])new Object[0];
    }
    public void set(T param)
    {
        firstParameter = param;
    }
   /* public T get()
    {
        return firstParameter;
    }*/
    public int size() {return table.length;}
    public void add(T object)
    {
        table = Arrays.copyOf(table, table.length+1);
        table[index++] = object;
    }
    public T get(int paramIndex)
    {
        if(paramIndex<index)
            return table[paramIndex];
        else
            return null;
    }

    public void remove(T param)
    {
        tempTable = (T[])new Object[index+1];
        int j=0;
        for (int i=0; i< table.length; ++i)
        {
            if(table[i] != param)
            {
                tempTable[j] = table[i];
                j++;
            }
        }
        table=Arrays.copyOf(tempTable, j);
    }
    public int findFirst(T param)
    {
        for (int i=0; i< table.length; ++i)
            if(table[i] == param)
                return i;
        return -1;
    }
}
