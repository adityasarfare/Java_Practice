package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//BFS with disconnected component
public class Classroom4 {

	
	public static void createGraph(ArrayList<Edge3> graph[]) {
		
		for(int i=0; i< graph.length; i++){
			graph[i] = new ArrayList<Edge3>();
		}
		
		graph[0].add(new Edge3(0, 1));
		graph[0].add(new Edge3(0, 2));
		
		graph[1].add(new Edge3(1, 0));
		graph[1].add(new Edge3(1, 3));
		
		graph[2].add(new Edge3(2, 0));
		graph[2].add(new Edge3(2, 4));
		
		graph[3].add(new Edge3(3, 1));
		graph[3].add(new Edge3(3, 4));
		graph[3].add(new Edge3(3, 5));
		
		
		graph[4].add(new Edge3(4, 2));
		graph[4].add(new Edge3(4, 3));
		graph[4].add(new Edge3(4, 5));
		
		graph[5].add(new Edge3(5, 3));
		graph[5].add(new Edge3(5, 4));
		graph[5].add(new Edge3(5, 6));
		
		graph[6].add(new Edge3(6, 5));
				
	} 
	
	
	public static void bfs(ArrayList<Edge3> graph[], int v, boolean vis [], int start ) {
		Queue<Integer> q = new LinkedList<>();
		
		
		q.add(start);
		while(!q.isEmpty()) {
			int curr = q.remove();
			if(vis[curr] == false) {
				System.out.print(curr + " ");
				vis[curr] = true;
				
				for(int i=0; i< graph[curr].size(); i++) {
					Edge3 e = graph[curr].get(i);
					q.add(e.dest);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		int v =7;
		ArrayList<Edge3> graph[] = new ArrayList[v];
		createGraph(graph);
		
		boolean vis [] = new boolean[v];
		
		for(int i =0; i< v; i++) {
			if(vis[i] == false) {
				bfs(graph, v, vis, i);
			}
		}
		
		System.out.println();
	}
}

class Edge3{
	int src;
	int dest;
//	int wt;
	
	public Edge3(int src, int dest) {
		this.src = src;
		this.dest = dest;
//		this.wt = wt;
	}
}
