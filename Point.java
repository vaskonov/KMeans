import java.util.ArrayList;

public class Point 
{
	int id = 0;
	
	ArrayList<Float> vector= new ArrayList <Float> ();
	
	Point (int id, String [] vec)
	{
		this.id = id;

		for (int i=1;i<vec.length;++i)
		{
			vector.add(Float.parseFloat(vec[i]));
		}
	}
}
