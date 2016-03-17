
public abstract class Card {
	private boolean available = true;
	
	protected int faceValue;
	protected Suit suit;
	
	public Card(int c, Suit s){
		faceValue = c;
		suit = s;
	}
	
	public abstract int value();
	
	public Suit suit() {return suit;}
	
	public void markAvailabe(){ available = true;}
}
