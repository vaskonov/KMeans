import java.util.ArrayList;


public class KMeans {
	
	private String id , fullName , filePath;
	private String id2 , fullName2;
	private int seed, k;
    
	public KMeans(String filePath, int seed, int k) {

		this.filePath = filePath;
		this.seed = seed;
		this.k = k;
	}
	
	public ArrayList<ArrayList<Integer>> runKMeans(){
		return null;
	}
	
	public Integer[] clusterCount(){
		return null;
	}

	public void setDetails() {
		
	}

    
    public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public double getSeed() {
		return seed;
	}


	public double getK() {
		return k;
	}


	public String getFilePath() {
		return filePath;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getFullName2() {
		return fullName2;
	}

	public void setFullName2(String fullName2) {
		this.fullName2 = fullName2;
	}


}
