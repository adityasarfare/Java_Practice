package com.example.HuffManCoding;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffManCoder {

	HashMap<Character, String> encoder;
	HashMap<String, Character> decoder;
	
	private class Node implements Comparable<Node>{
		Character data;
		int cost;
		Node left;
		Node right;
		
		public Node(Character data, int cost) {
			this.data = data;
			this.cost = cost;
			this.left = null;
			this.right = null;
		}
		@Override
		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
	} 
	
	public HuffManCoder(String feeder) throws Exception{
		HashMap<Character, Integer> fmap = new HashMap<>();
		
		for(int i =0; i< feeder.length(); i++) {
		     char cc = feeder.charAt(i);
		     fmap.put(cc, fmap.getOrDefault(cc, 0)+1);
		}
		
		Heap<Node> minHeap = new Heap<>();
		Set<Map.Entry<Character, Integer>> entrySet = fmap.entrySet();
		for(Map.Entry<Character, Integer> entry : entrySet) {
		Node node = new Node(entry.getKey(), entry.getValue());
		minHeap.insert(node);
		}
		
		while(minHeap.size() != 1) {
			Node first = minHeap.remove();
			Node second = minHeap.remove();
			
			Node newNode = new Node('\0', first.cost + second.cost);
			newNode.left = first;
			newNode.right = second;
			
			minHeap.insert(newNode);
		}
		
		Node ft = minHeap.remove();
		
		this.encoder = new HashMap<>();
		this.decoder = new HashMap<>();
		
		this.initEncoderDecoder(ft, "");
	}
	
	private void initEncoderDecoder(Node node, String osf) {
		if(node == null) {
			return;
		}
		
		if(node.left == null & node.right == null) {
			this.encoder.put(node.data, osf);
			this.decoder.put(osf, node.data);
		}
		initEncoderDecoder(node.left, osf+"0");
		initEncoderDecoder(node.right, osf+"1");
		
	}
	
	public String encode(String source) {
		String ans = "";
		for(int i=0; i< source.length(); i++) {
			ans = ans + encoder.get(source.charAt(i));
		}
		return  ans;
	}
	
    public String decode(String codedSource) {
		String key ="";
		String res ="";
		for(int i=0; i< codedSource.length(); i++) {
            key = key + codedSource.charAt(i);
            if(decoder.containsKey(key)) {
            	res = res + decoder.get(key);
            	key="";
            }
		}
		return res;
	}
	
	public static void main(String[] args) throws Exception{
		String val = "abbcda";
		HuffManCoder hf = new HuffManCoder(val);
		String cs = hf.encode(val);
		System.out.println(cs);
		String dc = hf.decode(cs);
		System.out.println(dc);
	}
}
