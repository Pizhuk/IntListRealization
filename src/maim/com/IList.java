package maim.com;

public interface IList {
    void clear();
    int size();
    int get(int index);
    boolean add(int value);
    boolean add(int index, int value);
    boolean remove(int number);
    int removeByIndex(int index);
    boolean contains(int value);
    boolean set(int index, int value);
    void print();
    int[] toArray();
    boolean removeAll(int[] ar);
}
