package com.example.Cyclic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.example.Cyclic.*;

public class CyclicDetectionForUndirectedGraph3 {

public static void createGraph(ArrayList<Edge> graph[]) {
		
		for(int i=0; i< graph.length; i++){
			graph[i] = new ArrayList<Edge>();
		}
		
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));
		
		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 2));
		graph[1].add(new Edge(1, 4));
		
		graph[2].add(new Edge(2, 1));
		graph[2].add(new Edge(2, 3));
		
		graph[3].add(new Edge(3, 2));
		
		graph[4].add(new Edge(4, 0));
		graph[4].add(new Edge(4, 1));
		graph[4].add(new Edge(4, 5));
		
		graph[5].add(new Edge(5, 4));
				
	}

public static boolean cyclicDetectionforUndirectedGraph(ArrayList<Edge> graph[], boolean[] vis, int curr, int par) {
	
	vis[curr] = true;
	
	for(int i=0; i< graph[curr].size(); i++) {
		Edge e = graph[curr].get(i);
		if(vis[e.dest] && par != e.dest) {
			return true;
		}
		else if(!vis[e.dest]) {
			if(cyclicDetectionforUndirectedGraph(graph, vis, e.dest, curr)) {
				return true;
			}
		}
		
	}
	return false;
}

public static void main(String[] args) {
	
	int v =6;
	ArrayList<Edge> [] graph = new ArrayList[v];
	createGraph(graph);
	
	boolean res = cyclicDetectionforUndirectedGraph(graph, new boolean[v], 0, -1);
	
	System.out.println(res);
	
}
}
