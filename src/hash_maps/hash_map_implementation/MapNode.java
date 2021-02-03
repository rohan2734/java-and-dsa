package hash_map_implementation;

public class MapNode<K,V> {
    K key;
    V value;
    MapNode<K,V> next;

    public MapNode(K key,V Value){
        this.key=key;
        this.value=Value;
    }
}
