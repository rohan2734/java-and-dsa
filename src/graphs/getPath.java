package graphs;

import java.io.IOException;
import java.util.*;
import java.util.HashMap;

public class getPath {

    public static boolean getPathDFSHelper(int edges[][],int sv,int ev,boolean visited[]){
        if(sv == ev){
            System.out.print(sv + " ");
            return true;
        }
        visited[sv]=true;
        int n=edges.length;
        for(int i=0;i< n;i++){
            if(edges[sv][i] == 1 && !visited[i]){
                boolean result = getPathDFSHelper(edges,i,ev,visited);
                if(result == true){
                    System.out.print(sv + " ");
                    return true;
                }
                   

                
            }
        }
        return false;
    }

    public static void getPathBFS(int edges[][],int sv, int ev){
        boolean visited[] = new boolean [edges.length];

        getPathBFSHelper(edges, sv, ev, visited);
    }

    public static void getPathBFSHelper(int edges[][],int sv,int ev,boolean visited[]){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(sv);
        visited[sv]=true;
        boolean isFound=false; 
        HashMap<Integer,Integer> map = new HashMap<>();
        while(!queue.isEmpty()){
            int front = queue.poll();
            for(int i=0;i<edges.length;i++){
                if(edges[front][i]==1 && !visited[i]){
                   	map.put(i,front);
                    if(i == ev){
                        isFound =true;
                        break;
                    }
                    visited[i]=true;
                    queue.add(i);
                }
            }
            if(isFound)
                break;

        }

        if(isFound){
            
            int element = ev;
            while(element!=sv){
                System.out.print(element + " ");
                element = map.get(element);
            }
            if(element==sv)
                System.out.print(sv);
        }
        

    
    }

    public static void getPathDFS(int edges[][] , int sv,int ev){
        boolean visited[] = new boolean[edges.length];
        // for(int i=sv;i<edges.length;i++){
        //     if(!visited[i]){
                if(getPathDFSHelper(edges, sv,ev, visited)){
                    return;
                }
        //     }
        // } 
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
        
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
         int n;
        int e;
        Scanner s = new Scanner(System.in);
        
        n = s.nextInt();//number of vertices
        e = s.nextInt();//number of edges
        
        int edges[][] = new int[n][n];
        for(int i=0;i<e;i++){
            int fv = s.nextInt();
            int sv = s.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv]=1;
        }

        int sv = s.nextInt();
        int ev = s.nextInt();

        getPathDFS(edges,sv,ev);
        s.close();

	}
}
