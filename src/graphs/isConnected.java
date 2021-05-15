package graphs;

import java.util.*;

public class isConnected {

    public static void  isConnectedDFSHelper(int edges[][],int sv,boolean visited[]){
        visited[sv] = true;

        for(int i=0;i<edges.length;i++){
            if(edges[sv][i]==1 && !visited[i]){
                visited[i]=true;
                isConnectedDFSHelper(edges, i, visited);
            }
        }
    }

    public static boolean isConnectedDFS(int edges[][],int sv){
        boolean visited[] = new boolean[edges.length];

        isConnectedDFSHelper(edges,sv,visited);

        for(int i=0;i<edges.length;i++){
            if(!visited[i]){
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
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

        System.out.print(isConnectedDFS(edges,sv));
        s.close();
    }
}
