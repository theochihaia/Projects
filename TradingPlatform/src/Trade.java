
public enum Trade {
	BUY(1),SELL(-1),HOLD(0);
	
	int value;
	Trade(int value){
		this.value = value;
	}
}
