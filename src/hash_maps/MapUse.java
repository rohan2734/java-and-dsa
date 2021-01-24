import java.util.HashMap;
import java.util.Set;

public class MapUse {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        //insertion
        map.put("abc", 1);
        map.put("def",2);

        if(map.containsKey("abc")){
            System.out.println("Has abc");
        }

        if(map.containsKey("abc1")){
            System.out.println("Has abc1");
        }
        int v = 0;
        if(map.containsKey("abc")){
            //returns Integer object,int v =null, and it throws exception
            v= map.get("abc");
        }
        System.out.println(v);

        //remove
        int s = map.remove("abc");
        System.out.println(s);

        if(map.containsValue(2)){
            //operations on the values are slower than the keys
            System.out.println("has 2");
        }
        
        map.put("abc",1);
        map.put("abc",2);
        System.out.println("size " + map.size());// it changes the value of key "abc" from 1 to 2 ,it doesnt add 1 and 2 with same key 
    
        //iterate
        Set<String> keys = map.keySet();
        for(String str:keys){
            System.out.println(str); //order will not be maintained
        }

    }   
}
