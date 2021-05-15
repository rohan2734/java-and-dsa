package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Graph{

    public static void printHelperDFS(int edges[][],int sv,boolean visited[]){
        System.out.println(sv);
        visited[sv]=true;
        int n=edges.length;
        for(int i=0;i< n;i++){
            if(edges[sv][i] == 1 && !visited[i]){
                printHelperDFS(edges,i,visited);
            }
        }
    }

    public static void printDFS(int edges[][] , int sv){
        boolean visited[] = new boolean[edges.length];
        for(int i=0;i<edges.length;i++){
            if(!visited[i]){
                printHelperDFS(edges, i, visited);
            }
        } 
    }

    public static void printHelperBFS(int edges[][] , int sv,boolean visited[]){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(sv);
        
        visited[sv] = true;
        
        int n=edges.length;
        while(!queue.isEmpty()){
            int front = queue.poll();
            System.out.print(front + " ");
            for(int i=0;i<n;i++){
                if(edges[front][i]==1 && !visited[i] ){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
        
        

    }

    public static void printBFS(int edges[][], int sv){
        boolean visited[] = new boolean[edges.length];
        for(int i=0;i<edges.length;i++){
            if(!visited[i]){
                printHelperBFS(edges, i, visited);
            }
        }
    }
    public static void main(String[] args) {
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
        // printDFS(edges,0);
        printBFS(edges,0);
        s.close();
    }
}
/**
 * if our graph is disconnected, then the other component will not print
 * the complete graph will not print
 * so after printing, one component, we need to see other elements which are not visiited and consider it as starting element and repeat it
 * 
 */