package com.fabulous.dd;

public class BinaryNode {
	BinaryNode leftChild;
	BinaryNode rightChild;
	int data;
	Boolean visited = false;
	
	public BinaryNode(int data, BinaryNode l, BinaryNode r){
		this.data = data;
		this.leftChild = l;
		this.rightChild = r;
	}
}
