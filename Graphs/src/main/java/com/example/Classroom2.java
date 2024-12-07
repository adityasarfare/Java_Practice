package com.example;

import java.util.ArrayList;

public class Classroom2 {

	
	public static void createGraph(ArrayList<Edge1> graph[]) {
		
		for(int i=0; i< graph.length; i++){
			graph[i] = new ArrayList<Edge1>();
		}
		
		graph[0].add(new Edge1(0, 2, 2));
		
		graph[1].add(new Edge1(1, 2, 10));
		graph[1].add(new Edge1(1, 3, 0));
		
		graph[2].add(new Edge1(2, 0, 2));
		graph[2].add(new Edge1(2, 1, 10));
		graph[2].add(new Edge1(2, 3, -1));
		
		graph[3].add(new Edge1(3, 1, 0));
		graph[3].add(new Edge1(3, 2, -1));
		
		
	} 
	
	public static void main(String[] args) {
		
		int v =4;
		ArrayList<Edge1> graph[] = new ArrayList[v];
		
		createGraph(graph);
		
		for(int i =0; i< graph[2].size(); i++) {
			Edge1 e = graph[2].get(i);
			System.out.println(e.dest + ":" + e.wt);
		}
	}
}

class Edge1{
	int src;
	int dest;
	int wt;
	
	public Edge1(int src, int dest, int wt) {
		this.src = src;
		this.dest = dest;
		this.wt = wt;
	}
}
