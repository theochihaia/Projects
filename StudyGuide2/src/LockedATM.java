import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LockedATM implements Runnable {
	private Lock lock;
	private int balance = 100;
	
	public LockedATM(){
		lock = new ReentrantLock();
	}
	
	public int withdraw(int value) {
	//	lock.lock();
		int temp = balance;
		
		try{
			Thread.sleep(100);
			temp = temp - value;
			Thread.sleep(900);
			balance = temp;
		}catch (InterruptedException e){
			
		}
		
	//	lock.unlock();
		return temp;
	}
	
	public int deposit (int value){
		// lock.lock();
		int temp = balance;
		try{
			Thread.sleep(100);
			temp = temp + value;
			Thread.sleep(300);
			balance = temp;
			
		}catch (InterruptedException e){
			
		}
	// 	lock.unlock();
		return temp;
	}

	@Override
	public void run() {
		System.out.println(deposit(500));
		System.out.println(withdraw(1000));
	}

	
}
