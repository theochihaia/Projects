import java.util.Date;


public class TradeSession {
private Date marketDate;
private float high;
private float low;
private float open;
private float close;
private int volume;
private float adjClose;

	TradeSession(){

	}

	TradeSession(Date marketDate, float high, float low, float open, float close, int volume, float adjClose){
		this.marketDate = marketDate;
		this.high = high;
		this.low = low;
		this.open = open;
		this.close = close;
		this.volume = volume;
		this.adjClose = adjClose;
	}


	public Date getMarketDate() {
		return marketDate;
	}


	public void setMarketDate(Date marketDate) {
		this.marketDate = marketDate;
	}


	public float getHigh() {
		return high;
	}


	public void setHigh(float high) {
		this.high = high;
	}


	public float getLow() {
		return low;
	}


	public void setLow(float low) {
		this.low = low;
	}


	public float getOpen() {
		return open;
	}


	public void setOpen(float open) {
		this.open = open;
	}


	public float getClose() {
		return close;
	}


	public void setClose(float close) {
		this.close = close;
	}


	public int getVolume() {
		return volume;
	}


	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public float getAdjClose() {
		return adjClose;
	}

	public void setAdjClose(float adjClose) {
		this.adjClose = adjClose;
	}

	public String toString(){
		return ""
				+ "Date: " + getMarketDate().toString() + "\n"
				+ "High: " + getHigh() + "\n"
				+ "Low: " + getLow() + "\n"
				+ "Open: " + getOpen() + "\n"
				+ "Close: " + getClose() + "\n"
				+ "Volume: " + getVolume() + "\n"
				+ "";
		
		
	}
	
}
