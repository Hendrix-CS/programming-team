import java.util.*;

public class AdjustablePQ<E extends Comparable<E>> {
    protected ArrayList<E> elems;
    protected HashMap<E, Integer> indices;
    protected Comparator<E> cmp;
    public AdjustablePQ() { this(Comparator.naturalOrder()); }
    public AdjustablePQ(Comparator<E> cmp) {
        elems = new ArrayList<>(); elems.add(null);
        indices = new HashMap<>();
        this.cmp = cmp;
    }
    public int size() { return elems.size() - 1; }
    public boolean isEmpty() { return size() == 0; }
    public void add(E item) { set(elems.size(), item); reheapUp(last()); }
    public E remove() {
        E ret = elems.get(1);
        set(1, elems.get(last())); elems.remove(last());
        reheapDown(1);
        return ret;
    }
    public E peek() { return elems.get(1); }
    public void adjust(E item) { int i = indices.get(item); reheapUp(i); reheapDown(i); }

    protected int last() { return elems.size() - 1; }
    protected void set(int i, E item) {
        if (i == elems.size()) elems.add(item);
        else elems.set(i, item);
        indices.put(item, i);
    }
    protected void swap(int i, int j) {
        E tmp = elems.get(i); set(i, elems.get(j)); set(j, tmp);
    }
    protected void reheapUp(int i) {
        if (i <= 1) return;
        if (cmp.compare(elems.get(i), elems.get(i/2)) >= 0) return;
        swap(i, i/2); reheapUp(i/2);
    }
    protected void reheapDown(int i) {
        if (2*i > last()) return;
        int small = 2*i;
        if (2*i+1 <= last() && cmp.compare(elems.get(2*i), elems.get(2*i+1)) > 0)
            small++;
        if (cmp.compare(elems.get(i), elems.get(small)) > 0) {
            swap(i, small); reheapDown(small);
        }
    }
}
