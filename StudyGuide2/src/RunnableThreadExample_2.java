public class RunnableThreadExample_2 implements Runnable{

	
	private int count;
	private int threadID = 0;
	private final int DELAY = 200;
	private static final int THREADS = 5;
	
	RunnableThreadExample_2(int threadID){
		this.threadID = threadID;
	}
	

	
	
	public void linRun(){
		
		int count = 0;
		
		System.out.println("RunnableThread starting." + threadID);
		
		try{
			while (count < 5){
				Thread.sleep(DELAY);
				count++;
				// System.out.println("Thread " + threadID + " finished executing" + Calendar.getInstance());
			}
		}
		catch (InterruptedException exc){
			System.out.println("RunnableThread interrupted."  + threadID);
			
		}
		
		System.out.println("RunnableThreadTerminating."  + threadID);
	}
	
	public void run(){
	
		linRun();
		
	}
	
	public static void main(String[] args){
		
	//	System.out.println( "RUN LINEAR");
//		long execTime_linear = testLinear();
		System.out.println( "RUN PARALLEL");
		long execTime_thread = testThread();

		System.out.println(" Thread Execution time: " + execTime_thread);
	//	System.out.println(" Thread Execution time: " + execTime_linear);
		System.out.println( "--================ END OF CODE ================--");
	}



	private static long testLinear() {
		long start = System.currentTimeMillis();    
		
		for(int i = 1; i <= 10; i++){
			RunnableThreadExample_2 instance = new RunnableThreadExample_2(i);
			instance.linRun();
		}
		
		long elapsedTime = System.currentTimeMillis() - start;
		return elapsedTime;
	}


	private static long testThread() {
		long start = System.currentTimeMillis();    
		
		/* create multiple threads */
		RunnableThreadExample_2 instance = new RunnableThreadExample_2(1);
		for(int i = 1; i <= THREADS; i++){
			
			Thread t = new Thread(instance);
			t.start();
		}
		
		long elapsedTime = System.currentTimeMillis() - start;
		return elapsedTime;

	}
	
	
}
