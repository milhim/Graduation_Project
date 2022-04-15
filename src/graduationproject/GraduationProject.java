package graduationproject;

public class GraduationProject {

    public static void main(String[] args) {

	  VertexCase v = new VertexCase(6);
	  v.addedge(0, 3);
	  v.addedge(0, 5);
	  v.addedge(1, 3);
	  v.addedge(1, 4);
	  v.addedge(2, 5);
	  v.addedge(2, 4);
	  v.addedge(2, 3);
	  v.addedge(3, 4);
	  	  v.addedge(0, 1);

	  int x = v.specialCase();
	  if (x == -10) {
		System.out.println("No Bipartite");
	  } else {
		System.out.println("Yes " + x);

	  }
	  
    }

}
