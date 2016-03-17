import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class dashboard_main {
	static final float stdDevInterval = (float) 1.5;
	static final float investmentAmount = 2000;
	static final int lag = 30;	
	
	
	public static void main(String [] args){
		
		try{
			final String div = " Processing:  ";
			final String col = "	";

			boolean showAll = true;
			String filename = "output/rec.xls";
			// final float stdDevInterval = (float) 1.5;

			HashMap<Stock,ArrayList<TradeSession>> mkt = new HashMap<Stock,ArrayList<TradeSession>>();
			DecimalFormat dFormat = new DecimalFormat( "#,###,###,##0.00" );
			
			// Initialize File Output
			File file = new File(filename);
			FileWriter fw = new FileWriter(file);
			fw.write("Date" + col + "Symbol" + col + "Trade Recommendation" + col + 
						"Current Price" + col + "Buy Price" + col + "Sell Price" + col
								+ "Theoretical Return" + col + "Profit Potential ($"+ "2k" + ")" + col 
								+ "Distance From Buy" + "\n");
			
			
			System.out.println("Starting Data Pull");
			System.out.println("Investment Amount " + investmentAmount);
			
			System.out.println("STD: " + stdDevInterval);
			System.out.println("Lag: " + lag);
			System.out.println("\nPROCESSING");
			
			final Set<DataRetriever> datasets = getDataRetrievers();
			datasets.parallelStream().forEach((v) -> {
				try { v.processData(); } 
				catch (Exception e) { e.printStackTrace(); }
		    });
			
			
			final Set<TradeRecommendation> tdRecSet = getTradeRecommendations(datasets);
			tdRecSet.parallelStream().forEach((v) -> {
				v.processStatistics();
		    });
			
			// Generate output per Stock
			for (TradeRecommendation rec : tdRecSet) {

				
				/* 
				 * Write output to file: trade_recommendations
				 */
				String currentDate = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime());
				fw.append(currentDate + col);
				fw.append(rec.stock + col);
				fw.append(rec.getTradeRecommendation().toString() + col);
				fw.append(dFormat.format(rec.getCurrentPrice())  + col);
				fw.append(dFormat.format(rec.getBuyRecommendation()) + col);
				fw.append(dFormat.format(rec.getSellRecommendation()) + col);
				fw.append(dFormat.format(rec.getTheoreticalReturn()) + "%" + col);
				fw.append(dFormat.format(rec.getProfitPotential(investmentAmount)) + col);
				fw.append(dFormat.format( (rec.getCurrentPrice() - rec.getBuyRecommendation()) / rec.getBuyRecommendation() * 100.0 ) + "%" + col);

				// fw.append(dFormat.format(rec.getWilliamsR()) + col);
				fw.append("\n");
				
			}
			
			System.out.print( "\nDONE" );
			
			fw.close();
			
			
		} catch (MalformedURLException e){
			System.out.println("Error, Malformed URL");
		} catch (IOException e){
			System.out.println("Error, IO Exception");
		}
		
	}

	private static Set<TradeRecommendation> getTradeRecommendations(Set<DataRetriever> datasets) {
		Set<TradeRecommendation> recs = new HashSet<TradeRecommendation>();
		for(DataRetriever data : datasets){
			recs.add(new TradeRecommendation(data.symbol, data.getTradingSession(), lag, stdDevInterval));
		}
		return recs;
	}

	private static Set<DataRetriever> getDataRetrievers() {
		Set<DataRetriever> dataSets = new HashSet<DataRetriever>();
		for (Stock s : Stock.values()) {
			dataSets.add(new DataRetriever(s.toString()));
		}
		return dataSets;
	}
}
