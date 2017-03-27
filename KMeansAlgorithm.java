import java.util.ArrayList;


public class KMeansAlgorithm {

	public static void main(String[] args) {
		
		// String filePath ="....";
		// int seed = 10;
		// int k = 2;

		int seed = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		String filePath = args[2];

		KMeans km = new KMeansStudent(filePath , seed , k);
		km.setDetails();
		ArrayList<ArrayList<Integer>> kmList = km.runKMeans();
		km.clusterCount();
	}

}
