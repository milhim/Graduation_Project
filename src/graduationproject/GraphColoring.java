package graduationproject;

public class GraphColoring {

    int[][] graph;
    int[] colorVector;
    int m;

    public GraphColoring(int size) {
	  graph = new int[size][size];
	  for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
		    graph[i][j] = 0;
		}
	  }
	  colorVector = new int[size];
	  for (int i = 0; i < colorVector.length; i++) {
		colorVector[i] = -1;
	  }
    }

    public void setGraph(int[][] graph) {
	  this.graph = graph;
    }

    public GraphColoring(int[][] graph, int[] colorVector) {
	  this.graph = graph;
	  this.colorVector = colorVector;
	  for (int i = 0; i < colorVector.length; i++) {
		colorVector[i] = -1;
	  }
    }

    //check if adj vertex is valid or not
    public boolean isValid(int v) {

	  //     boolean valid = true;
	  for (int i = 0; i < v; i++) {

		if (graph[v][i] == 1 && colorVector[v] == colorVector[i]) {
		    return false;

		}

	  }
	  //   System.out.println(valid);
	  return true;
    }

    public void addedge(int i, int j) {
	  graph[i][j] = 1;
	  graph[j][i] = 1;
    }

    public void setm(int l) {
	  m = l;
    }

    // coloring function
    public void mColoring(int surce) {
	  //int initColor = 0;
	  // colorVector[0] = initColor;
	  if (isValid(surce)) {
		if (surce == (graph.length - 1)) {
		    for (int i = 0; i < colorVector.length; i++) {
			  System.out.println("color of vertex " + i + " is " + colorVector[i]);
		    }
		    System.out.println("----------------------");

		} else {
		    for (int color = 1; color <= m; color++) {
			  colorVector[surce + 1] = color;
			  mColoring(surce + 1);
		    }
		}
	  }
    }

    public static void main(String[] args) {
	  int[][] myGraph
		    = {
			  {0, 1, 1, 1},
			  {1, 0, 0, 1},
			  {1, 0, 0, 1},
			  {1, 1, 1, 0}
		    };
	  GraphColoring gg = new GraphColoring(4);
	  gg.addedge(0, 1);
	  gg.addedge(0, 2);
	  gg.addedge(0, 3);
	  gg.addedge(1, 3);
	  gg.addedge(2, 3);
	  int[] cVector = new int[4];
	  GraphColoring g = new GraphColoring(myGraph, cVector);
	  //setting the number of colors
	  gg.setm(3);
	  gg.mColoring(-1);

    }

}
