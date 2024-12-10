package com.example.KosarajusAlgorithm;

import java.util.ArrayList;
import java.util.Stack;



public class KosaRajusAlgorithm {

public static void createGraph(ArrayList<Edge> graph[]) {
		
		for(int i=0; i< graph.length; i++){
			graph[i] = new ArrayList<Edge>();
		}
		
		graph[0].add(new Edge(0, 2));
		graph[0].add(new Edge(0, 3));
		
		graph[1].add(new Edge(1, 0));
		
		graph[2].add(new Edge(2, 1));
		
		graph[3].add(new Edge(3, 4));			
	}

          private static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {
	        
        	vis[curr]=true;
        	for(int i=0; i< graph[curr].size(); i++) {
        		Edge e = graph[curr].get(i);
        		if(!vis[e.dest]) {
        			topSort(graph, e.dest, vis, stack);
        		}
        	}
        	
        	stack.push(curr);
	
         }
          
          
          public static void dfs(ArrayList<Edge> graph[], boolean[] vis, int curr) {
        	 vis[curr]=true;
        	 System.out.print(curr + " ");
        	 for(int i=0; i< graph[curr].size(); i++) {
        		 Edge e = graph[curr].get(i);
        		 if(!vis[e.dest]) {
        			 dfs(graph, vis, e.dest);
        		 }
        	 }
        	  
          }
     public static void kosarajuAlgorithm(ArrayList<Edge> graph[], int V) {
	
    	 //Step1- Topological Sort
    	 Stack<Integer> stack = new Stack<>() ;
         boolean[] vis = new boolean[V];
         for(int i=0; i< V;i++) {
             if(!vis[i]) {
            	 vis[i]= false;
            	 topSort(graph, i, vis, stack);
             }	 
         }
         
         
         //Step 2:- Transpose
         ArrayList<Edge> transpose[] = new ArrayList[V];
         for(int i=0; i< transpose.length; i++){
        	 vis[i] = false;
        	 transpose[i] = new ArrayList<Edge>();
 		}
         
         for(int i=0; i<V; i++) {
        	 for(int j=0; j< graph[i].size(); j++) {
        		 Edge e = graph[i].get(j);// e.src --> e.dest--> reverse
        		 transpose[e.dest].add(new Edge(e.dest, e.src));
        	 }
         }
         
         //step3 do DFS
         while(!stack.isEmpty()) {
        	 int curr = stack.pop();
        	 
        	 if(!vis[curr]) {
        	 dfs(transpose, vis, curr);
        	 }
        	 System.out.println();
         }
     }



public static void main(String[] args) {
	
	int V =5;
	ArrayList<Edge> graph[] = new ArrayList[V];
	createGraph(graph);
	kosarajuAlgorithm(graph, V);

}
}
