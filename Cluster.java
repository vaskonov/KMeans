import java.util.ArrayList;

public class Cluster 
{
	ArrayList<Float> center = new ArrayList <Float> ();
	ArrayList<Point> dataset = new ArrayList <Point> ();
	
	public Cluster (ArrayList<Float> center)
	{
		this.center = (ArrayList<Float>) center.clone();
	}
	
	public float Distance(ArrayList<Float> point)
	{
		float distance = 0;

		for (int i=0;i<point.size();i++)
		{
			distance = distance + (center.get(i)-point.get(i))*(center.get(i)-point.get(i));
		}
		return distance;	
	}
	
	public ArrayList<Integer> Indexes()
	{
		ArrayList<Integer> Indexes = new ArrayList<Integer>();
	
		for (int i=0; i<dataset.size(); i++)
		{
			Indexes.add(dataset.get(i).id);
		}
		
		return Indexes;
	}
	
	public boolean addPoint(Point point)
	{
		return dataset.add(point);
		
	}

	public boolean updateCenter()
	{
		ArrayList<Float> newCenter=new ArrayList<Float> (center.size());

		ArrayList<Float> finalCenter=new ArrayList<Float> (center.size());

		for (int i=0;i<center.size();i++)

			newCenter.add(i,new Float(0));
		
		if (dataset.size() == 0)
			return true;
		
		for (int i=0;i<dataset.size();i++)
		{
			newCenter=sumVectors(newCenter, dataset.get(i).vector);
		}
		for (int i=0;i<center.size();i++)
		{
			finalCenter.add(i,newCenter.get(i)/ dataset.size());
		}
		
		this.center = finalCenter;

		this.dataset= new ArrayList <Point> ();

		return true;
	}
	
	public ArrayList<Float> sumVectors(ArrayList<Float> a, ArrayList<Float> b)
	{
		ArrayList<Float> c=new ArrayList<Float> ();
		
		for (int i=0; i<a.size();i++)

			c.add(i, a.get(i)+b.get(i));

		return c;
	}
	
	

}
