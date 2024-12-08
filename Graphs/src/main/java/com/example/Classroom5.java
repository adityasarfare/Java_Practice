package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//DFS
// For DFS i have included disconnected component in Same class
public class Classroom5 {

	
	public static void createGraph(ArrayList<Edge4> graph[]) {
		
		for(int i=0; i< graph.length; i++){
			graph[i] = new ArrayList<Edge4>();
		}
		
		graph[0].add(new Edge4(0, 1));
		graph[0].add(new Edge4(0, 2));
		
		graph[1].add(new Edge4(1, 0));
		graph[1].add(new Edge4(1, 3));
		
		graph[2].add(new Edge4(2, 0));
		graph[2].add(new Edge4(2, 4));
		
		graph[3].add(new Edge4(3, 1));
		graph[3].add(new Edge4(3, 4));
		graph[3].add(new Edge4(3, 5));
		
		
		graph[4].add(new Edge4(4, 2));
		graph[4].add(new Edge4(4, 3));
		graph[4].add(new Edge4(4, 5));
		
		graph[5].add(new Edge4(5, 3));
		graph[5].add(new Edge4(5, 4));
		graph[5].add(new Edge4(5, 6));
		
		graph[6].add(new Edge4(6, 5));
				
	} 
	
	
	public static void dfs(ArrayList<Edge4> graph[], int curr, boolean vis[]) {
		System.out.print(curr + " ");
		vis[curr] = true;
		
		for(int i =0; i< graph[curr].size(); i++) {
		Edge4 e = graph[curr].get(i);
		if(vis[e.dest] == false) {
	       dfs(graph, e.dest, vis);
		}
		}
		
	}
	
	public static void main(String[] args) {
		
		int v =7;
		ArrayList<Edge4> graph[] = new ArrayList[v];
		createGraph(graph);
		
		boolean vis [] = new boolean[v];
		
		for(int i =0; i< v; i++) {
			if(vis[i] == false) {
				dfs(graph, i, vis);
			}
		}
		
		System.out.println();
	}
}

class Edge4{
	int src;
	int dest;
//	int wt;
	
	public Edge4(int src, int dest) {
		this.src = src;
		this.dest = dest;
//		this.wt = wt;
	}
}
