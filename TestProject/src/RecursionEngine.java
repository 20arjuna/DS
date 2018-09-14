
public class RecursionEngine 
{
	public double sumGeometricSeries(int n, int r)
	{
		if(n == 0)
		{
			return 0;
		}
		return Math.pow(r, n-1) + this.sumGeometricSeries(n-1, r);
	}
	
}
