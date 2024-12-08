package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//BFS
public class Classroom3 {

	
	public static void createGraph(ArrayList<Edge2> graph[]) {
		
		for(int i=0; i< graph.length; i++){
			graph[i] = new ArrayList<Edge2>();
		}
		
		graph[0].add(new Edge2(0, 1));
		graph[0].add(new Edge2(0, 2));
		
		graph[1].add(new Edge2(1, 0));
		graph[1].add(new Edge2(1, 3));
		
		graph[2].add(new Edge2(2, 0));
		graph[2].add(new Edge2(2, 4));
		
		graph[3].add(new Edge2(3, 1));
		graph[3].add(new Edge2(3, 4));
		graph[3].add(new Edge2(3, 5));
		
		
		graph[4].add(new Edge2(4, 2));
		graph[4].add(new Edge2(4, 3));
		graph[4].add(new Edge2(4, 5));
		
		graph[5].add(new Edge2(5, 3));
		graph[5].add(new Edge2(5, 4));
		graph[5].add(new Edge2(5, 6));
		
		graph[6].add(new Edge2(6, 5));
				
	} 
	
	
	public static void bfs(ArrayList<Edge2> graph[], int v) {
		Queue<Integer> q = new LinkedList<>();
		
		boolean vis [] = new boolean[v];
		q.add(0);
		while(!q.isEmpty()) {
			int curr = q.remove();
			if(vis[curr] == false) {
				System.out.print(curr + " ");
				vis[curr] = true;
				
				for(int i=0; i< graph[curr].size(); i++) {
					Edge2 e = graph[curr].get(i);
					q.add(e.dest);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		int v =7;
		ArrayList<Edge2> graph[] = new ArrayList[v];
		createGraph(graph);
		bfs(graph, v);
		System.out.println();
	}
}

class Edge2{
	int src;
	int dest;
//	int wt;
	
	public Edge2(int src, int dest) {
		this.src = src;
		this.dest = dest;
//		this.wt = wt;
	}
}
