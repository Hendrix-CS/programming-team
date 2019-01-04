import java.util.*;

public class TreeBag<E extends Comparable<E>> implements Iterable<E> {
    private TreeMap<E, Integer> map;
    private int totalSize;
    public TreeBag() { map = new TreeMap<>(); }
    public void add(E e) {
        if (!map.containsKey(e)) map.put(e,0);
        map.put(e, map.get(e) + 1);
        totalSize++;
    }
    public void remove(E e) {
        if (map.containsKey(e)) {
            if (map.get(e) == 1) map.remove(e);
            else map.put(e, map.get(e) - 1);
            totalSize--;
        }
    }
    public int size() { return totalSize; }
    public boolean isEmpty() { return map.isEmpty(); }
    public int count(E e) { return map.containsKey(e) ? map.get(e) : 0; }
    public E first() { return map.firstKey(); }
    public E last() { return map.lastKey(); }
    public E pollFirst() { E e = first(); remove(e); return e; }
    public E pollLast() { E e = last(); remove(e); return e; }
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Iterator<E> it = map.keySet().iterator();
            E cur; int count = 0;
            public boolean hasNext() { return it.hasNext() || count > 0; }
            public E next() {
                if (count == 0) { cur = it.next(); count = map.get(cur); }
                count--; return cur;
            }
        };
    }
}
