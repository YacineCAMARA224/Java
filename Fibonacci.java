import java.util.concurrent.RecursiveAction;

public class Fibonacci extends RecursiveAction{
	final int threshold=10;
	volatile private int number;
	volatile private long result;
	public Fibonacci(int nb)
	{
		this.number=nb;
	}
	public long get_result()
	{
		return this.result;
	}
	public void compute()
	{
		if(this.number < threshold)
			this.result=this.calculate(this.number);
		else
		{
			final Fibonacci f1=new Fibonacci(this.number-1);
			final Fibonacci f2=new Fibonacci(this.number-2);
			invokeAll(f1, f2);
			this.result=f1.get_result()+f2.get_result();
		}
		
	}
	public long calculate(int n)
	{
		if(n <= 1)
			return n;
		return this.calculate(n-1)+this.calculate(n-2);
	}
}
