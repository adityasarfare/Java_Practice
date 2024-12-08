package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//DFS
// For DFS i have included disconnected component in Same class
public class AllPaths6 {

	public static void createGraph(ArrayList<Edge5> graph[]) {

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge5>();
		}

		graph[0].add(new Edge5(0, 1));
		graph[0].add(new Edge5(0, 2));

		graph[1].add(new Edge5(1, 0));
		graph[1].add(new Edge5(1, 3));

		graph[2].add(new Edge5(2, 0));
		graph[2].add(new Edge5(2, 4));

		graph[3].add(new Edge5(3, 1));
		graph[3].add(new Edge5(3, 4));
		graph[3].add(new Edge5(3, 5));

		graph[4].add(new Edge5(4, 2));
		graph[4].add(new Edge5(4, 3));
		graph[4].add(new Edge5(4, 5));

		graph[5].add(new Edge5(5, 3));
		graph[5].add(new Edge5(5, 4));
		graph[5].add(new Edge5(5, 6));

		graph[6].add(new Edge5(6, 5));
	}

	public static void dfs(ArrayList<Edge5> graph[], int curr, boolean vis[]) {
		System.out.print(curr + " ");
		vis[curr] = true;

		for (int i = 0; i < graph[curr].size(); i++) {
			Edge5 e = graph[curr].get(i);
			if (vis[e.dest] == false) {
				dfs(graph, e.dest, vis);
			}
		}
	}

	public static void printAllPaths(ArrayList<Edge5> graph[], boolean vis[], int curr, String path, int target) {
		if (curr == target) {
			System.out.println(path);
			return;
		}

		for (int i = 0; i < graph[curr].size(); i++) {
			Edge5 e = graph[curr].get(i);
			if (!vis[e.dest]) {
				vis[curr] = true;
				printAllPaths(graph, vis, e.dest, path + e.dest, target);
				vis[curr] = false;
			}
		}
	}

	public static void main(String[] args) {

		int v = 7;
		ArrayList<Edge5> graph[] = new ArrayList[v];
		createGraph(graph);

		int src = 0, tar = 5;
		printAllPaths(graph, new boolean[v], src, "0", tar);

	}
}

class Edge5 {
	int src;
	int dest;
//	int wt;

	public Edge5(int src, int dest) {
		this.src = src;
		this.dest = dest;
//		this.wt = wt;
	}
}
