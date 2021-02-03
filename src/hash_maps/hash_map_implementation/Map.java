package hash_map_implementation;

import java.util.ArrayList;

public class Map<K,V>{
    //bucket arrays every element will store linkedlist
    //Node<K,v>
    //we cannnot make an array with generic type
    //like Node<K,V>
    ArrayList<MapNode<K,V>> buckets;
    int size;//no of entries into map
    int numBuckets;
    public Map(){
        numBuckets = 5;
        buckets = new ArrayList<>();

        for(int i=0;i<20;i++){
            buckets.add(null); //20 empty LL will be inserted into buckets
        }
    }

    private int getBucketIndex(K key){
        int hashCode = key.hashCode(); 
        //object has a hashCode , it figures out on the basis of address of the hashcode
        return hashCode % numBuckets;

    }

    public int size(){
        return size;
    }

    public V removeKey(K key){
        int bucketIndex = getBucketIndex(key);

        MapNode<K,V> head = buckets.get(bucketIndex);
        MapNode<K,V> prev = null;
        while(head != null){
            if(head.key.equals(key)){
                size--;
                if(prev == null){
                    buckets.set(bucketIndex, head.next);
                }else{
                    prev.next = head.next;
                }
                
                return head.value;
            }
            prev=head;
            head  = head.next;
        }
        return null;
    }

    public V getValue(K key){
        int bucketIndex = getBucketIndex(key);

        MapNode<K,V> head = buckets.get(bucketIndex);

        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head  = head.next;
        }

        return null;
        
    }

    public double loadFactor(){
        return (1.0*size)/numBuckets;
    }

    private void rehash(){
        System.out.println("Rehasing : buckets " + numBuckets + "  size :" +size);
        ArrayList<MapNode<K,V>> temp = buckets;
        buckets = new ArrayList<>();

        for(int i=0;i < 2*numBuckets;i++){
            buckets.add(null);
        }

        size= 0 ;
        numBuckets*=2;

        for( int i=0;i<temp.size();i++){
            MapNode<K,V> head = temp.get(i);
            while(head != null){
                K key = head.key;
                V value = head.value;
                
                insert(key, value);
                head = head.next;
            }
        }

    }

    public void insert(K key,V value){
        int bucketIndex = getBucketIndex(key);
        //if we have the same key, then it will update value, else we will create a new entry
        MapNode<K , V> head = buckets.get(bucketIndex);

        while(head != null){
            //== compares memory address
            //use .eqauls 
            if(head.key.equals(key)){
                head.value = value;
            }
            head  = head.next;
        }
        head = buckets.get(bucketIndex);
        MapNode<K,V> newElementNode = new MapNode<K,V>(key, value);
        size++;
        newElementNode.next = head;
        buckets.set(bucketIndex, newElementNode);  
        
        //reshasing
        double loadFactor = (1.0*size) / numBuckets;
        if(loadFactor > 0.7){
            rehash();
        }
    }
}