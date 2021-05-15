package graphs;

import java.io.IOException;
import java.util.Scanner;

public class hasPath {

    public static boolean hasPathDFSHelper(int edges[][],int sv,int ev,boolean visited[]){
        if(sv == ev){
            return true;
        }
        visited[sv]=true;
        for(int i=0;i<edges.length;i++){
            if(edges[sv][i]==1 && !visited[i] ){
                // if(i == ev){
                //     return true;
                // }
               boolean ans  =   hasPathDFSHelper(edges,i,ev,visited);
                if(ans){
                    return ans;
                }
            }
        }

        return false;


    } 
    public static boolean hasPathDFS(int edges[][],int sv,int ev){
        int n=edges.length;
        boolean visited[] = new boolean[n];
        
        // for(int i=sv;i<n;i++){
        //     if(!visited[i]){
                boolean result = hasPathDFSHelper(edges,sv,ev,visited);
                // System.out.print(result);
                if(result){
                    return result;
                }
        //     }
        // }

        return false;
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        int n;
        int e;

        Scanner s = new Scanner(System.in);

        n=s.nextInt();
        e=s.nextInt();

        int edges[][] = new int[n][n];

        for(int i=0;i<e;i++){
            int fv= s.nextInt();
            int sv = s.nextInt();

            edges[fv][sv]=1;
            edges[sv][fv]=1;

        }

        int sv = s.nextInt();
        int ev = s.nextInt();

        System.out.print(hasPathDFS(edges,sv,ev));
        s.close();


	}
    
}
