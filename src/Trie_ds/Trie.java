package Trie_ds;

class TrieNode{
    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data){
        this.data = data;
        isTerminating=false;
        children = new TrieNode[26];
        childCount=0;
    }
}

public class Trie{
    private TrieNode root;

    public Trie(){
        root = new TrieNode('\0');
    }

    

    public void remove(String word){
        remove(root,word);
    }

    public void remove(TrieNode root,String word){
        if(word.length() == 0){
            root.isTerminating = false;
            return;
        }

        int childIndex = word.charAt(0)-'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            return;
        }

        remove(child,word.substring(1));
        //we can remove child node only if it is non terminating and its number of children are 0
        
        
        // if(!child.isTerminating){
        //     int numChild=0;
        //     for(int i=0;i<26;i++){
        //         if(child.children[i] != null){
        //             numChild++;
        //         }
        //     }
        //     if(numChild==0){
        //         //we can delete child
        //         root.children[childIndex] = null;
        //         child=null;
        //         root.childCount--;
                
        //     }

        // }

        if(!child.isTerminating && child.childCount == 0){
            root.children[childIndex] = null;
            //since we are adding address, when we are removing them, we are making it as null
            child=null;
            root.childCount--;
        }
    }

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
    public int countWords(TrieNode root2){
        
       
        int numWords=0;
        for(int i=0;i<root2.children.length;i++){
            TrieNode child = root2.children[i];
            
            
            if(child !=null){
                numWords+=countWords(child);
                
                if(child.isTerminating){
                    numWords++;
                }
            }
        
        }
        
        return numWords;
        
    }

    public boolean search(TrieNode root,String word){
        if(word.length() == 0){
            // if(root.isTerminating==true){
            //     return true;
            // }else{
            //     return false;
            // }
            return root.isTerminating;
        }
        
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        
        if(child == null){
            return false;
        }
        
        return search(child,word.substring(1));
    }
    public boolean search(String word){
        return search(root,word);
    }
}