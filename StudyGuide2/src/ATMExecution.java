
public class ATMExecution {
	public static void main(String [] args){
		
		LockedATM atm = new LockedATM();
		System.out.println(atm.deposit(500));
		System.out.println(atm.withdraw(1000));
		// System.out.println(atm.getbalance()) ;
	}
}
