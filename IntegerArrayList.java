public class IntegerArrayList implements IntegerList{
    private Integer[] data;
    private int size; 

    public IntegerArrayList()
    {
        data = new Integer[10];
        size = 0;
    }

    private void resizeInternalArrayIfNecessary() 
    {
        if (size >= data.length)
        {
          Integer[] bigger = new Integer[data.length*2];
          for (int i =0; i<data.length; i++)
          {
              bigger[i] = data[i];
          }
          data = bigger;
        }  
    }

    public void add(Integer val)
    {
        resizeInternalArrayIfNecessary();
        data[size] = val;
        size++;
    }

    public void add(int index, Integer val)
    {
        resizeInternalArrayIfNecessary();
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        for (int i=size; i > index; i--)
        {
            data[i] = data[i-1]; 
        }
        data[index] = val;
        size++;
    }

    public void set(int index, Integer val)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        data[index] = val;
    }

    public void clear()
    {
        size = 0;
        Integer[] temp = new Integer[10];
        data = temp;
    }

    public Integer remove(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Integer removed = data[index];
        Integer[] temp = new Integer[data.length-1];
        for (int i = size; i>= index; i--)
        {
            temp[i] = data[i+1];
        }
        for (int i=0; i<index; i++)
        {
            temp[i]= data[i];
        }
        data = temp;
        size--;
        return removed;
    }

    public Integer get(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return data[index];
    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        if (size==0)
        {
            return true;
        }
        return false; 
    }
    public boolean contains(Integer val)
    {   
        boolean contains = false;
        for (int i=0; i<size; i++)
        {
            if (data[i] == val)
            {
                contains = true;
            } 
        }
        return contains;
    }
    public int indexOf(Integer val)
    {
        int index = -1; 
        for (int i=0; i<size; i++)
        {
            if (data[i]== val)
            {
                index = i;
            }
        }
        return index;
    }
    public boolean equals(List<Integer> other)
    {
        boolean equals = false;
        if (data.length != other.size())
        {
            equals = false;
        }
        else{
        for (int i=0; i<size; i++)
        {
            
            if (data[i] == other.get(i))
            {
                equals = true;
            }
            else{
                equals = false;
                break;
            }
        }
        }   
        return equals;
    }

    public String toString()
    {
        String output = "[";
        for (int i=0; i<size-1; i++)
        {
            output += data[i] + ",";
        }
        output += data[size-1] + "]";
        return output; 
    }
}
