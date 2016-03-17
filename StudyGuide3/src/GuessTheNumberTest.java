import static org.junit.Assert.*;

import org.junit.Test;


public class GuessTheNumberTest {

	
    private GuessTheNumber guesser;

    protected void setUp() throws Exception
    {
    	guesser = new GuessTheNumber(); 
    }
	
	@Test
	public void test_small() {
		String[] test = {"948","Higher","Lower","Yay!"};
		assertEquals(593,guesser.guess(test));
	}
	
	@Test
	public void test_medium() {
		String[] test = {"948","Higher","Lower","Higher","Yay!"};
		assertEquals(652,guesser.guess(test));
	}
	
	
	@Test
	public void test_large() {
		String[] test = {"100","Lower","Lower","Higher","Lower","Lower","Lower","Yay!"};
		assertEquals(13,guesser.guess(test));
	}

}
