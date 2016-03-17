import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class CashRegisterTest {
    
    private CashRegister reg;

    protected void setUp() throws Exception
    {
       
        reg = new CashRegister();
        
 
    }
    

	@Test
	public void TestEqual_Large() {
			BigDecimal cost = new BigDecimal(100.32);
			BigDecimal paid = new BigDecimal(100.32);
			String solution = "ZERO";
			assertEquals(solution, CashRegister.getCoinText(cost, paid));
	}
	
	@Test
	public void TestEqual_small() {
			BigDecimal cost = new BigDecimal(.07);
			BigDecimal paid = new BigDecimal(.07);
			String solution = "ZERO";
			assertEquals(solution, CashRegister.getCoinText(cost, paid));
	}
	
	@Test
	public void TestNegative() {
		BigDecimal cost = new BigDecimal(150.05);
		BigDecimal paid = new BigDecimal(100.23);
		String solution = "ERROR";
		assertEquals(solution, CashRegister.getCoinText(cost, paid));
	}
	
	@Test
	public void TestValue_1() {
		BigDecimal cost = new BigDecimal(.37);
		BigDecimal paid = new BigDecimal(.50);
		String solution = "DIME,PENNY,PENNY,PENNY";
		String output = CashRegister.getCoinText(cost, paid);
		assertEquals(solution, output);
	}

	@Test
	public void TestValue_2() {
		BigDecimal cost = new BigDecimal(1);
		BigDecimal paid = new BigDecimal(2);
		String solution = "ONE";
		String output = reg.getCoinText(cost, paid);
		assertEquals(solution, output);
	}

}
