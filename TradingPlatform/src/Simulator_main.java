import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


public class Simulator_main {

	public static void main(String [] args){
		
		try{
			final String div = " ============== ";
			final int lag = 20;
			boolean showAll = true;
			String filename = "output/rec.csv";
			// final float stdDevInterval = (float) 1.5;
			final float stdDevInterval = (float) 3.5;
			final float investmentAmount = 2000;
			HashMap<Stock,ArrayList<TradeSession>> mkt = new HashMap<Stock,ArrayList<TradeSession>>();
			HashMap<Stock,ArrayList<TradeSession>> recommendation = new HashMap<Stock,ArrayList<TradeSession>>();
			DecimalFormat dFormat = new DecimalFormat( "#,###,###,##0.00" );
			final boolean displayDetail = false;
			// Initialize File Output
			File file = new File(filename);
			FileWriter fw = new FileWriter(file);
			fw.write("Date,Symbol,Trade Recommendation,Current Price,Buy Price,Sell Price,Theoretical Return,Profit Potential ($"+ investmentAmount + ")\n");
			
			
			System.out.println("Starting Data Pull");
			System.out.println("Investment Amount " + investmentAmount + "\n");
			
			// Generate output per Stock
			for (Stock s : Stock.values()) {
				// System.out.println("==============================================="); 
				System.out.print("Historical Return :" + s.name());
				
				/* 
				 * Retrieve data for stock
				 */
				DataRetriever data = new DataRetriever(s.toString());
				mkt.put(s, data.getTradingSession());
				// System.out.println("Data Received for " + s.toString());
				
				
				/*
				 * Process Trade Recommendation
				 */
				int count = data.getTradingSession().size();
				
				ArrayList<TradeRecommendation> actualTrades = new ArrayList<TradeRecommendation>();
				
				
				/*
				 * TODO: The trade data should be in a hashmap to facilitate lookup.
				 * 		Trade simulator needs to be able to pick up date range of a year.
				 * 		It also needs to sum the results and calculate gains for the specified time period.
				 * 
				 */
				
				for(int i = count-1; i > lag; i--){
					ArrayList<TradeSession> sublist = new ArrayList<TradeSession>(data.getTradingSession().subList(i - lag, i));
					TradeRecommendation rec = new TradeRecommendation(sublist, lag, stdDevInterval);
					
					Trade prevTrade = actualTrades.size() > 0 ? actualTrades.get(actualTrades.size() - 1).getTradeRecommendation() : Trade.HOLD;
					
					if (rec.getTradeRecommendation().equals(Trade.BUY) && !prevTrade.equals(Trade.BUY)){
						actualTrades.add(rec);
					}
					else if (rec.getTradeRecommendation().equals(Trade.SELL) && !prevTrade.equals(Trade.SELL)){
						actualTrades.add(rec);
					}
					
				}
				
				float returns = 0;
				float SENTINAL = (float) -999.0;
				float previousBuy = SENTINAL;
				int cnt = 1;
				for(TradeRecommendation trade:actualTrades){
					float price = trade.getTradeRecommendation().equals(Trade.BUY) ? trade.getBuyRecommendation() : trade.getSellRecommendation();
					
					if (trade.getTradeRecommendation().equals(Trade.BUY) && previousBuy == SENTINAL){
						previousBuy = trade.getBuyRecommendation();
					} else if (trade.getTradeRecommendation().equals(Trade.SELL) && previousBuy != SENTINAL){
						float percentGain = (trade.getSellRecommendation() - previousBuy ) / previousBuy;
						float currentReturn = percentGain * investmentAmount;
						returns += currentReturn;
						
						if(displayDetail)
							System.out.println("Trade " + cnt + ": Return : $" + currentReturn );
						
						previousBuy = SENTINAL;
						cnt++;
					}

				}
					
				actualTrades.clear();
				// System.out.print("\n\n\n\n\n");
				System.out.print(": " + returns + "\n");
				
			}
			
		} catch (MalformedURLException e){
			System.out.println("Error, Malformed URL");
		} catch (IOException e){
			System.out.println("Error, IO Exception");
		}
		
	}
}
