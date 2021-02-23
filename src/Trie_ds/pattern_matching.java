package Trie_ds;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * pattern_matching
 */
public class pattern_matching {

    

    public static class TrieNode{

        char data;
        boolean isTerminating;
        TrieNode children[];
        int childCount;

        public TrieNode(char data) {
            this.data = data;
            isTerminating = false;
            children = new TrieNode[26];
            childCount = 0;
        }
    }


    public  static class Trie {

        private TrieNode root;
        public int count;
        public Trie() {
            root = new TrieNode('\0');
        }

        public boolean search(String word){
            return search(root, word);
        }

        private boolean search(TrieNode root, String word) {
            if(word.length() == 0){
                return true;
            }
            int childIndex = word.charAt(0) - 'a';
            TrieNode child = root.children[childIndex];
            if(child == null){
                return false;
            }
            return search(child, word.substring(1));
        }
        
        // public boolean patternMatchingHelper(String inputString,String pattern){
        //     int k=0;
        //     for(int i=0;i<inputString.length();i++){
        //         while(k < pattern.length() &&  i< inputString.length() && inputString.charAt(i) == pattern.charAt(k)){
        //             k++;
        //             i++;
        //         }
        //     }
        //     if(k == pattern.length()){
        //         return true;
        //     }else{
        //         return false;
        //     }
        // }

        // public boolean patternMatching(ArrayList<String> vect, String pattern) {
        //     // Write your code here
        //     for(int i=0;i<vect.size();i++){
                
        //         String subVect =vect.get(i);
        //         boolean output = patternMatchingHelper(subVect,pattern);
        //         if(output){
        //             return true;
        //         }
        //     }
            
        //     return false;
        // }

        public void add(String word){
            add(root,word);
        }
    
        private void add(TrieNode root,String word){
    
            if(word.length() == 0){
                root.isTerminating=true;
                return;
            }
    
            int childIndex = word.charAt(0)-'a';
            //assuming all are small case letters
            TrieNode child = root.children[childIndex];
            if(child == null){
                child = new TrieNode(word.charAt(0));
                root.children[childIndex] = child;
                root.childCount++;
            }
    
            add(child,word.substring(1));
    
        }

        public boolean patternMatching(ArrayList<String> vect, String pattern) {
            // Write your code here
            
            for(int i=0;i<vect.size();i++){
               for(int j=0;j<vect.get(i).length();j++){
                   add(vect.get(i).substring(j));
               } 
               
            }
            
            return search(pattern);
        }


    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	
	public static void main(String[] args) throws IOException{
		Trie t = new Trie();
		int n = Integer.parseInt(br.readLine().trim());
        ArrayList<String> input = new ArrayList<String>();
        String[] words = br.readLine().split("\\s");
		for(int i = 0; i < n; i++) {
			
			input.add(words[i]);
		}
		String pattern = br.readLine();
		System.out.println(t.patternMatching(input, pattern));
	}


}