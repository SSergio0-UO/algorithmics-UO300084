package alglab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import labs.examples.branchandbound.pyramid.utils.Node;

public class NullPathNode extends Node  {

    private static final int MIN_COST = 10;
    private static final int MAX_COST = 99;
    private static final int TOLERANCE = 99;
    private static int[][] costs;

    private List<Integer> path; // current path
    private boolean[] visited; // visited nodes
    private int currentCost;
    private int n;

    // Root node constructor
    public NullPathNode(int n) {
        super();
        this.n = n;
        path = new ArrayList<>();
        visited = new boolean[n];
        currentCost = 0;

        generateCostMatrix(n);

        // Start from node 0
        path.add(0);
        visited[0] = true;
        calculateHeuristicValue();
    }

    // Child node constructor
    private NullPathNode(NullPathNode parent, int nextNode) {
        super();
        this.n = parent.n;
        this.path = new ArrayList<>(parent.path);
        this.visited = Arrays.copyOf(parent.visited, parent.visited.length);
        this.currentCost = parent.currentCost;
        this.parentID = parent.getID();

        int lastNodeOnPath = path.get(path.size() - 1);
        int addedCost = costs[lastNodeOnPath][nextNode];
        this.currentCost += addedCost;

        path.add(nextNode);
        visited[nextNode] = true;

        this.depth = path.size();
        calculateHeuristicValue();
    }

    private void generateCostMatrix(int n) {
        if (costs != null) return; // already generated
        costs = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) { 
                	int value = MIN_COST + rand.nextInt(MAX_COST - MIN_COST + 1);
                	if(rand.nextBoolean()) costs[i][j] = value;
                	else costs[i][j] = - value;
                }
            }
        }
        
//        System.out.println("Generated Cost Matrix:");
//        for (int[] row : costs) {
//            System.out.println(Arrays.toString(row));
//        }
    }

    @Override
    public void calculateHeuristicValue() {
        this.heuristicValue = Math.abs(currentCost);
    }

    @Override
    public ArrayList<Node> expand() {
        ArrayList<Node> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i] ) {
                children.add(new NullPathNode(this, i));
            }
        }
        return children;
    }

    @Override
    public boolean isSolution() {
        return path.size() == n &&
               path.get(0) == 0 &&
               path.get(n - 1) == n - 1 &&
               Math.abs(currentCost) <= TOLERANCE;
    }

    @Override
    public int initialValuePruneLimit() {
        return TOLERANCE + 1;
    }

    @Override
    public String toString() {
        return "Path: " + path + " | Cost: " + currentCost;
    }

}
