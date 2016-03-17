import java.util.ArrayList;


public class BollingerBand implements TradeAlgorithm{
	private ArrayList<TradeSession> tradeSessions;
	private String stock;
	private int lag;
	private float stdDevInterval;
	
	private TradeSession [] trades = new TradeSession[0];
	private float highestHigh = 0, sum_HIGH = 0, avg_HIGH = 0, std_HIGH = 0;
	private float lowestLow = 0, sum_LOW = 0, avg_LOW = 0, std_LOW = 0;
	
	BollingerBand(String stock, ArrayList<TradeSession> tradeSessions, int lag, float stdDevInterval){
		this.stock = stock;
		this.tradeSessions = tradeSessions;
		this.lag = lag;
		this.stdDevInterval = stdDevInterval;
		
	}
	

	@Override
	public void processStatistics() {

		trades = tradeSessions.toArray(trades);
				// new float [count];
		
		int count = trades.length;
		lowestLow = trades[0].getLow();
		
		for(int i = 0 ; i < lag ; i++){
			highestHigh = (highestHigh > trades[i].getHigh() ? highestHigh : trades[i].getHigh());
			lowestLow = (lowestLow < trades[i].getLow() ? lowestLow : trades[i].getLow());
			sum_LOW += trades[i].getLow();
			sum_HIGH += trades[i].getHigh();
		}
		
		avg_LOW = sum_LOW / (float) lag;
		avg_HIGH = sum_HIGH / (float) lag;
		
		
		for(int i = 0; i < lag ; i++){
			std_LOW += Math.pow(trades[i].getLow() - avg_LOW, 2) / lag;
			std_HIGH += Math.pow(trades[i].getHigh() - avg_HIGH, 2) / lag ;
		}
		
		std_LOW = (float) Math.sqrt(std_LOW);
		std_HIGH = (float) Math.sqrt(std_HIGH);

	}


	@Override
	public double getBuyRecommendation() {
		return (float) avg_LOW - ( std_LOW * stdDevInterval);
	}


	@Override
	public double getSellRecommendation() {
		return (float) avg_HIGH + ( std_HIGH * stdDevInterval);
	}


	@Override
	public Trade getTradeRecommendation() {
		if (tradeSessions.get(0).getClose() <= getBuyRecommendation())
			return Trade.BUY;
		else if (tradeSessions.get(0).getClose() >= getSellRecommendation())
			return Trade.SELL;
		return Trade.HOLD;
	}

	
	
	public float getAverage_HIGH(){
		return avg_HIGH;
	}
	
	public float getAverage_LOW(){
		return avg_LOW;
	}
	
	public float getSTD_HIGH(){
		return std_HIGH;
	}
	
	public float getSTD_LOW(){
		return std_LOW;
	}
	


}
