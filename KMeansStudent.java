import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class KMeansStudent extends KMeans 
{
	ArrayList<Point> points;
	
	public KMeansStudent(String filePath,int seed , int k)
	{
		super(filePath,seed , k);
 
		try 
		{
			points = LoadPoints(filePath);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	
	}
	
	public void setDetails()
    {
		setId("");
		setFullName("");
		setId2("");
		setFullName2("");
    }
    
    public ArrayList<Point> LoadPoints(String path) throws IOException
	{
		ArrayList<Point> points = new ArrayList <Point> ();
		BufferedReader br = new BufferedReader(new FileReader(path));
		int index=0;

		try 
		{
			String line = br.readLine();

			while (line != null) 
			{
				Point point = new Point (index, line.split("\\s+"));

				points.add(index,point);

				line = br.readLine();

				index++;
			}
		} 
		finally {

			br.close();
		}	

		return points;
	}

	public ArrayList<ArrayList<Integer>> runKMeans()
	{
		int myseed = (int) getSeed();

	 	int myk =(int) getK();

	 	int iterations = 500;

	 	ArrayList<Cluster> clusters = new ArrayList<Cluster> ();
		 
	 	ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		 	 
		for (int i=myseed;i<myseed+myk;i++)
		{
			clusters.add(new Cluster(points.get(i).vector));
		}
	 
		for (int i=0; i<iterations; i++)
		{
			
			Clusters_AssignPoints(clusters);

			Clusters_AssignCenter(clusters);
			 
		}
		
		Clusters_AssignPoints(clusters);
		
		for (int i=0; i<clusters.size(); i++)
		{
			output.add(clusters.get(i).Indexes());
		}
		
		// System.out.println(output);	
		
		return output;
	}

	public Integer[] clusterCount()
	{
		ArrayList<ArrayList<Integer>> clusters=runKMeans();

		Integer clustersize [] = new Integer[clusters.size()];

		for (int i=0 ; i < clusters.size() ; i++)
		{
			clustersize[i] = clusters.get(i).size();
		}

		for (int i=0 ; i < clusters.size() ; i++)
		{
		 	System.out.println(clustersize[i]);
		}
		 
		return clustersize;
	}
	 
	public boolean Clusters_AssignPoints(ArrayList<Cluster> clusters)
	{
	for (int i=0; i<points.size(); i++)
		{
		int closestCluster = 0;
			
		Float closestDistance = new Float(Float.MAX_VALUE);
					 
		for (int j=0; j<clusters.size(); j++)
			{
				
			Float currentDistance = clusters.get(j).Distance(points.get(i).vector);
			
			if (currentDistance < closestDistance)
				{
				
				closestDistance = new Float(currentDistance);

				closestCluster = j;
				
				}
			}
			clusters.get(closestCluster).addPoint(points.get(i));
				 
		}

	return true;
	}

	public boolean Clusters_AssignCenter(ArrayList<Cluster> clusters)
	{
		for (int j=0; j<clusters.size(); j++)
		{
		 	clusters.get(j).updateCenter();
		}
		return true;
	}
}
