import java.util.ArrayList;


public interface TradeAlgorithm {
	
	void processStatistics();
	double getBuyRecommendation();
	double getSellRecommendation();
	Trade getTradeRecommendation();

}
