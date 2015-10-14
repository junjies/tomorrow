package com.fabulous.dd;

public class FindAncesterNew {
	BinaryNode node;
	Boolean isAncester;
	
	public FindAncesterNew(BinaryNode n, Boolean v){
		this.node = n;
		this.isAncester = v;
	}
	
	public static FindAncesterNew ancesterFinder(BinaryNode root, BinaryNode m, BinaryNode n){
		if(root == null){
			return new FindAncesterNew(null, false);
		}
		
		if(root == m && root == n){
			return new FindAncesterNew(root, true);
		}
		
		FindAncesterNew lres = ancesterFinder(root.leftChild, m, n);
		if(lres.isAncester){
			return lres;
		}
		
		FindAncesterNew rres = ancesterFinder(root.rightChild, m, n);
		if(rres.isAncester){
			return rres;
		}
		
		if(lres.node != null && rres.node != null){
			return new FindAncesterNew(root, true);
		}else if(root == m || root == n){
			if(lres.node != null || rres.node != null){
				return new FindAncesterNew(root, true);
			}else{
				return new FindAncesterNew(root, false);
			}
		}else{
			return new FindAncesterNew(lres.node != null? lres.node:rres.node, false);
		}	
		
	}
	
	public static BinaryNode checkAncester(BinaryNode root, BinaryNode p, BinaryNode q){
		FindAncesterNew result = ancesterFinder(root, p, q);
		if(result.isAncester){
			return result.node;
		}
		return null;
	}
	
	
	
	public static void main(String[] args){
		BinaryNode n11 = new BinaryNode(11, null, null);
		BinaryNode n10 = new BinaryNode(10, null, null);
		BinaryNode n9 = new BinaryNode(9, null, null);
		BinaryNode n8 = new BinaryNode(8, null, null);
		BinaryNode n7 = new BinaryNode(7, null, null);
		BinaryNode n6 = new BinaryNode(6, null, null);
		BinaryNode n5 = new BinaryNode(5, n8, n9);
		BinaryNode n4 = new BinaryNode(4, n6, n7);
		BinaryNode n3 = new BinaryNode(3, n10, n11);
		BinaryNode n2 = new BinaryNode(2, n4, n5);
		BinaryNode n1 = new BinaryNode(1, n2, n3);
		
		BinaryNode n12 = new BinaryNode(12, null, null);
		BinaryNode n13 = new BinaryNode(13, null, null);
		
		
		//FindAncesterNew fan = new FindAncesterNew();
		
		//System.out.println(fca.findAncestor(null,n1,n2).data);
		System.out.println(checkAncester(n1, n4,n4).data);	
		System.out.println(checkAncester(n1, n6,n7).data);
		System.out.println(checkAncester(n1, n9,n8).data);
		System.out.println(checkAncester(n1, n6,n9).data);
		System.out.println(checkAncester(n1, n1, n2).data);
		System.out.println(checkAncester(n1, n7,n9).data);
//		System.out.println(checkAncester(n1, n12,n10).data); //n12 is not in the tree

	}
	
}
