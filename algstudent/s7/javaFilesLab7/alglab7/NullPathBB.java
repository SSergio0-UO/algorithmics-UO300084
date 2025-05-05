package alglab7;

import labs.examples.branchandbound.pyramid.utils.BranchAndBound;

public class NullPathBB extends BranchAndBound {
	private int n;
	private NullPathNode root;
	private BranchAndBound bnB;
	
	public static void main(String[] args) {
		NullPathBB npbb = new NullPathBB(5);
	}
	public  NullPathBB(int n) {
		super();
		this.n = n;
		root = new NullPathNode(n);
		this.rootNode = root;
		bnB = new BranchAndBound();
		bnB.branchAndBound(root);
		bnB.printSolutionTrace();
	}
}