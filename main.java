import java.util.concurrent.ForkJoinPool;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int proc_number=Runtime.getRuntime().availableProcessors();
		ForkJoinPool f_join_pool=new ForkJoinPool(proc_number);
		Fibonacci fibo=new Fibonacci(45);
		long t_init=System.currentTimeMillis(), t_final=0;
		f_join_pool.invoke(fibo);
		t_final=System.currentTimeMillis();
		System.out.println("Result: "+fibo.get_result()+"\nTime: "+(t_final-t_init));
	}

}
