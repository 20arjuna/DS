
public class RecursionEngine 
{
	public double sumGeometricSeries(int n, int r)
	{
		if(n == 0)
		{
			return 1;
		}
		return Math.pow(n,r) + sumGeometricSeries(n-1, r);
	}
	
}
