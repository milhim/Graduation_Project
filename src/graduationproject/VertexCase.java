/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduationproject;

import java.util.LinkedList;

/**
 *
 * @author mega-soft
 */
public class VertexCase {

    public int numberOfvertices;
    public boolean undirectedGraph[][];
    public int colorsForVertices[];
    public int ThedeletedVertex;

    public VertexCase(int numberOfvertices) {
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

    public boolean isBipartiteSubgraph(int source, int deletedvertex) {
	  initcoloring();

	  colorsForVertices[source] = 1;

	  LinkedList<Integer> q = new LinkedList<Integer>();
	  q.add(source);
	  while (!q.isEmpty()) {

		int u = q.getFirst();
		q.pop();
		if (u != deletedvertex) {
		    for (int v = 0; v < numberOfvertices; ++v) {
			  if (v != deletedvertex) {
				if (undirectedGraph[u][v] && !isVertexColored(v)) {

				    colorsForVertices[v] = 1 - colorsForVertices[u];
				    q.push(v);
				} else if (undirectedGraph[u][v]
					  && hasTheSameColor(v, u)) {
				    return false;
				}
			  }
		    }
		}
	  }

	  return true;
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

    public boolean isBipartite(int deletedvertex) {
	  initcoloring();

	  for (int i = 0; i < numberOfvertices; i++) {
		if (!isVertexColored(i)) {
		    if (isBipartiteSubgraph(i, deletedvertex) == false) {
			  return false;
		    }
		}
	  }

	  return true;
    }

    public int specialCase() {
	  for (int i = 0; i < numberOfvertices; i++) {
		if (isBipartite(i)) {
		    colorsForVertices[i] = 2;
		    return i;
		}
	  }
	  return -10;
    }
}
