import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class DataRetriever {

	ArrayList<String> sym;
	ArrayList<TradeSession> tdSessions;
	private String day,month,year,url;
	String symbol;
	
	DataRetriever(String symbol){
		day = "01";
		month = "01";
		year = "2020";
		url = "http://real-chart.finance.yahoo.com/table.csv?s=[SYMBOL]&d="+month+"&e="+day+"&f="+year+"&g=d&a=02&b=01&c=2012&ignore=.csv";
		this.symbol = symbol;
	}
	
	public ArrayList<TradeSession> getTradingSession(){
		return tdSessions;
	}
	
	
	public void processData() throws MalformedURLException, IOException{
		
		InputStream input = new URL(url.replace("[SYMBOL]", symbol)).openStream();
		
		tdSessions = new ArrayList<TradeSession>();
		

		final char[] buffer = new char[10];
		final StringBuilder out = new StringBuilder();
		
		try (Reader in = new InputStreamReader(input, "UTF-8")) {
			for (;;) {
				int rsz = in.read(buffer, 0, buffer.length);
				if (rsz < 0)
					break;
				out.append(buffer, 0, rsz);
			}

			Scanner scn = new Scanner(out.toString());
			scn.useDelimiter(",|\n");
		    
			// Clear the header
			for (int i = 0; i <= 6; i++)
				scn.next();
			
			//Store the Data
		    while (scn.hasNext()){
		    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		    	Date date = df.parse(scn.next()); // new Date(scn.next());
		    	float open = scn.nextFloat();
		    	float high = scn.nextFloat();
		    	float low = scn.nextFloat();
		    	float close = scn.nextFloat();
		    	int volume = scn.nextInt();
		    	float adjClose = scn.nextFloat();
		    	
		    	TradeSession td = new TradeSession(date, open, high, low, close, volume, adjClose);
		    	tdSessions.add(td);
		    	
		    }

		    scn.close();
		}
		
		catch(Exception e){
			  e.setStackTrace(null);
		}
		
		input.close();

	}
	
	
	
}

