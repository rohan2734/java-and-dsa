package graphs;

import java.util.*;

public class components {

    public static ArrayList<Integer> connectedComponentsHelper(int edges[][],int sv,boolean visited[]){
        visited[sv]=true;
        ArrayList<Integer> output = new ArrayList<>();
        output.add(sv);
        for(int i=0;i<edges.length;i++){
            if(edges[sv][i]==1 && !visited[i]){
                visited[i]=true;
                ArrayList<Integer> smallOutput = connectedComponentsHelper(edges,i,visited);
                output.addAll(smallOutput);
            }
        }

        return output;

        


    }

    public static void connectedComponents(int edges[][]){
        boolean visited[]  = new boolean[edges.length];

        // ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        for(int i=0;i<edges.length;i++){
            if(!visited[i]){
                ArrayList<Integer> smallOutput = connectedComponentsHelper(edges,i,visited);
                Collections.sort(smallOutput);
                for(int j=0;j<smallOutput.size();j++){
                    System.out.print(smallOutput.get(j) +" ");
                }
                System.out.println();
            }
            
        }
        

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

        // int sv = s.nextInt();

         connectedComponents(edges);
        s.close();
    }
}
