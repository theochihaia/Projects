import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class TradeRecommendation extends Thread {
private ArrayList<TradeSession> tradeSessions;

private int lag;
private float stdDevInterval;

public String stock;

private BollingerBand bollinger;

float highestHigh;
float lowestLow;

ArrayList<TradeAlgorithm> tradeAlgorithms;

	TradeRecommendation(String stock, ArrayList<TradeSession> tradeSessions, int lag, float stdDevInterval){
		this.tradeSessions = tradeSessions;		
		this.lag = lag;
		this.stdDevInterval = stdDevInterval;
		this.stock = stock;
		
		tradeAlgorithms = new ArrayList<TradeAlgorithm>();

	}


	public void processStatistics() {
		bollinger = new BollingerBand(stock, tradeSessions, lag, stdDevInterval);
		bollinger.processStatistics();
		
		tradeAlgorithms.add(bollinger);
	}


	// TODO
	public float getBuyRecommendation(){
		double sum = 0;
		for(TradeAlgorithm alg : tradeAlgorithms){
			sum = sum + alg.getBuyRecommendation();
		}
		
		return (float) sum / tradeAlgorithms.size();
	}
	
	// TODO
	public float getSellRecommendation(){
		double sum = 0;
		for(TradeAlgorithm alg : tradeAlgorithms){
			sum = sum + alg.getSellRecommendation();
		}
		
		return (float) sum / tradeAlgorithms.size();
	}
	

	public Date getTradeDate(){
		return tradeSessions.get(0).getMarketDate();
	}
	
	public Trade getTradeRecommendation(){
		double sum = 0;
		
		for(TradeAlgorithm alg : tradeAlgorithms){
			sum = sum + alg.getTradeRecommendation().value;
		}
		
		double recNum = (double) sum / tradeAlgorithms.size();
		
		if(recNum >= .5)
			return Trade.BUY;
		else if(recNum <= -.5)
			return Trade.SELL;
		else
			return Trade.HOLD;
	}
	
	public float getProfitPotential(float investmentAmount){
		int shares = (int) ((int) investmentAmount / getBuyRecommendation());
		return (shares * getSellRecommendation()) - (shares * getBuyRecommendation());
	}
	
	public float getTheoreticalReturn(){
		return 100 * ( getSellRecommendation() - getBuyRecommendation() ) / getBuyRecommendation();
	}


	
	public double getCurrentPrice(){
		return tradeSessions.get(0).getClose();
	}


}