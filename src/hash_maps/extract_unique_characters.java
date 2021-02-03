import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class extract_unique_characters {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String takeInput() throws IOException {
        String str = br.readLine(); 
        return str;
    }

    public static String uniqueChar(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        
        char[] inputCh = new char[str.length()];

        String output ="";
        for(int i=0;i<str.length();i++){
            inputCh[i] = str.charAt(i);
            
            char key = inputCh[i];
            if(!map.containsKey(key)){
                map.put(key, 1);
                output += key;
            }
        }

        return output;
        
	}


    public static void main(String[] args) throws NumberFormatException, IOException {


        String str = takeInput();
        System.out.print(uniqueChar(str));


    }
}
