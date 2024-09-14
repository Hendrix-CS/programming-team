class Trie<K,V> {
    Map<K, V> children;
    boolean mark;

    public Trie() {
        children = new HashMap<>(); mark = false;
    }
    public void add(String s) { addR(s); }
    public void addR(String s) {
        if (s.equals("")) mark = true;
        else ensureChild(s.charAt(0)).addR(s.substring(1));
    }
    public Trie getChild(Character c) { return children.get(c); }
    public Trie ensureChild(Character c) {
        Trie t = getChild(c);
        if (t == null) {
            t = new Trie();
            children.put(c, t);
        }
        return t;
    }
}
