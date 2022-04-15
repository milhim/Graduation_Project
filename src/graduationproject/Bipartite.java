package graduationproject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

class Bipartite {

    public int numberOfvertices;
    public boolean undirectedGraph[][];
    public int colorsForVertices[];
    public int ThedeletedVertex;

    public Bipartite(int numberOfvertices) {
	  this.numberOfvertices = numberOfvertices;
	  undirectedGraph = new boolean[this.numberOfvertices][this.numberOfvertices];
	  colorsForVertices = new int[this.numberOfvertices];
    }

    public void addedge(int i, int j) {
	  undirectedGraph[i][j] = true;
	  undirectedGraph[j][i] = true;
    }

    public void initcoloring() {
	  for (int i = 0; i < numberOfvertices; i++) {
		colorsForVertices[i] = -100;
	  }
    }

    public boolean hasTheSameColor(int i, int j) {
	  if (colorsForVertices[i] == colorsForVertices[j]) {
		return true;
	  }
	  return false;
    }

    public int getColoringVertex(int i) {
	  return colorsForVertices[i];
    }

    private boolean isVertexColored(int i) {
	  if (colorsForVertices[i] == -100) {
		return false;
	  }
	  return true;
    }

    public boolean isBipartiteSubgraph(int source) {
	  initcoloring();

	  colorsForVertices[source] = 1;

	  LinkedList<Integer> q = new LinkedList<Integer>();
	  q.add(source);
	  while (!q.isEmpty()) {
		int u = q.getFirst();
		q.pop();
		for (int v = 0; v < numberOfvertices; ++v) {
		    if (undirectedGraph[u][v] && !isVertexColored(v)) {
			  colorsForVertices[v] = 1 - colorsForVertices[u];
			  q.push(v);
		    } else if (undirectedGraph[u][v]
				&& hasTheSameColor(v, u)) {
			  return false;
		    }
		}
	  }

	  return true;
    }

    public boolean isBipartite() {
	  initcoloring();
	  for (int i = 0; i < numberOfvertices; i++) {
		if (!isVertexColored(i)) {
		    if (isBipartiteSubgraph(i) == false) {
			  return false;
		    }
		}
	  }

	  return true;
    }

    public boolean[][] creatBipartite(int size) {
	  Random r = new Random();
	  int n = size / 2;

	  int firstIndepentedSetSize, secondIndepentedSetSize;
	  if (size % 2 == 0) {
		firstIndepentedSetSize = n;
		secondIndepentedSetSize = n;
	  } else {
		firstIndepentedSetSize = n;
		secondIndepentedSetSize = n + 1;
	  }
	  ArrayList<Integer> firstIndepentedSet = new ArrayList<>();
	  ArrayList<Integer> secondIndepentedSet = new ArrayList<>();
	  for (int i = 0; i < firstIndepentedSetSize; i++) {

		int x = r.nextInt(size);
		while (firstIndepentedSet.contains(x)) {
		    x = r.nextInt(size);
		}
//		System.out.print(x + " ");
		firstIndepentedSet.add(x);
	  }
	  System.out.println("");
	  for (int i = 0; i < secondIndepentedSetSize; i++) {
		int x = r.nextInt(size);
		while (firstIndepentedSet.contains(x) || secondIndepentedSet.contains(x)) {
		    x = r.nextInt(size);
		}
//		System.out.print(x + " ");

		secondIndepentedSet.add(x);
	  }
	  System.out.println("");

	  boolean[][] g = new boolean[size][size];
	  for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
		    g[i][j] = false;
		}
	  }
	  for (int x : firstIndepentedSet) {
		for (int y : secondIndepentedSet) {
		    g[x][y] = true;
		    g[y][x] = true;
		}
	  }
	  return g;
    }

}
