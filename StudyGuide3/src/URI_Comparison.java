import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class URI_Comparison {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            
            int divider = line.indexOf(';');
            
            String uri1 = java.net.URLDecoder.decode(line.substring(0, divider).replaceAll("%(?![0-9a-fA-F]{2})", "%25"),"UTF-8").toLowerCase().trim();
            String uri2 = java.net.URLDecoder.decode(line.substring(divider + 1, line.length()).replaceAll("%(?![0-9a-fA-F]{2})", "%25"),"UTF-8").toLowerCase().trim();
            
            if(!uri1.contains(".com:80/"))
            	uri1 = uri1.replace(".com/", ".com:80/");
            
            if(!uri2.contains(".com:80/"))
            	uri2 = uri2.replace(".com/", ".com:80/");
            
            System.out.println(uri1.equals(uri2) ? "True" : "False");
            
        }
    }
}
